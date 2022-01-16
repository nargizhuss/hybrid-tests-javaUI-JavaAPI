package apiTests;

import helpers.Token;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.PlaylistResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePlaylist {

    @Test
    public void deleteAllCreatedPlaylists() throws InterruptedException {

        String token = Token.get("nargiz.rza@gmail.com", "te$t$tudent");
        // Function given returns a response
        Response response = given()
                .baseUri("https://bbb.testpro.io/")
                .basePath("api/playlist")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer "+ token)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();

        // extract json body (path) which would have a unique id
        JsonPath json = response.jsonPath();
        PlaylistResponse[] playlists = json.getObject("$", PlaylistResponse[].class);
        System.out.println(playlists.length);

        for (PlaylistResponse pl: playlists){
            given()
                    .baseUri("https://bbb.testpro.io/")
                    .basePath("api/playlist"+pl.getId())
                    .header("Authorization", "Bearer "+ token)
                    .when()
                    .delete();
            Thread.sleep(500);

        }
    }


}
