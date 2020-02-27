package pawaskar.prachi.DataDrivenTutorial.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    // List all the elements to be used from the page
    WebDriver driver;
    By signinButton = By.id("signin_button");


    // Constructor to initialize the driver
    public  HomePage(WebDriver driver){
        //Links the driver from test class and the driver from this class
        this.driver = driver;
    }

    //Go to Sign-in page
    public void goToSignInPage(){
        //enter user name
        driver.findElement(signinButton).click();
    }

}
