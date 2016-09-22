package org.dbserver.ecommerce.tasks;

import org.dbserver.ecommerce.appobjects.UserRegistrationAppObject;
import org.openqa.selenium.WebDriver;

public class UserRegistrationTasks {
	
	private UserRegistrationAppObject registration;
	
	public UserRegistrationTasks(WebDriver driver){
		this.registration = new UserRegistrationAppObject(driver);
	}
	
	public void fillForm(String name, String userName, String password, String confirmPassword, String email, String confirmEmail){
		registration.getNameTextField().sendKeys(name);
		registration.getUsernameTextField().sendKeys(userName);
		registration.getPasswordTextField().sendKeys(password);
		registration.getConfirmPasswordTextField().sendKeys(confirmPassword);
		registration.getEmailTextField().sendKeys(email);
		registration.getConfirmEmailTextField().sendKeys(confirmEmail);
	}
	
	public void toRegister(){
		registration.getRegisterButton().click();
	}
}
