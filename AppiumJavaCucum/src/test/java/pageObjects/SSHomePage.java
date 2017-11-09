package pageObjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import step_definitions.Hooks;

public class SSHomePage extends Exception{
	public MobileDriver driver; 
	BasePage basePage=new BasePage();
	
	ArrayList<String> list = new ArrayList<String>();
	public SSHomePage()
	{ 
	driver = Hooks.driver; 
	}

	public String getPageTitle(){
	return driver.findElement(By.id("recipes")).getText();
	}
	
	public WebElement waitForPageToLoad(){
	 
	 return driver.findElement(By.id("recipes"));
		}
	
	public ArrayList<String> getRecipeNames(){
		ArrayList<String> recipeList = new ArrayList<String>();
		String expectedLastDesc = "Latte Macchiato poured over ice cubes and yummy caramel syrup, brewed with cold milk and froth, to satisfy your sweet tooth.";
		String foundLastDesc = null;
		while (!expectedLastDesc.equalsIgnoreCase(foundLastDesc)) {
			List<WebElement> recipes= driver.findElements(By.id("de.luna.qbo.ci:id/recipe_name"));
			List<WebElement> recipesDesc = driver.findElements(By.id("de.luna.qbo.ci:id/recipe_description"));
			 recipes.addAll(recipesDesc);
			 recipeList = getRecipeList(recipes);
			int recipeListSize = recipeList.size();
			foundLastDesc = recipeList.get(recipeListSize-1);
			basePage.scrollDown(driver);
			}
		return recipeList;
	}
	
	public ArrayList<String> getRecipeList(List<WebElement> element){
		
		for (WebElement webElement : element) {
			String text=webElement.getText();
			list.add(text);
		}
		return list;
	}

}
