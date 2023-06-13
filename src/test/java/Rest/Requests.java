package Rest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Requests {

    /*
    How many ways to create a Request body
    - hashMap
    - Using org.json
    - using POJO (plain Old Java Object
    - Using external Json file
     */
    @Test(priority = 1)
    public void createUserAndGetResponseIdTest() {
        HashMap data = new HashMap<>();
        data.put("name", "Nyiko");
        data.put("Job", "Automation Engineer");

      Response response= given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
                .then()
              .statusCode(200)
              .log().body()
              .extract().response();

      String jsonSting = response.asString();
        Assert.assertEquals(jsonSting.contains("Ned-bank Happened"),true);
    }

}
