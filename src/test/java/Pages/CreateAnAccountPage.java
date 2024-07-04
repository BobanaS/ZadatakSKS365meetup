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
    @FindBy(linkText = "Create an Account")
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


}
