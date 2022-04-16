package src.main.java.ru.training.at.hw6.site.pages;


import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import org.openqa.selenium.WebElement;
import src.main.java.ru.training.at.hw6.site.sections.LoginForm;

import static src.main.java.ru.training.at.hw6.UserData.DEFAULT_USER;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {

    @UI("form")
    public static LoginForm loginForm;
    @UI("img#user-icon")
    public static Icon userIcon;
    @UI("#user-name")
    public static Label userName;
    @UI(".fa-sign-out")
    public static WebElement logout;

    public void login() {
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
    }

    public void logout() {
        userIcon.click();
        logout.click();
    }

}
