package step_definitions;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import cucumber.api.java.en.And;
import pageObjects.ActivateDevicePage;
import pageObjects.SSHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ActivateDevice {

	 ActivateDevicePage activateDevicePage = new ActivateDevicePage();
	 //SSHomePage customizeRecipePage = new SSHomePage();

	 @Given("^I open the app and land on home screen$")
	    public void open_app() throws Throwable {
	       assertThat(activateDevicePage.getPageTitle()).isEqualTo("Activate Device");
	    }

	 @And("^he clicks on button \"(.*)\"$")
	 public void clickonbutton(String buttonname) throws Throwable{
		 activateDevicePage.tapOnButton(buttonname);
	 }
	 
//	 @Then("^create recipe tab should be open by default$")
//	 public void create_recipe_tab_should_be_open_by_default() throws Throwable {
//		 assertThat(createRecipePage.isCreateRecipeTabOpen()).isTrue();
//	 }

	@Then("^user waits to see \"(.*)\" page$")
	public void user_waits_to_see_page(String text) throws Throwable {
		assertThat(activateDevicePage.verifyText()).isEqualTo(text);
	}

	@When("^user provides his phone number \"(.*)\"$")
	public void create_recipe_tab_should_be_open_by_default(String phonenum) throws Throwable {
		activateDevicePage.enterPhoneNumber(phonenum);
	}
	   
	
//	 @Then("^I should see the ten default recipes$")
//	 public void i_should_be_taken_to_customize_recipe_page(List<String> recipes) throws Throwable {
//		 ArrayList<String> expectedRecipeList = new ArrayList<String>();
//		 expectedRecipeList.addAll(recipes);
//		 assertThat(customizeRecipePage.getPageTitle()).isEqualToIgnoringCase("Recipes");
//		 ArrayList<String> actualRecipeList=new ArrayList<String>();
//		  actualRecipeList= customizeRecipePage.getRecipeNames();
//		 assertThat(actualRecipeList).containsAll(expectedRecipeList);
//		 }
    };
