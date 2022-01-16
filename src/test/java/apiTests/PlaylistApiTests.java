package apiTests;

import com.github.javafaker.Faker;
import helpers.Token;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.PlaylistRequest;
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

    @Test
    public void renamePlaylist(){

    }

}
