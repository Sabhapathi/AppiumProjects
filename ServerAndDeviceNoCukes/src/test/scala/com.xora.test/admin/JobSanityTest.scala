package com.xora.test.admin

import com.xora.mc.util.LoadableElement
import com.xora.test.SeleniumPostLoginTest
import com.xora.util.GenerateName._
import com.xora.util.SleepTime._
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import cucumber.api.testng.TestNGCucumberRunner
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.testng.annotations.Test

/**
 * Created by Nandini.Sullekal on 1/3/2017.
 */

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features/jobSanity.feature"),
  glue = Array("com.xora.test.stepDefinition"),
  dryRun = false,
  plugin = Array("html:output"))
class JobSanityTest extends SeleniumPostLoginTest with LoadableElement with ShouldMatchers {

  @Test
  def createJobAndPerformJobActionSanityTest(): Unit = {

    var jobListPage = securedPage.loadJobListPage
    //Create Job1
    val jobCreatePopup = jobListPage.createNewJob("2 Action Jobs")
    val jobID1 = generateName("Job")
    jobCreatePopup.selectStepJobDetails.setJobDetails(jobID1, "Auto:JobDeviceSanity", "")

    jobCreatePopup.selectStepJobParameters.setSkills("All Skills")

    jobCreatePopup.selectStepJobLocation.setJobLocation("MN,510 South Walnut Street,,Bondville,IL,61815", "Xora,651-209-0421,a@b.com", "Yes", "", "", "", "", "", "")

    jobCreatePopup.selectStepJobScheduleAndAssign.setJobScheduleAndAssign("One Time Job", "", "", "UTC-06:00 Central Time (US&Canada)", "1,hours", "NA", "Medium", "Android", "Automate worker")

    val shareStep = jobCreatePopup.selectJobShareStep
    shareStep.expandEmailRecipients()
//    shareStep.setGroups(List("Default"))
//    sleepTime(minWaitTime * 1000)
//    shareStep.selectEmailIdOfUser(List("All Users"))
//    shareStep.selectAllowMobileWorkersToEmailCompletedJob("Yes")
//    shareStep.selectAutoEmailDelivery("Yes")
//    shareStep.enterAdditionalEmailIds(List("NA"))
//    shareStep.deleteAdditionalEmailId(List("NA"))

    shareStep.expandEmailTemplate()
    shareStep.setEmailSubject("Job Completion Email")
    shareStep.insertEmailTemplateAttributes("Job Name")
    shareStep.setMessageBody("The worker has completed the Job. And Please do not reply")
    shareStep.insertEmailTemplateAttributes("Job Name")

    jobListPage = jobCreatePopup.saveAndClose
    sleepTime(minWaitTime * 1000)
    jobListPage.refresh()
    jobListPage.searchJob(jobID1)

    jobListPage.getJobName_Type_Pattern(jobID1) should be(List("Auto:JobDeviceSanity", "2 Action Jobs", "One Time Job"))
    val deviceside = new TestNGCucumberRunner(this.getClass)
    deviceside.runCukes()

    jobListPage.searchJob(jobID1)
    sleepTimeInSecond(10)
    jobListPage.refresh()
    jobListPage.statusOfJob(jobID1) should be("Completed")
    val jobContextMenu = jobListPage.contextMenuOfJob(jobID1)
    val jobDetailsPage = jobContextMenu.JobDetails()
    jobDetailsPage.getJobActionNames should be (List("Start Job", "End Job"))
    jobDetailsPage.getJobSummary should be(List("Auto:JobDeviceSanity", jobID1, "2 Action Jobs", "One Time Job", "Medium", "All Skills", "Completed"))
    val jobLocationDetailsList = jobDetailsPage.getLocationDetails
    val contactDetailsList = List(jobLocationDetailsList.head, jobLocationDetailsList(1), jobLocationDetailsList(2))
    contactDetailsList should be(List("Xora","651-209-0421","a@b.com"))
    jobLocationDetailsList(3) should be("510 South Walnut Street Bondville, IL 61815")

    val workerListPage = securedPage.loadWorkerListPage
    val workerActivityLogpage = workerListPage.contextMenu("Automate worker").workerActivity()
   workerActivityLogpage.getFirstNActivities(4) should be(List("2 Action Jobs: Auto:JobDeviceSanity: End Job", "2 Action Jobs: Auto:JobDeviceSanity: Start Job", "2 Action Jobs: MJC Automation: End Job", "2 Action Jobs: MJC Automation: Start Job"))

  }

}
