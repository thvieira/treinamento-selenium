package org.dbserver.ecommerce.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class VerificationPoint {
	
	private static final String PASS_ERROR_MESSAGE = "The password you entered do not match.";
	
	private static boolean contains(WebDriver driver, String value){
		try {
			return driver.findElement(By.xpath("//*[contains(text(), '" + value + "')]")).isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
	
	public static boolean hasPasswordFieldErrorMessage(WebDriver driver) {
		return contains(driver, PASS_ERROR_MESSAGE);
	}
}
