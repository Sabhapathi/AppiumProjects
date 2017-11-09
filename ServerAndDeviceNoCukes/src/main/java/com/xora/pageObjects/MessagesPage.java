package com.xora.pageObjects;

//import com.sun.java.util.jar.pack.Instruction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.fail;

/**
 * Created by Nandini.Sullekal on 1/11/2017.
 */
public class MessagesPage extends LoadableComponent<MessagesPage> {

    AndroidDriver androidDriver;


    public MessagesPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    @Override
    protected void load() {
        // to do enhancement
    }

    @Override
    protected void isLoaded() throws Error {
        try {
            androidDriver.findElement(By.name("Timesheets"));
        } catch (NoSuchElementException e) {
            fail("Failed to load conversations list page");
        }
    }

    public void tapOn(String text){
        androidDriver.findElement(By.name(text)).click();
    }

    public List<String> getVisibleText() throws Throwable{
        List<String> list = new ArrayList<String>();
        List<WebElement> eles= androidDriver.findElements(By.className("android.widget.TextView"));
        for(WebElement ele: eles){
            System.out.println("Elemnet" + ele.getText());
            list.add(ele.getText());
        }
         return list;
    }

    public String getSenderInfo() throws Throwable{
        WebElement ele = androidDriver.findElement(By.xpath("//*[contains(@name,'Sender')]"));
        String senderInfo = ele.getText();
        System.out.println("Sender info :"+senderInfo );
          return senderInfo;
    }

    public void click_Delete_Button() throws Throwable {
        androidDriver.findElement(By.name("Delete")).click();

    }

    public MessagesPage click_Yes_On_DeleteMessage_Dialog() throws Throwable{
        new WebDriverWait(androidDriver,10).until(ExpectedConditions.presenceOfElementLocated(By.name("Yes"))).click();
        return this;
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
