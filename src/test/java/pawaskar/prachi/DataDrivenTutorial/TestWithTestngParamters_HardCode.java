package pawaskar.prachi.DataDrivenTutorial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pawaskar.prachi.DataDrivenTutorial.pages.DefaultPageAfterLogin;
import pawaskar.prachi.DataDrivenTutorial.pages.HomePage;
import pawaskar.prachi.DataDrivenTutorial.pages.LoginHomePage;

import static org.testng.Assert.assertTrue;

public class TestWithTestngParamters_HardCode extends BaseTest {

    /*** TestNG file: testng_HardCodedTestngParams.xml ***/

    //Declarations
    HomePage homePage;
    LoginHomePage loginHomePage;
    DefaultPageAfterLogin defaultPageAfterLogin;


    //Test takes input from TestNG parameters, name of the parameter should be matched
    //Run the test to login and verify that the dashboard is loaded by default
    @Test
    @Parameters({"paramUsername","paramPassword"})
    public void verifyLogin(String username, String password) throws InterruptedException {
        //Home Page actions
        homePage = new HomePage(driver);
        homePage.goToSignInPage();
        //Login page actions
        loginHomePage = new LoginHomePage(driver);
        //Username and password value is hardcoded in the test
        loginHomePage.login(username,password);
        //Default landing page options
        defaultPageAfterLogin = new DefaultPageAfterLogin(driver);
        Boolean isDisplayed = false;
        try {
            isDisplayed = defaultPageAfterLogin.verifyLandingPage();
        }catch (Exception e){// Do nothing
        }
        assertTrue(isDisplayed);
    }

    //Test takes input from TestNG parameters, name of the parameter should be matched
    //This test will fail as wrong credentials are used.
    @Test
    @Parameters({"wrongUsername","wrongPassword"})
    public void verifyLoginWrongCredentials(String username, String password) throws InterruptedException {
        //Above same test logic is used.
        verifyLogin(username,password);
    }

}
