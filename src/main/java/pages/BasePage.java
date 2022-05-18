package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesReader;

import java.util.List;

import static utils.WebDriverSingleton.getDriver;

public abstract class BasePage {
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor jse;

    {
        wait = new WebDriverWait(getDriver(), PropertiesReader.getExplicityWaitValue());
        actions = new Actions(getDriver());
        jse = (JavascriptExecutor) getDriver();
    }

    public WebElement getElement(By locator) {
        return getDriver().findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return getDriver().findElements(locator);
    }

    public void moveToElement(By locator) {
        actions.moveToElement(getDriver().findElement(locator));
    }

    public void waitVisibilityIgnorExc(By locator) {
        wait.ignoring(NumberFormatException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilPageLoad() {
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public void clickWithJavaScript(By locator) {
        jse.executeScript("arguments[0].click()", getDriver().findElement(locator));
    }

}



