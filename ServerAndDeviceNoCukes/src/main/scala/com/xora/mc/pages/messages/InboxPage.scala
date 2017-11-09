package com.xora.mc.pages.messages

import com.xora.mc.pages.messages.InboxPage._
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.LoadableComponent
import org.openqa.selenium.{By, NoSuchElementException, WebDriver}
import org.testng.Assert._

import scala.collection.JavaConverters._


class InboxPage(driver: WebDriver, baseUrl: String) extends LoadableComponent[InboxPage] with AbstractMessageListPage
{
  PageFactory.initElements(driver, this)
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

  def getSenderNameOfFirstRowMessage = {
    val fromUsernameName = driver.findElement(By.xpath(INBOX_BASE_XPATH + "//tr//td[3]")).getText
    fromUsernameName.trim
  }

  def getSubjectOfFirstRowMessage = {
    val messageSubject = driver.findElement(By.xpath(INBOX_BASE_XPATH + "//tr//td[4]")).getText
    messageSubject.trim
  }

  def getDateOfFirstRowMessage = {
    val dateAndTime = driver.findElement(By.xpath(INBOX_BASE_XPATH + "//tr//td[5]")).getText
    dateAndTime.trim
  }


  def selectMessagesBySelectingCheckBox(senderNames: List[String]) {
    for (senderName <- senderNames) {
      val checkBoxEl = driver.findElement(By.xpath("//table[@id = '" + TABLE_ID + "']//tr//td[3][text() = '" + senderName + "']//..//td[1]"))
      checkBoxEl.click()
    }
  }

  def isUnReadMessage = {
     val firstMessageRowEl = driver.findElement(By.xpath("//table[@id = '" + TABLE_ID + "']//tr//td[2]"))
    val flag = firstMessageRowEl.getAttribute("innerHTML").contains("arrow.gif")
    flag
  }

  def validateExpandToolBar() = {
    var flag = false
    val toolBarEl = driver.findElement(By.id(TOOL_EXPAND_OR_COLLAPSE_IMAGE_ID))
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
    val toolBarEl = driver.findElement(By.id(TOOL_EXPAND_OR_COLLAPSE_IMAGE_ID))
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
    val toolBarValuesList = toolBarsListEls.filter(!_.getText.contains("Date Filter")).filter(!_.getText.isEmpty).map(_.getText.trim).toList.patch(3, Nil, 1)
    toolBarValuesList
  }

  def getAllMessageSubjects = {
    val subjectEls = driver.findElements(By.xpath(INBOX_BASE_XPATH + "//tr//td[4]")).asScala
    val subjectList = subjectEls.map(_.getText.trim).toList
    subjectList
  }

}

object InboxPage {
  val PAGE_TITLE = "Messages"
  val TITLE_CLASS = "pageHeadlineText"

  val TABLE_ID = "Message"
  val INBOX_BASE_XPATH = "//table[@id='" + TABLE_ID + "']"
  val TOOL_EXPAND_OR_COLLAPSE_IMAGE_ID = "messages.inbox.toolbar.contentWidgetImage"
  val TOOL_BAR_ID = "messages.inbox.toolbar.contentWidget"

}

