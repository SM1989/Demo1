package test.java.testCases;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import test.java.pageObjects.controlgroupPage;
import test.java.pageObjects.homePage;

import java.io.IOException;

public class TC03_controlgroupMultiAction extends baseClass {
    controlgroupPage cg = new controlgroupPage(driver);

    public TC03_controlgroupMultiAction() throws IOException {
    }

    @Test
    public void multiSelect() throws IOException {
        homePage homePageObject = new homePage(driver);
        driver.get(baseURL);
        logger.info("Launched the URL");
        homePageObject.clickControlgroup();
        logger.info("Clicked on ControlGroup");
        cg.fillForm(driver);
        screenCapture(driver,"multiaction");
    }
}
