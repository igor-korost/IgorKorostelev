package src.main.java.ru.training.at.hw6.site.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import src.main.java.ru.training.at.hw6.entities.User;

public class LoginForm extends Form<User> {

    @UI("#name")
    TextField userName;
    @UI("#password")
    TextField password;
    @UI("[type=submit]")
    Button enter;

}
