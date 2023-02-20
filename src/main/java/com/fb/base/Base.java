package com.fb.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {
	public static Logger log =Logger.getLogger(Base.class); 
	public static WebDriver driver;
	public static Properties prop;
	
	public ExtentReports extent = new ExtentReports();
	public  ExtentSparkReporter spark = new ExtentSparkReporter("file:///C:/Users/devik/eclipse-workspace/POMTestAutomation/test-output/ExtentReport.html");

	public Base ()   {
		try {
			prop = new Properties();
			FileInputStream ips = new FileInputStream("C:\\Users\\devik\\eclipse-workspace\\PomTestAutomation\\src\\main\\java\\"
					+ "com\\fb\\configurations\\configurations.properties");	
			prop.load(ips);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	public void  initialization(){
		log.info("Browser name " +prop.getProperty("browser"));
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\devik\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");	
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options); 
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("url name "+ prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
	}
}
