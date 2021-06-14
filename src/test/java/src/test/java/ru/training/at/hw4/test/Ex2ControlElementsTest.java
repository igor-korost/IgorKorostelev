package src.test.java.ru.training.at.hw4.test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import src.test.java.ru.training.at.hw4.steps.StepsEx2;

public class Ex2ControlElementsTest extends BaseTest {
    @Feature(value = "Page with control elements")
    @Story(value = "User logs in and control elements are checked")
    @Test
    public void exercise2() {
        StepsEx2 steps = new StepsEx2(webDriver);

        // 1. Open test site by URL
        steps.openSiteByUrl(webDriver);

        // 2. Assert Browser title
        steps.assertTitle(webDriver);

        // 3. Perform login
        steps.performLogin(webDriver);

        // 4. Assert Username is logged in
        steps.assertUsername(webDriver);

        // 4. Assert Username is logged in
        steps.assertUsername(webDriver);

        // 5. Open through the header menu Service -> Different Elements Page
        steps.openServiceMenu(webDriver);

        // 6. Select checkboxes Water, Wind
        steps.selectWaterWindCheckboxes(webDriver);

        // 7. Select radio Selen
        steps.selectSelenRadioButton(webDriver);

        // 8. Select in dropdown Yellow
        steps.selectYellowDropdown(webDriver);

        // 9. AssertLogs
        steps.assertLogs(webDriver);

        // 10. Close Browser
        steps.closeBrowser(webDriver);
    }
}
