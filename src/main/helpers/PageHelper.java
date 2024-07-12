package main.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageHelper {
    protected WebDriver driver;

    public PageHelper(WebDriver driver){
        this.driver = WebDriverHelper.getDriver();
        PageFactory.initElements(this.driver,this);
    }
    public void click(WebElement element){
        element.click();
    }
}
