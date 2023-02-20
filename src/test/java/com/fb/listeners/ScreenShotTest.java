package com.fb.listeners;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fb.base.Base;
import com.fb.pages.LoginPage;
@Listeners(com.fb.listeners.Listeners.class)
public class ScreenShotTest extends Base {
	LoginPage loginPage;
	@BeforeMethod
	public void setup () {
		initialization();
		loginPage = new LoginPage();
	}
	@Test
	public void loginPageTitleTest(){
		String loginPageTitle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up","HomePageTitle not match");
	}
}
