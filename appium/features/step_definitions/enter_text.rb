
Given /^I enter "(.*?)" into activation field$/ do |arg1|
 Screen_exists? arg1
end

Then /^change the URL to "(.*?)"$/ do |url|
change_url url
end

Then /^I enter "(.*?)" into EditText with name "(.*?)"$/ do |text,edittextname|
  $driver.find_element(:name,edittextname).send_keys "#{text}"
end

Then /^I enter "(.*?)" into EditText with ID "(.*?)"$/ do |text,textid|
  et=$driver.find_element(:id, textid).send_keys "#{text}"
end


Then /^I enter "(.*?)" into EditText field 1$/ do |text|
  et=$driver.find_elements(:class, "android.widget.EditText")
  et[0].click
  et[0].send_keys "#{text}"
end


Then /^I enter "(.*?)" into EditText field 2$/ do |text|
  et=$driver.find_elements(:class, "android.widget.EditText")
  et[1].click
  et[1].send_keys "#{text}"
end

Then /^I enter "(.*?)" into EditText field 3$/ do |text|
  et=$driver.find_elements(:class, "android.widget.EditText")
  et[2].click
  et[2].send_keys "#{text}"
end

Then /^I enter "(.*?)" into Enter Code$/ do |pwd|
$driver.find_element(:name,"Enter Code").send_keys "#{pwd}"
end

Given /^I enter "(.*?)" to activate worker$/ do |arg2|
el=$driver.find_element(:name, "Please confirm your phone number") 
9.times do el.clear() end
el.send_keys "#{arg2}"
end
