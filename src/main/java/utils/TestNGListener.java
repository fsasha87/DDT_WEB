package utils;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNGListener implements ITestListener {
    private static final Logger LOG = Logger.getLogger(String.valueOf(TestNGListener.class));

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshotPNG(WebDriverSingleton.getDriver());
        String textLog = saveTextLog(getTestMethodName(iTestResult)+" failed and screenshot is taken");
        LOG.info(textLog);
    }

    @Override
    public void onStart(ITestContext testContext) {
        LOG.info(String.format("Test Case started: %s", testContext.getName()));
    }

    @Override
    public void onFinish(ITestContext testContext) {
        LOG.info(String.format("Test Case ended: %s", testContext.getName()));
    }

    @Attachment(value = "Page_screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog (String message){
        return message;
    }

    private static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

}
