package com.my.framework.TestNGMaven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.my.framework.TestNGMaven.BasePageObject;

public class LoginPage extends BasePageObject<LoginPage>{
	private static final String URL = "https://www.dice.com/dashboard/login";
	private By emailField = By.xpath("//input[@id='email']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By signInButton=By.xpath("//button[@type='submit']");
    private By errorMessage=By.xpath("//span[@data-automation-id='login-failure-help-message']");

    
	public LoginPage(WebDriver odriver) {
		super(odriver);
	}
	public void openLoginPage() {
		getPage(URL);
	}
	
	public void fillupEmailandPassword(String email, String password) {
		type(email,emailField);
		type(password,passwordField);
	}
	
	
	public ProfilePage pushSignin() {
		click(signInButton);
		return new ProfilePage(odriver);
	}
	public String getLoginErrorMessage() {
		return getText(errorMessage);
		
	}
    	
    
}
