package com.fb.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.base.Base;
import com.fb.pages.FriendsPage;
import com.fb.pages.GroupsPage;
import com.fb.pages.HomePage;
import com.fb.pages.LoginPage;
import com.fb.pages.ProfilePage;

public class HomePageTest extends Base {
	LoginPage loginPage;
	HomePage homePage;
	FriendsPage friendsPage;
	ProfilePage profilePage;
	GroupsPage groupsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		profilePage = new ProfilePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle(); 
		Assert.assertEquals(homePageTitle, "Facebook","HomePageTitle not match");
	}
	
	@Test(priority=2)
	public void verifyFriendsLinkTest () {
		homePage.clickOnFriendsLink();
	}
	
	@Test(priority=3)
	public void verifyGroupsLinkTest () {
		groupsPage = homePage.clickOnGroupsLink();
	}
	
	@Test(priority=4)
	public void verifyProfilePageTest () {
		 profilePage =homePage.clickOnProfileLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
