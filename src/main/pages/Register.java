package main.pages;

import main.helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register extends PageHelper {

    public Register(WebDriver driver){
        super(driver);
       // PageFactory.initElements(driver,this);
    }
    @FindBy(id="firstname")                                         private WebElement firstName;
    @FindBy(id="lastname")                                          private WebElement lastName;
    @FindBy(id="email_address")                                     private WebElement email;
    @FindBy(id="password")                                          private WebElement password;
    @FindBy(id="password-confirmation")                             private WebElement confirmPassword;
    @FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button") private WebElement submitButton;

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
    public WebElement getSubmitButton(){
        return submitButton;}

    public void fillForm(String firstName, String lastName, String email, String password, String confirmPassword){
        Write(getFirstName(), firstName);
        Write(getLastName(), lastName);
        Write(getEmail(), email);
        Write(getPassword(), password);
        Write(getconfirmPassword(), confirmPassword);
        Click(submitButton);
    }
}
