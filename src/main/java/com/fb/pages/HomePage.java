package com.fb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.base.Base;

public class HomePage extends Base {
	
	@FindBy(xpath="//a[@aria-label='Friends']")
	WebElement friendsLink;
	
	@FindBy(xpath="//a[@aria-label='Groups']")  
	WebElement groupsLink;
	
	@FindBy(xpath="//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6']")								  
	WebElement profileLink;
	 
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public FriendsPage clickOnFriendsLink () {
		friendsLink.click();
		return new FriendsPage();
	}
	
	public GroupsPage clickOnGroupsLink () {
		groupsLink.click();
		return new GroupsPage();
	}
	
	public ProfilePage clickOnProfileLink () {
		profileLink.click();
		return new ProfilePage();
	}
	
}
