package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.pages.homePage;
import test.java.utilities.ReadConfig;

import java.io.IOException;
import java.util.Set;

public class test08_verifyPressUnheldException extends BaseClass{
    ReadConfig config = new ReadConfig();

    public test08_verifyPressUnheldException() throws IOException {
    }

    @Test
    public void test_verifyPressToException() throws InterruptedException, IOException {
        homePage hp = new homePage(driver);
        String text = hp.clickToUnhandledException(driver);
        screenCapture(driver,"verifyPressToException");
        Assert.assertEquals(text,config.readData("exceptionText"));
    }
}