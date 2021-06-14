package src.test.java.ru.training.at.hw4.test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import src.test.java.ru.training.at.hw4.steps.StepsEx1;

@Listeners(src.test.java.ru.training.at.hw4.listeners.ScreenshotListener.class)
public class FailedTest extends BaseTest {

    @Test
    @Feature("Failed test")
    @Story("Failed method after No 4 added")
    public void exercise1() {
        StepsEx1 steps = new StepsEx1(webDriver);

        // 1. Open test site by URL
        steps.openSiteByUrl(webDriver);

        // 2. Assert Browser title
        steps.assertTitle(webDriver);

        // 3. Perform login
        steps.performLogin(webDriver);

        // 4. Assert Username is logged in
        steps.assertUsername(webDriver);

        // Failed method
        steps.failedMethod();

        // 5. Assert that there are 4 items on the header section are displayed
        // and they have proper texts
        steps.assertFourItems(webDriver);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        steps.assertFourImages(webDriver);

        //7. Assert that there are 4 texts on the Index Page under icons
        // and they have proper text
        steps.assertFourTexts(webDriver);

        // 8. Assert that there is the iframe with “Frame Button” exist
        steps.assertFrameButton(webDriver);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        steps.gotoFrame(webDriver);

        // 10. Switch to original window back
        steps.gotoHomePage(webDriver);

        // 11. Assert that there are 5 items in the Left Section are displayed
        // and they have proper text
        steps.assertFiveItems(webDriver);

        // 12. Close Browser
        steps.closeBrowser(webDriver);
    }
}