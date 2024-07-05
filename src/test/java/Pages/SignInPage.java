package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BaseTest {
    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="email")
    public WebElement emailfield;
    @FindBy(id="pass")
    public WebElement passwordfield;
    @FindBy(id="send2")
    public WebElement signInButton;
    @FindBy(linkText = "Forgot Your Password?")
    public WebElement forgetPasswordButton;
    @FindBy (id="email-error")
    public WebElement errorEmail;
    @FindBy(id="pass-error")
    public WebElement errorPassword;
    @FindBy(css="#maincontent > div.page.messages > div:nth-child(2) > div > div > div")
    public WebElement errorAccount;
    @FindBy(className = "logged-in")
    public WebElement welcomeMessage;
    public String errorMessage="This is a required field.";
    @FindBy(className = "authorization-link")
    public WebElement signOutButton;
    //----------------------------------------------------------------------
    public void inputEmail(String email){
        emailfield.clear();
        emailfield.sendKeys(email);
    }
    public void inputPassword(String password){
        passwordfield.clear();
        passwordfield.sendKeys(password);
    }
    public void signInClick(){
        signInButton.click();
    }
    public void forgetPasswordButtonClick(){
        forgetPasswordButton.click();
    }
    public boolean displayedSignIneButton(){
        return elementDisplayed(signInButton);
    }
    public boolean displayedEmailField(){
        return elementDisplayed(emailfield);
    }
    public boolean displayedPasswordField(){
        return elementDisplayed(passwordfield);
    }
    public boolean errorMessageEmailDisplay(){
        return elementDisplayed(errorEmail);
    }
    public boolean errorPasswordDisplay(){
        return elementDisplayed(errorPassword);
    }
    public boolean errorMessageForInputisThere(WebElement e){
        return e.getText().equals(errorMessage);
    }
    public boolean noSuchAccount(){
        return elementDisplayed(errorAccount);
    }
    public boolean errorMailMessageisThere(){
        return errorEmail.getText().equalsIgnoreCase("Please enter a valid email address (Ex: johndoe@domain.com).");
    }
    public boolean welcomeUser(String userName){
        return welcomeMessage.getText().contains(userName);
    }
    public void clickSignOutButton(){
        signOutButton.click();
    }

}
