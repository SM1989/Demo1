package test.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class homePage {
    WebDriver driver;
    WebDriverWait wait;

    public homePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='sidebar']//a[contains(@href,'droppable')]")
    public WebElement droppable;
    @FindBy(xpath = "//div[@id='sidebar']//a[contains(@href,'selectable')]")
    public WebElement selectable;
    @FindBy(xpath = "//div[@id='sidebar']//a[contains(@href,'controlgroup')]")
    public WebElement controlgroup;

    public void clickDroppable(){
        droppable.click();
    }
    public void clickSelectable(){
        selectable.click();
    }
    public void clickControlgroup(){
        controlgroup.click();
    }
}
