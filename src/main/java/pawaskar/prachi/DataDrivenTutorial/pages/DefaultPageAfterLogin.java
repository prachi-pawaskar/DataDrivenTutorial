package pawaskar.prachi.DataDrivenTutorial.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DefaultPageAfterLogin {

    // List all the elements to be used from the page
    WebDriver driver;
    By accountsSummaryTab = By.xpath("//ul/li[@id=\"account_summary_tab\"]/a");

    // Constructor to initialize the driver
    public  DefaultPageAfterLogin(WebDriver driver){
        //Links the driver from test class and the driver from this class
        this.driver = driver;
    }

    //Method to verify that the login
    //Tests will call this single method to execute login functionality
    public Boolean verifyLandingPage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        Boolean isDisplayed = driver.findElement(accountsSummaryTab).isDisplayed();

        return isDisplayed;
    }

}
