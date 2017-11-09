package com.xora.mc.pages.workers

import com.typesafe.scalalogging.Logging
import com.xora.mc.pages.workers.AbstractWorkerActivityLogPage._
import com.xora.util.Optionally
import org.openqa.selenium.support.ui
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver, WebElement}
import com.xora.util.PropertyLoader
import com.xora.util.SleepTime._
import scala.Predef._
import scala.collection.JavaConverters._
import scala.util.control._
import com.xora.mc.util.XpathUtils._


/**
 * Created with IntelliJ IDEA.
 * User: Itee
 * Date: 11/8/13
 * Time: 12:18 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class AbstractWorkerActivityLogPage[T](driver: WebDriver,parentPage : T)  extends  Optionally {
  protected var workerActivityLogPage: WorkerActivityLogPage = _
//  private var dateFilter: DateFilterTimePeriodPickerWidget = null
  val mcBaseUrl = PropertyLoader.loadProperty("mc.url")
  protected var workerListPage : WorkerListPage = _


  def navigateBackToWorkerListPage(driver: WebDriver) = {
    val workersLink = driver.findElement(By.linkText("Workers"))
    workersLink.click()
    new WorkerListPage(driver,mcBaseUrl)
  }

  def refresh(): AbstractWorkerActivityLogPage[T] = {
    driver.findElement(By.className(REFRESH_BUTTON_CLASS)).click()
    optionally {
      val busyMessage = driver.findElement(By.className(BUSY_MSG_CLASS)).getText
      new WebDriverWait(driver, maxWaitTime)
        .until(ui.ExpectedConditions.invisibilityOfElementWithText(By.className(BUSY_MSG_CLASS), busyMessage))
    }
    this
  }

  def getElementsPresentInToolbar = {
    val toolBarEl = driver.findElement(By.id(TOOL_BAR_ID))
    val toolBarsListEls = toolBarEl.findElements(By.tagName("tr")).asScala
    val toolBarValuesList = toolBarsListEls.filter(!_.getText.contains("Date Filter")).filter(_.getText.nonEmpty).map(_.getText.trim).toList.patch(8,Nil,1)
    toolBarValuesList
  }

  def validateDateColumnIsNotEmpty()= {
    val date = driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH+"//tr[2]//td[1]")).getText
    var datePresent = true
    if (date.isEmpty) {
      datePresent = false
    }
    datePresent
  }

  def getWorkerFirstRowDateAndTime = {
    val dateAndTime = driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH+"//tr[2]//td[1]")).getText
    dateAndTime
  }

  def getWorkerFirstRowActivity()= {
    val latestRowActivityEL = driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH+"//tr[1]//td[2]"))
    latestRowActivityEL.getText
  }

  // This will give activity name(not form details) for 1st N activities shown in WAL Page
  def getFirstNActivities(n: Int)= {
    val activityELs = driver.findElements(By.xpath(WORKER_LOG_BASE_XPATH+"//tr//td[2]//div")).asScala
    val activityList = activityELs.map(_.getText).toList
    val nActivityList = activityList.splitAt(n)._1
    nActivityList
  }

  def getWorkerFirstActivityLocation()= {
    var address : String = ""
    val location = driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH+"//tr[2]//td[3]")).getText
    val locationText = location.split("\n")
    for (i <- 0 until locationText.size ){
      address = address+" " + locationText(i)
    }
    address.trim
  }

  def getWorkerActivityLogPageDetail() = {
    var pageDetail: List[String] = List()
    val rowNumber = driver.findElements(By.xpath(WORKER_LOG_BASE_XPATH+"//tbody//tr")).size()
    var i:Int =2
    i=2
    try{
    while(i <= rowNumber){
      var latestRowActivityEL :WebElement = null
      val dateAndTime = driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH+"//tr[" + i + "]//td[1]")).getText
      val latestRowActivity = driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH+"//tr[" + i + "]//td[2]")).getText
      var address : String = ""
      val location = driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH+"//tr[" + i + "]//td[3]")).getText
      val locationText = location.split("\n")
      for (j <- 0 until locationText.size ){
         address = address+" " + locationText(j)
      }

      var latestRowActivity1:String = null
      var formDetails : String =null
      try{
         latestRowActivityEL = driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH+"//tbody//tr[" + i + "]//td[2]//div//table//tbody//tr//td[1]//div[1]//img"))

         if(latestRowActivityEL.getAttribute("class").equals("expandBox")){
           latestRowActivityEL.click()
           sleepTime(minWaitTime*4)
           latestRowActivity1 = driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH+"//tr[" + (i+1) + "]//td[2]")).getText
           latestRowActivityEL.click()
           val formDetailList = latestRowActivity1.split("\n")
           for (k<-0 to formDetailList.size-1){
              if (formDetails==null){
                formDetails =formDetailList(k)+" "
              }
              else{
                formDetails= formDetails+formDetailList(k)+" "
              }
           }
           i+=1
         }
      }
      catch {
        case e: Exception => {
          e.printStackTrace()
      }
     }
      i+=1

      if (formDetails!=null){
          pageDetail = pageDetail ::: List("dateAndTime :: "+dateAndTime + "   " + "latestRowActivity :: "+(latestRowActivity + formDetails ) + "   " +"address::"+ address )

      }
      else{
          pageDetail = pageDetail ::: List("dateAndTime :: "+dateAndTime + "   " + "latestRowActivity :: "+(latestRowActivity ) + "   " +"address::"+ address )
      }
    }
    }
    catch{
      case e: Exception => {
        e.printStackTrace()
      }
    }
    pageDetail.map(_.replaceAll("dateAndTime ::    latestRowActivity ::    address:: ", "")).filter(_.nonEmpty).asJava


  }

  def getWALPageDetailsForActivityFilterTest = {
    var pageDetail: List[String] = List()
    val rowNumber = driver.findElements(By.xpath(WORKER_LOG_BASE_XPATH+"//tbody//tr")).size()
    var i:Int =2
    i=2
    try{
      while(i <= rowNumber){
        var latestRowActivityEL :WebElement = null
        var dateAndTime = driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH+"//tr[" + i + "]//td[1]")).getText
        var latestRowActivity = driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH+"//tr[" + i + "]//td[2]")).getText
        var address : String = ""
        var location = driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH+"//tr[" + i + "]//td[3]")).getText
        var locationText = location.split("\n")
        for (j <- 0 until locationText.size ){
          address = address+" " + locationText(j)
        }

        var latestRowActivity1:String = null
        var formDetails : String =null
        try{
          latestRowActivityEL = driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH+"//tbody//tr[" + i + "]//td[2]//div//table//tbody//tr//td[1]//div[1]//img"))

          if(latestRowActivityEL.getAttribute("class").equals("expandBox")){
            latestRowActivityEL.click()
            sleepTime(minWaitTime*4)
            latestRowActivity1 = driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH+"//tr[" + (i+1) + "]//td[2]")).getText
            latestRowActivityEL.click()
            val formDetailList = latestRowActivity1.split("\n")
            for (k<-0 to formDetailList.size-1){
              if (formDetails==null){
                formDetails =formDetailList(k)+" "
              }
              else{
                formDetails= formDetails+formDetailList(k)+" "
              }
            }
            i+=1
          }
        }
        catch {
          case e: Exception =>
//            logger.debug("Form is not attached to this Activity")

        }
        i+=1

        if (formDetails!=null){
          pageDetail = pageDetail ::: List("latestRowActivity :: "+(latestRowActivity + formDetails ) + "   " +"address::"+ address )

        }
        else{
          pageDetail = pageDetail ::: List("latestRowActivity :: "+latestRowActivity + "   " +"address::"+ address )

        }
      }

      if(pageDetail.equals(List())){
        pageDetail = List(driver.findElement(By.cssSelector("table.listTable tr[2]")).getText)
      }
    }
    catch{
      case e: Exception =>
//        logger.debug("Form is not attached to this Activity")

    }

    pageDetail.asJava
  }

//  def getDateFilter: DateFilterTimePeriodPickerWidget =
//  {
//    if (dateFilter == null)
//    {
//      dateFilter = new DateFilterTimePeriodPickerWidget(driver, "")
//    }
//    dateFilter
//  }

//  def clickOnActivityFilterButton = {
//    val activityFilterEl = new WebDriverWait(driver, minWaitTime).until(ExpectedConditions.elementToBeClickable(By.id("workerAcitvityFilter")))
//    activityFilterEl.click()
//    sleepTimeInSecond(minWaitTime)
//    new ActivityFilterPopup(driver,this)
//  }
//
//  def clickOnWorkerTimSheetsButtonInToolBar = {
//    val workerTimesheetEl = new WebDriverWait(driver, minWaitTime).until(ExpectedConditions.elementToBeClickable(By.id(WORKER_TIMESHEETS_BUTTON_ID)))
//    workerTimesheetEl.click()
//    sleepTimeInSecond(minWaitTime)
//    new WorkerTimeSheetPage(driver,mcBaseUrl)
//  }

//  def clickOnWorkerLocationButtonInToolBar = {
//    val activityFilterEl = new WebDriverWait(driver, minWaitTime).until(ExpectedConditions.elementToBeClickable(By.id(WORKER_LOCATIONS_BUTTON_ID)))
//    activityFilterEl.click()
//    sleepTimeInSecond(minWaitTime)
//    new WorkerLocationsPage(driver,workerListPage)
//  }

  def clickOnWorkerJobsInToolBar  {
    val activityFilterEl = new WebDriverWait(driver, minWaitTime).until(ExpectedConditions.elementToBeClickable(By.id(WORKER_JOBS_BUTTON_ID)))
    activityFilterEl.click()
    sleepTimeInSecond(minWaitTime)
  }

//  def clickOnWorkerDetailsInToolBar = {
//    val activityFilterEl = new WebDriverWait(driver, minWaitTime).until(ExpectedConditions.elementToBeClickable(By.id(WORKER_DETAILS_BUTTON_ID)))
//    activityFilterEl.click()
//    sleepTimeInSecond(minWaitTime)
//    new WorkerDetailsPage(driver, workerListPage)
//  }

  def clickOnWorkerMapInToolBar  {
    val activityFilterEl = new WebDriverWait(driver, minWaitTime).until(ExpectedConditions.elementToBeClickable(By.id(WORKER_MAP_BUTTON_ID)))
    activityFilterEl.click()
    sleepTimeInSecond(minWaitTime)

  }

//  def clickWorkerReportsButtonAndSelectReport(reportName: String) = {
//    val workerReportEl = driver.findElement(By.id(WORKER_REPORT_BUTTON_ID))
//    workerReportEl.click()
//    val reportMenuEl = workerReportEl.findElement(By.id(REPORT_MENU_LIST_ID))
//    val reportEl = reportMenuEl.findElement(By.linkText(reportName.trim))
//    reportEl.click()
//    new RunReportPopup(driver, this)
//  }

  def clickWorkersLink: WorkerListPage = {
    val workersLinkEl = driver.findElement(By.cssSelector("div." + SECTION_HEADLINE_CLASS + " a"))
    workersLinkEl.click()
    new WorkerListPage(driver, mcBaseUrl)
  }


  def sort(columnName: String, order: String): AbstractWorkerActivityLogPage[T] = {
    sleepTime(maxWaitTime * 1000)
      val columnHeaderEl = new WebDriverWait(driver, maxWaitTime + 5).until(ExpectedConditions.elementToBeClickable(By.xpath(WORKER_LOG_BASE_XPATH + "//th[.//*[contains(text(),'"+ columnName + "')]]")))

    if (!columnHeaderEl.getAttribute("innerHTML").contains("img")) {
        val columnEl = new WebDriverWait(driver, maxWaitTime + 5).until(ExpectedConditions.elementToBeClickable(By.xpath(WORKER_LOG_BASE_XPATH + "//th//*[contains(text(),'" + columnName + "')]")))
        columnEl.click()
    }
    sleepTime(maxWaitTime * 1000)

    val sortingOrderImage = new WebDriverWait(driver, maxWaitTime + 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WORKER_LOG_BASE_XPATH + "//tbody//tr//th//img"))).getAttribute("src")

    order match {
      case "ascending" => {
        if (sortingOrderImage.contains("sortArrowUp.gif")) {
          driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH + "//th//*[contains(text(),'" + columnName + "')]")).click()
          sleepTime(maxWaitTime * 1000)
          new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WORKER_LOG_BASE_XPATH + "//th[.//*[contains(text(),'" + columnName + "')] and .//img[contains(@src,'sortArrowDown')]]")))
        }
      }
      case "descending" => {
        if (sortingOrderImage.contains("sortArrowDown.gif")) {
          sleepTime(minWaitTime * 1000)
          driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH + "//th//*[contains(text(),'" + columnName + "')]")).click()
          sleepTime(maxWaitTime * 1000)
          new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WORKER_LOG_BASE_XPATH + "//th[.//*[contains(text(),'" + columnName + "')] and .//img[contains(@src,'sortArrowUp')]]")))
        }
      }
    }
    this
  }

  def latestSubmittedFormNameAndLocation(): List[String]= {
    expandFormDetails()
    sleepTimeInSecond(1)
    val nameEl = driver.findElement(By.className(DETAILSPAGELABEL))  //It will give display name of submitted form
    val addressEl = driver.findElement(By.xpath("//span[" + hasCssClass(LOCATION_CLASS) + "]"))
    val nameLocationList = List(nameEl.getText,addressEl.getText)
    nameLocationList
  }

  def latestSubmittedFormFieldNames() = {
    expandFormDetails()
    val expandedFormEl = driver.findElement(By.xpath("//div[@class = '"+FORM_DETAILS_CLASS+"']"))
    val fieldNameEls = expandedFormEl.findElements(By.className(FIELD_NAME_CLASS)).asScala
    val fieldNames = fieldNameEls.map(_.getText).toList
    fieldNames.map(_.replace(":",""))
  }

  def latestSubmittedFormFieldValues() = {
    expandFormDetails()
    val expandedFormEl = driver.findElement(By.xpath("//div[@class = '"+FORM_DETAILS_CLASS+"']"))
    val fieldValueEls = expandedFormEl.findElements(By.className(FIELD_VALUE_CLASS)).asScala
    val fieldValues = fieldValueEls.map(_.getText).toList
    var fieldValuesList: List[String] = List()
    val loop = new Breaks
    loop.breakable {
      for(a<-0 until fieldValues.size) {
        if(fieldValues(a).contains("Country")&&fieldValues(a).contains("State/Prov")&&fieldValues(a).contains("County/Area")&&fieldValues(a).contains("City")&&fieldValues(a).contains("District")) {
          fieldValuesList = fieldValues.patch(a, Nil, 1)
        }
        else {
          fieldValuesList = fieldValues
        }
        loop.break()
      }
    }
    fieldValuesList
  }

//  def editAdhocFormDetails() = {
//    expandFormDetails()
//    sleepTime((minWaitTime)*1000)
//    val editFormIconEl = driver.findElement(By.xpath("//img[@src = '/adapter/images/edit16.png']"))
//    editFormIconEl.click()
//    new EditFormFieldValuesPopup(driver,workerActivityLogPage)
//  }

  def viewEditHistoryFromAndToFieldValues()= {
    val editHistoryBox = driver.findElement(By.xpath("//div[" + hasCssClass(EDIT_HISTORY_CLASS) + "]"))
    val expandEditHistoryBoxEl = editHistoryBox.findElement(By.tagName("img"))
    if(expandEditHistoryBoxEl.getAttribute("class").equals("expandBox")){
      expandEditHistoryBoxEl.click()
    }
    sleepTime((minWaitTime/2)*1000)
    val editHistoryDetailsXpath = "//table[@class = '"+EDIT_HISTORY_DETAILS_CLASS+"']"
    val fromFieldValues = driver.findElements(By.xpath(editHistoryDetailsXpath+"//tbody//tr[1]//td[2]")).asScala
    val toFieldValues = driver.findElements(By.xpath(editHistoryDetailsXpath+"//tbody//tr[2]//td[2]")).asScala
    val fromFieldValuesArray = new Array[String](fromFieldValues.size)
    val toFieldValuesArray = new Array[String](fromFieldValues.size)
    var textPresent = ""
    for(a<- 0 until fromFieldValues.size) {
      textPresent = fromFieldValues(a).getText
      if(textPresent.contains("Country")&&textPresent.contains("State/Prov")&&textPresent.contains("County/Area")&&textPresent.contains("City")&&textPresent.contains("District")) {
        fromFieldValuesArray(a) = fromFieldValues(a).getText.replace("\n",",")
        toFieldValuesArray(a) = toFieldValues(a).getText.replace("\n",",")
      }
      else {
        fromFieldValuesArray(a) = fromFieldValues(a).getText
        toFieldValuesArray(a) = toFieldValues(a).getText
      }
    }
    val listOfFromAndToFieldLists = List(fromFieldValuesArray.toList,toFieldValuesArray.toList)
    listOfFromAndToFieldLists
  }

  def viewEditHistoryComments()= {
    val editHistoryBox = driver.findElement(By.xpath("//div[" + hasCssClass(EDIT_HISTORY_CLASS) + "]"))
    val expandEditHistoryBoxEl = editHistoryBox.findElement(By.tagName("img"))
    if(expandEditHistoryBoxEl.getAttribute("class").equals("expandBox")){
      expandEditHistoryBoxEl.click()
    }
    var comments = ""
    optionally {
      val commentEl = driver.findElement(By.className(EDIT_HISTORY_COMMENTS_CLASS))
      comments = commentEl.getText.split(":")(1).trim
    }
    comments
  }

  def formEditedBy() = {
    val editHistoryBox = driver.findElement(By.xpath("//div[" + hasCssClass(EDIT_HISTORY_CLASS) + "]"))
    val expandEditHistoryBoxEl = editHistoryBox.findElement(By.tagName("img"))
    if(expandEditHistoryBoxEl.getAttribute("class").equals("expandBox")){
      expandEditHistoryBoxEl.click()
    }
    val editedBy = driver.findElement(By.xpath("//span[@class ='"+EDITED_BY_CLASS+"']//div[1]")).getText
    editedBy
  }

  private def expandFormDetails() = {
    sleepTime((minWaitTime/2) * 1000)
    val latestRowActivityEL = driver.findElement(By.xpath(WORKER_LOG_BASE_XPATH+"//tr//td[1]//div[1]//img"))
    if(latestRowActivityEL.getAttribute("class").equals("expandBox")){
      latestRowActivityEL.click()
    }
  }

//  def clickOnTimeOffButtonInToolBar = {
//    val workerTimeSheetsButtonEl = driver.findElement(By.id(WORKER_TIMEOFF_BUTTON_ID))
//    workerTimeSheetsButtonEl.click()
//    sleepTimeInSecond(minWaitTime)
//    new WorkerTimeOffPage(driver,mcBaseUrl)
//  }

}

object AbstractWorkerActivityLogPage {
  val TABLE_ID = "Worker Activity Log"
  val WORKER_LOG_BASE_XPATH = "//table[@id='" + TABLE_ID + "']"
  val LOCATION_CLASS = "detailsPageAddress detailsPageValue"
  val FORM_DETAILS_CLASS = "formDetailsBubbleCallout"
  val FIELD_NAME_CLASS = "fieldLabel"
  val FIELD_VALUE_CLASS = "fieldValue"
  val EDIT_HISTORY_CLASS = "formDetailsBubbleRoundedBox actionEditHistoryBox"
  val EDIT_HISTORY_DETAILS_CLASS = "auditDetailsTable"
  val EDIT_HISTORY_COMMENTS_CLASS = "comments"
  val EDITED_BY_CLASS = "editedBy"
  val DETAILSPAGELABEL = "detailsPageLabel"
  val REFRESH_BUTTON_CLASS = "refreshNowButton"
  val BUSY_MSG_CLASS = "busyMsg"
  val TOOL_BAR_ID = "worker.activityLog.toolbar.contentWidget"
  val WORKER_TIMEOFF_BUTTON_ID = "workerTimeoffRequests"
  val WORKER_TIMESHEETS_BUTTON_ID = "workerTimecards"
  val WORKER_LOCATIONS_BUTTON_ID = "workerLocations"
  val WORKER_JOBS_BUTTON_ID = "workerJobs"
  val WORKER_DETAILS_BUTTON_ID = "workerDetails"
  val WORKER_MAP_BUTTON_ID = "workerMap"
  val WORKER_REPORT_BUTTON_ID = "workerReports_menu"
  val REPORT_MENU_LIST_ID = "menuBody"
  val SECTION_HEADLINE_CLASS = "sectionHeadline"
}