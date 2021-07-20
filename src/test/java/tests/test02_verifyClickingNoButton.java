package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.pages.homePage;

public class test02_verifyClickingNoButton extends BaseClass{

    @Test
    public void test_verifyClickingEnNoButton(){
        homePage hp = new homePage(driver);
        String pageTitle1 = hp.verifyTitle();
        hp.clickEnNo();
        String pageTitle2= hp.verifyTitle();
        Assert.assertEquals(pageTitle1,pageTitle2);
    }
}
