package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.pages.homePage;
import test.java.pages.registerUserPage;
import test.java.utilities.ReadConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class test06_verifyToastMessage extends BaseClass{
    ReadConfig config = new ReadConfig();

    public test06_verifyToastMessage() throws IOException {
    }

    @Test
    public void test_verifyToast() throws InterruptedException, IOException {
        homePage hp = new homePage(driver);
        //hp.clickonDisplayToast(driver);
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String toastText = hp.clickonDisplayToast(driver);
        screenCapture(driver,"verifyToast");
        Assert.assertEquals(toastText,config.readData("toastText"));
    }
}