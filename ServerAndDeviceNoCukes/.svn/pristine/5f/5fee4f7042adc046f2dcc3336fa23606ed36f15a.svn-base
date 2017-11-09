package com.xora.test.admin

import com.xora.mc.util.LoadableElement
import com.xora.test.SeleniumPostLoginTest
import com.xora.util.GenerateName._
import com.xora.util.SleepTime._
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import cucumber.api.testng.TestNGCucumberRunner
import org.junit.runner.RunWith
import org.scalatest.concurrent.Eventually
import org.scalatest.matchers.ShouldMatchers
import org.testng.annotations.Test

/**
 * Created by Nandini.Sullekal on 1/10/2017.
 */

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features/messages.feature"),
  glue = Array("com/xora/test/stepDefinition"),
  dryRun = false,
  plugin = Array("html:output"))
class MessageSanityTest extends SeleniumPostLoginTest with LoadableElement with ShouldMatchers with Eventually {
val True = true
  val False = false
  @Test
  def createMesageandValidateInDevice() {
    securedPage.loadHomePage
    val inboxPage = securedPage.loadMessagesInboxPage

    //Validate UI on Inbox List Page
    inboxPage.getPageHeader should be("Messages")
    inboxPage.getToolBars should be(List("Inbox", "Sent", "Deleted", "Create Message", "Delete Message"))
    inboxPage.getColumnHeaders should be(List("From", "Subject", "Date"))
    inboxPage.isExcelLinkPresent should be(True)
    inboxPage.validateCollapseSearchBox() should be(True)
    inboxPage.validateCollapseToolBar() should be(True)
    inboxPage.validateExpandSearchBox() should be(True)
    inboxPage.validateExpandToolBar() should be(True)
    inboxPage.isRefreshLinkPresent should be(True)

    //Create Message
    val createMessagePopup = inboxPage.createMessage

    //Validate Create Message Popup
    createMessagePopup.getPopupTitle should be("Create Message")
    createMessagePopup.getLabels should be(List("Date:", "To:", "Subject:", "Message:"))
    createMessagePopup.getButtonsNames should be(List("Cancel", "Send"))

    createMessagePopup.setSubject("ServerDeviceMessageSanity")
    createMessagePopup.selectGroups(List("Automate worker"))
    createMessagePopup.setMessageBody("Server Device Message Sanity Message body")
      createMessagePopup.send
      sleepTime(minWaitTime * 1000)


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

    //Validate crated Message on Device.
    new TestNGCucumberRunner(this.getClass).runCukes()

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
    sentMessagePage.navigateToDeletedMessagePage.getAllMessageSubjects should not contain "ServerDeviceMessageSanity"

  }
  }
