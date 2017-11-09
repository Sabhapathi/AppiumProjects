Feature: JobSanity
  Scenario: Jobs: Sanity Test

    Given user is on mobile home page

#    When user clicks on "Allow" button
#    And user clicks on "Allow" button
#    And user clicks on "Allow" button
#    And user clicks on "Allow" button
#    Then user clicks on "Allow" button

#    When user enter "999999999" into activation field
#    Then user press on "Activate" button
#    Then user should see the text "Set Bridge URL"
#    Then user change the URL to "http://crt-bridge.xora.com/bridge/DeviceBridgeServlet"
#    Then user press on "Update" button
    When user enter valid phone number "9999900122"
    Then user press on "Activate" button
    Then user should see the text "EULA"
    When user clicks on "I Agree" button
    Then user should see the text "Warning"
    And user clicks on "Ok" button
    Then user wait for "New Updates" popup and tap on "Ok" button
    Then user press Sync image_button
    Then  user wait for 10 seconds
## JOBS
    Then user touch on "Job" feature icon
### Mobile Job Create
    Then user press AddJob button
    Then user check the checkbox
    Then user select an item "2 Action Jobs" in the list
    Then user should see the text "Start Job"
    Then user check the checkbox
    Then user should see the text "Create Job"
    Then user check the checkbox
    Then user press on "Next" button
    Then user press on "Next" button
    Then user enter text "MJC Automation" on Job Name field
    Then user press on "Next" button
    Then user enter text "MJC Automation Job ID" on Job ID field
    Then user press on "Start Job" button
    Then user should see the text "0H:0M"
    Then user press on "End Job" button

### Do Job from MC
    Then user wait for 2 seconds
    Then user press "Auto:JobDeviceSanity"
    Then user press "Actions"
    Then  user wait for 5 seconds
    Then user press "Start Job"
    Then user press Sync image_button
    Then  user wait for 20 seconds
    Then user press "End Job"
    Then user press Sync image_button
    Then user wait for 30 seconds
    Then user press Home image_button
    Then user touch on "Settings" feature icon
    Then user press "Device Summary"
    Then wait until HTTP Queue Size become zero
    Then user press Home image_button

