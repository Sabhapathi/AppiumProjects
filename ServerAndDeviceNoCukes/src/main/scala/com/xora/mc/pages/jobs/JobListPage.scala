package com.xora.mc.pages.jobs

import com.xora.mc.pages.jobs.wizards.CreateWizardPopup
import com.xora.mc.util.LoadableElement
import com.xora.mc.util.XpathUtils._
import com.xora.util.SleepTime._
import org.openqa.selenium.support.ui.{ExpectedConditions, LoadableComponent, Select, WebDriverWait}
import org.openqa.selenium.{By, WebDriver, WebElement}
import com.xora.mc.pages.jobs.JobListPage._
import scala.collection.JavaConverters._


/**
 * Created by Nandini.Sullekal on 1/3/2017.
 */
class JobListPage(val driver: WebDriver, val baseUrl: String)
  extends LoadableComponent[JobListPage]
  with LoadableElement  {

  def load() {
    val url = baseUrl + "/jobs/list/doList.page"
    driver.get(url)
  }

  def isLoaded() {
    verifyElementLoaded(driver, By.xpath(PAGE_TITLE_XPATH))
  }

  def getPageHeader = {
    val pageHeaderEl = driver.findElement(By.className(TITLE_CLASS))
    val pageHeadline = pageHeaderEl.getText.trim
    pageHeadline
  }

  def getJobName_Type_Pattern(JobId: String) : List[String] ={
    List(jobNameOfJob(JobId),jobTypeOfJob(JobId),patternOfJob(JobId))
  }


  def searchJob(searchKey: String): JobListPage = {

    val searchOption: WebElement = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.id(SEARCH_OPTION_FIELD_ID)))
    val searchInputText: WebElement = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.id(SEARCH_INPUT_TEXT_ID)))

    val searchButton = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.id(SEARCH_BUTTON_ID)))

    new Select(searchOption).selectByVisibleText(JOB_LIST_TEXT)
    searchInputText.clear()
    searchInputText.sendKeys(searchKey)
    searchButton.click()
    Thread.sleep(2000)
    this
  }

  private def findJobRow(jobId: String) = {
    val jobRowXpath: String = JOB_BASE_XPATH + "//tr[.//*[text()='" + jobId + "']]"
    val jobRowEl = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.xpath(jobRowXpath)))
    jobRowEl
  }

  private def jobRowElements(jobId: String) = {
    val jobRowEl = findJobRow(jobId)
    val jobRowEls = jobRowEl.findElements(By.tagName("td")).asScala
    jobRowEls
  }

  def refresh(): JobListPage = {
    driver.findElement(By.className(REFRESH_BUTTON_CLASS)).click()
    this
  }

  def statusOfJob(jobId: String): String = {
    val jobRowEls = jobRowElements(jobId)
    val status = jobRowEls(11).getText.trim.replace("\n"," ")
    status
  }

  def workerNameOfJob(jobId: String): String = {
    val jobRowEls = jobRowElements(jobId)
    var workerName = jobRowEls(9).getText.trim
    if (workerName.isEmpty) {
      workerName = "Unassigned"
    }
    workerName
  }

  def jobTypeOfJob(jobId: String): String = {
    val jobRowEls = jobRowElements(jobId)
    val jobType = jobRowEls(6).getText.trim
    jobType
  }

  def jobNameOfJob(jobId: String): String = {
    val jobRowEls = jobRowElements(jobId)
    val jobName = jobRowEls(8).getText.trim
    jobName
  }

  def patternOfJob(jobId: String): String = {
    val jobRowEls = jobRowElements(jobId)
    val patternImgEl = jobRowEls(4).findElement(By.tagName("img"))
    val pattern = patternImgEl.getAttribute("title").trim
    pattern
  }

  def startDateAndTimeOfJob(jobId: String) = {
    val jobRowEls = jobRowElements(jobId)
    val dateAndTime = jobRowEls(10).getText.trim
    dateAndTime
  }

  def sourceOfJob(jobId: String): String = {
    val jobRowEls = jobRowElements(jobId)
    val sourceImgEl = jobRowEls(2).findElement(By.tagName("img"))
    val source = sourceImgEl.getAttribute("title").trim
    source
  }

  def locationAddressOfJob(jobId: String): String = {
    val jobRowEls = jobRowElements(jobId)
    val location = jobRowEls(15).getText.trim
    val locationText = location.replace("\n", ",")
    locationText
  }

  def jobStatusIconColor(jobId: String) = {
    val jobRowEls = jobRowElements(jobId)
    val statusImg = jobRowEls(10).findElement(By.tagName("img")).getAttribute("src")
    val jobStatusColorArray = statusImg.split("/")
    val len = jobStatusColorArray.length
    val icon = jobStatusColorArray(len - 1)
    val color: String = icon match {
      case "job_orange.png" => "Orange"
      case "JobActiveUnselected.png" => "Sky Blue"
      case "JobUnassignedUnselected.png" => "Violet"
      case "JobAssignedUnselected.png" => "Green"
      case "JobCompleteUnselected.png" => "Black"
      case "JobExpiredUnselected.png" => "Red"
    }
    color
  }

  def contextMenuOfJob(jobId: String) = {
    val jobRowEl = findJobRow(jobId)
    jobRowEl.click()
    new JobListPageContextMenuPopup(driver, this)
  }

  def createNewJob(jobType: String) = {
    searchJob("")
    val createJobButton = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.id(CREATE_JOB_BUTTON_ID)))
    createJobButton.click()
    sleepTime(minWaitTime * 1000)
    val jobTypeMenu = createJobButton.findElement(By.id(JOBTYPE_MENU_ID))
    val jobTypeEl = jobTypeMenu.findElement(By.linkText(jobType.trim))
    jobTypeEl.click()
    new CreateWizardPopup(driver, this)

  }


  def selectAllJobsCheckBox() {
    val selectAllCheckBox = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id(SELECT_ALL_CHECKBOX_ID)))
    selectAllCheckBox.click()
  }

  def clickDeleteJobButtonFromToolBarAndAccept() = {
    val deleteJobEl = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id(DELETE_BUTTON_ID)))
    deleteJobEl.click()
    sleepTime((minWaitTime / 4) * 1000)
    acceptDeleteJobConfirmationDialog()
    this
  }

  private def acceptDeleteJobConfirmationDialog() {
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val deleteButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Delete" + "']"))
    sleepTime((minWaitTime / 2) * 1000)
    deleteButton.click()
    sleepTime(minWaitTime * 1000)
  }

  private def rejectConfirmDialog() {
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val cancelButton = confirmDialog.findElement(By.xpath("//a[id= 'cancel']"))
    sleepTime((minWaitTime / 2) * 1000)
    cancelButton.click()
    sleepTime(minWaitTime * 1000)
  }



}

object JobListPage{
  val PAGE_TITLE = "Jobs"
  val TITLE_CLASS = "pageHeadlineText"
  val PAGE_TITLE_XPATH = "//*[@class='" + TITLE_CLASS + "' and .//text()='" + PAGE_TITLE + "']"
  val SEARCH_OPTION_FIELD_ID = "resourceUrl"
  val SEARCH_INPUT_TEXT_ID = "searchInput"
  val SEARCH_BUTTON_ID = "searchButton"
  val JOB_LIST_TEXT = "Jobs"
  val JOB_BASE_XPATH = "//table[@id='Job']"
  val TABLE_ID = "Job"
  val TABLE_CLASS = "listTable"
  val JOB_COMMON_XPATH = "//table[@id='" + TABLE_ID + "']//tr"
  val SELECT_ALL_CHECKBOX_ID = "selectAll"
  val DELETE_BUTTON_ID = "jobDelete"
  val DIALOG_CONFIRM_CLASS = "dialog"
  val DIALOG_BUTTON_CLASS = "linkButton"
  val XORA_UNDERLAY_ID = "xora-underlay"
  val CREATE_JOB_BUTTON_ID = "jobCreate_menu"
  val JOBTYPE_MENU_ID = "menuBody"
  val REFRESH_BUTTON_CLASS = "refreshNowButton"
  val BUSY_MSG_CLASS = "busyMsg"
  val SUB_TABLE = "//table//img"
  val TITLE = "title"
  val EXCEL_DOWNLOAD_ICON_XPATH = "//a[@id = 'downloadList']//img[contains(@src, 'share_detail_excel.png')]"
  val HELP_ICON_XPATH = "//a[@id = 'jobsListInPageHelp']//img[contains(@src,'question_24.png')]"
  val TOOL_BAR_ID = "jobs.list.toolbar.contentWidget"
  val DATE_FILTER_ID = "xora-widget-DateRangeFilter-Background"
  val DATE_FILTER_HEADER_CLASS_NAME = "xora-widget-DateRangeFilter-Title"
  val TOOL_BAR_REASSIGN_BUTTON_ID = "jobReassign"
  val UPLOAD_JOB_BUTTON_ID = "upload"
  val JOB_MAP_BUTTON_IN_TOOL_BAR = "jobsMap"
  val AVAILABILITY_CALENDER_ID = "workersAvailabiltiyCalendar"
  val GROUP_FILTER_ID = "groupFilter"
  val DISPLAY_FILTER_ID = "displayFilter"
  val TOOL_BAR_EXPAND_OR_COLLAPSE_IMAGE_ID = "jobs.list.toolbar.contentWidgetImage"
  val SEARCH_BOX_EXPAND_OR_COLLAPSE_IMAGE_ID = "search.contentWidgetImage"
  val COLLAPSE_IMAGE = "widget_Collapse.gif"
  val EXPAND_IMAGE = "widget_Expand.gif"

}