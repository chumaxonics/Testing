import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OnlineTest {
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }


    @Test
    public void CustomerTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        //driver.quit();
    }

}
