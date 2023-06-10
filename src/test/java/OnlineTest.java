import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OnlineTest {

    String username ="standard_user";
    String password ="secret_sauce";
    private String link ="https://www.saucedemo.com/";
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }


    @Test
    public void CustomerTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(link);
        login(driver,"standard_user","secret_sauce");
        Thread.sleep(6000);
        //driver.quit();
    }

    public void flow(WebDriver driver){
        WebDriverWait wait= new WebDriverWait(driver,10);
        WebElement singIn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

    }

    public void login(WebDriver driver,String username, String password){
       WebElement loginUserName = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
       WebElement loginInputPassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
       WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        WebDriverWait wait= new WebDriverWait(driver,10);
        WebElement singIn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"user-name\"]")));
       loginUserName.sendKeys(username);
       loginInputPassword.sendKeys(password);
        loginButton.click();

    }

}
