package com.xora.mc.pages.messages

import com.xora.util.PropertyLoader
import org.openqa.selenium.{By, WebDriver}

import scala.collection.JavaConverters._

/**
 * Created with IntelliJ IDEA.
 * User: Nandini.Sullekal
 * Date: 5/18/15
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */
class ReadMessagePage(driver: WebDriver, parentPage: InboxPage) extends AbstractMessageListPage{
  val mcBaseUrl = PropertyLoader.loadProperty("mc.url")
  webDriver  = this.driver
  def getMessageDetails = {
     val messageEls = driver.findElements(By.xpath("//table[@class = 'detailsContainer']//tr")).asScala
     val messageDetails = messageEls.map(_.getText.replace("\n","")).toList
    messageDetails
  }

  def getMessageBody = {
      val messageBody = driver.findElement(By.xpath("//table[@class = 'detailsContainer']/following-sibling::div"))
    val body = messageBody.getText
    body
  }

  def navigateToMessageListPage = {
      val messageListPage = driver.findElement(By.linkText("Message List"))
    messageListPage.click()
    new InboxPage(driver,mcBaseUrl)
  }

  def getMessageLabels = {
    val h3Els = driver.findElements(By.xpath("//table[@class = 'detailsContainer']//h3")).asScala
    val values = h3Els.map(_.getText.trim).toList
    values
  }
}
