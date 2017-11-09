package step_definitions;

import java.io.File;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	public static AndroidDriver<AndroidElement> driver;

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		capabilities.setCapability(MobileCapabilityType.APP, "C:\\QAHome\\AppiumJavaCucum\\src\\apps\\TimeTrack_ATT.apk");
 try {
        	driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
        
	};
	
	
	 public void embedScreenshot(Scenario scenario) {
		try{
			WebDriver augmentedDriver = new Augmenter().augment(driver);
			byte[] screenshot=((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot,"image/png");
		}catch(WebDriverException somWebDriverException){
			System.err.println(somWebDriverException.getMessage());
		}
//             WebDriver augmentedDriver = new Augmenter().augment(driver);
//             String screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.BASE64);
//             assert (screenshot) != null;
//             File file = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
//             assert (file) != null;
     }  
	@After
	public void tearDown(Scenario scenario) throws Exception{
		
		if (driver != null) 
	        {
			if(scenario.isFailed()){
				embedScreenshot(scenario);
			}
			System.out.println("quitting");
	        	driver.quit();
	        }
	   }
};
