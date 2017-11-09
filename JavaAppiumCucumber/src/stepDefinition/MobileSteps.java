package stepDefinition;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.lang.String;
import java.net.MalformedURLException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverFactory;
import pageObjects.BasePage;
import pageObjects.MobilePage;

public class MobileSteps extends DriverFactory{

	public MobileSteps() throws MalformedURLException, IOException,InterruptedException{

	}

	@Given("^user is on mobile home page$")
	public void I_am_on_the_landing_page() throws Throwable{
		new MobilePage(driver).waitForLoginScreen();
	}

	@When("^user enter invalid phone number \"([^\"]*)\"$")
	public void I_enter_invalid_phonenumber_as(String phone_num) throws Throwable {
		new MobilePage(driver).invalidLogin(phone_num);
	}

	@Then("^he should see the text \"([^\"]*)\"$")
	public void I_should_see_the_visibletext(String text) throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new MobilePage(driver).verifyTextDisplayed(text);
	}


	@When("^user enter valid phone number \"([^\"]*)\"$")
	public void I_enter_valid_phonenumber_as(String phone_num) throws Throwable {
		new MobilePage(driver).validLogin(phone_num);
		System.out.println(driver);
	}

	@And("^wait until OK is visible$")
	public void wait_until_locator_visible(String locator) throws Throwable{
		new MobilePage(driver).waitForOkButton();
	}

	@When("^user clicks on \"(.*)\" button$")
	public void user_clicks_on_button(String buttonname) throws Throwable {
		new MobilePage(driver).click_button(buttonname);
	}

	@When("^user clicks on \"(.*)\" text$")
	public void user_clicks_on_text(String text) throws Throwable {
		new MobilePage(driver).click_button(text);
	}

	@When("^user waits for \"(.*)\" seconds$")
	public void user_waits_in_seconds(int secs) throws Throwable {
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}



//
//	@Then("^user waits to see \"(.*)\" page$")
//	public void user_waits_to_see_page(String text) throws Throwable {
//		assertThat(MobilePage.verifyText()).isEqualTo(text);
//	}
//


//	@Given("^user is on mobile home page$")
//		public void is_on_home_page() throws Throwable{
//			if (MobilePage.is_on_home_page()=="Activate Device"){
//
//			 System.out.println("User on Mobile home page");
//			 }else {
//				System.out.println("User is not on home page");}
//			//MobilePage.is_on_home_page()
////			System.out.println(driver);
////			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
////			driver.findElement(By.name("ActivateDevice")).isDisplayed();
//
//	}
//
//
//	@When("^user provides his phone number \"(.*)\"$")
//	public void create_recipe_tab_should_be_open_by_default(String phonenum) throws Throwable {
//		MobilePage.enterPhoneNumber(phonenum);
//	}
//
////
////	@When("^user provides his phonenumber \"(.*)\"$")
////	public void user_provides_his_phonenumber(String phonenum){
////		driver.findElementByName("Please confirm your phone number").click();
////		driver.findElementByName("Please confirm your phone number").sendKeys(phonenum);
////		System.out.println("User entered his phone number as "+ phonenum);
////
////	}
////
////	@And("^he clicks on button \"(.*)\"$")
////	public void he_clicks_on_button(String buttonname){
////		driver.findElementByName("Activate").click();
////	}
////
//	@And("user waits for \"(.*)\"$")
//	public void user_waits_for(int seconds){
//		MobilePage.wait_for10_secs(seconds)
//	}
//
//	@Then("user waits to see \"(.*)\" page$")
//	public void user_waits_to_see(String elementname){
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElementByName(elementname).isDisplayed();
//	}
//

}
