Given /^My Appium is running$/ do
#  rotate_phone(0)
end

Given /^my Appium is running$/ do
#  rotate_phone(0)
end


Then /^I see the text "(.*?)"/ do |text|
$wait = Selenium::WebDriver::Wait.new(:timeout => 60) 
$wait.until { $driver.find_element(:name,"#{text}") }
end


Then /^I select item by text "(.*?)"/ do |text|
  $driver.find_element(:name,"#{text}").click
end



Then /^I swipe right$/ do
$driver.execute_script 'mobile: swipe', startX: 100, startY: 0.5, endX: 0.5, endY: 0.5, duration: 0.5
end


Then /^I swipe left$/ do
  $driver.execute_script 'mobile: swipe', startX: 0.5, startY: 0.5, endX: 100, endY: 0.5, duration: 0.5
end