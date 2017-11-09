package com.xora.mobileappdriver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nandini.Sullekal on 1/10/2017.
 */
public class DriverFactory1 {
    protected static AndroidDriver androidDriver;
    protected static WebDriver browser;
    public static final String appName = "TimeTrack_Sprint.apk";
    public static final String APP_DIR = System.getProperty("user.dir") + "\\apps";
    public static java.lang.Process Process;


    public DriverFactory1() throws MalformedURLException,IOException,InterruptedException {
        initializeAppiumServer();
//        initializeAndroidDriver();
        //initializeBrowserSession();
    }

    //APPIUM SERVER
//    protected void initializeAppiumServer() throws IOException,InterruptedException{
//        System.out.println("Intialize appium server");
//        Runtime.getRuntime().exec("cmd /c start "+System.getProperty("user.dir") + "\\apps\\startappium.bat");
//        Thread.sleep(7000);
//    }

    public  void initializeAppiumServer() throws IOException,InterruptedException{
        if(Process == null)
        {
            Process= Runtime.getRuntime().exec("cmd /c start "+System.getProperty("user.dir") + "\\apps\\startappium.bat");
            System.out.println("Appium starts..");
             Thread.sleep(7000);
        }

    }





    public WebDriver getBrowser(){
        return browser;
    }

//    public void killBrowser(){
//        browser.quit();
//        browser = null;
//    }

}
