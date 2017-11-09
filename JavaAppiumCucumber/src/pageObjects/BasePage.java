package pageObjects;

import java.net.MalformedURLException;

import org.mockito.internal.matchers.And;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;

public class BasePage {
	
	protected AndroidDriver driver;
	//String app_package_name= "com.filpkart.android:id/";

	public BasePage(AndroidDriver driver) {this.driver = driver; }

	protected void waitForVisibilityOf(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	protected void waitForClickabilityOf(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}


}
