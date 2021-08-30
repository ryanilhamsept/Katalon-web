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

CustomKeywords.'com.smartfren.utility.BrowserUtility.openURL'('https://my.smartfren.com/mysmartfren_login')

WebUI.setText(findTestObject('Login_via_web/userid_input'), 'ryanilhams@gmail.com')

WebUI.setEncryptedText(findTestObject('Login_via_web/password_input'), 'y/gZ/UkMWDSomvZQzUUVDA==')

WebUI.click(findTestObject('Login_via_web/button_Login'))

WebUI.delay(12)

WebUI.click(findTestObject('Login_via_web/menu_feature'))

//WebUI.click(findTestObject('Login_via_web/Feature', [('menu') : 'Choose Number']))

WebUI.click(findTestObject('Login_via_web/dropdown_profile'))

WebUI.click(findTestObject('Login_via_web/Button_Logout'))

WebUI.closeBrowser()

