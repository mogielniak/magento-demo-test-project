package main.helpers;

import main.helpers.webDriver.WebDriverHelper;
import main.helpers.webDriver.driverUtil;
import main.util.PageUtil;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.logging.Logger;

public class PageHelper {
    protected WebDriver driver;
    protected Wait<WebDriver> wait = new FluentWait<>(driverUtil.getDriver())
            .withTimeout(Duration.ofSeconds(2))
            .pollingEvery(Duration.ofMillis(300))
            .ignoring(ElementNotInteractableException.class);
    private static final Logger LOGGER = Logger.getLogger(WebDriverHelper.class.getName());
    public PageHelper(){
        driver = driverUtil.getDriver();
        PageFactory.initElements(driver,this);
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
