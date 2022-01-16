package apiTests;

import com.github.javafaker.Faker;
import helpers.Token;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.PlaylistRequest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PlaylistApiTests {
    private Faker faker;
    private int playlistId;
    private String token;

    @BeforeClass
    public void getToken(){
        token = Token.get("nargiz.rza@gmail.com", "te$t$tudent");
    }


    @BeforeMethod
    public void createPlaylist(){
        // initializing faker
        faker = new Faker();
        // Generate a random artist name
        PlaylistRequest playlistRequest = new PlaylistRequest(faker.artist().name());
        System.out.println(playlistRequest.getName());

        // Function given returns a response
        Response response = given()
                .baseUri("https://bbb.testpro.io/")
                .basePath("api/playlist")
                .header("Content-type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer "+ token)
                .body(playlistRequest)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();

        // extract json body (path) which would have a unique id
        JsonPath json = response.jsonPath();
        playlistId = json.getInt("id");
        System.out.println(playlistId);

    }

    @AfterMethod
    public void deletePlaylist(){

        given()
                .baseUri("https://bbb.testpro.io/")
                .basePath("api/playlist"+playlistId)
                .header("Content-type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer "+ token)
                .when()
                .delete();
    }

    @Test
    public void renamePlaylist(){

        PlaylistRequest newPlaylistRequest = new PlaylistRequest(faker.artist().name());
        System.out.println(newPlaylistRequest.getName());
        // Function given returns a response
        Response response = given()
                .baseUri("https://bbb.testpro.io/")
                .basePath("api/playlist/" +playlistId)
                .header("Content-type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer "+ token)
                .body(newPlaylistRequest)
                .when()
                .patch()
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        String newName = json.getString("name");
        Assert.assertEquals(newName,newPlaylistRequest.getName());


    }

}
