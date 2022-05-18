package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class BucketPage extends BasePage {

    private static final Logger LOG = Logger.getLogger(String.valueOf(BucketPage.class));

    By mainBucket = By.xpath("//li[contains(@class, 'header-actions__item--cart')]//button");
    By priceAmount = By.cssSelector("div.cart-receipt__sum-price span:nth-child(1)");

    public BucketPage openBucket() {
        getElement(mainBucket).click();
        LOG.info("Bucket window is opened.");
        return this;
    }

    public int getPriceOfGood() {
        waitVisibilityIgnorExc(priceAmount);
        String s = getElement(priceAmount).getText();
        int price = Integer.parseInt(s);
        return price;
    }

}
