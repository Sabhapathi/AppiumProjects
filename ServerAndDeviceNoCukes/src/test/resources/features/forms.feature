# Created by Murali.Kapu at 12/27/2016

Feature: FormSanity

#  Background: Login
  Scenario: FormSanity
    Given user is on mobile home page

    When user enter "999999999" into activation field
    Then user press on "Activate" button
    Then user should see the text "Set Bridge URL"
    Then user change the URL to "http://crt-bridge.xora.com/bridge/DeviceBridgeServlet"
    Then user press on "Update" button
    When user enter valid phone number "9999900112"
    Then user press on "Activate" button
    Then user should see the text "EULA"
    When user clicks on "I Agree" button
    Then user should see the text "Warning"
    And user clicks on "Ok" button
    Then user wait for 240 seconds
    Then user press "Ok"

#  Forms
    Then user wait for 4 seconds
    Then user touch on "Forms" feature icon
    Then user wait for 5 seconds
    Then user open "AutomateForm" form
    Then user wait for 2 seconds

#Forms:without filling fields
    Then user press "Submit"
    Then user press "Skip"
    Then user wait for 5 seconds

#Forms: fill the form
    Then user open "AutomationForm" form
    Then user wait for 5 seconds
    Then user enter "Happy to Automate" into Text field
    Then user enter "12345" into Number field
    Then user enter "1000" into Odometer field
    Then user enter "500.00" into Money field
    Then user check the checkbox
#Single Select
    Then user select an item "a" in the list
#Multi-Select & DATE&TIME
    Then user have selected multiple items in the list
    Then user press "Ok"
    Then user do increment or decrement the Time
    Then user do increment or decrement the Date
#    Pictures and Signatures
    Then user press "Tap to capture one or more pictures"
    Then user wait for 2 seconds
    Then user capture picture
    Then user wait for 2 seconds
    Then user press "Tap to capture one or more pictures"
    Then user select pictures
    Then user press "Tap to capture one or more signatures"
    Then user wait for 2 seconds
    Then user do signature
    Then user press "Save"

# Form submit
    Then user press "Submit"
#Form Email
    Then user enter an email address "abc@bc.com " to send submitted Action
    Then user press "Send"
    Then user wait for 3 seconds
#    Then user should see the text "A Copy of the Form will be emailed shortly"
#    Then user press Sync image_button
#    Then user wait for 30 seconds
    Then user press Home image_button
    Then user touch on "Settings" feature icon
    Then user wait for 2 seconds
    Then user press "Device Summary"
    Then wait until Media Queue Size become zero
    Then user press Home image_button
