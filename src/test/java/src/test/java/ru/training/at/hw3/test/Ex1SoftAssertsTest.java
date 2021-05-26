package src.test.java.ru.training.at.hw3.test;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import src.test.java.ru.training.at.hw3.page.FramePage;
import src.test.java.ru.training.at.hw3.page.HomePage;
import src.test.java.ru.training.at.hw3.page.LoginPage;

import java.util.Arrays;
import java.util.List;


public class Ex1SoftAssertsTest extends BaseClass {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void exercise1() {

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

        // 5. Assert that there are 4 items on the header section are displayed
        // and they have proper texts
        List<WebElement> headerItems = homePage.getHeaderItems();
        List<String> expectedHeaderItemText =
                Arrays.asList(fileReader.getProperties("HeaderItemText").split(", "));

        for (int i = 1; i < headerItems.size(); i++) {
            String headerItemText = headerItems.get(i).getText();
            softAssert.assertEquals(headerItemText, expectedHeaderItemText.get(i));
            softAssert.assertTrue(headerItems.get(i).isDisplayed());
        }
        softAssert.assertEquals(headerItems.size(), 4);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> indexIcons = homePage.getIndexIcons();
        for (WebElement web : indexIcons) {
            web.isDisplayed();
        }
        softAssert.assertEquals(indexIcons.size(), 4);

        //7. Assert that there are 4 texts on the Index Page under icons
        // and they have proper text
        FramePage framePage = new FramePage(webDriver);
        List<String> iconsText = homePage.getIconsText();
        softAssert.assertEquals(iconsText.get(0), fileReader.getProperties("practiseIconText"));
        softAssert.assertEquals(iconsText.get(1), fileReader.getProperties("customIconText"));
        softAssert.assertEquals(iconsText.get(2), fileReader.getProperties("multiIconText"));
        softAssert.assertEquals(iconsText.get(3), fileReader.getProperties("baseIconText"));

        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(framePage.isDisplayedFrame());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        framePage.gotoFrame();
        softAssert.assertTrue(framePage.isDisplayedFrameButton());

        // 10. Switch to original window back
        framePage.gotoHomePage();

        // 11. Assert that there are 5 items in the Left Section are displayed
        // and they have proper text
        List<WebElement> sideBarItems = homePage.getSideBarItems();
        List<String> expectedSideBarText =
                Arrays.asList(fileReader.getProperties("sideBarText").split(", "));

        for (int i = 0; i < sideBarItems.size(); i++) {
            String sideBarItemText = sideBarItems.get(i).getText();
            softAssert.assertEquals(sideBarItemText, expectedSideBarText.get(i));
            softAssert.assertTrue(sideBarItems.get(i).isDisplayed());
        }
        softAssert.assertEquals(sideBarItems.size(), 5);

        // 12. Close Browser
        webDriver.quit();
        softAssert.assertAll();
    }
}

