package com.xora.mc.pages.mileage

import com.xora.mc.pages.ListPageContextMenuPopup
import com.xora.mc.pages.mileage.PurposeContextMenuPopup._
import com.xora.mc.util.XpathUtils._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}

import scala.collection.JavaConverters._


/**
 * Created with IntelliJ IDEA.
 * User: Nandini
 * Date: 8/22/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */

object PurposeContextMenuPopup{
  sealed abstract class CONTEXT_MENU_POPUP_OPTION(val displayValue: String)
  case object EDIT_PURPOSE extends CONTEXT_MENU_POPUP_OPTION("Edit Purpose")
  case object DELETE_PURPOSE extends CONTEXT_MENU_POPUP_OPTION("Delete Purpose")

  val DIALOG_CONFIRM_CLASS = "dialog dialog-confirm"
  val DIALOG_BUTTON_CLASS = "linkButton"
  val CONTEXT_MENU_BODY_ID = "cssbox_body_id"
  val CONTEXT_MENU_LIST_CLASS_ID = "actionList"
  val CONTEXT_MENU_CLOSE_BUTTON = "puClose"
  val CONTEXT_MENU_HEADER_CLASS = "cssbox_head"
}

class PurposeContextMenuPopup(driver: WebDriver, parentPage: MileageConfigurePage) extends
ListPageContextMenuPopup[MileageConfigurePage](driver: WebDriver, parentPage: MileageConfigurePage){


  def editPurpose()= {
    this.selectOption(EDIT_PURPOSE)
    new AddPurposePopup(driver,parentPage)
  }

  def acceptDeletePurpose() ={
    this.selectOption(DELETE_PURPOSE)
    acceptDeletePurposeDialog()
    parentPage
  }

  def cancelDeletePurpose()= {
    this.selectOption(DELETE_PURPOSE)
    cancelDeletePurposeDialog()
    parentPage
  }

  private def acceptDeletePurposeDialog()
  {
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val deleteButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Delete" + "']"))
    deleteButton.click()
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]")))
  }

  private def cancelDeletePurposeDialog()
  {
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val cancelButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Cancel" + "']"))
    cancelButton.click()
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]")))
  }

  def getContextMenuHeaderName ={
    val contextMenuHeaderEle = driver.findElement(By.className(CONTEXT_MENU_HEADER_CLASS))
    contextMenuHeaderEle.getText
  }

  def listContextMenuItems():List[String]= {
    val contextMenuEls = driver.findElements(By.className(CONTEXT_MENU_LIST_CLASS_ID)).asScala
    val MenuItems = contextMenuEls.map(_.getText)
    MenuItems.toList
  }

  def closeContextMenu()
  {
    val closeButtonEl = driver.findElement(By.xpath("//div[@class = '"+CONTEXT_MENU_CLOSE_BUTTON+"']"))
    closeButtonEl.click()
  }

  protected def selectOption(option: PurposeContextMenuPopup.CONTEXT_MENU_POPUP_OPTION) {
    this.selectOption(option.displayValue)
  }
}
