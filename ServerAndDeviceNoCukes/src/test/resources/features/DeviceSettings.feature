Feature: Settings Page
  Scenario: Mobile App Login


      #####  ON Mobile   ########################
    Given user is on mobileapp login page
    When user enter valid phone number "999999999"
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
    And user clicks on "Ok" button

    When user press "Settings"
    Then user should see Settings options
    Then user press "Device Summary"
    Then user should see Device Summary options
    And  click Back Button to go back to previous screen
    Then user press "Send Current Location"
    Then user should see the text "Send current location?"
    Then user clicks on "Yes" button
    Then user press Sync image_button
    Then user wait for 10 seconds
    Then user press "Send Log to Server"
    Then user should see the text "Send Log to Server ?"
    And user clicks on "No" button
    When user press "Notifications"
    Then user should see the text "Notifications"
    And user selects TimePicker for "Start Shift"
    And change interval time
    And user clicks on "OK" button
   # When user enable "Start Break" checkbox
   # Then "Start Break" layout expands and should show HH:MM button
    And  click Back Button to go back to previous screen
    When user clicks on "Advanced Options" button
    Then user should see the text "Enter Code"
    When user enter valid pin number "4321"
    When user clicks on "Submit" button

  ### **********************Advances Settings***********************
    Then user should see AdvancedSettings options
    When user press "Log Options"
    Then user should see Log options
    When user clicks on "Done" button
    And user press "Clear Log"
    When user press "Debug"
    And  click Back Button to go back to previous screen
    When user press "Force Login"
    Then user should see the text "You will be required to enter a PIN the next time you login."
    When user clicks on "No" button
    When user press "Clear Record Store"
    Then user should see the text "Are you sure you want to clear the record store?"
    When user clicks on "No" button
    When user press "Clear Activation"
    Then user should see the text "Confirm Deactivation"
    When user clicks on "Yes" button