package src.test.java.ru.training.at.hw3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ControlElementsPage {
    WebDriver webDriver;

    public ControlElementsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 a.dropdown-toggle")
    private WebElement serviceMenu;

    @FindBy(xpath = "//nav/ul[@class='uui-navigation nav navbar-nav m-l8']/"
            + "descendant::a[contains(text(), 'Different elements')]")
    private WebElement differentElements;

    @FindBy(css = ".label-checkbox:nth-child(1)")
    private WebElement waterCheckbox;

    @FindBy(css = ".label-checkbox:nth-child(3)")
    private WebElement windCheckbox;

    @FindBy(css = ".label-radio:nth-child(4)")
    private WebElement selenRadio;

    @FindBy(css = "select.uui-form-element")
    private WebElement dropdownColors;

    @FindBy(css = "ul.panel-body-list.logs > li")
    private List<WebElement> logWebElementList;

    public void openDifferentElementsPage() {
        serviceMenu.click();
        differentElements.click();
    }

    public void setWaterCheckbox() {
        waterCheckbox.click();
    }

    public void setWindCheckbox() {
        windCheckbox.click();
    }

    public void setSelenRadio() {
        selenRadio.click();
    }

    public void setDropdownYellow() {
        Select dropdown = new Select(dropdownColors);
        dropdown.selectByVisibleText("Yellow");
    }

    public List<String> getLogList() {
        List<String> logList = new ArrayList<>();
        for (WebElement web : logWebElementList) {
            logList.add(web.getText());
        }
        return logList;
    }
}