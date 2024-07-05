package Tests;

import Base.BaseTest;
import Pages.AccountPage;
import Pages.CreateAnAccountPage;
import Pages.HomePage;
import Pages.SignInPage;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignInTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(homePageURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage();
        accountPage = new AccountPage();
        signInPage = new SignInPage();
        homePage.clickOnSignIn();

    }

    @Test(priority = 10)
    public void userIsOnSignInPage() {
        Assert.assertEquals(driver.getCurrentUrl(), signInPageURL);
        Assert.assertTrue(signInPage.displayedSignIneButton());
        Assert.assertTrue(signInPage.displayedEmailField());

    }

    @Test(priority = 20)
    public void userClickOnSignInButtonWithoutInputCredentials() {
        signInPage.signInClick();
        Assert.assertTrue(signInPage.displayedSignIneButton());
        Assert.assertTrue(signInPage.errorMessageEmailDisplay());
        Assert.assertTrue(signInPage.errorMessageForInputisThere(signInPage.errorPassword));
    }

    @Test(priority = 30)
    public void userClickOnSignInButtonWithoutPassword() {
        signInPage.inputEmail("bobi@simi.com");
        signInPage.signInClick();
        Assert.assertTrue(signInPage.displayedSignIneButton());
        Assert.assertTrue(signInPage.errorPasswordDisplay());
        Assert.assertTrue(signInPage.errorMessageForInputisThere(signInPage.errorPassword));
    }

    @Test(priority = 40)
    public void userClickOnSignInButtonWithInvalidMail() {
        signInPage.inputEmail("bob");
        signInPage.signInClick();
        Assert.assertTrue(signInPage.displayedSignIneButton());
        Assert.assertTrue(signInPage.errorMailMessageisThere());
        Assert.assertTrue(signInPage.errorPasswordDisplay());
        Assert.assertTrue(signInPage.errorMessageForInputisThere(signInPage.errorPassword));
    }

    @Test(priority = 50)
    public void userClickOnSignInButtonWithWrongPassword() {
        signInPage.inputEmail("bobi@simi.com");
        signInPage.inputPassword("false");
        signInPage.signInClick();
        Assert.assertTrue(signInPage.displayedSignIneButton());
        Assert.assertTrue(signInPage.noSuchAccount());
    }

    @Test(priority = 60)
    public void userClickOnSignInButtonWithWrongEmail() {
        signInPage.inputEmail("bbobi@simi.com");
        signInPage.inputPassword("bobi.QA1");
        signInPage.signInClick();
        Assert.assertTrue(signInPage.displayedSignIneButton());
        Assert.assertTrue(signInPage.noSuchAccount());
    }

    @Test(priority = 70)
    public void userSignInWithValidCredentials() {
        testerAcountloggIn();
        Assert.assertEquals(driver.getCurrentUrl(), homePageURL);
        waitForElementVisibility(signInPage.welcomeMessage);
        Assert.assertTrue(signInPage.welcomeUser("Bobana"));
    }

    @Test(priority = 80)
    public void userCanSignOut() {
        testerAcountloggIn();
        accountPage.optionButtonclick();
        signInPage.clickSignOutButton();
        Assert.assertEquals(driver.getCurrentUrl(), signOutPageURL);
    }

    @AfterMethod
    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }
}
