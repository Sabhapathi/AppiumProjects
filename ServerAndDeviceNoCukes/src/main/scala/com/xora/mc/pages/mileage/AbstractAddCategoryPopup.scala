package com.xora.mc.pages.mileage

import com.xora.mc.pages.mileage.AbstractAddCategoryPopup._
import com.xora.util.SleepTime._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}

import scala.collection.JavaConverters._

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 8/23/13
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class AbstractAddCategoryPopup[T](driver: WebDriver, parentPage: T) {

  new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IFRAME_ID))

  def getPopupTitle = {
    val popupTitleEle = driver.findElement(By.className(TITLE_CLASS))
    popupTitleEle.getText
  }

  def getLabelNames= {
    val labelEls = driver.findElements(By.tagName("label")).asScala
    val labelsList = labelEls.filter(_.getText.nonEmpty).map(_.getText).toList
    labelsList.patch(3,Nil,1)
  }

  def getButtonNames= {
    val buttonEls = driver.findElements(By.xpath("//div[@class = '"+BUTTON_CLASS+"']//a")).asScala
    val buttonsList = buttonEls.map(_.getText).toList
    buttonsList
  }
  
  def setCategoryName(categoryName: String):AbstractAddCategoryPopup[T]=
  {
    val nameEl = new WebDriverWait(driver, 10).until(
      ExpectedConditions.elementToBeClickable(By.id(ADD_CATEGORY_NAME_ID)))
    nameEl.clear()
    nameEl.sendKeys(categoryName)
    this
  }

  def setReimburseRate(reimburseRate: String)=
  {
    val reimburseRateEl = new WebDriverWait(driver, 10).until(
      ExpectedConditions.elementToBeClickable(By.id(ADD_CATEGORY_REIMBURSE_RATE_ID)))
    reimburseRateEl.clear()
    reimburseRateEl.sendKeys(reimburseRate)
    this
  }

  def setDescription(description: String)=
  {
    if(!description.isEmpty)
    {
      val descriptionEl = new WebDriverWait(driver, 10).until(
        ExpectedConditions.elementToBeClickable(By.id(ADD_CATEGORY_DESCRIPTION_ID)))
      descriptionEl.clear()
      descriptionEl.sendKeys(description)
    }
    this
  }

  def setToDefaultCategory(default: String)=
  {
    if(default.equals("Yes"))
    {
      val defaultCheckBox = new WebDriverWait(driver, 10).until(
        ExpectedConditions.elementToBeClickable(By.id(ADD_CATEGORY_DEFAULT_ID)))
      defaultCheckBox.click()
    }
    this
  }

  def presenceOfMakeDefaultCheckBox() = {
    var flag = false
    try {
      new WebDriverWait(driver, 10)
        .until(ExpectedConditions.presenceOfElementLocated(By.id(MAKE_DEFAULT_CHECKBOX_ID)))
      flag = true
    }
    catch {
      case e: Exception =>
        println("Make default category checkbox is not present ")
    }
    flag
  }

  def getDefaultCheckboxState=
  {
    var state = false
    val defaultCheckbox = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.presenceOfElementLocated(By.id(MAKE_DEFAULT_CHECKBOX_ID)))
    if(defaultCheckbox.isSelected){
      state = true
    }
    state
  }

  def getCurrentDefaultCategoryName=
  {
    val currentDefault = driver.findElements(By.className(CURRENT_DEFAULT_CATEGORY_MESSAGE_CLASS))
    currentDefault.get(1).getText
  }

  def clickSaveAndClose(): T=
  {
    val saveAndCLoseButton = new WebDriverWait(driver, 10).until(
      ExpectedConditions.elementToBeClickable(By.id(SAVE_AND_CLOSE_ID)))
    saveAndCLoseButton.click()
    driver.switchTo.defaultContent
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id(XORA_UNDERLAY_ID)))
    parentPage
  }

  def clickCancel(): T =
  {
    val cancelButton = new WebDriverWait(driver, 10).until(
      ExpectedConditions.elementToBeClickable(By.id(CANCEL_ID)))
    cancelButton.click()
    driver.switchTo.defaultContent
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id(XORA_UNDERLAY_ID)))
    parentPage
  }

  def getAddCategoryHeadLine= {
    val headLineText = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.visibilityOfElementLocated(By.className(PAGE_HEADLINE_CLASS))).getText
    headLineText.trim
  }

  def clickSaveAndCloseWithEmptyField() {
    val saveAndCloseButton = new WebDriverWait(driver, 10).until(
      ExpectedConditions.elementToBeClickable(By.id(SAVE_AND_CLOSE_ID)))
    saveAndCloseButton.click()
    sleepTimeInSecond(minWaitTime)

  }

  def getCategoryPopupErrorMessage= {
    val errorMessages = driver.findElements(By.className(ERROR_MESSAGE_CLASS)).asScala
    val errors = errorMessages.map(_.getText.trim).toList
    errors
  }

}

object AbstractAddCategoryPopup {
  val IFRAME_ID = "xrCommonDialogIFrame"
  val TITLE_CLASS = "popupSectionHeadline"
  val ADD_CATEGORY_NAME_ID = "categoryData.name"
  val ADD_CATEGORY_REIMBURSE_RATE_ID = "categoryData.reimburseRate"
  val ADD_CATEGORY_DESCRIPTION_ID = "categoryData.description"
  val ADD_CATEGORY_DEFAULT_ID = "categoryData_defaultFlag_forDisplay"
  val SAVE_AND_CLOSE_ID = "submit"
  val CANCEL_ID = "cancel"
  val BUTTON_CLASS = "buttonPanel"
  val XORA_UNDERLAY_ID = "xora-underlay"
  val PAGE_HEADLINE_CLASS = "popupPageTitle"
  val ERROR_MESSAGE_CLASS = "errorMessage"
  val MAKE_DEFAULT_CHECKBOX_ID = "categoryData_defaultFlag_forDisplay"
  val CURRENT_DEFAULT_CATEGORY_MESSAGE_CLASS= "formLabelNotes-italic"
}
