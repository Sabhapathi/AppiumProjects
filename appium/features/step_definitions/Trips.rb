

Then /^I enter "(.*?)" into odometer$/ do |txt2|
fild=$driver.find_element(:name,"Enter Odometer")
fild.send_keys "#{txt2}"
end


Then /^I enter "(.*?)" into notes$/ do |txt1|
fd=$driver.find_element(:name,"Write a note")
fd.send_keys "#{txt1}"
end

Then /^I enter "(.*?)" into expenses$/ do |txt3|
fied=$driver.find_element(:name,"$0.00")
fied.send_keys "#{txt3}"
end

