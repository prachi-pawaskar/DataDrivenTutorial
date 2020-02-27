package pawaskar.prachi.DataDrivenTutorial;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;


public class BaseTest {

    WebDriver driver;

    //Runs once before every Test METHOD
    @BeforeMethod
    public void beforeTest(){
        //Get the driver path
        String resourceFilePath = "src/main/java/pawaskar/prachi/DataDrivenTutorial/drivers";
        String resourceURL = new File(resourceFilePath).getAbsolutePath();
        //Set the driver path
        System.setProperty("webdriver.chrome.driver", resourceURL +"/chromedriver.exe");
        //Initialize browser
        // To disable pop up: Loading of unpacked extensions is disabled by the administrator
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/index.html");
    }

    //Shut down the browser
    @AfterMethod
    public void afterTest(){
        driver.close();
    }

}
