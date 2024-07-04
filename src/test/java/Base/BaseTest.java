package Base;

import Pages.AccountPage;
import Pages.CreateAnAccountPage;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
//Sajt za testiranje: https://magento.softwaretestingboard.com/

    public static WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public CreateAnAccountPage createAnAccountPage;
    public AccountPage accountPage;
    public String homePageURL = "https://magento.softwaretestingboard.com/";
    public String createAnAccountPageURL = "https://magento.softwaretestingboard.com/customer/account/create/";
    public String accountPageURL="https://magento.softwaretestingboard.com/customer/account/";

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
    }

    /*
    Scrolls to the specified web element on the page.
    This method ensures that the element is brought into view so it can be interacted with.
     */
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    /*
      Waits for the specified web element to become visible on the page.
      This method will repeatedly check the visibility status of the element
      until it is visible or a timeout occurs.
      */
    public void waitForElementVisibility(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

    }

    /*
      Automates the login process for a test user.
      This method inputs credentials, and then clicks the create account  button.
      It is used to quickly log in a standard test user for automated tests.
     */
   public void testcreateAccount() {
        createAnAccountPage.inputFirstname("Bobana");
        createAnAccountPage.inputLastname("Simikic");
        createAnAccountPage.inputemail("bobi@simi.com");
        createAnAccountPage.inputPassword("bobi.QA1");
        createAnAccountPage.inputConfirmpassword("bobi.QA1");
        createAnAccountPage.clickOnButton();
    }
    /*
      Checks if the specified web element is displayed on the page.
      This method returns true if the element is visible, and false otherwise.
     */
    public boolean elementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    /*
    This method is executed once after all test methods in this class have been run.
    It closes driver
     */
      @AfterClass
    public void theEndOfAllTest() {
    //    driver.quit();
    }

}

