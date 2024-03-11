import io.restassured.response.Response;
import org.junit.Test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class APITesting {

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
    @Test
    public void Test() {
        getDecoder_();
    }
    public void  getDecoder_(){
        File file = new File("./test.pdf");
        try ( FileOutputStream fos = new FileOutputStream(file); ) {
            String b64 = readFileAsString("./testData.txt");
            byte[] decoder = Base64.getDecoder().decode(b64);
            fos.write(decoder);
            System.out.println("PDF File Saved");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readFile(String filePath) throws IOException {
        /*
        C:\Users\pankaj\Desktop\test.java
         */
        String content = null;
        FileReader reader = null;
        try {
            reader = new FileReader(filePath);
            char[] chars = new char[(int) filePath.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                reader.close();
            }
        }
        return content;
    }
//Java 11
    public static String readFileAsString(String fileName)
            throws Exception
    {
        String data = "";
        data = new String(
                Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

}
