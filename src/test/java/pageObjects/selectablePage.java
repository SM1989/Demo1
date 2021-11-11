package test.java.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import test.java.testCases.baseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class selectablePage{
    WebDriver driver;

    public selectablePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    String frame = "//iframe[@class='demo-frame']";
    String el1 = "(//ol[@id='selectable']/li)[1]";
    String el2 = "(//ol[@id='selectable']/li)[3]";
    String el3 = "(//ol[@id='selectable']/li)[7]";

    public void selectOptions(WebDriver driverr) throws InterruptedException, IOException {
        driverr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverr.switchTo().frame((driverr.findElement(By.xpath(frame))));
        Actions builder = new Actions(driverr);
        builder.keyDown(Keys.COMMAND).build().perform();
        driverr.findElement(By.xpath(el1)).click();
        driverr.findElement(By.xpath(el2)).click();
        driverr.findElement(By.xpath(el3)).click();
        Boolean result1 = driverr.findElement(By.xpath(el1)).getAttribute("class").contains("selected");
        Boolean result2 = driverr.findElement(By.xpath(el2)).getAttribute("class").contains("selected");
        Boolean result3 = driverr.findElement(By.xpath(el3)).getAttribute("class").contains("selected");
        System.out.println(driverr.findElement(By.xpath(el1)).getAttribute("class"));
        System.out.println(driverr.findElement(By.xpath(el2)).getAttribute("class"));
        System.out.println(driverr.findElement(By.xpath(el3)).getAttribute("class"));
        Assert.assertEquals(result1, Boolean.TRUE);
        Assert.assertEquals(result2, Boolean.TRUE);
        Assert.assertEquals(result3, Boolean.TRUE);
    }
}
