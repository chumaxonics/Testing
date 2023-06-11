package Rest;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class HttpRequest {
WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        
    }

    @BeforeEach
    void setUp() {
        
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void HttpRequestTest() {

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
