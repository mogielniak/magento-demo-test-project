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

public class LoginRegisterTest extends BlankTest{
    private WebDriver driver;
    @Test
    @Order(1)
    @DisplayName("Login")
    public void test(){
        gotoSite("login");
        Login loginPage = new Login(driver);
        loginPage.enterCredentials(getProperty("L_user"), getProperty("L_pass"));
        assertEquals("https://magento.softwaretestingboard.com/customer/account/", getCurrentURL());
    }
    @Test
    @Order(2)
    @DisplayName("Bad login")
    public void test2(){
        gotoSite("login");
        Login loginPage = new Login(driver);
        loginPage.enterCredentials(getProperty("L_user"), getProperty("pass"));
        assertNotEquals("https://magento.softwaretestingboard.com/customer/account/", getCurrentURL());
    }

    @Test
    @Order(3)
    @DisplayName("register with already used email")
    public void test3() {
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                              getProperty("pass"), getProperty("confirmPass"));
        assertTrue(registerPage.getUsedEmailAlert().isDisplayed());
    }
    @Test
    @Order(4)
    @DisplayName("register with too short password")
    public void test4() {
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                              getProperty("shortPass"), getProperty("shortPass"));

    }
}


