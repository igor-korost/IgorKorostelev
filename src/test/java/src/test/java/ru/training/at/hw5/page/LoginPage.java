package src.test.java.ru.training.at.hw5.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.java.ru.training.at.hw5.util.PropertiesFileReader;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    PropertiesFileReader fileReader = new PropertiesFileReader();

    public void login() {
        userIcon.click();
        userNameInput.sendKeys(fileReader.getValue("name"));
        passwordInput.sendKeys(fileReader.getValue("password"));
        loginButton.click();
    }
}
