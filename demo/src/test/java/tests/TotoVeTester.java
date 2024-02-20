package tests;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class TotoVeTester {


    public static void main(String[] args) throws MalformedURLException {
        
        UiAutomator2Options options = new UiAutomator2Options();
        // options.setUdid("ENUM630010");
         
        options.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.rn");
        options.setCapability("appium:appActivity", ".MainActivity");
        options.setCapability("platformName", "Android");
        options.setCapability("appium:platformVersion", "14");
        options.setCapability("appium:automationName", "UiAutomator2");
        options.setCapability("appium:deviceName", "emulator-5554");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

         
        try {

            // Product
            WebElement productItem = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]"));
            productItem.click();
            WebElement product_color = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"red circle\"]/android.view.ViewGroup"));
            product_color.click();
            WebElement btn_plus_one = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView"));
            for (int index = 0; index < 12; index++) {
                btn_plus_one.click();                
            }
            WebElement btn_AddToCart = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Add To Cart button\"]"));
            btn_AddToCart.click();
            //cart
            WebElement btn_cart_view = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]"));
            btn_cart_view.click();
            WebElement btn_cart_checkout = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Proceed To Checkout\"]"));
            btn_cart_checkout.click();
            //login
            WebElement txt_username = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]"));
            txt_username.sendKeys("bob@example.com");
            WebElement txt_password = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]"));
            txt_password.sendKeys("10203040");
            WebElement btn_login = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]"));
            btn_login.click();
            //form
            WebElement txt_fullname = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]"));
            txt_fullname.sendKeys("Wilson shix");
            WebElement txt_adress = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]"));
            txt_adress.sendKeys("25 rue de la paix");
            WebElement txt_city = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"City* input field\"]"));
            txt_city.sendKeys("Nantes");
            WebElement txt_zipcode = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Zip Code* input field\"]"));
            txt_zipcode.sendKeys("44000");
            WebElement txt_country = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Country* input field\"]"));
            txt_country.sendKeys("France");
            WebElement btn_payment = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"To Payment button\"]"));
            btn_payment.click();
            // payment
            WebElement pay_txt_fullname = driver.findElement(AppiumBy.xpath("//*[@text='Rebecca Winter']"));
            pay_txt_fullname.sendKeys("Wilson shix");
            WebElement pay_txt_cardNumber = driver.findElement(AppiumBy.xpath("//*[@text='3258 1265 7568 789']"));
            pay_txt_cardNumber.sendKeys("325812657568789");
            WebElement pay_txt_expiration_date = driver.findElement(AppiumBy.xpath("//*[@text='03/25']"));
            pay_txt_expiration_date.sendKeys("03/25");
            WebElement pay_txt_securityCode = driver.findElement(AppiumBy.xpath("//*[@text='123']"));
            pay_txt_securityCode.sendKeys("123");
            WebElement pay_btn_review_order = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Review Order button\"]"));
            pay_btn_review_order.click();
            WebElement pay_btn_place_order = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Place Order button\"]"));
            pay_btn_place_order.click();

            // confirmation
            WebElement confirmation_message = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Checkout Complete\"]"));
            if (confirmation_message.isDisplayed()) {
                System.out.println("Test réussi !");                
 }
        }  finally {
            driver.quit();
        }
    }


    
}
