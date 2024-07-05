package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountPage extends BaseTest {
    public AccountPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "page-title")
    public WebElement myAccount;
    @FindBy(className = "logged-in")
    public WebElement loggedInMessage;
    @FindBy (css = "body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.customer-welcome > span > button")
    public WebElement optionButton;
    @FindBy(css="body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.customer-welcome.active > div > ul")
    public List<WebElement> options;
    public String myAccounttxt="My Account";
    public String myWishListtxt="My Wish List";
    public String signOuttxt=" Sign Out ";
    //--------------------------------------
    public boolean myAccountIsDisplayed(){
        return elementDisplayed(myAccount);
    }
    public boolean myAccountIsThere(){
        return myAccount.getText().equalsIgnoreCase("My Account");
    }
    public boolean loggednMessageIsThere(){
        return  elementDisplayed(loggedInMessage);
    }
    public boolean loggedInMessageContainsFirstAndLastUserName(String firstNameLastName){
        return loggedInMessage.getText().contains(firstNameLastName);
    }
    public void optionButtonclick(){
        optionButton.click();
    }
    public boolean optionsDisplayed(){
        return options.get(0).isDisplayed();
    }
    public void clickOnSideBarItem(String option) {
        for(WebElement opcija : options) {
            if(opcija.getText().equalsIgnoreCase(option)) {
                opcija.click();
                break;

            }
        }
    }
}
