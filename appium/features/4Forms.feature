  Feature: Xora
  
  
       		
Scenario: Forms:OpenForm
        Then I wait for 10 seconds
		Then I wait for "4 Forms"
		Then I press "4 Forms"
		Then I wait for 5 seconds 
		Then I open "AutomationForm" form   
         Then I wait for 2 seconds
Scenario: Forms:without filling fields
        Then I press "Submit"
		
        #Then I press "Skip"
		Then I wait for 5 seconds
		
Scenario: Forms: fill the form
        Then I open "AutomationForm" form 
        Then I wait for 5 seconds
		
Scenario: Forms: Form Text field
Then I enter "abcdef123" into text_field1 
Then I press "Next"

Scenario: Forms: Form Numeric field
Then I enter "12345" into text_field3
Then I press "Next"

Scenario: Forms: Form Numeric precision 1
Then I enter "00.1" into text_field4
Then I press "Next"

Scenario: Forms: Form Numeric precision 1
Then I enter "00.1" into text_field5
Then I press "Next"

Scenario: Forms: Form Numeric precision 2
Then I enter "0.12" into text_field6
Then I press "Next"

Scenario: Forms: Form Numeric precision 8
Then I enter "0.12345678" into text_field7
Then I press "Next"

Scenario: Forms: Form Numeric field
#Then I enter "12345" into text_field2
Then I press "Next"

#Scenario: Forms:Check box
#	     Then I toggle checkbox number 1
#		 Then I press "Next"

#Scenario: Forms:Form Select List     
#        Then I press "None"
	#	Then I press "a"
       # Then I press list item number 2
#Then I press "Next"

		 
#Scenario: Forms:Form Multi Select
#        Then I press "No option selected."
#	Then I press "Ok"
#Then I press "Next"	
	
#Scenario: Forms: Form Media field
#Then I press "Tap to capture one or more signatures"
#Then I swipe left
#Then I swipe right
#Then I press "Save"

Scenario: Forms:SubmitForm

        Then I press "Submit"
       	#Then I press "Skip"	 
		
	  Then I press Home button
      Then I wait for 3 seconds
      