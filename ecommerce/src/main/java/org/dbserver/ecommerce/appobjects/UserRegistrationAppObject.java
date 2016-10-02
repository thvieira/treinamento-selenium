package org.dbserver.ecommerce.appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Classe para mapeamento dos objetos da página de registro de usuários.
 */
public class UserRegistrationAppObject {
	private WebDriver driver;
	
	public UserRegistrationAppObject(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getNameTextField(){
		return driver.findElement(By.id("jform_name"));
	}	

	public WebElement getUsernameTextField(){		
		return driver.findElement(By.id("jform_username"));
	}

	public WebElement getPasswordTextField(){		
		return driver.findElement(By.id("jform_password1"));
	}
	
	public WebElement getConfirmPasswordTextField(){		
		return driver.findElement(By.id("jform_password2"));
	}
	
	public WebElement getEmailTextField(){		
		return driver.findElement(By.id("jform_email1"));
	}
	
	public WebElement getConfirmEmailTextField(){		
		return driver.findElement(By.id("jform_email2"));
	}
	
	public WebElement getRegisterButton(){
		return driver.findElement(By.xpath("//*[@type = 'submit' and text() = 'Register']"));
	}
}