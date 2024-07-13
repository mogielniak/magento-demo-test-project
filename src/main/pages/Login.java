package main.pages;

import main.helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends PageHelper {

    public Login(WebDriver driver){
        super(driver);
      //  PageFactory.initElements(driver,this);
    }
    @FindBy(id="email")     private WebElement email;
    @FindBy(id="pass")      private WebElement password;
    @FindBy(id = "send2")   private WebElement log_inButton;

    public WebElement getEmail(){
        return email;}
    public WebElement getPassword(){
        return password;}
    public WebElement getLog_inButton(){
        return log_inButton;}

    public void enterCredentials(String email, String password){
        Write(getEmail(), email);
        Write(getPassword(), password);
        Click(log_inButton);
    }





}
