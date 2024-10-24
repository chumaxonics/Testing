package new_technologies;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
public class HttpRequest {
    int id;
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
    public void createUser() {
        HashMap data = new HashMap<>();
        data.put("name", "Brudances");
        data.put("Job", "Automation Engineer");
        RestAssured.baseURI ="https://reqres.in/api/users";
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post(RestAssured.baseURI)
                .then()
                .statusCode(201)
                .log().all();
    }
    @Test
    public  void restJsonPostTest(){
        RestAssured.baseURI = "https://reqres.in/api";
        HashMap requestBody = new HashMap<>();
        requestBody.put("name", "Joey");
        requestBody.put("Job", "Automation");
        // Send the POST request
        Response response = RestAssured.given()
                .contentType(ContentType.JSON) // Set content type
                .body(requestBody) // Set the request body
                .post("/users"); // Specify the endpoint
        // Print the response
        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }
    @Test
    public  void restJsonGetTest(){
        // Set the base URI
        RestAssured.baseURI = "https://reqres.in/api";
        // Send a GET request
        Response response = given()
                .when()
                .get("/users?page=2") // Endpoint for getting posts
                .then()
                .extract().response();
        // Print the response body
        System.out.println("Response Body: " + response.asString());
        // Search for a specific value in the response array
        String searchValue = "michael.lawson@reqres.in";
        boolean exists = searchValue.contains(response.jsonPath().getJsonObject("data[0].email"));
        String result= response.jsonPath().getJsonObject("data[0].email");
        if (exists) {
            System.out.println("The Value - -  - " + result + "-----");
        } else {
            System.out.println("The title does not exist in the response.");
        }
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
}