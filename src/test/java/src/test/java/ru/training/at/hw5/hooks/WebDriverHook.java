package src.test.java.ru.training.at.hw5.hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import src.test.java.ru.training.at.hw5.context.TestContext;

import java.util.concurrent.TimeUnit;

public class WebDriverHook {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

        TestContext.getInstance().setTestObject(TestContext.WEB_DRIVER, this.webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
        TestContext.getInstance().cleanContext();
    }

}

