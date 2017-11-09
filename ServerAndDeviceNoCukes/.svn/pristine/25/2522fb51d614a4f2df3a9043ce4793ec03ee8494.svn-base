package com.xora.mc.pages.partsCatalog

import org.openqa.selenium.{By, WebDriver}
import com.xora.mc.pages.ListPageContextMenuPopup
import com.xora.mc.util.XpathUtils._
import com.xora.util.SleepTime._
import com.xora.mc.pages.partsCatalog.PartsCatalogPageContextMenuPopup._
import scala.collection.JavaConverters._

/**
 * Created with IntelliJ IDEA.
 * User: Itee.Yadav
 * Date: 5/19/15
 * Time: 7:41 PM
 * To change this template use File | Settings | File Templates.
 */

object PartsCatalogPageContextMenuPopup {
  sealed abstract class CONTEXT_MENU_POPUP_OPTION(val displayValue: String)
  case object EDIT_PART extends CONTEXT_MENU_POPUP_OPTION("Edit Item")
  case object DELETE_PART extends CONTEXT_MENU_POPUP_OPTION("Delete Item")
}

class PartsCatalogPageContextMenuPopup (driver: WebDriver, parentPage: PartsCatalogPage) extends
ListPageContextMenuPopup[PartsCatalogPage](driver: WebDriver, parentPage: PartsCatalogPage)   {
  val DIALOG_CONFIRM_CLASS = "dialog dialog-confirm"
  val DIALOG_BUTTON_CLASS = "linkButton"
  val CONTEXT_MENU_LIST_ID = "drillDownUL"
  val CONTEXT_MENU_CLOSE_BUTTON_ID = "puClose"
  val CONTEXT_MENU_HEADER_CLASS = "cssbox_head"


  def cancelDeletePart()={
    this.selectOption(DELETE_PART)
    cancelDeletePartConfirmDialog()
    parentPage
  }

  def acceptDeletePart()={
    this.selectOption(DELETE_PART)
    deleteDeletePartConfirmationDialog()
    parentPage
  }

  private def cancelDeletePartConfirmDialog(){
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val cancelButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Cancel" + "']"))
    cancelButton.click()
  }

  private def deleteDeletePartConfirmationDialog(){
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val deleteButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Delete" + "']"))
    deleteButton.click()
    sleepTime(minWaitTime*1000)
  }

  protected def selectOption(option: PartsCatalogPageContextMenuPopup.CONTEXT_MENU_POPUP_OPTION) {
    this.selectOption(option.displayValue)
  }

  def getContextMenuHeaderName() ={
    val contextMenuHeaderEle = driver.findElement(By.className(CONTEXT_MENU_HEADER_CLASS))
    contextMenuHeaderEle.getText
  }

  def getContextMenuItems():List[String]=
  {
    val menuItemEls = driver.findElements(By.xpath("//ul[@id = '" + CONTEXT_MENU_LIST_ID + "']//li//a")).asScala
    val menuItems = menuItemEls.map(_.getText)
    menuItems.toList
  }


}
