package com.xora.pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

import static org.testng.Assert.fail;

/**
 * Created by Nandini.Sullekal on 12/15/2016.
 */
public class HomePage extends LoadableComponent<HomePage> {

    AndroidDriver androidDriver;



    public HomePage(AndroidDriver androidDriver)
    {
        this.androidDriver = androidDriver;
    }

    @Override
    protected void load()
    {
        // to do enhancement
    }

    @Override
    protected void isLoaded() throws Error
    {
        try
        {
            androidDriver.findElement(By.name("Timesheets")).isDisplayed();
        }
        catch (NoSuchElementException e)
        {
            fail("Failed to load conversations list page");
        }
    }


    public void touchFeatureIcon(String argument) {
        List<WebElement> feats = androidDriver.findElements(By.className("android.widget.TextView"));
        for (WebElement feat :feats) {
            if (feat.getText().contains(argument)) {
                feat.click();
                break;
            }
        }
    }

    public void tapOn(String name) {
        androidDriver.findElement(By.name(name)).click();
    }


    public MessagesPage tapOnMessagesFeatueIcon(){
        WebElement messageEle = androidDriver.findElement(By.xpath("//*[contains(text(),'Messages')]"));
        messageEle.click();
        return new MessagesPage(androidDriver);
    }

    public HomePage tapOnTopBarButton(String image) {
        List<WebElement> imgNo = androidDriver.findElementsByClassName("android.widget.ImageButton");
        HomePage pageSelected = null;
        if (image.equals("Home")) {
            imgNo.get(0).click();
            pageSelected = new HomePage(androidDriver);

        } else if (image.equals("sync")) {
            imgNo.get(1).click();

        } else if (image.equals("GPS")) {
            imgNo.get(2).click();

        }
        return pageSelected;
    }

}
