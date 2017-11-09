package com.xora.test.admin


import com.xora.mc.util.LoadableElement
import com.xora.test.SeleniumPostLoginTest
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import cucumber.api.testng.TestNGCucumberRunner
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.testng.annotations.Test

/**
 * Created by murali.kapu on 1/11/2017.
 */


@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features/locations.feature"),
  glue = Array("com/xora/test/stepDefinition"),
  dryRun = false,
  plugin = Array("html:output"))
class LocationSanityTest extends SeleniumPostLoginTest with LoadableElement with ShouldMatchers {

  @Test
  def testLocationSanityTest(): Unit = {

    val locationsListPage = securedPage.loadLocationListPage

//   Send Created Location to Worker

    val contextMenuPopup = locationsListPage.contextMenuOfLocation("Location from MC")
    contextMenuPopup.getContextMenuHeaderName() should be("Locations : " + "Location from MC")
    val sendLocToWorkerPopup = contextMenuPopup.sendLocationToWorker()
    sendLocToWorkerPopup.setGroups(List("Automate worker")).send

    // Device side execution
    new TestNGCucumberRunner(this.getClass).runCukes()
  }
}