package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.pages.homePage;
import test.java.utilities.ReadConfig;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class test07_verifyPopupWindow extends BaseClass{
    ReadConfig config = new ReadConfig();

    public test07_verifyPopupWindow() throws IOException {
    }

    @Test
    public void test_verifyPopup() throws InterruptedException, IOException {
        homePage hp = new homePage(driver);
        hp.clickonPopup(driver);
    }
}