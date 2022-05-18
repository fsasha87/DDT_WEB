package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;


public class SearchResultsPage extends BasePage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(SearchResultsPage.class));

    By brandField = By.xpath("(//input[@name='searchline'])[1]");
    By sortButton = By.cssSelector("select");
    By selectOption = By.cssSelector("option[value='5: action']");
    By firstElementBucket = By.xpath("(//div[@class='goods-tile__prices']//button)[1]");
    String brandCheckbox = "//a[@data-id='%s']";

    public SearchResultsPage enterBrandFieldAndClickCheckbox(String brand) {
        waitUntilPageLoad();
        for (int i = 0; i < 2; i++) {
            try {
                getElement(brandField).sendKeys(brand + Keys.RETURN);
                LOG.info(String.format("Brand '%s' was selected.", brand));
                break;
            } catch (StaleElementReferenceException e){e.printStackTrace();}
        }
        WebElement brandCheckBox = getElement(By.xpath(String.format(brandCheckbox, brand)));
        String str = brandCheckBox.getAttribute("href");
        String[] strings = str.split("=");
        LOG.info(String.format("Checkbox '%s' was selected.", strings[strings.length - 1]));
        return this;
    }

    public SearchResultsPage selectSortOption() {
        moveToElement(sortButton);
        clickWithJavaScript(sortButton);
        clickWithJavaScript(selectOption);
        LOG.info("Sort option was selected.");
        return this;
    }

    public SearchResultsPage clickFirstElementButton() {
        getElement(firstElementBucket).click();
        LOG.info("First element's bucket is clicked.");
        return this;
    }

}
