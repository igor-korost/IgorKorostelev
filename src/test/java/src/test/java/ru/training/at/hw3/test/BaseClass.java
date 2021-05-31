package src.test.java.ru.training.at.hw3.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import src.test.java.ru.training.at.hw3.util.DriverManager;
import src.test.java.ru.training.at.hw3.util.PropertiesFileReader;

public abstract class BaseClass {

    WebDriver webDriver;
    PropertiesFileReader fileReader;

    @BeforeMethod
    public void setupDriver() {
        DriverManager driverManager = new DriverManager();
        webDriver = driverManager.driverSetup();
        fileReader = new PropertiesFileReader();
    }

}
