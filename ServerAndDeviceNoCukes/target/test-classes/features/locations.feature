Feature: LocationsSanity

  Scenario: Locations SANITY
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
    Then user wait for "New Updates" popup and tap on "Ok" button
    Then  user wait for 10 seconds

    #Location List
    Then user touch on "Location" feature icon
    Then user wait for 2 seconds
#    Then user should see the text "Locations"
#    Then user should see the text "Location from MC"
    Then user press "Location from MC"

  #Delete Location
    Then user press "Delete"
    Then user press "No"
    Then user should see the text "Location from MC"
    Then user press "Navigation"
    Then user should see the text "Search here"
    And click Back Button to go back to previous screen
    Then user press "Delete"
    Then user press "Yes"
    Then user wait for 2 seconds
    Then user press Home image_button
    Then user wait for 2 seconds

