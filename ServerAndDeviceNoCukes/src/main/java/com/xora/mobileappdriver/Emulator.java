package com.xora.mobileappdriver;

import com.xora.util.PropertyLoader;

/**
 * Created by Nandini.Sullekal on 4/29/2016.
 */
public class Emulator {

    public static final String appPackage = PropertyLoader.loadProperty("appPackage");
    public static final String appActivity = PropertyLoader.loadProperty("appActivity");
    public static final String platformName = "Android";
    public static final String deviceName = "Android";
    public static final String avd = "Android";
    public static final String platformVersion = "4.4.2";
    public static final String URL = "http://127.0.0.1:4723/wd/hub";

}
