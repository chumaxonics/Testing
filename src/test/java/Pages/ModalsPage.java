package Pages;
import org.openqa.selenium.By;
public class ModalsPage extends BasePage {
    private By formModal = By.id("formModal");
    private By modalName = By.id("g1051-name");
    private By modalEmail = By.id("g1051-email");
    private By modalMsg = By.id("contact-form-comment-g1051-message");
    private By modalSubmitBtn = By.cssSelector("div[class='pum-content popmake-content'] button[type='submit']");

    public ModalsPage openModal() {
        click(formModal);
        return this;
    }
    public ModalsPage modalSendMessage(String name, String email, String message) {
        setText(modalName, name);
        setText(modalEmail, email);
        setText(modalMsg, message);
        click(modalSubmitBtn);
        return this;
    }
}
