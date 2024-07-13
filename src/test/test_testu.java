package test;

import main.pages.Login;
import main.pages.Register;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;

import static main.config.PropertyReader.getProperty;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class test_testu extends BlankTest{
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
    @DisplayName("register with already used email")
    public void test2() {
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                              getProperty("pass"), getProperty("confirmPass"));
        assertTrue(registerPage.getUsedEmailAlert().isDisplayed());
    }
}


