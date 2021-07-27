package test.java.pages;

import com.github.javafaker.Bool;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;


//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class homePage {
    WebDriverWait wait;

    public homePage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver,20);

    }

    @AndroidFindBy(id = "android:id/title")
    public WebElement pageTitle;
    @AndroidFindBy(id = "io.selendroid.testapp:id/buttonTest")
    public WebElement enButton;
    @AndroidFindBy(id = "android:id/button2")
    public WebElement noButton;
    @AndroidFindBy(id = "io.selendroid.testapp:id/buttonStartWebview")
    public WebElement webIcon;
    @AndroidFindBy(id = "io.selendroid.testapp:id/startUserRegistration")
    public WebElement userRegistration;
    @AndroidFindBy(id = "io.selendroid.testapp:id/my_text_field")
    public WebElement textField;
    @AndroidFindBy(id = "io.selendroid.testapp:id/waitingButtonTest")
    public WebElement showProgress;
    @AndroidFindBy(id = "io.selendroid.testapp:id/waitingButtonTest")
    public WebElement checkBox;
    @AndroidFindBy(id = "io.selendroid.testapp:id/visibleButtonTest")
    public WebElement displayText;
    @AndroidFindBy(id = "io.selendroid.testapp:id/showToastButton")
    public WebElement displayAToast;
    @AndroidFindBy(id = "io.selendroid.testapp:id/showPopupWindowButton")
    public WebElement displayPopup;
    @AndroidFindBy(id = "io.selendroid.testapp:id/exceptionTestButton")
    public WebElement pressToThrow;
    @AndroidFindBy(id = "io.selendroid.testapp:id/exceptionTestField")
    public WebElement typeToThrow;
    @AndroidFindBy(id = "io.selendroid.testapp:id/topLevelElementTest")
    public WebElement displayAndFocus;
    @AndroidFindBy(xpath = "//*[@class='android.widget.FrameLayout']")
    public WebElement dialogBox;
    @AndroidFindBy(id = "android:id/message")
    public WebElement dialogBoxMessage;
    @AndroidFindBy(id = "io.selendroid.testapp:id/inputUsername")
    public WebElement username;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.Toast")
    public WebElement toast;
    String toastXpath = "/hierarchy/android.widget.Toast";
    @AndroidFindBy(id = "io.selendroid.testapp:id/showPopupWindowButton")
    public WebElement popupWindow;
    @AndroidFindBy(id = "android:id/alertTitle")
    public WebElement appCrashException;




    public String verifyTitle() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        String title = pageTitle.getText();
        return title;
    }

    public Boolean verifyHomepageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(enButton));
            enButton.isDisplayed();
            System.out.println("Home Screen is displayed");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean verifyElements() {
        try {
            enButton.isDisplayed();
            webIcon.isDisplayed();
            userRegistration.isDisplayed();
            textField.isDisplayed();
            showProgress.isDisplayed();
            checkBox.isDisplayed();
            displayText.isDisplayed();
            displayAToast.isDisplayed();
            displayPopup.isDisplayed();
            pressToThrow.isDisplayed();
            typeToThrow.isDisplayed();
            displayAndFocus.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickEnNo(){
        enButton.click();
        wait.until(ExpectedConditions.visibilityOf(noButton));
        noButton.click();
    }
    public void clickonWebIcon(){
        webIcon.click();
    }
    public void clickonRegisterUser(){
        userRegistration.click();
    }
    public void clickonShowProgress(AppiumDriver<MobileElement> driverr){
        showProgress.click();
        System.out.println("dialogBoxMessage -- "+dialogBoxMessage.getText());
        wait.until(ExpectedConditions.visibilityOf(username));
        System.out.println("Dialog Box Dissappeared");
    }
    public String clickonDisplayToast(AppiumDriver<MobileElement> driverr){
        displayAToast.click();
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(toastXpath))));
        String toastMessage = toast.getText();
        System.out.println("toastMessage -- "+toastMessage);
        return toastMessage;
    }
    public void clickonPopup(AppiumDriver<MobileElement> driverr) throws InterruptedException {
        TouchAction touchAction=new TouchAction(driverr);
        displayPopup.click();
        wait.until(ExpectedConditions.visibilityOf(popupWindow));
        System.out.println("popupWindow displayed");
        Thread.sleep(2000);
        Set<String> contextNames = driverr.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }

//        switcActivity(driverr);
//        System.out.println("Switched Activity--");
//        driverr.findElement(By.id("io.selendroid.testapp:id/popup_dismiss_button")).click();
        Thread.sleep(2000);
        touchAction.press(PointOption.point(360, 846)).release().perform();
        System.out.println("Dismissed");
        Thread.sleep(2000);
    }

    public String clickToUnhandledException(AppiumDriver<MobileElement> driverr) throws InterruptedException {
        pressToThrow.click();
        System.out.println("Clicked on the button");
        wait.until(ExpectedConditions.visibilityOf(appCrashException));
        System.out.println("Exception Title -- "+appCrashException.getText());
        return appCrashException.getText();
    }

    public String typeToUnhandledException(String text,AndroidDriver<MobileElement> driverr) throws InterruptedException {
        typeToThrow.click();
        driverr.pressKey(new KeyEvent(AndroidKey.A));
        wait.until(ExpectedConditions.visibilityOf(appCrashException));
        System.out.println("Exception Title -- "+appCrashException.getText());
        return appCrashException.getText();
    }

    public void switcActivity(AppiumDriver<MobileElement> driverrr) {
        try {
            System.out.println("Try Block");
            System.out.println("Package -- "+((AndroidDriver) driverrr).getCurrentPackage());
            System.out.println("Activity -- "+((AndroidDriver) driverrr).currentActivity());
            Activity act = new Activity("io.selendroid.testapp", "io.selendroid.testapp.PopupWindow:3a9fe1c");
            ((AndroidDriver) driverrr).startActivity(act);
            System.out.println("Switched Activity");
        }
        catch (Exception exc){
            System.out.println("Catch Block");
            System.out.println("Package -- "+((AndroidDriver) driverrr).getCurrentPackage());
            System.out.println("Activity -- "+((AndroidDriver) driverrr).currentActivity());
            Activity act = new Activity("io.selendroid.testapp", "io.selendroid.testapp.PopupWindow:666e008");
            ((AndroidDriver) driverrr).startActivity(act);
            System.out.println("Switched Activity in Catch Block");
        }
    }
}
