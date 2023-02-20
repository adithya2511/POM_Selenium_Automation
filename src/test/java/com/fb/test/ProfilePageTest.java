package com.fb.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fb.base.Base;
import com.fb.pages.FriendsPage;
import com.fb.pages.HomePage;
import com.fb.pages.LoginPage;
import com.fb.pages.ProfilePage;
  
public class ProfilePageTest extends Base {
	HomePage homePage;
	LoginPage loginPage;
	ProfilePage profilePage;
	
	public ProfilePageTest () {
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();	
		profilePage = new ProfilePage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		profilePage = homePage.clickOnProfileLink();
	}
	
	@Test(priority=1)
	public void verifyProfilePageTitleTest() throws InterruptedException {
		boolean profilePageTitle = profilePage.verifyProfilePageTitle();
		Assert.assertTrue(profilePageTitle);
	}
	
	@Test(priority=2)
	public void verifyAddStoryTest ()  {
		 profilePage.verifyUploadStory(prop.getProperty("StoryName"));
	}
}
