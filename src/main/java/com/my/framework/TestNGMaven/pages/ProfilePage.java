package com.my.framework.TestNGMaven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.my.framework.TestNGMaven.BasePageObject;

public class ProfilePage extends BasePageObject<ProfilePage> {
	protected By editButnField = By.xpath("//button[@id='editProfile']");
	protected By advanceSearchField = By.xpath("//a[@id='advanced-search-link']");
    private By profileName = By.id("profileContactFirstName");
    
	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	public void waitForProfilePageToLoad() {
		waitForVisibilityOf(editButnField);
		waitForVisibilityOf(advanceSearchField,10);
	}
	
	public boolean IsprofileNameCorrect(String correctProfileName) {
    	if(getText(profileName).equals(correctProfileName)) {
    	   return true;
    	       	}
    	return false;
    }
}
