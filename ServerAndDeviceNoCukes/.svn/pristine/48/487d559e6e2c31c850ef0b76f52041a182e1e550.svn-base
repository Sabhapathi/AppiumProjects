package com.xora.test.admin

import com.xora.mc.util.LoadableElement
import com.xora.test.SeleniumPostLoginTest
import com.xora.util.GenerateName._
import com.xora.util.SleepTime._
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import cucumber.api.testng.TestNGCucumberRunner
import org.junit.runner.RunWith
import org.scalatest.concurrent.Eventually
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.time.{Millis, Seconds, Span}
import org.testng.annotations.Test

/**
 * //Created by Nandini.Sullekal on 1/19/2017.
 */


@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features/tripsSanity.feature"),
  glue = Array("com/xora/test/stepDefinition"),
  dryRun = false,
  plugin = Array("html:output"))
class TripsSanityTest extends SeleniumPostLoginTest with LoadableElement with ShouldMatchers with Eventually {
  val True = true
  val False = false
  @Test(description = "Verify Tirp list page and Trip Detail Page")
  def testTripDetailPage() {

    val tripPage = securedPage.loadMileageTripListPage
    tripPage.deleteAllTrips()

    new TestNGCucumberRunner(this.getClass).runCukes()

    var tripListPage = securedPage.loadMileageTripListPage
    webDriver.navigate().refresh()
    sleepTime(minWaitTime*1000)
    tripListPage.getTripData("Category") should  contain ("Personal")
    tripListPage.getTripData("Submitted By") should contain ("Automate worker")
    tripListPage.getTripData("Purpose") should contain ("Business Trip")
    tripListPage.getTripData("Distance - Odometer") should contain ("100.0")
    tripListPage.getTripData("Distance - GPS") should contain ("0.0")
    tripListPage.getTripData("Commuter Distance") should contain ("5.0")
    tripListPage.getTotalExpenseOfTrip("Personal")  should be ("$20.00")
    tripListPage.statusOfTrip("Personal") should be ("Trip Completed")

    val contextMenuPage = tripListPage.contextMenuOfTrip("Personal")
    val tripDetailsPage = contextMenuPage.viewTripDetails()

    // Validating Trip Details Page
    tripDetailsPage.getElementsPresentInToolbar should be (List("Edit Trip"))
    //Trip Summary
    tripDetailsPage.getTripSummary should be (List("Automate worker", "Android", "Personal", "Business Trip", "Trip Completed", "-", "-"))
    //Start Trip Details
    tripDetailsPage.getStartTripDetails.head should be ("400.0")
    //End Trip Details
    tripDetailsPage.getEndTripDetails.head should be("500.0")

    //Trip Route
    tripDetailsPage.verifyStartTripImageInRouteMap() should be(True)
    tripDetailsPage.verifyEndTripImageInRouteMap() should be(True)

    //delete Trip
    tripListPage = securedPage.loadMileageTripListPage
    tripListPage.contextMenuOfTrip("Personal").deleteTripDelete()
    Thread.sleep(1000)
    webDriver.navigate().refresh()
    tripListPage.getTripData("Category") should not contain "Personal"
  }

}
