package com.xora.mc.pages.messages

import com.xora.mc.pages.ListPageContextMenuPopup
import com.xora.mc.pages.messages.MessagePageContextMenuPopup._
import com.xora.mc.util.XpathUtils._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}

import scala.collection.JavaConverters._


/**
 * Created with IntelliJ IDEA.
 * User: Nandini.Sullekal
 * Date: 5/15/15
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
object MessagePageContextMenuPopup {
  sealed abstract class CONTEXT_MENU_POPUP_OPTION(val displayValue: String)

  case object READ_MESSAGE extends CONTEXT_MENU_POPUP_OPTION("Read Message")

  case object DELETE_MESSAGE extends CONTEXT_MENU_POPUP_OPTION("Delete Message")
}

class MessagePageContextMenuPopup(driver: WebDriver, parentPage: InboxPage) extends
ListPageContextMenuPopup[InboxPage](driver: WebDriver, parentPage: InboxPage) {

  val DIALOG_CONFIRM_CLASS = "dialog dialog-confirm"
  val DIALOG_BUTTON_CLASS = "linkButton"
  val CREATE_JOB_MENU_BASE_PATH = "//div[@id='jobCreate_menu']"
  val CONTEXT_MENU_LIST_ID = "drillDownUL"
  val CONTEXT_MENU_LIST_ITEM_CLASS = "actionList"
  val CONTEXT_MENU_CLOSE_BUTTON_ID = "puClose"
  val CONTEXT_MENU_HEADER_CLASS = "cssbox_head"

  def readMessage() = {
    this.selectOption(READ_MESSAGE)
    new ReadMessagePage(driver, parentPage)
  }

  def deleteMessageAccept() ={
    this.selectOption(DELETE_MESSAGE)
    acceptRemoteStartConfirmDialog()
    parentPage
  }
  def deleteMessageReject() ={
    this.selectOption(DELETE_MESSAGE)
    cancelRemoteStartConfirmDialog()
    parentPage
  }

  private def acceptRemoteStartConfirmDialog()
  {
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val okButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Delete" + "']"))
    okButton.click()

  }

  private def cancelRemoteStartConfirmDialog()
  {
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val cancelButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Cancel" + "']"))
    cancelButton.click()

  }
  protected def selectOption(option: MessagePageContextMenuPopup.CONTEXT_MENU_POPUP_OPTION) {
    this.selectOption(option.displayValue)
  }

  def listContextMenuItems():List[String]=
  {
    val menuItemEls = driver.findElements(By.xpath("//ul[@id='" + CONTEXT_MENU_LIST_ID +"']//li[@class='" + CONTEXT_MENU_LIST_ITEM_CLASS + "']")).asScala
    val menuItems = menuItemEls.map(_.getText)
    menuItems.toList
  }

  def closeContextMenu()
  {
    val closeButton = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className(CONTEXT_MENU_CLOSE_BUTTON_ID)))
    closeButton.click()
  }

  def getContextMenuHeader = {
    val contextMenuHeaderEl =  new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className(CONTEXT_MENU_HEADER_CLASS)))
    val header = contextMenuHeaderEl.getText
    header
  }
}
