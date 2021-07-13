package src.test.java.ru.training.at.hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import src.main.java.ru.training.at.hw6.DataProviders;
import src.main.java.ru.training.at.hw6.entities.MetalAndColors;
import src.main.java.ru.training.at.hw6.site.JdiSite;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static src.main.java.ru.training.at.hw6.UserData.DEFAULT_USER;
import static src.main.java.ru.training.at.hw6.site.JdiSite.homePage;
import static src.main.java.ru.training.at.hw6.site.JdiSite.metalAndColorsPage;


public class JdiTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initElements(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
    public void siteTest(MetalAndColors entity) {
        homePage.open();
        homePage.login();
        homePage.userName.is().text(DEFAULT_USER.userNameLogged);
        metalAndColorsPage.open();
        metalAndColorsPage.checkOpened();
        metalAndColorsPage.metalAndColorsForm.submit(entity);
        List<String> expectedResults = metalAndColorsPage.resultSection.getListFromEntity(entity);
        List<String> actualResults = metalAndColorsPage.resultSection.getResults();
        // hamcrest assert Lists are equal in any elements order
        assertThat("expected and actual result Lists are not equal",
                expectedResults, containsInAnyOrder(actualResults.toArray()));
        homePage.logout();
    }
}
