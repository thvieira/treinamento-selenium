package org.dbserver.ecommerce.appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Classe para mapeamento dos objetos da página inicial.
 */
public class HomeAppObject {	
	private WebDriver driver;
	
	public HomeAppObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCreateAccountButton() {
		return driver.findElement(By.xpath("//*[contains(text(), 'Create an account')]"));
	}
}