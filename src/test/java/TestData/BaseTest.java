package TestData;

import Pages.BasePage;
import Pages.HomePage;
import Pages.NavigationBar;
import Pages.SandboxPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends BasePage {
    protected NavigationBar navBar;
    protected HomePage homePage;
    protected SandboxPage sandboxPage;

    @BeforeSuite
    public void setup() {
        Assert.assertTrue(goToHomepage(), "An error occurred while navigating to the the homepage");

        navBar = new NavigationBar();
        homePage = new HomePage();
        sandboxPage = new SandboxPage();
    }

    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }
}
