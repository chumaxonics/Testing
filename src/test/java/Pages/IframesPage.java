package Pages;
import org.openqa.selenium.By;
public class IframesPage extends BasePage {
    private By searchBox = By.name("search");
    private By magnifyingGlass = By.xpath("//*[@id=\"search-form\"]/fieldset/button/i");
    private By pageHeading = By.cssSelector(".entry-title");

    public IframesPage wikiSearch(String searchQuery) {
        setText(searchBox, "test automation");
        click(magnifyingGlass);
        return this;
    }

    public String getPageHeading() {
        return getText(pageHeading);
    }
}