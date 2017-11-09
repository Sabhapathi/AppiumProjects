def start_app
  def capabilities
      {
          "platformName" => "Android",
          "browserName" => "",
          "platformVersion" => "4.2.2",
	  "deviceName" => "",
	  "app" => "#{Dir.pwd}/TimeTrack_ATT.apk",
          "appPackage" => "com.xora.att",
          "appActivity" => "com.xora.device.NativeActivity"
      }
    end
    
    http_client = Selenium::WebDriver::Remote::Http::Default.new
    http_client.timeout = 80
   
    
    Selenium::WebDriver.for(
        :remote,
        :desired_capabilities => capabilities,
        :url => 'http://127.0.0.1:4723/wd/hub',
        :http_client => http_client
    )
end