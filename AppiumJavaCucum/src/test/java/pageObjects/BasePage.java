package pageObjects;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BasePage extends Exception{
	
	public TouchAction scrollDown(MobileDriver driver){
		TouchAction touchAction = new TouchAction(driver);
		touchAction.press((int)0.5,(int) 0.5).waitAction(1000).moveTo((int) 0.5, (int) 1).release();
		return driver.performTouchAction(touchAction);
		
	}
}