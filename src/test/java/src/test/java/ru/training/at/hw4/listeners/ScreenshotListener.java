package src.test.java.ru.training.at.hw4.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import src.test.java.ru.training.at.hw4.test.BaseTest;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
        if (driver != null) {
            takeScreenshot(driver);
            System.out.println("Test failed. Screenshot taken.");
        } else {
            System.out.println("Driver not found");
        }
    }

    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}




