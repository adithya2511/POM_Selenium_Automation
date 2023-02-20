package com.fb.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fb.base.Base;
import com.fb.pages.LoginPage;
import com.fb.utilities.LoginPageUtility;

public class LoginPageDataTest extends Base {
	public String sheetName = "Sheet1";
	LoginPage loginPage;
	LoginPageUtility loginPageUtility;
	
	public LoginPageDataTest () {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		loginPageUtility = new LoginPageUtility();
	}
	 
	@Test(priority =1)
	 public void loginTest () {
		 loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	 }

	@DataProvider
	public  Object [ ] [ ] getLoginTestData () {
		  Object data [ ] [ ]  = LoginPageUtility.getTestData(sheetName);
		  return data;
	}
	
	@Test(dataProvider = "getLoginTestData", priority =2)
	public void multipleUsersLoginTest (String uname, String pass) {
		loginPage.login(uname, pass);
	}
}