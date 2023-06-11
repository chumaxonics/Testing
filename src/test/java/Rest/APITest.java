package Rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class APITest {
    @Test
    public void APITesting(){

      Response response= RestAssured.get("https://reqres.in/api/users?page=2");

      System.out.println("Response : " + response.asString());
      System.out.println("Status Code : " + response.getStatusCode());
      System.out.println("Body : " + response.getBody().asString());
      System.out.println("Time taken : " + response.getTime());
      System.out.println("Time taken : " + response.getHeader("content-type"));

      int statusCode =response.getStatusCode();
      Assert.assertEquals(statusCode,200);
    }

    @Test
    public  void statusTest(){
        given().
                get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200);
    }




}
