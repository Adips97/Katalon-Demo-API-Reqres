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
import com.kms.katalon.core.util.internal.PathUtil as PathUtil
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

'Get full directory\'s path of android application'
def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_AppPath, RunConfiguration.getProjectDir())

Mobile.startApplication(appPath, false)

Mobile.setText(findTestObject('Android Element/EditText - Username'), GlobalVariable.username, 0)

Mobile.setText(findTestObject('Android Element/EditText - Password'), GlobalVariable.password, 0)

Mobile.tap(findTestObject('Object Repository/Android Element/Button - Login'), 0)

switch (firstName) {
    case 'Adi':
        println(('\n\n\nIteration 1: ' + firstName) + '\n\n\n\n\n')

        Mobile.scrollToText('Sauce Labs Onesie')

        Mobile.tap(findTestObject('Android Element/TextViewProduct - Sauce Labs Fleece Jacket'), 0)

        Mobile.scrollToText('2019 Sauce Labs. All Rights Reserved')

        Mobile.tap(findTestObject('Object Repository/Android Element/Button - ADD TO CART'), 0)

        Mobile.tap(findTestObject('Object Repository/Android Element/Button - BACK TO PRODUCTS'), 0)

        Mobile.scrollToText('Sauce Labs Onesie')

        Mobile.tap(findTestObject('Android Element/TextViewProduct - Sauce Labs Bolt T-Shirt'), 0)

        Mobile.scrollToText('2019 Sauce Labs. All Rights Reserved')

        Mobile.tap(findTestObject('Android Element/Button - ADD TO CART'), 0)

        Mobile.tap(findTestObject('Object Repository/Android Element/Button - BACK TO PRODUCTS'), 0)

        Mobile.scrollToText('Sauce Labs Backpack')

        Mobile.tap(findTestObject('Android Element/TextViewProduct - Sauce Labs Backpack'), 0)

        Mobile.tap(findTestObject('Android Element/Button - ADD TO CART'), 0)

        break
    case 'Rudi':
        println(('\n\n\nIteration 2: ' + firstName) + '\n\n\n\n\n')

        Mobile.scrollToText('Sauce Labs Onesie')

        Mobile.tap(findTestObject('Android Element/TextViewProduct - Test.allTheThings() T-Shirt (Red)'), 0)

        Mobile.scrollToText('2019 Sauce Labs. All Rights Reserved')

        Mobile.tap(findTestObject('Android Element/Button - ADD TO CART'), 0)

        Mobile.tap(findTestObject('Object Repository/Android Element/Button - BACK TO PRODUCTS'), 0)

        Mobile.scrollToText('Sauce Labs Onesie')

        Mobile.tap(findTestObject('Android Element/TextViewProduct - Sauce Labs Onesie'), 0)

        Mobile.scrollToText('2019 Sauce Labs. All Rights Reserved')

        Mobile.tap(findTestObject('Android Element/Button - ADD TO CART'), 0)

        break
    default:
        Mobile.tap(findTestObject('Android Element/TextViewProduct - Sauce Labs Bike Light'), 0)

        Mobile.scrollToText('2019 Sauce Labs. All Rights Reserved')

        Mobile.tap(findTestObject('Object Repository/Android Element/Button - ADD TO CART'), 0)

        Mobile.tap(findTestObject('Object Repository/Android Element/Button - BACK TO PRODUCTS'), 0)

        Mobile.scrollToText('Sauce Labs Onesie')

        Mobile.tap(findTestObject('Object Repository/Android Element/TextViewProduct - Sauce Labs Onesie'), 0)

        Mobile.scrollToText('2019 Sauce Labs. All Rights Reserved')

        Mobile.tap(findTestObject('Android Element/Button - ADD TO CART'), 0)

        break
}

Mobile.tap(findTestObject('Android Element/Button - cart'), 0)

Mobile.scrollToText('CHECKOUT')

Mobile.tap(findTestObject('Object Repository/Android Element/Button - CHECKOUT'), 0)

Mobile.setText(findTestObject('Android Element/EditText - First Name'), firstName, 0)

Mobile.setText(findTestObject('Object Repository/Android Element/EditText - Last Name'), lastName, 0)

Mobile.setText(findTestObject('Object Repository/Android Element/EditText - ZipPostal Code'), zipPostalCode, 0)

Mobile.tap(findTestObject('Object Repository/Android Element/Button - CONTINUE'), 0)

Mobile.scrollToText('FINISH')

Mobile.tap(findTestObject('Android Element/Button - FINISH'), 0)

Mobile.tap(findTestObject('Android Element/Button - Hamburger Menu'), 0)

Mobile.tap(findTestObject('Object Repository/Android Element/Button - LOGOUT'), 0)

Mobile.closeApplication()

