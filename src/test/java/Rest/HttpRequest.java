package Rest;

import org.testng.annotations.Test;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;


public class HttpRequest {
int id;


     @Test(priority=1)
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


    @Test(priority=2)
    public void createUserAndGetResponseIdTest(){
        HashMap  data = new HashMap<>();
        data.put("name","Nyiko");
        data.put("Job","Automation Engineer");

      id=given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
    }
    @Test(priority=3)
    public  void  updateUser(){

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
