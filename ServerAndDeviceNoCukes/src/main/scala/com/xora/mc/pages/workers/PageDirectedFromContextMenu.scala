package com.xora.mc.pages.workers

import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}

/**
 * Created with IntelliJ IDEA.
 * User: iyadav
 * Date: 7/1/14
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */
trait PageDirectedFromContextMenu {

  val TITLE_CLASS = "pageHeadlineText"
  val SEARCH_BOX_EXPAND_OR_COLLAPSE_IMAGE_ID = "search.contentWidgetImage"
  val COLLAPSE_IMAGE = "widget_Collapse.gif"
  val EXPAND_IMAGE = "widget_Expand.gif"
  val DATE_FILTER_ID = "inline-date-filter-container"
  val REFRESH_BUTTON_CLASS = "refreshNowButton"
  val DOWNLOAD_LIST_ID = "downloadList"

  protected var webDriver: WebDriver = null

  def getPageHeaderValue = {
    val pageHeaderEl = webDriver.findElement(By.className(TITLE_CLASS))
    val pageHeadline = pageHeaderEl.getText.trim
    pageHeadline
  }

  def validateRefreshButtonIsClickable(driver: WebDriver) = {
    var flag = false
    val refreshButton = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className(REFRESH_BUTTON_CLASS)))
    if(refreshButton.isDisplayed) {
      flag = true
    }
    flag
  }

  def validateDownloadExcelSymbolPresent(driver: WebDriver)= {
    var flag = false
    val excelDownloadIcon = driver.findElement(By.id(DOWNLOAD_LIST_ID))
    if(excelDownloadIcon.isDisplayed) {
      flag = true
    }
    flag
  }

  def presenceOfDateFilter(driver: WebDriver) = {
    val dateFilterEl = driver.findElement(By.id(DATE_FILTER_ID))
    val flag = dateFilterEl.isDisplayed
    flag
  }

  def validateExpandSearchBox(driver: WebDriver) = {
    var flag = false
    val toolBarEl = driver.findElement(By.id(SEARCH_BOX_EXPAND_OR_COLLAPSE_IMAGE_ID))
    if(toolBarEl.getAttribute("src").contains(EXPAND_IMAGE)){
      toolBarEl.click()
    }
    if(toolBarEl.getAttribute("src").contains(COLLAPSE_IMAGE)){
      flag = true
    }
    flag
  }

  def validateCollapseSearchBox(driver: WebDriver) = {
    var flag = false
    val toolBarEl = driver.findElement(By.id(SEARCH_BOX_EXPAND_OR_COLLAPSE_IMAGE_ID))
    if(toolBarEl.getAttribute("src").contains(COLLAPSE_IMAGE)){
      toolBarEl.click()
    }
    if(toolBarEl.getAttribute("src").contains(EXPAND_IMAGE)){
      flag = true
    }
    flag
  }




}
