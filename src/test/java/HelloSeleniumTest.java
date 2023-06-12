import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class HelloSeleniumTest {
    @Test
    public void firstTest()
    {
        //Telling the system where to find chromedriver on Mac.
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        //Here's how to do it on Windows
        System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");
        //Use WebDriverManager Maven package to download the correct version of
        //a driver to automate Chrome browser
        WebDriverManager.chromedriver().setup();
        //Set variable driver to an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        //Open the URL
        driver.get("https://www.saucedemo.com/");
        //Assert that the title of the page = Swag Labs
        assertEquals("Swag Labs", driver.getTitle());
        //Quit the browser
        driver.quit();
    }
}
