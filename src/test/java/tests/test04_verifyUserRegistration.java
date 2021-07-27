package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.pages.homePage;
import test.java.pages.registerUserPage;
import test.java.pages.webViewPage;
import test.java.utilities.ReadConfig;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class test04_verifyUserRegistration extends BaseClass{
    ReadConfig config = new ReadConfig();

    public test04_verifyUserRegistration() throws IOException {
    }

    @Test
    public void test_verifyUserRegistration() throws InterruptedException, IOException {

        homePage hp = new homePage(driver);
        registerUserPage rup = new registerUserPage(driver);
        hp.clickonRegisterUser();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String title = hp.verifyTitle();
        Assert.assertEquals(title,config.readData("pageTitle"));
        String welcome = rup.welcomeText();
        String defaultName = rup.prefilledName();
        String defaultProgrammingLanguage = rup.prefilledProgrammingLanguage();
        String changedProgrammingLanguage = rup.fillForm(driver);
        System.out.println("defaultName -- "+defaultName);
        System.out.println("defaultProgrammingLanguage -- "+defaultProgrammingLanguage);
        System.out.println("changedProgrammingLanguage -- "+changedProgrammingLanguage);
        List<String> actualResults = rup.verifyUserDetails();
        System.out.println("actualResults in TestCase-- "+actualResults);
        Assert.assertEquals(welcome,config.readData("welcomeMessage"));
        Assert.assertEquals(actualResults.toArray()[0],config.readData("name1"));
        Assert.assertEquals(actualResults.toArray()[1],config.readData("username"));
        Assert.assertEquals(actualResults.toArray()[2],config.readData("password"));
        Assert.assertEquals(actualResults.toArray()[3],config.readData("email"));
        Assert.assertEquals(actualResults.toArray()[4],config.readData("programingLanguage"));
        Assert.assertEquals(actualResults.toArray()[5],"true");
        screenCapture(driver,"verifyUserRegistration");
        rup.clickRegisterUser();
        Boolean home = hp.verifyHomepageDisplayed();
        Assert.assertTrue(home,"Home Screen is not displayed");
    }
}