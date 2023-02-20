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
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

WebUI.click(findTestObject('Object Repository/WEB Element/CURA Healthcare Service/Button - Make Appointment'))

WebUI.setText(findTestObject('Object Repository/WEB Element/CURA Healthcare Service/EditText - Username'), GlobalVariable.usernameWeb)

WebUI.setText(findTestObject('Object Repository/WEB Element/CURA Healthcare Service/EditText - Password'), GlobalVariable.passwordWeb)

WebUI.click(findTestObject('Object Repository/WEB Element/CURA Healthcare Service/Button - Login'))

WebUI.selectOptionByLabel(findTestObject('WEB Element/CURA Healthcare Service/DropDown - Facility'), facility, false)

switch (facility) {
    case 'Hongkong CURA Healthcare Center':
        WebUI.click(findTestObject('Object Repository/WEB Element/CURA Healthcare Service/CheckBox - Apply for hospital readmission'))

        checkButtonValue = WebUI.getAttribute(findTestObject('Object Repository/WEB Element/CURA Healthcare Service/CheckBox - Apply for hospital readmission'), 
            'value')

        println('ini attribute: ' + checkButtonValue)

        unchecked = WebUI.verifyElementNotChecked(findTestObject('WEB Element/CURA Healthcare Service/Radio - Medicaid Programs'), 
            10)

        if (unchecked == true) {
            WebUI.check(findTestObject('WEB Element/CURA Healthcare Service/Radio - Medicaid Programs'))

            radioButtonValue = WebUI.getAttribute(findTestObject('WEB Element/CURA Healthcare Service/Radio - Medicaid Programs'), 
                'value')

            println('ini attribute: ' + radioButtonValue)
        }
        
        break
    case 'Seoul CURA Healthcare Center':
        unchecked = WebUI.verifyElementNotChecked(findTestObject('Object Repository/WEB Element/CURA Healthcare Service/CheckBox - Apply for hospital readmission'), 
            10)

        if (unchecked == true) {
            checkButtonValue = 'No'
        }
        
        unchecked = WebUI.verifyElementNotChecked(findTestObject('WEB Element/CURA Healthcare Service/Radio - None Programs'), 
            10)

        if (unchecked == true) {
            WebUI.check(findTestObject('WEB Element/CURA Healthcare Service/Radio - None Programs'))

            radioButtonValue = WebUI.getAttribute(findTestObject('WEB Element/CURA Healthcare Service/Radio - None Programs'), 
                'value')

            println('ini attribute: ' + radioButtonValue)
        }
        
        break
    default:
        WebUI.click(findTestObject('Object Repository/WEB Element/CURA Healthcare Service/CheckBox - Apply for hospital readmission'))

        checkButtonValue = WebUI.getAttribute(findTestObject('Object Repository/WEB Element/CURA Healthcare Service/CheckBox - Apply for hospital readmission'), 
            'value')

        println('ini attribute: ' + checkButtonValue)

        radioButtonValue = WebUI.getAttribute(findTestObject('WEB Element/CURA Healthcare Service/Radio - Madicare'), 'value')

        println('ini attribute: ' + radioButtonValue)

        break
}

LocalDate currentDate = LocalDate.now()

LocalDate futureDate = currentDate.plusDays(3)

DateTimeFormatter formatter = DateTimeFormatter.ofPattern('dd/MM/yyyy')

String formattedFutureDate = futureDate.format(formatter)

println(formattedFutureDate)

WebUI.setText(findTestObject('Object Repository/WEB Element/CURA Healthcare Service/Date - Visit Date'), formattedFutureDate)

WebUI.setText(findTestObject('Object Repository/WEB Element/CURA Healthcare Service/TextArea - Comment'), 'Make Appointment with ' + 
    facility)

WebUI.click(findTestObject('Object Repository/WEB Element/CURA Healthcare Service/Button - Book Appointment'))

facilityData = WebUI.getText(findTestObject('WEB Element/CURA Healthcare Service/TextView - Facility Appointment'))

readmissionData = WebUI.getText(findTestObject('WEB Element/CURA Healthcare Service/TextView - Hospital Readmission Appointment'))

healtcareData = WebUI.getText(findTestObject('WEB Element/CURA Healthcare Service/TextView - Healtcare Appointment'))

dateData = WebUI.getText(findTestObject('WEB Element/CURA Healthcare Service/TextView - Date Appointment'))

commentData = WebUI.getText(findTestObject('WEB Element/CURA Healthcare Service/TextView - Comment Appointment'))

WebUI.verifyEqual(facilityData, facility)

WebUI.verifyEqual(readmissionData, checkButtonValue)

WebUI.verifyEqual(healtcareData, radioButtonValue)

WebUI.verifyEqual(dateData, formattedFutureDate)

WebUI.verifyEqual(commentData, 'Make Appointment with ' + facility)

WebUI.click(findTestObject('Object Repository/WEB Element/CURA Healthcare Service/Button - Go to Homepage'))

WebUI.click(findTestObject('WEB Element/CURA Healthcare Service/Button - Hamburger Menu'))

WebUI.click(findTestObject('WEB Element/CURA Healthcare Service/Button - Logout'))

WebUI.closeBrowser()

