 
 ###### SYNC and GPS Icons####### 
 Then /^I perform Sync$/ do 
ele=$driver.find_elements(:class,"android.widget.ImageButton")
ele[1].click
end

Then /^I press GPS button$/ do 
ele=$driver.find_elements(:class,"android.widget.ImageButton")
ele[2].click
end

Then /^I go back$/ do
#$driver.press_keycode=4
#send_keyevent_via_adb(4)
end

Then /^I select all the text$/ do
id=$driver.find_elements(:class,"android.widget.Button")
id[0].click
end

Then /^I perform long press on the field$/ do 
long_tap 
end


##### To Touch Feature Icon irrespective of Count of items ########
Then /^I touch "([^\"]*)" feature icon$/ do |arg|
  touchFeatureIcon(arg)
end

 ########Multi-Select Code in two formats########

				#Format1#
Then /^I have selected multiple items in the list$/ do
multi=$driver.find_element(:name,"No option selected.")
multi.click
$driver.manage.timeouts.implicit_wait = 1
$driver.find_element(:name,"manual").click
$driver.find_element(:name,"automation").click
$driver.find_element(:name,"automation1").click
$driver.manage.timeouts.implicit_wait = 1
end

Then /^I have selected multiple options under "([^\"]*)"$/ do |name|
multi=$driver.find_element(:name,"#{name}")
multi.click
$driver.manage.timeouts.implicit_wait = 1
$driver.find_element(:name,"TRACE").click
$driver.find_element(:name,"INFO").click
2.times do $driver.find_element(:name,"WARN").click end
$driver.manage.timeouts.implicit_wait = 1
end

				#Format2#
Then /^I have selected multiple items "([^\"]*)","([^\"]*)","([^\"]*)" in the list$/ do |ele1,ele2,ele3|
multi=$driver.find_element(:name,"No option selected.")
multi.click
$driver.manage.timeouts.implicit_wait = 1
$driver.find_element(:name,"#{ele1}").click
$driver.find_element(:name,"#{ele2}").click
$driver.find_element(:name,"#{ele3}").click
$driver.manage.timeouts.implicit_wait = 1
end

#############Single-Select list Code############
Then /^I select an item "([^\"]*)" in the list$/ do |item2|
single=$driver.find_element(:class,"android.widget.Spinner")
single.click
$driver.manage.timeouts.implicit_wait = 2
a=$driver.find_element(:name,"#{item2}")
a.click
end

#########################
###Cascading list code###
#########################

Then /^I select an item "([^\"]*)" in the first dropdown cascading list$/ do |ele1|
multi=$driver.find_elements(:class,"android.widget.Spinner")
multi[1].click
$driver.manage.timeouts.implicit_wait = 1
$driver.find_element(:name,"#{ele1}").click
end

Then /^I select an item "([^\"]*)" in the second dropdown list$/ do |ele2|
multi=$driver.find_elements(:class,"android.widget.Spinner")
#$driver.manage.timeouts.implicit_wait = 1
multi[2].click
$driver.manage.timeouts.implicit_wait = 1
$driver.find_element(:name,"#{ele2}").click
#$driver.manage.timeouts.implicit_wait = 1
end

Then /^I select an item "([^\"]*)" in the next to second cascading list$/ do |ele3|
multi=$driver.find_elements(:class,"android.widget.Spinner")
multi[3].click
#$driver.manage.timeouts.implicit_wait = 1
$driver.find_element(:name,"#{ele3}").click
end




############ Category n Purpose Spinners on Trips #######

Then /^I select "(.*?)" purpose from Purpose list$/ do |pur_name|
 pur_arr=$driver.find_elements(:class,"android.widget.Spinner")
 pur_arr[1].click
 $driver.manage.timeouts.implicit_wait = 1
 $driver.find_element(:name,"#{pur_name}").click
 end
 
Then /^I select "(.*?)" category from Category list$/ do |cat_name|
cat_arr = $driver.find_elements(:class,"android.widget.Spinner")
 cat_arr[0].click
 $driver.manage.timeouts.implicit_wait = 1
 $driver.find_element(:name,"#{cat_name}").click
 end

####### Check or Un-check box###########
Then /^I check the check-box$/ do 
$driver.find_element(:class,"android.widget.CheckBox").click
end







Then /^I increment r decrement the Time$/ do
$driver.find_element(:id,"android:id/increment").click 
$driver.find_element(:id,"android:id/decrement").click   
$driver.find_element(:id,"android:id/amPm").click      
$driver.find_element(:id,"android:id/button1").click
end


#####Select JobType#######

Then /^I select a JobType "(.*?)" in the list$/ do |arg1|
JTP=$driver.find_element(:class,"android.widget.Spinner")
JTP.click
$driver.manage.timeouts.implicit_wait = 2
a=$driver.find_element(:name,"#{arg1}")
a.click
end

####### To Send Email######

Then /^I enter email address "([^\"]*)" to send submitted Action$/ do |email|
#$wait=Selenium::WebDriver::Wait.new(:timeout => 120)
mail=$driver.find_element(:class,"android.widget.MultiAutoCompleteTextView")
mail.send_keys "#{email}"
#$wait.until { mail.send_keys "#{email}" }
end