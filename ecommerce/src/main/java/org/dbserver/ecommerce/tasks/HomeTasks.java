package org.dbserver.ecommerce.tasks;

import org.dbserver.ecommerce.appobjects.HomeAppObject;
import org.openqa.selenium.WebDriver;

public class HomeTasks {
	private HomeAppObject home;
	
	public HomeTasks(WebDriver driver){
		this.home = new HomeAppObject(driver);
	}
	
	public void accessRegistrationPage(){
		home.getAccountButton().click();
	}
	
	public void login(String username, String password) {
		home.getUsernameTextField().sendKeys(username);
		home.getPasswordTextField().sendKeys(password);
		home.getLoginButton().click();
	}
	
	public void logout() {
		home.getLoginButton().click();
	}
}
