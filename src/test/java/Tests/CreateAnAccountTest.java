package Tests;

import Base.BaseTest;
import Pages.AccountPage;
import Pages.CreateAnAccountPage;
import Pages.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAnAccountTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(homePageURL);
        homePage = new HomePage();
        createAnAccountPage= new CreateAnAccountPage();
        accountPage=new AccountPage();
        homePage.clickOnCreateAnAccount();
    }
    @Test(priority = 10)
    public void userisOnCreateAnAccountPage(){
        Assert.assertEquals(driver.getCurrentUrl(), createAnAccountPageURL);
        Assert.assertTrue(createAnAccountPage.buttonIsDIsplayed());
    }
    @Test(priority = 20)
    public void userClickOnCreateAccountButton(){
        createAnAccountPage.clickOnButton();
        Assert.assertEquals(driver.getCurrentUrl(), createAnAccountPageURL);
        Assert.assertTrue(createAnAccountPage.buttonIsDIsplayed());
        Assert.assertTrue(createAnAccountPage.messageisDisplayed(createAnAccountPage.firstnameerror));
        Assert.assertTrue(createAnAccountPage.rightMessageIsDisplayed(createAnAccountPage.firstnameerror, createAnAccountPage.errorMessage));
    }
    @Test(priority = 30)
    public void userInputonlyFirstNameAndClickAccountButton(){
        createAnAccountPage.inputFirstname("Bobana");
        createAnAccountPage.clickOnButton();
        Assert.assertEquals(driver.getCurrentUrl(), createAnAccountPageURL);
        Assert.assertTrue(createAnAccountPage.messageisDisplayed(createAnAccountPage.lastnameerror));
        Assert.assertTrue(createAnAccountPage.rightMessageIsDisplayed(createAnAccountPage.lastnameerror, createAnAccountPage.errorMessage));
    }
    @Test(priority = 40)
    public void userInputonlyFirstAndLastNameAndClickAccountButton(){
        createAnAccountPage.inputFirstname("Bobana");
        createAnAccountPage.inputLastname("Simikic");
        createAnAccountPage.clickOnButton();
        Assert.assertEquals(driver.getCurrentUrl(), createAnAccountPageURL);
        Assert.assertTrue(createAnAccountPage.messageisDisplayed(createAnAccountPage.emailaddresserror));
        Assert.assertTrue(createAnAccountPage.rightMessageIsDisplayed(createAnAccountPage.emailaddresserror, createAnAccountPage.errorMessage));
    }
    @Test (priority = 50)

    public void userTrytoInputInvalidMail(){
        createAnAccountPage.inputFirstname("Bobana");
        createAnAccountPage.inputLastname("Simikic");
        createAnAccountPage.inputemail("bob");
        createAnAccountPage.clickOnButton();
        Assert.assertEquals(driver.getCurrentUrl(), createAnAccountPageURL);
        Assert.assertTrue(createAnAccountPage.messageisDisplayed(createAnAccountPage.emailaddresserror));
        Assert.assertTrue(createAnAccountPage.rightMessageIsDisplayed(createAnAccountPage.emailaddresserror, createAnAccountPage.errorMailMessage));
    }
    @Test(priority=60)
    public void userTrytoInputInvalidMailWithSignOnly(){
        createAnAccountPage.inputFirstname("Bobana");
        createAnAccountPage.inputLastname("Simikic");
        createAnAccountPage.inputemail("bob@");
        createAnAccountPage.clickOnButton();
        Assert.assertEquals(driver.getCurrentUrl(), createAnAccountPageURL);
        Assert.assertTrue(createAnAccountPage.messageisDisplayed(createAnAccountPage.emailaddresserror));
        Assert.assertTrue(createAnAccountPage.rightMessageIsDisplayed(createAnAccountPage.emailaddresserror, createAnAccountPage.errorMailMessage));
    }
    @Test(priority=70)
    public void userTrytoInputInvalidMailWithoutcom(){
        createAnAccountPage.inputFirstname("Bobana");
        createAnAccountPage.inputLastname("Simikic");
        createAnAccountPage.inputemail("bob@simi");
        createAnAccountPage.clickOnButton();
        Assert.assertEquals(driver.getCurrentUrl(), createAnAccountPageURL);
        Assert.assertTrue(createAnAccountPage.messageisDisplayed(createAnAccountPage.emailaddresserror));
        Assert.assertTrue(createAnAccountPage.rightMessageIsDisplayed(createAnAccountPage.emailaddresserror, createAnAccountPage.errorMailMessage));
    }
    @Test(priority=80)
    public void userTrytoCreateAccountWithoutPassword(){
        createAnAccountPage.inputFirstname("Bobana");
        createAnAccountPage.inputLastname("Simikic");
        createAnAccountPage.inputemail("bob@simi.com");
        createAnAccountPage.clickOnButton();
        Assert.assertEquals(driver.getCurrentUrl(), createAnAccountPageURL);
        Assert.assertTrue(createAnAccountPage.messageisDisplayed(createAnAccountPage.passworderror));
        Assert.assertTrue(createAnAccountPage.rightMessageIsDisplayed(createAnAccountPage.passworderror, createAnAccountPage.errorMessage));
    }
    @Test(priority=90)
    public void userTrytoCreateAccountWithoutconfirmPassword(){
        createAnAccountPage.inputFirstname("Bobana");
        createAnAccountPage.inputLastname("Simikic");
        createAnAccountPage.inputemail("bob@simi.com");
        createAnAccountPage.inputPassword("bobi.QA1");
        createAnAccountPage.clickOnButton();
        Assert.assertEquals(driver.getCurrentUrl(), createAnAccountPageURL);
        Assert.assertTrue(createAnAccountPage.messageisDisplayed(createAnAccountPage.passwordconfirmationerror));
        Assert.assertTrue(createAnAccountPage.rightMessageIsDisplayed(createAnAccountPage.passwordconfirmationerror, createAnAccountPage.errorMessage));
    }
    @Test(priority=100)
    public void userTrytoCreateAccountWithDiffrentconfirmPassword(){
        createAnAccountPage.inputFirstname("Bobana");
        createAnAccountPage.inputLastname("Simikic");
        createAnAccountPage.inputemail("bob@simi.com");
        createAnAccountPage.inputPassword("bobi.QA1");
        createAnAccountPage.inputConfirmpassword("BOBI.QA1");
        createAnAccountPage.clickOnButton();
        Assert.assertEquals(driver.getCurrentUrl(), createAnAccountPageURL);
        Assert.assertTrue(createAnAccountPage.messageisDisplayed(createAnAccountPage.passwordconfirmationerror));
        Assert.assertTrue(createAnAccountPage.rightMessageIsDisplayed(createAnAccountPage.passwordconfirmationerror, createAnAccountPage.errorConfirmMessage));
    }
    @Test(priority=110)
    public void userCreateValidAccount(){
        createAnAccountPage.inputFirstname("Bobana");
        createAnAccountPage.inputLastname("Simikic");
        createAnAccountPage.inputemail("bobii@simi.com");
        createAnAccountPage.inputPassword("bobi.QA1");
        createAnAccountPage.inputConfirmpassword("bobi.QA1");
        createAnAccountPage.clickOnButton();
        Assert.assertEquals(driver.getCurrentUrl(), accountPageURL);
        Assert.assertTrue(accountPage.myAccountIsThere());
        Assert.assertTrue(accountPage.loggedInMessageContainsFirstAndLastUserName("Bobana"));

    }
}
