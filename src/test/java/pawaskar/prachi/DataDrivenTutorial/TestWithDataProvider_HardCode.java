package pawaskar.prachi.DataDrivenTutorial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pawaskar.prachi.DataDrivenTutorial.pages.DefaultPageAfterLogin;
import pawaskar.prachi.DataDrivenTutorial.pages.HomePage;
import pawaskar.prachi.DataDrivenTutorial.pages.LoginHomePage;

import static org.testng.Assert.assertTrue;

public class TestWithDataProvider_HardCode extends BaseTest {

    /*** TestNG file: testng_HardCodedDataProvider.xml ***/

    //Declarations
    HomePage homePage;
    LoginHomePage loginHomePage;
    DefaultPageAfterLogin defaultPageAfterLogin;


    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                { "username", "password" } // This combination should pass
                ,{ "testuser_1", "Test@123" } // This combination should fail
        };
    }

    //Test takes input from dataprovider above, it runs based on the number of combinations.
    //Run the test to login and verify that the dashboard is loaded by default
    @Test (dataProvider = "Authentication")
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

}
