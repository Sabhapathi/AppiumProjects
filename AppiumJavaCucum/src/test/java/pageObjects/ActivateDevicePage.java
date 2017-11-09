package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import step_definitions.Hooks;
import java.util.concurrent.TimeUnit;

public class ActivateDevicePage extends Exception{
	public WebDriver driver; 
	public ActivateDevicePage()	{	driver = Hooks.driver;	}

	public String getPageTitle(){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver.findElement(By.name("Activate Device")).getText();
	}

	public void wait_for10_secs(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public String verifyText(){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver.findElement(By.name("EULA")).getText();
	}
	
	public void enterPhoneNumber(String phonenum){
		driver.findElement(By.name("Please confirm your phone number")).click();
		driver.findElement(By.name("Please confirm your phone number")).sendKeys(phonenum);
		System.out.println("User Entered his phone number as " + phonenum);

		}

	public void tapOnButton(String buttonname) {
		driver.findElement(By.name(buttonname)).click();
	};

}
