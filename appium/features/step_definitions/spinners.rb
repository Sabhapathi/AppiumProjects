Then /^I select purpose by spinner index "(.*?)"$/ do |indx|
 spin_arr=$driver.find_elements(:class,"android.widget.Spinner")
spin_arr["#{index}"].click
 end
 
Then /^I select category by spinner index "(.*?)"$/ do |index|
cat_arr = $driver.find_elements(:class,"android.widget.Spinner")
 cat_arr["#{index}"].click
 end




Then /^I select spinner by index (.*)$/ do |index|
  cat_arr = $driver.find_elements(:class,"android.widget.Spinner")
  cat_arr['#{index}'].click
end


Then /^I select spinner by spinnerid "(.*?)"$/ do |spinnerid|
  $driver.find_element(:id,"#{spinnerid}").click
end