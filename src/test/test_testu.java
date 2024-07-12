package test;

import main.config.PropertyReader;
import main.helpers.WebDriverHelper;
import main.helpers.NavigationHelper;
import main.pages.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class test_testu {
    private WebDriver driver;


    @Before
    public void setUp(){
        driver = WebDriverHelper.getDriver();
        NavigationHelper navigationHelper = new NavigationHelper(driver);  // to do in blanktest
        navigationHelper.gotoSite("login");

    }
    @Test
    public void test(){
        Login loginPage = new Login(driver);
        loginPage.enterCredentials(PropertyReader.getProperty("username"), PropertyReader.getProperty("password"));
    }
    @After
    public void tearDown() {
    WebDriverHelper.quitDriver();
    }
}


