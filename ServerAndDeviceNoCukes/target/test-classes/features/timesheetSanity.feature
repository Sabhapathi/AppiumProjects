# Created by Nandini.Sullekal at 12/15/2016
Feature: TimeSheetSanity

#  Background: Login
  Scenario: TimeSheetSanity
    Given user is on mobile home page

#    When user enter "999999999" into activation field
#    Then user press on "Activate" button
#    Then user should see the text "Set Bridge URL"
#    Then user change the URL to "http://crt-bridge.xora.com/bridge/DeviceBridgeServlet"
#    Then user press on "Update" button
    When user enter valid phone number "9999900111"
    Then user press on "Activate" button
    Then user should see the text "EULA"
    When user clicks on "I Agree" button
    Then user should see the text "Warning"
    And user clicks on "Ok" button
   Then user wait for "New Updates" popup and tap on "Ok" button

    Then user touch on "Timesheets" feature icon
    Then user wait for 4 seconds
    Then user press "Start Shift"
    Then user wait for 4 seconds
    Then user press "Start Break"
    Then user wait for 4 seconds
    Then user press "End Break"
    Then user wait for 4 seconds
    Then user press "End Shift"

    And user should see the text "Summary"
    When user press "Summary"
    Then user should see the text "Today"
    And user press "Actions"
    Then user should see the text "Start Shift"

