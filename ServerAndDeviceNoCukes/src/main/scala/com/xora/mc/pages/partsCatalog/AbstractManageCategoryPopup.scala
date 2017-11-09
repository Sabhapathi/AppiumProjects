package com.xora.mc.pages.partsCatalog

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.support.ui.{Select, ExpectedConditions, WebDriverWait}
import com.xora.mc.pages.partsCatalog.AbstractManageCategoryPopup._
import scala.collection.JavaConverters._
import com.xora.mc.util.XpathUtils._
import com.xora.util.SleepTime._


/**
 * Created with IntelliJ IDEA.
 * User: Itee.Yadav
 * Date: 5/19/15
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
class AbstractManageCategoryPopup[T](driver: WebDriver, parentPage: T) {

  new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IFRAME_ID))

  def getPopupTitle = {
    val popupTitleEle = driver.findElement(By.className(TITLE_CLASS))
    popupTitleEle.getText
  }

  def getLabelNames = {
    val labelEls = driver.findElements(By.tagName("label")).asScala
    val labelsList = labelEls.filter(_.getText.nonEmpty).map(_.getText.trim).toList
    labelsList
  }

  def getButtonNames = {
    val buttonEls = driver.findElements(By.xpath("//div[@class = '"+BUTTON_CLASS+"']//a")).asScala
    val buttonsList = buttonEls.map(_.getText).toList
    buttonsList
  }

  def getAlreadyCreatedCategoryNames = {
    val categoryNameEls = driver.findElements(By.xpath("//select[@id = '" + CATEGORY_LIST_ID + "']//option")).asScala
    val categoryNameList = categoryNameEls.map(_.getText).toList
    categoryNameList
  }

  def clickNewButton() {
    val newButtonEl = driver.findElement(By.id(NEW_BUTTON_ID))
    newButtonEl.click()
  }

  def clickDeleteButton() {
    val deleteButtonEl = driver.findElement(By.id(DELETE_BUTTON_ID))
    deleteButtonEl.click()
  }

  def clickApplyButton() {
    val applyButtonEl = driver.findElement(By.id(APPLY_BUTTON_ID))
    applyButtonEl.click()
  }


  def addNewCategory(categoryName: String) {
    clickNewButton()
    val categoryNameTextField = driver.findElement(By.id(CATEGORY_NAME_ID))
    categoryNameTextField.clear()
    categoryNameTextField.sendKeys(categoryName)
    clickApplyButton()
  }

  def checkLaborCheckBox {
    val laborCheckBoxEl =  driver.findElement(By.id("categoryIsLabor"))
    if(!laborCheckBoxEl.isSelected)
      laborCheckBoxEl.click()
  }

  def uncheckLaborCheckBox {
    val laborCheckBoxEl =  driver.findElement(By.id("categoryIsLabor"))
    if(laborCheckBoxEl.isSelected)
      laborCheckBoxEl.click()
  }


  def getErrorMessageForAddNewCategory(categoryName: String) = {
    addNewCategory(categoryName)
    sleepTime((minWaitTime/2)*1000)
    val errorMessage = getErrorMessageFromAlertBox
    errorMessage
  }

  def getCategoryNameFromRHS(categoryName: String) = {
    selectCategoryFromCategoryList(categoryName)
    val categoryNameInRHS = driver.findElement(By.id(CATEGORY_NAME_ID)).getAttribute("value")
    categoryNameInRHS
  }

  def selectCategoryFromCategoryList(categoryName: String) {
    val selectCategoryEl = new Select(driver.findElement(By.id(CATEGORY_LIST_ID)))
    selectCategoryEl.selectByVisibleText(categoryName)
  }

  def deleteCategory(categoryName: String) {
    selectCategoryFromCategoryList(categoryName)
    clickDeleteButton()
    sleepTime((minWaitTime)*1000)
    acceptDeleteCategoryConfirmDialog()
  }

  private def acceptDeleteCategoryConfirmDialog() {
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val deleteButton = confirmDialog.findElements(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Delete" + "']")).asScala
    sleepTime((minWaitTime/2)*1000)
    deleteButton(1).click()
    sleepTime((minWaitTime/2)*1000)
  }

  private def cancelDeleteCategoryConfirmDialog() {
    val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
    val cancelButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "Cancel" + "']"))
    cancelButton.click()
  }

  def getErrorMessageForDeleteCategory(categoryName: String) =  {
    selectCategoryFromCategoryList(categoryName)
    clickDeleteButton()
    sleepTime((minWaitTime)*1000)
    val errorMessage = getErrorMessageFromAlertBox
    errorMessage
  }

  def getErrorMessageFromAlertBox: String = {
    val warningMessageDialog = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[" + hasCssClass(DIALOG_ALERT_CLASS) + "]")))
    val errorMessage = warningMessageDialog.findElement(By.className("body")).getText
    val okButton = warningMessageDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "OK" + "']"))
    okButton.click()
    sleepTime(minWaitTime * 2000)
    errorMessage
  }

  def renameCategory(categoryName: String, editedCategoryName: String) {
    selectCategoryFromCategoryList(categoryName)
    val categoryNameTextField = driver.findElement(By.id(CATEGORY_NAME_ID))
    categoryNameTextField.clear()
    categoryNameTextField.sendKeys(editedCategoryName)
    clickApplyButton()
  }

  def moveCategoryUpAndDown(categoryName: String, arrowName: String, steps: Int) {
    val arrowId = arrowName match {
      case "Up" => "itemListUpBtn"
      case "Down" => "itemListDownBtn"
    }
    selectCategoryFromCategoryList(categoryName)
    val arrowEl = driver.findElement(By.id(arrowId))
    for(i<- 1 to steps){
      arrowEl.click()
    }
  }

  def cancel(): T = {
    val cancelButton = new WebDriverWait(driver, 10).until(
      ExpectedConditions.elementToBeClickable(By.id(CANCEL_ID)))
    cancelButton.click()
    driver.switchTo.defaultContent
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id(XORA_UNDERLAY_ID)))
    parentPage
  }

  def saveAndClose(): T = {
    val saveAndCLoseButton = new WebDriverWait(driver, 10).until(
      ExpectedConditions.elementToBeClickable(By.id(SAVE_AND_CLOSE_ID)))
    saveAndCLoseButton.click()
    driver.switchTo.defaultContent
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id(XORA_UNDERLAY_ID)))
    parentPage
  }

  def close: T = {
    driver.switchTo.defaultContent
    val closeEl = driver.findElement(By.className(CLOSE_BUTTON_CLASS))
    closeEl.click()
    parentPage
  }

}

object AbstractManageCategoryPopup {
  val IFRAME_ID = "xrCommonDialogIFrame"
  val TITLE_CLASS = "popupSectionHeadline"

  val CATEGORY_LIST_ID = "itemsListField"
  val NEW_BUTTON_ID = "newItemBtn"
  val BUTTON_CLASS = "buttonPanel"
  val DELETE_BUTTON_ID = "deleteItemBtn"
  val APPLY_BUTTON_ID = "applyItemBtn"
  val CATEGORY_NAME_ID = "categoryName"
  val CANCEL_ID = "cancel"
  val SAVE_AND_CLOSE_ID = "submit"
  val XORA_UNDERLAY_ID = "xora-underlay"
  val DIALOG_CONFIRM_CLASS = "dialog dialog-confirm"
  val DIALOG_BUTTON_CLASS = "linkButton"
  val DIALOG_ALERT_CLASS = "dialog dialog-alert"
  val CLOSE_BUTTON_CLASS = "close"

}
