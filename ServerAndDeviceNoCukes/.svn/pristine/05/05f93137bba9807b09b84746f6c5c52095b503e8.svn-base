package com.xora.mc.pages.jobs

import com.xora.mc.pages.jobs.{AbstractViewJobDetailPage}
import com.xora.mc.pages.jobs.wizards.{EditWizardPopup, CreateWizardPopup}
import com.xora.util.SleepTime._
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import com.xora.mc.pages.jobs.ViewJobDetailPage._

/**
 * Created by Nandini.Sullekal on 1/4/2017.
 */
class ViewJobDetailPage (driver: WebDriver, parentPage: JobListPage)
  extends AbstractViewJobDetailPage [JobListPage](driver,parentPage){
  def createNewJob(jobType: String) = {

    val createJobButton = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.id(CREATE_JOB_BUTTON_ID)))
    createJobButton.click()
    sleepTime(minWaitTime * 1000)
    val jobTypeMenu = createJobButton.findElement(By.id(JOBTYPE_MENU_ID))
    val jobTypeEl = jobTypeMenu.findElement(By.linkText(jobType.trim))
    jobTypeEl.click()
    new CreateWizardPopup(driver, parentPage)
  }


  def clickEditJobActionsInToolBar = {
    val editJobActionButtonEl = driver.findElement(By.id(EJA_BUTTON_ID))
    editJobActionButtonEl.click()
    sleepTimeInSecond(minWaitTime)
//    new EditJobActionsPage(driver,parentPage)
  }

  def clickOnEditJobInformationInToolBar = {
    val editJobInformationButtonEl = driver.findElement(By.id(EDIT_JOB_INFORMATION_BUTTON_ID))
    editJobInformationButtonEl.click()
    sleepTimeInSecond(minWaitTime)
    new EditWizardPopup(driver, parentPage)
  }

  def clickOnReassignJobFromToolBarOption = {
    val reassignButtonEl = driver.findElement(By.id(TOOL_BAR_REASSIGN_BUTTON_ID))
    reassignButtonEl.click()
//    new AssignJobPopup(driver, parentPage)
  }


}

object ViewJobDetailPage {
  val CREATE_JOB_BUTTON_ID = "jobCreate_menu"
  val JOBTYPE_MENU_ID = "menuBody"
  val EJA_BUTTON_ID = "editjobactions"
  val EDIT_JOB_INFORMATION_BUTTON_ID = "jobEdit"
  val TOOL_BAR_REASSIGN_BUTTON_ID = "jobReassign"
}

