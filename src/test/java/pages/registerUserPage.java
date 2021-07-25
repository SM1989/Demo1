package test.java.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.utilities.ReadConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class registerUserPage {
    WebDriverWait wait;
    ReadConfig config = new ReadConfig();


    public registerUserPage(AppiumDriver<MobileElement> driver) throws IOException {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver,10);
    }


    @AndroidFindBy(xpath = "(//*[@class='android.widget.TextView'])[2]")
    public WebElement welcomeMessage;
    @AndroidFindBy(id = "io.selendroid.testapp:id/inputUsername")
    public WebElement username;
    @AndroidFindBy(id = "io.selendroid.testapp:id/inputEmail")
    public WebElement email;
    @AndroidFindBy(id = "io.selendroid.testapp:id/inputPassword")
    public WebElement password;
    @AndroidFindBy(id = "io.selendroid.testapp:id/inputName")
    public WebElement name;
    @AndroidFindBy(id = "io.selendroid.testapp:id/input_preferedProgrammingLanguage")
    public WebElement defaultProgramingLanguage;
    @AndroidFindBy(id = "android:id/text1")
    public WebElement defaultProgramingLanguageValue;
    @AndroidFindBy(xpath = "(//*[@class='android.widget.CheckedTextView'])[2]")
    public WebElement changedProgramingLanguage;
    @AndroidFindBy(id = "io.selendroid.testapp:id/input_adds")
    public WebElement checkbox;
    @AndroidFindBy(id = "io.selendroid.testapp:id/btnRegisterUser")
    public WebElement registerUser;
    @AndroidFindBy(id = "io.selendroid.testapp:id/label_name_data")
    public WebElement nameVerify;
    @AndroidFindBy(id = "io.selendroid.testapp:id/label_username_data")
    public WebElement usernameVerify;
    @AndroidFindBy(id = "io.selendroid.testapp:id/label_password_data")
    public WebElement passwordVerify;
    @AndroidFindBy(id = "io.selendroid.testapp:id/label_email_data")
    public WebElement emailVerify;
    @AndroidFindBy(id = "io.selendroid.testapp:id/label_preferedProgrammingLanguage_data")
    public WebElement programingLanguageVerify;
    @AndroidFindBy(id = "io.selendroid.testapp:id/label_acceptAdds_data")
    public WebElement checkboxVerify;
    @AndroidFindBy(id = "io.selendroid.testapp:id/buttonRegisterUser")
    public WebElement registerUserButton;



    public String welcomeText(){
        String text = welcomeMessage.getText();
        return text;
    }
    public String prefilledName(){
        String text = name.getText();
        System.out.println("Prefilled Name is -- "+text);
        return text;
    }
    public String prefilledProgrammingLanguage(){
        String text = defaultProgramingLanguageValue.getText();
        System.out.println("Prefilled Programming Language is -- "+text);
        return text;
    }


    public String fillForm(AppiumDriver<MobileElement> driverr) throws InterruptedException {
        String text;
        driverr.hideKeyboard();
        username.sendKeys(config.readData("username"));
        email.sendKeys(config.readData("email"));
        password.sendKeys(config.readData("password"));
        name.clear();
        name.sendKeys(config.readData("name1"));
        defaultProgramingLanguage.click();
        changedProgramingLanguage.click();
        text = defaultProgramingLanguageValue.getText();
        System.out.println("Changed Programming Language is -- "+text);
        checkbox.click();
        registerUser.click();
        return text;
    }
    public List<String> verifyUserDetails(){
        List<String> actualResults = new ArrayList<String>();
        String nameVerifyText = nameVerify.getText();
        String usernameVerifyText = usernameVerify.getText();
        String passwordVerifyText = passwordVerify.getText();
        String emailVerifyText = emailVerify.getText();
        String programingLanguageVerifyText = programingLanguageVerify.getText();
        String checkboxVerifyText = checkboxVerify.getText();
        actualResults.add(nameVerifyText);
        actualResults.add(usernameVerifyText);
        actualResults.add(passwordVerifyText);
        actualResults.add(emailVerifyText);
        actualResults.add(programingLanguageVerifyText);
        actualResults.add(checkboxVerifyText);
        return actualResults;
    }
    public void clickRegisterUser() throws InterruptedException {
        registerUserButton.click();
        Thread.sleep(3000);
    }

    public Boolean verifyAllFields(AppiumDriver<MobileElement> driverr){
        driverr.hideKeyboard();
        try{
            wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
            wait.until(ExpectedConditions.visibilityOf(username));
            wait.until(ExpectedConditions.visibilityOf(email));
            wait.until(ExpectedConditions.visibilityOf(password));
            wait.until(ExpectedConditions.visibilityOf(name));
            wait.until(ExpectedConditions.visibilityOf(defaultProgramingLanguage));
            wait.until(ExpectedConditions.visibilityOf(checkbox));
            wait.until(ExpectedConditions.visibilityOf(registerUser));
            System.out.println("All Fields Visible in the User Registration Screen");
            return true;
        }catch (Exception excp){
            return false;
        }
    }
}