package com.xora.test.admin

import java.io.File
import java.net.URL

import com.xora.mc.pages.LoginPage

//import com.xora.SetupApp
import com.xora.mc.pages.LoginPage
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.{By, WebElement, WebDriver}
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.{Test, BeforeTest}
//import com.tecnoguru.scuby._
//import JRuby._



/**
 * Created by Nandini.Sullekal on 3/4/2016.
 */
class firstAndroidTest{
  protected var webDriver = new FirefoxDriver()
//  val baseUrl = PropertyLoader.loadProperty("mc.url")
//  val  mcUserName = PropertyLoader.loadProperty("mc.username")
//  val  mcPassword = PropertyLoader.loadProperty("mc.password")
//  val companyId = PropertyLoader.loadProperty("company.id")


  @Test
  def androidTest(): Unit ={
   val loginPage = new LoginPage(webDriver,"https://stg-mc.xoraint.com/adapter").get
    val securedpage = loginPage.login("super","aaaaa","3028526")
    val homepage = securedpage.loadHomePage
    val path: String = System.getProperty("user.dir") + "\\src\\main\\ruby"
//    require(path)
//    evalIgnore("import Core")
//    val array = evalRuby("[]")


  }

}
