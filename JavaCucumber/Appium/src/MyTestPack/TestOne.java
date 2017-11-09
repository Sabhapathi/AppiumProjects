package MyTestPack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import io.appium.java_client.android.AndroidDriver;
public class TestOne {

private AndroidDriver driver;

@Before
public void setUp() throws MalformedURLException{

File classpathRoot = new File(System.getProperty("user.dir"));
File appDir = new File(classpathRoot, "/ContactManager");
File app = new File(appDir, "TimeTrack_ATT.apk");

DesiredCapabilities capabilities = new DesiredCapabilities();

    cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.Android);


//    capabilities.setCapability(CapabilityType.BROWSER_NAME, ""); //Name of mobile web browser to automate. Should be an empty string if automating an app instead.
//    capabilities.setCapability("platformName", "Android");
//    capabilities.setCapability(CapabilityType.VERSION, "4.4");
//    capabilities.setCapability("deviceName", "TA6270JSRZ");
//    capabilities.setCapability("app", app.getAbsolutePath());
//    capabilities.setCapability("appPackage", "com.xora.att");
//    capabilities.setCapability("appActivity", "com.xora.device.NativeActivity");
//    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
}
@Test
public void addContact() throws Exception {
WebElement addContactButton = driver.findElement(By.name("Add Contact"));
addContactButton.click();
List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
textFieldsList.get(0).sendKeys("Some Name");
textFieldsList.get(2).sendKeys("Some@example.com");
driver.findElementByName("Save").click();
//insert assertions here
}
}