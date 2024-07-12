package test;

import main.util.NavigationUtil;
import main.helpers.WebDriverHelper;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class BlankTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverHelper.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //change to setup
    }
    @After
    public void tearDown() {
        WebDriverHelper.quitDriver();
    }
    protected void gotoSite(String PageID){
        NavigationUtil navigationHelper = new NavigationUtil(driver);
        navigationHelper.NavigateToAnotherSite(PageID);
    }
}

