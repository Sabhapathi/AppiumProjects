package com.xora.mc.pages.mileage

import java.util

import com.xora.mc.pages.mileage.MileageConfigurePage._
import com.xora.mc.util.LoadableElement
import com.xora.util.Optionally
import com.xora.util.SleepTime._
import org.openqa.selenium.support.ui.{ExpectedConditions, LoadableComponent, WebDriverWait}
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.scalatest.concurrent.Eventually
import org.scalatest.time.{Millis, Seconds, Span}

import scala.Predef._
import scala.collection.JavaConverters._
import scala.util.control._

/**
 * Created with IntelliJ IDEA.
 * User: Nandini
 * Date: 8/22/13
 * Time: 11:35 AM
 * To change this template use File | Settings | File Templates.
 */
class MileageConfigurePage(val driver: WebDriver, val baseUrl: String)
  extends LoadableComponent[MileageConfigurePage]
  with LoadableElement with Optionally with Eventually  {


  def load() {
    val url = baseUrl + "/mileage/configure/doList.page"
    driver.get(url)
  }

  def isLoaded() {
    verifyElementLoaded(driver, By.xpath(PAGE_TITLE_XPATH))
  }

  def enableCategory() {
    configureCheckbox("Category", "enable")
  }

  def disableCategory() {
    configureCheckbox("Category", "disable")
  }

  def enablePurpose() {
    configureCheckbox("Purpose", "enable")
  }

  def disablePurpose() {
    configureCheckbox("Purpose", "disable")
  }

  def enableCommuterDistance() {
    configureCheckbox("CommuterDistance", "enable")
  }

  def disableCommuterDistance() {
    configureCheckbox("CommuterDistance", "disable")
  }

  def enableVehicleId() {
    configureCheckbox("VehicleId", "enable")
  }

  def disableVehicleId() {
    configureCheckbox("VehicleId", "disable")
  }

  def configureCheckbox(checkBoxName: String, status: String)= {
    val mainEl = driver.findElement(By.id(MAIN_CONTENT))
    val checkboxId = checkBoxName match {
      case "Category" => ENABLE_CATEGORY
      case "Purpose" => ENABLE_PURPOSE
      case "CommuterDistance" => ENABLE_COMMUTER_DISTANCE
      case "VehicleId" => ENABLE_VEHICLE_ID
    }
    val enableEl = mainEl.findElement(By.id(checkboxId)).isSelected
    if (status.equals("enable")) {
      if (!enableEl) {
        mainEl.findElement(By.id(checkboxId)).click()
      }
    }
    else if (status.equals("disable")) {
      if (enableEl) {
        mainEl.findElement(By.id(checkboxId)).click()
      }
    }
  }


  def getPageHeader: String = {
    val pageHeaderEl = driver.findElement(By.className(TITLE_CLASS))
    val pageHeadline = pageHeaderEl.getText.trim
    pageHeadline
  }

  def validateTripListPage()={
    driver.findElement(By.id(TRIP_LIST_BUTTON)).click()
    val pageHeader = driver.findElement(By.className(TITLE_CLASS)).getText
    pageHeader
  }

  def getElementsPresentInToolbar=
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

  def presenceOfHelpIcon = {
    val helpIconEl = driver.findElement(By.id(HELP_ICON_ID))
    val flag = helpIconEl.isDisplayed && helpIconEl.isEnabled
    flag
  }

  def getNewPageHeaderOnClickingHelpLink: String = {
    val parentWindowHandle = driver.getWindowHandle
    val helpLink = driver.findElement(By.xpath("//a[@id = '"+HELP_ICON_ID+"']"))
    helpLink.click()
    sleepTime(2000)
    val windowHandles: util.Set[String] = driver.getWindowHandles
    import scala.collection.JavaConversions._
    var done = false
    for (windowHandle <- windowHandles if !done) {
      if (!(windowHandle == parentWindowHandle)) {
        driver.switchTo.window(windowHandle)
        done = true
      }
    }
    val pageHeader = driver.findElement(By.className("pageHeader")).getText
    driver.close()
    driver.switchTo().window(parentWindowHandle)
    pageHeader
  }

  def verifyEnableCommuterDistanceCheckBox() = {
    var flag = false
    try {
      new WebDriverWait(driver, 10).until(
        ExpectedConditions.presenceOfElementLocated(By.id(ENABLE_COMMUTER_DISTANCE)))
      flag = true
    }
    catch {
      case e: Exception =>
        //logger.debug("Enable Commuter Distance checkbox is not present " )
    }
    flag
  }

  def verifyEnableVehicleIdCheckBox() = {
    var flag = false
    try {
      new WebDriverWait(driver, 10).until(
        ExpectedConditions.presenceOfElementLocated(By.id(ENABLE_VEHICLE_ID)))
      flag = true
    }
    catch {
      case e: Exception =>
        //logger.debug("Enable Vehicle Id checkbox is not present " )
    }
    flag
  }

  def verifyCategoryEnableCheckBox() = {
    var flag = false
    try {
      new WebDriverWait(driver, 10).until(
        ExpectedConditions.presenceOfElementLocated(By.id(ENABLE_CATEGORY_CHECKBOX)))
      flag = true
    }
    catch {
      case e: Exception =>
        //logger.debug("Enable category checkbox is not present " )
    }
    flag
  }

  def verifyMakeCategoryVisibleCheckBox() = {
    var flag = false
    try {
      new WebDriverWait(driver, 10).until(
        ExpectedConditions.presenceOfElementLocated(By.id(MAKE_CATEGORY_VISIBLE_CHECKBOX)))
      flag = true
    }
    catch {
      case e: Exception => //logger.debug("Make category visible checkbox is not present " )
    }
    flag
  }

  def selectMakeCategoryVisibleToMobileUsersCheckbox() {
     val checkBoxEl = new WebDriverWait(driver, 10).until(
       ExpectedConditions.elementToBeClickable(By.id(MAKE_CATEGORY_VISIBLE_CHECKBOX)))
    if(!checkBoxEl.isSelected) {
      checkBoxEl.click()
    }
  }

  def getCategoryTableHeaderNames ={
    val table = driver.findElement(By.xpath(CATEGORY_BASE_XPATH))
    val headerNameEls = table.findElements(By.tagName("th")).asScala
    val headerNames = headerNameEls.map(_.getText)
    headerNames.toList
  }

  def checkDefaultCategory (defaultCategory: String) ={
    var flag = false
    val defaultCategoryRow = searchCategory(defaultCategory)
    val default= defaultCategoryRow.findElements(By.tagName("td")).asScala
    val radioButtonEnabled =  default(3).getAttribute(INNER_HTML)
    if(radioButtonEnabled.contains("checked")) {
      flag = true
    }
    flag
  }

  def addCategory() = {
    val addCategoryButton = new WebDriverWait(driver, 10).until(
      ExpectedConditions.elementToBeClickable(By.id(ADD_CATEGORY_BUTTON)))
    addCategoryButton.click()
    new AddCategoryPopup(driver, this)
  }

  def searchCategory(categoryName: String) = {
    val categoryXpath = CATEGORY_BASE_XPATH + "//tr[.//*[text()='" + categoryName + "']]"
    optionally {
      eventually(timeout(Span(3, Seconds)), interval(Span(500, Millis))) {
        val nextButtonEl = driver.findElement(By.xpath(CATEGORY_BASE_XPATH + "//span[@class='" + PAGINATION_NEXT_BUTTON + "']"))
      }
    }
    val pageIndexEls = driver.findElements(By.xpath(CATEGORY_BASE_XPATH + "//span[@class ='" + PAGINATION_CLASS_ID + "']"))
    var categoryEl: WebElement = null
    var bFlag: Boolean = false
    val loop = new Breaks
    var i = 0
    if (pageIndexEls.isEmpty) {
      categoryEl = new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(By.xpath(categoryXpath)))
    }
    else //if pagination Exists
     {
      loop.breakable {
        for (i <- 0 until pageIndexEls.size()) {
          if (i != 0)
            pageIndexEls.get(i).click()
          try {
            categoryEl = new WebDriverWait(driver, 10)
              .until(ExpectedConditions.elementToBeClickable(By.xpath(categoryXpath)))
            bFlag = true
          }
          catch {
            case e: Exception =>
              //logger.debug("Category is not present in Page " + (i + 1))
          }
          if (bFlag == true) {
            loop.break
          }
        }
      }
    }
    categoryEl
  }

  def contextMenuOfCategory(categoryName: String) = {
    val categoryEl = searchCategory(categoryName)
    sleepTime(minWaitTime*1000)
    categoryEl.click()
    sleepTime(minWaitTime*1000)
    new CategoryContextMenuPopup(driver, this)
  }

  def checkCategoryNameInTable(categoryName: String) = {
    val categoryEl = searchCategory(categoryName)
    val categoryRow: Array[String] = categoryEl.getText.split(" ")
    val categoryNameText = categoryRow(0)
    categoryNameText
  }

  def getColumnDataForCategoryTable(columnName:String) =  {
    val columnNumber = columnName match {
      case "Category" => 1
      case "Description" => 2
      case "Reimbursement" =>  3
    }
        var pageIndexEls = driver.findElements(By.xpath(CATEGORY_BASE_XPATH + "//span[@class ='" + PAGINATION_CLASS_ID + "']"))
        var columnEl = List[WebElement]()
        var columnElements = List[String]()
        if (pageIndexEls.isEmpty) {
          columnEl = driver.findElements(By.xpath(CATEGORY_BASE_XPATH + "//td["+columnNumber+"]")).asScala.toList
          val tableElementsMap = columnEl.map(_.getText)
          columnElements = tableElementsMap.toList
        }
        else {
          for (i <- 0 until pageIndexEls.size()) {
            if (i != 0) {
              sleepTime(minWaitTime*1000)
              pageIndexEls = driver.findElements(By.xpath(CATEGORY_BASE_XPATH + "//span[@class ='" + PAGINATION_CLASS_ID + "']"))
              pageIndexEls.get(i).click()
            }
            sleepTime(minWaitTime*2000)    // Time required to load the 2nd page
            columnEl = driver.findElements(By.xpath(CATEGORY_BASE_XPATH + "//td["+columnNumber+"]")).asScala.toList
            for (a <- columnEl) {
              columnElements = columnElements ::: List(a.getText)
            }
          }
          pageIndexEls = driver.findElements(By.xpath(CATEGORY_BASE_XPATH + "//span[@class ='" + PAGINATION_CLASS_ID + "']"))
          pageIndexEls.get(0).click()
        }
    columnElements
    }

  def checkPaginationPresentForCategory()=
  {
    var flag = false
    try{
      val pageIndexEls = driver.findElements(By.xpath(CATEGORY_BASE_XPATH + "//span[@class ='" + PAGINATION_CLASS_ID + "']"))
      if(pageIndexEls.size>0){
        flag = true
      }
    }
    catch {
      case e: Exception =>
        //logger.debug("Pagination not present")
    }

    flag
  }



  def countCategories()={
    val categoryTableEls = getColumnDataForCategoryTable("Category")
    val totalCategories = categoryTableEls.size
    totalCategories
  }

  def addPurpose() = {
    val addPurposeButtonEl = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.id(ADD_PURPOSE_BUTTON)))
    addPurposeButtonEl.click()
    new AddPurposePopup(driver, this)
  }

  def searchPurpose(purposeName: String) = {
    val purposeXpath: String = PURPOSE_BASE_XPATH + "//tr[.//*[contains(.//text(),'" + purposeName + "')]]"
    optionally {
      eventually(timeout(Span(3, Seconds)), interval(Span(500, Millis))) {
        val nextButtonEl = driver.findElement(By.xpath(PURPOSE_BASE_XPATH + "//span[@class='" + PAGINATION_NEXT_BUTTON + "']"))
      }
    }
    val pageIndexEls = driver.findElements(By.xpath(PURPOSE_BASE_XPATH + "//span[@class ='" + PAGINATION_CLASS_ID + "']"))
    var purposeEl: WebElement = null
    var bFlag: Boolean = false
    val loop = new Breaks
    var i = 0
    if (pageIndexEls.isEmpty) //If no pagination exists
     {
      purposeEl = new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(By.xpath(purposeXpath)))
    }
    else // If Pagination exists
     {
      loop.breakable {
        for (i <- 0 until pageIndexEls.size()) {
          if (i != 0)  {
            pageIndexEls.get(i).click()
          }
          try {
            purposeEl = new WebDriverWait(driver, 10)
              .until(ExpectedConditions.elementToBeClickable(By.xpath(purposeXpath)))
            bFlag = true
          }
          catch {
            case e: Exception =>
              //logger.debug("Purpose is not present in Page " + (i + 1))
          }
          if (bFlag == true) {
            loop.break
          }
        }
      }
    }
    purposeEl
  }


  def contextMenuOfPurpose(purposeName: String) = {
    val purposeEl = searchPurpose(purposeName)
    purposeEl.click()
    sleepTime(minWaitTime*1000)
    new PurposeContextMenuPopup(driver, this)
  }

  def checkPurposeNameInTable(purposeName: String) = {
    val purposeEl = searchPurpose(purposeName)
    val purposeRow: Array[String] = purposeEl.getText.split(" ")
    val purposeNameText = purposeRow(0)
    purposeNameText
  }

  def getPurposeTableElements = {
    optionally {
      eventually(timeout(Span(3, Seconds)), interval(Span(500, Millis))) { //Time required to load the Purpose Table
        val nextButtonEl = driver.findElement(By.xpath(PURPOSE_BASE_XPATH + "//span[@class='" + PAGINATION_NEXT_BUTTON + "']"))
      }
      }
    var pageIndexEls = driver.findElements(By.xpath(PURPOSE_BASE_XPATH + "//span[@class ='" + PAGINATION_CLASS_ID + "']"))
    var purposeTableEls = List[WebElement]()
    var tableElements = List[String]()
    if (pageIndexEls.isEmpty) {
      purposeTableEls = driver.findElements(By.xpath(PURPOSE_BASE_XPATH + "//tr//td")).asScala.toList
      val tableElementsMap = purposeTableEls.map(_.getText)
      tableElements = tableElementsMap.toList
    }
    else {
      for (i <- 0 until pageIndexEls.size()) {
        if (i != 0) {
          pageIndexEls= driver.findElements(By.xpath(PURPOSE_BASE_XPATH + "//span[@class ='" + PAGINATION_CLASS_ID + "']"))
          pageIndexEls.get(i).click()
        }
        sleepTime(minWaitTime*1000)   // Time required to load the 2nd page
        purposeTableEls = driver.findElements(By.xpath(PURPOSE_BASE_XPATH + "//tr//td")).asScala.toList
        for (a <- purposeTableEls) {
          tableElements = tableElements ::: List(a.getText)
        }
      }
    }

    tableElements
  }

  def getColumnNameOfPurpose :List[String]={
    val purposeTableEl =  new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.xpath(PURPOSE_BASE_XPATH)))
    val purposeColumnNameEls = purposeTableEl.findElements(By.tagName("th")).asScala
    val purposeColumnNamesList = purposeColumnNameEls.map(_.getText).toList
    purposeColumnNamesList
  }

  def getColumnDataForPurpose(columnName:String)={
    val result = columnName match {
      case "Purpose" => driver.findElements(By.xpath(PURPOSE_CELL_XPATH)).asScala.map(_.getText)
      case "Description" => driver.findElements(By.xpath(DESCRIPTION_CELL_XPATH)).asScala.map(_.getText)
       }
    result.toList
  }

  def verifyDefaultPurpose(purposeName: String) = {
    var flag = false
    val defaultPurposeRow = searchPurpose(purposeName)
    val default = defaultPurposeRow.findElements(By.tagName("td")).asScala
    val chkDefault =  default(2).getAttribute(INNER_HTML)
    if (chkDefault.contains("checked")){
      flag = true
    }
    flag
  }
  def countPurpose()={
    val purposeTableEls = getPurposeTableElements
    val totalPurpose = purposeTableEls.size/3
    totalPurpose
  }

  def verifyPurposePagination()={
    var flag = false
    val totalPurpose = countPurpose()
     if(totalPurpose>5){
       val pageIndexEls = driver.findElements(By.xpath(PURPOSE_BASE_XPATH + "//span[@class ='" + PAGINATION_CLASS_ID + "']"))
       if(pageIndexEls.size()>0)
         flag = true
     }
    flag
  }

  def verifyPurposeEnableCheckBox() = {
    var flag = false
    try {
      new WebDriverWait(driver, 10).until(
        ExpectedConditions.presenceOfElementLocated(By.id(ENABLE_PURPOSE_CHECKBOX)))
      flag = true
    }
    catch {
      case e: Exception =>
        //logger.debug("Enable purpose checkbox is not present " )
    }
    flag
  }

  def verifyMakePurposeVisibleCheckBox() = {
    var flag = false
    try {
      new WebDriverWait(driver, 10).until(
        ExpectedConditions.presenceOfElementLocated(By.id(MAKE_PURPOSE_VISIBLE_CHECKBOX)))
      flag = true
    }
    catch {
      case e: Exception =>
        //logger.debug("Make purpose visible checkbox is not present " )
    }
    flag
  }

  def selectMakePurposeVisibleToMobileUsersCheckbox() {
    val checkBoxEl = new WebDriverWait(driver, 10).until(
      ExpectedConditions.elementToBeClickable(By.id(MAKE_PURPOSE_VISIBLE_CHECKBOX)))
    if(!checkBoxEl.isSelected) {
      checkBoxEl.click()
    }
  }

  def getAllLabels:List[String] = {
    val labels = driver.findElements(By.cssSelector("label.label")).asScala
    labels.map(_.getText).toList
  }
}


object MileageConfigurePage {
  val PAGE_TITLE = "Mileage Configurations"
  val TITLE_CLASS = "pageHeadlineText"
  val PAGE_TITLE_XPATH = "//*[@class='" + TITLE_CLASS + "' and .//text()='" + PAGE_TITLE + "']"
  val TRIP_LIST_BUTTON="tool.mileage.trip.list"
  val ADD_CATEGORY_BUTTON = "tool.mileage.add.category"
  val SAVE_AND_CLOSE_ID = "submit"
  val SWITCH_FRAME_ID = "xrCommonDialogIFrame"
  val CATEGORY_TABLE_ID = "categoryListTable"
  val CATEGORY_BASE_XPATH = "//div[@id='" + CATEGORY_TABLE_ID + "']"
  val BUSY_MSG_CLASS = "busyMsg"
  val PAGINATION_CLASS_ID = "pageIndex"
  val PAGINATION_NEXT_BUTTON = "nextPage"
  val MAIN_CONTENT = "mainContent"
  val ENABLE_CATEGORY = "enableCategory"
  val ENABLE_PURPOSE = "enablePurpose"
  val ADD_PURPOSE_BUTTON = "tool.mileage.add.purpose"
  val PURPOSE_TABLE_ID = "purposeListTable"
  val PURPOSE_BASE_XPATH = "//div[@id='" + PURPOSE_TABLE_ID + "']"
  val TOOLBAR_ID = "mileage.configure.toolbar.contentWidget"
  val TOOLBAR_XPATH = "//div[@id='" + TOOLBAR_ID + "']//a//span"
  val ENABLE_COMMUTER_DISTANCE = "enableCommuterDistance"
  val ENABLE_VEHICLE_ID = "enableVehicleId"
  val ENABLE_CATEGORY_CHECKBOX = "enableCategory"
  val MAKE_CATEGORY_VISIBLE_CHECKBOX = "categoryVisibleForMobileWorker"
  val ENABLE_PURPOSE_CHECKBOX = "enablePurpose"
  val MAKE_PURPOSE_VISIBLE_CHECKBOX = "purposeVisibleForMobileWorker"
  val PURPOSE_CELL_XPATH  = PURPOSE_BASE_XPATH +"//td[1]"
  val DESCRIPTION_CELL_XPATH  = PURPOSE_BASE_XPATH +"//td[2]"
  val DEFAULT_CELL_XPATH  = PURPOSE_BASE_XPATH +"//td[3]"
  val INNER_HTML = "innerHTML"
  val HELP_ICON_ID = "mileageTripListInPageHelp"
  val TOOL_BAR_EXPAND_OR_COLLAPSE_IMAGE_ID = "mileage.configure.toolbar.contentWidgetImage"
  val SEARCH_BOX_EXPAND_OR_COLLAPSE_IMAGE_ID = "search.contentWidgetImage"
  val COLLAPSE_IMAGE = "widget_Collapse.gif"
  val EXPAND_IMAGE = "widget_Expand.gif"
}


