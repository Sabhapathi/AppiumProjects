package com.xora.webdriver;

import com.opera.core.systems.OperaDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Nandini.Sullekal on 4/29/2016.
 */
public class WebDriverFactory {

    /* Browsers constants */
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String OPERA = "opera";
    public static final String INTERNET_EXPLORER = "ie";
    public static final String HTML_UNIT = "htmlunit";
    public static final String IPHONE = "iphone";

    /* Platform constants */
    public static final String WINDOWS = "windows";
    public static final String ANDROID = "android";
    public static final String XP = "xp";
    public static final String VISTA = "vista";
    public static final String MAC = "mac";
    public static final String LINUX = "linux";

    /*
     * Factory method to return a WebDriver instance given the browser to hit
     *
     * @param browser : String representing the local browser to hit
     *
     * @return WebDriver instance
     */
    public static WebDriver getInstance(String browser, ChromeDriverService chromeDriverService) {

        WebDriver webDriver = null;

        if (CHROME.equals(browser)) {
            setChromeDriver();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-password-autofill-public-suffix-domain-matching");
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.addArguments("--start-maximized");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            webDriver = new RemoteWebDriver(chromeDriverService.getUrl(), capabilities);
        } else if (FIREFOX.equals(browser)) {

            webDriver = new FirefoxDriver();

        } else if (INTERNET_EXPLORER.equals(browser)) {
            setIEDriver();
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            webDriver = new InternetExplorerDriver(capabilities);

        } else if (OPERA.equals(browser)) {
            webDriver = new OperaDriver();

        } else if (IPHONE.equals(browser)) {
            try {
//				webDriver = new IPhoneDriver();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ANDROID.equals(browser)) {
//			webDriver = new AndroidDriver();

        } else {

            webDriver = new HtmlUnitDriver(true);
        }

        return webDriver;
    }

    /*
     * Helper method to set ChromeDriver location into the right ststem property
     */
    private static void setChromeDriver() {
        String chromeBinary = findChromeBinaryLocation();
        System.setProperty("webdriver.chrome.driver", chromeBinary);
    }

    public static String findChromeBinaryLocation()
    {
        String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
        String driverSuffix = findOsSuffix(os);
        return "src/main/resources/drivers/chrome/chromedriver"
                + driverSuffix;
    }

    private static void setIEDriver() {

        String ieBinary =  "src/main/resources/drivers/ie/IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", ieBinary);
    }

    private static String findOsSuffix(String os)
    {
        if ("win".equals(os))
        {
            return "-win.exe";
        }
        else if ("lin".equals(os))
        {
            return "-linux";
        }
        else if ("mac".equals(os))
        {
            return "-mac";
        }
        return "";
    }
}
