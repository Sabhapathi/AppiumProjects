package com.xora.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.testng.Assert.fail;



import com.xora.util.PropertyLoader;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: rpriyadarshi
 * Date: 9/30/15
 * Time: 10:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeviceLoginPage extends LoadableComponent<DeviceLoginPage>{
    AndroidDriver androidDriver;

    By activatedevice = By.name("Activate Device");
    By activate_Button = By.name("Activate");
    By text_edit = By.name("Please confirm your phone number");
    By locator_text = By.name("Ok");


//

    final static Logger logger = Logger.getLogger(DeviceLoginPage.class);

    public DeviceLoginPage(AndroidDriver androidDriver){
           this.androidDriver=androidDriver;
    }

    @Override
    protected void load()
    {

    }

    @Override
    protected void isLoaded() throws Error
    {
        try
        {
            androidDriver.findElement(By.name("Please confirm your phone number"));
            System.out.println("loaded");
        }
        catch (NoSuchElementException e)
        {
            fail("Failed to load login page");
        }
    }

    public void changeUrl(){

        String changeUrl = PropertyLoader.loadProperty("bridge.url");
        WebElement urlTextBox  = androidDriver.findElementByClassName("android.widget.EditText");
        urlTextBox.click();
        urlTextBox.clear();
        urlTextBox.sendKeys(changeUrl);
    }

    public void verifyText(String text) {
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        androidDriver.findElement(By.name(text)).isDisplayed();
    }

    public void click_button(String buttonName){
        androidDriver.findElement(By.name(buttonName)).click();
    }


    public HomePage login(){
        String phoneNumber = PropertyLoader.loadProperty("mobile.worker.phone.number");

        new WebDriverWait(androidDriver, 120)
        .until(ExpectedConditions.visibilityOfElementLocated(text_edit));
        androidDriver.findElement(text_edit).sendKeys("999999999");
        click_button("Activate");
        verifyText("Set Bridge URL");
        changeUrl();
        click_button("Update");
        new WebDriverWait(androidDriver, 120)
                .until(ExpectedConditions.visibilityOfElementLocated(text_edit));
        androidDriver.findElement(text_edit).sendKeys(phoneNumber);
        click_button("Activate");
        verifyText("EULA");
        click_button("I Agree");
        verifyText("Warning");
        click_button("Ok");
        new WebDriverWait(androidDriver,240).until(ExpectedConditions.presenceOfElementLocated(By.name("New Updates")));
        click_button("Ok");
        return new HomePage(androidDriver);
    }

}
