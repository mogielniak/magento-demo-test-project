package test;

import main.config.PropertyReader;
import main.pages.Login;
import main.pages.Register;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;

public class test_testu extends BlankTest{
    private WebDriver driver;
    @Test
    @Order(1)
    @DisplayName("Login")
    public void test(){
        gotoSite("login");
        Login loginPage = new Login(driver);
        loginPage.enterCredentials(PropertyReader.getProperty("L_user"), PropertyReader.getProperty("L_pass"));
    }
    @Test
    @Order(2)
    @DisplayName("Register")
    public void test2() {
        gotoSite("register");
        Register registerPage = new Register(driver);
        registerPage.fillForm(PropertyReader.getProperty("firstName"), PropertyReader.getProperty("lastName"), PropertyReader.getProperty("email"),
                              PropertyReader.getProperty("pass"), PropertyReader.getProperty("confirmPass"));
    }
}


