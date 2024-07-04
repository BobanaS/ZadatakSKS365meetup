package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(linkText = "Create an Account")
    public WebElement link;

    //-----------------------------------
    public boolean linksAreThere() {
        return elementDisplayed(link);
    }

    public void clickOnCreateAnAccount(){
        link.click();
    }


}