package com.xora.mc.pages.messages

import com.xora.mc.pages.messages.AbstractCreateMessagePopup._
import com.xora.mc.util.XpathUtils._
import com.xora.util.SleepTime._
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver, WebElement}

import scala.collection.JavaConverters._


/**
 * Created with IntelliJ IDEA.
 * User: Nandini.Sullekal
 * Date: 5/15/15
 * Time: 2:15 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class AbstractCreateMessagePopup[T](driver: WebDriver, parentPage: T){
  new WebDriverWait(driver, 10)
    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IFRAME_ID))

  def getButtonsNames = {
    val buttonEls = driver.findElements(By.xpath("//div[@class = '"+BUTTON_CLASS+"']//a")).asScala
    val buttonsList = buttonEls.map(_.getText).toList
    buttonsList
  }

  def getLabels = {
    val labelEls = driver.findElements(By.xpath("//*["+hasCssClass("label")+"]")).asScala
    val labels = labelEls.map(_.getText.trim).toList
    labels
  }

  def send : T=
  {
    val saveAndCloseButton: WebElement = driver.findElement(By.id(SEND_BUTTON_ID))
    saveAndCloseButton.click()
    driver.switchTo.defaultContent
    new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.id(XORA_UNDERLAY_ID)))
    parentPage
  }

  def sendForErrorValidationTest() {
    val submitButton = new WebDriverWait(driver, 10).until(
      ExpectedConditions.elementToBeClickable(By.id(SEND_BUTTON_ID)))
    submitButton.click()
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
      case e: Exception =>
        val errorMessage = driver.findElements(By.className(ERROR_MESSAGE_CLASS)).asScala
        errorMessageText = errorMessage.filter(!_.getText.isEmpty).map(_.getText.trim).toList
        if (errorMessageText.isEmpty){
          val confirmDialog = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]"))
          val confirmDialogMsg = driver.findElement(By.xpath("//div[" + hasCssClass(DIALOG_CONFIRM_CLASS) + "]//div["+hasCssClass(DIALOG_MSG_CLASS) + "]")).getText
          errorMessageText = errorMessageText ::: List(confirmDialogMsg)
          val okButton = confirmDialog.findElement(By.xpath("//a[" + hasCssClass(DIALOG_BUTTON_CLASS) + "]//span[text() = '" + "OK" + "']"))
          okButton.click()
        }

    }
    errorMessageText
  }

  def cancel : T =
  {
    val saveAndCloseButton: WebElement = driver.findElement(By.id(CANCEL_BUTTON_ID))
    saveAndCloseButton.click()
    Thread.sleep(1000)
    driver.switchTo.defaultContent
    new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(By.id(XORA_UNDERLAY_ID)))
    parentPage
  }

  def getPopupTitle = {
    val HeaderEle = driver.findElement(By.className(TITLE_CLASS))
    HeaderEle.getText
  }

  def getDateAndTime = {
      val dateEl = driver.findElement(By.xpath("//table[@id = 'createMessageTable']//table//tr[contains(text(), 'Date:')]"))
       val dateAndTime = dateEl.getText
    dateAndTime
  }

  def selectAllGroup() = {
    val groupField = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.id(GROUP_FIELD_ID)))
    val allGroupEl = groupField.findElement(By.id(ALL_GROUP_ID))
    if (!allGroupEl.isSelected)
      allGroupEl.click()
    this
  }

  def selectGroups(groupNames: List[String]) = {
    if(groupNames.contains("AllGroups"))  {
      selectAllGroup()
    }
    else {
      val allGroupEl = driver.findElement(By.xpath(TOP_LEVEL_CHECKBOX))
      try {
        val groupExpandButtons = driver.findElements(By.xpath(GROUP_EXPAND_BUTTON_XPATH)).asScala
        for (groupExpandButton <- groupExpandButtons) {
          if (groupExpandButton.getAttribute("class").equals(GROUP_EXPAND_BUTTONS_CLASS))
            groupExpandButton.click()
        }
      }
      catch {
        case e: Exception =>
//          logger.debug("groups dose not have user")

      }

      if (groupNames != List("NA")) {
        if (!allGroupEl.isSelected){
          allGroupEl.click()
        }
        if (allGroupEl.isSelected) {
          allGroupEl.click()
        }
        val groupEls1 = driver.findElements(By.xpath(GROUP_XPATH_1)).asScala.toList
        val groupEls2 = driver.findElements(By.xpath(GROUP_XPATH_2)).asScala.toList

        var parentGroup = ""
        var group = ""
        val groupEls = groupEls1 ::: groupEls2

        for (groupName <- groupNames) {
          if(!groupName.isEmpty) {
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
    }

    this
  }

  def setSubject(subject: String) {
    if(!subject.isEmpty && !subject.equals("NA")){
      val subjectEl = driver.findElement(By.id(SUBJECT_ID))
      subjectEl.clear()
      subjectEl.sendKeys(subject)
    }
  }

  def setMessageBody(message: String){
    if(!message.isEmpty && !message.equals("NA")){
      val messageEl = driver.findElement(By.id(MESSAGE_ID))
      messageEl.clear()
      messageEl.sendKeys(message)
    }
  }

  def getSubject = {
    val subjectEl = driver.findElement(By.id(SUBJECT_ID))
    val subject = subjectEl.getAttribute("value")
    subject
  }

  def getMessageBody = {
    val messageEl = driver.findElement(By.id(MESSAGE_ID))
    val message = messageEl.getAttribute("value")
    message
  }

  def getSelectedWorkers = {
    var workersList: List[String] = List()
    try {
      val groupExpandButtons = driver.findElements(By.xpath(GROUP_EXPAND_BUTTON_XPATH)).asScala
      for (groupExpandButton <- groupExpandButtons) {
        if (groupExpandButton.getAttribute("class").equals(GROUP_EXPAND_BUTTONS_CLASS))
          groupExpandButton.click()
      }
    }
    catch {
      case e: Exception =>
//        logger.debug("groups dose not have Sub groups")

    }
    val groupEls1 = driver.findElements(By.xpath(GROUP_FIELD_XPATH + GROUP_XPATH_1)).asScala.toList
    val groupEls2 = driver.findElements(By.xpath(GROUP_FIELD_XPATH + GROUP_XPATH_2)).asScala.toList
    val groupEls = groupEls1 ::: groupEls2
    for(groupEl <- groupEls){
      val group = groupEl.findElement(By.className(GROUP_CHECKBOX_CLASS))
      if (group.isSelected) {
        val workerGroup = groupEl.findElement(By.tagName("span"))
        if (workerGroup.getAttribute("class").equals("trNdSymb-wrkr")){
          val group= groupEl.getText
          val workerList =group.split("\n")
          workersList = workersList ::: List(workerList(0))
        }
      }
    }
    if(workersList.isEmpty){
      workersList = workersList ::: List("NULL")
    }
    workersList
  }


  def getAllWorkers = {
    var workersList: List[String] = List()
    try {
      val groupExpandButtons = driver.findElements(By.xpath(GROUP_EXPAND_BUTTON_XPATH)).asScala
      for (groupExpandButton <- groupExpandButtons) {
        if (groupExpandButton.getAttribute("class").equals(GROUP_EXPAND_BUTTONS_CLASS))
          groupExpandButton.click()
      }
    }
    catch {
      case e: Exception =>
//        logger.debug("groups dose not have Sub groups")

    }
    val groupEls1 = driver.findElements(By.xpath(GROUP_FIELD_XPATH + GROUP_XPATH_1)).asScala.toList
    val groupEls2 = driver.findElements(By.xpath(GROUP_FIELD_XPATH + GROUP_XPATH_2)).asScala.toList
    val groupEls = groupEls1 ::: groupEls2
    for(groupEl <- groupEls){

      val workerGroup = groupEl.findElement(By.tagName("span"))
      if (workerGroup.getAttribute("class").equals("trNdSymb-wrkr")){
        val group= groupEl.getText
        val workerList =group.split("\n")
        workersList = workersList ::: List(workerList(0))
      }
    }
    if(workersList.isEmpty){
      workersList = workersList ::: List("NULL")
    }
    workersList
  }

  def getSelectedGroupsNamesList = {
    var groups: List[String] = List()
    var finalSelectedGroupNamesList: List[String] = List()
    try {
      val groupExpandButtons = driver.findElements(By.xpath(GROUP_EXPAND_BUTTON_XPATH)).asScala
      for (groupExpandButton <- groupExpandButtons) {
        if (groupExpandButton.getAttribute("class").equals(GROUP_EXPAND_BUTTONS_CLASS))
          groupExpandButton.click()
      }
    }
    catch {
      case e: Exception =>
//        logger.debug("groups dose not have Sub groups")
    }
    val groupEls1 = driver.findElements(By.xpath(GROUP_FIELD_XPATH + GROUP_XPATH_1)).asScala.toList
    val groupEls2 = driver.findElements(By.xpath(GROUP_FIELD_XPATH + GROUP_XPATH_2)).asScala.toList
    val groupEls = groupEls1 ::: groupEls2
    for (groupEl <- groupEls) {
      val group = groupEl.getText
      val groupList = group.split("\n")
      groups = groups ::: List(groupList(0))
    }
    val workersList = getAllWorkers
    val onlyGroupNames = groups.diff(workersList)

    for (onlyGroupName <- onlyGroupNames) {
      for (groupEl <- groupEls) {
        val group = groupEl.getText
        val grp = group.split("\n")
        if (grp(0).equals(onlyGroupName)) {
          val group = groupEl.findElement(By.className(GROUP_CHECKBOX_CLASS))
          if (group.isSelected) {
            val group = groupEl.getText
            val groupList = group.split("\n")
            finalSelectedGroupNamesList = finalSelectedGroupNamesList ::: List(groupList(0))
          }
        }

      }
    }
    finalSelectedGroupNamesList
  }

  def isGroupCheckBoxSelected(groupName: String) = {
    val allGroupEl = driver.findElement(By.xpath(TOP_LEVEL_CHECKBOX))
    try {
      val groupExpandButtons = driver.findElements(By.xpath(GROUP_EXPAND_BUTTON_XPATH)).asScala
      for (groupExpandButton <- groupExpandButtons) {
        if (groupExpandButton.getAttribute("class").equals(GROUP_EXPAND_BUTTONS_CLASS))
          groupExpandButton.click()
      }
    }
    catch {
      case e: Exception =>
//        logger.debug("groups dose not have user")
    }
    val groupEls1 = driver.findElements(By.xpath(GROUP_XPATH_1)).asScala.toList
    val groupEls2 = driver.findElements(By.xpath(GROUP_XPATH_2)).asScala.toList

    var parentGroup = ""
    var group = ""
    val groupEls = groupEls1 ::: groupEls2
    var flag: Any = null
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
        flag = group.isSelected
      }
    }
    flag.toString
  }

  def close() {
    driver.switchTo().defaultContent()
    val closeEl = driver.findElement(By.className("close"))
    closeEl.click()
  }

}

object AbstractCreateMessagePopup {
  val IFRAME_ID = "xrCommonDialogIFrame"
  val TITLE_CLASS = "popupSectionHeadline"
  val BUTTON_CLASS = "buttonPanel"
  val XORA_UNDERLAY_ID = "xora-underlay"
  val SEND_BUTTON_ID = "submit"
  val CANCEL_BUTTON_ID = "cancel"
  val ERROR_MESSAGE_CLASS = "errorMessage"
  val DIALOG_CONFIRM_CLASS = "dialog"
  val DIALOG_BUTTON_CLASS = "linkButton"
  val DIALOG_MSG_CLASS = "body"

  val GROUP_FIELD_ID = "workerTreeRoot"
  val ALL_GROUP_ID = "rootNode"
  val GROUP_EXPAND_BUTTONS_CLASS = "ndPlusBtn"
  val NODE_ELE = "trNdElem "
  val NODE_ELE_SPCR = "trNdElem nd-spcr "
  val GROUP_EXPAND_BUTTON_XPATH = "//div[@class = '"+NODE_ELE+"']//span"
  val GROUP_XPATH_1 = "//div[@class = '"+NODE_ELE_SPCR+"']"
  val GROUP_XPATH_2 = "//div[@class = '"+NODE_ELE+"']"
  val GROUP_CHECKBOX_CLASS = "trNdChk"
  val GROUPS_DIV_ID = "tree-form-rootNode"
  val TOP_LEVEL_CHECKBOX = "//div[@id='" + GROUPS_DIV_ID + "']//input[@type='checkbox']"
  val GROUP_FIELD_XPATH = "//span[@id='" + GROUP_FIELD_ID + "']"

  val SUBJECT_ID = "subject"
  val MESSAGE_ID = "message"
}
