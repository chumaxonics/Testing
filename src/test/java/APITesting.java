import io.restassured.response.Response;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class APITesting {


   //


    @Test
    public void APITest() {

        given()
                .contentType("application/json")
                .when()
                .get("https://api.coindesk.com/v1/bpi/currentprice.json")
                .then()
                .log().all();

        //"rate": "25,467.2065",



    }
    @Test
    public void APITesRatet() {

        Response response =  given()
                .contentType("application/json")
                .when()
                .get("https://api.coindesk.com/v1/bpi/currentprice.json")
                .jsonPath().get();

        System.out.println(response.getBody().peek());



        //"rate": "25,467.2065",

    }
}
