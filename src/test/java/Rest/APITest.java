package Rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;


public class APITest {
    @Test
    public void APITesting(){

      Response response= RestAssured.get("https://reqres.in/api/users?page=2");

      System.out.println("Response" + response.asString());
      System.out.println("Status Code" + response.getStatusCode());
      System.out.println("Body" + response.getBody().asString());
      System.out.println("Time taken " + response.getTime());
      System.out.println("Time taken " + response.getHeader("content-type"));


    }

}
