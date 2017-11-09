package com.xora.mc.pages

import com.xora.mc.util.XpathUtils._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}

import scala.collection.JavaConverters._


/**
 * Created with IntelliJ IDEA.
 * User: Nandini
 * Date: 9/13/13
 * Time: 12:22 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class AbstractDisplayFilterPage(driver: WebDriver) {

  new WebDriverWait(driver, 10)
    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(AbstractDisplayFilterPage.IFRAME_ID))


  def unSelectAllFilter(filterName: String): AbstractDisplayFilterPage = {
    filterName match {
      case "WorkerStatus" => {
        val workerStatusEL = new WebDriverWait(driver, 10)
          .until(ExpectedConditions.elementToBeClickable(By.id(AbstractDisplayFilterPage.WORKER_STATUS_FILTER_ID)))
        val workerStatusCheckBoxEl = workerStatusEL.findElement(By.id(AbstractDisplayFilterPage.WORKER_STATUS_FILTER_CHECKBOX_ID))
        if (!workerStatusCheckBoxEl.isSelected)
          workerStatusCheckBoxEl.click()

        if (workerStatusCheckBoxEl.isSelected)
          workerStatusCheckBoxEl.click()

      }
      case "CommunicationNotification" => {
        val communicationEL = new WebDriverWait(driver, 10)
          .until(ExpectedConditions.elementToBeClickable(By.id(AbstractDisplayFilterPage.COMMUNICATION_FILTER_ID)))
        val communicationCheckBoxEl = communicationEL.findElement(By.id(AbstractDisplayFilterPage.COMMUNICATION_FILTER_CHECKBOX_ID))
        if (!communicationCheckBoxEl.isSelected)
          communicationCheckBoxEl.click()

        if (communicationCheckBoxEl.isSelected)
          communicationCheckBoxEl.click()
      }
      case "GPSLocationNotification" => {
        val gpsEL = new WebDriverWait(driver, 10)
          .until(ExpectedConditions.elementToBeClickable(By.id(AbstractDisplayFilterPage.GPS_FILTER_ID)))
        val gpsCheckBoxEl = gpsEL.findElement(By.id(AbstractDisplayFilterPage.GPS_FILTER_CHECKBOX_ID))
        if (!gpsCheckBoxEl.isSelected)
          gpsCheckBoxEl.click()

        if (gpsCheckBoxEl.isSelected)
          gpsCheckBoxEl.click()
      }

      case "ShowGeofenceFilter" => {
        val geofenceEL = new WebDriverWait(driver, 10)
          .until(ExpectedConditions.elementToBeClickable(By.id(AbstractDisplayFilterPage.GEOFENCE_FILTER_ID)))
        val geofenceCheckBoxEl = geofenceEL.findElement(By.id(AbstractDisplayFilterPage.GEOFENCE_FILTER_CHECK_BOX_ID))
        if (!geofenceCheckBoxEl.isSelected)
          geofenceCheckBoxEl.click()

        if (geofenceCheckBoxEl.isSelected)
          geofenceCheckBoxEl.click()
      }

    }
    this
  }

  def selectAllFilter(filterName: String): AbstractDisplayFilterPage = {
    filterName match {
      case "WorkerStatus" => {
        val workerStatusEL = new WebDriverWait(driver, 10)
          .until(ExpectedConditions.elementToBeClickable(By.id(AbstractDisplayFilterPage.WORKER_STATUS_FILTER_ID)))
        val workerStatusCheckBoxEl = workerStatusEL.findElement(By.id(AbstractDisplayFilterPage.WORKER_STATUS_FILTER_CHECKBOX_ID))
        if (!workerStatusCheckBoxEl.isSelected)
          workerStatusCheckBoxEl.click()
      }

      case "CommunicationNotification" => {
        val communicationEL = new WebDriverWait(driver, 10)
          .until(ExpectedConditions.elementToBeClickable(By.id(AbstractDisplayFilterPage.COMMUNICATION_FILTER_ID)))
        val communicationCheckBoxEl = communicationEL.findElement(By.id(AbstractDisplayFilterPage.COMMUNICATION_FILTER_CHECKBOX_ID))
        if (!communicationCheckBoxEl.isSelected)
          communicationCheckBoxEl.click()
      }

      case "GPSLocationNotification" => {
        val gpsEL = new WebDriverWait(driver, 10)
          .until(ExpectedConditions.elementToBeClickable(By.id(AbstractDisplayFilterPage.GPS_FILTER_ID)))
        val gpsCheckBoxEl = gpsEL.findElement(By.id(AbstractDisplayFilterPage.GPS_FILTER_CHECKBOX_ID))
        if (!gpsCheckBoxEl.isSelected)
          gpsCheckBoxEl.click()
      }

      case "ShowGeofenceFilter" => {
        val geofenceEL = new WebDriverWait(driver, 10)
          .until(ExpectedConditions.elementToBeClickable(By.id(AbstractDisplayFilterPage.GEOFENCE_FILTER_ID)))
        val geofenceCheckBoxEl = geofenceEL.findElement(By.id(AbstractDisplayFilterPage.GEOFENCE_FILTER_CHECK_BOX_ID))
        if (!geofenceCheckBoxEl.isSelected)
          geofenceCheckBoxEl.click()
      }
    }
    this
  }

  def workerStatusFilter(workerStatusFilterName: String): AbstractDisplayFilterPage = {
    val workerStatusFilterList = splitValues(workerStatusFilterName)
    for (workerStatusFilter <- workerStatusFilterList) {
      val workerStatusFilterEls = driver.findElements(By.xpath("//span[@id ='" + AbstractDisplayFilterPage.WORKER_STATUS_TREE_FILTER_ID + "']//div[@class = '" + AbstractDisplayFilterPage.NOTIFICATION_CLASS + "']")).asScala
      for (workerStatusFilterEl <- workerStatusFilterEls) {
        if (workerStatusFilterEl.getText.equals(workerStatusFilter)) {
          val checkBoxEl = workerStatusFilterEl.findElement(By.className(AbstractDisplayFilterPage.TREE_CLASS))
          if (!checkBoxEl.isSelected)
            checkBoxEl.click()
        }
      }
    }
    this
  }

  def communicationNotificationFilter(communicationFilterName: String): AbstractDisplayFilterPage = {
    val communicationFilterList = splitValues(communicationFilterName)
    for (communicationFilter <- communicationFilterList) {
      val communicationFilterEls = driver.findElements(By.xpath("//span[@id ='" + AbstractDisplayFilterPage.COMMUNICATION_NOTIFICATION_TREE_FILTER_ID + "']//div[@class = '" + AbstractDisplayFilterPage.NOTIFICATION_CLASS + "']")).asScala
      for (communicationFilterEl <- communicationFilterEls) {
        if (communicationFilterEl.getText.equals(communicationFilter)) {
          val checkBoxEl = communicationFilterEl.findElement(By.className(AbstractDisplayFilterPage.TREE_CLASS))
          if (!checkBoxEl.isSelected)
            checkBoxEl.click()
        }
      }
    }
    this
  }

  def gpsNotificationFilter(gpsNotificationFilterName: String): AbstractDisplayFilterPage = {
    val gpsFilterList = splitValues(gpsNotificationFilterName)
    for (gpsFilter <- gpsFilterList) {
      val gpsFilterEls = driver.findElements(By.xpath("//span[@id ='" + AbstractDisplayFilterPage.GPS_NOTIFICATION_TREE_FILTER_ID + "']//div[@class = '" + AbstractDisplayFilterPage.NOTIFICATION_CLASS + "']")).asScala
      for (gpsFilterEl <- gpsFilterEls) {
        if (gpsFilterEl.getText.equals(gpsFilter)) {
          val checkBoxEl = gpsFilterEl.findElement(By.className(AbstractDisplayFilterPage.TREE_CLASS))
          if (!checkBoxEl.isSelected) {
            checkBoxEl.click()
          }
        }
      }
    }
    this
  }


  def clickSaveAndClose() = {
    val saveAndCLoseButton = new WebDriverWait(driver, 10).until(
      ExpectedConditions.elementToBeClickable(By.id(AbstractDisplayFilterPage.SAVE_AND_CLOSE_ID)))
    saveAndCLoseButton.click()
    driver.switchTo.defaultContent
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id(AbstractDisplayFilterPage.XORA_UNDERLAY_ID)))
//    parentPage
  }

  def clickCancel() = {
    val cancelButton = new WebDriverWait(driver, 10).until(
      ExpectedConditions.elementToBeClickable(By.id(AbstractDisplayFilterPage.CANCEL_ID)))
    cancelButton.click()
    driver.switchTo.defaultContent
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id(AbstractDisplayFilterPage.XORA_UNDERLAY_ID)))
//    parentPage
  }

  def getPopUpTitle = {
    val popUpTitleEl = driver.findElement(By.id(AbstractDisplayFilterPage.POPUP_TITLE_ID))
    val popUpTitleText = popUpTitleEl.getText
    popUpTitleText.trim
  }

  def getAllButtons = {
    val buttonDivEl = driver.findElement(By.className(AbstractDisplayFilterPage.BUTTONS_PANEL_CLASS))
    val buttonsEls = buttonDivEl.findElements(By.xpath("//a["+hasCssClass(AbstractDisplayFilterPage.BUTTONS_LINK_CLASS_NAME)+"]")).asScala
    val buttonsList = buttonsEls.map(_.getText.trim).toList
    buttonsList
  }

  def close {
    driver.switchTo().defaultContent()
    val closeEl = driver.findElement(By.className("close"))
    closeEl.click()
  }

  private def splitValues(filters: String): List[String] = {
    val filterValueArray = filters.split("\\|")
    filterValueArray.toList
  }

  def getLocationTypeNames = {
    val locationTypeEls = driver.findElements(By.xpath("//span[@id = '"+AbstractDisplayFilterPage.LOCATION_TYPES_TREE_FILTER_ID+"']//div")).asScala
    val locationTypeList = locationTypeEls.map(_.getText).toList
    locationTypeList
  }

  def selectLocationTypeCheckBoxes(locationTypeList: List[String]) = {
    for(locationType<- locationTypeList) {
      val locationTypeFilterEls = driver.findElements(By.xpath("//span[@id ='" + AbstractDisplayFilterPage.LOCATION_TYPES_TREE_FILTER_ID + "']//div[@class = '" + AbstractDisplayFilterPage.NOTIFICATION_CLASS + "']")).asScala
      for (locationTypeFilterEl <- locationTypeFilterEls) {
        if (locationTypeFilterEl.getText.equals(locationType)) {
          val checkBoxEl = locationTypeFilterEl.findElement(By.className(AbstractDisplayFilterPage.TREE_CLASS))
          if (!checkBoxEl.isSelected) {
            checkBoxEl.click()
          }
        }
      }
    }
    this
  }

  def selectShowGeofencesCheckBoxes(geofenceNames: List[String]) = {
    for(geofenceName <-geofenceNames){
      val geofenceEls = driver.findElements(By.xpath("//span[@id ='" + AbstractDisplayFilterPage.SHOW_GEOFENCE_FILTER_SPAN_ID + "']//div[@class = '" + AbstractDisplayFilterPage.SHOW_GEOFENCE_CLASS + "']")).asScala
       for(geofenceEl <- geofenceEls){
         if(geofenceEl.getText.equals(geofenceName)){
           val checkBoxEl = geofenceEl.findElement(By.className(AbstractDisplayFilterPage.TREE_CLASS))
           if (!checkBoxEl.isSelected) {
             checkBoxEl.click()
           }
         }
       }
    }
    this
  }

  def getAllGeoFenceNames = {
    val geofenceEls = driver.findElements(By.xpath("//span[@id ='" + AbstractDisplayFilterPage.SHOW_GEOFENCE_FILTER_SPAN_ID + "']//div[@class = '" + AbstractDisplayFilterPage.SHOW_GEOFENCE_CLASS + "']")).asScala
    val geofenceList = geofenceEls.map(_.getText.trim).toList
    geofenceList
  }

//  def getColorOfGeofence(geofenceName: String) = {
//    var color = ""
//    val geofenceEls = driver.findElements(By.xpath("//span[@id ='" + SHOW_GEOFENCE_FILTER_SPAN_ID + "']//div[@class = '" + SHOW_GEOFENCE_CLASS + "']")).asScala
//    for(geofenceEl <- geofenceEls){
//      if(geofenceEl.getText.equals(geofenceName)){
//        val colorEl = geofenceEl.findElement(By.className(GEO_ICON))
////        val colorArray = colorEl.getAttribute("style")
////        println("colorArray::"+colorArray)
////        println("colorArray Split value1::"+colorArray.split(":",colorArray.size-1))
////        println("colorArray Split value2::"+colorArray.split(":",colorArray.size-2))
//        val colorArray2 = colorEl.getCssValue("background-color")
//        val rgbValue =  colorArray2.split("\\(",colorArray2.size-1).toString.toInt
//        println("colorArray2::"+colorArray2)
////        Color your_color = Color.BLACK;
//
//        val color = "#"+Integer.toHexString(rgbValue).substring(2)
//        println("color::"+color)
//      }
//    }
//    color
//  }

  def isGeoFenceChecked(geofenceName: String) = {
    var flag:Boolean = false
    val geofenceEls = driver.findElements(By.xpath("//span[@id ='" + AbstractDisplayFilterPage.SHOW_GEOFENCE_FILTER_SPAN_ID + "']//div[@class = '" + AbstractDisplayFilterPage.SHOW_GEOFENCE_CLASS + "']")).asScala
    for(geofenceEl <- geofenceEls){
      if(geofenceEl.getText.equals(geofenceName)){
        val checkBoxEl = geofenceEl.findElement(By.className(AbstractDisplayFilterPage.TREE_CLASS))
        if(checkBoxEl.isSelected)
          flag = true
      }
    }
    flag
  }
  
  def getGeofenceShape(geofenceName: String) = {
    var shapeOfGeofence:String = ""
    val geofenceEls = driver.findElements(By.xpath("//span[@id ='" + AbstractDisplayFilterPage.SHOW_GEOFENCE_FILTER_SPAN_ID + "']//div[@class = '" + AbstractDisplayFilterPage.SHOW_GEOFENCE_CLASS + "']")).asScala
    for(geofenceEl <- geofenceEls){
      if(geofenceEl.getText.equals(geofenceName)){
        val checkBoxEl = geofenceEl.findElement(By.className(AbstractDisplayFilterPage.GEO_ICON))
        val src = checkBoxEl.getAttribute("src")
        val shapeImg = src.split("/")
        val shape: String = shapeImg(shapeImg.length - 1)

        shapeOfGeofence = shape match {
          case "geofence_filter_rectangle.png" => "Rectangle"
          case "geofence_filter_circle.png" => "Circle"
          case "geofence_filter_polygon.png" => "Polygonal"
        }

      }
    }
    shapeOfGeofence
  }

}

object AbstractDisplayFilterPage {
  val IFRAME_ID = "xrCommonDialogIFrame"
  val SAVE_AND_CLOSE_ID = "submit"
  val CANCEL_ID = "cancel"
  val XORA_UNDERLAY_ID = "xora-underlay"
  val NOTIFICATION_ID = "spanNotifications"
  val WORKER_STATUS_TREE_FILTER_ID = "spanWorkerStatus"
  val NOTIFICATION_CLASS = "trNdElem nd-spcr "
  val TREE_CLASS = "trNdChk"
  val COMMUNICATION_NOTIFICATION_TREE_FILTER_ID = "spanCommunicationNotification"
  val GPS_NOTIFICATION_TREE_FILTER_ID = "spanGPSLocationNotification"
  val WORKER_STATUS_FILTER_ID = "tree-form-filter.workerSymbologyGuids"
  val COMMUNICATION_FILTER_ID = "tree-form-filter.deviceCommunicationSymbologyGuids"
  val GPS_FILTER_ID = "tree-form-filter.gpsCommunicationSymbologyGuids"
  val WORKER_STATUS_FILTER_CHECKBOX_ID = "filter.workerSymbologyGuids"
  val COMMUNICATION_FILTER_CHECKBOX_ID = "filter.deviceCommunicationSymbologyGuids"
  val GPS_FILTER_CHECKBOX_ID = "filter.gpsCommunicationSymbologyGuids"
  val POPUP_TITLE_ID = "popupTitle"
  val BUTTONS_LINK_CLASS_NAME = "linkButton"
  val BUTTONS_PANEL_CLASS = "buttonPanel"
  val SHOW_GEOFENCE_FILTER_SPAN_ID = "spanShowGeofences"
  val SHOW_GEOFENCE_CLASS = "trNdElem nd-spcr "
  val GEOFENCE_FILTER_ID = "tree-form-filter.Geofences"
  val GEOFENCE_FILTER_CHECK_BOX_ID = "filter.Geofences"
  val LOCATION_TYPES_TREE_FILTER_ID = "spanLocationTypes"
  val GEO_ICON = "geoIcon"
}