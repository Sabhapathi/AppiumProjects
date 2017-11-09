package com.xora.mc.pages.mileage

import com.xora.mc.pages.ListPageContextMenuPopup
import com.xora.mc.pages.mileage.MileageTripListPageContextMenuPopup.{DELETE_TRIP, EDIT_TRIP, VIEW_TRIP_DETAILS}
import com.xora.mc.util.XpathUtils._
import com.xora.util.SleepTime._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}

import scala.collection.JavaConverters._

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 8/12/13
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
object MileageTripListPageContextMenuPopup {
  sealed abstract class CONTEXT_MENU_POPUP_OPTION(val displayValue: String)
  case object EDIT_TRIP extends CONTEXT_MENU_POPUP_OPTION("Edit Trip")
  case object VIEW_TRIP_DETAILS extends CONTEXT_MENU_POPUP_OPTION("View Trip Details")
  case object DELETE_TRIP extends CONTEXT_MENU_POPUP_OPTION("Delete Trip")
}

class MileageTripListPageContextMenuPopup(driver: WebDriver, parentPage: MileageTripListPage) extends
ListPageContextMenuPopup[MileageTripListPage](driver: WebDriver, parentPage: MileageTripListPage)   {
  val DIALOG_CONFIRM_CLASS = "dialog dialog-confirm"
  val DIALOG_BUTTON_CLASS = "linkButton"
  val CONTEXT_MENU_LIST_CLASS_ID = "actionList"
  val CONTEXT_MENU_CLOSE_BUTTON_ID = "puClose"
  val CONTEXT_MENU_HEADER_CLASS = "cssbox_head"


  def editTrip() = {
    this.selectOption(EDIT_TRIP)
    new EditTripPopup(driver,parentPage)
  }
  def viewTripDetails()= {
   this.selectOption(VIEW_TRIP_DETAILS)
    new ViewTripDetailPage(driver,parentPage)
  }
  def deleteTripCancel()={
    this.selectOption(DELETE_TRIP)
    cancelDeleteTripConfirmDialog()
    parentPage
  }
  def deleteTripDelete()={
    this.selectOption(DELETE_TRIP)
    deleteDeleteTripConfirmationDialog()
    parentPage
  }
  private def cancelDeleteTripConfirmDialog(){
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val cancelButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Cancel" + "']"))
    cancelButton.click()
  }
  private def deleteDeleteTripConfirmationDialog(){
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val deleteButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Delete" + "']"))
    deleteButton.click()
    sleepTime(minWaitTime*1000)
  }
  protected def selectOption(option: MileageTripListPageContextMenuPopup.CONTEXT_MENU_POPUP_OPTION) {
    this.selectOption(option.displayValue)
  }

  def getContextMenuHeaderName ={
    val contextMenuHeaderEle = driver.findElement(By.className(CONTEXT_MENU_HEADER_CLASS))
    contextMenuHeaderEle.getText
  }


  def contextMenuContent(): List[String] = {
    val contextMenuListEls = driver.findElements(By.id("cssbox_body_id")).asScala
    val contextMenuList = contextMenuListEls.map(_.getText)
    contextMenuList.toList
  }

  def closeContextMenu()
  {
    val closeButton = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className(CONTEXT_MENU_CLOSE_BUTTON_ID)))
    closeButton.click()
  }
}
