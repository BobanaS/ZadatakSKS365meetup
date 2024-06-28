package Tests;

import Base.BaseTest;
import Pages.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest extends BaseTest {
     /*
      Setup method executed before each test method.
      Initializes WebDriver, maximizes window, navigates to the SauceDemo homepage,
      initializes WebDriverWait, and initializes page objects.
      Logs in the user to prepare for tests.
     */

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(homePageURL);
        homePage = new HomePage();

    }

    @Test
    public void userIsOnHomePage() {

    }
    /*@AfterMethod
    public void closetab(){
        driver.close();
    }
*/
}
