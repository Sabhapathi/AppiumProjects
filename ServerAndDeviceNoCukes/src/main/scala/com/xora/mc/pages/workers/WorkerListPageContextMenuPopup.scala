package com.xora.mc.pages.workers

import com.xora.mc.pages.ListPageContextMenuPopup
import com.xora.mc.pages.workers.WorkerListPageContextMenuPopup._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}
import com.xora.util.PropertyLoader
import com.xora.util.SleepTime._
import scala.collection.JavaConverters._


/**
 * Created with IntelliJ IDEA.
 * User: Nandini
 * Date: 7/1/13
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */

object WorkerListPageContextMenuPopup
{
  sealed abstract class CONTEXT_MENU_POPUP_OPTION(val displayValue: String)
  case object WORKER_MAP extends CONTEXT_MENU_POPUP_OPTION("Worker Map")
  case object WORKER_ACTIVITY_LOG extends CONTEXT_MENU_POPUP_OPTION("Worker Activity Log")
  case object WORKER_TIMESHEETS extends CONTEXT_MENU_POPUP_OPTION("Worker Timesheets")
  case object WORKER_JOBS extends CONTEXT_MENU_POPUP_OPTION("Worker Jobs")
  case object WORKER_LOCATIONS extends CONTEXT_MENU_POPUP_OPTION("Worker Locations")
  case object SUBMITTED_FORMS extends CONTEXT_MENU_POPUP_OPTION("Submitted Forms")
  case object WORKER_TRIPS extends CONTEXT_MENU_POPUP_OPTION("Worker Trips")
  case object WORKER_DETAILS extends CONTEXT_MENU_POPUP_OPTION("Worker Details")
  case object DEVICE_STATUS_LOG extends CONTEXT_MENU_POPUP_OPTION("Device Status Log")
  case object GET_CURRENT_LOCATION extends CONTEXT_MENU_POPUP_OPTION("Get Current Location")
  case object REMOTE_START extends CONTEXT_MENU_POPUP_OPTION("Remote Start")
  case object EDIT_WORKER extends CONTEXT_MENU_POPUP_OPTION("Edit Worker")
  case object CONFIGURE_SETTINGS extends CONTEXT_MENU_POPUP_OPTION("Configure Settings")
  case object HOURS_OF_OPERATION extends CONTEXT_MENU_POPUP_OPTION("Hours of Operation")
  case object TIME_OFF extends CONTEXT_MENU_POPUP_OPTION("Time Off")
  case object REPORTS extends CONTEXT_MENU_POPUP_OPTION("Reports")
}

class WorkerListPageContextMenuPopup(driver: WebDriver, parentPage: WorkerListPage) extends
ListPageContextMenuPopup[WorkerListPage](driver: WebDriver, parentPage: WorkerListPage) {
  val mcBaseUrl = PropertyLoader.loadProperty("mc.url")

  val DIALOG_CONFIRM_CLASS = "dialog dialog-confirm"
  val DIALOG_BUTTON_CLASS = "linkButton"
  val REPORTS_MENU_BASE_PATH = "//div[@id='workerReports_menu']"
  val DIALOG_ALERT_CLASS = "dialog dialog-alert"
  val CONTEXT_MENU_LIST_ID = "drillDownUL"
  val CONTEXT_MENU_LIST_ITEM_CLASS = "actionList"
  val CONTEXT_MENU_HEADER_CLASS = "cssbox_head"
  val CONTEXT_MENU_CLOSE_BUTTON_ID = "puClose"
//  val userListPage = new UserListPage(driver, mcBaseUrl)


//  def workerMap()= {
//    this.selectOption(WORKER_MAP)
//    new WorkerMapPage(driver,mcBaseUrl)
//  }

  def workerActivity()= {
    this.selectOption(WORKER_ACTIVITY_LOG)
    new WorkerActivityLogPage(driver,parentPage)
  }

//  def workerTimeSheets() = {
//    this.selectOption(WORKER_TIMESHEETS)
//    new WorkerTimeSheetPage(driver,mcBaseUrl)
//  }

//  def workerJobs()= {
//    this.selectOption(WORKER_JOBS)
//    new WorkerJobsPage(driver,mcBaseUrl)
//  }
//
//  def workerLocation()= {
//    this.selectOption(WORKER_LOCATIONS)
//    new WorkerLocationsPage(driver,parentPage)
//  }
//
//  def submittedForms() = {
//    this.selectOption(SUBMITTED_FORMS)
//    new WorkerSubmittedForms(driver,mcBaseUrl)
//  }
//
//  def workerTrips() = {
//    this.selectOption(WORKER_TRIPS)
//    new WorkerTripsPage(driver,mcBaseUrl)
//  }
//
//  def workerDetails()= {
//    this.selectOption(WORKER_DETAILS)
//    new WorkerDetailsPage(driver, parentPage)
//  }
//
//  def deviceStatusLog() = {
//    this.selectOption(DEVICE_STATUS_LOG)
//    new DeviceStatusLogPage(driver, parentPage)
//  }
//
//  def getCurrentLocation(workerName: String): String = {
//    this.selectOption(GET_CURRENT_LOCATION)
//    sleepTimeInSecond(minWaitTime)
//    clickOkOnDialogAlert
//    val requestMessage = notification_qRequestMessageAndActionName(workerName)
//    requestMessage
//  }
//
//  def editWorker() = {
//    this.selectOption(EDIT_WORKER)
//    new EditWorkerPopup(driver, parentPage)
//  }
//
//  def configureSettings() {
//    this.selectOption(CONFIGURE_SETTINGS)
//
//  }
//
//  def hoursOfOperation() = {
//    this.selectOption(HOURS_OF_OPERATION)
//    new HoursOfOperationPage(driver, userListPage)
//  }
//
//  def timeOff() = {
//    this.selectOption(TIME_OFF)
//   new WorkerTimeOffPage(driver, mcBaseUrl)
//  }
//
//  def remoteStartAccept() ={
//    this.selectOption(REMOTE_START)
//    acceptRemoteStartConfirmDialog()
//    parentPage
//  }
//  def remoteStartCancel() ={
//    this.selectOption(REMOTE_START)
//    cancelRemoteStartConfirmDialog()
//    parentPage
//  }
//
//  def reports() {
//    this.selectOption(REPORTS)
//
//  }

//  def clickOkOnDialogAlert: WorkerListPage = {
//    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_ALERT_CLASS) + "]"))
//    val okButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "OK" + "']"))
//    okButton.click()
//    parentPage
//  }
//
//  private def acceptRemoteStartConfirmDialog()
//  {
//    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
//    val okButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "OK" + "']"))
//    okButton.click()
//
//  }
//
//  private def cancelRemoteStartConfirmDialog()
//  {
//    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
//    val cancelButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Cancel" + "']"))
//    cancelButton.click()
//
//  }

  protected def selectOption(option: WorkerListPageContextMenuPopup.CONTEXT_MENU_POPUP_OPTION) {
    sleepTime(minWaitTime*2000)
    this.selectOption(option.displayValue)
  }

//  def contextMenuOfReport(reportName: String) = {
//    val reportMenuPage = reports()
//    val reportXpath = REPORTS_MENU_BASE_PATH + "//li[.//*[text()='" + reportName + "']]"
//    val reportOfWorkerEl = new WebDriverWait(driver, 10)
//      .until(ExpectedConditions.elementToBeClickable(By.xpath(reportXpath)))
//    reportOfWorkerEl.click()
//    new RunReportPopup(driver, this)
//  }
//
//  def contextReportList(workerName: String):List[String] = {
//    reports()
//    val reportListXpath: String = REPORTS_MENU_BASE_PATH + "//li"
//    val reportOfWorkerEls = driver.findElements(By.xpath(reportListXpath)).asScala
//    val reportMenuList=reportOfWorkerEls.map(_.getText)
//    reportMenuList.toList
//  }

  def contextMenuContent(): List[String] = {
    val contextMenuListEls = driver.findElements(By.className("popupDiv")).asScala
    val contextMenuList = contextMenuListEls.map(_.getText)
    contextMenuList.toList

  }

  def getContextMenuHeaderName() ={
    val contextMenuHeaderEle = driver.findElement(By.className(CONTEXT_MENU_HEADER_CLASS))
    contextMenuHeaderEle.getText
  }

  def listContextMenuItems(): List[String]= {
    val menuItemEls = driver.findElements(By.xpath("//ul[@id='" + CONTEXT_MENU_LIST_ID +"']//li[@class='" + CONTEXT_MENU_LIST_ITEM_CLASS + "']")).asScala
    val menuItems = menuItemEls.map(_.getText)
    menuItems.toList
  }

  def closeContextMenu()
  {
    val closeButton = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className(CONTEXT_MENU_CLOSE_BUTTON_ID)))
    closeButton.click()
  }

//  def notification_qRequestMessageAndActionName(userName: String): String = {
//    val companyId = PropertyLoader.loadProperty("company.id")
//    val con = connectDB()
//    val user = UserRepository.getUserDetails(companyId,userName)
//    val notification_q = Notification_qRepository.getNotification_qDetails(user.usrId)
//    val requestMessage = notification_q.requestMsg
//    val actionName = notification_q.actn_Name
//    actionName+ "|" +requestMessage
//  }

}





