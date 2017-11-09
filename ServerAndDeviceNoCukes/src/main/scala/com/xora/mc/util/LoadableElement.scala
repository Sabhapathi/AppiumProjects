package com.xora.mc.util

import org.openqa.selenium.{By, SearchContext}
import org.testng.Assert._

/**
 * Created by Nandini.Sullekal on 5/2/2016.
 */
trait LoadableElement {

  /**
   * Returns true if the element is loaded
   * @param context context to search for the element
   * @param by
   * @return
   */
  def isElementLoaded(context: SearchContext, by: By): Boolean = {
    try
    {
      val element = context.findElement(by)
      return true
    }
    catch
      {
        case e: org.openqa.selenium.NoSuchElementException =>
        {
          return false
        }
      }
  }

  /**
   * Throws an error if the given element is not loaded
   * @param context
   * @param by
   */
  def verifyElementLoaded(context: SearchContext, by: By) {
    try
    {
      val element = context.findElement(by)
    }
    catch
      {
        case e: org.openqa.selenium.NoSuchElementException =>
        {
          fail("Failed to load element by " + by)
        }
      }
  }

}
