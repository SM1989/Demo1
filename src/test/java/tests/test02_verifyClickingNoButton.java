package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.pages.homePage;

import java.io.IOException;

public class test02_verifyClickingNoButton extends BaseClass{

    @Test
    public void test_verifyClickingEnNoButton() throws IOException {
        homePage hp = new homePage(driver);
        String pageTitle1 = hp.verifyTitle();
        hp.clickEnNo();
        screenCapture(driver,"verifyClickingNoButton");
        String pageTitle2= hp.verifyTitle();
        Assert.assertEquals(pageTitle1,pageTitle2);
    }
}
