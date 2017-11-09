package com.xora.test

import com.xora.mc.pages.{LoginPage, SecuredPage}
import com.xora.test.SeleniumBaseTest
import com.xora.util.PropertyLoader
import org.testng.annotations.{BeforeSuite, BeforeTest}
import com.xora.pageObjects.DeviceLoginPage

/**
 * Created by Nandini.Sullekal on 5/2/2016.
 */
class SeleniumPostLoginTest extends SeleniumBaseTest {

protected var loginPage: LoginPage = _
protected var securedPage: SecuredPage = _
  protected var deviceLoginPage: DeviceLoginPage = _
  val phoneNumber = PropertyLoader.loadProperty("mobile.worker.phone.number")

@BeforeTest
def login() {

  println("Before Test")
loginPage = new LoginPage(webDriver, baseUrl).get
securedPage = loginPage.login(mcUserName, mcPassword, companyId)


}

  @BeforeTest
  def loginTodevice(): Unit ={
    deviceLoginPage = new DeviceLoginPage(androidDriver).get
    deviceLoginPage.login
  }

}
