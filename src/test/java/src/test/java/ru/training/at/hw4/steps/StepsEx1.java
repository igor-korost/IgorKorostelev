package src.test.java.ru.training.at.hw4.steps;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import src.test.java.ru.training.at.hw4.page.FramePage;
import src.test.java.ru.training.at.hw4.page.HomePage;
import src.test.java.ru.training.at.hw4.page.LoginPage;
import src.test.java.ru.training.at.hw4.util.DriverManager;
import src.test.java.ru.training.at.hw4.util.PropertiesFileReader;

import java.util.Arrays;
import java.util.List;


public class StepsEx1 {
    WebDriver webDriver = DriverManager.driver;
    PropertiesFileReader fileReader = new PropertiesFileReader();
    SoftAssert softAssert = new SoftAssert();

    LoginPage loginPage;
    HomePage homePage;
    FramePage framePage;

    public StepsEx1(WebDriver webDriver) {
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        framePage = new FramePage(webDriver);
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
        String expectedUsername = fileReader.getProperties("loggedUser");
        softAssert.assertEquals(loginPage.getLoggedUser(), expectedUsername);
    }

    @Step("5. Assert that there are 4 items on the header section are displayed"
            + "and they have proper texts")
    public void assertFourItems(WebDriver webDriver) {
        List<WebElement> headerItems = homePage.getHeaderItems();
        List<String> expectedHeaderItemText =
                Arrays.asList(fileReader.getProperties("HeaderItemText").split(", "));

        for (int i = 1; i < headerItems.size(); i++) {
            String headerItemText = headerItems.get(i).getText();
            softAssert.assertEquals(headerItemText, expectedHeaderItemText.get(i));
            softAssert.assertTrue(headerItems.get(i).isDisplayed());
        }
        softAssert.assertEquals(headerItems.size(), 4);
    }

    @Step("6. Assert that there are 4 images on the Index Page and they are displayed")
    public void assertFourImages(WebDriver webDriver) {
        String expectedUsername = fileReader.getProperties("loggedUser");
        softAssert.assertEquals(loginPage.getLoggedUser(), expectedUsername);
    }

    @Step("7. Assert that there are 4 texts on the Index Page")
    public void assertFourTexts(WebDriver webDriver) {
        List<String> iconsText = homePage.getIconsText();
        softAssert.assertEquals(iconsText.get(0), fileReader.getProperties("practiseIconText"));
        softAssert.assertEquals(iconsText.get(1), fileReader.getProperties("customIconText"));
        softAssert.assertEquals(iconsText.get(2), fileReader.getProperties("multiIconText"));
        softAssert.assertEquals(iconsText.get(3), fileReader.getProperties("baseIconText"));
    }

    @Step("8. Assert that there is the iframe with “Frame Button” exist")
    public void assertFrameButton(WebDriver webDriver) {
        softAssert.assertTrue(framePage.isDisplayedFrame());
    }

    @Step("9. Switch to the iframe and check that there is “Frame Button” in the iframe")
    public void gotoFrame(WebDriver webDriver) {
        softAssert.assertTrue(framePage.isDisplayedFrame());
    }

    @Step("10. Switch to original window back")
    public void gotoHomePage(WebDriver webDriver) {
        framePage.gotoHomePage();
    }

    @Step("11. Assert that there are 5 items in the Left Section are displayed"
            + "and they have proper text")
    public void assertFiveItems(WebDriver webDriver) {
        List<WebElement> sideBarItems = homePage.getSideBarItems();
        List<String> expectedSideBarText =
                Arrays.asList(fileReader.getProperties("sideBarText").split(", "));

        for (int i = 0; i < sideBarItems.size(); i++) {
            String sideBarItemText = sideBarItems.get(i).getText();
            softAssert.assertEquals(sideBarItemText, expectedSideBarText.get(i));
            softAssert.assertTrue(sideBarItems.get(i).isDisplayed());
        }
        softAssert.assertEquals(sideBarItems.size(), 5);
    }

    @Step("12. Close Browser")
    public void closeBrowser(WebDriver webDriver) {
        webDriver.quit();
    }

    @Step("Failed method")
    public void failedMethod() {
        Assert.fail();
    }
}


