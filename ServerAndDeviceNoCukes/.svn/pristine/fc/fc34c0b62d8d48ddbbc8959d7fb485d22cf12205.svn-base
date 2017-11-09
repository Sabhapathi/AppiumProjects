package com.xora.mc.pages.Forms

import com.xora.mc.pages.workers.WorkerActivityLogPage
import com.xora.mc.util.XpathUtils._
import com.xora.util.PropertyLoader
import com.xora.util.SleepTime._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}
import com.xora.mc.pages.Forms.AbstractViewSubmittedFormDetailPage._
import scala.collection.JavaConverters._


/**
 * Created with IntelliJ IDEA.
 * User: Nandini
 * Date: 12/10/13
 * Time: 3:23 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class AbstractViewSubmittedFormDetailPage[T](driver: WebDriver, parentPage: T) {

  protected var workerActivityLogPage: WorkerActivityLogPage = _
  val mcBaseUrl = PropertyLoader.loadProperty("mc.url")
  def getSubmittedFormLabels = {
    val formLabelsEl = driver.findElements(By.xpath(FORM_DETAIL_PAGE_XPATH + FORM_INFO_LABELS_XPATH)).asScala
    val formLabelsList1 = formLabelsEl.map(_.getText.trim).toList

    val formLabelsEls = driver.findElements(By.xpath(FORM_DETAIL_PAGE_XPATH + FORM_DETAILS_LABELS_XPATH)).asScala
    val formLabelsList2 = formLabelsEls.map(_.getText.trim).toList
    val formLabelsList = formLabelsList1 ::: formLabelsList2
    formLabelsList
  }

  def getSubmittedFormValues = {
    val formValuesEls = driver.findElements(By.xpath(FORM_DETAIL_PAGE_XPATH + FORM_LABEL_VALUES_XPATH)).asScala
    var formLabelValuesList: List[String] = List()
    for (formValuesEl <- formValuesEls) {
      val innerHTMLText = formValuesEl.getAttribute(INNER_HTML)
      if (innerHTMLText.contains("img")) {
        if (innerHTMLText.contains(".jpg")) {
          val picture = "picture image"
          formLabelValuesList = formLabelValuesList ::: List(picture)
        }
        if (innerHTMLText.contains(".png")) {
          val signature = "signature image"
          formLabelValuesList = formLabelValuesList ::: List(signature)
        }
      }
      else {
        formLabelValuesList = formLabelValuesList ::: List(formValuesEl.getText.trim)
      }
    }
    val labelArray = formLabelValuesList.toArray
    if (!labelArray(2).isEmpty){
      labelArray(2) = "Date/time"
    }
    else{
      labelArray(2) = "Empty Date/time"
    }
    labelArray.toList
  }

  def getPageHeader = {
    val headLineText = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.visibilityOfElementLocated(By.className(PAGE_HEADLINE_CLASS))).getText
    headLineText.trim
  }

  def getTableHeaders = {
    val tableHeadersEls = driver.findElements(By.xpath(TABLE_HEADER_XPATH)).asScala
    val tableHeadersList = tableHeadersEls.map(_.getText.trim).toList
    tableHeadersList
  }

  def clickOnFormButton = {
    val formButtonEl = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.id(FORM_BUTTON_ID)))
    formButtonEl.click()
//    new FormsListPage(driver,mcBaseUrl)
  }

  def clickOnEditSubmittedFormButton = {
    val editSubmittedFormButtonEl = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.id(EDIT_SUBMITTED_FORM_BUTTON_ID)))
    editSubmittedFormButtonEl.click()
//    new EditFormFieldValuesPopup(driver,workerActivityLogPage)
  }

  def getToolBars = {
    val toolBarEl = driver.findElement(By.id(TOOL_BAR_ID))
    val toolBarsListEls = toolBarEl.findElements(By.tagName("tr")).asScala
    val toolBarValuesList = toolBarsListEls.filter(_.getText.nonEmpty).map(_.getText.trim).toList
    toolBarValuesList
  }

  def clickSubmittedFormsPageLink = {
    val submittedFormsPageLink = driver.findElement(By.linkText("Submitted Forms"))
    submittedFormsPageLink.click()
    new SubmittedFormsListPage(driver, mcBaseUrl)
  }

  def isEmailPrintDownloadIconsPresent = {
    var flag = false
    val emailIcon = new WebDriverWait(driver,maxWaitTime).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL_ICON_XPATH)))
    val printIcon =  new WebDriverWait(driver,maxWaitTime).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRINT_ICON_XPATH)))
    val pdfIcon =  new WebDriverWait(driver,maxWaitTime).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PDF_ICON_XPATH)))
    if(emailIcon.isDisplayed && printIcon.isDisplayed && pdfIcon.isDisplayed){
      flag = true
    }
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

  def emailSubmittedFormDetails = {
    val emailIcon = driver.findElement(By.xpath("//div[@class = '" + EMAIL_ICON_CLASS + "']//img[@title = 'Email']"))
    emailIcon.click()
//    new EmailSubmittedFormDetailsPopup(driver,this)
  }

}

object AbstractViewSubmittedFormDetailPage {
  val TABLE_CLASS = "table"
  val FORM_INFO_ROW_CLASS = "tableRow2"
  val FORM_INFO_TD_CLASS = "key2"
  val FORM_HEADER_ROW_CLASS = "tableRow1"
  val FORM_DETAIL_TD_CLASS = "key3"
  val FOR_HEADER_TD_CLASS = "key1"
  val FORM_LABEL_CLASS = "value"
  val FORM_ROW_BASE_XPATH = "//tr[@class = '"+FORM_INFO_ROW_CLASS+"']"
  val FORM_DETAIL_PAGE_XPATH = "//table[@class = '"+TABLE_CLASS+"']"
  val FORM_INFO_LABELS_XPATH = FORM_ROW_BASE_XPATH + "//td[@class = '"+FORM_INFO_TD_CLASS+"']"
  val FORM_DETAILS_LABELS_XPATH = FORM_ROW_BASE_XPATH + "//td[@class = '"+FORM_DETAIL_TD_CLASS+"']"
  val FORM_LABEL_VALUES_XPATH = FORM_ROW_BASE_XPATH + "//td["+hasCssClass(FORM_LABEL_CLASS)+"]"
  val INNER_HTML = "innerHTML"
  val PAGE_HEADLINE_CLASS = "pageHeadlineText"
  val TABLE_HEADER_XPATH = "//tr[@class = '"+FORM_HEADER_ROW_CLASS+"']//td[@class = '"+FOR_HEADER_TD_CLASS+"']"
  val FORM_BUTTON_ID = "formsList"
  val EDIT_SUBMITTED_FORM_BUTTON_ID = "submittedFormEdit"
  val TOOL_BAR_ID = "submittedform.detail.toolbar.contentWidget"
  val EMAIL_ICON_XPATH = "//div[@class = 'emailPrintDownloadIcons']//img[contains(@src, 'emailDefault.png')]"
  val PRINT_ICON_XPATH = "//div[@class = 'emailPrintDownloadIcons']//img[contains(@src, 'printDefault.png')]"
  val PDF_ICON_XPATH = "//div[@class = 'emailPrintDownloadIcons']//img[contains(@src, 'downloadDefault.png')]"
  val TOOL_BAR_EXPAND_OR_COLLAPSE_IMAGE_ID = "submittedform.detail.toolbar.contentWidgetImage"
  val COLLAPSE_IMAGE = "widget_Collapse.gif"
  val EXPAND_IMAGE = "widget_Expand.gif"
  val EMAIL_ICON_CLASS = "emailPrintDownloadIcons"
}

