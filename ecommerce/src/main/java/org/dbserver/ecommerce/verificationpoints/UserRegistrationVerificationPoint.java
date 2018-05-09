package org.dbserver.ecommerce.verificationpoints;

import org.dbserver.ecommerce.framework.Report;
import org.dbserver.ecommerce.framework.ScreenShot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

public class UserRegistrationVerificationPoint {
	
	private static final String PASSWORD_ERROR_MESSAGE = "The password you entered do not match.";
	
	private WebDriver driver;
	
	public UserRegistrationVerificationPoint(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkPasswordFieldErrorMessage() {
		if(this.pageContains(PASSWORD_ERROR_MESSAGE)) {
			Report.log(Status.PASS, "A mensagem de erro foi exibida corretamente.", ScreenShot.capture(driver));
		} else {
			Report.log(Status.FAIL, "A mensagem de erro nao foi exibida conforme esperado.", ScreenShot.capture(driver));
		}
	}

	private boolean pageContains(String text){
		return this.driver.getPageSource().contains(text);
	}
	
}
