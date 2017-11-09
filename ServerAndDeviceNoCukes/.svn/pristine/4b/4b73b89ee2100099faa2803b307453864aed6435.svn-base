package com.xora.mc.pages.messages

import com.xora.util.SleepTime._
import org.openqa.selenium.support.ui.{ExpectedConditions, Select, WebDriverWait}
import org.openqa.selenium.{By, WebDriver, WebElement}
//import com.xora.mc.pages.messages.AbstractMessageListPage._
import com.xora.mc.pages.jobs.JobListPage
import com.xora.mc.pages.workers.WorkerListPage
import com.xora.mc.util.XpathUtils._
import com.xora.util.PropertyLoader

import scala.collection.JavaConverters._

/**
 * Created with IntelliJ IDEA.
 * User: Nandini.Sullekal
 * Date: 5/15/15
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
trait AbstractMessageListPage {

//  private var dateFilter: DateFilterTimePeriodPickerWidget = null
  private val baseUrl = PropertyLoader.loadProperty("mc.url")
  protected var webDriver: WebDriver = null

  val PAGE_TITLE = "Messages"
  val TITLE_CLASS = "pageHeadlineText"

  val TABLE_ID = "Message"
  val BASE_XPATH = "//table[@id='" + TABLE_ID + "']"

  val SEARCH_BUTTON_ID = "searchButton"
  val SEARCH_OPTION_FIELD_ID = "resourceUrl"
  val SEARCH_INPUT_TEXT_ID = "searchInput"
  val CREATE_MESSAGE_BUTTON_ID = "createMessage"
  val REFRESH_BUTTON_CLASS = "refreshNowButton"
  val EXCEL_DOWNLOAD_ICON_XPATH = "//a[@id = 'downloadList']//img[contains(@src, 'share_detail_excel.png')]"
  val DOWNLOAD_LIST_ID = "downloadList"
  val SELECT_ALL_CHECKBOX_ID = "selectAll"
  val DELETE_BUTTON_ID = "deleteMessage"
  val DIALOG_CONFIRM_CLASS = "dialog"
  val DIALOG_BUTTON_CLASS = "linkButton"
  val XORA_UNDERLAY_ID = "xora-underlay"
  val DIALOG_ALERT_CLASS = "dialog dialog-alert"
  val SEARCH_BOX_EXPAND_OR_COLLAPSE_IMAGE_ID = "search.contentWidgetImage"
  val COLLAPSE_IMAGE = "widget_Collapse.gif"
  val EXPAND_IMAGE = "widget_Expand.gif"
  val SENT_BUTTON_ID = "messageOutbox"
  val DELETED_BUTTON_ID = "messageDeleted"
  val INBOX_BUTTON_ID = "messageInbox"

//  def getDateFilter: DateFilterTimePeriodPickerWidget =
//  {
//    if (dateFilter == null)
//    {
//      dateFilter = new DateFilterTimePeriodPickerWidget(webDriver, "")
//    }
//    dateFilter
//  }

  def getPageHeader = {
    val pageHeaderEl = webDriver.findElement(By.className(TITLE_CLASS))
    val pageHeadline = pageHeaderEl.getText.trim
    pageHeadline
  }


  def sort(columnName: String, order: String)= {
    sleepTime(maxWaitTime * 1000)
    val columnHeaderEl = new WebDriverWait(webDriver, maxWaitTime + 5).until(ExpectedConditions.elementToBeClickable(By.xpath(BASE_XPATH + "//th[.//*[contains(text(),'"+ columnName + "')]]")))

    if (!columnHeaderEl.getAttribute("innerHTML").contains("img")) {
      val columnEl = new WebDriverWait(webDriver, maxWaitTime + 5).until(ExpectedConditions.elementToBeClickable(By.xpath(BASE_XPATH + "//th//*[contains(text(),'" + columnName + "')]")))
      columnEl.click()
    }
    sleepTime(maxWaitTime * 1000)

    val sortingOrderImage = new WebDriverWait(webDriver, maxWaitTime + 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BASE_XPATH + "//tbody//tr//th//img"))).getAttribute("src")

    order match {
      case "ascending" =>
        if (sortingOrderImage.contains("sortArrowUp.gif")) {
          webDriver.findElement(By.xpath(BASE_XPATH + "//th//*[contains(text(),'" + columnName + "')]")).click()
          sleepTime(maxWaitTime * 1000)
          new WebDriverWait(webDriver, maxWaitTime).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BASE_XPATH + "//th[.//*[contains(text(),'" + columnName + "')] and .//img[contains(@src,'sortArrowDown')]]")))
        }
      case "descending" =>
        if (sortingOrderImage.contains("sortArrowDown.gif")) {
          sleepTime(minWaitTime * 1000)
          webDriver.findElement(By.xpath(BASE_XPATH + "//th//*[contains(text(),'" + columnName + "')]")).click()
          sleepTime(maxWaitTime * 1000)
          new WebDriverWait(webDriver, maxWaitTime).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BASE_XPATH + "//th[.//*[contains(text(),'" + columnName + "')] and .//img[contains(@src,'sortArrowUp')]]")))
        }
    }
    this
  }

  def getLatestMessageRow = {
    sleepTime(minWaitTime * 1000)
    sort("Date", "descending")
    sleepTime(minWaitTime * 1000)
    webDriver.navigate().refresh()
    val latestFormEl = new WebDriverWait(webDriver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.xpath(BASE_XPATH + "//tr[2]")))
    latestFormEl
  }


  def validateExpandSearchBox() = {
    var flag = false
    val toolBarEl = webDriver.findElement(By.id(SEARCH_BOX_EXPAND_OR_COLLAPSE_IMAGE_ID))
    if (toolBarEl.getAttribute("src").contains(EXPAND_IMAGE)) {
      toolBarEl.click()
    }
    if (toolBarEl.getAttribute("src").contains(COLLAPSE_IMAGE)) {
      flag = true
    }
    flag
  }

  def validateCollapseSearchBox() = {
    var flag = false
    val toolBarEl = webDriver.findElement(By.id(SEARCH_BOX_EXPAND_OR_COLLAPSE_IMAGE_ID))
    if (toolBarEl.getAttribute("src").contains(COLLAPSE_IMAGE)) {
      toolBarEl.click()
    }
    if (toolBarEl.getAttribute("src").contains(EXPAND_IMAGE)) {
      flag = true
    }
    flag
  }

  def selectAllMessagesCheckBox() {
    val selectAllCheckBox = new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable(By.id(SELECT_ALL_CHECKBOX_ID)))
    selectAllCheckBox.click()
  }

  def clickDeleteMessageButtonInToolBarAndAcceptDialog() = {
    val deleteLocationButtonEl = new WebDriverWait(webDriver,10).until(ExpectedConditions.elementToBeClickable(By.id(DELETE_BUTTON_ID)))
    deleteLocationButtonEl.click()
    try{
      acceptDeleteMessageConfirmationDialog()
    }
    catch{
      case e : Exception =>
        val noLocationsToDeleteDialog = new WebDriverWait(webDriver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[" + hasCssClass(DIALOG_ALERT_CLASS) + "]")))
        val okButton = noLocationsToDeleteDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "OK" + "']"))
        okButton.click()
        sleepTime(minWaitTime * 2000)
        webDriver.switchTo.defaultContent
        new WebDriverWait(webDriver, 40).until(ExpectedConditions.invisibilityOfElementLocated(By.id(XORA_UNDERLAY_ID)))
    }
    this
  }

  private def acceptDeleteMessageConfirmationDialog() {
    val confirmDialog = webDriver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val deleteButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Delete" + "']"))
    sleepTime((minWaitTime / 2) * 1000)
    deleteButton.click()
    sleepTime(minWaitTime * 1000)
  }

  def clickDeleteMessageButtonFromToolBarAndCancel() = {
    val deleteJobEl = new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable(By.id(DELETE_BUTTON_ID)))
    deleteJobEl.click()
    rejectConfirmDialog()
    this
  }

  private def rejectConfirmDialog() {
    val confirmDialog = webDriver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val cancelButton = confirmDialog.findElement(By.xpath("//a[id= 'cancel']"))
    sleepTime((minWaitTime / 2) * 1000)
    cancelButton.click()
    sleepTime(minWaitTime * 1000)
  }

  def createMessage = {
    Thread.sleep(1000)
    val createUserButton = webDriver.findElement(By.id(CREATE_MESSAGE_BUTTON_ID))
    createUserButton.click()
    new CreateMessagePopup(webDriver,this)
  }

  def navigateToSentMessagesPage = {
    val sentEl = webDriver.findElement(By.id(SENT_BUTTON_ID))
    sentEl.click()
    sleepTime(minWaitTime*1000)
    new SentMessagesPage(webDriver,baseUrl)
  }
  
  def navigateToDeletedMessagePage = {
    val deletedEl = webDriver.findElement(By.id(DELETED_BUTTON_ID))
    deletedEl.click()
    sleepTime(minWaitTime*1000)
    new DeletedMessagesPage(webDriver,baseUrl)
  }

  def navigateToInboxPage = {
    val inboxButtonEl = webDriver.findElement(By.id(INBOX_BUTTON_ID))
    inboxButtonEl.click()
    sleepTime(minWaitTime*1000)
    new InboxPage(webDriver, baseUrl)
  }
   val inboxPage: InboxPage = null
  def contextMenuOfLatestMessage= {
    val messageRowEL= getLatestMessageRow
    messageRowEL.click()
    sleepTime(minWaitTime*1000)
    new MessagePageContextMenuPopup(webDriver, inboxPage)
  }

  def refresh() = {
    webDriver.findElement(By.className(REFRESH_BUTTON_CLASS)).click()
    this
  }

  def getColumnHeaders = {
    val headersEls = webDriver.findElements(By.xpath(BASE_XPATH + "//th")).asScala
    val headersList = headersEls.filter(!_.getText.isEmpty).map(_.getText.trim).toList
    headersList
  }

  def getColumnValuesForColumn(columnName: String) = {
    val columnNumber = columnName match {
      case  "From" => "3"
      case  "Subject" => "4"
      case  "Date" => "5"
    }
    val columnValueEls = webDriver.findElements(By.xpath(BASE_XPATH +"//tr//td["+columnNumber+"]")).asScala
    val columnValuesList = columnValueEls.filter(!_.getText.isEmpty).map(_.getText).toList
    columnValuesList
  }

  def isExcelLinkPresent = {
    var flag = false
    val excelDownloadIcon = new WebDriverWait(webDriver, maxWaitTime).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EXCEL_DOWNLOAD_ICON_XPATH)))

    if (excelDownloadIcon.isDisplayed ) {
      flag = true
    }
    flag
  }
  
  def isRefreshLinkPresent = {
    var flag = false
    val refreshLink = new WebDriverWait(webDriver, maxWaitTime).until(ExpectedConditions.visibilityOfElementLocated(By.className(REFRESH_BUTTON_CLASS)))

    if (refreshLink.isDisplayed ) {
      flag = true
    }
    flag
  }

  def downloadExcel() {
    val downloadEle = webDriver.findElement(By.id(DOWNLOAD_LIST_ID))
    downloadEle.click()
  }

  def searchJob(searchKey: String) = {
    enterSearchKeyAndKeywordType(searchKey,"Jobs")
    new JobListPage(webDriver,baseUrl)
  }
  def searchWorker(searchKey: String) = {
    enterSearchKeyAndKeywordType(searchKey,"Workers")
    new WorkerListPage(webDriver,baseUrl)
  }
  def searchLocation(searchKey: String) = {
    enterSearchKeyAndKeywordType(searchKey,"Locations")
//    new LocationListPage(webDriver,baseUrl)
  }
  def searchUser(searchKey: String) = {
    enterSearchKeyAndKeywordType(searchKey,"Users")
//    new UserListPage(webDriver,baseUrl)
  }

  // keywordType can be "Jobs", "Workers", "Locations", "Users"
  private def enterSearchKeyAndKeywordType(searchKey: String, keywordType: String){
    val searchOption: WebElement = new WebDriverWait(webDriver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.id(SEARCH_OPTION_FIELD_ID)))
    val searchInputText: WebElement = new WebDriverWait(webDriver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.id(SEARCH_INPUT_TEXT_ID)))

    val searchButton = new WebDriverWait(webDriver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.id(SEARCH_BUTTON_ID)))

    new Select(searchOption).selectByVisibleText(keywordType)
    searchInputText.clear()
    searchInputText.sendKeys(searchKey)
    searchButton.click()
    Thread.sleep(2000)
  }

  def checkCheckBoxOfFirstRowMessage ={
    val firstMessageCheckBox = webDriver.findElement(By.xpath(BASE_XPATH + "//tr//td[1]//input"))
    if(!firstMessageCheckBox.isSelected)
      firstMessageCheckBox.click()
    this
  }

}
