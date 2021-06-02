package src.test.java.ru.training.at.hw4.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.ru.training.at.hw3.util.PropertiesFileReader;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    public WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> headerItems;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> indexIcons;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> iconsTexts;

    @FindBy(css = "#mCSB_1_container > ul > li")
    private List<WebElement> sideBar;

    PropertiesFileReader fileReader = new PropertiesFileReader();

    public void openHomePage() {
        webDriver.navigate().to(fileReader.getProperties("baseUrl"));
    }

    public List<WebElement> getHeaderItems() {
        return headerItems;
    }

    public List<WebElement> getIndexIcons() {
        return indexIcons;
    }

    public List<String> getIconsText() {
        List<String> indexPageIconsText = new ArrayList<>();
        for (WebElement web : iconsTexts) {
            indexPageIconsText.add(web.getText());
        }
        return indexPageIconsText;
    }

    public List<WebElement> getSideBarItems() {
        return sideBar;
    }

}
