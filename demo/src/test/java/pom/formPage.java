package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class formPage {

    @SuppressWarnings("unused")
    private AndroidDriver driver;


    public formPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Full Name* input field\"]")
    private WebElement txt_fullname;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]")
    private WebElement txt_adress;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"City* input field\"]")
    private WebElement txt_city;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Zip Code* input field\"]")
    private WebElement txt_zipcode;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Country* input field\"]")
    private WebElement txt_country;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"To Payment button\"]")
    private WebElement btn_payment;






    public void saisirNomComplet (String fullname) {        
        txt_fullname.sendKeys(fullname);
    }     
    public void saisirVille (String city) {    
        txt_city.sendKeys(city);
    }     
    public void saisirAddresse (String address) {        
        txt_adress.sendKeys(address);
    }     
    public void saisirPays (String country) {    
        txt_country.sendKeys(country);
    }     

    public void saisirCodePostal (String codePostal){
        txt_zipcode.sendKeys(codePostal);
    }

    public void cliquerBtnPayment () {
        btn_payment.click();
    }




}
