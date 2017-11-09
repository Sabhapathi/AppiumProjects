package driver;

/**
 * Created by Sabhapathi.Akkipalli on 3/29/2016.
 */
public class Emulator {
    public static final String appPackage = new PropertyReader().readProperty("appPackage");
    public static final String appActivity = new PropertyReader().readProperty("appActivity");
    public static final String platformName = "Android";
    public static final String deviceName = "Android Emulator";
    public static final String avd = "nexus5";
    public static final String platformVersion = "5.1.1";
    public static final String URL = "http://127.0.0.1:4723/wd/hub";

    //public static final String appPackage = "com.flipkart.android";
    //public static final String appActivity = "com.flipkart.android.activity.LoginActivity";
}
