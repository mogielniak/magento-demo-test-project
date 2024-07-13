package main.pages;

import main.helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register extends PageHelper {

    public Register(WebDriver driver){
        super(driver);
    }
    public WebElement getFirstName(){
        return firstName;}
    public WebElement getLastName(){
        return lastName;}
    public WebElement getEmail(){
        return email;}
    public WebElement getPassword(){
        return password;}
    public WebElement getconfirmPassword(){
        return confirmPassword;}
    public WebElement getUsedEmailAlert(){
        return usedEmailAlert;}

    public void fillForm(String firstName, String lastName, String email, String password, String confirmPassword){
        Write(getFirstName(), firstName);
        Write(getLastName(), lastName);
        Write(getEmail(), email);
        Write(getPassword(), password);
        Write(getconfirmPassword(), confirmPassword);
        Click(submitButton);
    }
    @FindBy(id="firstname")                                                 private WebElement firstName;
    @FindBy(id="lastname")                                                  private WebElement lastName;
    @FindBy(id="email_address")                                             private WebElement email;
    @FindBy(id="password")                                                  private WebElement password;
    @FindBy(id="password-confirmation")                                     private WebElement confirmPassword;
    @FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button")         private WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")   private WebElement usedEmailAlert;

    @FindBy(xpath = "//*[@id=\"password-error\"]")                          private WebElement shortPassword;

}
