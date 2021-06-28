package src.test.java.ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import src.test.java.ru.training.at.hw5.context.TestContext;
import src.test.java.ru.training.at.hw5.page.HomePage;
import src.test.java.ru.training.at.hw5.page.LoginPage;


public class CommonSteps {
    private final WebDriver driver = TestContext.getInstance()
            .getTestObject(TestContext.WEB_DRIVER);

    @Given("I open JDI GitHub site")
    public void openHomePage() {
        new HomePage(driver).openHomePage();
    }

    @And("I login as user 'Roman Iovlev'")
    public void login() {
        new LoginPage(driver).login();
    }

    @And("I click on 'Service' button in Header")
    public void clickServiceButtonInHeader() {
        new HomePage(driver).openServiceMenu();
    }
}
