package tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.config;
//import pom.*
import pom.productPage;
import pom.confirmPage;
import pom.formPage;
import pom.loginPage;
import pom.paymentPage;
import pom.cartPage;

public class TotoTeste {

    AppiumDriverLocalService service;
    AndroidDriver driver;       

    @Test
    public void myFirstBags() throws MalformedURLException{

        System.out.println("myFirstBags");  
        //startAppiumServer();
        //startEmulatorSession();

        //productPage
        System.out.println("productPage");  
        productPage pp = new productPage(driver);
        pp.selectionner_article();
        pp.selectionner_couleur_article();
        pp.ajouter_article_au_panier();

        //cartPage
        System.out.println("cartPage");  
        cartPage cp = new cartPage(driver);
        cp.aller_vers_panier();
        cp.cliquer_btn_checkout();

        //loginpage
        System.out.println("loginpage");  
        loginPage lp = new loginPage(driver);
        lp.seConnecter("bob@example.com","10203040");

        //formPage
        System.out.println("formPage");  
        formPage fp = new formPage(driver);
        fp.saisirNomComplet("TOTO LECOSTAUD");
        fp.saisirAddresse("25 rue de la Liberté");
        fp.saisirVille("Rennes");
        fp.saisirCodePostal("35000");
        fp.saisirPays("FRANCE");
        fp.cliquerBtnPayment();

        //paymentPage
        System.out.println("paymentPage"); 
        paymentPage payp = new paymentPage(driver);
        payp.saisirNomComplet("TOTO LECOSTAUD");
        payp.saisirCB("325812657568789");
        payp.saisirExpDate("03/25");
        payp.saisirCode("123");
        payp.cliquerBtnReviewOrder();
        payp.cliquerBtnPlaceOrder();

        //confirmPage
        System.out.println("confirmPage"); 
        confirmPage cop = new confirmPage(driver);
        boolean rep = cop.verifierConfirmationAchat();
        if (rep) {
            System.out.println("Vos 12 sacs arrivent très très très très très bientôt !!!");            
        }else{
            System.out.println("Vérifiez que vous n'êtes pas sur un site pirate !!!");
        }  
        
        driver.quit();

    }


    @BeforeMethod
    public void startEmulatorSession() throws MalformedURLException{
        System.out.println("startEmulatorSession driver");
        UiAutomator2Options options = new UiAutomator2Options();
        // options.setUdid("ENUM630010");
         
        options.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.rn");
        options.setCapability("appium:appActivity", ".MainActivity");
        options.setCapability("platformName", "Android");
        options.setCapability("appium:platformVersion", "14");
        options.setCapability("appium:automationName", "UiAutomator2");
        options.setCapability("appium:deviceName", "emulator-5554");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    @BeforeMethod
    public AppiumDriverLocalService startAppiumServer() { 
        System.out.println("startAppiumServer driver check running");
        boolean running = isServerRunning(config.appiumPort);
        if (!running) {
            service = new AppiumServiceBuilder()
                .withAppiumJS(new File(config.appiumJSExecutor))
                .withIPAddress(config.appiumServer)
                .withLogFile(new File(config.appiumLog))
                .withTimeout(Duration.ofSeconds(config.appiumServerTimeOut))
                .usingPort(config.appiumPort).build();
            service.start();
        }
        return service;
    }

    public boolean isServerRunning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSock;
        try {
            serverSock = new ServerSocket(port);
            System.out.println("serverSock :"+ serverSock);
            serverSock.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSock = null;
        }
        return isServerRunning;
    }


    
}
