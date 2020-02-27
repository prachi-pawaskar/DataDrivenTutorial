package pawaskar.prachi.DataDrivenTutorial.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHomePage {

    // List all the elements to be used from the page
    WebDriver driver;
    By usernameElement = By.id("user_login");
    By passwordElement = By.id("user_password");
    By loginButtonElement = By.xpath("//*[@value=\"Sign in\"]");


    // Constructor to initialize the driver
    public  LoginHomePage(WebDriver driver){
        //Links the driver from test class and the driver from this class
        this.driver = driver;
    }


    //Enter user name in text box
    //Internal method
    public void enterUsername(String username){
        //enter user name
        driver.findElement(usernameElement).sendKeys(username);
    }

    //Enter password in text box
    //Internal method
    public void enterPassword(String password){
        //enter password
        driver.findElement(passwordElement).sendKeys(password);
    }

    //Click login
    //Internal method
    public void clickLogin(){
        driver.findElement(loginButtonElement).click();
    }

    //Method to login. This combines all the above internal methods
    //Tests will call this single method to execute login functionality
    public void login(String username,String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }



}
