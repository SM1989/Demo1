package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.pages.homePage;
import test.java.utilities.ReadConfig;

import java.io.IOException;

public class test01_verifyTitle extends BaseClass{


    @Test
    public void test_verifyTitle() throws IOException {
        ReadConfig config = new ReadConfig();
        homePage hp = new homePage(driver);
        String title = hp.verifyTitle();
        //String pageTitle = driver.getTitle();
        Boolean result = hp.verifyElements();
        screenCapture(driver,"verifyTitle");
        Assert.assertEquals(title,config.readData("pageTitle"));
        Assert.assertTrue(result,"Items are not Displayed");
    }
}
