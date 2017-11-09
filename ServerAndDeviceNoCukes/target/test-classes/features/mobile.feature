Feature: Login
  As a user I should be able to perform mobile actions and Web Browser actions also.

  Scenario: Mobile App Login
    #####  ON Mobile   ########################
    Given user is on mobile home page

    When user enter "999999999" into activation field
#Given I enter "999999999" to activate worker
    Then user press on "Activate" button
    Then user should see the text "Set Bridge URL"
    Then user change the URL to "http://stg-bridge.xora.com/bridge/DeviceBridgeServlet"
    Then user press on "Update" button
    When user enter valid phone number "9999900111"
    Then user press on "Activate" button
    Then user should see the text "EULA"

    When user clicks on "I Agree" button
    Then user should see the text "Warning"
    And user clicks on "Ok" button

    ### Back on Mobile Again ################################

#  Scenario: Mobile App Login1
#   #####  ON Mobile   ########################
#    Given user is on mobile home page
#    When user enter valid phone number "9999900101"
#    Then he should see the text "EULA"
#
#   ### Back on Mobile Again ################################
#    When user clicks on "I Agree" button
#    Then he should see the text "Warning"
#    And user clicks on "Ok" button
# On Browser ####################################
#    Given the user is on web login page
#    When user provides his credentials as follows:
#      |Username|Password|Company_id|
#      |sabha   |sabha|3017634|
#    And user clicks on Login
#    Then user should be logged in
#    Then user on workerlist page
#
#    Given user on joblist page
#    When he clicks on id "jobCreate"
#    And he clicks on linktext "3 Action Jobs"
#
#    Given he switches to frame "xrCommonDialogIFrame"
#    When he clears field "job_name"
#    And he enter "Automation" into field "job_name"
#    And he clicks on id "popupSidebarStep3"
#    And he chooses radio option "jobAssignedToTypesingle"
#    And he chooses visible text "Android in India" from list "assignedWorkerId"
#    Then he clicks on id "submit"
#
#    Given he switches to default view
#    Then user chooses to Logout

    #### On Browser Again ####################
    #Given Browser session is started
#    And the user is on web login page
#    When user provides his credentials as follows:
#      |Username|Password|Company_id|
#      |sabha   |sabha|3017634|
#    And user clicks on Login
#    Then user should be logged in
#    Then user on workerlist page
#
#    And I quite the browser