package test.java.testCases;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import test.java.utilities.ReadConfig;

import java.io.File;
import java.io.IOException;


public class baseClass {
    ReadConfig config = new ReadConfig();
    public String baseURL = config.readURL();
    WebDriver driver;
    public static Logger logger;

    public baseClass() throws IOException {
    }

    @BeforeClass
    public void setup(){
        if (System.getProperty("browser").equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver");
            driver = new ChromeDriver();
        }
        else if (System.getProperty("browser").equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/driver/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        logger = Logger.getLogger("Automation");
        PropertyConfigurator.configure("Log4j.properties");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public void screenCapture(WebDriver driver, String testName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"/Screenshots/"+testName+".png");
        FileUtils.copyFile(source,target);
        System.out.println("Screenshot Captured");
        System.out.println("Screenshot Name -- "+System.getProperty("user.dir")+"/Screenshots/"+testName+".png");
    }

}
