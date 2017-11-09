package com.xora.mc.pages.wizards

import org.openqa.selenium.{By, WebDriver}


/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 8/1/13
 * Time: 10:42 AM
 * To change this template use File | Settings | File Templates.
 */
abstract class AbstractStep(driver: WebDriver)
{
  def getStepDescriptionForCreateEditPopup = {
    val stepDescription = driver.findElement(By.xpath("//div[@class = 'selected_subtab_color']//div[@class ='body_text']")).getText
    stepDescription
  }
}
