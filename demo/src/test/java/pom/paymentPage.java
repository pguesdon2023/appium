package pom;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class paymentPage {

    @SuppressWarnings("unused")
    private AndroidDriver driver;


    public paymentPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @CacheLookup
    @AndroidFindBy(xpath = "//*[@text='Rebecca Winter']")
    private WebElement pay_txt_fullname;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Card Number* input field\"]")
    private WebElement pay_txt_cardNumber;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Expiration Date* input field\"]")
    private WebElement pay_txt_expiration_date;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Security Code* input field\"]")
    private WebElement pay_txt_securityCode;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Review Order button\"]")
    private WebElement pay_btn_review_order;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Place Order button\"]")
    private WebElement pay_btn_place_order;






    public void saisirNomComplet (String fullname) {        
        pay_txt_fullname.sendKeys(fullname);
    }     
    public void saisirCB (String cb) {    
        pay_txt_cardNumber.sendKeys(cb);
    }     
    public void saisirExpDate (String date) {        
        pay_txt_expiration_date.sendKeys(date);
    }     
    public void saisirCode (String code) {    
        pay_txt_securityCode.sendKeys(code);
    }     

    public void cliquerBtnReviewOrder () {
        pay_btn_review_order.click();
    }

    public void cliquerBtnPlaceOrder () {
        pay_btn_place_order.click();
    }




}