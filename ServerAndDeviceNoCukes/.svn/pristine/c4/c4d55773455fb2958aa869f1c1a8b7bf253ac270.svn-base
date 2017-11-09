Feature: Exit
Scenario: Exit the app
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


  Then user wait for "New Updates" popup and tap on "Ok" button
  Then user press "Exit"

  Then user should see the text "Are you sure you want to exit StreetSmart?"
  Then user clicks on "Yes" button
  Then user wait for 10 seconds



