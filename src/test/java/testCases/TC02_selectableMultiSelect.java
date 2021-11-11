package test.java.testCases;

import org.testng.annotations.Test;
import test.java.pageObjects.droppablePage;
import test.java.pageObjects.homePage;
import test.java.pageObjects.selectablePage;
import test.java.utilities.ReadConfig;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class TC02_selectableMultiSelect extends baseClass {

    ReadConfig config = new ReadConfig();

    public TC02_selectableMultiSelect() throws IOException {
    }

    @Test
    public void multiSelect() throws InterruptedException, AWTException, IOException {
        homePage homePageObject = new homePage(driver);
        selectablePage select = new selectablePage(driver);
        driver.get(baseURL);
        logger.info("Launched the URL");
        homePageObject.clickSelectable();
        logger.info("Clicked on Selectable");
        screenCapture(driver,"multiselect1");
        select.selectOptions(driver);
        screenCapture(driver,"multiselect2");
    }
}
