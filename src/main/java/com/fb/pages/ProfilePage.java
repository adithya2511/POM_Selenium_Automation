package com.fb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.base.Base;

public class ProfilePage extends Base{

	@FindBy(linkText="Adithya Veldandi")
	WebElement profileTitle;
	
	@FindBy(xpath="//a[@aria-label='Add to Story']")
	WebElement addStory;
	
	@FindBy(xpath="//div[@class = 'x6s0dn4 x1ey2m1c x78zum5 xds687c xdt5ytf xl56j7k x10l6tqk x17qophe x13vifvy']")
	WebElement createStory;
	
	@FindBy(xpath="//label[contains(@aria-label,'Start typing')]")
	WebElement textHere;
	
	@FindBy(xpath = "//div[@aria-label='Share to Story']")
	WebElement shareButton;
	 
	public ProfilePage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyProfilePageTitle() {
		boolean title = profileTitle.isDisplayed();
		return title;
	}
	
	public void verifyUploadStory (String a) {
		addStory.click();
		createStory.click();
		textHere.sendKeys(a);
		shareButton.click();
	}
}
