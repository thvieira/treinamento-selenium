package org.dbserver.ecommerce.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserUtils {
	public static WebDriver MozillaFirefoxDriver(){
		return new FirefoxDriver();
	}
	
	public static WebDriver InternetExplorerDriver(){
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir").toString() + "/drivers/IEDriverServer.exe");
		return new InternetExplorerDriver();
	}
	
	public static WebDriver ChromeDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").toString() + "/drivers/chromedriver.exe");
		return new ChromeDriver();
	}
}