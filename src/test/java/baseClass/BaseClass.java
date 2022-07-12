package baseClass;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.GuruLoginPage;
import pages.SuccessFullLoginMessage;

import java.io.File;
import java.io.IOException;

public class BaseClass {
    WebDriver driver;
    protected GuruLoginPage loginPage;
    protected SuccessFullLoginMessage message;

    @BeforeSuite
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/login.html");
        loginPage = new GuruLoginPage(driver);
        message = new SuccessFullLoginMessage(driver);
    }

    @AfterMethod
    public void takeFailureScreenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var getScreenShot = (TakesScreenshot) driver;
            File screenShot = getScreenShot.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenShot, new File("src/test/resources/screenShots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.getStackTrace();
                e.getMessage();
            }
        }
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
