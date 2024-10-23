package research_new_topics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Website {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    public String linkNavigation = "https://demoqa.com/books";
    String password = "Eqauser2!";
    String Username = "Eqauser2";

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void bookstoreTestTwo() throws InterruptedException {
        driver.get("https://demoqa.com/books");
      //  driver.switchTo().frame(3);
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton =wait.until(ExpectedConditions.presenceOfElementLocated(By.id(("login"))));
        loginButton.click();

        WebElement loginUsername =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"userName\"]")));
        WebElement loginPassword =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password\"]")));

        loginPassword.sendKeys(password);
        loginUsername.sendKeys(Username);
        WebElement loginButton_ =wait.until(ExpectedConditions.presenceOfElementLocated(By.id(("login"))));
        loginButton_.click();
//Can be avoided

        //search for book
        search();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        System.out.println("---we are here --");

        clickBook();

        System.out.println( "  ISBN :" + getInformation());
        if(getInformation().trim().equals("9781491950296") ){
            System.out.println("Passed");
        }else {
            System.out.println("failed");
        }

    }
    public void search() {
        WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement search =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"searchBox\"]")));
        search.sendKeys("Programming JavaScript Applications");

    }
    public void  login( ){
        driver.switchTo().frame(1);
        WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement loginButtonSecond =wait.until(ExpectedConditions.presenceOfElementLocated((By.id("login"))));
        loginButtonSecond.click();
    }
    public  void  clickBook() throws InterruptedException {
        WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement search =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Programming JavaScript')]")));
        search.click();
    }


    public String  getInformation(){

        WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement search =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]")));
       return search.getText();
    }

    public void login(String Xpathusername, String Xpathpassword, String XpathButton){
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