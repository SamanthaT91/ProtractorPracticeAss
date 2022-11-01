package baseTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    private WebDriver driver;
   protected static HomePage homePage;

@BeforeClass
    public  void setup(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
        System.out.println("Title name " + driver.getTitle());
       homePage = new HomePage(driver);
    }
    @AfterMethod
    public void captureScreenshot(ITestResult testResult) {

    if(ITestResult.FAILURE == testResult.getStatus()){
    TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/FailureScreens/" + testResult.getName()+ " _ " + testResult.getStartMillis() +".png");
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
    else{
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/PassResults/" + testResult.getName()+ " _ " + testResult.getStartMillis() +".png");
        try {
            FileHandler.copy(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

    @AfterClass
    public void teardown() {
        driver.quit();
    }


}
