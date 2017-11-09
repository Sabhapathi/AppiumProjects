 Then /^I toggle checkbox number$/ do
 #chk=$driver.find_elements(:class,"android.widget.CheckBox")
 #chk[0].click
   $driver.find_element(:class,"android.widget.CheckBox").click
 end


 Then /^I check Start Break checkbox number$/ do
   chk=$driver.find_elements(:class,"android.widget.CheckBox")
   chk[2].click

 end


 Then /^I uncheck the check-box$/ do
   if $driver.find_element(:class,"android.widget.CheckBox").attribute("checked")==true
     $driver.find_element(:class,"android.widget.CheckBox").click
   end

 end