package helpers;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Credentials;

import static io.restassured.RestAssured.given;

public class Token {
    public static String get(String email, String password) {
        Credentials credentials = new Credentials(email, password);
// Function given returns a response
        Response response = given()
                .baseUri("https://bbb.testpro.io/")
                .basePath("api/me")
                .header("Content-type", "application/json")
                .header("Accept", "application/json")
                .body(credentials)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getString("token");

    }
}
