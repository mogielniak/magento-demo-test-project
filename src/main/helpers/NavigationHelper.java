package main.helpers;

import main.config.PropertyReader;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver driver;

    public NavigationHelper(WebDriver driver){
        this.driver=driver;
    }
    public void NavigateToAnotherSite(String pageID){
        String home = PropertyReader.getProperty("home_page");
        String page = PropertyReader.getProperty(pageID);
        if (page == null) page = ""; // so we dont end up on https://magento.softwaretestingboard.com/null
        driver.get(home + page);
    }
}
