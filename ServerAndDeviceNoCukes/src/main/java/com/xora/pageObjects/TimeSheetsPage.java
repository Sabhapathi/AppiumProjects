package com.xora.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by Nandini.Sullekal on 12/15/2016.
 */
public class TimeSheetsPage extends BasePage{

    public TimeSheetsPage(AndroidDriver driver) {super(driver);}

    public void tapOn(String shift){
        driver.findElement(By.name(shift)).click();
    }

}
