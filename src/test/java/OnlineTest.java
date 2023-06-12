import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OnlineTest {
    WebDriver driver;
    String username = "standard_user";
    String password = "secret_sauce";
    private String link = "https://www.saucedemo.com/";

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }


    @Test
    public void CustomerTest() throws InterruptedException, IOException {
        driver = new ChromeDriver();
        driver.get(link);
        login(driver, "standard_user", "secret_sauce");
        Thread.sleep(6000);
    }

    public void flow(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement singIn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

    }

    public void login(WebDriver driver, String username, String password) throws IOException, InterruptedException {
        WebElement loginUserName = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        WebElement loginInputPassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement singIn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"user-name\"]")));
        loginUserName.sendKeys(username);
        loginInputPassword.sendKeys(password);
        screenShot();
        loginButton.click();
        Thread.sleep(2000);
        screenShot();
    }
//*[@type='submit']/..
//*[@type='submit'][@class='buttonClass']

//*[contains(text(),'sign in')]

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void doubleClick(WebElement element){
        doubleClick(element);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void scroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50");

    }
    public void validateAlert(String text){
        Alert myAlert = driver.switchTo().alert();
        Assert.assertTrue(myAlert.getText().equals(text));
        myAlert.accept();
    }

    public void screenShot() throws IOException {
        String pattern = "dd-M-yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String currentDate = simpleDateFormat.format(new Date());
        String screenShotFilename= currentDate.toString().replace(" ","-").replace(":","-");
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot,new File(".//screenshots//"+screenShotFilename+"screen.png"));
    }

}
