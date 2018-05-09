package org.dbserver.ecommerce.testcases;

import org.dbserver.ecommerce.framework.Drivers;
import org.dbserver.ecommerce.framework.Report;
import org.dbserver.ecommerce.framework.ScreenShot;
import org.dbserver.ecommerce.tasks.HomeTasks;
import org.dbserver.ecommerce.tasks.UserRegistrationTasks;
import org.dbserver.ecommerce.verificationpoints.UserRegistrationVerificationPoint;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

public class RegistrationWrongPasswordTestCase {
	
	public WebDriver driver;
	
	private HomeTasks homePage; 
	private UserRegistrationTasks userRegistrationPage;
	private UserRegistrationVerificationPoint verificationPoint;
	
	@Before
	public void setUp() {
		this.driver = Drivers.getFirefoxDriver();
		
		this.homePage = new HomeTasks(driver);
		this.userRegistrationPage = new UserRegistrationTasks(driver);
		this.verificationPoint = new UserRegistrationVerificationPoint(driver);
	}
	
	@Test
	public void testMain() {
		driver.get("http://demo.virtuemart.net/");
		driver.manage().window().maximize();
		
		Report.log(Status.INFO, "The website has started.", ScreenShot.capture(driver));
		
		homePage.accessRegistrationPage();
		
		Report.log(Status.INFO, "Register Page loaded.", ScreenShot.capture(driver));
		
		userRegistrationPage.fillForm("Ana Terra", "anaterra", "mascada123", "mascada1234", "ana@terra.com.br", "ana@terra.com.br");		
		userRegistrationPage.toRegister();
		
		verificationPoint.checkPasswordFieldErrorMessage();
	}	

	@AfterClass
	public static void tearDownTest() {
		Report.close();
	}
}