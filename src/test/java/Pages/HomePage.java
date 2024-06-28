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


    @FindBy(className = "authorization-link")
    public List<WebElement> links;

    //-----------------------------------
    public boolean linksAreThere() {
        return elementDisplayed(links.get(0));
    }

    public void clickOnLink(String option) {
        for (WebElement opcija : links) {
            if (opcija.getText().equals(option)) {
                opcija.click();
                break;
            }

        }
    }
}