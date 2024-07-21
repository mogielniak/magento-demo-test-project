package main.pages;

import main.helpers.PageHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import static main.util.FakerUtil.*;

public class Register extends PageHelper {


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
    public WebElement getPasswordError(){
        return passwordError;
    }
    public WebElement getPasswordConfirmationError(){
        return passwordConfirmationError;
    }
    public WebElement getFirstNameError(){
        return firstNameError;
    }
    public WebElement getLastNameError(){
        return lastNameError;
    }
    public WebElement getEmailError(){
        return emailError;
    }

    public void fillForm(String firstName, String lastName, String email, String password, String confirmPassword){
        Write(getFirstName(), firstName);
        Write(getLastName(), lastName);
        Write(getEmail(), email);
        Write(getPassword(), password);
        Write(getconfirmPassword(), confirmPassword);
        Click(submitButton);
    }
    public void registerWithRandomValues(){
        String password = getRandomPassword();
        Write(getFirstName(), getRandomFirstname());
        Write(getLastName(), getRandomLastname());
        Write(getEmail(), getRandomEmail());
        Write(getPassword(), password);
        Write(getconfirmPassword(), password);
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
    @FindBy(id = "firstname-error")                                         private WebElement firstNameError;
    @FindBy(id = "lastname-error")                                          private WebElement lastNameError;
    @FindBy(id = "email_address-error")                                     private WebElement emailError;
    @FindBy(id = "password-error")                                          private WebElement passwordError;
    @FindBy(id = "password-confirmation-error")                             private WebElement passwordConfirmationError;

}
