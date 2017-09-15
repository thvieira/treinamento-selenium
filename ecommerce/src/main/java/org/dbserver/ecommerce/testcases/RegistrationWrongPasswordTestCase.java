package org.dbserver.ecommerce.testcases;

import org.dbserver.ecommerce.framework.BrowserUtils;
import org.dbserver.ecommerce.framework.ScreenShot;
import org.dbserver.ecommerce.tasks.HomeTasks;
import org.dbserver.ecommerce.tasks.UserRegistrationTasks;
import org.dbserver.ecommerce.verificationpoints.UserRegistrationVerificationPoint;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RegistrationWrongPasswordTestCase {
	
	public WebDriver driver = BrowserUtils.getFirefoxDriver();
	
	private HomeTasks homePage = new HomeTasks(driver);
	private UserRegistrationTasks userRegistration = new UserRegistrationTasks(driver);
	
	private static ExtentReports report = new ExtentReports("./reports/report.html");
	private static ExtentTest logger = report.startTest("New User Registration.");
	
	@Test
	public void testMain() {
		driver.get("http://demo.virtuemart.net/");
		driver.manage().window().maximize();
		
		logger.log(LogStatus.INFO, "The website has started.", logger.addScreenCapture(ScreenShot.capture(driver)));
		
		homePage.accessRegistrationPage();
		
		logger.log(LogStatus.INFO, "Register Page loaded.", logger.addScreenCapture(ScreenShot.capture(driver)));
		
		userRegistration.fillForm("Ana Terra", "anaterra", "mascada123", "mascada1234", "ana@terra.com.br", "ana@terra.com.br");		
		userRegistration.toRegister();
		
		if(UserRegistrationVerificationPoint.hasPasswordFieldErrorMessage(driver)) {
			logger.log(LogStatus.PASS, "Step Passed.", logger.addScreenCapture(ScreenShot.capture(driver)));
		} else {
			logger.log(LogStatus.FAIL, "Step Failed.", logger.addScreenCapture(ScreenShot.capture(driver)));
		}
	}	

	@AfterClass
	public static void tearDownTest() {
		report.endTest(logger);
		report.flush();
	}
}