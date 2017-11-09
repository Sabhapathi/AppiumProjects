package com.xora.mc.pages.messages

import com.xora.mc.pages.messages.DeletedMessagesPage._
import org.openqa.selenium.support.ui.LoadableComponent
import org.openqa.selenium.{By, NoSuchElementException, WebDriver}
import org.testng.Assert._

import scala.collection.JavaConverters._

/**
 * Created with IntelliJ IDEA.
 * User: Nandini.Sullekal
 * Date: 5/15/15
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
class DeletedMessagesPage(driver: WebDriver, baseUrl: String) extends LoadableComponent[InboxPage] with AbstractMessageListPage {

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
    val fromUsernameName = driver.findElement(By.xpath(DELETED_BASE_XPATH + "//tr//td[3]")).getText
    fromUsernameName.trim
  }

  def getSubjectOfFirstRowMessage = {
    val messageSubject = driver.findElement(By.xpath(DELETED_BASE_XPATH + "//tr//td[4]")).getText
    messageSubject.trim
  }

  def getDateOfFirstRowMessage = {
    val dateAndTime = driver.findElement(By.xpath(DELETED_BASE_XPATH + "//tr//td[5]")).getText
    dateAndTime.trim
  }


  def selectMessagesBySelectingCheckBox(senderNames: List[String]) {
    for (senderName <- senderNames) {
      val checkBoxEl = driver.findElement(By.xpath("//table[@id = '" + TABLE_ID + "']//tr//td[3][text() = '" + senderName + "']//..//td[1]"))
      checkBoxEl.click()
    }
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
    val subjectEls = driver.findElements(By.xpath(DELETED_BASE_XPATH + "//tr//td[4]")).asScala
    val subjectList = subjectEls.map(_.getText.trim).toList
    subjectList
  }
}

object DeletedMessagesPage{
  val PAGE_TITLE = "Messages"
  val TITLE_CLASS = "pageHeadlineText"
  val TABLE_ID = "Message"
  val DELETED_BASE_XPATH = "//table[@id='" + TABLE_ID + "']"
  val TOOL_BAR_EXPAND_OR_COLLAPSE_IMAGE_ID = "messages.deleted.toolbar.contentWidgetImage"
  val TOOL_BAR_ID = "messages.deleted.toolbar.contentWidget"
}
