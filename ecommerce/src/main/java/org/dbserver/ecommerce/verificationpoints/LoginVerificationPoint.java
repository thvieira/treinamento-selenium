package org.dbserver.ecommerce.verificationpoints;

import org.dbserver.ecommerce.framework.Report;
import org.dbserver.ecommerce.framework.ScreenShot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

public class LoginVerificationPoint {
	
	private static final String INVALID_LOGIN_MESSAGE = "Username and password do not match or you do not have an account yet.";
	
	private WebDriver driver;
	
	public LoginVerificationPoint(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkInvalidLoginMessage() {
		if(this.pageContains(INVALID_LOGIN_MESSAGE)) {
			Report.log(Status.PASS, "Mensagem exibida corretamente.", ScreenShot.capture(driver));
		} else {
			Report.log(Status.FAIL, "Mensagem nao exibida conforme esperado.", ScreenShot.capture(driver));
		}
	}

	private boolean pageContains(String text){
		return this.driver.getPageSource().contains(text);
	}
	
}
