package com.xora.mc.pages.locations

//import com.xora.mc.pages.newreports.RunReportPopup
import com.xora.mc.pages.{DisplayFilterPage, GroupFilterPopup}
import org.openqa.selenium.{ WebElement, By, WebDriver}
import org.openqa.selenium.support.ui.{Select, ExpectedConditions, WebDriverWait, LoadableComponent}
import com.xora.mc.util.LoadableElement
import com.xora.mc.pages.locations.LocationListPage._
import scala.collection.JavaConverters._
import com.xora.util.SleepTime._
import com.xora.mc.util.XpathUtils._
import com.xora.mc.pages.jobs.JobListPage
import com.xora.mc.pages.workers.WorkerListPage
//import com.xora.mc.pages.user.UserListPage


/**
 * Page object for Location list page
 * Locations --> Location list
 */
class LocationListPage(val driver: WebDriver, val baseUrl: java.lang.String)
  extends LoadableComponent[LocationListPage]
  with LoadableElement {

  var locationRowEl: WebElement = _

  def load() {
    val url = baseUrl + "/location/list/doList.page"
    driver.get(url)
  }

  def isLoaded() {
    verifyElementLoaded(driver, By.xpath(LocationListPage.PAGE_TITLE_XPATH))
  }

  def getPageHeader(): String = {
    val pageHeaderEl = driver.findElement(By.className(TITLE_CLASS))
    val pageHeadline = pageHeaderEl.getText.trim
    pageHeadline
  }

  def getColumnNames: List[String] = {
    val groupTableEl = driver.findElement(By.xpath(LOCATION_BASE_XPATH))
    val tableHeadersEls = groupTableEl.findElements(By.tagName("th")).asScala
    val tableHeaderNamesList = tableHeadersEls.map(_.getText.trim).toList.patch(0, Nil, 1)
    tableHeaderNamesList
  }

  def validateRefreshButtonIsClickable() = {
    var flag = false
    val refreshButton = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className(REFRESH_BUTTON_CLASS)))
    if(refreshButton.isDisplayed) {
      flag = true
    }
    flag
  }

  def validateDownloadExcelSymbolPresent()= {
    var flag = false
    val excelDownloadIcon = driver.findElement(By.id(DOWNLOAD_LIST_ID))
    if(excelDownloadIcon.isDisplayed) {
      flag = true
    }
    flag
  }

  def getElementsPresentInToolbar() = {
    val toolBarEl = driver.findElement(By.id(TOOL_BAR_ID))
    val toolBarsListEls = toolBarEl.findElements(By.tagName("tr")).asScala
    val toolBarValuesList = toolBarsListEls.filter(!_.getText.contains("Date Filter")).filter(_.getText.nonEmpty).map(_.getText.trim).toList.patch(7,Nil,1)
    toolBarValuesList
  }

  def presenceOfDateFilter() = {
    val dateFilterEl = driver.findElement(By.id(DATE_FILTER_ID))
    val flag = dateFilterEl.isDisplayed
    flag
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

  def validateExpandSearchBox() = {
    var flag = false
    val toolBarEl = driver.findElement(By.id(SEARCH_BOX_EXPAND_OR_COLLAPSE_IMAGE_ID))
    if(toolBarEl.getAttribute("src").contains(EXPAND_IMAGE)){
      toolBarEl.click()
    }
    if(toolBarEl.getAttribute("src").contains(COLLAPSE_IMAGE)){
      flag = true
    }
    flag
  }

  def validateCollapseSearchBox() = {
    var flag = false
    val toolBarEl = driver.findElement(By.id(SEARCH_BOX_EXPAND_OR_COLLAPSE_IMAGE_ID))
    if(toolBarEl.getAttribute("src").contains(COLLAPSE_IMAGE)){
      toolBarEl.click()
    }
    if(toolBarEl.getAttribute("src").contains(EXPAND_IMAGE)){
      flag = true
    }
    flag
  }

  def searchJob(searchKey: String) = {
    enterSearchKeyAndKeywordType(searchKey,"Jobs")
    new JobListPage(driver,baseUrl)
  }
  def searchWorker(searchKey: String) = {
    enterSearchKeyAndKeywordType(searchKey,"Workers")
    new WorkerListPage(driver,baseUrl)
  }
  def searchLocation(searchKey: String) = {
    enterSearchKeyAndKeywordType(searchKey,"Locations")
    new LocationListPage(driver,baseUrl)
  }
//  def searchUser(searchKey: String) = {
//    enterSearchKeyAndKeywordType(searchKey,"Users")
//    new UserListPage(driver,baseUrl)
//  }

  // keywordType can be "Jobs", "Workers", "Locations", "Users"
  private def enterSearchKeyAndKeywordType(searchKey: String, keywordType: String){
    val searchOption: WebElement = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.id(SEARCH_OPTION_FIELD_ID)))
    val searchInputText: WebElement = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.id(SEARCH_INPUT_TEXT_ID)))

    val searchButton = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.id(SEARCH_BUTTON_ID)))

    new Select(searchOption).selectByVisibleText(keywordType)
    searchInputText.clear()
    searchInputText.sendKeys(searchKey)
    searchButton.click()
    Thread.sleep(2000)
  }



//  def createLocation() = {
//    val createLocationEl = new WebDriverWait(driver, maxWaitTime)
//      .until(ExpectedConditions.elementToBeClickable(By.id(CREATE_LOCATION_ID)))
//    createLocationEl.click()
//    new CreateLocationPopup(driver, this)
//  }

//  def uploadLocation() ={
//    val uploadLocationButtonEl = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.id(UPLOAD_LOCATION_ID)))
//    uploadLocationButtonEl.click()
//    new UploadLocationPopup(driver,this)
//  }

  private def findLocationRow(locationName: String) = {
    val locationRowXpath = LOCATION_BASE_XPATH + "//td[2][text()='" + locationName + "']//.."
    val locationRowEL = driver.findElement(By.xpath(locationRowXpath))
    locationRowEL
  }

  def contextMenuOfLocation(locationName: String): LocationsPageContextMenuPopup = {
    val locationRowEl = findLocationRow(locationName)
    locationRowEl.click()
    new LocationsPageContextMenuPopup(driver, this)
  }

  def getAllLocationNames : List[String] = {
    val locationNameElXpath = LOCATION_BASE_XPATH + "//tr/td[2]"
    val locationNamesEls = driver.findElements(By.xpath(locationNameElXpath)).asScala
    val locationsNameList = locationNamesEls.map(_.getText.trim).toList
    locationsNameList
  }

  def getLocationType(locationName: String) = {
    val locationTypeEl  = driver.findElement(By.xpath(LOCATION_BASE_XPATH + "//td[2][text()='" + locationName + "']//..//td[4]"))
    locationTypeEl.getText.trim
  }

  def getLocationAddress(locationName: String) = {
    val locationAddressEl  = driver.findElement(By.xpath(LOCATION_BASE_XPATH + "//td[2][text()='" + locationName + "']//..//td[5]"))
    var address: String = ""
    val locationAddr =  locationAddressEl.getText.split("\n")
    for (i <- 0 until locationAddr.size ){
      address = address + " " + locationAddr(i)
    }
    address.trim
  }

  def selectAllCheckBox() {
    val selectAllCheckBox = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id(SELECT_ALL_CHECKBOX_ID)))
    selectAllCheckBox.click()
  }

  def clickDeleteLocationButtonInToolBarAndAcceptDialog() = {
    val deleteLocationButtonEl = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.id(DELETE_LOCATION_BUTTON_TOOL_BAR_ID)))
    deleteLocationButtonEl.click()
    try{
      acceptDeleteDialog()
    }
    catch{
      case e : Exception =>{
        val noLocationsToDeleteDialog = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[" + hasCssClass(DIALOG_ALERT_CLASS) + "]")))
        val okButton = noLocationsToDeleteDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "OK" + "']"))
        okButton.click()
        sleepTime(minWaitTime * 2000)
        driver.switchTo.defaultContent
        new WebDriverWait(driver, 40).until(ExpectedConditions.invisibilityOfElementLocated(By.id(XORA_UNDERLAY_ID)))
      }
    }
    this
  }

  def clickDeleteLocationButtonInToolBarAndRejectDialog() ={
    val deleteLocationButtonEl = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.id(DELETE_LOCATION_BUTTON_TOOL_BAR_ID)))
    deleteLocationButtonEl.click()
    cancelDeleteDialog()
    this
  }

  private def acceptDeleteDialog() {
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val deleteButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Delete" + "']"))
    deleteButton.click()
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]")))
  }

  private def cancelDeleteDialog() {
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    Thread.sleep(2000)
    val cancelButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Cancel" + "']"))
    Thread.sleep(1000)
    cancelButton.click()
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]")))
  }

  def selectCheckBoxesByLocationNames(locations: List[String]) {
    for (location <- locations){
      val locationTypeEl = findLocationRow(location)
      val checkBoxEl = locationTypeEl.findElement(By.tagName(CHECKBOX_TAG_NAME))
      checkBoxEl.click()
    }
  }

  def clickSendToWorkerButtonInToolBar() = {
    val sendToWorkerEl = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id(SEN_TO_WORKER_BUTTON_ID_IN_TOOL_BAR)))
    sendToWorkerEl.click()
    new SendLocationToWorkerPopup(driver, this)
  }

  def groupFilter = {
    val groupFilterButtonEl = driver.findElement(By.cssSelector("a#groupFilter"))
    groupFilterButtonEl.click()
    new GroupFilterPopup(driver)
  }

  def displayFilter = {
    val displayFilterButtonEl = driver.findElement(By.cssSelector("a#displayFilter"))
    displayFilterButtonEl.click()
    new DisplayFilterPage(driver)
  }

}


object LocationListPage {
  val PAGE_TITLE = "Locations"
  val TITLE_CLASS = "pageHeadlineText"
  val PAGE_TITLE_XPATH = "//*[@class='" + TITLE_CLASS + "' and .//text()='" + PAGE_TITLE + "']"
  val CREATE_LOCATION_ID = "create"
  val UPLOAD_LOCATION_ID = "upload"
  val TABLE_ID = "Location"
  val LOCATION_BASE_XPATH = "//table[@id='" + TABLE_ID + "']"
  val SEARCH_OPTION_FIELD_ID = "resourceUrl"
  val SEARCH_INPUT_TEXT_ID = "searchInput"
  val SEARCH_BUTTON_ID = "searchButton"
  val SEARCH_OPTION= "Locations"
  val SELECT_ALL_CHECKBOX_ID = "selectAll"
  val DELETE_LOCATION_BUTTON_TOOL_BAR_ID = "delete"
  val DIALOG_ALERT_CLASS = "dialog dialog-alert"
  val DIALOG_CONFIRM_CLASS = "dialog dialog-confirm"
  val DIALOG_BUTTON_CLASS = "linkButton"
  val XORA_UNDERLAY_ID = "xora-underlay"
  val CHECKBOX_TAG_NAME = "input"
  val SEN_TO_WORKER_BUTTON_ID_IN_TOOL_BAR = "LocationSend"
  val REFRESH_BUTTON_CLASS = "refreshNowButton"
  val DOWNLOAD_LIST_ID = "downloadList"
  val TOOLBAR_CLASS = "linkButtonActionTool"
  val TOOL_BAR_ID = "locations.list.toolbar.contentWidget"
  val TOOL_BAR_EXPAND_OR_COLLAPSE_IMAGE_ID = "locations.list.toolbar.contentWidgetImage"
  val SEARCH_BOX_EXPAND_OR_COLLAPSE_IMAGE_ID = "search.contentWidgetImage"
  val COLLAPSE_IMAGE = "widget_Collapse.gif"
  val EXPAND_IMAGE = "widget_Expand.gif"
  val DATE_FILTER_ID = "inline-date-filter-container"
  val LOCATION_REPORT_BUTTON_ID = "reports"
  val REPORT_MENU_ID = "menuBody"
}
