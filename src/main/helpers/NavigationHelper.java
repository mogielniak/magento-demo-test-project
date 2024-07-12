package main.helpers;

import main.config.PropertyReader;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver driver;

    public NavigationHelper(WebDriver driver){
        this.driver=driver;
    }
    public void gotoSite(String pageID){
        String home = PropertyReader.getProperty("home_page");
        String page = PropertyReader.getProperty(pageID);
        driver.get(home + page);
    }
}
