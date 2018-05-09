package org.dbserver.ecommerce.testcases;

import org.dbserver.ecommerce.framework.Drivers;
import org.dbserver.ecommerce.framework.Report;
import org.dbserver.ecommerce.framework.ScreenShot;
import org.dbserver.ecommerce.tasks.HomeTasks;
import org.dbserver.ecommerce.verificationpoints.LoginVerificationPoint;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

public class LoginTestCase {
	
	private WebDriver driver;
	
	private HomeTasks homePage;
	private LoginVerificationPoint verificationPoint;
	
	@Before
	public void setUp() {
		Report.startTest("Login");
		driver = Drivers.getFirefoxDriver();
		
		homePage = new HomeTasks(driver);
		verificationPoint = new LoginVerificationPoint(driver);
	}
	
	@Test
	public void testMain() {
		driver.get("http://demo.virtuemart.net/");
		driver.manage().window().maximize();
		
		Report.log(Status.INFO, "The website was loaded.", ScreenShot.capture(driver));
		
		homePage.login("invalid", "invalid");
		
		Report.log(Status.INFO, "Dados inseridos no formulario.", ScreenShot.capture(driver));

		verificationPoint.checkInvalidLoginMessage();
	}	

	@After
	public void tearDown() {
		driver.quit();
	}
}