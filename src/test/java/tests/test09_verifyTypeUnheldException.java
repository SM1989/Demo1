package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.pages.homePage;
import test.java.utilities.ReadConfig;

import java.io.IOException;

public class test09_verifyTypeUnheldException extends BaseClass{
    ReadConfig config = new ReadConfig();

    public test09_verifyTypeUnheldException() throws IOException {
    }

    @Test
    public void test_verifyTypeToException() throws InterruptedException, IOException {
        homePage hp = new homePage(driver);
        String text = hp.typeToUnhandledException(config.readData("name"), driver);
        System.out.println("text -- "+text);
        if (text.trim().equalsIgnoreCase(config.readData("exceptionText"))){
            System.out.println("exceptionText -- "+text);
            Assert.assertTrue(true);
        }
        else if (text.trim().equalsIgnoreCase(config.readData("exceptionTextNew"))){
            System.out.println("exceptionTextNew -- "+text);
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false,"exception message mismatch");
        }
    }
}