 
def Screen_exists? arg1
 $driver.manage.timeouts.implicit_wait = 10
 el = $driver.find_element(:name, "Please confirm your phone number")
 el.send_keys "#{arg1}" 
end
 
def button_click name
$driver.find_element(:name,"#{name}").click
end

def change_url url
$driver.find_element(:name,"Bridge URL")
text_field=$driver.find_elements(:uiautomator, 'new UiSelector().className("android.widget.EditText")')
text_field[1].clear()
text_field[1].clear()
text_field[1].send_keys "#{url}"
end

def go_back
$driver.back
end 


def wait_for_action_to_finish
 $driver.manage.timeouts.implicit_wait = 20
end

def wait_for_action_to_complete time
 $driver.manage.timeouts.implicit_wait = "#{time}"
end

  