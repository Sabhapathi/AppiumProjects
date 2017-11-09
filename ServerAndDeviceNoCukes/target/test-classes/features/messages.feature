# Created by Nandini.Sullekal at 1/10/2017
Feature: MessageSanity
  # Enter feature description here

  Scenario:ReadMessage
    Given user is on mobile home page

    When user enter "999999999" into activation field
    Then user press on "Activate" button
    Then user should see the text "Set Bridge URL"
    Then user change the URL to "http://crt-bridge.xora.com/bridge/DeviceBridgeServlet"
    Then user press on "Update" button
    When user enter valid phone number "9999900122"
    Then user press on "Activate" button
    Then user should see the text "EULA"
    When user clicks on "I Agree" button
    Then user should see the text "Warning"
    And user clicks on "Ok" button
    Then user wait for "New Updates" popup and tap on "Ok" button
    Then  user wait for 10 seconds
    Then user touch on "Message" feature icon
    Then user wait for 2 seconds
    Then user press "ServerDeviceMessageSanity"
    Then user should see the text "Subject : ServerDeviceMessageSanity"
    Then user should see the text "Sender : pathi, Sabha"
    Then user clicks on "Delete" button
    Then user should see the text "Are you sure you wish to delete this message?"
    Then user clicks on "Yes" button
    Then user wait for 4 seconds
