package test;
import main.helpers.webDriver.WebDriverHelper;
import main.pages.Login;
import main.pages.Register;

import static main.config.PropertyReader.getProperty;

import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.*;

import static main.util.PageUtil.getCurrentURL;
import static main.util.PageUtil.gotoSite;
import static main.util.PageUtil.mergePage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
@Listeners(WebDriverHelper.class)
public class LoginRegisterTest {
//go to testng.xml for parallel testing
    @Test
    @DisplayName("Login")
    public void test() {
        gotoSite("login");
        Login loginPage = new Login();
        loginPage.enterCredentials(getProperty("L_user"), getProperty("L_pass"));
        assertEquals(getCurrentURL(), mergePage("account"));
    }

    @Test(priority = 2)
    @DisplayName("Good login/bad password")
    public void test2() {
        gotoSite("login");
        Login loginPage = new Login();
        loginPage.enterCredentials(getProperty("L_user"), getProperty("pass"));
        assertNotEquals("https://magento.softwaretestingboard.com/customer/account/", getCurrentURL());
    }


    @Test(priority = 3)
    @DisplayName("Bad login/Good password")
    public void test3() {
        gotoSite("login");
        Login loginPage = new Login();
        loginPage.enterCredentials(getProperty("firstName"), getProperty("L_pass"));
        assertNotEquals(getCurrentURL(), mergePage("account"));
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
    @DisplayName("register with too short password")
    public void test5() {
        gotoSite("register");
        Register registerPage = new Register();
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                getProperty("shortPass"), getProperty("shortPass"));
        assertTrue(registerPage.getPasswordError().isDisplayed());
    }

    @Test(priority = 6)
    @DisplayName("register not matching passwords")
    public void test6() {
        gotoSite("register");
        Register registerPage = new Register();
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                getProperty("pass"), getProperty("L_pass"));
        assertTrue(registerPage.getPasswordConfirmationError().isDisplayed());
    }

    @Test(priority = 7)
    @DisplayName("register/no firstname")
    public void test7() {
        gotoSite("register");
        Register registerPage = new Register();
        registerPage.fillForm(getProperty("nothing"), getProperty("lastName"), getProperty("email"),
                getProperty("pass"), getProperty("L_pass"));
        assertTrue(registerPage.getFirstNameError().isDisplayed());
    }

    @Test(priority = 8)
    @DisplayName("register/no lastname")
    public void test8() {
        gotoSite("register");
        Register registerPage = new Register();
        registerPage.fillForm(getProperty("firstName"), getProperty("nothing"), getProperty("email"),
                getProperty("pass"), getProperty("L_pass"));
        assertTrue(registerPage.getLastNameError().isDisplayed());
    }

    @Test(priority = 9)
    @DisplayName("register/no email")
    public void test9() {
        gotoSite("register");
        Register registerPage = new Register();
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("nothing"),
                getProperty("pass"), getProperty("L_pass"));
        assertTrue(registerPage.getEmailError().isDisplayed());
    }

    @Test(priority = 10)
    @DisplayName("register/no password")
    public void test10() {
        gotoSite("register");
        Register registerPage = new Register();
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                getProperty("nothing"), getProperty("L_pass"));
        assertTrue(registerPage.getPasswordConfirmationError().isDisplayed());
    }

    @Test(priority = 11)
    @DisplayName("register/no password confirmation")
    public void test11() {
        gotoSite("register");
        Register registerPage = new Register();
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                getProperty("pass"), getProperty("nothing"));
        assertTrue(registerPage.getPasswordConfirmationError().isDisplayed());
    }
    @Test(priority = 12)
    @DisplayName("register random values")
    public void test12(){
        gotoSite("register");
        Register registerPage = new Register();
        registerPage.registerWithRandomValues();
        assertEquals(getCurrentURL(), mergePage("account"));
    }
    @Test(priority = 13)
    @DisplayName("sign out")
    public void test13(){
        gotoSite("register");
        Register registerPage = new Register();
        registerPage.registerWithRandomValues();
        registerPage.Click(registerPage.customerMenuToggle);
        registerPage.Click(registerPage.signOutButton);
        assertEquals(getCurrentURL(), mergePage("sign_out"));

    }
}


