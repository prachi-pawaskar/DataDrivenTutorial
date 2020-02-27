package pawaskar.prachi.DataDrivenTutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pawaskar.prachi.DataDrivenTutorial.pages.DefaultPageAfterLogin;
import pawaskar.prachi.DataDrivenTutorial.pages.HomePage;
import pawaskar.prachi.DataDrivenTutorial.pages.LoginHomePage;

import java.io.File;

import static org.testng.Assert.assertTrue;

//BaseTest have @BeforeTest and @AfterTest, also the driver declaration
public class TestsToExecuteWithoutExternalData extends BaseTest {


    /*** TestNG file: testng_WithoutExternalData.xml ***/
    
    //Declarations
    HomePage homePage;
    LoginHomePage loginHomePage;
    DefaultPageAfterLogin defaultPageAfterLogin;
    

    //Run the test to login and verify that the dashboard is loaded by default
    @Test
    public void verifyLogin() throws InterruptedException {
        //Home Page actions
        homePage = new HomePage(driver);
        homePage.goToSignInPage();
        //Login page actions
        loginHomePage = new LoginHomePage(driver);
        //Username and password value is hardcoded in the test
        loginHomePage.login("username","password");
        //Default landing page options
        defaultPageAfterLogin = new DefaultPageAfterLogin(driver);
        Boolean isDisplayed = false;
        try {
            isDisplayed = defaultPageAfterLogin.verifyLandingPage();
        }catch (Exception e){// Do nothing
        }
        assertTrue(isDisplayed);
    }

}
