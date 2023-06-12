package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class NavigationBar extends BasePage {
    private By sandbox = By.cssSelector("span[data-hover='Sandbox']");
    private By vlog = By.xpath("//a[text()='Vlog']");
    private By webdriverIntro = By.xpath("//a[text()='Intro to Selenium WebDriver']");
    private By acceptCookiesBtn = By.id("cookie_action_close_header");

    public SandboxPage selectSandbox() {
        click(sandbox);
        return new SandboxPage();
    }

    public void selectIntroToSeleniumWebDriver() {
        hoverOverElement(vlog);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(webdriverIntro)).click();
    }

    public NavigationBar acceptCookies() {
        click(acceptCookiesBtn);
        return this;
    }
}
