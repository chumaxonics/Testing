package new_technologies;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Requests {
    @Test
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

    @Test
    public void GetBooksDetails() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "");
        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
        System.out.println("Value is : " + response.jsonPath().getJsonObject("books[0].title"));
    }


}
