package src.test.java.ru.training.at.hw5.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserTablePage {

    public WebDriver webDriver;

    public UserTablePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(css = "#user-table > tbody > tr > td > select")
    private List<WebElement> dropdownsList;

    @FindBy(css = "#user-table > tbody > tr > td> a")
    private List<WebElement> usernamesList;

    @FindBy(css = "#user-table div.user-descr > span")
    private List<WebElement> userDescrUnderImageList;

    @FindBy(css = "#user-table  input[type='checkbox']")
    private List<WebElement> checkboxesList;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(1)")
    private List<WebElement> userIdList;

    @FindBy(css = "tbody tr:first-child option")
    private List<WebElement> dropdownValuesForUserRoman;

    @FindBy(id = "ivan")
    private WebElement vipCheckboxForSergeyIvan;

    @FindBy(css = ".panel-body-list > li")
    private WebElement logVipCheckboxForSergeyIvan;

    public List<WebElement> getDropdownList() {
        return dropdownsList;
    }

    public List<WebElement> getUsernameList() {
        return usernamesList;
    }

    public List<WebElement> getUserDescrList() {
        return userDescrUnderImageList;
    }

    public List<WebElement> getUserCheckboxList() {
        return checkboxesList;
    }

    public List<WebElement> getUserIdList() {
        return userIdList;
    }

    public List<WebElement> getDropdownValuesForUserRoman() {
        return dropdownValuesForUserRoman;
    }

    public void setVipCheckboxForSergeyIvan() {
        vipCheckboxForSergeyIvan.click();
    }

    public String getLogVipCheckboxForSergeyIvan() {
        return logVipCheckboxForSergeyIvan.getText();
    }

    public Boolean isDisplayed(List<WebElement> list) {
        boolean isDisplayed = true;
        for (WebElement web : list) {
            if (!web.isDisplayed()) {
                isDisplayed = false;
            }
        }
        return isDisplayed;
    }
}
