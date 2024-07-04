package Tests;

import Base.BaseTest;
import Pages.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAnAccountTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(homePageURL);
        homePage = new HomePage();
        homePage.clickOnCreateAnAccount();
    }
    @Test(priority = 10)
    public void userisOnCreateAnAccounPage(){

    }
}
