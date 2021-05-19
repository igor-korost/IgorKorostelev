package src.test.java.ru.training.at.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import src.test.java.ru.training.at.hw2.BaseClass;

public class ControlElementsTest extends BaseClass {
    // Create new instance of WebDriver
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void exercise2() {

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

        // 5. Open through the header menu Service -> Different Elements Page
        String serviceMenuLocator = "ul.uui-navigation.nav.navbar-nav.m-l8 a.dropdown-toggle";
        WebElement serviceMenu = webDriver.findElement(By.cssSelector(serviceMenuLocator));
        serviceMenu.click();
        String differentElementsLocator = "//nav/ul[@class='uui-navigation nav navbar-nav m-l8']"
                + "/descendant::a[contains(text(), 'Different elements')]";
        WebElement differentElements = webDriver.findElement(By.xpath(differentElementsLocator));
        differentElements.click();

        // 6. Select checkboxes Water, Wind
        WebElement waterCheckbox = webDriver.findElement(
                By.cssSelector(".label-checkbox:nth-child(1)"));
        waterCheckbox.click();
        WebElement windCheckbox = webDriver.findElement(
                By.cssSelector(".label-checkbox:nth-child(3)"));
        windCheckbox.click();

        // 7. Select radio Selen
        WebElement selenRadio = webDriver.findElement(
                By.cssSelector(".label-radio:nth-child(4)"));
        selenRadio.click();

        // 8. Select in dropdown Yellow
        Select  dropdown = new Select(webDriver.findElement(
                By.cssSelector("select.uui-form-element")));
        dropdown.selectByVisibleText("Yellow");

        /* 9. Assert that
        • for each checkbox there is an individual log row and value
         is corresponded to the status of checkbox
        • for radio button there is a log row and value
        is corresponded to the status of radio button
        • for dropdown there is a log row and value is corresponded to the selected value. */

        WebElement logColors = webDriver.findElement(
                By.cssSelector("ul.panel-body-list.logs > li:nth-child(1)"));
        WebElement logMetal = webDriver.findElement(
                By.cssSelector("ul.panel-body-list.logs > li:nth-child(2)"));
        WebElement logWind = webDriver.findElement(
                By.cssSelector("ul.panel-body-list.logs > li:nth-child(3)"));
        WebElement logWater = webDriver.findElement(
                By.cssSelector("ul.panel-body-list.logs > li:nth-child(4)"));

        softAssert.assertTrue(logColors.getText().contains("Colors: value changed to Yellow"));
        softAssert.assertTrue(logMetal.getText().contains("metal: value changed to Selen"));
        softAssert.assertTrue(logWind.getText().contains("Wind: condition changed to true"));
        softAssert.assertTrue(logWater.getText().contains("Water: condition changed to true"));

        // 10. Close Browser
        webDriver.quit();
        // check if all softAssets passed
        softAssert.assertAll();
    }
}
