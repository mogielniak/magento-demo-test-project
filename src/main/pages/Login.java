package main.pages;

import main.helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends PageHelper {

    public Login(WebDriver driver){
        super(driver);
    }
    @FindBy(id="email")     private WebElement email;
    @FindBy(id="pass")  private WebElement password;
    @FindBy(id = "send2")   private WebElement log_in;

    public WebElement getEmail(){
        return email;
    }
    public WebElement getPassword(){
        return password;
    }
    public WebElement getLog_in(){
        return log_in;
    }

    public void enterCredentials(String email, String password){
        Write(getEmail(), email);
        Write(getPassword(), password);
    }





}
