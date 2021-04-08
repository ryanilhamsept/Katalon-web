package com.smartfren.validation

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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import internal.GlobalVariable

public class Validation {
	@Keyword
	def validateElementPresent(ArrayList<TestObject> element) {
		int count=0
		String element_not_exist = ''
		boolean status = true
		while (element.size() > count) {
			if (!WebUI.verifyElementPresent(element.get(count),3, FailureHandling.OPTIONAL)
			) {
				element_not_exist = element_not_exist+element.get(count).toString()+'not found in page\n'
				println 'Element_not_exist :'+element_not_exist
				status = false
			}
			count++;
		}
		if(status == false) {
			KeywordUtil.markFailed("Some element in Validation not exist\n"+element_not_exist)
		}else {
			KeywordUtil.markPassed("All element in Validation exist")
		}
	}
	@Keyword
	def validateElementClickable(ArrayList<TestObject> element) {
		int count=0
		String element_not_clickable = ''
		boolean status = true
		while (element.size() > count) {
			if (!WebUI.verifyElementClickable(element.get(count), FailureHandling.CONTINUE_ON_FAILURE)
			) {
				element_not_clickable = element_not_clickable+element.get(count).toString()+'not clickable\n'
				println 'Element_not_exist :'+element_not_clickable
				status = false
			}
			count++;
		}
		if(status == false) {
			KeywordUtil.markFailed("Some element in Validation not Clickable\n"+element_not_clickable)
		}else {
			KeywordUtil.markPassed("Element in Validation Clickable")
		}
	}
	@Keyword
	def validateElementNotClickable(ArrayList<TestObject> element) {
		int count=0
		String element_clickable = ''
		boolean status = true
		while (element.size() > count) {
			if (!WebUI.verifyElementNotClickable(element.get(count), FailureHandling.CONTINUE_ON_FAILURE)
			) {
				element_clickable = element_clickable+element.get(count).toString()+'not clickable\n'
				println 'Element_not_exist :'+element_clickable
				status = false
			}
			count++;
		}
		if(status == false) {
			KeywordUtil.markFailed("Some element in Validation not Clickable\n"+element_clickable)
		}else {
			KeywordUtil.markPassed("Element in Validation Clickable")
		}
	}
	@Keyword
	def validateElementTextExist(ArrayList<TestObject> element) {
		int count=0
		String element_text_null = ''
		boolean status = true
		String text = ''
		while (element.size() > count) {
			if (WebUI.getText(element.get(count), FailureHandling.CONTINUE_ON_FAILURE).equals('')
			) {
				element_text_null = element_text_null+element.get(count).toString()+' text is null\n'
				println 'Element_text_null :'+element_text_null
				status = false
			}
			count++;
		}
		if(status == false) {
			KeywordUtil.markFailed("Some element text in Validation not present\n"+element_text_null)
		}else {
			KeywordUtil.markPassed("Element Text in Validation Exist")
		}
	}
	@Keyword
	def validateElementText(ArrayList<TestObject> element, ArrayList<String> expected_text) {
		int count=0
		String element_text_diff = ''
		boolean status = true
		String text = ''
		while (element.size() > count) {
			if (!WebUI.verifyElementText(element.get(count), expected_text.get(count))
			) {
				element_text_diff = element_text_diff+element.get(count).toString()+' text is different\n'
				println 'Element_text_different :'+element_text_diff
				status = false
			}
			count++;
		}
		if(status == false) {
			KeywordUtil.markFailed("Some element text in Validation different from expected\n"+element_text_diff)
		}else {
			KeywordUtil.markPassed("Element Text in Validation Success")
		}
	}
	@Keyword
	def validateElementTextDropDown(TestObject element, ArrayList<String> expected_text) {
		boolean status=true
		String missing_text=''
		def element_text = WebUI.getText(element).trim().split("\\s*\n\\s*")
		println 'Element text :'+element_text
		for(int i in 0..expected_text.size()-1) {
			if(!element_text.contains(expected_text.get(i))) {
				status=false
				missing_text=missing_text+expected_text.get(i)+'\n'
			}
		}
		
		if(status == false) {
			KeywordUtil.markFailed("Some text missing from dropdown :\n"+missing_text)
		}else {
			KeywordUtil.markPassed("All Text available from dropdown, Validation Success")
		}
	}
}
