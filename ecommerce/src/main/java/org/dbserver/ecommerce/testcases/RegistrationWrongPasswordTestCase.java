package org.dbserver.ecommerce.testcases;

import org.dbserver.ecommerce.framework.Drivers;
import org.dbserver.ecommerce.framework.Report;
import org.dbserver.ecommerce.framework.ScreenShot;
import org.dbserver.ecommerce.tasks.HomeTasks;
import org.dbserver.ecommerce.tasks.AccountTasks;
import org.dbserver.ecommerce.verificationpoints.AccountVerificationPoint;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

public class RegistrationWrongPasswordTestCase {
	
	private WebDriver driver;
	
	private HomeTasks homePage; 
	private AccountTasks accountPage;
	private AccountVerificationPoint verificationPoint;
	
	@Before
	public void setUp() {
		Report.startTest("Register Fails");
		driver = Drivers.getFirefoxDriver();
		
		homePage = new HomeTasks(driver);
		accountPage = new AccountTasks(driver);
		verificationPoint = new AccountVerificationPoint(driver);
	}
	
	@Test
	public void testMain() {
		driver.get("http://demo.virtuemart.net/");
		driver.manage().window().maximize();
		
		Report.log(Status.INFO, "The website has started.", ScreenShot.capture(driver));
		
		homePage.accessRegistrationPage();
		
		Report.log(Status.INFO, "Register Page loaded.", ScreenShot.capture(driver));
		
		accountPage.fillForm("Ana Terra", "anaterra", "mascada123", "mascada1234", "ana@terra.com.br");		
		accountPage.toRegister();
		
		verificationPoint.checkPasswordFieldErrorMessage();
	}	

	@After
	public void tearDown() {
		driver.quit();
	}
}