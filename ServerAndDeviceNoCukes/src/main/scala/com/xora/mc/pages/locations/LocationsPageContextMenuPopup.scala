package com.xora.mc.pages.locations

import com.xora.mc.pages.ListPageContextMenuPopup
import org.openqa.selenium.{By, WebDriver}
import com.xora.mc.pages.locations.LocationsPageContextMenuPopup._
import com.xora.mc.util.XpathUtils._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import com.xora.mc.pages.jobs.wizards.CreateWizardPopup
import com.xora.mc.pages.jobs.JobListPage
import scala.collection.JavaConverters._

/**
 * Created with IntelliJ IDEA.
 * User: Nandini
 * Date: 11/20/13
 * Time: 12:31 PM
 * To change this template use File | Settings | File Templates.
 */

object LocationsPageContextMenuPopup {

  sealed abstract class CONTEXT_MENU_POPUP_OPTION(val displayValue: String)

  case object VIEW_LOCATION_DETAILS extends CONTEXT_MENU_POPUP_OPTION("View Location Detail")

  case object VIEW_LOCATION_MAP extends CONTEXT_MENU_POPUP_OPTION("View Location Map")

  case object VIEW_JOB_HISTORY extends CONTEXT_MENU_POPUP_OPTION("View Job History")

  case object EDIT_LOCATION extends CONTEXT_MENU_POPUP_OPTION("Edit Location")

  case object SEND_LOCATION_TO_WORKER extends CONTEXT_MENU_POPUP_OPTION("Send Location to Worker")

  case object DELETE_LOCATION extends CONTEXT_MENU_POPUP_OPTION("Delete Location")

  case object CREATE_JOB extends CONTEXT_MENU_POPUP_OPTION("Create Job")

}

class LocationsPageContextMenuPopup(driver: WebDriver, parentPage: LocationListPage) extends
ListPageContextMenuPopup[LocationListPage](driver: WebDriver, parentPage: LocationListPage) {

  val DIALOG_CONFIRM_CLASS = "dialog dialog-confirm"
  val DIALOG_BUTTON_CLASS = "linkButton"
  val CREATE_JOB_MENU_BASE_PATH = "//div[@id='jobCreate_menu']"
  val CONTEXT_MENU_LIST_ID = "drillDownUL"
  val CONTEXT_MENU_LIST_ITEM_CLASS = "actionList"
  val CONTEXT_MENU_CLOSE_BUTTON_ID = "puClose"
  val CONTEXT_MENU_HEADER_CLASS = "cssbox_head"

  protected var jobListPage: JobListPage = _


//  def viewLocationDetails() = {
//    this.selectOption(VIEW_LOCATION_DETAILS)
//    new ViewLocationDetailPage(driver, parentPage)
//  }
//
//  def viewLocationMap() = {
//    this.selectOption(VIEW_LOCATION_MAP)
//    new ViewLocationMapPage(driver, parentPage)
//  }
//
//  def viewJobHistory() = {
//    this.selectOption(VIEW_JOB_HISTORY)
//    new ViewJobHistoryPage(driver, parentPage)
//  }
//
//  def editLocation() = {
//    this.selectOption(EDIT_LOCATION)
//    new EditLocationPopup(driver, parentPage)
//  }

  def sendLocationToWorker() = {
    this.selectOption(SEND_LOCATION_TO_WORKER)
    new SendLocationToWorkerPopup(driver, parentPage)
  }

  def acceptDeleteLocation() = {
    this.selectOption(DELETE_LOCATION)
    acceptDeletePurposeDialog()
    parentPage
  }

  def rejectDeleteLocation() = {
    this.selectOption(DELETE_LOCATION)
    cancelDeletePurposeDialog()
    parentPage
  }

  def createJob(jobType: String) = {
    this.selectOption(CREATE_JOB)
    val jobCreateXpath = CREATE_JOB_MENU_BASE_PATH + "//li[.//*[text()='" + jobType + "']]"
    val jobTypeEL = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.xpath(jobCreateXpath)))
    jobTypeEL.click()
    new CreateWizardPopup(driver, jobListPage)

  }

  def getContextMenuHeaderName() ={
    val contextMenuHeaderEle = driver.findElement(By.className(CONTEXT_MENU_HEADER_CLASS))
    contextMenuHeaderEle.getText
  }

  def listContextMenuItems():List[String]=
  {
    val menuItemEls = driver.findElements(By.xpath("//ul[@id='" + CONTEXT_MENU_LIST_ID +"']//li[@class='" + CONTEXT_MENU_LIST_ITEM_CLASS + "']")).asScala
    val menuItems = menuItemEls.map(_.getText)
    menuItems.toList
  }

  private def acceptDeletePurposeDialog() {
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val deleteButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Delete" + "']"))
    deleteButton.click()
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]")))
  }

  private def cancelDeletePurposeDialog() {
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    Thread.sleep(2000)
    val cancelButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Cancel" + "']"))
    Thread.sleep(1000)
    cancelButton.click()
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]")))
  }


  protected def selectOption(option: LocationsPageContextMenuPopup.CONTEXT_MENU_POPUP_OPTION) {
    this.selectOption(option.displayValue)
  }
}
