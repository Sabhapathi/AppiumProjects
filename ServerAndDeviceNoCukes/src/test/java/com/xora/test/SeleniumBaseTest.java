package com.xora.test;

import com.xora.mobileappdriver.Device;
import com.xora.mobileappdriver.DriverFactory1;
import com.xora.mobileappdriver.Emulator;
import com.xora.util.PropertyLoader;
import com.xora.webdriver.WebDriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.xora.util.GenerateName.generateName;
import static com.xora.util.SleepTime.sleepTimeInSecond;

/**
 * Created by Nandini.Sullekal on 5/2/2016.
 */
public class SeleniumBaseTest extends DriverFactory1 {


    public SeleniumBaseTest() throws MalformedURLException, IOException, InterruptedException {

    }
    private static final String SCREENSHOT_FOLDER = "target/screenshots/";
    private static final String SCREENSHOT_FORMAT = ".png";

    private static ChromeDriverService chromeDriverService;
    private static String browserName;

    protected WebDriver webDriver;
    protected AndroidDriver androidDriver;
    protected String baseUrl;
    protected String mcUserName;
    protected String mcPassword;
    protected String companyId;
    static int passedTestCasesCount =0;
    static int failedTestCasesCount =0;
    static int skippedTestCasesCount =0;
    static String startDateTime ="";

    @BeforeTest
    public  void createAndStartService() throws IOException
    {
        System.out.println("Before test");
        browserName = PropertyLoader.loadProperty("browser.name");
        if (WebDriverFactory.CHROME.equals(browserName))
        {
            chromeDriverService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(WebDriverFactory.findChromeBinaryLocation()))
                    .usingAnyFreePort()
                    .build();
            chromeDriverService.start();
            DesiredCapabilities cap=new DesiredCapabilities();
            cap.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, false);
        }
        baseUrl = PropertyLoader.loadProperty("mc.url");
        mcUserName = PropertyLoader.loadProperty("mc.username");
        mcPassword = PropertyLoader.loadProperty("mc.password");
        companyId = PropertyLoader.loadProperty("company.id");
        webDriver = WebDriverFactory.getInstance(browserName, chromeDriverService);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

    }

    @BeforeTest
    public void configureSessionForDevice() throws MalformedURLException {
        System.out.println("Before Suite");
        File appDir = new File(APP_DIR);
        File app = new File(appDir, appName);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", Device.device);

        //mandatory capabilities
        capabilities.setCapability("deviceName", Device.deviceName);
        capabilities.setCapability("platformName", Device.platformName);

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("newCommandTimeout", 60 * 10);
//        androidDriver =  new AndroidDriver(new URL(Device.URL), capabilities);
//        sleepTimeInSecond(10);

        if(androidDriver == null )
        {
            androidDriver =  new AndroidDriver(new URL(Device.URL), capabilities);
        }
        else if(!androidDriver.isAppInstalled(Emulator.appPackage)){
            androidDriver =  new AndroidDriver(new URL(Device.URL), capabilities);
        }
    }


    @AfterTest
    public  void stopService()
    {
        if (webDriver != null) {
            webDriver.quit();
        }
        if (chromeDriverService != null) {
            chromeDriverService.stop();
        }
    }

    @BeforeMethod
    public void init() {

        try{
            WebElement logoutLink = webDriver.findElement(By.xpath("//*[@class='head_links' and .//text()='Logout']"));
        }

        catch(Exception e) {
            com.xora.mc.pages.LoginPage loginPage = new com.xora.mc.pages.LoginPage(webDriver,baseUrl).get();
            loginPage.login(mcUserName, mcPassword, companyId);
        }

    }

    @AfterMethod
    public void setScreenshot(ITestResult result) {

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
                WebDriver returned = new Augmenter().augment(webDriver);
                if (returned != null) {
                    File f = ((TakesScreenshot) returned)
                            .getScreenshotAs(OutputType.FILE);
                    try {
                        FileUtils.copyFile(f, new File(SCREENSHOT_FOLDER
                                + result.getName() + "_" + generateName("") + SCREENSHOT_FORMAT));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (ScreenshotException se) {
                se.printStackTrace();
            }
        }

        try{
            webDriver.switchTo().defaultContent();
            webDriver.findElement(By.className("close")).click();
        }
        catch(Exception e){
            //do nothing
        }

        try{
            webDriver.findElement(By.className("puClose")).click();
        }
        catch(Exception e){
            //do nothing
        }
    }
//    @AfterSuite
//    public  void getResultData(ITestContext iTestContext )
//    {
//        String testSuiteName = iTestContext.getSuite().getName();
//
//        String message = "<strong><font size=\"4\">Test Suite Execution Details:</font></strong><br>";
//        message = message +"&nbsp;&nbsp;&nbsp;&nbsp;"+"<strong>Test Suite Name             :</strong>"+testSuiteName+"<br>"
//                + "&nbsp;&nbsp;&nbsp;&nbsp;"+"<strong>Start Date of test suite    :</strong>"+startDateTime+"<br>"
//                + "&nbsp;&nbsp;&nbsp;&nbsp;"+"<strong>End Date of test suite      :</strong>"+iTestContext.getEndDate().toString()+"<br>"
//                + "&nbsp;&nbsp;&nbsp;&nbsp;"+"<strong><font color=\"green\">Number of Passed Testcases  :</font></strong>"+passedTestCasesCount+"<br>"
//                + "&nbsp;&nbsp;&nbsp;&nbsp;"+"<strong><font color=\"red\">Number of failed Testcases  :</font></strong>"+failedTestCasesCount+"<br>"
//                + "&nbsp;&nbsp;&nbsp;&nbsp;"+"<strong><font color=\"orange\">Number of Skipped Testcases :</font></strong>"+skippedTestCasesCount+"<br>";
//
//        List<String> versionDetail = BuildVersion.getBuildVersion();
//        String adapterVersion = versionDetail.get(0).toString();
//        String dbVersion = versionDetail.get(1).toString();
//        Write(System.getProperty("user.dir")+ "\\src\\main\\resources\\AdapterVersion.txt", adapterVersion);
//        Write(System.getProperty("user.dir")+ "\\src\\main\\resources\\DatabaseVersion.txt", dbVersion);
//        Write(System.getProperty("user.dir")+ "\\src\\main\\resources\\TestResult.txt" , message );

//    }
}
