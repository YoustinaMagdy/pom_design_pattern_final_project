package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    ChromeDriver driver;

    @BeforeMethod
    public void setup_initiateDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://www.automationexercise.com/");
    }

    @AfterMethod
    public void a_takeScreenshotForFailedTests(ITestResult result) {
        String destination = "./screenshots/" + result.getName() + ".png";
        if (result.getStatus() == 2) {
            File screenshot = (File)((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(screenshot, new File(destination));
            } catch (IOException var5) {
                var5.printStackTrace();
            }
        }

    }

    @AfterMethod
    public void z_quitDriver()
    {
    driver.quit();
    }
}
