package test;
//import junit.framework.TestListener;

import main.helpers.WebDriverHelper;
import main.pages.Login;
import main.pages.Register;
import main.util.NavigationUtil;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import java.time.Duration;


//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Order;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;



import static main.config.PropertyReader.getProperty;


import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

@Listeners(WebDriverHelper.class)
public class LoginRegisterTest { // still has some bugs.. temporary i moved things a little bit so its a mess now but
    //parallel testing is working (cant destroy your cpu anymore and most of the tests are accepted)
    //go to testng.xml to use it
    private WebDriver driver;
    private WebDriverHelper webDriverHelper;
    private WebDriverWait wait;

    @Test(priority = 1)
    //@Order(1)
    // @DisplayName("Login")
    public void test() {
        driver = WebDriverHelper.getDriverInv();
        gotoSite("login");
        Login loginPage = new Login(driver);
        loginPage.enterCredentials(getProperty("L_user"), getProperty("L_pass"));
        assertEquals("https://magento.softwaretestingboard.com/customer/account/", getCurrentURL());
    }

    @Test(priority = 2)
    // @Order(2)
    //  @DisplayName("Good login/bad password")
    public void test2() {
        driver = WebDriverHelper.getDriverInv();
        gotoSite("login");
        Login loginPage = new Login(driver);
        loginPage.enterCredentials(getProperty("L_user"), getProperty("pass"));
        assertNotEquals("https://magento.softwaretestingboard.com/customer/account/", getCurrentURL());
    }


    @Test(priority = 3)
    // @Order(3)
    //  @DisplayName("Bad login/Good password")
    public void test3() {
        driver = WebDriverHelper.getDriverInv();
        gotoSite("login");
        Login loginPage = new Login(driver);
        loginPage.enterCredentials(getProperty("firstName"), getProperty("L_pass"));
        assertNotEquals("https://magento.softwaretestingboard.com/customer/account/", getCurrentURL());
    }

   /* @Test //probably needs a setup once in a while to make it work i think every sunday data resets so register first manually, cant really automate that
    @Order(4)
    @DisplayName("register with already used email")
    public void test4() {
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                getProperty("pass"), getProperty("confirmPass"));
        assertTrue(registerPage.getUsedEmailAlert().isDisplayed());
    }*/

    @Test(priority = 5)
    //   @Order(5)
    //   @DisplayName("register with too short password")
    public void test5() {
        driver = WebDriverHelper.getDriverInv();
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                getProperty("shortPass"), getProperty("shortPass"));
        assertTrue(registerPage.getPasswordError().isDisplayed());
    }

    @Test(priority = 6)
    //  @Order(6)
    // @DisplayName("register not matching passwords")
    public void test6() {
        driver = WebDriverHelper.getDriverInv();
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                getProperty("pass"), getProperty("L_pass"));
        assertTrue(registerPage.getPasswordConfirmationError().isDisplayed());
    }

    @Test(priority = 7)
    //   @Order(7)
    //  @DisplayName("register/no firstname")
    public void test7() {
        driver = WebDriverHelper.getDriverInv();
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("nothing"), getProperty("lastName"), getProperty("email"),
                getProperty("pass"), getProperty("L_pass"));
        assertTrue(registerPage.getFirstNameError().isDisplayed());
    }

    @Test(priority = 8)
    //   @Order(8)
    //  @DisplayName("register/no lastname")
    public void test8() {
        driver = WebDriverHelper.getDriverInv();
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("nothing"), getProperty("email"),
                getProperty("pass"), getProperty("L_pass"));
        assertTrue(registerPage.getLastNameError().isDisplayed());
    }

    @Test(priority = 9)
    //   @Order(9)
    //  @DisplayName("register/no email")
    public void test9() {
        driver = WebDriverHelper.getDriverInv();
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("nothing"),
                getProperty("pass"), getProperty("L_pass"));
        assertTrue(registerPage.getEmailError().isDisplayed());
    }

    @Test(priority = 10)
    //   @Order(10)
    //  @DisplayName("register/no password")
    public void test10() {
        driver = WebDriverHelper.getDriverInv();
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                getProperty("nothing"), getProperty("L_pass"));
        assertTrue(registerPage.getPasswordConfirmationError().isDisplayed());
    }

    @Test(priority = 11)
    //   @Order(11)
    //  @DisplayName("register/no password confirmation")
    public void test11() {
        driver = WebDriverHelper.getDriverInv();
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                getProperty("pass"), getProperty("nothing"));
        assertTrue(registerPage.getPasswordConfirmationError().isDisplayed());
    }


    NavigationUtil navigationHelper = new NavigationUtil(driver); //temporary here

    void gotoSite(String PageID) {
        driver.get(navigationHelper.mergePage(PageID));
    }

    protected String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}


