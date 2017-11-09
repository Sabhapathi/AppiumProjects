#require "rubygems" 
#require "watir"
#require "watir-webdriver"
#require "selenium-webdriver"
#require "rspec/expectations"




Given /^I have logged into Mission control with "([^"]*)","([^"]*)",(.*)$/ do |username,pwd,coid|
  #@browser ||= Watir::Browser.new
  #@browser.goto "http://streetsmart.xora.com"
  #@browser.text_field(:name => "username").set username
  #@browser.text_field(:name => "password").set pwd
  #@browser.text_field(:name => "companyId").set coid
	@browser = Selenium::WebDriver.for :firefox
	@browser.get "http://streetsmart.xora.com"
	field1=@browser.find_element :name => "username"
	field1.send_keys username
	field2=@browser.find_element :name => "password"
	field2.send_keys pwd
	field3=@browser.find_element :id => "companyId"
	field3.send_keys coid

end

Then /^I enter text "([^"]*)" into "([^"]*)"$/ do |text,fieldid|
  @browser.find_element(:id, fieldid).send_keys text
end
 
 When /^I clear text from "([^"]*)"$/ do |fieldid|
  @browser.find_element(:id, fieldid).clear
end
 
When /^I click buttonid "([^"]*)"$/ do |button_id|
  b=@browser.find_element :id => button_id
  b.click
end
 
When /^I click link "([^"]*)"$/ do |linktext|
    @browser.find_element(:link, linktext).click
 end 
 
 
 When /^I click id "([^"]*)"$/ do |idname|
  @browser.find_element(:id, idname).click
 end 
 
Then /^I should see "([^"]*)"$/ do |link_text| 
  wait = Selenium::WebDriver::Wait.new(:timeout => 10)
  wait.until { @browser.find_element(:link => link_text) }
end

Then /^I should see frame "([^"]*)"$/ do |frameid| 
  wait = Selenium::WebDriver::Wait.new(:timeout => 10)
  wait.until { @browser.switch_to.frame @browser.find_element(:id, frameid) }
end

Then /^I wait for (.*) secs$/ do |number| 
Selenium::WebDriver::Wait.new(:timeout => number)
end

Then /^I goto worker activity log for workerid (.*)$/ do |workerid|
@browser.get "https://streetsmart.xora.com/adapter/worker/detail/log.page?workerId=8645790"
end

Then /^I goto job list$/ do
@browser.get "https://streetsmart.xora.com/adapter/jobs/list/doList.page"
end


Then /^I verify the text on page "([^"]*)"$/ do |texttoverify|
@browser.find_element(:tag_name => "body").text.include?(texttoverify)
end

Then(/^I close browser$/) do
@browser.close
end


Then /^I switch to frame "([^"]*)"$/ do |frameid|
@browser.switch_to.frame @browser.find_element(:id, frameid)
end


Then /^I choose the radio option id "([^"]*)" radio button$/ do |optionid|
radiobutton = @browser.find_element(:id, optionid)
radiobutton.click
end

Then(/^I switch to default window$/) do
@browser.switch_to.default_content
end

Then /^I choose visible text "([^"]*)" from list "([^"]*)"$/ do |visibletext,listname|
dropDown = @browser.find_element(:name, listname)
option = Selenium::WebDriver::Support::Select.new(dropDown)
option.select_by(:text, visibletext)
end