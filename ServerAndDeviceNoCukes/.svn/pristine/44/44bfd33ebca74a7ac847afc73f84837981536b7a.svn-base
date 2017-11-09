package com.xora.mc.pages.mileage

import com.xora.mc.pages.mileage.AbstractViewTripDetailPage._
import com.xora.util.ScreenShotOfElement
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}

import scala.collection.JavaConverters._

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 8/12/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class AbstractViewTripDetailPage[T](driver: WebDriver, parentPage: T) extends ScreenShotOfElement{

  def getPageHeader: String = {
    val headLineText = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.visibilityOfElementLocated(By.className(PAGE_HEADLINE_CLASS))).getText
    headLineText
  }

  def getElementsPresentInToolbar =
  {
    val toolbarElementEls = driver.findElements(By.xpath(TOOLBAR_XPATH)).asScala
    val toolbarElementsMap = toolbarElementEls.map(_.getText)
    var toolBarElementsList : List[String] = List()
    for(element<-toolbarElementsMap)  {
      if(!element.isEmpty) {
        toolBarElementsList = toolBarElementsList ::: List(element)
      }
    }
    toolBarElementsList
  }

  def validateExpandToolBar() = {
    var flag = false
    val toolBarEl = driver.findElement(By.id(TOOL_BAR_EXPAND_OR_COLLAPSE_IMAGE_ID))
    if(toolBarEl.getAttribute("src").contains(EXPAND_IMAGE)){
      toolBarEl.click()
    }
    if(toolBarEl.getAttribute("src").contains(COLLAPSE_IMAGE)){
      flag = true
    }
    flag
  }

  def validateCollapseToolBar() = {
    var flag = false
    val toolBarEl = driver.findElement(By.id(TOOL_BAR_EXPAND_OR_COLLAPSE_IMAGE_ID))
    if(toolBarEl.getAttribute("src").contains(COLLAPSE_IMAGE)){
      toolBarEl.click()
    }
    if(toolBarEl.getAttribute("src").contains(EXPAND_IMAGE)){
      flag = true
    }
    flag
  }

  def presenceOfEmailIcon = {
    val emailIconEl = driver.findElement(By.xpath("//img[@src = '/adapter/images/emailDefault.png']"))
    val flag = emailIconEl.isDisplayed && emailIconEl.isEnabled
    flag
  }
  def presenceOfPrintIcon = {
    val printIconEl = driver.findElement(By.xpath("//img[@src = '/adapter/images/printDefault.png']"))
    val flag = printIconEl.isDisplayed && printIconEl.isEnabled
    flag
  }
  def presenceOfPdfIcon = {
    val pdfIconEl = driver.findElement(By.xpath("//img[@src = '/adapter/images/printDefault.png']"))
    val flag = pdfIconEl.isDisplayed && pdfIconEl.isEnabled
    flag
  }

  def getTripSummary: List[String] = {
    val tripSummaryEls = driver.findElements(By.xpath(TRIP_SUMMARY_XPATH)).asScala
    val tripSummaryList = tripSummaryEls.map(_.getText).toList.patch(0, Nil, 1)
    tripSummaryList
  }

  def getTripSummaryHeaders: List[String] = {
    val tripSummaryHeaderEls = driver.findElements(By.xpath(TRIP_SUMMERY_HEADER_XPATH)).asScala
    val tripSummeryHeaderList = tripSummaryHeaderEls.map(_.getText).toList
    tripSummeryHeaderList
  }

  def getTripReimbursementHeaders: List[String] = {
    val tripSummaryHeaderEls = driver.findElements(By.xpath(TRIP_REIMBURSEMENT_HEADER_XPATH)).asScala
    val tripSummeryHeaderList = tripSummaryHeaderEls.map(_.getText).toList
    tripSummeryHeaderList
  }

  def getReimbursement: List[String] = {
    val tripReimbursementEls = driver.findElements(By.xpath(REIMBURSEMENT_XPATH)).asScala
    var tripReimbursementList = tripReimbursementEls.map(_.getText).toList.patch(3, Nil, 1)
    tripReimbursementList = tripReimbursementList.patch(0,Nil,1)
    tripReimbursementList
  }

  def getStartTripDetails: List[String] = {
    val startTripDetailsEls = driver.findElements(By.xpath(DETAILS_BASE_XPATH + "//div[@style='float:left;']//tr//td[2]")).asScala
    var startTripDetailsList = List(startTripDetailsEls.head.getText)
    startTripDetailsList = startTripDetailsList ::: List(startTripDetailsEls(1).getText+" "+startTripDetailsEls(2).getText)
    startTripDetailsList
  }

def getEndTripDetails: List[String] = {
  val endTripDetailsEls = driver.findElements(By.xpath(DETAILS_BASE_XPATH + "//div[@style='float:right;']//tr//td[2]")).asScala
  var endTripDetailsList = List(endTripDetailsEls.head.getText)
  endTripDetailsList = endTripDetailsList ::: List(endTripDetailsEls(1).getText+" "+endTripDetailsEls(2).getText)
  endTripDetailsList
}

  def getTripNotes: String = {
    var tripNoteTxt = ""
    val tripNotesDetailEls = driver.findElements(By.xpath(DETAILS_BASE_XPATH + TRIP_NOTE_XPATH)).asScala
    for (tripNotesDetail <- tripNotesDetailEls) {
      if (tripNotesDetail.getText.contains("TRIP NOTES")) {
        val tripNoteEl = tripNotesDetail.findElement(By.className(TRIP_NOTE_CLASS))
        tripNoteTxt = tripNoteEl.getText
      }
    }
    tripNoteTxt
  }

  def verifyStartTripImageInRouteMap() = {
    var flag = false
    try {
      val tripRouteEl = driver.findElement(By.id(TRIP_MAP_ID))
      tripRouteEl.findElement(By.xpath(START_TRIP_IMG_XPATH)).isDisplayed
      flag = true
    }
    catch {
      case e: Exception =>
//        logger.debug("Start Trip Image in route map is not present")
    }
    flag
  }

  def verifyEndTripImageInRouteMap() = {
    var flag = false
    try {
      val tripRouteEl = driver.findElement(By.id(TRIP_MAP_ID))
      tripRouteEl.findElement(By.xpath(END_TRIP_IMG_XPATH)).isDisplayed
      flag = true
    }
    catch {
      case e: Exception =>
        //logger.debug("End Trip Image in route map is not present")
    }
    flag
  }

  def panClick(direction: String) {
    val tripRouteEl = driver.findElement(By.id(TRIP_MAP_ID))
    tripRouteEl.findElement(By.xpath("//div[@title = '" + direction + "']")).click()
  }

  def getStartTripAddress = {
    val startTripAddEl = driver.findElement(By.id(START_TRIP_ADDRESS_ID))
    startTripAddEl.getText
  }

  def getEndTripAddress = {
    val endTripAddEl = driver.findElement(By.id(END_TRIP_ADDRESS_ID))
    endTripAddEl.getText
  }

  def verifyStartOdometerImageVisible(): Boolean = {
    var imagePresentFlag = false
    try {
      new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@style='float:left;']//span[@class = '"+ODOMETER_IMAGE_CLASS+"' and contains(text(),'Data transmission in progress')]")))
      val startOdoImageEl = driver.findElement(By.xpath("//div[@style='float:left;']//span[@class = '"+ODOMETER_IMAGE_CLASS+"']//img"))
      imagePresentFlag = startOdoImageEl.isDisplayed
    }
    catch {
      case e: Exception => //logger.debug("Start Odometer Image is not present")
    }
    imagePresentFlag
  }

  def verifyEndOdometerImageVisible(): Boolean = {
    var imagePresentFlag = false
    try {
      new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@style='float:right;']//span[@class = '"+ODOMETER_IMAGE_CLASS+"' and contains(text(),'Data transmission in progress')]")))
      val endOdoImageEl = driver.findElement(By.xpath("//div[@style = 'float:right;']//span[@class = '"+ODOMETER_IMAGE_CLASS+"']//img"))
      imagePresentFlag = endOdoImageEl.isDisplayed
    }
    catch {
      case e: Exception => //logger.debug("End Odometer Image is not present")
    }
    imagePresentFlag
  }

  def verifyStartOdometerImageCorrupted(): Boolean = {
    var corruptImageFlag = false
    try {
      val corruptImageEl = driver.findElement(By.xpath("//div[@style='float:left;']//span[@class = '"+ODOMETER_IMAGE_CLASS+"' and contains(text(),'Image got corrupted')]"))
      corruptImageFlag = corruptImageEl.isDisplayed
    }
    catch {
      case e: Exception => // logger.debug("Start Odometer Image is not Corrupted")
    }
    corruptImageFlag
  }

  def verifyEndOdometerImageCorrupted(): Boolean = {
    var corruptImageFlag = false
    try {
      val corruptImageEl = driver.findElement(By.xpath("//div[@style='float:right;']//span[@class = '"+ODOMETER_IMAGE_CLASS+"' and contains(text(),'Image got corrupted')]"))
      corruptImageFlag = corruptImageEl.isDisplayed
    }
    catch {
      case e: Exception =>
//        logger.debug("Start Odometer Image is not Corrupted")
    }
    corruptImageFlag
  }

  def getStartOdoImageDimension = {
    val startOdoImageEl = driver.findElement(By.xpath("//div[@style='float:left;']//span[@class = '"+ODOMETER_IMAGE_CLASS+"']"))
    val size = startOdoImageEl.getSize
    val dimension = List(size.getWidth,size.getHeight)
    dimension
  }

  def getEndOdoImageDimension = {
    val endOdoImageEl = driver.findElement(By.xpath("//div[@style = 'float:right;']//span[@class = '"+ODOMETER_IMAGE_CLASS+"']"))
    val size = endOdoImageEl.getSize
    val dimension = List(size.getWidth,size.getHeight)
    dimension
  }

  def getOdometerImageScreenShotFilePath(actionName: String) = {
    val ImageEl = actionName match {
      case "Start Trip" => driver.findElement(By.xpath("//div[@style='float:left;']//span[@class = '"+ODOMETER_IMAGE_CLASS+"']"))
      case "End Trip" => driver.findElement(By.xpath("//div[@style = 'float:right;']//span[@class = '"+ODOMETER_IMAGE_CLASS+"']"))
    }
    getScreenShotOfWebElement(driver,ImageEl)
  }

  def getScreenShotOfStartOdoImage = {
    val startOdoImageEl = driver.findElement(By.xpath("//div[@style='float:left;']//span[@class = '"+ODOMETER_IMAGE_CLASS+"']"))
    getScreenShotOfWebElement(driver,startOdoImageEl)
  }
}

object AbstractViewTripDetailPage {
  val PAGE_HEADLINE_CLASS = "pageHeadlineText"
  val TRIP_SUMMARY_XPATH = "//div[@id='showSummary']//tr//td[@class='fieldValue']"
  val TRIP_SUMMERY_HEADER_XPATH = "//div[@id='showSummary']//tr//td[@class='fieldLabel']"
  val REIMBURSEMENT_XPATH = "//div[@id='showReimbursement']//tr//td[@class='fieldValue']"
  val TRIP_REIMBURSEMENT_HEADER_XPATH = "//div[@id='showReimbursement']//tr//td[@class='fieldLabel']"
  val DETAILS_BASE_XPATH = "//div[@id='showDetails']"
  val TRIP_NOTE_XPATH = "//div[@class='detailsPageInnerBox']"
  val TRIP_MAP_ID = "tripDetailsMapDiv"
  val END_TRIP_IMG_XPATH = "//img[@src='https://maps-api-ssl.google.com/mapfiles/dd-end.png']"
  val START_TRIP_IMG_XPATH = "//img[@src='https://maps-api-ssl.google.com/mapfiles/dd-start.png']"
  val TRIP_NOTE_CLASS = "detailsPageInnerBoxContent"
  val START_TRIP_ADDRESS_ID = "tripAddress_startOdometer"
  val END_TRIP_ADDRESS_ID = "tripAddress_endOdometer"
  val ODOMETER_IMAGE_CLASS = "odometerPic"
  val TOOLBAR_ID = "mileage.trip.detail.toolbar.contentWidget"
  val TOOLBAR_XPATH = "//div[@id='" + TOOLBAR_ID + "']//a//span"
  val TOOL_BAR_EXPAND_OR_COLLAPSE_IMAGE_ID = "mileage.trip.detail.toolbar.contentWidgetImage"
  val SEARCH_BOX_EXPAND_OR_COLLAPSE_IMAGE_ID = "search.contentWidgetImage"
  val COLLAPSE_IMAGE = "widget_Collapse.gif"
  val EXPAND_IMAGE = "widget_Expand.gif"
}


