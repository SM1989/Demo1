package test.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import test.java.utilities.ReadConfig;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class droppablePage {
    WebDriver driver;
    ReadConfig config = new ReadConfig();
    public String droppedText = config.readDroppedText();

    public droppablePage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver,this);
    }

    String frame = "//iframe[@class='demo-frame']";
    String el1 = "//div[@id='draggable']";
    String el2 = "//div[@id='droppable']";
    String el3 = "//div[@id='droppable']/p";

    public void dragDrop(WebDriver driverr) throws InterruptedException {
        driverr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverr.switchTo().frame((driverr.findElement(By.xpath(frame))));
        Actions builder = new Actions(driverr);
        Action dragAndDrop = builder.clickAndHold(driverr.findElement(By.xpath(el1))).moveToElement(driverr.findElement(By.xpath(el2))).release(driverr.findElement(By.xpath(el2))).build();
        dragAndDrop.perform();
        String text = driverr.findElement(By.xpath(el3)).getText();
        Assert.assertEquals(text, droppedText);
    }
}
