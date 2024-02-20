package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class cartPage {

    @SuppressWarnings("unused")
    private AndroidDriver driver;


    public cartPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @CacheLookup
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cart badge\"]")
    private WebElement btn_cart_view;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Proceed To Checkout\"]")
    private WebElement btn_cart_checkout;

    public void aller_vers_panier () {        
        btn_cart_view.click();
    }     
    public void cliquer_btn_checkout () {        
        btn_cart_checkout.click();
    }     




}
