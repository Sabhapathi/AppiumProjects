package com.xora.mobileappdriver;

import com.xora.util.PropertyLoader;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nandini.Sullekal on 4/29/2016.
 */
public class DriverFactory {

    protected static AndroidDriver driver;
    protected static WebDriver browser;
    public static final String appName = "TimeTrack_Sprint.apk";
    public static final String APP_DIR = System.getProperty("user.dir") + "\\apps";
    public static java.lang.Process Process;

    public DriverFactory() throws MalformedURLException,IOException,InterruptedException {

        initializeAppiumServer();
        initializeAndroidDriver();
        //initializeBrowserSession();
    }

    //APPIUM SERVER
    public  void initializeAppiumServer() throws IOException,InterruptedException{
        if(Process == null)
        {
            Process= Runtime.getRuntime().exec("cmd /c start "+System.getProperty("user.dir") + "\\apps\\startappium.bat");
            //if(Process==null)
            System.out.println("Appium starts..");
            // Thread.sleep(10000);
        }

    }



    //ANDROID DRIVER

    protected void initializeAndroidDriver() throws MalformedURLException {
        String DvcREmulator = new PropertyLoader().loadProperty("DeviceREmulator");
        if (DvcREmulator.equals("Device")){
            configureSessionForDevice();
        }
        else if (DvcREmulator.equals("Emulator")) {configureSessionForEmulator();}
        else {System.out.println("Please select either Device or Emulator. " +DvcREmulator+" is not the right environment");}
    }

    // Enter your android device details
    private void configureSessionForDevice() throws MalformedURLException {
        File app = getAppFile();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", Device.device);
        // capabilities.setCapability("noReset", true);   -->True-Will not deactivate the app,
        //capabilities.setCapability("fastRest", false);

        //mandatory capabilities
        capabilities.setCapability("deviceName", Device.deviceName);
        capabilities.setCapability("platformName", Device.platformName);
        capabilities.setCapability("appPackage", Emulator.appPackage);
        capabilities.setCapability("appActivity", Emulator.appActivity);
        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());

        if(driver == null )
        {
            driver =  new AndroidDriver(new URL(Device.URL), capabilities);
        }
        else if(!driver.isAppInstalled(Emulator.appPackage)){
            driver =  new AndroidDriver(new URL(Device.URL), capabilities);
        }

    }

    //Standard Emulator details, however customize it based on your avd
    private void configureSessionForEmulator() throws MalformedURLException {
        File app = getAppFile();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //mandatory capabilities
        capabilities.setCapability("deviceName", Emulator.deviceName);
        capabilities.setCapability("platformName", Emulator.platformName);
        capabilities.setCapability("platformVersion", Emulator.platformVersion);
        capabilities.setCapability("avd", Emulator.avd);

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", Emulator.appPackage);
        capabilities.setCapability("appActivity", Emulator.appActivity);
        if(driver == null)
        {
            driver =  new AndroidDriver(new URL(Device.URL), capabilities);
        }
    }

    private File getAppFile() {
        File appDir = new File(APP_DIR);
        return new File(appDir, appName);
    }

    public void killAppiumSession(){

        driver.quit();

    }


    // Browser Initialization
    public void initializeBrowserSession() {
        if(browser==null)
            createNewBrowserInstance();
    }

    public void createNewBrowserInstance(){
        browser = new FirefoxDriver();
        System.out.println(browser);
    }

    public WebDriver getBrowser(){
        return browser;
    }

    public void killBrowser(){
        browser.quit();
        browser = null;
    }

}
