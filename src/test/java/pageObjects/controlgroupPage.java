package test.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class controlgroupPage {
    WebDriver driver;

    public controlgroupPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    String frame = "//iframe[@class='demo-frame']";
    String el1 = "//span[@id='car-type-button']";
    String el2 = "//li/div[@id='ui-id-4']";
    String el3 = "(//label/span[contains(@class,'ui-checkboxradio')])[3]";
    String el4 = "(//label/span[contains(@class,'ui-checkboxradio')])[5]";
    String el5 = "(//span/input[@class='ui-spinner-input'])[1]";
    String el6 = "(//label/span[contains(@class,'ui-checkboxradio')])[7]";
    String el7 = "(//label/span[contains(@class,'ui-checkboxradio')])[11]";
    String el8 = "(//span/input[@class='ui-spinner-input'])[2]";
    String el9 = "//button[@id='book']";

    public void fillForm(WebDriver driverr){
        driverr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverr.switchTo().frame((driverr.findElement(By.xpath(frame))));
        driverr.findElement(By.xpath(el1)).click();
        driverr.findElement(By.xpath(el2)).click();
        driverr.findElement(By.xpath(el3)).click();
        driverr.findElement(By.xpath(el4)).click();
        driverr.findElement(By.xpath(el5)).click();
        driverr.findElement(By.xpath(el5)).sendKeys("2");
        driverr.findElement(By.xpath(el6)).click();
        driverr.findElement(By.xpath(el7)).click();
        driverr.findElement(By.xpath(el8)).click();
        driverr.findElement(By.xpath(el8)).sendKeys("1");
        driverr.findElement(By.xpath(el9)).click();
    }
}
