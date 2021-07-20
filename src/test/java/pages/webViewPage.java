package test.java.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.utilities.ReadConfig;

import java.io.IOException;

public class webViewPage {
    WebDriverWait wait;
    ReadConfig config = new ReadConfig();


    public webViewPage(AppiumDriver<MobileElement> driver) throws IOException {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver,10);
    }

    @AndroidFindBy(id = "io.selendroid.testapp:id/mainWebView")
    public WebElement webView;
    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement name_input;
    @AndroidFindBy(xpath = "(//*[@class='android.widget.Spinner'])[2]")
    public WebElement dropdown;
    @AndroidFindBy(xpath = "(//*[@class='android.widget.Button'])[2]")
    public WebElement sendButton;
    @AndroidFindBy(xpath = "(//*[@class='android.widget.CheckedTextView'])[2]")
    public WebElement mercedes;
    @AndroidFindBy(xpath = "(//*[@class='android.view.View'])[4]")
    public WebElement nameAfter;
    @AndroidFindBy(xpath = "(//*[@class='android.view.View'])[6]")
    public WebElement carAfter;
    @AndroidFindBy(xpath = "(//*[@class='android.view.View'])[10]")
    public WebElement click;


    public Boolean verifywebViewDisplayed() {
        Boolean diplayed = webView.isDisplayed();
        return diplayed;
    }
    public void fillForm() throws InterruptedException {
        name_input.sendKeys(config.readData("name"));
        dropdown.click();
        Thread.sleep(2000);
        mercedes.click();
        sendButton.click();
        Thread.sleep(2000);
    }
    public String verifyName(){
        String name = nameAfter.getText().trim();
        System.out.println("name -- "+name);
        return name;
    }
    public String verifyCar(){
        String car = carAfter.getText().trim();
        System.out.println("car -- "+car);
        return car;
    }
    public void clickHere() throws InterruptedException {
        click.click();
        Thread.sleep(2000);
    }

}