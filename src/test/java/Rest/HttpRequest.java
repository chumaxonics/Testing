package Rest;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;


public class HttpRequest {
    int id;

    @Test(priority = 1)
    public void HttpRequestGetUsersTest() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .log().all();
    }

    //    @Test
    public void createUser() {
        HashMap data = new HashMap<>();
        data.put("name", "Nyiko");
        data.put("Job", "Automation Engineer");

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .log().all();
    }


    @Test(priority = 2, dependsOnMethods = {"HttpRequestGetUsersTest"})
    public void createUserAndGetResponseIdTest() {
        HashMap data = new HashMap<>();
        data.put("name", "Nyiko");
        data.put("Job", "Automation Engineer");

        id = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
    }

    @Test(priority = 3, dependsOnMethods = {"createUserAndGetResponseIdTest"})
    public void updateUser() {
        HashMap data = new HashMap<>();
        data.put("name", "Johan");
        data.put("Job", "Test Engineer");
        given()
                .contentType("application/json")
                .body(data)
                .when()
                .put("https://reqres.in/api/users/" + id)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 4, dependsOnMethods = {"updateUser"})
    public void deleteUser() {
        given()
                .when()
                .delete("https://reqres.in/api/users/" + id)
                .then()
                .statusCode(204)
                .log().all();
    }

    //given

    /*
    Sending an API request, we need something before sending. . .
    Set cookies
    parameters
    set headers
     */

    //when
       /*
   request type, get, post, put, delete
     */

    //then

   /*
   Validations, response from request
     */
}
