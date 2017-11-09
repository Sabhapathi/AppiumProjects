package com.xora.mc.pages.jobs.wizards

import com.xora.mc.pages.jobs.JobListPage
import com.xora.mc.pages.jobs.steps._
import com.xora.mc.pages.wizards.AbstractWizardPopup
import org.openqa.selenium.WebDriver


/**
 * Created with IntelliJ IDEA.
 * User: Nandini
 * Date: 2/12/14
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
class EditWizardPopup(driver: WebDriver, parent: JobListPage)
  extends AbstractWizardPopup[JobListPage](driver, parent) {
  def selectStepJobDetails: EditJobDetailStep =
  {
    clickStep(JobDetailStep.LABEL_TEXT)
    new EditJobDetailStep(driver)
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

  def selectStepJobScheduleAndAssign: EditJobScheduledAndAssignStep =
  {
    clickStep(JobScheduleAndAssignStep.LABEL_TEXT)
    new EditJobScheduledAndAssignStep (driver)
  }

  def selectJobShareStep = {
    clickStep(JobShareStep.LABEL_TEXT)
    new JobShareStep(driver)
  }

  protected def selectInitialStep()
  {
    selectStepJobDetails
  }
}
