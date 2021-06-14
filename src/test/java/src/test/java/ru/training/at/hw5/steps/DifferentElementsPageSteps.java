package src.test.java.ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import src.test.java.ru.training.at.hw5.context.TestContext;
import src.test.java.ru.training.at.hw5.page.DifferentElementsPage;
import src.test.java.ru.training.at.hw5.util.PropertiesFileReader;

import java.util.List;

public class DifferentElementsPageSteps {
    private final WebDriver driver = TestContext.getInstance()
            .getTestObject(TestContext.WEB_DRIVER);

    @And("I open Different Elements Page")
    public  void openDifferentElementsPage() {
        new DifferentElementsPage(driver).openDifferentElementsPage();
    }

    @When("I select 'Water' and 'Wind' checkboxes")
    public void selectWaterAndWindCheckboxes() {
        new DifferentElementsPage(driver).setWaterCheckbox();
        new DifferentElementsPage(driver).setWindCheckbox();
    }

    @And("I select radio button 'Selen'")
    public void selectRadioButton() {
        new DifferentElementsPage(driver).setSelenRadio();
    }

    @And("I select 'Yellow' from the dropdown menu")
    public void selectYellowDropdown() {
        new DifferentElementsPage(driver).setDropdownYellow();
    }

    @Then("Logs for every selected element will be displayed")
    public void assertLogs() {
        PropertiesFileReader fileReader = new PropertiesFileReader();
        List<String> logList = new DifferentElementsPage(driver).getLogList();

        Assert.assertTrue(logList.get(0).contains(fileReader.getValue("logYellow")));
        Assert.assertTrue(logList.get(1).contains(fileReader.getValue("logSelen")));
        Assert.assertTrue(logList.get(2).contains(fileReader.getValue("logWind")));
        Assert.assertTrue(logList.get(3).contains(fileReader.getValue("logWater")));
    }
}
