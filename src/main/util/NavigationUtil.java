package main.util;

import main.config.PropertyReader;
import org.openqa.selenium.WebDriver;

public class NavigationUtil {
    private WebDriver driver;

    public NavigationUtil(WebDriver driver){
        this.driver=driver;
    }
    public void NavigateToAnotherSite(String pageID){
        String home = PropertyReader.getProperty("home_page");
        String page = PropertyReader.getProperty(pageID);
        if (page == null) page = ""; // so we dont end up on https://magento.softwaretestingboard.com/null
        driver.get(home + page);
    }
}
