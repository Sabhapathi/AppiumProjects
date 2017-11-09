Then /^I wait for "(.*?)"$/ do |form_name|
$driver.find_element(:name,"#{form_name}")
end

Then /^I open "(.*?)" form$/ do |form_name|
$driver.find_element(:name,"#{form_name}").click
end




Then /^I enter (\d+) into text_field2$/ do |txt2|
fild=$driver.find_element(:name,"Money:")
fild.send_keys "#{txt2}"
end


Then /^I enter "(.*?)" into text_field1$/ do |txt1|
fd=$driver.find_element(:name,"Text:")
fd.send_keys "#{txt1}"
end

Then /^I enter "(.*?)" into text_field3$/ do |txt3|
fied=$driver.find_element(:name,"Number:")
fied.send_keys "#{txt3}"
end

Then /^I enter "(.*?)" into text_field4$/ do |txt4|
field=$driver.find_element(:name,"Odometer:")
field.send_keys "#{txt4}"
end

Then /^I enter "(.*?)" into text_field5$/ do |txt4|
field=$driver.find_element(:name,"numpre1:")
field.send_keys "#{txt4}"
end

Then /^I enter "(.*?)" into text_field6$/ do |txt4|
field=$driver.find_element(:name,"numpre2:")
field.send_keys "#{txt4}"
end

Then /^I enter "(.*?)" into text_field7$/ do |txt4|
field=$driver.find_element(:name,"numpre8:")
field.send_keys "#{txt4}"
end

Then /^I wait for Screen to launch$/ do 
$wait = Selenium::WebDriver::Wait.new(:timeout => 20)
$driver.find_element(:uiautomator, 'new UiSelector().className("android.widget.TextView").instance(0)')
end