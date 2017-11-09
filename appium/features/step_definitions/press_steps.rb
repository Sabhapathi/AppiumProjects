 Then /^I press "(.*?)"$/ do |action|
  $driver.find_element(:name,"#{action}").click
 end

 Then /^I press the menu item "(.*?)"$/ do |action|
   a=$driver.find_elements(:class,'android.widget.TextView')

   if action == "Jobs"
     return true if ( a.find_all{ |item| item.click if item.name =~ /\d*[ ]?Job[s]?/ }.count > 0)
   elsif action == "Messages"
     return true if ( a.find_all{ |item| item.click if item.name =~ /\d*[ ]?Message[s]?/ }.count > 0)
   elsif action == "Forms"
     return true if ( a.find_all{ |item| item.click if item.name =~ /\d*[ ]?Form[s]?/ }.count > 0)
   elsif action == "Locations"
     return true if ( a.find_all{ |item| item.click if item.name =~ /\d*[ ]?Location[s]?/ }.count > 0)
   elsif action == "Exit"
     return true if ( a.find_all{ |item| item.click if item.name =~ /\d*[ ]?Exit[s]?/ }.count > 0)
   else
     return true if ( $driver.find_element(:name,action).click )
   end
   return false
 end

 Then /^I press on "(.*?)" button$/ do |name|
   $driver.find_element(:name,"#{name}").click
 #button_click name
 end
 
Then /^I wait to tap on "(.*?)" button$/ do |arg4|
wait_for_action_to_finish
$wait.until { button_click arg4 }
end

 Then /^I press button with buttonid "(.*?)"$/ do |buttonid|
   et=$driver.find_element(:id,"#{buttonid}")
   et.click
 end

 Then /^I press button with button name "(.*?)"$/ do |buttonname|
   et=$driver.find_element(:name,"#{buttonname}")
   et.click
 end


Then /^I press Home button$/ do 
el=$driver.find_elements(:class,"android.widget.ImageButton")
el[0].click
end

Then /^I press Sync button$/ do
ele=$driver.find_elements(:class,"android.widget.ImageButton")
ele[0].click
ele[1].click
end

Then /^I press GPS button $/ do 
ell=$driver.find_elements(:class,"android.widget.ImageButton")
ele[0].click
ell[2].click
end

Then /^I click on action bar with "(.*?)" title$/ do |titlename|
   $driver.find_element(:id,"#{titlename}").click
 end

 Then /^I press text "(.*?)"/ do |text|
   $driver.find_element(:name,"#{text}").click
 end