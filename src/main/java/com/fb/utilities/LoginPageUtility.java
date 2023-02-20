package com.fb.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import com.fb.base.Base;

public class LoginPageUtility extends Base {

	public WebDriver driver;
	public Properties prop;
	
	public static  Workbook book;
	public static Sheet sheet;
	
	public static String testDataPath = "C:\\Users\\devik\\eclipse-workspace\\PomTestAutomation\\src\\main\\java\\com\\fb\\data\\scenarios.xlsx";
	public static Object [ ] [ ] getTestData (String sheetName) {
		FileInputStream file = null;
		
		try {
			file =  new FileInputStream(testDataPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		
		sheet =book.getSheet(sheetName);
		Object [ ] [ ] data = new Object[sheet.getLastRowNum()] [sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum();  i++) {
			for(int j = 0; j < sheet.getRow(0).getLastCellNum();  j++) {
			 data [i] [j] = sheet.getRow(i + 1).getCell(j).toString();
		 }
	 }
	 return data;
	}
}
