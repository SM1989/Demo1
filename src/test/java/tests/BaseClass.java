package test.java.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import test.java.utilities.ReadConfig;

import java.io.IOException;
import java.net.URL;

public class BaseClass {
//    AppiumDriver<MobileElement> driver;
    AndroidDriver<MobileElement> driver;


    @BeforeClass
    public void setup() throws IOException {
        ReadConfig config = new ReadConfig();
        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        //caps.setCapability(MobileCapabilityType.APP, "src/test/resources/apps/selendroid-test-app.apk");
        //caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        String deviceName = config.readData("deviceName");
        String uuid = config.readData("uuid");
        String platformVersion = config.readData("platformVersion");
        String appPackage = config.readData("appPackage");
        String appActivity = config.readData("appActivity");
        String urlData = config.readData("url");


        caps.setCapability("deviceName", deviceName);
        caps.setCapability("uuid", uuid);
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);
        caps.setCapability("autoAcceptAlerts", true);
        caps.setCapability("autoDismissAlerts", true);
        URL url = new URL(urlData);
//        driver = new AppiumDriver<MobileElement>(url,caps);
        driver = new AndroidDriver<MobileElement>(url,caps);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        System.out.println("Done");
    }
}
