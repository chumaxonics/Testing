import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BuyBook {

    public String linkNavigation = "https://demoqa.com/books";
    String password = "Eqauser2!";
    String Username = "Eqauser2";
    Logger Logger= LogManager.getLogger();

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }



    @Test
    public void bookstoreTest() throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(linkNavigation);
        driver.switchTo().frame(1);
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginUsername =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"userName\"]")));
        WebElement loginPassword =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password\"]")));
        WebElement loginButton =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login\"]")));

        loginButton.click();
        loginUsername.sendKeys(Username);
        loginPassword.sendKeys(password);
        loginButton.click();
//*[@id="login"]
       // login("//*[@id=\"userName\"]","//*[@id=\"password\"]","//*[@id=\"login\"]");
        Thread.sleep(5000000);
    }

    public void login(String Xpathusername, String Xpathpassword,String XpathButton){
        WebDriver driver;
        driver = new ChromeDriver();
        WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(10));
            WebElement loginUsername =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpathusername)));
            WebElement loginPassword =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpathpassword)));
            WebElement loginButton =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathButton)));

            loginButton.click();
            loginUsername.sendKeys(Username);
            loginPassword.sendKeys(password);
            loginButton.click();


    }


}
