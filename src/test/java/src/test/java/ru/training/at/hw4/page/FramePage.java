package src.test.java.ru.training.at.hw4.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FramePage {
    WebDriver webDriver;

    public FramePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(id = "frame")
    private List<WebElement> frames;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public boolean isDisplayedFrame() {
        return frames.size() > 0;
    }

    public void gotoFrame() {
        webDriver.switchTo().frame("frame");
        WebElement frameButton = webDriver.findElement(By.id("frame-button"));
    }

    public boolean isDisplayedFrameButton() {
        return frameButton.isDisplayed();
    }

    public void gotoHomePage() {
        webDriver.switchTo().defaultContent();
    }

}
