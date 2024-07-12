package test;

import main.config.PropertyReader;
import main.helpers.WebDriverHelper;
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
        String url = PropertyReader.getProperty("home_page");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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


