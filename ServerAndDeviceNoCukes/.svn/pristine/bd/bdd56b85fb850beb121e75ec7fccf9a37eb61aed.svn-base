package com.xora.test.admin

import com.xora.mc.pages.LoginPage
import com.xora.test.SeleniumPostLoginTest
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import cucumber.api.testng.{CucumberFeatureWrapper, TestNGCucumberRunner}
import org.junit.runner.RunWith
import org.openqa.selenium.By
import org.scalatest.matchers.ShouldMatchers
import org.testng.annotations.{DataProvider, Test}
import com.xora.mc.util.LoadableElement


/**
 * Created by Nandini.Sullekal on 5/2/2016.
 */

@RunWith(classOf[Cucumber])
@CucumberOptions(
features = Array("src/test/resources/features/mobile.feature"),
glue = Array("com/xora/test/stepDefinition"),
dryRun = false,
plugin = Array("html:output"))
class HomePageTest  extends SeleniumPostLoginTest with LoadableElement with ShouldMatchers
{

  @Test
  def loginShouldLoadLastVisitedPageBeforeLogoff()
  {
//    securedPage.loadLocationListPage
//    securedPage.logout()
val PAGE_TITLE = "Locations"
    val TITLE_CLASS = "pageHeadlineText"
val PAGE_TITLE_XPATH = "//*[@class='" + TITLE_CLASS + "' and .//text()='" + PAGE_TITLE + "']"
   new TestNGCucumberRunner(getClass).runCukes()
    securedPage.loadHomePage
    securedPage.logout()
    val loginPage2 = new LoginPage(webDriver, baseUrl).get()
    loginPage2.login(mcUserName, mcPassword, companyId)
    val isLocationListLoaded = isElementLoaded(webDriver, By.xpath(PAGE_TITLE_XPATH))
    isLocationListLoaded should be (true)
  }


  @DataProvider(name = "featureProvider")
  def features =  new TestNGCucumberRunner(getClass).provideFeatures()

  @Test(dataProvider = "featureProvider")
  def loginShouldLoadLastVisitedPageBeforeLogoff1(cucumberFeatures:CucumberFeatureWrapper)
  {
    //    securedPage.loadLocationListPage
    //    securedPage.logout()

//    val fetEle = cucumberFeatures.getCucumberFeature.getFeatureElements
//        for(fef:CucumberTagStatement  <- fetEle)
//      {
//        println("fef::"+ fef.getGherkinModel)
//        println("Vis::"+ fef.getVisualName)
//        println("Setps::"+ fef.getSteps)
//      }

    val Gfeat =  cucumberFeatures.getCucumberFeature.getGherkinFeature


    println("Gfeat :: "+ Gfeat.toString)
    val path  = cucumberFeatures.getCucumberFeature.getPath
    println("path:: "+ path)

    new TestNGCucumberRunner(getClass).runCucumber(cucumberFeatures.getCucumberFeature)


//     val scn = cucumberFeatures.getCucumberFeature.scenario.apply(Scenario:"Mobile App Login")
    securedPage.loadHomePage
    securedPage.logout()

    val loginPage2 = new LoginPage(webDriver, baseUrl).get()
    loginPage2.login(mcUserName, mcPassword, companyId)
    //    val isLocationListLoaded = isElementLoaded(webDriver, By.xpath(LocationListPage.PAGE_TITLE_XPATH))
    //    isLocationListLoaded should be (true)
  }
  @Test
  def jobSnatiyTest()
  {
    //    securedPage.loadLocationListPage
    //    securedPage.logout()
    val PAGE_TITLE = "Locations"
    val TITLE_CLASS = "pageHeadlineText"
    val PAGE_TITLE_XPATH = "//*[@class='" + TITLE_CLASS + "' and .//text()='" + PAGE_TITLE + "']"
//    val  testNGCucumberRunner: TestNGCucumberRunner
    //Create JOb From MC

    //Validate same job on Device and Perform the actions
    new TestNGCucumberRunner(getClass).runCukes()
    val testNGCucumberRunner = new TestNGCucumberRunner(this.getClass)
    testNGCucumberRunner.provideFeatures()
   //SErver side validation


    securedPage.loadHomePage
    securedPage.logout()
    val loginPage2 = new LoginPage(webDriver, baseUrl).get()
    loginPage2.login(mcUserName, mcPassword, companyId)
    val isLocationListLoaded = isElementLoaded(webDriver, By.xpath(PAGE_TITLE_XPATH))
    isLocationListLoaded should be (true)
  }

@Test
  def loginEventTest() {
  new TestNGCucumberRunner(this.getClass).runCukes()
  val workerListPage = securedPage.loadWorkerListPage
  val activityPage = workerListPage.contextMenu("Android_Worker2").workerActivity().sort("Date", "descending")
  activityPage.getFirstNActivities(2) should be (List("Session: EULA Accepted","Session: Login"))
}
}
