package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.pages.homePage;
import test.java.pages.registerUserPage;
import test.java.utilities.ReadConfig;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class test05_verifyProgressBar extends BaseClass{
    ReadConfig config = new ReadConfig();

    public test05_verifyProgressBar() throws IOException {
    }

    @Test
    public void test_verifyProgressBarBox() throws InterruptedException, IOException {
        homePage hp = new homePage(driver);
        registerUserPage rup = new registerUserPage(driver);
        hp.clickonShowProgress(driver);
        screenCapture(driver,"verifyProgressBarBox");
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Boolean result = rup.verifyAllFields(driver);
        Assert.assertTrue(result,"Fields are Not Visible Properly");
    }
}