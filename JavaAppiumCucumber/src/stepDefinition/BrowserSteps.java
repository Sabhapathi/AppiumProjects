package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sabhapathi.Akkipalli on 3/30/2016.
 */
public class BrowserSteps {

    WebDriver browser = new FirefoxDriver();

    @Given("^the user is on web login page$")
    public void setup() throws Throwable {
        browser.get("https://crt-mc.xora.com/adapter/guest/login.page");
        browser.manage().window().maximize();
    }

    @When("^user provides his credentials as follows:$")
    public void user_provides_his_credentials_as_follows(DataTable usercredentials) throws Throwable {

        for (Map<String, String> data : usercredentials.asMaps(String.class, String.class)) {

//            new SignupPage(driver).user_provides_username_as(userToBeSignedUp.Username);
//            new SignupPage(driver).user_provides_password_as(userToBeSignedUp.Password);
//            new SignupPage(driver).user_provies_companyid_as(userToBeSignedUp.Company_id);
            browser.findElement(By.id("username")).clear();
            browser.findElement(By.id("username")).sendKeys(data.get("Username"));
            browser.findElement(By.id("password")).clear();
            browser.findElement(By.id("password")).sendKeys(data.get("Password"));
            browser.findElement(By.id("companyId")).clear();
            browser.findElement(By.id("companyId")).sendKeys(data.get("Company_id"));
            browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("Logged in with valid Credentials");

        }

    }



    @And("^user clicks on Login$")
    public void user_logs_in() throws Throwable {
        browser.findElement(By.id("password_submit")).click();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^user should be logged in$")
    public void user_should_be_logged_in() throws Throwable {
        browser.findElement(By.linkText("Logout")).isDisplayed();

    }

    @Given("^user on workerlist page$")
    public void gotoWorkerlist() throws Throwable {
        browser.get("https://crt-mc.xora.com/adapter/worker/list/doList.page");
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Navigated to Worker list page");

    }

    @Given("^user on joblist page$")
    public void gotoJobList() throws Throwable {
        browser.get("https://crt-mc.xora.com/adapter/jobs/list/doList.page");
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Navigated to job list page");
    }

    @When("he clicks on id \"(.*)\"$")
    public void then_he_click_on_id(String idname) throws Throwable {
        browser.findElement(By.id(idname)).click();
        System.out.println("Clicked on " + idname);
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("^he clicks on linktext \"(.*)\"$")
    public void then_he_click_on_link(String linktext) throws Throwable {
        browser.findElement(By.linkText(linktext)).click();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Working with Text fields
    @When("^he clears field \"(.*)\"")
    public void then_he_clear_field_id(String fieldid) throws Throwable {
        browser.findElement(By.id(fieldid)).clear();
        System.out.println(fieldid + " Cleared");
    }
    //Frames step definitions

    @Given("^he switches to frame \"(.*)\"")
    public void given_he_switch_to_frame(String frameid) throws Throwable {
        browser.switchTo().frame(frameid);
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Switched to frame id " + frameid);
    }

    @Then("^he switches to default view")
    public void he_switch_to_default_view() throws Throwable {
        browser.switchTo().defaultContent();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Switched to default view");
    }

    //Working with Text fields
    @Then("^he enter \"(.*)\" into field \"(.*)\"")
    public void then_he_enter_into_field_id(String value, String fieldid) throws Throwable{
        browser.findElement(By.id(fieldid)).sendKeys(value);
        System.out.println("Entered " + value + " into " + fieldid);
    }


    // Working with Radio Buttons
    @And("^he chooses radio option \"(.*)\"")
    public void then_he_choose_radio_option(String optionid) throws Throwable {
        browser.findElement(By.id(optionid)).click();
        System.out.println(optionid + " selected");
    }


    //Working with select list
    @And("^he chooses visible text \"(.*)\" from list \"(.*)\"")
    public void then_he_choose_visible_text_from_list(String visibletext,String listname) throws Throwable {
        Select dropdown = new Select(browser.findElement(By.id(listname)));
        dropdown.selectByVisibleText(visibletext);
    }

    @Then("^user chooses to Logout$")
    public void user_chooses_to_Logout() throws Throwable {
        browser.findElement(By.linkText("Logout")).click();
        System.out.println("Logout is clicked");
    }

    @Then("^I quite the browser$")
    public void user_quits_browser() throws Throwable{
        browser.quit();
        System.out.println("Browser is closed");
    }
    @Given("^Browser session is started$")
    public void start_browser_session() throws Throwable{
        WebDriver browser = new FirefoxDriver();
    }




}
