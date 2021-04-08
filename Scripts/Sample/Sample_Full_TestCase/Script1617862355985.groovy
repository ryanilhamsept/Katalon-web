import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Open Browser
CustomKeywords.'com.smartfren.utility.BrowserUtility.openURL'('https://opensource-demo.orangehrmlive.com/')

// Go to page click or call test case
WebUI.callTestCase(findTestCase('Test Cases/Sample/Sample_StandAlone/Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)


//Click button or Link
CustomKeywords.'com.smartfren.utility.BrowserUtility.clickButton'(findTestObject('Sample/btn/leave_tab'),
	FailureHandling.STOP_ON_FAILURE, 'Click tab Leave on Home Page')

//Check uncheck checklist also using click
CustomKeywords.'com.smartfren.utility.BrowserUtility.clickButton'(findTestObject('Sample/btn/checklist_all'),
	FailureHandling.CONTINUE_ON_FAILURE, 'Checklist Leave Status All checked')
CustomKeywords.'com.smartfren.utility.BrowserUtility.clickButton'(findTestObject('Sample/btn/checklist_cancelled'),
	FailureHandling.CONTINUE_ON_FAILURE, 'Checklist Leave Status Cancelled uncheck')

//Select dropdown by Label
WebUI.selectOptionByLabel(findTestObject('Sample/btn/dropdown_sub_unit'),'Client Services', false)



// Capture element screenshot
WebUI.takeElementScreenshot(findTestObject('Sample/btn/dropdown_sub_unit'))

// Capture page screenshot
WebUI.takeScreenshot()

//Capture full page screenshot when have scroll
WebUI.takeFullPageScreenshot()

// Capture scroll page for video, 4000 here is height
CustomKeywords.'com.smartfren.utility.BrowserUtility.scrollPageCapture'(4000)



// Page Validation
// validation using new keyword class in com.smartfren.validation
//1. Check Some Element Exist
CustomKeywords.'com.smartfren.validation.SamplePageValidation.validateSamplePageElementPresent'()

//2. Button/Link clicable
CustomKeywords.'com.smartfren.validation.SamplePageValidation.validateSamplePageElementClickable'()

//3. Text not null/empty
CustomKeywords.'com.smartfren.validation.SamplePageValidation.validateSamplePageElementTextnotNull'()

//4. Text value
CustomKeywords.'com.smartfren.validation.SamplePageValidation.validateSamplePageElementText'()

//5. Drop Down Value
CustomKeywords.'com.smartfren.validation.SamplePageValidation.validateSamplePageDropDownMenu'()

//6. DB validation
GlobalVariable.g_SP_Points = CustomKeywords.'com.smartfren.DB.DBFunction.GetPoints'(GlobalVariable.g_MDN)

//7. Specific Project Validation
//Spesific Project Validation can be made using new keywords

// Close Browser
//using test listener


