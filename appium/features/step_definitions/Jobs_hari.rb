 Then /^I press "(.*?)" $/ do |name|
   $driver.find_element(:name,"#{name}").click
 #button_click name
 end


Then /^I open "(.*?)" job$/ do |job_name|
$driver.find_element(:name,"#{job_name}").click
end

Then /^I enter job "(.*?)" into text_field1$/ do |txt5|
fd=$driver.find_element(:name,"Job Name")
fd.send_keys "#{txt5}"
end

Then /^I checked Autostart checkbox$/ do
chkbox=$driver.find_element(:class,"android.widget.CheckBox")
chkbox.click
end

Then /^I checked "(.*?)" checkbox should be checked$/ do |id|
  find_field(id)[:value].should eq "true" 
end



Then /^ I Checkbox "android.widget.CheckBox" should be checked$/ do |checkbox|
  page.has_checked_field?("#{checkbox}").should be_true
end


Then /^I Checkbox "(.*?)" job$/ do |job_name|
$driver.find_element(:name,"#{job_name}").click
end

Then /^I Create Jobs$/ do
 cjob=$driver.find_element(:text,"Create Job")
 sjob=$driver.find_element(:text,"Start Job")

 if Job=cjob
            macro 'I wait for 2 seconds'
            macro 'I should see "Create Job"'
            macro 'I press "<none selected>"'
            macro 'I wait for 2 seconds'
        	macro 'I see the text "3 Action Jobs"'
        	macro 'I wait for 2 seconds'
        	macro 'I press text "3 Action Jobs"'
        	macro 'I wait for 3 seconds'
        	macro 'I press "Next"'
        	macro 'I wait for 3 seconds'
       # 	macro I enter "DeviceJob1" into EditText field 1
        	macro 'I press "Create Job"'
        	macro 'I wait for 5 seconds'
        else
		macro 'I wait for 2 seconds'
		macro 'I enter text using adb "tt"'
		macro 'I wait for 2 seconds'
        macro 'I select textview by id "email"'
        macro 'I enter text using adb "hikm@xora.com"'
		macro 'I send key event using adb "62"'
		macro 'I wait for 2 seconds'
		macro 'I press "Send"'
        macro 'I wait for 4 seconds'
		macro 'I go back'
		macro 'I wait for 2 seconds'
		end
    end