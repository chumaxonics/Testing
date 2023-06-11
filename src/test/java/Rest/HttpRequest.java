package Rest;

import com.google.common.base.Predicates;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;


public class HttpRequest {
WebDriver driver;


    @Test
    public void HttpRequestGetUsersTest() {
          given()
                .when()

                .get("https://reqres.in/api/users?page=2")


                .then()
                .statusCode(200)
                .log().all();
    }


    @Test
    public void createUser(){
        HashMap  data = new HashMap<>();
        data.put("name","Nyiko");
        data.put("Job","Automation Engineer");

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
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
