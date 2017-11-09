package com.xora.mc.pages


import org.openqa.selenium.{NoSuchElementException, By, WebElement, WebDriver}
import org.openqa.selenium.support.ui.LoadableComponent
import org.testng.Assert._

/**
 * Created by Nandini.Sullekal on 5/2/2016.
 */
class LoginPage (driver: WebDriver, baseUrl: String) extends LoadableComponent[LoginPage]
{

  protected def load()
  {
    val url: String = baseUrl + "/guest/login.page"
    driver.get(url)
  }

  protected def isLoaded()
  {
    try
    {
      /* Add two second sleep time to avoid login fail
      webdriver is able to find password_submit element
      before complete loading of page.
       */
      Thread.sleep(2000)
      val div: WebElement = driver.findElement(By.id("password_submit"))
    }
    catch
      {
        case e: NoSuchElementException =>
        {
          fail("Failed to load log in page")
        }
      }
  }

  def login(username: String, password: String, companyId: CharSequence) =
  {
    val userNameElement = driver.findElement(By.id("username"))
    userNameElement.clear()
    userNameElement.sendKeys(username)
    val passwordElement = driver.findElement(By.id("password"))
    passwordElement.clear()
    passwordElement.sendKeys(password)
    val companyIdElement = driver.findElement(By.id("companyId"))
    companyIdElement.clear()
    companyIdElement.sendKeys(companyId)
    companyIdElement.submit()

    try {
      val buttonNext = driver.findElement(By.id("text_continue"))
      buttonNext.click()
    } catch {
      case e: NoSuchElementException =>
      {
//        logger.info("Next button is not available ")
      }
    }
    try {
      val buttonContinue = driver.findElement(By.id("button_continue"))
      buttonContinue.click()
    } catch {
      case e: NoSuchElementException =>
      {
//        logger.info("Continue button is not available ")
      }
    }


    new SecuredPage(driver, baseUrl)
  }


}
