package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class loginPage {

    @SuppressWarnings("unused")
    private AndroidDriver driver;


    public loginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Username input field\"]")
    private WebElement txt_username;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Password input field\"]")
    private WebElement txt_password;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Login button\"]")
    private WebElement btn_login;



    public void saisirUsername (String username) {        
        txt_username.sendKeys(username);
    }   
    public void saisirPassword (String password) {        
        txt_password.sendKeys(password);
    }   
    public void cliquerBtnLogin () {        
        btn_login.click();
    }       
    public void seConnecter (String username, String password) {        
        txt_username.sendKeys(username);
        txt_password.sendKeys(password);
        btn_login.click();
    }   
}
