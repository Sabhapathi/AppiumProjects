 Feature:Login
 Given My Appium is running
 
 @need_restart	
 Scenario:Mobile Activity
	Given I enter "9999900101" into activation field
	Then I press on "Activate" button
    Then I wait for 60 seconds
	Then I wait to tap on "I Agree" button
	Then I wait to tap on "Ok" button 
    #Then I wait for 240 seconds
    Then I wait for "New Updates" popup to appear
    Then I press "Ok"
	#Then I wait for 180 seconds 
    Then I press Home button
    Then I wait for 3 seconds
	Then I press "Timesheets"
	Then I press "Start Shift"
    Then I press "Start Break"
   #Then I press "Submit"
    Then I press "End Break"
   #Then I press "Submit"
    Then I press "End Shift"
	#Then I press "Submit"
     Then I press "No"
	Then I wait for 30 seconds
    Then I press Home button
	Then I wait for 3 seconds


  Scenario: QA on MC

    Given I have logged into Mission control with "sabha","sabha",3017634
	When I click buttonid "password_submit"
    #When I click link "Login"
	Then I should see "Logout"
	Then I should see "Refresh Now"
	Then I goto worker activity log for workerid 8645790
#	Then I verify the text on page "Login"
#	Then I verify the text on page "EULA Accepted"
	Then I verify the text on page "Timesheets: Start Shift"
#	Then I verify the text on page "Timesheets: Start Break"
#	Then I verify the text on page "Timesheets: End Break"
#	Then I verify the text on page "Timesheets: End Shift"
	Then I goto job list
	Then I should see "Refresh Now"
	Then I click id "jobCreate"
	When I click link "3 Action Jobs"
	Then I wait for 60 secs
#	Then I should see frame "xrCommonDialogIFrame"
	Then I switch to frame "xrCommonDialogIFrame"
#	Then I enter text "Automation" into "job_referenceNumber"
	Then I clear text from "job_name"
	Then I enter text "Automation" into "job_name"
	Then I click id "popupSidebarStep3"
	Then I choose the radio option id "jobAssignedToTypesingle" radio button
	Then I choose visible text "Android in India" from list "assignedWorkerId"
	Then I click id "submit"
	When I switch to default window
	Then I should see "Refresh Now"
	Then I should see "Logout"
	When I click link "Logout"
	Then I close browser


@need_restart
 Scenario:Resume on mobile
#  	Then I restart mobile session
    Then I wait for "New Updates" popup to appear
  	Then I press "Ok"
  	Then I wait for 3 seconds
	Then I press Home button
	Then I press "1 Job"
	Then I press "Automation"
    Then I press "Actions"
    Then I press "Start"
    Then I press "Hold"
    Then I press "End"
  	Then I press "Submit"
  	Then I press "Skip"
  	Then I wait for 30 seconds
  	Then I press Home button
