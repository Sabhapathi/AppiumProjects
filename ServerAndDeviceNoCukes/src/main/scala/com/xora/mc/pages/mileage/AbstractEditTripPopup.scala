package com.xora.mc.pages.mileage

import com.xora.mc.pages.mileage.AbstractEditTripPopup._
import com.xora.mc.util.XpathUtils._
import com.xora.util.SleepTime._
import org.openqa.selenium.support.ui.{ExpectedConditions, Select, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}

import scala.collection.JavaConverters._

/**
 * Created with IntelliJ IDEA.
 * User: iyadav
 * Date: 3/27/14
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class AbstractEditTripPopup[T](driver: WebDriver, parentPage: T){

  driver.switchTo.frame(driver.findElement(By.id(IFRAME_ID)))

  def getPopupTitle = {
    val HeaderEle = driver.findElement(By.className(TITLE_CLASS))
    HeaderEle.getText
  }

  def getEditPopupEditableFieldNames = {
    val fieldNamesEls = driver.findElements(By.xpath("//td[" + hasCssClass("labelHolder") + "]//label")).asScala
    val fieldNames = fieldNamesEls.map(_.getText).toList
    var fieldsList: List[String] = List()
    for(fieldName<- fieldNames) {
      fieldsList =fieldsList :::List(fieldName.substring(0,fieldName.indexOf(":")))
    }
    fieldsList
  }

  def getLabelNames = {
    val fieldNamesEls = driver.findElements(By.tagName("label")).asScala
    val fieldNames = fieldNamesEls.map(_.getText).toList
    fieldNames
  }

  def getStartOdometerReading = {
    val startOdoEl= driver.findElement(By.id(START_ODOMETER_ID))
    val startOdoReading = startOdoEl.getAttribute("value")
    startOdoReading
  }

  def setStartOdometerReading(startOdoReading: String)= {
    if(!startOdoReading.equalsIgnoreCase("NA")){
      val startOdoEl= driver.findElement(By.id(START_ODOMETER_ID))
      startOdoEl.clear()
      startOdoEl.sendKeys(startOdoReading)
      startOdoEl.click()
    }
    this
  }

  def getEndOdometerReading= {
    val endOdoEl= driver.findElement(By.id(END_ODOMETER_ID))
    val endOdoReading = endOdoEl.getAttribute("value")
    endOdoReading
  }

  def setEndOdometerReading(endOdoReading: String)= {
    if(!endOdoReading.equalsIgnoreCase("NA")){
      val endOdoEl= driver.findElement(By.id(END_ODOMETER_ID))
      endOdoEl.clear()
      endOdoEl.sendKeys(endOdoReading)
      endOdoEl.click()
    }
    this
  }

  def getStartOdometerTextColor = {
    val startOdoEl= driver.findElement(By.id(START_ODO_LABEL_ID))
    val textColorCode =startOdoEl.getCssValue("color")
    var textColor = ""
    if(textColorCode.equals("rgba(153, 0, 0, 1)")) {
      textColor = "Red"
    }
    if(textColorCode.equals("rgba(0, 0, 0, 1)")) {
      textColor = "Black"
    }
    textColor
  }

  def getEndOdometerTextColor = {
    val startOdoEl= driver.findElement(By.id(END_ODO_LABEL_ID))
    val textColorCode =startOdoEl.getCssValue("color")
    var textColor = ""
    if(textColorCode.equals("rgba(153, 0, 0, 1)")) {
      textColor = "Red"
    }
    if(textColorCode.equals("rgba(0, 0, 0, 1)")) {
      textColor = "Black"
    }
    textColor
  }

  def getCommuterDistanceTextColor = {
    val startOdoEl= driver.findElement(By.id(COMMUTER_DISTANCE_LABEL_ID))
    val textColorCode =startOdoEl.getCssValue("color")
    var textColor = ""
    if(textColorCode.equals("rgba(153, 0, 0, 1)")) {
      textColor = "Red"
    }
    if(textColorCode.equals("rgba(0, 0, 0, 1)")) {
      textColor = "Black"
    }
    textColor
  }

  def getStartOdometerFieldBorderColor = {
    val startOdoEl= driver.findElement(By.id(START_ODOMETER_ID))
    val borderColorCode =startOdoEl.getCssValue("border-top-color")
    var borderColor = ""
    if(borderColorCode.equals("rgba(153, 0, 0, 1)")) {
      borderColor = "Red"
    }
    if(borderColorCode.equals("rgba(0, 0, 0, 1)")) {
      borderColor = "Black"
    }
    borderColor
  }

  def getEndOdometerFieldBorderColor = {
    val endOdoEl= driver.findElement(By.id(END_ODOMETER_ID))
    val borderColorCode =endOdoEl.getCssValue("border-top-color")
    var borderColor = ""
    if(borderColorCode.equals("rgba(153, 0, 0, 1)")) {
      borderColor = "Red"
    }
    if(borderColorCode.equals("rgba(0, 0, 0, 1)")) {
      borderColor = "Black"
    }
    borderColor
  }

  def getCommuterDistanceFieldBorderColor = {
    val endOdoEl= driver.findElement(By.id(COMMUTER_DISTANCE_ID))
    val borderColorCode =endOdoEl.getCssValue("border-top-color")
    var borderColor = ""
    if(borderColorCode.equals("rgba(153, 0, 0, 1)")) {
      borderColor = "Red"
    }
    if(borderColorCode.equals("rgba(0, 0, 0, 1)")) {
      borderColor = "Black"
    }
    borderColor
  }

  def getStartOdometerDateTime = {
    val DateTimeEls = driver.findElements(By.className(DATE_TIME_CLASS)).asScala
    val startOdoTimeAndDate =  DateTimeEls.head.getText
    startOdoTimeAndDate
  }

  def getEndOdometerDateTime = {
    val DateTimeEls = driver.findElements(By.className(DATE_TIME_CLASS)).asScala
    val endOdoTimeAndDate =  DateTimeEls(1).getText
    endOdoTimeAndDate
  }

  def getStartOdometerAddress = {
    val addressEls = driver.findElements(By.className(ADDRESS_CLASS)).asScala
    val address = addressEls.head.getText
    address
  }

  def getEndOdometerAddress = {
    val addressEls = driver.findElements(By.className(ADDRESS_CLASS)).asScala
    val address = addressEls(1).getText
    address
  }

  def verifyStartOdoImagePresent(): Boolean = {
    var imagePresentFlag = false
    try {
      val startOdoImageEl = driver.findElement(By.id(START_ODOMETER_IMAGE_ID))
      imagePresentFlag = startOdoImageEl.isDisplayed
    }
    catch {
      case e: Exception => //logger.debug("Start Odometer Image is not present")
    }
    imagePresentFlag
  }

  def verifyEndOdoImagePresent(): Boolean = {
    var imagePresentFlag = false
    try {
      val endOdoImageEl = driver.findElement(By.id(END_ODOMETER_IMAGE_ID))
      imagePresentFlag = endOdoImageEl.isDisplayed
    }
    catch {
      case e: Exception => //logger.debug("End Odometer Image is not present")
    }
    imagePresentFlag
  }

  def verifyStartOdoImageCorrupted(): Boolean = {
    var corruptImagePresentFlag = false
    try {
      val startOdoCorruptImageEl = driver.findElement(By.xpath("//div[@id = '" + START_ODOMETER_IMAGE_ID + "']//img[@title = 'Image got corrupted']" ))
      corruptImagePresentFlag = startOdoCorruptImageEl.isDisplayed
    }
    catch {
      case e: Exception => //logger.debug("Start Odometer Image is not Corrupted")
    }
    corruptImagePresentFlag
  }

  def verifyEndOdoImageCorrupted(): Boolean = {
    var corruptImagePresentFlag = false
    try {
      val endOdoCorruptImageEl = driver.findElement(By.xpath("//div[@id = '" + END_ODOMETER_IMAGE_ID + "']//img[@title = 'Image got corrupted']" ))
      corruptImagePresentFlag = endOdoCorruptImageEl.isDisplayed
    }
    catch {
      case e: Exception => //logger.debug("End Odometer Image is not Corrupted")
    }
    corruptImagePresentFlag
  }

  def deleteStartOdometerImage() {
    val deleteIcon = driver.findElement(By.id(DELETE_START_ODO_ICON_ID))
    deleteIcon.click()
  }

  def deleteEndOdometerImage() {
    val deleteIcon = driver.findElement(By.id(DELETE_END_ODO_ICON_ID))
    deleteIcon.click()
  }

  def verifyStartOdometerImageBrowseButtonPresent(): Boolean = {
    var flag = false
    try {
      val startOdoBrowseButton = driver.findElement(By.id(START_ODO_BROWSE_BUTTON_ID))
      flag = startOdoBrowseButton.isDisplayed
    }
    catch {
      case e: Exception => //logger.debug("Start Odometer Image Browse Button is not present")
    }
    flag
  }

  def verifyEndOdometerImageBrowseButtonPresent(): Boolean = {
    var flag = false
    try {
      val endOdoBrowseButton = driver.findElement(By.id(END_ODO_BROWSE_BUTTON_ID))
      flag = endOdoBrowseButton.isDisplayed
    }
    catch {
      case e: Exception => //logger.debug("End Odometer Image Browse Button is not present")
    }
    flag
  }

  def uploadStartOdometerImage() = {
    val uploadImageButton = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.id(START_ODOMETER_IMAGE_UPLOAD_BUTTON_ID)))
    uploadImageButton.click()
  }

  def uploadEndOdometerImage() = {
    val uploadImageButton = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.id(END_ODOMETER_IMAGE_UPLOAD_BUTTON_ID)))
    uploadImageButton.click()
  }

  def getOdometerDistance: String = {
    sleepTime((minWaitTime/2)*1000)
    val tripNotes = getCurrentTripNotes
    editNotes(tripNotes)
    driver.findElement(By.id(ODOMETER_DISTANCE_ID)).click()
    sleepTime((minWaitTime/2)*1000)
    val odometerDistanceEl = driver.findElement(By.id(ODOMETER_DISTANCE_ID))
    odometerDistanceEl.getText
  }

  def getGpsDistance: String = {
    val gpsDistanceEl = driver.findElement(By.xpath("//td[" + hasCssClass(GPS_DISTANCE_CLASS) + "]//..//td[2]"))
    gpsDistanceEl.click()
    gpsDistanceEl.getText
  }
  
  def getSuggestedRouteDistance= {
    val suggestedRouteDistanceEl = driver.findElement(By.xpath("//td[" + hasCssClass(SUGGESTED_ROUTE_DISTANCE_CLASS) + "]//..//td[2]"))
    suggestedRouteDistanceEl.click()
    suggestedRouteDistanceEl.getText
  }

  def getCommuterDistance= {
    val commuterDistanceEl= driver.findElement(By.id(COMMUTER_DISTANCE_ID))
    val commuterDistance = commuterDistanceEl.getAttribute("value")
    commuterDistance
  }

  def setCommuterDistance(commuterDistance: String)= {
    if(!commuterDistance.equalsIgnoreCase("NA")){
      val commuterDistanceEl= driver.findElement(By.id(COMMUTER_DISTANCE_ID))
      commuterDistanceEl.clear()
      commuterDistanceEl.sendKeys(commuterDistance)
    }
    this
  }

  def getCategoryReimbursementRate: String= {
    val reimburseRate =driver.findElement(By.id(CATEGORY_REIMBURSEMENT_RATE_ID)).getText
    reimburseRate
  }

  def getSelectedCategoryName = {
    val selectedCategory = driver.findElement(By.xpath("//td//select[@id = '"+CATEGORY_ID+"']//option[@selected]")).getText
    selectedCategory
  }

  def getSelectedPurposeName = {
    val selectedPurpose = driver.findElement(By.xpath("//td//select[@id = '"+PURPOSE_ID+"']//option[@selected]")).getText
    selectedPurpose
  }

  def editCategory(categoryName: String)= {
    if(!categoryName.equalsIgnoreCase("NA")){
      val categoryEl = driver.findElement(By.id(CATEGORY_ID))
      val categorySelect: Select = new Select(categoryEl)
      categorySelect.selectByVisibleText(categoryName)
    }
    this
  }

  def editPurpose(purposeName: String)= {
    if(!purposeName.equalsIgnoreCase("NA")){
      val purposeEl = driver.findElement(By.id(PURPOSE_ID))
      val purposeSelect: Select = new Select(purposeEl)
      purposeSelect.selectByVisibleText(purposeName)
    }
    this
  }

  def getVisibleCategoryNamesFromDropDownList = {
    val categoryEl = driver.findElement(By.id(CATEGORY_ID))
    categoryEl.click()
    val categoryEls = driver.findElements(By.xpath("//select[@id = '"+CATEGORY_ID+"']//option")).asScala
    val visibleCategoriesList = categoryEls.map(_.getText)
    visibleCategoriesList.toList
  }

  def getVisiblePurposeNamesFromDropDownList = {
    val purposeEl = driver.findElement(By.id(PURPOSE_ID))
    purposeEl.click()
    val purposeEls = driver.findElements(By.xpath("//select[@id = '"+PURPOSE_ID+"']//option")).asScala
    val visiblePurposeList = purposeEls.map(_.getText)
    visiblePurposeList.toList
  }

  def getCategoryDeletedMessage = {
    val categoryDeletedMessage = driver.findElement(By.id(DELETED_CATEGORY_INFO_ID)).getText
    categoryDeletedMessage
  }

  def getPurposeDeletedMessage = {
    val purposeDeletedMessage = driver.findElement(By.id(DELETED_PURPOSE_INFO_ID)).getText
    purposeDeletedMessage
  }

  def getLinkedJob = {
    val jobEl = driver.findElement(By.id(LINKED_JOB_KEY_ID))
    val job =  jobEl.getAttribute("value")
    job
  }

  def setLinkedJob(jobKey: String) = {
    val jobEl = driver.findElement(By.id(LINKED_JOB_KEY_ID))
    if(!(jobKey.equalsIgnoreCase("NA")||jobKey.equalsIgnoreCase("-"))) {
       jobEl.clear()
       jobEl.sendKeys(jobKey)
     }
    if(jobKey.isEmpty){
      jobEl.clear()
      jobEl.sendKeys("JJJJJJJJ")
      jobEl.clear()
    }
    this
  }

  def selectJobFromVisibleJobsOnEnteringJobKey(jobKey: String){
    setLinkedJob(jobKey)
    sleepTime(minWaitTime*1000)
    if(!jobKey.isEmpty) {
      val jobListDropDownEL = driver.findElement(By.xpath("//div[@id = '"+JOB_COMBO_BOX_DROPDOWN_ID+"']//span[contains(text(),'" + jobKey +"')]"))
      jobListDropDownEL.click()
    }
    sleepTime((minWaitTime/2)*1000)
    clickOnFrame()
  }

  def selectJobFromVisibleJobsOnClickingDropDownButton(jobKey: String) {
    clickJobListDropDownMenu()
    sleepTime(minWaitTime*1000)
    if(!jobKey.isEmpty) {
      val jobListDropDownEL = driver.findElement(By.xpath("//div[@id = '"+JOB_COMBO_BOX_DROPDOWN_ID+"']//span[contains(.//text(),'" + jobKey + "')]"))
      jobListDropDownEL.click()
    }
    sleepTime((minWaitTime/2)*1000)
    clickOnFrame()
  }

  def clickJobListDropDownMenu() {
    val jobListDropDownEl = driver.findElement(By.xpath("//div[@id= '"+JOB_COMBO_BOX_DROPDOWN_BUTTON_ID+"']//div//input["+ hasCssClass(JOB_COMBO_BOX_DROPDOWN_BUTTON_CLASS) +"]"))
    jobListDropDownEl.click()
  }

  def getVisibleJobNameAndIdListFromDropDown = {
    val JobIdListEl = driver.findElements(By.xpath("//div[@id = '"+JOB_COMBO_BOX_ID+"']//div[@role='option']")).asScala
    val jobIdList = JobIdListEl.filter(_.getText.nonEmpty).map(_.getText).toList
    jobIdList
  }

  def getAdditionalExpenses = {
    val additionalExpensesEl= driver.findElement(By.id(ADDITIONAL_EXPENSES_ID))
    val additionalExpenses = additionalExpensesEl.getAttribute("value")
    additionalExpenses
  }

  def setAdditionalExpenses(additionalExpense: String)= {
    if(!additionalExpense.equalsIgnoreCase("NA")){
      val additionalExpensesEl= driver.findElement(By.id(ADDITIONAL_EXPENSES_ID))
      additionalExpensesEl.clear()
      additionalExpensesEl.sendKeys(additionalExpense)
    }
    this
  }

  def getTotalExpense = {
    val totalExpenseEl = driver.findElement(By.id(TOTAL_EXPENSE_ID))
    clickOnFrame()
    totalExpenseEl.getText
  }

  def getVehicleId= {
    val vehicleIdEl= driver.findElement(By.id(VEHICLE_ID_FILED_ID))
    val vehicleId = vehicleIdEl.getAttribute("value")
    vehicleId
  }

  def setVehicleId(vehicleId: String)= {
    if(!vehicleId.equalsIgnoreCase("NA")){
      val vehicleEl= driver.findElement(By.id(VEHICLE_ID_FILED_ID))
      vehicleEl.clear()
      vehicleEl.sendKeys(vehicleId)
    }
    this
  }

  def getCurrentTripNotes = {
    val notesEl = driver.findElement(By.id(TRIP_NOTES_ID))
    val notes = notesEl.getAttribute("value")
    notes
  }

  def editNotes(notes: String) {
   if(!notes.equalsIgnoreCase("NA")){
     val notesEl = driver.findElement(By.id(TRIP_NOTES_ID))
     notesEl.clear()
     notesEl.sendKeys(notes)
   }
  }

  def cancel() ={
    val cancelButton = driver.findElement(By.id(CANCEL_BUTTON_ID))
    cancelButton.click()
    driver.switchTo().defaultContent()
    parentPage
  }

  def saveAndClose() ={
    val saveAndCloseButton = driver.findElement(By.id(SAVE_AND_CLOSE_BUTTON_ID))
    saveAndCloseButton.click()
    sleepTimeInSecond(4)
    driver.switchTo().defaultContent()
    parentPage
  }

  def getButtonNames = {
    val buttonEls = driver.findElements(By.xpath("//div[" + hasCssClass(BUTTON_CLASS) + "]//a")).asScala
    val buttonsList = buttonEls.map(_.getText).toList
    buttonsList
  }

  def closeEditTripPopup() = {
    val outsideIframeEL = driver.switchTo.defaultContent()
    val crossMarkEl = outsideIframeEL.findElement(By.className(CLOSE_MARK_ID))
    crossMarkEl.click()
    parentPage
  }

  def clickOnFrame(){
     val purposeDropDownEl = driver.findElement(By.id(PURPOSE_ID))
    purposeDropDownEl.click()
    purposeDropDownEl.click()
    sleepTime((minWaitTime/2)*1000)
  }

  def getErrorMessage: List[String] = {
    sleepTime(minWaitTime*1000)
    val errorMessages = driver.findElements(By.className(ERROR_MESSAGE_CLASS)).asScala
    val errors = errorMessages.map(_.getText.trim).toList.filter(!_.isEmpty)
    errors
  }

  def saveAndCloseButtonEnabled() = {
    var enabled = true
    val saveAndCloseButton = driver.findElement(By.id(SAVE_AND_CLOSE_BUTTON_ID))
    val saveAndCloseButtonClassName = saveAndCloseButton.getAttribute("class")
    if(saveAndCloseButtonClassName.contains("disabledButton"))
    {
      enabled = false
    }
    enabled
  }

  def getFieldColor(fieldName: String)= {
    clickOnFrame()
    sleepTime(minWaitTime*1000)
    var fieldColour = ""
    val fieldEl = fieldName match  {
      case "Start Odometer" =>  driver.findElement(By.id(START_ODOMETER_ID))
      case "End Odometer"  =>  driver.findElement(By.id(END_ODOMETER_ID))
      case "Commuter Distance"  =>  driver.findElement(By.id(COMMUTER_DISTANCE_ID))
      case "Category" => driver.findElement(By.id(CATEGORY_ID))
      case "Purpose" => driver.findElement(By.id(PURPOSE_ID))
      case "Job" =>  driver.findElement(By.id(LINKED_JOB_KEY_ID))
      case "Additional Expenses" =>  driver.findElement(By.id(ADDITIONAL_EXPENSES_ID))
      case "Vehicle ID" => driver.findElement(By.id(VEHICLE_ID_FILED_ID))
      case "Notes" => driver.findElement(By.id(TRIP_NOTES_ID))
    }
    val colorCode =fieldEl.getCssValue("background-color")
    if(colorCode.equals("rgba(0, 0, 0, 0)")) {
      fieldColour = "Transparent"
    }
    if(colorCode.equals("rgba(255, 255, 255, 1)")) {
      fieldColour = "White"
    }
    if(colorCode.equals("rgba(237, 228, 204, 1)")) {
      fieldColour = "Yellow"
    }
    fieldColour
  }

}

object AbstractEditTripPopup {
  val IFRAME_ID = "xrCommonDialogIFrame"
  val TITLE_CLASS = "popupSectionHeadline"
  val START_ODOMETER_ID = "startOdometer"
  val END_ODOMETER_ID = "endOdometer"
  val START_ODO_LABEL_ID = "startOdometer_label"
  val END_ODO_LABEL_ID = "endOdometer_label"
  val DATE_TIME_CLASS = "time"
  val ADDRESS_CLASS = "address"
  val START_ODOMETER_IMAGE_UPLOAD_BUTTON_ID = "startOdometerImageFile"
  val END_ODOMETER_IMAGE_UPLOAD_BUTTON_ID = "endOdometerImageFile"
  val START_ODOMETER_IMAGE_ID = "startOdometerImageHolder"
  val END_ODOMETER_IMAGE_ID = "endOdometerImageHolder"
  val DELETE_START_ODO_ICON_ID = "startOdometerImageDeleteIcon"
  val DELETE_END_ODO_ICON_ID = "endOdometerImageDeleteIcon"
  val START_ODO_BROWSE_BUTTON_ID = "startOdometerImageFile"
  val END_ODO_BROWSE_BUTTON_ID = "endOdometerImageFile"
  val ODOMETER_DISTANCE_ID = "odometerDistance_holder"
  val GPS_DISTANCE_CLASS = "distanceGPSLabelHolder"
  val SUGGESTED_ROUTE_DISTANCE_CLASS = "distanceSuggestedRouteLabelHolder"
  val COMMUTER_DISTANCE_ID = "commuterDistance"
  val COMMUTER_DISTANCE_LABEL_ID = "commuterDistance_label"
  val CATEGORY_ID = "categoryId"
  val DELETED_CATEGORY_INFO_ID = "categoryInfo"
  val CATEGORY_REIMBURSEMENT_RATE_ID = "reimbursementRate_holder"
  val PURPOSE_ID = "purposeId"
  val DELETED_PURPOSE_INFO_ID = "purposeInfo"
  val LINKED_JOB_KEY_ID = "jobComboBox"
  val JOB_COMBO_BOX_ID = "jobComboBox_popup"
  val JOB_COMBO_BOX_DROPDOWN_ID= "widget_jobComboBox_dropdown"
  val JOB_COMBO_BOX_DROPDOWN_BUTTON_ID = "widget_jobComboBox"
  val JOB_COMBO_BOX_DROPDOWN_BUTTON_CLASS = "dijitArrowButtonInner"
  val ADDITIONAL_EXPENSES_ID = "additionalExpenses"
  val TOTAL_EXPENSE_ID = "totalReimbursement_holder"
  val VEHICLE_ID_FILED_ID = "vehicleId"
  val TRIP_NOTES_ID = "notes"
  val CANCEL_BUTTON_ID = "cancel"
  val SAVE_AND_CLOSE_BUTTON_ID = "submit"
  val CLOSE_MARK_ID = "close"
  val EDIT_TRIP_POPUP_FRAME_ID = "popupContentFrame"
  val ERROR_MESSAGE_CLASS = "errorMessage"
  val BUTTON_CLASS = "buttonPanel"

}


