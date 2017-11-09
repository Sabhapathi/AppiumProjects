package com.xora.mc.pages.partsCatalog

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.support.ui.{Select, ExpectedConditions, WebDriverWait}
import com.xora.mc.pages.partsCatalog.AbstractAddNewPartPopup._
import scala.collection.JavaConverters._
import com.xora.util.SleepTime._

/**
 * Created with IntelliJ IDEA.
 * User: Itee.Yadav
 * Date: 5/19/15
 * Time: 3:19 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class AbstractAddNewPartPopup[T](driver: WebDriver, parentPage: T) {

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

  def getPartNumber = {
    val partNumberEl = driver.findElement(By.id(PART_NUMBER_ID))
    val partNumber = partNumberEl.getAttribute("value")
    partNumber
  }

  def setPartNumber(partNumber: String) {
    if(!partNumber.equals("NA")) {
      val partNumberEl = driver.findElement(By.id(PART_NUMBER_ID))
      partNumberEl.clear()
      partNumberEl.sendKeys(partNumber)
    }
  }

  def getPartName = {
    val partNameEl = driver.findElement(By.id(PART_NAME_ID))
    val partName = partNameEl.getAttribute("value")
    partName
  }

  def setPartName(partName: String) {
    if(!partName.equals("NA")) {
      val partNameEl = driver.findElement(By.id(PART_NAME_ID))
      partNameEl.clear()
      partNameEl.sendKeys(partName)
    }
  }

  def getSelectedCategory = {
    val selectedCategory = driver.findElement(By.xpath("//td//select[@id = '" + PART_CATEGORY_ID + "']//option[@selected]")).getText
    selectedCategory
  }

  def getAllCategoriesListed() = {
    val categoryEls = driver.findElements(By.xpath("//td//select[@id = '" + PART_CATEGORY_ID + "']//option")).asScala
    val categoriesList = categoryEls.map(_.getText).toList
    categoriesList
  }


  def setPartCategory(partCategory: String) {
    if(!partCategory.equals("NA")) {
      val categoryEl = new Select(driver.findElement(By.id(PART_CATEGORY_ID)))
      categoryEl.selectByVisibleText(partCategory)
    }
  }

  def getUnitPrice() = {
    val unitPriceEl = driver.findElement(By.id(UNIT_PRICE_ID))
    val unitPrice = unitPriceEl.getAttribute("value")
    unitPrice
  }

  def setUnitPrice(unitPrice: String) {
    if(!unitPrice.equals("NA")) {
      val unitPriceEl = driver.findElement(By.id(UNIT_PRICE_ID))
      unitPriceEl.clear()
      unitPriceEl.sendKeys(unitPrice)
    }
  }

  def setTaxRate(taxRate: String): Unit = {
    if(!taxRate.equals("NA")) {
      val taxRateEl = driver.findElement(By.id("partCatalog_taxRate"))
      taxRateEl.clear()
      taxRateEl.sendKeys(taxRate)
    }
  }

  def getTaxRate = {
    driver.findElement(By.id("partCatalog_taxRate")).getAttribute("value")
  }

  def getBarcodeNumber() = {
    val barcodeNumberEl = driver.findElement(By.id(BARCODE_NUMBER_ID))
    val barcodeNumber = barcodeNumberEl.getAttribute("value")
    barcodeNumber
  }

  def setBarcodeNumber(barcodeNumber: String) {
    if(!barcodeNumber.equals("NA")) {
      val barcodeNumberEl = driver.findElement(By.id(BARCODE_NUMBER_ID))
      barcodeNumberEl.clear()
      barcodeNumberEl.sendKeys(barcodeNumber)
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

  def saveAndCloseForErrorValidation()
  {
    val saveAndCloseButton = new WebDriverWait(driver, 10).until(
      ExpectedConditions.elementToBeClickable(By.id(SAVE_AND_CLOSE_ID)))
    saveAndCloseButton.click()
    sleepTimeInSecond(minWaitTime)
  }

  def getErrorMessage = {
    val errorMessages = driver.findElements(By.className(ERROR_MESSAGE_CLASS)).asScala
    val errors = errorMessages.map(_.getText.trim).toList
    errors
  }

  def clickCloseButton = {
    driver.switchTo().defaultContent()
    sleepTime((minWaitTime/2)*1000)
    val closeEl = driver.findElement(By.className(CLOSE_BUTTON_CLASS))
    closeEl.click()
    parentPage
  }

}

object AbstractAddNewPartPopup{
  val IFRAME_ID = "xrCommonDialogIFrame"
  val TITLE_CLASS = "popupSectionHeadline"
  val SAVE_AND_CLOSE_ID = "submit"
  val CANCEL_ID = "cancel"
  val BUTTON_CLASS = "buttonPanel"
  val XORA_UNDERLAY_ID = "xora-underlay"
  val ERROR_MESSAGE_CLASS = "errorMessage"
  val CLOSE_BUTTON_CLASS = "close"

  val PART_NUMBER_ID = "partCatalog_partNumber"
  val PART_NAME_ID = "partCatalog_partName"
  val PART_CATEGORY_ID = "selectedPartCategoryId"
  val UNIT_PRICE_ID = "partCatalog_suggestedUnitPrice"
  val BARCODE_NUMBER_ID = "partCatalog_barcode"

}
