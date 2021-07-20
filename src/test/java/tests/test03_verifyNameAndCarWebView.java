package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.pages.homePage;
import test.java.pages.webViewPage;
import test.java.utilities.ReadConfig;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class test03_verifyNameAndCarWebView extends BaseClass{
    ReadConfig config = new ReadConfig();

    public test03_verifyNameAndCarWebView() throws IOException {
    }

    @Test
    public void test_verifyWebViewNameCar() throws InterruptedException, IOException {
        homePage hp = new homePage(driver);
        webViewPage wp = new webViewPage(driver);
        hp.clickonWebIcon();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wp.fillForm();
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }
        //driver.context(contextNames.toArray()[1].toString());
        String name = wp.verifyName();
        String car = wp.verifyCar();
        if (name.contains(config.readData("name"))){
            System.out.println("Name is matched");
        }
        else{
            Assert.fail( "Name is not matched");
            System.out.println("Name is not matched");
        }
        if (car.contains(config.readData("preferedCar"))){
            System.out.println("Car is matched");
        }
        else{
            Assert.fail( "Car is not matched");
            System.out.println("Name is not matched");
        }
        wp.clickHere();
        String title = hp.verifyTitle();
        Assert.assertEquals(title,config.readData("pageTitle"));
    }
}