package com.xora.mc.pages.locations

import com.xora.mc.pages.locations.AbstractSendLocationToWorkerPopup._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver, WebElement}

import scala.collection.JavaConverters._
//import com.typesafe.scalalogging.slf4j.Logging
import com.xora.util.SleepTime._


/**
 * Created with IntelliJ IDEA.
 * User: Nandini
 * Date: 11/20/13
 * Time: 3:16 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class AbstractSendLocationToWorkerPopup[T](driver: WebDriver, parentPage: T) {

  new WebDriverWait(driver, 10)
    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IFRAME_ID))

  def SelectAllGroup() = {
    val allGroupEl = driver.findElement(By.id(WORK_GROUPS_ID))
    if (!allGroupEl.isSelected)
      allGroupEl.click()
    this
  }

  def setGroups(groupNames: List[String]) = {
    val allGroupEl = driver.findElement(By.id(WORK_GROUPS_ID))
    try {
      val groupExpandButtons = driver.findElements(By.xpath(GROUP_EXPAND_BUTTON_XPATH)).asScala
      for (groupExpandButton <- groupExpandButtons) {
        if (groupExpandButton.getAttribute("class").equals(GROUP_EXPAND_BUTTONS_CLASS))
          groupExpandButton.click()
      }
    }
    catch {
      case e: Exception => {
//        logger.debug("groups dose not have user")
      }
    }
    if (groupNames != List("NA")) {
      if (!allGroupEl.isSelected)
        allGroupEl.click()
      if (allGroupEl.isSelected) {
        allGroupEl.click()
      }
      val groupEls1 = allGroupEl.findElements(By.xpath(GROUP_XPATH_1)).asScala.toList
      val groupEls2 = allGroupEl.findElements(By.xpath(GROUP_XPATH_2)).asScala.toList

      var parentGroup = ""
      var group = ""
      val groupEls = groupEls1 ::: groupEls2

      for (groupName <- groupNames) {
        if (!groupName.isEmpty) {
          for (groupEl <- groupEls) {
            group = groupEl.getText
            if (group.length > groupName.length) {
              parentGroup = group.substring(0, groupName.length)
            }
            else {
              parentGroup = group
            }

            if (parentGroup.equals(groupName)) {
              val group = groupEl.findElement(By.className(GROUP_CHECKBOX_CLASS))
              if (group.isSelected) {
                group.click()
              }
              if (!group.isSelected) {
                group.click()
              }
            }
          }
        }
      }
    }
    this
  }

  def send: T = {
    val saveAndCloseButton: WebElement = driver.findElement(By.id(SAVE_AND_CLOSE_BUTTON_ID))
    saveAndCloseButton.click()
    driver.switchTo.defaultContent
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id(XORA_UNDERLAY_ID)))
    parentPage
  }

   def clickSendButtonForNegativeValidation()= {
    val saveAndCloseButton: WebElement = driver.findElement(By.id(SAVE_AND_CLOSE_BUTTON_ID))
    saveAndCloseButton.click()
  }

  def cancel: T = {
    val cancelButton = driver.findElement(By.id(CANCEL_BUTTON_ID))
    cancelButton.click()
    driver.switchTo.defaultContent
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id(XORA_UNDERLAY_ID)))
    parentPage
  }

  def errorMessageText() = {
    var errorMessageText: List[String] = List()
    try {
      val alertEl = new WebDriverWait(driver, maxWaitTime)
      if (alertEl.until(ExpectedConditions.alertIsPresent()) != null) {
        val errorMessage = driver.switchTo().alert().getText
        errorMessageText = errorMessageText ::: List(errorMessage)
        driver.switchTo().alert().accept()
        driver.switchTo().defaultContent()
      }
    }
    catch {
      case e: Exception => {
        val errorMessage = driver.findElements(By.className(ERROR_MESSAGE_CLASS)).asScala
        errorMessageText = errorMessage.map(_.getText.trim).toList
      }
    }
    errorMessageText
  }

  def close {
    driver.switchTo().defaultContent()
    val closeEl = driver.findElement(By.className("close"))
    closeEl.click()
  }
}

object AbstractSendLocationToWorkerPopup {
  val IFRAME_ID = "xrCommonDialogIFrame"
  val GROUP_EXPAND_BUTTON_XPATH = "//div[@class = 'trNdElem ']//span"
  val GROUP_CHECKBOX_CLASS = "trNdChk"
  val GROUP_EXPAND_BUTTONS_CLASS = "ndPlusBtn"
  val WORK_GROUPS_ID = "filter.workerIds"
  val GROUP_XPATH_1 = "//div[@class = 'trNdElem nd-spcr ']"
  val GROUP_XPATH_2 = "//div[@class = 'trNdElem ']"
  val SAVE_AND_CLOSE_BUTTON_ID = "submit"
  val CANCEL_BUTTON_ID = "cancel"
  val XORA_UNDERLAY_ID = "xora-underlay"
  val ERROR_MESSAGE_CLASS = "errorMessage"
  val SEND_BUTTON_ID = "send"
}