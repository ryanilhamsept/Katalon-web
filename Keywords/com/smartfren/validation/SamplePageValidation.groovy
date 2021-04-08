package com.smartfren.validation
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class SamplePageValidation {
	def validation = new Validation()
	@Keyword
	def validateSamplePageElementPresent() {
		ArrayList<TestObject> element = new ArrayList<TestObject>();
		element.add(findTestObject('Sample/btn/dropdown_sub_unit'))
		element.add(findTestObject('Sample/btn/leave_search_btn'))
		element.add(findTestObject('Sample/btn/leave_tab'))
		element.add(findTestObject('Sample/btn/user_menu'))
		validation.validateElementPresent(element)
	}
	@Keyword
	def validateSamplePageElementClickable() {
		ArrayList<TestObject> element = new ArrayList<TestObject>();
		element.add(findTestObject('Sample/btn/leave_search_btn'))
		element.add(findTestObject('Sample/btn/leave_tab'))
		element.add(findTestObject('Sample/btn/user_menu'))
		validation.validateElementClickable(element)
	}
	@Keyword
	def validateSamplePageElementTextnotNull() {
		ArrayList<TestObject> element = new ArrayList<TestObject>();
		element.add(findTestObject('Sample/txt/heading_text'))
		element.add(findTestObject('Sample/txt/label_From'))
		validation.validateElementTextExist(element)
	}
	@Keyword
	def validateSamplePageElementText() {
		ArrayList<TestObject> element = new ArrayList<TestObject>();
		ArrayList<String> expected_text = new ArrayList<String>();
		element.add(findTestObject('Object Repository/Sample/btn/user_menu'))
		expected_text.add('Welcome Paul')
		element.add(findTestObject('Sample/txt/label_From'))
		expected_text.add('From')
		validation.validateElementText(element,expected_text)
	}
	@Keyword
	def validateSamplePageDropDownMenu() {
		ArrayList<String> expected_text = new ArrayList<String>();
		expected_text.add('All')
		expected_text.add('Administration')
		expected_text.add('Engineering')
		expected_text.add('Development')
		expected_text.add('Quality Assurance')
		expected_text.add('TechOps')
		expected_text.add('Sales & Marketing')
		expected_text.add('Sales')
		expected_text.add('Marketing')
		expected_text.add('Client Services')
		expected_text.add('Technical Support')
		expected_text.add('Finance')
		expected_text.add('Human Resources')
		validation.validateElementTextDropDown(findTestObject('Sample/btn/dropdown_sub_unit'), expected_text)
	}
}