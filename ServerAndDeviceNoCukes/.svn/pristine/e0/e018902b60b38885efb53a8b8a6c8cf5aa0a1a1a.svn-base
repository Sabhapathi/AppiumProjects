package com.xora.mc.pages


import com.xora.mc.util.XpathUtils._
import com.xora.util.SleepTime._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver, WebElement}

import scala.collection.JavaConverters._



/**
 * Created with IntelliJ IDEA.
 * User: nandinis
 * Date: 3/16/15
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 */
 abstract class AbstractGroupFilterPopup (driver: WebDriver) {
  new WebDriverWait(driver, 20)
    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(AbstractGroupFilterPopup.IFRAME_ID))

  protected var groupField: WebElement = null
  protected var allGroups: WebElement = null

  def saveAndClose =
  {
    val submitButton = new WebDriverWait(driver, 20).until(
      ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='" + AbstractGroupFilterPopup.SUBMIT_BUTTON_ID + "']")))
    submitButton.click()
    sleepTime(minWaitTime * 2000)
    driver.switchTo.defaultContent
    new WebDriverWait(driver, 40).until(ExpectedConditions.invisibilityOfElementLocated(By.id(AbstractGroupFilterPopup.XORA_UNDERLAY_ID)))
  }

  def cancel =
  {
    val cancelButton = new WebDriverWait(driver, 10).until(
      ExpectedConditions.elementToBeClickable(By.id(AbstractGroupFilterPopup.CANCEL_BUTTON_ID)))
    cancelButton.click()
    driver.switchTo.defaultContent
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id(AbstractGroupFilterPopup.CANCEL_BUTTON_ID)))

  }

  def close {
    sleepTime(minWaitTime * 1000)
    driver.switchTo().defaultContent()
    val closeEl = driver.findElement(By.className("close"))
    closeEl.click()
  }

  def getAllButtons = {
    val buttonDivEl = driver.findElement(By.className(AbstractGroupFilterPopup.BUTTONS_PANEL_CLASS))
    val buttonsEls = buttonDivEl.findElements(By.xpath("//a["+hasCssClass(AbstractGroupFilterPopup.BUTTONS_LINK_CLASS_NAME)+"]")).asScala
    val buttonsList = buttonsEls.map(_.getText.trim).toList
    buttonsList
  }

  def getPopUpTitle = {
    val popUpTitleEl = driver.findElement(By.id(AbstractGroupFilterPopup.POPUP_TITLE_ID))
    val popUpTitleText = popUpTitleEl.getText
    popUpTitleText.trim
  }
  def selectAllGroup(value: String) = {
    this.groupField = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.id(AbstractGroupFilterPopup.GROUP_FIELD_ID)))
    if (!value.equals("NA")) {
      this.allGroups = groupField.findElement(By.id(AbstractGroupFilterPopup.ALL_GROUP_ID))
      if (value.equalsIgnoreCase("Yes")) {
        if (!allGroups.isSelected) {
          allGroups.click()
        }
      }
      if (value.equalsIgnoreCase("No")) {
        if (allGroups.isSelected) {
          allGroups.click()
        }
      }
    }
    this
  }

  def setGroups(groupNames: List[String]) = {
    this.groupField = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.id(AbstractGroupFilterPopup.GROUP_FIELD_ID)))
    if (groupNames.contains("All Groups")) {
      selectAllGroup("Yes")
    }
    else {
      this.allGroups = groupField.findElement(By.id(AbstractGroupFilterPopup.ALL_GROUP_ID))
      try {
        val groupExpandButtons = driver.findElements(By.xpath(AbstractGroupFilterPopup.GROUP_EXPAND_BUTTON_XPATH)).asScala
        for (groupExpandButton <- groupExpandButtons) {
          if (groupExpandButton.getAttribute("class").equals(AbstractGroupFilterPopup.GROUP_EXPAND_BUTTONS_CLASS))
            groupExpandButton.click()
        }
      }
      catch {
        case e: Exception => {
//          logger.debug("groups dose not have user")
        }
      }

      if (groupNames != List("NA")) {
        if (!allGroups.isSelected) {
          allGroups.click()
        }
        if (allGroups.isSelected) {
          allGroups.click()
        }
        val groupEls1 = groupField.findElements(By.xpath(AbstractGroupFilterPopup.GROUP_XPATH_1)).asScala.toList
        val groupEls2 = groupField.findElements(By.xpath(AbstractGroupFilterPopup.GROUP_XPATH_2)).asScala.toList

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
                val group = groupEl.findElement(By.className(AbstractGroupFilterPopup.GROUP_CHECKBOX_CLASS))
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
    }
    this
  }

  def getSelectedGroups = {
    var groupsList: List[String] = List()

    try {
      val groupExpandButtons = driver.findElements(By.xpath(AbstractGroupFilterPopup.GROUP_EXPAND_BUTTON_XPATH)).asScala
      for (groupExpandButton <- groupExpandButtons) {
        if (groupExpandButton.getAttribute("class").equals(AbstractGroupFilterPopup.GROUP_EXPAND_BUTTONS_CLASS))
          groupExpandButton.click()
      }
    }
    catch {
      case e: Exception => {
//        logger.debug("groups dose not have Sub groups")
      }
    }
    val groupEls1 = driver.findElements(By.xpath(AbstractGroupFilterPopup.GROUP_FIELD_XPATH + AbstractGroupFilterPopup.GROUP_XPATH_1)).asScala.toList
    val groupEls2 = driver.findElements(By.xpath(AbstractGroupFilterPopup.GROUP_FIELD_XPATH + AbstractGroupFilterPopup.GROUP_XPATH_2)).asScala.toList
    val groupEls = groupEls1 ::: groupEls2
    for(groupEl <- groupEls){
      val group = groupEl.findElement(By.className(AbstractGroupFilterPopup.GROUP_CHECKBOX_CLASS))
      if (group.isSelected) {
        val group= groupEl.getText
        val groupList =group.split("\n")
        groupsList = groupsList ::: List(groupList(0))
      }
    }
    if(groupsList.isEmpty){
      groupsList = groupsList ::: List("NULL")
    }
    groupsList
  }

  def getGroupsNamesList = {
    var groups: List[String] = List()
    try {
      val groupExpandButtons = driver.findElements(By.xpath(AbstractGroupFilterPopup.GROUP_EXPAND_BUTTON_XPATH)).asScala
      for (groupExpandButton <- groupExpandButtons) {
        if (groupExpandButton.getAttribute("class").equals(AbstractGroupFilterPopup.GROUP_EXPAND_BUTTONS_CLASS))
          groupExpandButton.click()
      }
    }
    catch {
      case e: Exception => {
//        logger.debug("groups dose not have Sub groups")
      }
    }
    val groupEls1 = driver.findElements(By.xpath(AbstractGroupFilterPopup.GROUP_FIELD_XPATH + AbstractGroupFilterPopup.GROUP_XPATH_1)).asScala.toList
    val groupEls2 = driver.findElements(By.xpath(AbstractGroupFilterPopup.GROUP_FIELD_XPATH + AbstractGroupFilterPopup.GROUP_XPATH_2)).asScala.toList
    val groupEls = groupEls1 ::: groupEls2
    for(groupEl<-groupEls){
      val group= groupEl.getText
      val groupList =group.split("\n")
      groups = groups ::: List(groupList(0))
    }
    groups
  }


}

object AbstractGroupFilterPopup {
  val IFRAME_ID = "xrCommonDialogIFrame"
  val XORA_UNDERLAY_ID = "xora-underlay"
  val STEP_LIST_ID = "steps"
  val CANCEL_BUTTON_ID = "cancel"
  val SUBMIT_BUTTON_ID = "submit"
  val BUTTONS_LINK_CLASS_NAME = "linkButton"
  val BUTTONS_PANEL_CLASS = "buttonPanel"
  val POPUP_TITLE_ID = "popupTitle"
  val SUB_NODE_ELEMENT_CLASS = "trNdElem "
  val NODE_ELEMENT_CLASS = "trNdElem nd-spcr "
  val GROUP_FIELD_ID = "groupTreeRoot"
  val SELECT_ALL_EMAIL_IDS = "selectAll"
  val ALL_GROUP_ID = "divisionListIds"
  val GROUP_EXPAND_BUTTON_XPATH = "//div[@class = '" + SUB_NODE_ELEMENT_CLASS + "']//span"
  val GROUP_CHECKBOX_CLASS = "trNdChk"
  val GROUP_EXPAND_BUTTONS_CLASS = "ndPlusBtn"
  val GROUP_XPATH_1 = "//div[@class = '" + NODE_ELEMENT_CLASS + "']"
  val GROUP_XPATH_2 = "//div[@class = '" + SUB_NODE_ELEMENT_CLASS + "']"
  val GROUP_FIELD_XPATH = "//span[@id='" + GROUP_FIELD_ID + "']"
}
