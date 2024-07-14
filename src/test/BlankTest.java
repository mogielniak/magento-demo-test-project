package test;

import main.util.NavigationUtil;
import main.helpers.WebDriverHelper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
        NavigationUtil navigationHelper = new NavigationUtil(driver); //possibly make navigation util static idk
        navigationHelper.NavigateToAnotherSite(PageID);
    }
    protected String getCurrentURL(){
        return driver.getCurrentUrl();
    }
}

