package org.dbserver.ecommerce.framework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public static String capture(WebDriver driver) {
	    String path;
	    
	    try {
	        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        path = "./reports/screenshots/" + source.getName();
	        FileUtils.copyFile(source, new File(path)); 
	    } catch(IOException e) {
	        path = "Failed to capture screenshot: " + e.getMessage();
	    }
	    return path.replace("./reports/", "");
	}
}
