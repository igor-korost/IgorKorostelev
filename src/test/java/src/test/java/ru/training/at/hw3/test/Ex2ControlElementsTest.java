package src.test.java.ru.training.at.hw3.test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import src.test.java.ru.training.at.hw3.page.ControlElementsPage;
import src.test.java.ru.training.at.hw3.page.HomePage;
import src.test.java.ru.training.at.hw3.page.LoginPage;

import java.util.List;


public class Ex2ControlElementsTest extends BaseClass {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void exercise2() {

        LoginPage loginPage = new LoginPage(webDriver);
        HomePage homePage = new HomePage(webDriver);

        // 1. Open test site by URL
        homePage.openHomePage();

        // 2. Assert Browser title
        String expectedTitle = fileReader.getProperties("pageTitle");
        softAssert.assertEquals(webDriver.getTitle(), expectedTitle);

        // 3. Perform login
        String login = fileReader.getProperties("name");
        String password = fileReader.getProperties("password");
        loginPage.login(login, password);

        // 4. Assert Username is logged in
        String expectedUsername = fileReader.getProperties("loggedUser");
        softAssert.assertEquals(loginPage.getLoggedUser(), expectedUsername);

        // 5. Open through the header menu Service -> Different Elements Page
        ControlElementsPage controlElementsPage = new ControlElementsPage(webDriver);
        controlElementsPage.openDifferentElementsPage();

        // 6. Select checkboxes Water, Wind
        controlElementsPage.setWaterCheckbox();
        controlElementsPage.setWindCheckbox();

        // 7. Select radio Selen
        controlElementsPage.setSelenRadio();

        // 8. Select in dropdown Yellow
        controlElementsPage.setDropdownYellow();

        /* 9. Assert that
        • for each checkbox there is an individual log row and value
         is corresponded to the status of checkbox
        • for radio button there is a log row and value
        is corresponded to the status of radio button
        • for dropdown there is a log row and value is corresponded to the selected value. */

        List<String> logList = controlElementsPage.getLogList();

        softAssert.assertTrue(logList.get(0).contains(fileReader.getProperties("logYellow")));
        softAssert.assertTrue(logList.get(1).contains(fileReader.getProperties("logSelen")));
        softAssert.assertTrue(logList.get(2).contains(fileReader.getProperties("logWind")));
        softAssert.assertTrue(logList.get(3).contains(fileReader.getProperties("logWater")));

        // 10. Close Browser
        webDriver.quit();
        softAssert.assertAll();
    }
}
