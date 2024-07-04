package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateAnAccountPage extends BaseTest {
    public CreateAnAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="firstname")
    public WebElement firstnamefield;
    @FindBy(id="lastname")
    public WebElement lastnamefield;
    @FindBy(id="email_address")
    public WebElement emailaddressfield;
    @FindBy(id="password")
    public WebElement passwordfield;
    @FindBy(id="password-confirmation")
    public WebElement passwordconfirmationfield;
    @FindBy(css = "#form-validate > div > div.primary > button")
    public WebElement createAnaccountbutton;
    @FindBy(id="firstname-error")
    public WebElement firstnameerror;
    @FindBy(id="lastname-error")
    public WebElement lastnameerror;
    @FindBy(id = "email_address-error")
    public WebElement emailaddresserror;
    @FindBy(id="password-error")
    public WebElement passworderror;
    @FindBy(id="password-confirmation-error")
    public WebElement passwordconfirmationerror;
    public String errorMessage="This is a required field.";
    public String errorMailMessage="Please enter a valid email address (Ex: johndoe@domain.com).";
    public String errorPasswordMessage="Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.";
    public String errorConfirmMessage="Please enter the same value again.";
    //-----------------------------------------------------------

    public boolean fieldIsDisplayed(){
        return elementDisplayed(firstnamefield);
    }
    public boolean buttonIsDIsplayed(){
        scrollToElement(createAnaccountbutton);
        return elementDisplayed(createAnaccountbutton);
    }
    public void inputFirstname(String firstName) {
        firstnamefield.clear();
        firstnamefield.sendKeys(firstName);
    }
    public void inputLastname(String lastName) {
        lastnamefield.clear();
        lastnamefield.sendKeys(lastName);
    }
    public void inputemail(String email) {
        emailaddressfield.clear();
        emailaddressfield.sendKeys(email);
    }
    public void inputPassword(String password){
        passwordfield.clear();
        passwordfield.sendKeys(password);
    }
    public void inputConfirmpassword(String confirmpassword){
        passwordconfirmationfield.clear();
        passwordconfirmationfield.sendKeys(confirmpassword);
    }

    public void clickOnButton(){
        scrollToElement(createAnaccountbutton);
        createAnaccountbutton.click();
    }
    public boolean messageisDisplayed(WebElement e){
        return elementDisplayed(e);
    }
    public boolean rightMessageIsDisplayed(WebElement e, String message){
        return e.getText().equalsIgnoreCase(message);
    }
}
