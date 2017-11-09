
Feature: InvoicesSanity

#  Background: Login
  Scenario: InvoicesSanity
    Given user is on mobile home page

    When user enter "999999999" into activation field
    #Given I enter "999999999" to activate worker
    Then user press on "Activate" button
    Then user should see the text "Set Bridge URL"
    Then user change the URL to "http://crt-bridge.xora.com/bridge/DeviceBridgeServlet"
    Then user press on "Update" button
    When user enter valid phone number "9999900111"
    Then user press on "Activate" button
    Then user should see the text "EULA"
    When user clicks on "I Agree" button
    Then user should see the text "Warning"
    And user clicks on "Ok" button
    Then user wait for "New Updates" popup and tap on "Ok" button
    Then user press Sync image_button
    Then  user wait for 10 seconds

    #  Scenario:Invoices
    Then user touch on "Invoices" feature icon
    Then user wait for 4 seconds
    When user clicks on "Select a Job" button
    Then user press "Auto:InvoicesDeviceSanity"
    Then user clicks on "Add Item" button
    Then user wait for 2 seconds
    Then user select a category "Default" in the list
    Then user select a category item "PartName1" in the list
    Then user press on "Add" button
    Then user wait for 2 seconds
    Then user clicks on "Submit" button









