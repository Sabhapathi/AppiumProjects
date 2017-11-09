package com.xora.mc.pages

import com.xora.mc.pages.Forms.SubmittedFormsListPage
import com.xora.mc.pages.SecuredPage._
import com.xora.mc.pages.jobs.JobListPage
import com.xora.mc.pages.locations.LocationListPage
import com.xora.mc.pages.messages.InboxPage
import com.xora.mc.pages.mileage.MileageTripListPage
import com.xora.mc.pages.partsCatalog.PartsCatalogPage
import com.xora.mc.pages.workers.WorkerListPage
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}


  //Created by Nandini.Sullekal on 5/2/2016.

class SecuredPage(driver: WebDriver, baseUrl: String) {

  def loadMileageTripListPage: MileageTripListPage = {
    new MileageTripListPage(driver, baseUrl).get
  }


  def loadMessagesInboxPage : InboxPage = {
    new InboxPage(driver, baseUrl).get
  }

  def loadJobListPage : JobListPage ={
    new JobListPage(driver, baseUrl).get
  }


  def loadHomePage: HomePage =
  {
    new HomePage(driver, baseUrl).get
  }

  def loadWorkerListPage : WorkerListPage =
  {
    new WorkerListPage(driver, baseUrl).get
  }

  def loadSubmittedFormsListPage : SubmittedFormsListPage =
  {
    new SubmittedFormsListPage(driver, baseUrl).get
  }

  def loadLocationListPage: LocationListPage =
  {
    new LocationListPage(driver, baseUrl).get
  }

  def loadPartsCatalogPage : PartsCatalogPage = {
    new PartsCatalogPage(driver, baseUrl).get
  }

  def logout()
  {
    val logoutLinkEl = driver.findElement(By.xpath(LOGOUT_TITLE_XPATH))
    logoutLinkEl.click()

    new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("password_submit")))

  }


}

object SecuredPage {
  val LOGOUT_CLASS = "head_links"
  val LOGOUT_TEXT = "Logout"
  val LOGOUT_TITLE_XPATH = "//*[@class='" + LOGOUT_CLASS + "' and .//text()='" + LOGOUT_TEXT + "']"
}