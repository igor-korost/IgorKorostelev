package src.test.java.ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.List;
import src.test.java.ru.training.at.hw2.BaseClass;

public class SoftAssertsTest extends BaseClass {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void exercise1() {

        // 1. Open test site by URL
        webDriver.navigate().to(baseUrl);

        // 2. Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(), "Home Page");

        // 3. Perform login
        WebElement loginIcon = webDriver.findElement(By.id("user-icon"));
        loginIcon.click();
        WebElement usernameInput = webDriver.findElement(By.id("name"));
        usernameInput.sendKeys("Roman");
        WebElement passwordInput = webDriver.findElement(By.id("password"));
        passwordInput.sendKeys("Jdi1234");
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();

        // 4. Assert Username is logged in
        String userName = webDriver.findElement(By.id("user-name")).getText();
        softAssert.assertEquals(userName, "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed
        // and they have proper texts
        String navString = ".uui-navigation.nav.navbar-nav.m-l8 > li";
        List<WebElement> navElements = webDriver.findElements(By.cssSelector(navString));
        List<String> navElementsStringList = new ArrayList<>();
        // Get text from nav WebElement, count elements, check isDisplayed()
        int navStringCount = 0;
        boolean isDisplayedNav = true;
        for (WebElement web : navElements) {
            // do not put empty Strings into List
            if (web.getText().length() > 0) {
                navElementsStringList.add(web.getText());
                navStringCount++;
            }
            if (!web.isDisplayed()) {
                isDisplayedNav = false;
            }
        }
        softAssert.assertTrue(navElementsStringList.contains("HOME"));
        softAssert.assertTrue(navElementsStringList.contains("CONTACT FORM"));
        softAssert.assertTrue(navElementsStringList.contains("SERVICE"));
        softAssert.assertTrue(navElementsStringList.contains("METALS & COLORS"));
        softAssert.assertEquals(navStringCount, 4);
        softAssert.assertTrue(isDisplayedNav);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        WebElement iconPractise = webDriver.findElement(By.cssSelector(".icon-practise"));
        WebElement iconCustom = webDriver.findElement(By.cssSelector(".icon-custom"));
        WebElement iconMulti = webDriver.findElement(By.cssSelector(".icon-multi"));
        WebElement iconBase = webDriver.findElement(By.cssSelector(".icon-base"));
        softAssert.assertTrue(iconPractise.isDisplayed());
        softAssert.assertTrue(iconCustom.isDisplayed());
        softAssert.assertTrue(iconMulti.isDisplayed());
        softAssert.assertTrue(iconBase.isDisplayed());

        //7. Assert that there are 4 texts on the Index Page under icons
        // and they have proper text

        String searchStringPractise = "//div[@class='benefit']"
                + "/span[contains(text(), 'To include')]";
        WebElement practiseIconText = webDriver.findElement(By.xpath(searchStringPractise));
        String textPractise = practiseIconText.getText();
        String targetTextPractise = "To include good practices\n"
                + "and ideas from successful\nEPAM project";
        softAssert.assertEquals(textPractise, targetTextPractise);

        String searchStringCustom = "//div[@class='benefit']"
                + "/span[contains(text(), 'To be flexible')]";
        WebElement customIconText = webDriver.findElement(By.xpath(searchStringCustom));
        String textCustom = customIconText.getText();
        String targetTextCustom = "To be flexible and\ncustomizable";
        softAssert.assertEquals(textCustom, targetTextCustom);

        String searchStringMulti = "//div[@class='benefit']"
                + "/span[contains(text(), 'To be multiplatform')]";
        WebElement multiIconText = webDriver.findElement(By.xpath(searchStringMulti));
        String textMulti = multiIconText.getText();
        String targetTextMulti = "To be multiplatform";
        softAssert.assertEquals(textMulti, targetTextMulti);

        String searchStringBase = "//div[@class='benefit']"
                + "/span[contains(text(), 'Already have')]";
        WebElement baseIconText = webDriver.findElement(By.xpath(searchStringBase));
        String textBase = baseIconText.getText();
        String targetTextBase = "Already have good base\n(about 20 internal and"
                + "\nsome external projects),\nwish to get more…";
        softAssert.assertEquals(textBase, targetTextBase);

        // 8. Assert that there is the iframe with “Frame Button” exist
        List<WebElement> frames = webDriver.findElements(By.id("frame"));
        softAssert.assertTrue(frames.size() > 0);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        WebElement frameButton = webDriver.findElement(By.id("frame-button"));

        // 10. Switch to original window back
        webDriver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed
        // and they have proper text
        String sideBarString = "#mCSB_1_container > ul > li";
        List<WebElement> sideBar = webDriver.findElements(By.cssSelector(sideBarString));
        List<String> sideBarStringList = new ArrayList<>();
        // Get text from sideBar WebElement, count elements, check isDisplayed()
        int sideBarCount = 0;
        boolean isDisplayedSideBar = true;
        for (WebElement web : sideBar) {
            // do not put empty Strings into List
            if (web.getText().length() > 0) {
                sideBarStringList.add(web.getText());
                sideBarCount++;
            }
            if (!web.isDisplayed()) {
                isDisplayedSideBar = false;
            }
        }
        softAssert.assertTrue(sideBarStringList.contains("Home"));
        softAssert.assertTrue(sideBarStringList.contains("Contact form"));
        softAssert.assertTrue(sideBarStringList.contains("Service"));
        softAssert.assertTrue(sideBarStringList.contains("Metals & Colors"));
        softAssert.assertTrue(sideBarStringList.contains("Elements packs"));
        softAssert.assertEquals(sideBarCount, 5);
        softAssert.assertTrue(isDisplayedSideBar);

        // 12. Close Browser
        webDriver.quit();
        // check if all softAssets passed
        softAssert.assertAll();
    }
}
