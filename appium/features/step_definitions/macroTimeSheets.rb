Then /^I perform Timesheet actions (\d+) times$/ do |num|

    step 'I press "Timesheets"'
  maxnum=num.to_i
  maxnum.times do
    step 'I press "Start Shift"'
    step 'I press "Start Break"'
    step 'I press "End Break"'
    step 'I press "End Shift"'
    step 'I press "No"'

  end

end

