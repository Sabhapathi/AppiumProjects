package com.xora.mc.pages.Forms

import com.xora.mc.util.XpathUtils._
import com.xora.util.SleepTime._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver, WebElement}
import com.xora.mc.pages.Forms.AbstractFormFilterPopup._
import scala.collection.JavaConverters._


/**
 * Created with IntelliJ IDEA.
 * User: Nandini
 * Date: 12/5/13
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class AbstractFormFilterPopup[T](driver: WebDriver, parentPage: T) {
  new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IFRAME_ID))

  def selectAllForms(value: String) = {
    sleepTime((minWaitTime/2)*1000)
    val allFormsEl = driver.findElement(By.id(ALL_FORMS_ID))
    if(value.equalsIgnoreCase("Yes")) {
      if(!allFormsEl.isSelected) {
        sleepTime((minWaitTime/4)*1000)
        allFormsEl.click()
      }
    }
    if(value.equalsIgnoreCase("No")) {
      sleepTime((minWaitTime/4)*1000)
      if(!allFormsEl.isSelected) {
        allFormsEl.click()
      }
      if(allFormsEl.isSelected){
        allFormsEl.click()
      }
    }
    this
  }

  def verifyAllFormsAreSelected = {
    val allFormsEl = driver.findElement(By.id(ALL_FORMS_ID))
    var flag = false
    sleepTime((minWaitTime)*1000)
    if(allFormsEl.isSelected){
      flag = true
    }
    flag
  }

  def verifyAllLinkedActivitiesAreSelected = {
    val allLinkedActionsEl = driver.findElement(By.id(ALL_LINKED_ACTIONS_ID))
    var flag = false
    sleepTime((minWaitTime) * 1000)
    if (allLinkedActionsEl.isSelected) {
      flag = true
    }
    flag
  }


  def selectAllLinkedActivities(value: String)={
    sleepTime((minWaitTime/2)*1000)
    val allLinkedActionsEl = driver.findElement(By.id(ALL_LINKED_ACTIONS_ID))
    if(value.equalsIgnoreCase("Yes")) {
      if(!allLinkedActionsEl.isSelected){
        allLinkedActionsEl.click()
      }

    }
    if(value.equalsIgnoreCase("No")) {
      if(!allLinkedActionsEl.isSelected) {
        allLinkedActionsEl.click()
      }
      if(allLinkedActionsEl.isSelected){
        allLinkedActionsEl.click()
      }
    }
    this
  }

  def selectForms(formNames: List[String]) = {
    val allFormsEl = driver.findElement(By.id(ALL_FORMS_ID))
    sleepTime((minWaitTime/2)*1000)
    if (!allFormsEl.isSelected) {
      allFormsEl.click()
    }
    if (allFormsEl.isSelected) {
      allFormsEl.click()
    }
    for (formName <- formNames) {
      val spanTreeEl = driver.findElement(By.id(SPAN_FORMS_ID))
      val formEls = spanTreeEl.findElements(By.xpath(FORMS_TREE_XPATH)).asScala
      for (formEl <- formEls) {
        if (formEl.getText.equals(formName)) {
          val checkBoxEl = formEl.findElement(By.className(CHECK_BOX_CLASS_NAME))
          if (!checkBoxEl.isSelected) {
            checkBoxEl.click()
          }
        }
      }
    }
  }

  def getSelectedFormNames: List[String] = {
    var selectedFormNames: List[String] = List()
    val formEls = driver.findElements(By.xpath("//span[@id = '"+SPAN_FORMS_ID+"']" + FORMS_TREE_XPATH)).asScala
    for (formEl <- formEls) {
      if (formEl.findElement(By.tagName("input")).isSelected) {
        selectedFormNames = selectedFormNames ::: List(formEl.getText.trim)
      }
    }
    selectedFormNames
  }

  def getSelectedLinkedActivities:List[String] = {
    var selectedActionsNames: List[String] = List()
    val actionEls = driver.findElements(By.xpath("//span[@id = '"+SPAN_LINKED_ACTIONS_ID+"']" + FORMS_TREE_XPATH)).asScala
    for (actionEl <- actionEls) {
      if (actionEl.findElement(By.tagName("input")).isSelected) {
        selectedActionsNames = selectedActionsNames ::: List(actionEl.getText.trim)
      }
    }
    selectedActionsNames
  }

  def selectLinkedActivity(actionNames: List[String]) = {
    val allActionsEl = driver.findElement(By.id(ALL_LINKED_ACTIONS_ID))

    if (!allActionsEl.isSelected) {
      allActionsEl.click()
    }
    if (allActionsEl.isSelected) {
      allActionsEl.click()
    }
    for (actionName <- actionNames) {
      val spanTreeEl = driver.findElement(By.id(SPAN_LINKED_ACTIONS_ID))
      val actionEls = spanTreeEl.findElements(By.xpath(FORMS_TREE_XPATH)).asScala
      for (actionEl <- actionEls) {
        if (actionEl.getText.equals(actionName)) {
          val checkBoxEl = actionEl.findElement(By.className(CHECK_BOX_CLASS_NAME))
          if (!checkBoxEl.isSelected) {
            checkBoxEl.click()
          }
        }
      }
    }
  }
  def saveAndClose: T = {
    val saveAndCloseButton: WebElement = driver.findElement(By.id(SAVE_AND_CLOSE_BUTTON_ID))
    saveAndCloseButton.click()
    driver.switchTo.defaultContent
    new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.invisibilityOfElementLocated(By.id(XORA_UNDERLAY_ID)))
    parentPage
  }

  def cancel: T = {
    val cancelButton = driver.findElement(By.id(CANCEL_BUTTON_ID))
    cancelButton.click()
    driver.switchTo.defaultContent
    new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.invisibilityOfElementLocated(By.id(XORA_UNDERLAY_ID)))
    parentPage
  }

  def getAllFormNames = {
    val formEls = driver.findElements(By.xpath("//span[@id = '"+SPAN_FORMS_ID+"']" + FORMS_TREE_XPATH)).asScala
    val formsList  = formEls.map(_.getText.trim).toList
    formsList
  }

  def getAllLinkedActivities = {
    val linkedActionEls = driver.findElements(By.xpath("//span[@id = '"+SPAN_LINKED_ACTIONS_ID+"']" + FORMS_TREE_XPATH)).asScala
    val linkedActionsList  = linkedActionEls.map(_.getText.trim).toList
    linkedActionsList
  }

  def getAllButtons = {
    val buttonDivEl = driver.findElement(By.className(BUTTONS_PANEL_CLASS))
    val buttonsEls = buttonDivEl.findElements(By.xpath("//a["+hasCssClass(BUTTONS_LINK_CLASS_NAME)+"]")).asScala
    val buttonsList = buttonsEls.map(_.getText.trim).toList
    buttonsList
  }

  def getPopUpTitle = {
    val popUpTitleEl = driver.findElement(By.id(POPUP_TITLE_ID))
    val popUpTitleText = popUpTitleEl.getText
    popUpTitleText.trim
  }

}

object AbstractFormFilterPopup{
  val SAVE_AND_CLOSE_BUTTON_ID = "submit"
  val COPY_NAME_FIELD_ID = "name"
  val XORA_UNDERLAY_ID = "xora-underlay"
  val IFRAME_ID = "xrCommonDialogIFrame"
  val CANCEL_BUTTON_ID = "cancel"
  val ALL_FORMS_ID = "formTypes"
  val ALL_LINKED_ACTIONS_ID = "linkedActions"
  val SPAN_FORMS_ID = "spanForms"
  val FORMS_TREE_CLASS = "trNdElem nd-spcr "
  val FORMS_TREE_XPATH = "//div[@class = '" + FORMS_TREE_CLASS + "']"
  val SPAN_LINKED_ACTIONS_ID = "spanLinkedActivity"
  val CHECK_BOX_CLASS_NAME  = "trNdChk"
  val BUTTONS_LINK_CLASS_NAME = "linkButton"
  val BUTTONS_PANEL_CLASS = "buttonPanel"
  val POPUP_TITLE_ID = "popupTitle"
}