
Then /^I enter string using adb "([^"]*)"$/ do |text|
  enter_text_via_adb("'#{text}'")
end


Then /^I enter text using adb "([^"]*)"$/ do |text|
  enter_eachchar_via_adb("'#{text}'")
end

Then /^I send key event using adb (.*)$/ do |keyevent|
 send_keyevent_via_adb(keyevent)
 # Some of the Key Event Codes are as follows
 # KEYCODE_SPACE - 62
 # KEYCODE_DEL -  67
 # KEYCODE_FORWARDDEL - 112
 # KEYCODE_SEMICOLON - 74
 # KEYCODE_COMMA - 55
 # KEYCODE_CLEAR - 28
 # KEYCODE_BACK - 4
end

Then /^I touch the view "([^"]*)"$/ do |viewname|
 	touch("#{viewname}")
end


Then /^I make "([^\"]*)" field Focused$/ do |label|
  sel = query("#{label} index:0", :isFocused)[0]
  	if sel==false
    touch("#{label} index:0")
	end
end

Then /^I select textview by id "([^\"]*)"$/ do |textviewid|
  touchtextviewbyid("#{textviewid}")
end

Then /^I set Airplanemode$/ do
	turn_airplanmode
end

Then /^I enable Locationservices$/ do
	turn_locationservices_on
end

Then /^I disable Locationservices$/ do
	turn_locationservices_off
end

Then /^I capture picture$/ do
	capture_pic
end


Then /^I save picture$/ do
	save_pic
end

Then /^I dismiss keypad$/ do
	goback
end


Then /^I install newapp "([^\"]*)"$/ do |pathofapkname|
	install_newapp("#{pathofapkname}")
	# Example of path of apk C:\\Users\\sabhap\\Desktop\\ffmbuilds\\FieldForceManager_1802.apk
end


Then(/^I restart mobile session$/) do
	start_app
end