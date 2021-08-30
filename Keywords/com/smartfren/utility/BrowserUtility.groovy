package com.smartfren.utility

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

public class BrowserUtility {
	@Keyword
	def openURL(String URL) {
		WebUI.openBrowser('')
		WebUI.delay(2)
		//WebUI.deleteAllCookies(FailureHandling.OPTIONAL)
		//WebUI.delay(2)
		//WebUI.maximizeWindow()
		WebUI.navigateToUrl(URL, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForPageLoad(30)
		WebUI.delay(2)
	}
	@Keyword
	def scrollPageCapture (int scrollDown){
		int pageInc=0
		while (pageInc < scrollDown) {
			WebUI.scrollToPosition(pageInc, pageInc, FailureHandling.STOP_ON_FAILURE)
			Thread.sleep (GlobalVariable.scrollSleep)
			pageInc=pageInc+30
		}
	}
	@Keyword
	def clickButton(TestObject test, FailureHandling fail, String info){
		KeywordUtil.logInfo(info)
		WebUI.click(test, fail)
	}
	@Keyword
	def Screenshot(){
		Date today = new Date()
		String todaysDate = today.format('MM_dd_yy')
		String nowTime = today.format('hh_mm_ss')
		WebUI.delay(3)
		WebUI.takeScreenshot(((('Capture//Document_'  + todaysDate) + '_') + nowTime) + '.jpg')
	}
	@Keyword
	def HandlePopUpAfterQuiz() {
		//if(WebUI.verifyElementPresent(findTestObject('Object Repository/PQ_Play_QA/button/pop_up_badge_ok'), 3, FailureHandling.OPTIONAL)) {
		//	WebUI.takeScreenshot()
		//	KeywordUtil.logInfo('Closing PopUp After Quiz')
		//	WebUI.click(findTestObject('Object Repository/PQ_Play_QA/button/pop_up_badge_ok'))
		//}
	}
}
