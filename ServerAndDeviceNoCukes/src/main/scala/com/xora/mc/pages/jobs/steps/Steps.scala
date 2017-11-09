package com.xora.mc.pages.jobs.steps

import com.xora.mc.pages.wizards.AbstractStep
import com.xora.mc.util.XpathUtils._
import com.xora.util.SleepTime._
import org.openqa.selenium.support.ui.{ExpectedConditions, Select, WebDriverWait}
import org.openqa.selenium.{By, WebDriver, WebElement}
//import com.typesafe.scalalogging.{Logger, Logging}
import scala.collection.JavaConverters._

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 8/5/13
 * Time: 11:42 AM
 * To change this template use File | Settings | File Templates.
 */


object JobDetailStep {
  val LABEL_TEXT = "Job Details"
}

class JobDetailStep(driver: WebDriver) extends AbstractJobDetailStep(driver) {
  this.jobIdField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobDetailStep.JOB_ID_FIELD_ID)))

}

class EditJobDetailStep(driver: WebDriver) extends AbstractJobDetailStep(driver) {
  this.jobIdField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.presenceOfElementLocated(By.id(AbstractJobDetailStep.JOB_ID_FIELD_ID)))


  def getJobNameInEditPopup = {
    this.jobNameField = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobDetailStep.JOB_NAME_FIELD_ID)))
    val jobName = jobNameField.getAttribute("value")
    jobName
  }

  def getJobIdInEditPopup = {
    val jobIdValue = jobIdField.getAttribute("value")
    jobIdValue
  }

}

object JobLocationStep {
  val LABEL_TEXT = "Job Location"
}

class JobLocationStep(driver: WebDriver) extends AbstractJobLocationStep(driver) {

  this.locationNameField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.JOB_LOCATION_NAME_FIELD)))

  this.jobLocationStreetNameField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.JOB_LOCATION_STREET_ID)))

  this.jobLocationSuiteNameField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.JOB_LOCATION_SUITE_ID)))

  this.jobLocationCityNameField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.JOB_LOCATION_CITY_ID)))

  this.jobLocationStateNameField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.JOB_LOCATION_STATE_ID)))

  this.jobLocationPostalCodeField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.JOB_LOCATION_POSTAL_CODE_ID)))

  this.locationContactNameField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.LOCATION_CONTACT_NAME_ID)))

  this.locationContactPhoneField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.LOCATION_CONTACT_PHONE_ID)))

  this.locationEmailAddressField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.LOCATION_EMAIL_ADDRESS_ID)))

  this.validateAddressButton = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.VALIDATE_ADDRESS_BUTTON_ID)))

  this.overrideGeoCodeCoordinateCheckBox = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.OVERRIDE_COORDINATES_CHECKBOX_ID)))

  this.latitudeField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.LATITUDE_FIELD_ID)))

  this.longitudeField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.LONGITUDE_FIELD_ID)))

  this.overrideWorkZoneCoordinateCheckbox = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.OVERRIDE_COORDINATES_FOR_WORKZONE_CHECKBOX_ID)))

  this.workZoneLatitudeField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.WORKZONE_LATITUDE_FIELD_ID)))

  this.workZoneLongitudeField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.WORKZONE_LONGITUDE_FIELD_ID)))

  this.workZoneRadiusField = new WebDriverWait(driver, 10)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.WORKZONE_RADIUS_ID)))

}

object JobParameterStep {
  val LABEL_TEXT = "Job Parameters"
}


class JobParameterStep(driver: WebDriver) extends AbstractJobParameterStep(driver) {
  this.skillField = new WebDriverWait(driver, 10).until(
    ExpectedConditions.visibilityOfElementLocated(By.id(AbstractJobParameterStep.SKILLS_ID)))
}

object JobScheduleAndAssignStep {
  val LABEL_TEXT = "Schedule and Assign"
}

class JobScheduleAndAssignStep(driver: WebDriver) extends AbstractJobScheduleAndAssignStep(driver) {

  this.jobPatternField = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.visibilityOfElementLocated(By.id(AbstractJobScheduleAndAssignStep.JOB_PATTERN_FIELD_ID)))

  this.jobPriorityField = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.visibilityOfElementLocated(By.id(AbstractJobScheduleAndAssignStep.JOB_PRIORITY_FIELD_ID)))


  this.singleWorkerRadioButton = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AbstractJobScheduleAndAssignStep.SINGLE_WORKER_RADIO_BUTTON_XPATH)))

  this.multipleWorkerRadioButton = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AbstractJobScheduleAndAssignStep.MULTI_WORKER_RADIO_BUTTON_XPATH)))

  this.sendJobToDevice = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.visibilityOfElementLocated(By.className(AbstractJobScheduleAndAssignStep.SEND_JOB_TO_DEVICE_CLASS)))

  this.senJobNowRadioEl = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.presenceOfElementLocated(By.id(AbstractJobScheduleAndAssignStep.SEND_JOB_NOW_RADIO_BUTTON_ID)))

  this.scheduleJobStart = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(AbstractJobScheduleAndAssignStep.SCHEDULE_JOB_START_FIELD_CLASS_NAME)))

//  def logger {
//    println("logger")
//  }

}

 class EditJobScheduledAndAssignStep(driver: WebDriver) extends AbstractJobScheduleAndAssignStep(driver) {
//   def logger {
//     println("logger")
//   }

  this.jobPriorityField = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.visibilityOfElementLocated(By.id(AbstractJobScheduleAndAssignStep.JOB_PRIORITY_FIELD_ID)))

  this.assignedWorkerField = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.visibilityOfElementLocated(By.id(AbstractJobScheduleAndAssignStep.ASSIGNED_WORKER_FIELD_ID)))

  this.recommendWorker = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.visibilityOfElementLocated(By.id(AbstractJobScheduleAndAssignStep.RECOMMEND_WORKER_BUTTON_ID)))

  this.jobPatternField = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.visibilityOfElementLocated(By.id(AbstractJobScheduleAndAssignStep.JOB_PATTERN_FIELD_ID)))

  def editJobScheduleAndAssign(jobPatternText: String, date: String, time: String, Timezone: String, duration: String, endAAJ: String, priority: String, group: String, worker: String) {

    setJobPattern(jobPatternText.trim)
    if (jobPatternText.trim == "One Time Job") {
      setTime(time)
      selectTimeZone(Timezone)
      setDuration(duration)
    }
    else {
      endAlwaysAvailableJob(endAAJ)
    }
    setPriority(priority)
    selectGroup(group)
    assignWorker(worker)
  }
}


object AbstractJobDetailStep {
  val JOB_ID_FIELD_ID = "job_referenceNumber"
  val JOB_NAME_FIELD_ID = "job_name"
  val JOB_ATTRIBUTES_FIELD_ID = "attributes"
  val JOB_ATTRIBUTES_VALUES_FIELD_ID = "jobAttributeValues_"
}

abstract class AbstractJobDetailStep(driver: WebDriver) extends AbstractStep(driver) {

  def setJobDetails(jobID: String, jobName: String, jobAttribute: String) {
    setJobID(jobID)
    setJobName(jobName)
    setAttributes(jobAttribute)
  }

  def setJobDescription(description: String): Unit ={
    if(!description.equals("NA")){
      val descriptionEl = driver.findElement(By.cssSelector("textarea#job_description"))
      descriptionEl.clear()
      descriptionEl.sendKeys(description)
    }
  }

  def setJobID(jobId: String): AbstractJobDetailStep = {
    if (!jobId.equals("NA")) {
      jobIdField.clear()
      jobIdField.sendKeys(jobId)
    }
    this
  }

  def setJobName(jobName: String): AbstractJobDetailStep = {
    var flag = false
    if (!jobName.equals("NA")) {
      try {
        this.jobNameField = new WebDriverWait(driver, 10)
          .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobDetailStep.JOB_NAME_FIELD_ID)))
        flag = true
        if (flag) {
          jobNameField.clear()
          jobNameField.sendKeys(jobName)
        }

      }
      catch {
        case e: Exception =>
          println("job name field is hidden ")
      }
    }
    this
  }

  def setAttributes(attributeList: String): AbstractJobDetailStep = {
    if (!attributeList.isEmpty) {
      val attributes: Array[String] = attributeList.split(",")
      for (i <- attributes.indices) {
        if (!attributes(i).equals("NA")) {
          val attributeEl = driver.findElement(By.id("jobAttributeValues_" + i + "_"))
          attributeEl.clear()
          attributeEl.sendKeys(attributes(i))
        }
      }
    }
    this
  }


  def getJobAttributesValues = {
    val attributeEl = driver.findElements(By.xpath("//*[contains(@id, 'jobAttributeValues_')]")).asScala
    val attributeValuesList = attributeEl.map(_.getAttribute("value")).toList
    attributeValuesList
  }

  def getLabelsOfJobDetailsStep = {
    val labelsELs = driver.findElements(By.tagName("label")).asScala
    val labels = labelsELs.filter(_.getText.nonEmpty).map(_.getText.trim).toList
    labels
  }

  protected var jobIdField: WebElement = null
  protected var jobNameField: WebElement = null
  protected var attributesField: WebElement = null

}


object AbstractJobLocationStep {
    val JOB_LOCATION_NAME_FIELD = "locationName"
    val JOB_LOCATION_REFERENCE_FIELD_ID = "locationReference"
    val JOB_LOCATION_STREET_ID = "job_location_address_street"
    val JOB_LOCATION_SUITE_ID = "job_location_address_suite"
    val JOB_LOCATION_CITY_ID = "job_location_address_city"
    val JOB_LOCATION_STATE_ID = "job_location_address_state"
    val JOB_LOCATION_POSTAL_CODE_ID = "job_location_address_postalCode"
    val LOCATION_CONTACT_NAME_ID = "job_location_contactName"
    val LOCATION_CONTACT_PHONE_ID = "job_location_contactPhone"
    val LOCATION_EMAIL_ADDRESS_ID = "job_location_email"
    val VALIDATE_ADDRESS_BUTTON_ID = "validateAddress"
    val SAVE_NEW_LOCATION_CHECKBOX_ID = "newLocation"
    val OVERRIDE_COORDINATES_CHECKBOX_ID = "coordinateOverride"
    val LATITUDE_FIELD_ID = "latitude"
    val LONGITUDE_FIELD_ID = "longitude"
    val OVERRIDE_COORDINATES_FOR_WORKZONE_CHECKBOX_ID = "coordinateOverrideForWorkzone"
    val WORKZONE_LATITUDE_FIELD_ID = "workzoneLatitude"
    val WORKZONE_LONGITUDE_FIELD_ID = "workzoneLongitude"
    val WORKZONE_RADIUS_ID = "radius"
}

abstract class AbstractJobLocationStep(driver: WebDriver) extends AbstractStep(driver) {


  def setJobLocation(location: String, contact: String, validate: String, overrideCoordinate: String, latLon: String, overrideWorkZone: String, workZone: String, saveLocation: String, locationRef: String) {
    if (!location.isEmpty) {
      val locationParts: Array[String] = location.split(",")
      setLocationName(locationParts(0))
      setLocationStreetName(locationParts(1))
      setLocationSuiteName(locationParts(2))
      setLocationCityName(locationParts(3))
      setLocationStateName(locationParts(4))
      setLocationPostalCode(locationParts(5))

    }

    if (!contact.isEmpty) {
      val contacts: Array[String] = contact.split(",")
      setLocationContactName(contacts(0))
      setLocationContactPhone(contacts(1))
      setLocationEmailAddress(contacts(2))
    }


    if (validate == "Yes") {
      validateAddress()
    }

    if (saveLocation == "Yes") {
      saveNewLocation()
      setLocationReference(locationRef)
    }

    if (!(overrideCoordinate.equals("NA") || overrideCoordinate.isEmpty)) {
      overrideCoordinatesForGeoCode()
      val geoCode: Array[String] = latLon.split(",")
      setGeocodeLatitude(geoCode(0))
      setGeocodeLongitude(geoCode(1))
    }

    if (!(overrideWorkZone.equals("NA") || overrideWorkZone.isEmpty)) {
      overrideCoordinatesForWorkZone()
      Thread.sleep(2000)
      val workZoneDetails: Array[String] = workZone.split(",")
      setWorkZoneLatitude(workZoneDetails(0))
      setWorkZoneLongitude(workZoneDetails(1))
      setWorkZoneSize(workZoneDetails(2))

    }
  }

  def setLocationName(locationName: String): AbstractJobLocationStep = {
    if (!locationName.equals("NA")) {
      locationNameField.clear()
      locationNameField.sendKeys(locationName)
    }
    this
  }

  def setLocationReference(locationRef: String): AbstractJobLocationStep = {
    if (!locationRef.equals("NA")) {
      val locationReferenceField = new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.JOB_LOCATION_REFERENCE_FIELD_ID)))
      locationReferenceField.clear()
      locationReferenceField.sendKeys(locationRef)
    }
    this

  }

  def setLocationStreetName(streetName: String): AbstractJobLocationStep = {
    if (!streetName.equals("NA")) {
      jobLocationStreetNameField.clear()
      jobLocationStreetNameField.sendKeys(streetName)
    }
    this
  }

  def setLocationSuiteName(suitName: String): AbstractJobLocationStep = {
    if (!suitName.equals("NA")) {
      jobLocationSuiteNameField.clear()
      jobLocationSuiteNameField.sendKeys(suitName)
    }
    this
  }

  def setLocationCityName(cityName: String): AbstractJobLocationStep = {
    if (!cityName.equals("NA")) {
      jobLocationCityNameField.clear()
      jobLocationCityNameField.sendKeys(cityName)
    }
    this
  }

  def setLocationStateName(stateName: String): AbstractJobLocationStep = {
    if (!stateName.equals("NA")) {
      jobLocationStateNameField.clear()
      jobLocationStateNameField.sendKeys(stateName)
    }
    this
  }

  def setLocationPostalCode(postalCode: String): AbstractJobLocationStep = {
    if (!postalCode.equals("NA")) {
      jobLocationPostalCodeField.clear()
      jobLocationPostalCodeField.sendKeys(postalCode)
    }
    this
  }

  def setLocationContactName(contactName: String): AbstractJobLocationStep = {
    if (!contactName.equals("NA")) {
      if (contactName.equals("Empty")) {
        locationContactNameField.clear()
      } else {
        locationContactNameField.clear()
        locationContactNameField.sendKeys(contactName)
      }
    }
    this
  }

  def setLocationContactPhone(contactPhone: String): AbstractJobLocationStep = {
    if (!contactPhone.equals("NA")) {
      if (contactPhone.equals("Empty")) {
        locationContactPhoneField.clear()
      } else {
        locationContactPhoneField.clear()
        locationContactPhoneField.sendKeys(contactPhone)
      }
    }
    this
  }

  def setLocationEmailAddress(emailId: String): AbstractJobLocationStep = {
    if (!emailId.equals("NA")) {
      if (emailId.equals("Empty")) {
        locationEmailAddressField.clear()
      } else {
        locationEmailAddressField.clear()
        locationEmailAddressField.sendKeys(emailId)
      }
    }
    this
  }

  def validateAddress(): AbstractJobLocationStep = {
    validateAddressButton.click()
    this
  }

  def saveNewLocation(): AbstractJobLocationStep = {
    val saveNewLocationButton = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobLocationStep.SAVE_NEW_LOCATION_CHECKBOX_ID)))
    saveNewLocationButton.click()
    this
  }

  def overrideCoordinatesForGeoCode(): AbstractJobLocationStep = {
    if (!overrideGeoCodeCoordinateCheckBox.isSelected) {
      overrideGeoCodeCoordinateCheckBox.click()
    }
    this
  }

  def setGeocodeLatitude(lat: String): AbstractJobLocationStep = {
    if (!(lat.equals("NA") || lat.isEmpty)) {
      if (lat.equals("Empty")) {
        latitudeField.clear()
      } else {
        latitudeField.clear()
        latitudeField.sendKeys(lat)
      }
    }
    this
  }

  def setGeocodeLongitude(lon: String): AbstractJobLocationStep = {
    if (!(lon.equals("NA") || lon.isEmpty)) {
      if (lon.equals("Empty")) {
        longitudeField.clear()
      } else {
        longitudeField.clear()
        longitudeField.sendKeys(lon)
      }
    }
    this
  }

  def overrideCoordinatesForWorkZone(): AbstractJobLocationStep = {
    if (!overrideWorkZoneCoordinateCheckbox.isSelected) {
      overrideWorkZoneCoordinateCheckbox.click()
    }
    this
  }

  def setWorkZoneLatitude(lat: String): AbstractJobLocationStep = {
    if (!lat.equals("NA")) {
      workZoneLatitudeField.clear()
      workZoneLatitudeField.sendKeys(lat)
    }

    this
  }

  def setWorkZoneLongitude(lon: String): AbstractJobLocationStep = {
    if (!lon.equals("NA")) {
      workZoneLongitudeField.clear()
      workZoneLongitudeField.sendKeys(lon)
    }

    this
  }

  def setWorkZoneSize(radius: String): AbstractJobLocationStep = {

    if (!(radius.equals("NA") || radius.isEmpty)) {
      workZoneRadiusField.clear()
      workZoneRadiusField.sendKeys(radius)
    }

    this
  }

  def getLocationDetails = {
    val locationName = locationNameField.getAttribute("value")
    val streetName = jobLocationStreetNameField.getAttribute("value")
    val apartmentName = jobLocationSuiteNameField.getAttribute("value")
    val cityName = jobLocationCityNameField.getAttribute("value")
    val state = jobLocationStateNameField.getAttribute("value")
    val postalCode = jobLocationPostalCodeField.getAttribute("value")
    val locationDetails = locationName + "," + streetName + "," + apartmentName + "," + cityName + "," + state + "," + postalCode
    locationDetails
  }

  def getContactDetails = {
    var contactName = locationContactNameField.getAttribute("value")
    if (contactName.isEmpty) {
      contactName = "NA"
    }
    var contactPhone = locationContactPhoneField.getAttribute("value")
    if (contactPhone.isEmpty) {
      contactPhone = "NA"
    }
    var emailAddress = locationEmailAddressField.getAttribute("value")
    if (emailAddress.isEmpty) {
      emailAddress = "NA"
    }
    val contactDetails = contactName + "," + contactPhone + "," + emailAddress
    contactDetails
  }

  def getLabelsOfJobLocationStep = {

    val labelsELs2 = driver.findElements(By.xpath("//*[contains(@class, 'label')]")).asScala.toList
    val labels = labelsELs2.filter(_.getText.nonEmpty).map(_.getText.trim)
    labels
  }

  def autoChoiceLocation(locationName: String) = {
    val autoChoiceLocEl = driver.findElement(By.cssSelector("div#autocomplete_choices"))
    val locationEl = autoChoiceLocEl.findElement(By.cssSelector("li[locationname = "+locationName+"]"))
    locationEl.click()
  }

  protected var locationNameField: WebElement = null
  protected var locationReferenceField: WebElement = null
  protected var jobLocationStreetNameField: WebElement = null
  protected var jobLocationSuiteNameField: WebElement = null
  protected var jobLocationCityNameField: WebElement = null
  protected var jobLocationStateNameField: WebElement = null
  protected var jobLocationPostalCodeField: WebElement = null
  protected var locationContactNameField: WebElement = null
  protected var locationContactPhoneField: WebElement = null
  protected var locationEmailAddressField: WebElement = null
  protected var validateAddressButton: WebElement = null
  protected var saveNewLocationButton: WebElement = null
  protected var overrideGeoCodeCoordinateCheckBox: WebElement = null
  protected var latitudeField: WebElement = null
  protected var longitudeField: WebElement = null
  protected var overrideWorkZoneCoordinateCheckbox: WebElement = null
  protected var workZoneLatitudeField: WebElement = null
  protected var workZoneLongitudeField: WebElement = null
  protected var workZoneRadiusField: WebElement = null
}


object AbstractJobParameterStep {
  val SKILLS_ID = "jobSkillGuids"
}

abstract class AbstractJobParameterStep(driver: WebDriver) extends AbstractStep(driver) {

  def setSkills(skills: String): AbstractJobParameterStep = {
    if (!(skills.equals("NA") || skills.isEmpty)) {
      val skillNames: Array[String] = skills.split(",")
      val skillSelect: Select = new Select(skillField)
      for (a <- skillNames) {
        skillSelect.selectByVisibleText(a)
      }

    }
    this
  }

  def isSkillFieldEnabled = {
    val flag = skillField.isEnabled
    flag
  }

  def getSelectedSkills = {
    val skillSelect: Select = new Select(skillField)
    val selectedEls = skillSelect.getAllSelectedOptions.asScala
    val selectedOptionsList = selectedEls.map(_.getText).toList
    selectedOptionsList
  }

  def getLabelsOfJobParameterStep = {
    val labelsELs = driver.findElements(By.tagName("label")).asScala
    val labels = labelsELs.filter(_.getText.nonEmpty).map(_.getText.trim).toList
    labels
  }

  protected var skillField: WebElement = null

}


object AbstractJobScheduleAndAssignStep {
  val JOB_PATTERN_FIELD_ID = "jobModeId"
  val DATE_CHECKBOX_ID = "useDate"
  val DATE_FIELD_ID = "scheduledStartDate"
  val TIME_CHECKBOX_ID = "useTime"
  val TIME_FIELD_ID = "widget_scheduledStartTime"
  val TIME_ZONE_FIELD_ID = "job_scheduledTimeZone"
  val DURATION_TEXTBOX_ID = "scheduledDuration"
  val DURATION_UNITS_ID = "durationUnit"
  val END_AAJ_NEVER = "jobEndCriteria1"
  val END_AAJ_AFTER = "jobEndCriteria2"
  val END_AAJ_ON = "jobEndCriteria3"
  val JOB_PRIORITY_FIELD_ID = "job_priorityId"
  val SINGLE_WORKER_GROUP_ID = "divisionId"
  val GROUP_FIELD_ID = "assignToWorkersTree"
  val ASSIGNED_WORKER_FIELD_ID = "assignedWorkerId"
  val OCCURRENCE = "occurences"
  val REPEATABLE_END_TIME = "widget_repeatableEndTime"
  val ALL_GROUP_ID = "jobTypeDivisionListIds"
  val SUB_NODE_ELEMENT_CLASS = "trNdElem "
  val NODE_ELEMENT_CLASS = "trNdElem nd-spcr "
  val GROUP_EXPAND_BUTTON_XPATH = "//div[@class = '" + SUB_NODE_ELEMENT_CLASS + "']//span"
  val GROUP_CHECKBOX_CLASS = "trNdChk"
  val GROUP_EXPAND_BUTTONS_CLASS = "ndPlusBtn"
  val GROUP_XPATH_1 = "//div[@class = '" + NODE_ELEMENT_CLASS + "']"
  val GROUP_XPATH_2 = "//div[@class = '" + SUB_NODE_ELEMENT_CLASS + "']"
  val GROUP_FIELD_XPATH = "//span[@id='" + GROUP_FIELD_ID + "']"
  val SINGLE_WORKER_RADIO_BUTTON_XPATH = "//input[@id = 'jobAssignedToTypesingle' and @type = 'radio']"
  val MULTI_WORKER_RADIO_BUTTON_XPATH = "//input[@id = 'jobAssignedToTypemultiple' and @type = 'radio']"
  val RECOMMEND_WORKER_BUTTON_ID = "recommendWorker"
  val SEND_JOB_TO_DEVICE_CLASS = "schedule-job-download"
  val SEND_JOB_NOW_CLASS = "schedule-job-download-now"
  val SEND_JOB_NOW_RADIO_BUTTON_ID = "sendToDvcDateRadio1"
  val SEND_JOB_BEFORE_SCHEDULE_START_CLASS = "schedule-job-download-relative"
  val SEND_JOB_BEFORE_SCHEDULE_START_RADIO_BUTTON_ID = "sendToDvcDateRadio2"
  val DAYS_BEFORE_START_DATE_SELECT_ID = "daysBeforeStartDateSelect"
  val SCHEDULE_JOB_ON_DATE_ID = "schedule-job-download-date"
  val SCHEDULE_JOB_ON_DATE_RADIO_BUTTON_ID = "sendToDvcDateRadio3"
  val ASSIGN_SINGLE_WORKER_JOB_FIELD_ID = "jobAssignTo_single"
  val SCHEDULE_JOB_START_FIELD_CLASS_NAME = "//table[@class = 'schedule-job-start']"
}

abstract class AbstractJobScheduleAndAssignStep(driver: WebDriver) extends AbstractStep(driver) {

  this.jobPatternField = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.visibilityOfElementLocated(By.id(AbstractJobScheduleAndAssignStep.JOB_PATTERN_FIELD_ID)))

  def setJobScheduleAndAssign(jobPatternText: String, date: String, time: String, Timezone: String, duration: String, endAAJ: String, priority: String, group: String, worker: String) {


    setJobPattern(jobPatternText.trim)
    if (jobPatternText.trim == "One Time Job") {
      setTime(time)
      selectTimeZone(Timezone)
      setDuration(duration)
    }
    else {
      endAlwaysAvailableJob(endAAJ)
    }
    selectSingleWorkerRadioButton()
    setPriority(priority)
    selectGroup(group)
    assignWorker(worker)
  }


  def isAssignSingleWorkerJobGroupFieldEnabled = {
    val flag = driver.findElement(By.id(AbstractJobScheduleAndAssignStep.SINGLE_WORKER_GROUP_ID)).isEnabled
    flag
  }

  def isSendJobToDeviceFieldEnabled = {
    val flag = this.sendJobToDevice.isEnabled
    flag
  }

  def isScheduleJObStartFieldEnabled = {
    val scheduleJObStartFieldEl = driver.findElement(By.xpath(AbstractJobScheduleAndAssignStep.SCHEDULE_JOB_START_FIELD_CLASS_NAME))
    val flag = scheduleJObStartFieldEl.isEnabled
    flag
  }

  def isAssignSingleWorkerJobWorkerFieldEnabled = {
    val workerEl = driver.findElement(By.id(AbstractJobScheduleAndAssignStep.ASSIGNED_WORKER_FIELD_ID))
    val flag = workerEl.isEnabled
    flag
  }

  def setJobScheduleAndAssignForMultipleWorkers(jobPatternText: String, date: String, time: String, Timezone: String, duration: String, endAAJ: String, priority: String, workers: List[String]) {
    setJobPattern(jobPatternText.trim)
    if (jobPatternText.trim == "One Time Job") {
      setTime(time)
      selectTimeZone(Timezone)
      setDuration(duration)
    }
    else {
      endAlwaysAvailableJob(endAAJ)
    }
    selectMultipleWorkerRadioButton()
    setPriority(priority)
    selectMultipleWorkers(workers)
  }

  def setJobPattern(jobPattern: String): AbstractJobScheduleAndAssignStep = {
    if (!(jobPattern.equals("NA") || jobPattern.isEmpty)) {
      val jobPatternSelect: Select = new Select(jobPatternField)
      jobPatternSelect.selectByVisibleText(jobPattern)

    }
    this
  }


  def isJobPatternEnabled = {
    val flag = jobPatternField.isEnabled
    flag
  }


  def isSendJobNowRadioButtonSelectedByDefault = {
    var flag = false
    if (senJobNowRadioEl.isSelected) {
      flag = true
    }
    flag
  }

  def getLabelsOfSendJobToDevice = {
    val labelsEls = sendJobToDevice.findElements(By.tagName("label")).asScala
    val labels = labelsEls.map(_.getText.trim).toList
    labels
  }


  def sendJobNow() {
    val sendJobNowEl = sendJobToDevice.findElement(By.id(AbstractJobScheduleAndAssignStep.SEND_JOB_NOW_RADIO_BUTTON_ID))
    sendJobNowEl.click()
  }

  def sendJobBeforeScheduleStart(days: String) {
    val sendJobBeforeScheduleStartRadioEl = sendJobToDevice.findElement(By.id(AbstractJobScheduleAndAssignStep.SEND_JOB_BEFORE_SCHEDULE_START_RADIO_BUTTON_ID))
    sendJobBeforeScheduleStartRadioEl.click()
    val selectEl = sendJobToDevice.findElement(By.id(AbstractJobScheduleAndAssignStep.DAYS_BEFORE_START_DATE_SELECT_ID))
    new Select(selectEl).selectByVisibleText(days)
  }

  def senJobOnDate(date: String) {
    val onRadioEl = sendJobToDevice.findElement(By.id(AbstractJobScheduleAndAssignStep.SCHEDULE_JOB_ON_DATE_RADIO_BUTTON_ID))
    onRadioEl.click()
  }

  def setTime(time: String): AbstractJobScheduleAndAssignStep = {
    if (!(time.equals("NA") || time.isEmpty)) {
      val timeField = new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobScheduleAndAssignStep.TIME_FIELD_ID)))
      timeField.clear()
      timeField.sendKeys(time)

    }
    this
  }

  def selectTimeZone(timeZone: String): AbstractJobScheduleAndAssignStep = {
    if (!(timeZone.equals("NA") || timeZone.isEmpty)) {
      val timeZoneField = new WebDriverWait(driver, 10).until(
        ExpectedConditions.visibilityOfElementLocated(By.id(AbstractJobScheduleAndAssignStep.TIME_ZONE_FIELD_ID)))
      val timeZoneSelect: Select = new Select(timeZoneField)
      timeZoneSelect.selectByVisibleText(timeZone)

    }
    this
  }

  def setDuration(durationAndUnits: String): AbstractJobScheduleAndAssignStep = {
    if (!(durationAndUnits.equals("NA") || durationAndUnits.isEmpty)) {
      val durationField = new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='" + AbstractJobScheduleAndAssignStep.DURATION_TEXTBOX_ID + "']")))
      val durationUnitArray: Array[String] = durationAndUnits.split(",")
      durationField.clear()
      durationField.sendKeys(durationUnitArray(0))
      val durationUnitsField = new WebDriverWait(driver, 10)
        .until(ExpectedConditions.visibilityOfElementLocated(By.id(AbstractJobScheduleAndAssignStep.DURATION_UNITS_ID)))
      val durationUnitSelect = new Select(durationUnitsField)
      durationUnitSelect.selectByVisibleText(durationUnitArray(1))
    }
    this
  }


  def endAlwaysAvailableJob(endAAJ: String): AbstractJobScheduleAndAssignStep = {
    if (!(endAAJ.equals("NA") || endAAJ.isEmpty)) {
      val endAAJParamenters: Array[String] = endAAJ.split(",")
      endAAJParamenters(0) match {
        case "Never" =>
          val jobEndCriteria1Field = new WebDriverWait(driver, 10).until(
            ExpectedConditions.elementToBeClickable(By.id(AbstractJobScheduleAndAssignStep.END_AAJ_NEVER)))
          jobEndCriteria1Field.click()
        case "After" =>
          val jobEndCriteria2Field = new WebDriverWait(driver, 10).until(
            ExpectedConditions.elementToBeClickable(By.id(AbstractJobScheduleAndAssignStep.END_AAJ_AFTER)))
          jobEndCriteria2Field.click()
          val occurrenceField = new WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobScheduleAndAssignStep.OCCURRENCE)))
          occurrenceField.clear()
          occurrenceField.sendKeys(endAAJParamenters(1))
        case "On" =>
          val jobEndCriteria3Field = new WebDriverWait(driver, 10).until(
            ExpectedConditions.elementToBeClickable(By.id(AbstractJobScheduleAndAssignStep.END_AAJ_ON)))
          jobEndCriteria3Field.click()
          val repeatableEndTimeField = new WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.id(AbstractJobScheduleAndAssignStep.REPEATABLE_END_TIME)))
          repeatableEndTimeField.clear()
          repeatableEndTimeField.sendKeys(endAAJParamenters(2))
      }
    }
    this
  }

  def setPriority(priority: String): AbstractJobScheduleAndAssignStep = {
    if (!priority.isEmpty) {
      val prioritySelect: Select = new Select(jobPriorityField)
      prioritySelect.selectByVisibleText(priority)

    }
    this
  }

  def selectSingleWorkerRadioButton() {
    singleWorkerRadioButton.click()
  }

  def selectMultipleWorkerRadioButton() {
    multipleWorkerRadioButton.click()
  }

  def isSingleWorkerRadioButtonSelected = {
    var flag = false
    if (singleWorkerRadioButton.isSelected) {
      flag = true
    }
    flag
  }

  def isMultipleWorkerRadioButtonSelected = {
    var flag = false
    if (multipleWorkerRadioButton.isSelected) {
      flag = true
    }
    flag
  }

  def getGroupListForSingleWorker = {
    val groupEls = driver.findElements(By.xpath("//select[@id = '" + AbstractJobScheduleAndAssignStep.SINGLE_WORKER_GROUP_ID + "']//option")).asScala
    val groupList = groupEls.map(_.getText.trim).toList
    groupList
  }

  def selectGroup(groupName: String): AbstractJobScheduleAndAssignStep = {
    if (!(groupName.equals("NA") || groupName.isEmpty) ) {
      this.groupField = new WebDriverWait(driver, maxWaitTime)
        .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobScheduleAndAssignStep.SINGLE_WORKER_GROUP_ID)))
      val groupNameELs = groupField.findElements(By.tagName("option")).asScala
      val gNameList = groupNameELs.filter(_.getText.trim.equals(groupName)).map(_.getText).toList
      val gNameStr = gNameList.head
      new Select(groupField).selectByVisibleText(gNameStr)
    }
    this
  }

  def getSelectedGroupForSingleWorkerJob = {
    this.groupField = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobScheduleAndAssignStep.SINGLE_WORKER_GROUP_ID)))
    val group = new Select(groupField).getFirstSelectedOption.getText.trim
    group
  }

  def assignWorker(workerName: String): AbstractJobScheduleAndAssignStep = {
    this.assignedWorkerField = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.visibilityOfElementLocated(By.id(AbstractJobScheduleAndAssignStep.ASSIGNED_WORKER_FIELD_ID)))
    if (!(workerName.equals("NA") || workerName.isEmpty)) {
      val workerSelect: Select = new Select(assignedWorkerField)
      workerSelect.selectByVisibleText(workerName)
    }
    this
  }

  def selectAllWorkers(value: String) = {
    this.groupField = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobScheduleAndAssignStep.GROUP_FIELD_ID)))
    if (!value.equals("NA")) {
      this.allGroups = groupField.findElement(By.id(AbstractJobScheduleAndAssignStep.ALL_GROUP_ID))
      if (value.equalsIgnoreCase("Yes")) {
        if (!allGroups.isSelected) {
          allGroups.click()
        }
      }
      if (value.equalsIgnoreCase("No")) {
        if (allGroups.isSelected) {
          allGroups.click()
        }
      }
    }
    this
  }


  def selectMultipleWorkers(workerNames: List[String]) = {
    this.groupField = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobScheduleAndAssignStep.GROUP_FIELD_ID)))
    if (workerNames.contains("All Groups")) {
      selectAllWorkers("Yes")
    }
    else {
      this.allGroups = groupField.findElement(By.id(AbstractJobScheduleAndAssignStep.ALL_GROUP_ID))
      try {
        val groupExpandButtons = driver.findElements(By.xpath(AbstractJobScheduleAndAssignStep.GROUP_EXPAND_BUTTON_XPATH)).asScala
        for (groupExpandButton <- groupExpandButtons) {
          if (groupExpandButton.getAttribute("class").equals(AbstractJobScheduleAndAssignStep.GROUP_EXPAND_BUTTONS_CLASS))
            groupExpandButton.click()
        }
      }
      catch {
        case e: Exception =>
//          logger.debug("groups dose not have user")
      }

      if (workerNames != List("NA")) {
        if (!allGroups.isSelected) {
          allGroups.click()
        }
        if (allGroups.isSelected) {
          allGroups.click()
        }
        val groupEls1 = groupField.findElements(By.xpath(AbstractJobScheduleAndAssignStep.GROUP_XPATH_1)).asScala.toList
        val groupEls2 = groupField.findElements(By.xpath(AbstractJobScheduleAndAssignStep.GROUP_XPATH_2)).asScala.toList

        var parentGroup = ""
        var group = ""
        val groupEls = groupEls1 ::: groupEls2

        for (workerName <- workerNames) {
          if (!workerName.isEmpty) {
            for (groupEl <- groupEls) {
              group = groupEl.getText
              if (group.length > workerName.length) {
                parentGroup = group.substring(0, workerName.length)
              }
              else {
                parentGroup = group
              }

              if (parentGroup.equals(workerName)) {
                val group = groupEl.findElement(By.className(AbstractJobScheduleAndAssignStep.GROUP_CHECKBOX_CLASS))
                if (group.isSelected) {
                  group.click()
                }
                if (!group.isSelected) {
                  group.click()
                }
              }
            }
          }
        }
      }
    }
    this
  }


  def getSelectedWorkersList = {
    var groupsList: List[String] = List()

    try {
      val groupExpandButtons = driver.findElements(By.xpath(AbstractJobScheduleAndAssignStep.GROUP_EXPAND_BUTTON_XPATH)).asScala
      for (groupExpandButton <- groupExpandButtons) {
        if (groupExpandButton.getAttribute("class").equals(AbstractJobScheduleAndAssignStep.GROUP_EXPAND_BUTTONS_CLASS))
          groupExpandButton.click()
      }
    }
    catch {
      case e: Exception =>
//        logger.debug("groups dose not have Sub groups")

    }
    val groupEls1 = driver.findElements(By.xpath(AbstractJobScheduleAndAssignStep.GROUP_FIELD_XPATH + AbstractJobScheduleAndAssignStep.GROUP_XPATH_1)).asScala.toList
    val groupEls2 = driver.findElements(By.xpath(AbstractJobScheduleAndAssignStep.GROUP_FIELD_XPATH + AbstractJobScheduleAndAssignStep.GROUP_XPATH_2)).asScala.toList
    val groupEls = groupEls1 ::: groupEls2
    for (groupEl <- groupEls) {
      val group = groupEl.findElement(By.className(AbstractJobScheduleAndAssignStep.GROUP_CHECKBOX_CLASS))
      if (group.isSelected) {
        val workerGroup = groupEl.findElement(By.tagName("span"))
        if (workerGroup.getAttribute("class").equals("trNdSymb-wrkr")) {
          val group = groupEl.getText
          val groupList = group.split("\n")
          groupsList = groupsList ::: List(groupList(0))
        }
      }
    }
    if (groupsList.isEmpty) {
      groupsList = groupsList ::: List()
    }
    groupsList
  }


  def getWorkersNames = {
    var groupsList: List[String] = List()

    try {
      val groupExpandButtons = driver.findElements(By.xpath(AbstractJobScheduleAndAssignStep.GROUP_EXPAND_BUTTON_XPATH)).asScala
      for (groupExpandButton <- groupExpandButtons) {
        if (groupExpandButton.getAttribute("class").equals(AbstractJobScheduleAndAssignStep.GROUP_EXPAND_BUTTONS_CLASS))
          groupExpandButton.click()
      }
    }
    catch {
      case e: Exception =>
//        logger.debug("groups dose not have Sub groups")
    }

    val groupEls1 = driver.findElements(By.xpath(AbstractJobScheduleAndAssignStep.GROUP_FIELD_XPATH + AbstractJobScheduleAndAssignStep.GROUP_XPATH_1)).asScala.toList
    val groupEls2 = driver.findElements(By.xpath(AbstractJobScheduleAndAssignStep.GROUP_FIELD_XPATH + AbstractJobScheduleAndAssignStep.GROUP_XPATH_2)).asScala.toList
    val groupEls = groupEls1 ::: groupEls2

    for (groupEl <- groupEls) {
      //      val group = groupEl.findElement(By.className(AbstractJobScheduleAndAssignStep.GROUP_CHECKBOX_CLASS))
      //      if (group.isSelected) {
      val workerGroup = groupEl.findElement(By.tagName("span"))
      if (workerGroup.getAttribute("class").equals("trNdSymb-wrkr")) {
        val group = groupEl.getText
        val groupList = group.split("\n")
        groupsList = groupsList ::: List(groupList(0))
      }
      //      }
    }
    if (groupsList.isEmpty) {
      groupsList = groupsList ::: List()
    }
    groupsList
  }


  def getSelectedGroupsNamesList = {
    var groups: List[String] = List()
    var finalSelectedGroupNamesList: List[String] = List()
    try {
      val groupExpandButtons = driver.findElements(By.xpath(AbstractJobScheduleAndAssignStep.GROUP_EXPAND_BUTTON_XPATH)).asScala
      for (groupExpandButton <- groupExpandButtons) {
        if (groupExpandButton.getAttribute("class").equals(AbstractJobScheduleAndAssignStep.GROUP_EXPAND_BUTTONS_CLASS))
          groupExpandButton.click()
      }
    }
    catch {
      case e: Exception =>
//        logger.debug("groups dose not have Sub groups")
    }
    val groupEls1 = driver.findElements(By.xpath(AbstractJobScheduleAndAssignStep.GROUP_FIELD_XPATH + AbstractJobScheduleAndAssignStep.GROUP_XPATH_1)).asScala.toList
    val groupEls2 = driver.findElements(By.xpath(AbstractJobScheduleAndAssignStep.GROUP_FIELD_XPATH + AbstractJobScheduleAndAssignStep.GROUP_XPATH_2)).asScala.toList
    val groupEls = groupEls1 ::: groupEls2
    for (groupEl <- groupEls) {
      val group = groupEl.getText
      val groupList = group.split("\n")
      groups = groups ::: List(groupList(0))
    }
    val workersList = getWorkersNames
    val onlyGroupNames = groups.diff(workersList)

    for (onlyGroupName <- onlyGroupNames) {
      for (groupEl <- groupEls) {
        val group = groupEl.getText
        val grp = group.split("\n")
        if (grp(0).equals(onlyGroupName)) {
          val group = groupEl.findElement(By.className(AbstractJobScheduleAndAssignStep.GROUP_CHECKBOX_CLASS))
          if (group.isSelected) {
            val group = groupEl.getText
            val groupList = group.split("\n")
            finalSelectedGroupNamesList = finalSelectedGroupNamesList ::: List(groupList(0))
          }
        }

      }
    }
    finalSelectedGroupNamesList
  }

  def getGroupsNamesList = {
    var groups: List[String] = List()
    try {
      val groupExpandButtons = driver.findElements(By.xpath(AbstractJobScheduleAndAssignStep.GROUP_EXPAND_BUTTON_XPATH)).asScala
      for (groupExpandButton <- groupExpandButtons) {
        if (groupExpandButton.getAttribute("class").equals(AbstractJobScheduleAndAssignStep.GROUP_EXPAND_BUTTONS_CLASS))
          groupExpandButton.click()
      }
    }
    catch {
      case e: Exception =>
//        logger.debug("groups dose not have Sub groups")
    }
    val groupEls1 = driver.findElements(By.xpath(AbstractJobScheduleAndAssignStep.GROUP_FIELD_XPATH + AbstractJobScheduleAndAssignStep.GROUP_XPATH_1)).asScala.toList
    val groupEls2 = driver.findElements(By.xpath(AbstractJobScheduleAndAssignStep.GROUP_FIELD_XPATH + AbstractJobScheduleAndAssignStep.GROUP_XPATH_2)).asScala.toList
    val groupEls = groupEls1 ::: groupEls2
    for (groupEl <- groupEls) {
      val group = groupEl.getText
      val groupList = group.split("\n")
      groups = groups ::: List(groupList(0))
    }
    val workersList = getWorkersNames
    val onlyGroupNames = groups.diff(workersList)
    onlyGroupNames
  }


  def getJObPattern = {
    val jobPatternSelect: Select = new Select(jobPatternField)
    val jobPattern = jobPatternSelect.getFirstSelectedOption.getText
    jobPattern
  }

  def getScheduleJobStartDate = {
    val date = driver.findElement(By.id(AbstractJobScheduleAndAssignStep.DATE_FIELD_ID)).getAttribute("value")
    date
  }

  def getScheduleStartTime = {
    val timeField = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobScheduleAndAssignStep.TIME_FIELD_ID)))
    val time = timeField.getAttribute("value")
    time
  }

  def getSelectedTimeZone = {
    val timeZoneField = new WebDriverWait(driver, 10).until(
      ExpectedConditions.visibilityOfElementLocated(By.id(AbstractJobScheduleAndAssignStep.TIME_ZONE_FIELD_ID)))
    val timeZoneSelect: Select = new Select(timeZoneField)
    val timeZone = timeZoneSelect.getFirstSelectedOption.getText
    timeZone
  }

  def getDurationAndUnits = {
    val durationField = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='" + AbstractJobScheduleAndAssignStep.DURATION_TEXTBOX_ID + "']")))
    var duration = durationField.getAttribute("value")
    val durationUnitsField = new WebDriverWait(driver, 10)
      .until(ExpectedConditions.visibilityOfElementLocated(By.id(AbstractJobScheduleAndAssignStep.DURATION_UNITS_ID)))
    val durationUnitSelect = new Select(durationUnitsField)
    val unit = durationUnitSelect.getFirstSelectedOption.getText
    duration = duration + "," + unit
    duration
  }

  def getJobPriority = {
    val prioritySelect: Select = new Select(jobPriorityField)
    val priority = prioritySelect.getFirstSelectedOption.getText
    priority
  }

  def getAssignedWorker = {
    val workerSelect: Select = new Select(assignedWorkerField)
    val worker = workerSelect.getFirstSelectedOption.getText
    worker
  }

  def getLabelsOfJobScheduleAndAssignStep = {
    val labelsELs1 = driver.findElements(By.tagName("label")).asScala.toList
    val labelsELs2 = driver.findElements(By.xpath("//*[@class = 'label']")).asScala.toList
    val labelEls = labelsELs1 ::: labelsELs2

    val labels = labelEls.filter(_.getText.nonEmpty).map(_.getText.trim)
    labels
  }


  protected var jobPatternField: WebElement = null
  protected var timeCheckBox: WebElement = null
  protected var timeField: WebElement = null
  protected var timeZoneField: WebElement = null
  protected var durationField: WebElement = null
  protected var durationUnitsField: WebElement = null

  protected var jobEndCriteria1Field: WebElement = null
  protected var jobEndCriteria2Field: WebElement = null
  protected var jobEndCriteria3Field: WebElement = null
  protected var occurrenceField: WebElement = null
  protected var repeatableEndTimeField: WebElement = null

  protected var jobPriorityField: WebElement = null
  protected var groupField: WebElement = null
  protected var assignedWorkerField: WebElement = null
  protected var singleWorkerRadioButton: WebElement = null
  protected var multipleWorkerRadioButton: WebElement = null
  protected var recommendWorker: WebElement = null
  protected var allGroups: WebElement = null
  protected var sendJobToDevice: WebElement = null
  protected var senJobNowRadioEl: WebElement = null
  protected var scheduleJobStart: WebElement = null
}


object JobShareStep {
  val LABEL_TEXT = "Share"
}

class JobShareStep(driver: WebDriver) extends AbstractJobShareStep(driver) {
//  def logger {
//    println("logger")
//  }

  this.allowMobileWorkerToEmailCheckBox = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobShareStep.ALLOW_MOBILE_WORKER_TO_EMAIL_CHECKBOX_ID)))
  this.autoEmailDelivery = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobShareStep.AUTO_EMAIL_DELIVERY_ID)))
  this.emailRecipientBox = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobShareStep.EMAIL_RECIPIENT_BOX_ID)))
  this.emailTemplateBox = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobShareStep.EMAIL_TEMPLATE_BOX_ID)))
  this.expandCollapseBoxEl = new WebDriverWait(driver, maxWaitTime)
    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(AbstractJobShareStep.EXPAND_COLLAPSE_BOX_XPATH)))
}

abstract class AbstractJobShareStep(driver: WebDriver) extends AbstractStep(driver) {

  def selectAllGroup(value: String) = {
    this.groupField = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobShareStep.GROUP_FIELD_ID)))
    if (!value.equals("NA")) {
      this.allGroups = groupField.findElement(By.id(AbstractJobShareStep.ALL_GROUP_ID))
      if (value.equalsIgnoreCase("Yes")) {
        if (!allGroups.isSelected) {
          allGroups.click()
        }
      }
      if (value.equalsIgnoreCase("No")) {
        if (allGroups.isSelected) {
          allGroups.click()
        }
      }
    }
    this
  }

  def setGroups(groupNames: List[String]) = {
    this.groupField = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobShareStep.GROUP_FIELD_ID)))
    if (groupNames.contains("All Groups")) {
      selectAllGroup("Yes")
    }
    else {
      this.allGroups = groupField.findElement(By.id(AbstractJobShareStep.ALL_GROUP_ID))
      try {
        val groupExpandButtons = driver.findElements(By.xpath(AbstractJobShareStep.GROUP_EXPAND_BUTTON_XPATH)).asScala
        for (groupExpandButton <- groupExpandButtons) {
          if (groupExpandButton.getAttribute("class").equals(AbstractJobShareStep.GROUP_EXPAND_BUTTONS_CLASS))
            groupExpandButton.click()
        }
      }
      catch {
        case e: Exception =>
//          logger.debug("groups dose not have user")
      }

      if (groupNames != List("NA")) {
        if (!allGroups.isSelected) {
          allGroups.click()
        }
        if (allGroups.isSelected) {
          allGroups.click()
        }
        val groupEls1 = groupField.findElements(By.xpath(AbstractJobShareStep.GROUP_XPATH_1)).asScala.toList
        val groupEls2 = groupField.findElements(By.xpath(AbstractJobShareStep.GROUP_XPATH_2)).asScala.toList

        var parentGroup = ""
        var group = ""
        val groupEls = groupEls1 ::: groupEls2

        for (groupName <- groupNames) {
          if (!groupName.isEmpty) {
            for (groupEl <- groupEls) {
              group = groupEl.getText
              if (group.length > groupName.length) {
                parentGroup = group.substring(0, groupName.length)
              }
              else {
                parentGroup = group
              }

              if (parentGroup.equals(groupName)) {
                val group = groupEl.findElement(By.className(AbstractJobShareStep.GROUP_CHECKBOX_CLASS))
                if (group.isSelected) {
                  group.click()
                }
                if (!group.isSelected) {
                  group.click()
                }
              }
            }
          }
        }
      }
    }
    this
  }

  def selectAllEmailIds(value: String) = {
    this.selectAllEmail = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobShareStep.SELECT_ALL_EMAIL_IDS)))
    if (!value.equals("NA")) {
      if (value.equalsIgnoreCase("Yes")) {
        if (!selectAllEmail.isSelected)
          selectAllEmail.click()
      }
      if (value.equalsIgnoreCase("No")) {
        if (selectAllEmail.isSelected)
          selectAllEmail.click()
      }
    }
    this
  }

  def selectAllowMobileWorkersToEmailCompletedJob(value: String) = {
    if (!value.equals("NA")) {
      if (value.equalsIgnoreCase("Yes")) {
        if (!allowMobileWorkerToEmailCheckBox.isSelected)
          allowMobileWorkerToEmailCheckBox.click()
      }
      if (value.equalsIgnoreCase("No")) {
        if (allowMobileWorkerToEmailCheckBox.isSelected)
          allowMobileWorkerToEmailCheckBox.click()
      }
    }
    this
  }

  def selectAutoEmailDelivery(value: String) = {
    if (!value.equals("NA")) {
      if (value.equalsIgnoreCase("Yes")) {
        if (!autoEmailDelivery.isSelected)
          autoEmailDelivery.click()
      }
      if (value.equalsIgnoreCase("No")) {
        if (autoEmailDelivery.isSelected)
          autoEmailDelivery.click()
      }
    }
    this
  }

  def getEmailIdOfUser(userName: String): String = {
    var emailID: String = ""
    new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class = 'listTable']")))
    val userEl = driver.findElement(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//tr[.//*[contains(.//text(),'" + userName + "')]]"))
    val emailIdsELs = userEl.findElements(By.tagName("td")).asScala
    try {
      val emailIDList = emailIdsELs.filter(_.getText.contains("@")).map(_.getText.trim).toList
      emailID = emailIDList.head
    }
    catch {
      case e: Exception =>
//        logger.debug("User dose not have email")
    }
    emailID
  }

  def verifyEmailIdCheckBoxOfUser(userName: String) = {
    var flag = false
    new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH)))
    val userEl = driver.findElement(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//tr[.//*[contains(.//text(),'" + userName + "')]]"))
    if (userEl.getAttribute(AbstractJobShareStep.INNER_HTML).contains("checkbox")) {
      flag = true
    }
    flag
  }

  def selectEmailIdOfUser(userNames: List[String]) = {
    this.selectAllEmail = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobShareStep.SELECT_ALL_EMAIL_IDS)))
    if (userNames.contains("All Users")) {
      selectAllEmailIds("Yes")
    }
    else {
      if (!userNames.equals(List("NA"))) {
        new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.elementToBeClickable(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH)))
        if (!selectAllEmail.isSelected) {
          selectAllEmail.click()
        }
        if (selectAllEmail.isSelected) {
          selectAllEmail.click()
        }
        for (userName <- userNames) {
          val userEl = driver.findElement(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//tr[.//*[contains(.//text(),'" + userName + "')]]"))
          try {
            if (userEl.getAttribute(AbstractJobShareStep.INNER_HTML).contains("checkbox")) {
              val emailCheckBoxEl = userEl.findElement(By.tagName("input"))
              if (!emailCheckBoxEl.isSelected) {
                emailCheckBoxEl.click()
              }
            }
          }
          catch {
            case e: Exception =>
//              logger.debug("This User dose not have email")
          }
        }
      }
    }
    this
  }

  def enterAdditionalEmailIds(emails: List[String]) {
    this.additionalEmailsId = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobShareStep.ADDITIONAL_EMAILS_ID)))
    if (!emails.contains("NA")) {
      this.additionalEmailsId.click()
      val additionalEmailEl = additionalEmailsId.findElement(By.className(AbstractJobShareStep.ADDITIONAL_EMAILS_INPUT_CLASS))
      for (email <- emails) {
        additionalEmailEl.sendKeys(email.trim + ",")
        sleepTime(minWaitTime * 1000)
      }
    }
  }

  def getAllUsersEmailEmailIds = {
    var userEmail: List[String] = List()
    new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH)))
    val userEls = driver.findElements(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//tr")).asScala
    for (userEl <- userEls) {

      if (userEl.getAttribute(AbstractJobShareStep.INNER_HTML).contains("checkbox")) {
        val checkBoxEl = userEl.findElement(By.tagName("input"))
        if (checkBoxEl.isSelected) {
          val userEmailEls = userEl.findElements(By.tagName("td")).asScala
          userEmail = userEmail ::: userEmailEls.filter(_.getText.contains("@")).map(_.getText).toList
        }
      }
    }
    userEmail
  }

  def getAllSelectUserNames = {
    var userNames: List[String] = List()
    new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH)))
    val userEls = driver.findElements(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//tr")).asScala
    for (userEl <- userEls) {
      if (userEl.getAttribute(AbstractJobShareStep.INNER_HTML).contains("checkbox") && userEl.getAttribute(AbstractJobShareStep.INNER_HTML).contains("td")) {
        val checkBoxEl = userEl.findElement(By.tagName("input"))
        if (checkBoxEl.isSelected) {
          val userNameEls = userEl.findElements(By.tagName("td")).asScala
          userNames = userNames ::: List(userNameEls(2).getText)
        }
      }
    }
    userNames
  }

  def getAllAdditionalEmailIds = {
    this.additionalEmailsId = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobShareStep.ADDITIONAL_EMAILS_ID)))
    val emailIdsEls = this.additionalEmailsId.findElements(By.className("value")).asScala
    val emailIds = emailIdsEls.map(_.getText.trim).toList
    emailIds
  }

  def deleteAdditionalEmailId(emails: List[String]) {
    this.additionalEmailsId = new WebDriverWait(driver, maxWaitTime)
      .until(ExpectedConditions.elementToBeClickable(By.id(AbstractJobShareStep.ADDITIONAL_EMAILS_ID)))
    if (!emails.contains("NA")) {
      this.additionalEmailsId.click()
      for (email <- emails) {
        val emailDeleteEl = this.additionalEmailsId.findElement(By.xpath("//span[.//*[text()='" + email + "']]//span[@class = '" + AbstractJobShareStep.DELETE_EMAIL_ID_CLASS + "']"))
        emailDeleteEl.click()
      }
    }
  }

  def expandEmailRecipients() {
    val emailRecipientsEl = expandCollapseBoxEl.findElement(By.xpath(AbstractJobShareStep.EMAIL_RECIPIENT_BOX_XPATH))
    //    val emailRecipientsEl = expandCollapseBoxEl.findElement(By.xpath(AbstractJobShareStep.EMAIL_RECIPIENT_BOX_XPATH + AbstractJobShareStep.EXPAND_COLLAPSE_BOX_HEADERS_XPATH + "//td[3]"))
    if (emailRecipientsEl.getAttribute(AbstractJobShareStep.INNER_HTML).contains("expandBox")) {
      emailRecipientsEl.click()
      sleepTime(minWaitTime * 1000)
    }
  }

  def expandEmailTemplate() {
    val emailTemplateEl = expandCollapseBoxEl.findElement(By.xpath(AbstractJobShareStep.EMAIL_TEMPLATE_BOX_XPATH + AbstractJobShareStep.EXPAND_COLLAPSE_BOX_HEADERS_XPATH + "//td[2]"))
    if (emailTemplateEl.getAttribute(AbstractJobShareStep.INNER_HTML).contains("expandBox")) {
      emailTemplateEl.click()
      sleepTime(minWaitTime * 1000)
    }
  }

  def setEmailSubject(subject: String) {
    if (!subject.equals("NA")) {
      new WebDriverWait(driver, 20)
        .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(AbstractJobShareStep.EMAIL_SUBJECT_IFRAME_ID))
      val emailSubjectBodyEl = driver.findElement(By.id(AbstractJobShareStep.EDITOR_BODY_ID))
      emailSubjectBodyEl.clear()
      emailSubjectBodyEl.sendKeys(subject)
      driver.switchTo().defaultContent()
      driver.switchTo().frame(AbstractJobShareStep.IFRAME_ID)
    }
  }

  def getEmailSubject = {
    new WebDriverWait(driver, 20)
      .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(AbstractJobShareStep.EMAIL_SUBJECT_IFRAME_ID))
    val emailSubjectBodyEl = driver.findElement(By.id(AbstractJobShareStep.EDITOR_BODY_ID))
    val emailSubjectBody = emailSubjectBodyEl.getText
    driver.switchTo().defaultContent()
    driver.switchTo().frame(AbstractJobShareStep.IFRAME_ID)
    emailSubjectBody
  }


  def setMessageBody(body: String) {
    if (!body.equals("NA")) {

      new WebDriverWait(driver, 20)
        .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(AbstractJobShareStep.EMAIL_BODY_IFRAME_ID))

      val bodyEl = driver.findElement(By.id(AbstractJobShareStep.EDITOR_BODY_ID))
      bodyEl.clear()
      bodyEl.sendKeys(body)
      driver.switchTo().defaultContent()
      driver.switchTo().frame(AbstractJobShareStep.IFRAME_ID)
    }
  }

  def getEmailMessageBody = {
    new WebDriverWait(driver, 20)
      .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(AbstractJobShareStep.EMAIL_BODY_IFRAME_ID))

    val bodyEl = driver.findElement(By.id(AbstractJobShareStep.EDITOR_BODY_ID))
    val bodyMessage = bodyEl.getText
    driver.switchTo().defaultContent()
    driver.switchTo().frame(AbstractJobShareStep.IFRAME_ID)
    bodyMessage
  }

  def insertEmailTemplateAttributes(attribute: String) {
    if (!attribute.equals("NA")) {
      val toolTipEl = driver.findElement(By.id(AbstractJobShareStep.TOOL_TIP_DIALOG_ID))
      val selectEl = toolTipEl.findElement(By.id(AbstractJobShareStep.SELECT_TEMPLATE_ATTRIBUTE_ID))
      new Select(selectEl).selectByVisibleText(attribute)
      val insert = toolTipEl.findElement(By.id(AbstractJobShareStep.INSERT_BUTTON_ID))
      insert.click()
    }
  }

  def checkBoxStatusOfAllowMobileWorkersToEmailCompletedJob = {
    var flag = false
    if (allowMobileWorkerToEmailCheckBox.isSelected && allowMobileWorkerToEmailCheckBox.isDisplayed) {
      flag = true
    }
    flag
  }

  def checkBoxStatusOfAutoEmailDelivery = {
    var flag = false
    if (autoEmailDelivery.isSelected && autoEmailDelivery.isDisplayed) {
      flag = true
    }
    flag
  }

  def getBoxHeaderText = {
    val boxHeaderTextEl = driver.findElements(By.className(AbstractJobShareStep.BOX_HEADER_TEXT_CLASS_NAME)).asScala
    val boxHeaderTextList = boxHeaderTextEl.map(_.getText).toList
    boxHeaderTextList
  }

  def getUserTableHeaders = {
    val userTableEl = driver.findElement(By.id(AbstractJobShareStep.SELECT_USER_TABLE_ID))
    val userTableHeaderEls = userTableEl.findElements(By.tagName("th")).asScala
    var userTableHeaderList: List[String] = List()
    for (userTableHeaderEl <- userTableHeaderEls) {
      if (userTableHeaderEl.getAttribute(AbstractJobShareStep.INNER_HTML).contains("input")) {
        userTableHeaderList = userTableHeaderList ::: List("Select All Email checkBox")
      }
      else {
        userTableHeaderList = userTableHeaderList ::: List(userTableHeaderEl.getText)
      }
    }
    userTableHeaderList
  }

  def sort(columnName: String, order: String) {
    val columnNameEl = driver.findElement(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//th[.//*[contains(text(),'" + columnName + "')]]"))
    if (columnNameEl.getAttribute("innerHTML").contains("display: none;")) {
      driver.findElement(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//th[.//*[contains(text(),'" + columnName + "')]]")).click()
    }
    sleepTime(minWaitTime * 1000)
    val sortedImg = new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//th[.//*[contains(text(),'" + columnName + "')]]//img"))).getAttribute("src")

    if (order.equalsIgnoreCase("ascending")) {
      if (sortedImg.contains("sortArrowUp.gif")) {
        driver.findElement(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//th[.//*[contains(text(),'" + columnName + "')]]")).click()
        new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//th[.//*[contains(text(),'" + columnName + "')]]//img[contains(@src,'sortArrowDown')]")))
      }
    }

    if (order.equalsIgnoreCase("descending")) {
      if (sortedImg.contains("sortArrowDown.gif")) {
        driver.findElement(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//th[.//*[contains(text(),'" + columnName + "')]]")).click()
        new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//th[.//*[contains(text(),'" + columnName + "')]]//img[contains(@src,'sortArrowUp')]")))
      }
    }
  }

  def getRecipientsCount = {
    val recipientsEl = driver.findElement(By.id(AbstractJobShareStep.RECIPIENTS_COUNT_ID))
    recipientsEl.getText
  }

  def getAllUserNames = {
    new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH)))
    val userEls = driver.findElements(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//tr//td[3]")).asScala
    val userNames = userEls.map(_.getText).toList
    userNames
  }

  def getAllRoles = {
    new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH)))
    val roleEls = driver.findElements(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//tr//td[4]")).asScala
    val roles = roleEls.map(_.getText).toList
    roles
  }

  def getAllGroup = {
    new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH)))
    val groupEls = driver.findElements(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//tr//td[5]")).asScala
    val groups = groupEls.map(_.getText).toList
    groups
  }

  def getAllUsersEmailIds = {
    new WebDriverWait(driver, maxWaitTime).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH)))
    val EmailIdEls = driver.findElements(By.xpath(AbstractJobShareStep.USERS_EMAIL_IDS_TABLE_XPATH + "//tr//td[2]")).asScala
    val userEmail = EmailIdEls.filter(_.getText.nonEmpty).map(_.getText).toList
    userEmail
  }

  def getLabelsOfJobShareStep = {
    val labelsELs = driver.findElements(By.tagName("label")).asScala
    val labels = labelsELs.filter(_.getText.nonEmpty).map(_.getText.trim).toList
    labels
  }


  protected var groupField: WebElement = null
  protected var selectAllEmail: WebElement = null
  protected var allowMobileWorkerToEmailCheckBox: WebElement = null
  protected var additionalEmailsId: WebElement = null
  protected var allGroups: WebElement = null
  protected var autoEmailDelivery: WebElement = null
  protected var emailRecipientBox: WebElement = null
  protected var emailTemplateBox: WebElement = null
  protected var expandCollapseBoxEl: WebElement = null
}

object AbstractJobShareStep {
  val SUB_NODE_ELEMENT_CLASS = "trNdElem "
  val NODE_ELEMENT_CLASS = "trNdElem nd-spcr "
  val GROUP_FIELD_ID = "recipientGroupTreeRoot"
  val SELECT_ALL_EMAIL_IDS = "selectAll"
  val ALLOW_MOBILE_WORKER_TO_EMAIL_CHECKBOX_ID = "deviceEmailFlag"
  val ADDITIONAL_EMAILS_ID = "additionalEmailsNode"
  val ADDITIONAL_EMAILS_INPUT_CLASS = "multiValueTextAreaInput"
  val ALL_GROUP_ID = "emailUserDivisionListIds"
  val GROUP_EXPAND_BUTTON_XPATH = "//div[@class = '" + SUB_NODE_ELEMENT_CLASS + "']//span"
  val GROUP_CHECKBOX_CLASS = "trNdChk"
  val GROUP_EXPAND_BUTTONS_CLASS = "ndPlusBtn"
  val GROUP_XPATH_1 = "//div[@class = '" + NODE_ELEMENT_CLASS + "']"
  val GROUP_XPATH_2 = "//div[@class = '" + SUB_NODE_ELEMENT_CLASS + "']"
  val USER_TABLE_ID = "listTable jsonListTable"
  val USERS_EMAIL_IDS_TABLE_XPATH = "//table[" + hasCssClass(USER_TABLE_ID) + "]"
  val INNER_HTML = "innerHTML"
  val AUTO_EMAIL_DELIVERY_ID = "webEmailFlag"
  val DELETE_EMAIL_ID_CLASS = "delete-btn"
  val EMAIL_RECIPIENT_BOX_ID = "configureEmailRecipientsBox"
  val EMAIL_TEMPLATE_BOX_ID = "configureEmailTemplateBox"
  val EXPAND_COLLAPSE_BOX_CLASS = "expandCollapseBoxGroup"
  val EXPAND_COLLAPSE_BOX_XPATH = "//div[@class = '" + EXPAND_COLLAPSE_BOX_CLASS + "']"
  val EMAIL_RECIPIENT_BOX_XPATH = "//div[@id = '" + EMAIL_RECIPIENT_BOX_ID + "']"
  val EMAIL_TEMPLATE_BOX_XPATH = "//div[@id = '" + EMAIL_TEMPLATE_BOX_ID + "']"
  val EXPAND_COLLAPSE_BOX_HEADERS_XPATH = "//div[@class ='boxHeader']"
  val EXPAND_COLLAPSE_BOX_CONTENTS_XPATH = "//div[@class ='boxContent']"
  val EMAIL_SUBJECT_ID = "emailSubject"
  val EMAIL_MESSAGE_BODY_ID = "emailBody"
  val SELECT_TEMPLATE_ATTRIBUTE_ID = "emailTemplateAttributes"
  val EMAIL_SUBJECT_IFRAME_ID = "emailSubjectEditor_iframe"
  val EMAIL_BODY_IFRAME_ID = "emailBodyEditor_iframe"
  val IFRAME_ID = "xrCommonDialogIFrame"
  val EDITOR_BODY_ID = "dijitEditorBody"
  val TOOL_TIP_DIALOG_ID = "dijit_TooltipDialog_0"
  val INSERT_BUTTON_ID = "emailTemplateAttributes_insertBtn"
  val BOX_HEADER_TEXT_CLASS_NAME = "boxHeaderText"
  val SELECT_USER_TABLE_ID = "selectedUsersTable"
  val RECIPIENTS_COUNT_ID = "emailRecipientsCountNode"
}

