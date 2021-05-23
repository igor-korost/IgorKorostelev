package src.test.java.ru.training.at.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BaseClass {
    public WebDriver webDriver;
    public String baseUrl = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeMethod
    public void beforeMethod() {

        // Use WebDriverManager to manage browser driver
        WebDriverManager.chromedriver().setup();
        // Create new instance of WebDriver
        webDriver = new ChromeDriver();
        // implicit waits
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Start browser maximized
        webDriver.manage().window().maximize();
    }
}
