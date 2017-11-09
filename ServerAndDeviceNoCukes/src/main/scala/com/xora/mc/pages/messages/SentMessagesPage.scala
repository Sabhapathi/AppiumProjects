package com.xora.mc.pages.messages

import com.xora.mc.pages.messages.SentMessagesPage._
import org.openqa.selenium.support.ui.LoadableComponent
import org.openqa.selenium.{By, NoSuchElementException, WebDriver}
import org.testng.Assert._

import scala.collection.JavaConverters._

/**
 * Created with IntelliJ IDEA.
 * User: Nandini.Sullekal
 * Date: 5/15/15
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */
class SentMessagesPage(driver: WebDriver, baseUrl: String) extends LoadableComponent[InboxPage] with AbstractMessageListPage {

  webDriver  = this.driver
  protected def load()
  {
    val url = baseUrl + "/messages/inbox.page"
    driver.get(url)
  }

  protected def isLoaded()
  {
    try
    {
      driver.findElement(By.xpath("//*[@class='" + TITLE_CLASS + "' and .//text()='" + PAGE_TITLE + "']"))
    }
    catch
      {
        case e: NoSuchElementException =>
          fail("Failed to load the message inbox page" + "//*[@class='" + TITLE_CLASS + "' and .//text()='" + PAGE_TITLE + "']")
      }
  }

  def getReceiverNameOfFirstRowMessage = {
    val fromUsernameName = driver.findElement(By.xpath(OUTBOX_BASE_XPATH + "//tr//td[3]")).getText
    fromUsernameName.trim
  }

  def getSubjectOfFirstRowMessage = {
    val messageSubject = driver.findElement(By.xpath(OUTBOX_BASE_XPATH + "//tr//td[4]")).getText
    messageSubject.trim
  }

  def getDateOfFirstRowMessage = {
    val dateAndTime = driver.findElement(By.xpath(OUTBOX_BASE_XPATH + "//tr//td[5]")).getText
    dateAndTime.trim
  }

  def getDataOfColumnOfSentMessagesPage(columnName: String) = {
    val columnNumber = columnName match {
      case  "To" => "2"
      case  "Subject" => "3"
      case  "Date" => "4"
    }
    val columnValueEls = webDriver.findElements(By.xpath(BASE_XPATH +"//tr//td["+columnNumber+"]")).asScala
    val columnValuesList = columnValueEls.filter(!_.getText.isEmpty).map(_.getText).toList
    columnValuesList
  }

  def validateExpandToolBar() = {
    var flag = false
    val toolBarEl = driver.findElement(By.id(TOOL_BAR_EXPAND_OR_COLLAPSE_IMAGE_ID))
    if (toolBarEl.getAttribute("src").contains(EXPAND_IMAGE)) {
      toolBarEl.click()
    }
    if (toolBarEl.getAttribute("src").contains(COLLAPSE_IMAGE)) {
      flag = true
    }
    flag
  }

  def validateCollapseToolBar() = {
    var flag = false
    val toolBarEl = driver.findElement(By.id(TOOL_BAR_EXPAND_OR_COLLAPSE_IMAGE_ID))
    if (toolBarEl.getAttribute("src").contains(COLLAPSE_IMAGE)) {
      toolBarEl.click()
    }
    if (toolBarEl.getAttribute("src").contains(EXPAND_IMAGE)) {
      flag = true
    }
    flag
  }

  def getToolBars = {
    val toolBarEl = driver.findElement(By.id(TOOL_BAR_ID))
    val toolBarsListEls = toolBarEl.findElements(By.tagName("tr")).asScala
    val toolBarValuesList = toolBarsListEls.filter(!_.getText.contains("Date Filter")).filter(_.getText.nonEmpty).map(_.getText.trim).toList.patch(3, Nil, 1)
    toolBarValuesList
  }

  def getAllMessageSubjects = {
    val subjectEls = driver.findElements(By.xpath(OUTBOX_BASE_XPATH + "//tr//td[3]")).asScala
    val subjectList = subjectEls.map(_.getText.trim).toList
    subjectList
  }

}

object SentMessagesPage{
  val PAGE_TITLE = "Messages"
  val TITLE_CLASS = "pageHeadlineText"
  val TABLE_ID = "Message"
  val OUTBOX_BASE_XPATH = "//table[@id='" + TABLE_ID + "']"
  val TOOL_BAR_EXPAND_OR_COLLAPSE_IMAGE_ID = "messages.outbox.toolbar.contentWidgetImage"
  val TOOL_BAR_ID = "messages.outbox.toolbar.contentWidget"
}
