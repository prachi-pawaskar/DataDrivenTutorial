package pawaskar.prachi.DataDrivenTutorial;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pawaskar.prachi.DataDrivenTutorial.pages.DefaultPageAfterLogin;
import pawaskar.prachi.DataDrivenTutorial.pages.HomePage;
import pawaskar.prachi.DataDrivenTutorial.pages.LoginHomePage;

import java.io.*;


import static org.testng.Assert.assertTrue;
import static pawaskar.prachi.DataDrivenTutorial.pages.Utils.readExcel;

public class TestWithDataProvider_Excel extends BaseTest {


    /*** TestNG file: testng_HardCodedDataProvider.xml ***/

    //Declarations
    HomePage homePage;
    LoginHomePage loginHomePage;
    DefaultPageAfterLogin defaultPageAfterLogin;





    @DataProvider(name = "Credentials")
    public static Object[][] credentials() throws IOException {
            return readExcel("src/main/resources/loginData.xlsx");
    }

    //Test takes input from dataprovider above, it runs based on the number of combinations.
    //Run the test to login and verify that the dashboard is loaded by default
    @Test(dataProvider = "Credentials")
    public void verifyLogin(String username, String password) throws InterruptedException {
        //Home Page actions
        homePage = new HomePage(driver);
        homePage.goToSignInPage();
        //Login page actions
        loginHomePage = new LoginHomePage(driver);
        //Username and password value is  in the test
        loginHomePage.login(username,password);
        //Default landing page options
        defaultPageAfterLogin = new DefaultPageAfterLogin(driver);
        //Handling the exception and not printing it. As assertion is done below.
        Boolean isDisplayed = false;
        try {
            isDisplayed = defaultPageAfterLogin.verifyLandingPage();
        }catch (Exception e){// Do nothing
            }
        assertTrue(isDisplayed);
    }


}
