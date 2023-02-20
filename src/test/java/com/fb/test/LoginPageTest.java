package com.fb.test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.base.Base;
import com.fb.pages.HomePage;
import com.fb.pages.LoginPage;

public class LoginPageTest  extends Base {
	LoginPage loginPage;
	HomePage homePage;
 
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String loginPageTitle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up","HomePageTitle not match");
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException{
	boolean messeage = loginPage.logoIsDisplayed(prop.getProperty("username"), prop.getProperty("password"));
	Assert.assertTrue(messeage);
	}
	
	@AfterMethod
	public void closeBrowser(){
//		driver.quit();
	}
	
}
