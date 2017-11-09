package com.xora.mc.pages.jobs.wizards

import com.xora.mc.pages.jobs.JobListPage
import com.xora.mc.pages.jobs.steps._
import com.xora.mc.pages.wizards.AbstractWizardPopup
import com.xora.mc.util.XpathUtils._
import org.openqa.selenium.{By, WebDriver}
import com.xora.mc.pages.jobs.wizards.CreateWizardPopup._

import scala.collection.JavaConverters._


/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 8/5/13
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
class CreateWizardPopup(driver: WebDriver, parent: JobListPage)
  extends AbstractWizardPopup[JobListPage](driver, parent)
{
  def selectStepJobDetails: JobDetailStep =
  {
    clickStep(JobDetailStep.LABEL_TEXT)
    new JobDetailStep(driver)
  }

  def selectStepJobParameters: JobParameterStep =
  {
    clickStep(JobParameterStep.LABEL_TEXT)
    new JobParameterStep(driver)
  }

  def selectStepJobLocation: JobLocationStep =
  {
    clickStep(JobLocationStep.LABEL_TEXT)
    new JobLocationStep(driver)
  }

  def selectStepJobScheduleAndAssign: JobScheduleAndAssignStep =
  {
    clickStep(JobScheduleAndAssignStep.LABEL_TEXT)
    new JobScheduleAndAssignStep(driver)
  }

  def selectJobShareStep = {
    clickStep(JobShareStep.LABEL_TEXT)
    new JobShareStep(driver)
  }

  def getPopupHeader = {
    val headerEl = driver.findElement(By.id("popupTitle"))
    headerEl.getText
  }

  def getEmailsPopUpHeader = {
    val duplicateEmailsDialogEl = driver.findElement(By.xpath("//div[" + hasCssClass(DUPLICATE_EMAILS_DIALOG_CLASS) + "]"))
    val headerText = duplicateEmailsDialogEl.findElement(By.tagName("h2")).getText
    headerText
  }

  def getEmailsPopupContent = {
    val duplicateEmailsDialogEl = driver.findElement(By.xpath("//div[" + hasCssClass(DUPLICATE_EMAILS_DIALOG_CLASS) + "]"))
    val emailId = duplicateEmailsDialogEl.findElement(By.className(DIALOG_BODY_CLASS_NAME)).getText
    emailId
  }

  def clickOkOnDialog()  {
    val duplicateEmailsDialogEl = driver.findElement(By.xpath("//div[" + hasCssClass(DUPLICATE_EMAILS_DIALOG_CLASS) + "]"))
    val okEl = duplicateEmailsDialogEl.findElement(By.className(OK_BUTTON_CLASS))
    okEl.click()

  }
  def maxEmailRecipientsDialog = {
    val dialogBoxEl = driver.findElement(By.xpath("//div[" + hasCssClass("dialog-alert") +"]"))
    val dialogText = dialogBoxEl.getText
    dialogBoxEl.findElement(By.className("linkButton")).click()
    dialogText
  }

  protected def selectInitialStep()
  {
    selectStepJobDetails
  }

  def getTabNames = {
    val tabsEls = driver.findElements(By.xpath("//ul[@id = '"+TABS_UL_ID+"']//li")).asScala
    val tabsList = tabsEls.map(_.getText.replace("\n","").trim).toList
    tabsList
  }
}

object CreateWizardPopup{
  val DUPLICATE_EMAILS_DIALOG_CLASS = "dialog dialog-alert"
  val DIALOG_BODY_CLASS_NAME = "body"
  val OK_BUTTON_CLASS = "buttonPanel"
  val TABS_UL_ID = "steps"
}
