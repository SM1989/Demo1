package test.java.testCases;


import org.testng.annotations.Test;
import test.java.pageObjects.droppablePage;
import test.java.pageObjects.homePage;
import org.testng.Assert;
import test.java.utilities.ReadConfig;


import java.io.IOException;

public class TC01_scalableDragAndDrop extends baseClass {
    ReadConfig config = new ReadConfig();
    public String droppedText = config.readDroppedText();

    public TC01_scalableDragAndDrop() throws IOException {
    }

    @Test
    public void dragAndDrop() throws InterruptedException, IOException {
        homePage homePageObject = new homePage(driver);
        droppablePage drop = new droppablePage(driver);
        driver.get(baseURL);
        logger.info("Launched the URL");
        homePageObject.clickDroppable();
        logger.info("Clicked on Dropable");
        drop.dragDrop(driver);
        screenCapture(driver,"draganddrop");
    }

}
