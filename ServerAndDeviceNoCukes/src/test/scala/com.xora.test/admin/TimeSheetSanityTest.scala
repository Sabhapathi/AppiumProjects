package com.xora.test.admin

import com.xora.mc.util.LoadableElement
import com.xora.pageObjects.HomePage
import com.xora.test.SeleniumPostLoginTest
import com.xora.util.SleepTime._
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import cucumber.api.testng.TestNGCucumberRunner
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.testng.annotations.Test

/**
 * Created by Nandini.Sullekal on 12/15/2016.
 */


//@RunWith(classOf[Cucumber])
//@CucumberOptions(
//  features = Array("src/test/resources/features/timesheetSanity.feature"),
//  glue = Array("com.xora.test.stepDefinition"),
//  dryRun = false,
//  plugin = Array("html:output"))
class TimeSheetsSanityTest extends SeleniumPostLoginTest with LoadableElement with ShouldMatchers{
  @Test
  def timeSheetsSanitytest(){
//     new TestNGCucumberRunner(this.getClass).runCukes()
     val homePage = new HomePage(androidDriver)
    homePage.touchFeatureIcon("Timesheets")
//    sleepTimeInSecond(5)
    homePage.tapOn("Start Shift")
    val workerListPage = securedPage.loadWorkerListPage
    //Validate status


   val activityPage = workerListPage.contextMenu("Android_Appium").workerActivity().sort("Date", "descending")
    sleepTimeInSecond(5)
    activityPage.refresh()
    sleepTimeInSecond(2)
    activityPage.getFirstNActivities(6) should be (List("Timesheets: End Shift", "Timesheets: End Break","Timesheets: Start Break", "Timesheets: Start Shift", "Session: EULA Accepted", "Session: Login"))
  }


}
