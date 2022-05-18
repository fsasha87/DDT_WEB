package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.WebDriverSingleton.getDriver;

public class MainPage extends BasePage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(MainPage.class));

    {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "input[name='search']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@name='search']/../../following-sibling::button")
    private WebElement searchFieldButton;

    public MainPage typeSearchField(String commodity) {
        searchField.sendKeys(commodity);
        LOG.info(String.format("Search field is filled by %s", commodity));
        return this;
    }

    public SearchResultsPage clickSearchField() {
        searchFieldButton.click();
        LOG.info("Search button is clicked");
        return new SearchResultsPage();
    }
}
