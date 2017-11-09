package com.xora.util

import java.io.File
import javax.imageio.ImageIO

import com.xora.util.GenerateName._
import org.apache.commons.io.FileUtils.copyFile
import org.openqa.selenium.remote.Augmenter
import org.openqa.selenium.{OutputType, TakesScreenshot, WebDriver, WebElement}


/**
 * Created with IntelliJ IDEA.
 * User: nandinis
 * Date: 7/14/14
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
 trait ScreenShotOfElement {
  val imageName = generateName("")+".png"

def getScreenShotOfWebElement(driver: WebDriver, element: WebElement) = {
  val filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\webElementScreenShots\\" + imageName
  val page: WebDriver = new Augmenter().augment(driver)
    if(page != null){
      val image: File = page.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
      val pageImage = ImageIO.read(image)
      val imagePos = element.getLocation
      val imageWidth = element.getSize.getWidth
      val imageHeight = element.getSize.getHeight
      val imageElScreenShot = pageImage.getSubimage(imagePos.getX,imagePos.getY,imageWidth,imageHeight)
      ImageIO.write(imageElScreenShot,"png",image)
      copyFile(image,new File(filePath))
    }
  filePath
  }
}

