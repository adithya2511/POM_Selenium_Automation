package com.fb.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.fb.base.Base;

public class Utility extends Base {
	
	public void failedTestCase(String fileName) {
		TakesScreenshot ss = (TakesScreenshot)driver;
		File sourceFile = ss.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("C:\\Users\\devik\\eclipse-workspace\\Listener_Selenium\\FB_ScreenShots\\" + fileName +".png");
		try {
			FileHandler.copy(sourceFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
