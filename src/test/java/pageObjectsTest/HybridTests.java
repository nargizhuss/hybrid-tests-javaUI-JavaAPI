package pageObjectsTest;

import com.github.javafaker.Faker;
import helpers.Token;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.PlaylistRequest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import static io.restassured.RestAssured.given;

public class HybridTests extends BaseTest {

    private Faker faker;
    private int playlistId;
    private String token;


    @BeforeMethod
    public void createPlaylist(){
        // initializing faker
        faker = new Faker();
        token = Token.get(username, password);
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
    public void hybrid_renamePlayList_playlistRenamed(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
        MainPage mainPage = loginPage.loginToApp(username, password);


        String newName = faker.ancient().god();
        mainPage.renamePlaylist(playlistId+"",newName);


        // Assert created playlist
        Assert.assertTrue(mainPage.playlistExist(playlistId+"",newName));

    }
}
