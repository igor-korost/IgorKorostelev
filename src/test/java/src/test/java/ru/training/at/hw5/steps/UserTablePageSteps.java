package src.test.java.ru.training.at.hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import src.test.java.ru.training.at.hw5.context.TestContext;
import src.test.java.ru.training.at.hw5.page.HomePage;
import src.test.java.ru.training.at.hw5.page.UserTablePage;
import src.test.java.ru.training.at.hw5.util.PropertiesFileReader;

import java.util.List;
import java.util.Map;

public class UserTablePageSteps {
    private final WebDriver driver = TestContext.getInstance()
            .getTestObject(TestContext.WEB_DRIVER);

    PropertiesFileReader fileReader = new PropertiesFileReader();

    @When("I click on 'User Table' button in Service dropdown")
    public void clickUserTableButton() {
        new HomePage(driver).openUserTableMenu();
    }

    @Then("'User Table' page should be opened")
    public void assertUserTablePage() {
        String expectedTitle = fileReader.getValue("userPageTitle");
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @And("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertDropdowns() {
        UserTablePage userTablePage = new UserTablePage(driver);
        List<WebElement> tableDropdownList = userTablePage.getDropdownList();
        int number = tableDropdownList.size();
        int expectedNo = Integer.parseInt(fileReader.getValue("dropdownsNo"));
        Assert.assertEquals(number, expectedNo);
        boolean isDisplayed = userTablePage.isDisplayed(tableDropdownList);
        Assert.assertTrue(isDisplayed);
    }

    @And("6 Usernames should be displayed on Users Table on User Table Page")
    public void assertUsernames() {
        UserTablePage userTablePage = new UserTablePage(driver);
        List<WebElement> usernames = userTablePage.getUsernameList();
        int number = usernames.size();
        int expectedNo = Integer.parseInt(fileReader.getValue("usernamesNo"));
        Assert.assertEquals(number, expectedNo);
        boolean isDisplayed = userTablePage.isDisplayed(usernames);
        Assert.assertTrue(isDisplayed);
    }

    @And("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void assertTextsUnderImage() {
        UserTablePage userTablePage = new UserTablePage(driver);
        List<WebElement> textList = userTablePage.getUserDescrList();
        int number = textList.size();
        int expectedNo = Integer.parseInt(fileReader.getValue("textsUnderImageNo"));
        Assert.assertEquals(number, expectedNo);
        boolean isDisplayed = userTablePage.isDisplayed(textList);
        Assert.assertTrue(isDisplayed);
    }

    @And("6 checkboxes should be displayed on Users Table on User Table Page")
    public void assertCheckboxes() {
        UserTablePage userTablePage = new UserTablePage(driver);
        List<WebElement> checkboxes = userTablePage.getUserCheckboxList();
        int number = checkboxes.size();
        int expectedNo = Integer.parseInt(fileReader.getValue("userTableCheckboxNo"));
        Assert.assertEquals(number, expectedNo);
        boolean isDisplayed = userTablePage.isDisplayed(checkboxes);
        Assert.assertTrue(isDisplayed);
    }

    @And("User table should contain following values:")
    public void assertUsertable(DataTable dataTable) {
        UserTablePage userTablePage = new UserTablePage(driver);
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        for (int i = 0; i < table.size(); i++) {
            String userId = userTablePage.getUserIdList().get(i).getText();
            String expectedUserId = table.get(i).get("Number");
            Assert.assertEquals(userId, expectedUserId);

            String username = userTablePage.getUsernameList().get(i).getText();
            String expectedUsername = table.get(i).get("User");
            Assert.assertEquals(username, expectedUsername);

            String userDescription = userTablePage.getUserDescrList().get(i)
                    .getText().replace("\n", " ");
            String expectedUserDescription = table.get(i).get("Description");
            Assert.assertEquals(userDescription, expectedUserDescription);
        }
    }

    @And("droplist should contain values in column Type for user Roman")
    public void assertDroplistValuesForUserRoman(DataTable dataTable) {
        UserTablePage userTablePage = new UserTablePage(driver);
        List<String> table = dataTable.asList(String.class);

        for (int i = 0; i < table.size() - 1; i++) {
            String dropdownValue = userTablePage
                    .getDropdownValuesForUserRoman().get(i).getText();
            // i+1 to skip Data Table title in feature file
            String expectedDropdownValue = table.get(i + 1);
            Assert.assertEquals(dropdownValue, expectedDropdownValue);
        }
    }

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void selectVipCheckboxForSergeyIvan() {
        UserTablePage userTablePage = new UserTablePage(driver);
        userTablePage.setVipCheckboxForSergeyIvan();
    }

    @Then("1 log row has {string} text in log section")
    public void assertCheckboxConditionChangedToTrueInLogSection(String expectedLogText) {
        UserTablePage userTablePage = new UserTablePage(driver);
        String logs = userTablePage.getLogVipCheckboxForSergeyIvan();
        Assert.assertTrue(logs.contains(expectedLogText));
    }
}

