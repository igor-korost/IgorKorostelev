package src.test.java.ru.training.at.hw4.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import src.test.java.ru.training.at.hw4.util.DriverManager;
import src.test.java.ru.training.at.hw4.util.PropertiesFileReader;

public class BaseTest {

    WebDriver webDriver;
    PropertiesFileReader fileReader;

    public WebDriver getDriver() {
        return webDriver;
    }

    @BeforeMethod
    public void setupDriver() {
        webDriver = DriverManager.driverSetup();
        fileReader = new PropertiesFileReader();
    }
}
