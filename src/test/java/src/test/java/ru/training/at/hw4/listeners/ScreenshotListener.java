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

        try {
            //WebDriver driver = DriverManager.driver;
            WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
            takeScreenshot(driver);
            System.out.println("Test failed. Screenshot taken.");
        } catch (NullPointerException e) {
            System.out.println("Driver not found");
        }
    }

    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}




