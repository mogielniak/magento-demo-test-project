package main.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUtil {
    private WebElement element;
    PageUtil(WebElement element){
        this.element=element;
    }

    public static void scrollToElement(WebDriver driver, WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
        if(!element.isDisplayed()) javascriptExecutor.executeScript("arguments[0].scrollBy(0,100)");
    }
    public void scrollToBottom() {
        ((JavascriptExecutor) element).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    public void scrollToTop() {
        ((JavascriptExecutor) element).executeScript("window.scrollTo(0, 0);");
    }
}
