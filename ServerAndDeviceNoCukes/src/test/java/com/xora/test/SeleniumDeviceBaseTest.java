package com.xora.test;

import com.xora.mobileappdriver.Device;
import com.xora.mobileappdriver.DriverFactory1;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: rpriyadarshi
 * Date: 9/26/15
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeleniumDeviceBaseTest extends DriverFactory1 {

    public SeleniumDeviceBaseTest() throws MalformedURLException, IOException, InterruptedException {

    }
    protected AndroidDriver androidDriver;
    protected String testUrl;



    static int passedTestCasesCount =0;
    static int failedTestCasesCount =0;
    static int skippedTestCasesCount =0;
    static String startDateTime ="";
    private static final String SCREENSHOT_FOLDER = "test-output/screenshots/";
    private static final String SCREENSHOT_FORMAT = ".png";
    public static final String appName = "TimeTrack_Sprint.apk";
    public static final String APP_DIR = System.getProperty("user.dir") + "\\apps";


    @BeforeTest
    public void setUp() throws MalformedURLException {

//                DriverFactory.initializeAndroidDriver();

//        File appDir = new File(APP_DIR);
//        File app = new File(appDir, appName);
//
//        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
//        DesiredCapabilities capabilities = new DesiredCapabilities();
////        capabilities.setCapability("device","Android");
////        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
////        capabilities.setCapability(CapabilityType.PLATFORM, "WINDOW");
////        capabilities.setCapability(CapabilityType.VERSION, "5.1.1");
//
////        capabilities.setCapability("platformVersion", "5.1.1");
//
//        capabilities.setCapability("deviceName", Device.deviceName);
//        capabilities.setCapability("platformName",Device.platformName);
//        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
////        capabilities.setBrowserName(CapabilityType.HAS_TOUCHSCREEN);
//
////        capabilities.setCapability("appPackage", "com.mobicomkit.sample.debug");
//        // This package name of your app (you can get it from apk info app)
////        capabilities.setCapability("appActivity","com.applozic.mobicomkit.sample.MainActivity"); // This is Launcher activity of your app (you can get it from apk info app)
//        //Create RemoteWebDriver instance and connect to the Appium server
//        //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
////        capabilities.setCapability("testobject_api_key", "CDCCE4B95F714B80AF2BA8775AEAF20B");
////        capabilities.setCapability("testobject_app_id","2");
////        capabilities.setCapability("testobject_device","Asus_Google_Nexus_7_real");
//
//        try {
//                    androidDriver = new AndroidDriver(new URL(Device.URL), capabilities);
////              androidDriver = new AndroidDriver(new URL("https://app.testobject.com:443/api/appium/wd/hub"), capabilities);
//
//            androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

    }



    @AfterMethod
    public void setUpAfterMethod(ITestResult result) {

        if(result.getStatus()==ITestResult.SUCCESS  ){
            passedTestCasesCount++;
        }
        if(result.getStatus()==ITestResult.FAILURE  ){
            failedTestCasesCount++;
        }
        if(result.getStatus()==ITestResult.SKIP  ){
            skippedTestCasesCount++;
        }

        if (startDateTime.isEmpty()){
            startDateTime = result.getTestContext().getStartDate().toString();
        }

        if (!result.isSuccess()) {
            try {
                WebDriver returned = new Augmenter().augment(androidDriver);
                if (returned != null) {
                    File f = ((TakesScreenshot) returned)
                            .getScreenshotAs(OutputType.FILE);
                    try {
                        FileUtils.copyFile(f, new File(SCREENSHOT_FOLDER
                                + result.getName() + "" +  SCREENSHOT_FORMAT));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (ScreenshotException se) {
                se.printStackTrace();
            }
        }

        if(result.getStatus()==ITestResult.FAILURE  ){
            try{
                stopService();
                setUp();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @AfterTest
    public  void stopService()
    {
        if (androidDriver != null) {
            androidDriver.quit();
        }
    }

    @AfterSuite
    public  void getResultData(ITestContext iTestContext )
    {
        String testSuiteName = iTestContext.getSuite().getName();

        String message = "<strong><font size=\"4\">Test Suite Execution Details:</font></strong><br>";
        message = message +"&nbsp;&nbsp;&nbsp;&nbsp;"+"<strong>Test Suite Name             :</strong>"+testSuiteName+"<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;"+"<strong>Start Date of test suite    :</strong>"+startDateTime+"<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;"+"<strong>End Date of test suite      :</strong>"+iTestContext.getEndDate().toString()+"<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;"+"<strong><font color=\"green\">Number of Passed Testcases  :</font></strong>"+passedTestCasesCount+"<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;"+"<strong><font color=\"red\">Number of failed Testcases  :</font></strong>"+failedTestCasesCount+"<br>"
                + "&nbsp;&nbsp;&nbsp;&nbsp;"+"<strong><font color=\"orange\">Number of Skipped Testcases :</font></strong>"+skippedTestCasesCount+"<br>";



    }


}
