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
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Create User'
createUser = WS.sendRequest(findTestObject('Create User', [('userName') : userName, ('job') : job]))

println((('ini nama dan job ' + userName) + ' ') + job)

slurper = new JsonSlurper()
def parseJson = slurper.parseText(createUser.getResponseText())

def userId = parseJson.id

GlobalVariable.userId = userId
println('ini user id: ' + GlobalVariable.userId)
println('ini username: ' + parseJson.name)
println('ini job: ' + parseJson.job)

WS.verifyResponseStatusCode(createUser, 201)
WS.verifyEqual(parseJson.name, userName)
WS.verifyEqual(parseJson.job, job)


'Update User'
updateUser = WS.sendRequest(findTestObject('Update User', [('userNameUpdate') : userNameUpdate, ('jobUpdate') : jobUpdate]))
println((('ini nama update dan job update ' + userNameUpdate) + ' ') + jobUpdate)

def parseJsonUpdateUser = slurper.parseText(updateUser.getResponseText())

WS.verifyResponseStatusCode(updateUser, 200)
WS.verifyEqual(parseJsonUpdateUser.name, userNameUpdate)
WS.verifyEqual(parseJsonUpdateUser.job, jobUpdate)


'Delete User'
deleteUser = WS.sendRequest(findTestObject('Delete User'))

WS.verifyResponseStatusCode(deleteUser, 204)
