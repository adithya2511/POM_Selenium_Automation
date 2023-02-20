package com.fb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.base.Base;

public class LoginPage extends Base {

	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath="//div[contains(@class,'x6s0dn4 x9f61')]")
	WebElement facbookLogo;
	 
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}
	public  boolean logoIsDisplayed(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		boolean logo = facbookLogo.isDisplayed();
		return logo;
	}
	
}
