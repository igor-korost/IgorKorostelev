package src.test.java.ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import src.test.java.ru.training.at.hw4.page.ControlElementsPage;
import src.test.java.ru.training.at.hw4.page.HomePage;
import src.test.java.ru.training.at.hw4.page.LoginPage;
import src.test.java.ru.training.at.hw4.util.DriverManager;
import src.test.java.ru.training.at.hw4.util.PropertiesFileReader;

import java.util.List;

public class StepsEx2 {
    WebDriver webDriver = DriverManager.driver;
    PropertiesFileReader fileReader = new PropertiesFileReader();
    SoftAssert softAssert = new SoftAssert();

    LoginPage loginPage;
    HomePage homePage;
    ControlElementsPage controlElementsPage;

    public StepsEx2(WebDriver webDriver) {
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        controlElementsPage = new ControlElementsPage(webDriver);
    }

    @Step("1. Open test site by URL")
    public void openSiteByUrl(WebDriver webDriver) {
        homePage.openHomePage();
    }

    @Step("2. Assert Browser title")
    public void assertTitle(WebDriver webDriver) {
        String expectedTitle = fileReader.getProperties("pageTitle");
        softAssert.assertEquals(webDriver.getTitle(), expectedTitle);
    }

    @Step("3. Perform login")
    public void performLogin(WebDriver webDriver) {
        String login = fileReader.getProperties("name");
        String password = fileReader.getProperties("password");
        loginPage.login(login, password);
    }

    @Step("4. Assert Username is logged in")
    public void assertUsername(WebDriver webDriver) {
        String login = fileReader.getProperties("name");
        String password = fileReader.getProperties("password");
        String expectedUsername = fileReader.getProperties("loggedUser");
        softAssert.assertEquals(loginPage.getLoggedUser(), expectedUsername);
    }

    @Step("5. Open through the header menu Service -> Different Elements Page")
    public void openServiceMenu(WebDriver webDriver) {
        ControlElementsPage controlElementsPage = new ControlElementsPage(webDriver);
        controlElementsPage.openDifferentElementsPage();
    }

    @Step("6. Select checkboxes Water, Wind")
    public void selectWaterWindCheckboxes(WebDriver webDriver) {
        controlElementsPage.setWaterCheckbox();
        controlElementsPage.setWindCheckbox();
    }

    @Step("7. Select radio Selen")
    public void selectSelenRadioButton(WebDriver webDriver) {
        controlElementsPage.setSelenRadio();
    }

    @Step("7. Select in dropdown Yellow")
    public void selectYellowDropdown(WebDriver webDriver) {
        controlElementsPage.setDropdownYellow();
    }

    @Step("9. AssertLogs")
    public void assertLogs(WebDriver webDriver) {
        List<String> logList = controlElementsPage.getLogList();

        softAssert.assertTrue(logList.get(0).contains(fileReader.getProperties("logYellow")));
        softAssert.assertTrue(logList.get(1).contains(fileReader.getProperties("logSelen")));
        softAssert.assertTrue(logList.get(2).contains(fileReader.getProperties("logWind")));
        softAssert.assertTrue(logList.get(3).contains(fileReader.getProperties("logWater")));

    }

    @Step("10. Close Browser")
    public void closeBrowser(WebDriver webDriver) {
        webDriver.quit();
    }
}
