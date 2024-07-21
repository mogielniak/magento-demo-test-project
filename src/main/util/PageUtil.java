package main.util;

import main.config.PropertyReader;
import main.helpers.webDriver.driverUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class PageUtil {
    private PageUtil(){}

    public static void scrollToElement(WebDriver driver, WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
        if(!element.isDisplayed()) javascriptExecutor.executeScript("arguments[0].scrollBy(0,100)");
    }
    public static String getCurrentURL(){
        return driverUtil.getDriver().getCurrentUrl();
    }
    public static String mergePage(String pageID){
        String home = PropertyReader.getProperty("home_page");
        String page = PropertyReader.getProperty(pageID);
        if (page == null) page = ""; // so we dont end up on https://magento.softwaretestingboard.com/null
        String mergedPage = home + page;
        return mergedPage;
    }
    public static void gotoSite(String pageID){
        driverUtil.getDriver().get(mergePage(pageID));
    }

}

