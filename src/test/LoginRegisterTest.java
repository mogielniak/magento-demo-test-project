package test;
import main.helpers.WebDriverHelper;
import main.pages.Login;
import main.pages.Register;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static main.config.PropertyReader.getProperty;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LoginRegisterTest extends BlankTest {
    private WebDriver driver;

    @Test
    @Order(1)
    @DisplayName("Login")
    public void test() {
        gotoSite("login");
        Login loginPage = new Login(driver);
        loginPage.enterCredentials(getProperty("L_user"), getProperty("L_pass"));
        assertEquals("https://magento.softwaretestingboard.com/customer/account/", getCurrentURL());
    }

    @Test
    @Order(2)
    @DisplayName("Good login/bad password")
    public void test2() {
        gotoSite("login");
        Login loginPage = new Login(driver);
        loginPage.enterCredentials(getProperty("L_user"), getProperty("pass"));
        assertNotEquals("https://magento.softwaretestingboard.com/customer/account/", getCurrentURL());
    }


    @Test
    @Order(3)
    @DisplayName("Bad login/Good password")
    public void test3() {
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

    @Test
    @Order(5)
    @DisplayName("register with too short password")
    public void test5() {
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                getProperty("shortPass"), getProperty("shortPass"));
        assertTrue(registerPage.getPasswordError().isDisplayed());
    }

    @Test
    @Order(6)
    @DisplayName("register not matching passwords")
    public void test6() {
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                getProperty("pass"), getProperty("L_pass"));
        assertTrue(registerPage.getPasswordConfirmationError().isDisplayed());
    }
    @Test
    @Order(7)
    @DisplayName("register/no firstname")
    public void test7() {
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("nothing"), getProperty("lastName"), getProperty("email"),
                getProperty("pass"), getProperty("L_pass"));
        assertTrue(registerPage.getFirstNameError().isDisplayed());
    }
    @Test
    @Order(8)
    @DisplayName("register/no lastname")
    public void test8() {
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("nothing"), getProperty("email"),
                getProperty("pass"), getProperty("L_pass"));
        assertTrue(registerPage.getLastNameError().isDisplayed());
    }
    @Test
    @Order(9)
    @DisplayName("register/no email")
    public void test9() {
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("nothing"),
                getProperty("pass"), getProperty("L_pass"));
        assertTrue(registerPage.getEmailError().isDisplayed());
    }
    @Test
    @Order(10)
    @DisplayName("register/no password")
    public void test10() {
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                getProperty("nothing"), getProperty("L_pass"));
        assertTrue(registerPage.getPasswordConfirmationError().isDisplayed());
    }
    @Test
    @Order(11)
    @DisplayName("register/no password confirmation")
    public void test11() {
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                getProperty("pass"), getProperty("nothing"));
        assertTrue(registerPage.getPasswordConfirmationError().isDisplayed());
    }
}


