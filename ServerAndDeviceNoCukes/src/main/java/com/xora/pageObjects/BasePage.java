package com.xora.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
* Created by Nandini.Sullekal on 4/29/2016.
*/
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
