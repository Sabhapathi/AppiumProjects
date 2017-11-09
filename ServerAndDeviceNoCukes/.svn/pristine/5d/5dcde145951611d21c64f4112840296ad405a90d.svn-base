package com.xora.mc.pages

import com.xora.mc.pages.ListPageContextMenuPopup._
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.support.ui.{ExpectedConditions, LoadableComponent, WebDriverWait}
import com.xora.mc.util.XpathUtils._
import com.xora.util.SleepTime._


object ListPageContextMenuPopup
{
  val POPUP_ID = "popupDiv"
  val ACTION_LIST_CLASS = "actionList"
  val ACTION_LIST_ELEMENT_CLASS = "actionList"
  val CLOSE_BUTTON_CLASS = "puClose"
  val POPUP_BASE_XPATH = "//div[@id='" + POPUP_ID + "']"
  val CLOSE_BUTTON_XPATH = POPUP_BASE_XPATH + "//*[" + hasCssClass(CLOSE_BUTTON_CLASS) + "]"
}

abstract class ListPageContextMenuPopup[T <: LoadableComponent[T]](driver: WebDriver, parentPage: T)
{

  def cancel: T =
  {
    val closeButton: WebElement = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(CLOSE_BUTTON_XPATH)))
    closeButton.click()
    new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(CLOSE_BUTTON_XPATH)))
    parentPage
  }

  protected def selectOption(optionDisplayValue: String)
  {
    driver.findElement(By.xpath(POPUP_BASE_XPATH + "//ul[" + hasCssClass(ACTION_LIST_CLASS) + "]//li[" + hasCssClass(ACTION_LIST_ELEMENT_CLASS) + "]//a[contains(text(),'" + optionDisplayValue + "')]")).click()
    sleepTime(minWaitTime*2000)
  }

}

