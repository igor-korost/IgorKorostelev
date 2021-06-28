package src.test.java.ru.training.at.hw5.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.ru.training.at.hw3.util.PropertiesFileReader;

public class HomePage {
    public WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 a.dropdown-toggle")
    private WebElement serviceMenuItem;

    @FindBy(css = ".dropdown-menu a[href='user-table.html']")
    private WebElement userTableMenuItem;

    PropertiesFileReader fileReader = new PropertiesFileReader();

    public void openHomePage() {
        webDriver.navigate().to(fileReader.getProperties("baseUrl"));
    }

    public void openServiceMenu() {
        serviceMenuItem.click();
    }

    public void openUserTableMenu() {
        userTableMenuItem.click();
    }
}
