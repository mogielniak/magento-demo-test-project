package main.helpers;

import main.util.PageUtil;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class PageHelper {
    protected WebDriver driver;
    protected Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(2))
                    .pollingEvery(Duration.ofMillis(300))
                    .ignoring(ElementNotInteractableException.class);

    public PageHelper(WebDriver driver){
        this.driver = WebDriverHelper.getDriverInv();
        if(this.driver==null) this.driver = WebDriverHelper.getDriver();
        PageFactory.initElements(this.driver,this);
    }
    public void Click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        PageUtil.scrollToElement(driver, element);
        element.click();
    }
    public void waitForTheElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void Write (WebElement element, String text){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }
    public void Hover(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
}
