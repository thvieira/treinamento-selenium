package org.dbserver.ecommerce.tasks;

import org.dbserver.ecommerce.appobjects.AccountAppObject;
import org.openqa.selenium.WebDriver;

public class AccountTasks {
	
	private AccountAppObject appObjects;
	
	public AccountTasks(WebDriver driver){
		this.appObjects = new AccountAppObject(driver);
	}
	
	public void fillForm(String name, String userName, String password, String confirmPassword, String email){
		appObjects.getNameTextField().sendKeys(name);
		appObjects.getUsernameTextField().sendKeys(userName);
		appObjects.getPasswordTextField().sendKeys(password);
		appObjects.getConfirmPasswordTextField().sendKeys(confirmPassword);
		appObjects.getEmailTextField().sendKeys(email);
	}
	
	public void toRegister(){
		appObjects.getRegisterButton().click();
	}
}
