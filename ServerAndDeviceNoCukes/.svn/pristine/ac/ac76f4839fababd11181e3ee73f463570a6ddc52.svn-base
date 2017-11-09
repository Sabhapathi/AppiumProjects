package com.xora.mc.pages.Forms

import com.xora.mc.pages.ListPageContextMenuPopup
import com.xora.mc.pages.workers.WorkerActivityLogPage
import org.openqa.selenium.WebDriver
import com.xora.mc.pages.Forms.SubmittedFormsContextMenuPopup._

/**
 * Created with IntelliJ IDEA.
 * User: Nandini
 * Date: 11/29/13
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
object SubmittedFormsContextMenuPopup{
  sealed abstract class SUBMITTED_FORM_CONTEXT_MENU_POPUP_OPTION(val displayValue: String)
  case object EDIT_SUBMITTED_FORM extends SUBMITTED_FORM_CONTEXT_MENU_POPUP_OPTION("Edit Submitted Form")
  case object VIEW_SUBMITTED_FORM_DETAIL extends SUBMITTED_FORM_CONTEXT_MENU_POPUP_OPTION("View Submitted Form Detail")
}

class SubmittedFormsContextMenuPopup(driver: WebDriver, parentPage: SubmittedFormsListPage) extends
ListPageContextMenuPopup[SubmittedFormsListPage](driver: WebDriver, parentPage: SubmittedFormsListPage) {

  protected var workerActivityLogPage: WorkerActivityLogPage = _
  def EditSubmittedForm () = {
    this.selectOption(EDIT_SUBMITTED_FORM)
    //    new EditFormFieldValuesPopup(driver,workerActivityLogPage)
  }
  def viewSubmittedFormDetail() =  {
    this.selectOption(VIEW_SUBMITTED_FORM_DETAIL)
    new ViewSubmittedFormDetailPage(driver, parentPage)
  }

  protected def selectOption(option: SubmittedFormsContextMenuPopup.SUBMITTED_FORM_CONTEXT_MENU_POPUP_OPTION) {
    this.selectOption(option.displayValue)
  }
}
