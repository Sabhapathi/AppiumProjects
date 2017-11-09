package pageObjects;

import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MobilePage extends BasePage{


    By activatedevice = By.name("Activate Device");
    By activate_Button = By.name("Activate");
    By text_edit = By.name("Please confirm your phone number");
    By locator_text = By.name("Ok");



    public MobilePage(AndroidDriver driver) {super(driver);}


    public String is_on_home_page(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	return driver.findElement(By.name("ActivateDevice")).getText();
	}

	public void waitForLoginScreen(){

        waitForVisibilityOf(activatedevice);
        waitForClickabilityOf(activate_Button);
    }

    public void waitForOkButton(){

        waitForVisibilityOf(locator_text);

    }

//    public void verifyText(String text){
//        waitForVisibilityOf(visible_text);
//        String textfound = driver.findElement(visible_text).getText();
//        text.contentEquals(driver.findElement(visible_text).getText());
//    }


    public boolean verifyTextDisplayed(String visibletext) throws Throwable{
        return driver.findElement(By.name(visibletext)).isDisplayed();
    }

    public void click_button(String buttonname) throws Throwable{
        driver.findElement(By.name(buttonname)).click();
    }

    public void invalidLogin(String phonenum) {
        waitForVisibilityOf(text_edit);
        driver.findElement(text_edit).sendKeys(phonenum);
        driver.findElement(activate_Button).click();
    }

    public void validLogin(String phonenum) {
        waitForVisibilityOf(text_edit);
        driver.findElement(text_edit).sendKeys(phonenum);
        driver.findElement(activate_Button).click();
    }
	
	
}
