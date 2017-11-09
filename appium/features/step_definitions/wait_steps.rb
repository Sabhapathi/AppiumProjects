
Then /^I wait for (\d+) seconds$/ do |sec|
#$driver.manage.timeouts.implicit_wait = "#{sec}"
#$driver.set_wait "#{sec}"
$wait = Selenium::WebDriver::Wait.new(:timeout => 60) 
$wait.until { $driver.manage.timeouts.implicit_wait = "#{sec}" }
end

Then /^I wait for "(.*?)" popup to appear$/ do |pop_box|
$wait = Selenium::WebDriver::Wait.new(:timeout => 120)
$wait.until { $driver.find_element(:name,"#{pop_box}") }
end