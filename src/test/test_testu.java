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

public class test_testu extends BlankTest{
    private WebDriver driver;
    @Test
    public void test(){
        gotoSite("login");
        Login loginPage = new Login(driver); //Create loginPage
        loginPage.enterCredentials(PropertyReader.getProperty("username"), PropertyReader.getProperty("password"));
    }

}


