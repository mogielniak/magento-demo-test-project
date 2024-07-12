package main.helpers;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class PageHelper {
    protected WebDriver driver;
    private Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(2))
                    .pollingEvery(Duration.ofMillis(300))
                    .ignoring(ElementNotInteractableException.class);

    public PageHelper(WebDriver driver){
        this.driver = WebDriverHelper.getDriver();
        PageFactory.initElements(this.driver,this);
    }
    public void Click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void Write (WebElement element, String text){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }
}
