package com.xora.test.admin

import com.xora.mc.util.LoadableElement
import com.xora.pageObjects.{HomePage, MessagesPage, DeviceLoginPage, MobilePage}
import com.xora.pageObjects.MobilePage._
import com.xora.test.SeleniumPostLoginTest
import com.xora.util.SleepTime._
import org.scalatest.matchers.ShouldMatchers
import org.testng.annotations.Test
import scala.collection.JavaConverters._

/**
 * Created by Nandini.Sullekal on 1/9/2017.
 */
class SampleClass extends SeleniumPostLoginTest with LoadableElement with ShouldMatchers  {
val True = true
  val False = false
  @Test
  def sampleTest() {
    var homePage = new HomePage(androidDriver)
    val inboxPage = securedPage.loadMessagesInboxPage
    //Validate Create Message Popup
    val createMessagePopup = inboxPage.createMessage
    createMessagePopup.getPopupTitle should be("Create Message")
    createMessagePopup.getLabels should be(List("Date:", "To:", "Subject:", "Message:"))
    createMessagePopup.getButtonsNames should be(List("Cancel", "Send"))

    createMessagePopup.setSubject("ServerDeviceMessageSanity")
    createMessagePopup.selectGroups(List("Automate worker"))
    createMessagePopup.setMessageBody("Server Device Message Sanity Message body")
    createMessagePopup.send

//    val loginPage = new DeviceLoginPage(androidDriver)
//    var homePage = loginPage.login()

    homePage.touchFeatureIcon("Message")
    var messagesPage = new MessagesPage(androidDriver)
    messagesPage.tapOn("ServerDeviceMessageSanity")
     val actualMessageDetails = messagesPage.getVisibleText.asScala.patch(0,Nil,1).patch(0,Nil,1).patch(1,Nil,1).toList
    actualMessageDetails should be (List("Sender : pathi, Sabha", "Subject : ServerDeviceMessageSanity", "Server Device Message Sanity Message body"))
    messagesPage.click_Delete_Button()
    messagesPage.getVisibleText.asScala.toList should be (List("Delete?", "Are you sure you wish to delete this message?"))
    messagesPage = messagesPage.click_Yes_On_DeleteMessage_Dialog()
    homePage = messagesPage.tapOnTopBarButton("Home")

    //Validate Sent Message page
    var sentMessagePage = inboxPage.navigateToSentMessagesPage
    sentMessagePage.getPageHeader should be("Messages")
    sentMessagePage.getToolBars should be(List("Inbox", "Sent", "Deleted", "Create Message", "Delete Message"))
    sentMessagePage.getColumnHeaders should be(List("To", "Subject", "Date"))
    sentMessagePage.validateCollapseToolBar() should be(True)
    sentMessagePage.validateExpandToolBar() should be(True)
    sentMessagePage.validateCollapseSearchBox() should be(True)
    sentMessagePage.validateExpandSearchBox() should be(True)
    sentMessagePage.isExcelLinkPresent should be(True)
    sentMessagePage.isRefreshLinkPresent should be(True)
    sentMessagePage.getLatestMessageRow
    val sentMessageContextMenu = sentMessagePage.contextMenuOfLatestMessage
    sentMessageContextMenu.getContextMenuHeader should be("Messages : " + "ServerDeviceMessageSanity")
    sentMessageContextMenu.listContextMenuItems().size == List("Delete Message", "Read Message").size should be(True)
    sentMessageContextMenu.listContextMenuItems().toSet == List("Delete Message", "Read Message").toSet should be(True)


    //validate Read Message Page
    val readMessagePage = sentMessageContextMenu.readMessage()
    readMessagePage.getPageHeader should be("ServerDeviceMessageSanity")
    val readMessageDetails = readMessagePage.getMessageDetails
    readMessagePage.getMessageLabels should be(List("From:", "To:", "Date:", "Subject:"))
    readMessagePage.getMessageBody should be("Server Device Message Sanity Message body")
    readMessageDetails should contain("Subject:" + "ServerDeviceMessageSanity")
    readMessageDetails should contain("From:sabha")
    sleepTime(minWaitTime * 1000)

    //Navigate To Sent Messages Page From Read Messages page.
    sentMessagePage = readMessagePage.navigateToSentMessagesPage
    sentMessagePage.getPageHeader should be("Messages")

    //Delete the Latest Message and Validate in Deleted Page
    sentMessagePage.getLatestMessageRow
    sentMessagePage.contextMenuOfLatestMessage.deleteMessageAccept()
    sleepTime(minWaitTime * 1000)
    sentMessagePage.navigateToDeletedMessagePage.getAllMessageSubjects should contain("ServerDeviceMessageSanity")



  }

}
