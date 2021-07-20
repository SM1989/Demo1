package test.java.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {
    WebDriverWait wait;

    public homePage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver,10);

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

    public String verifyTitle() {
        String title = pageTitle.getText();
        return title;
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
}
