package com.my.framework.TestNGMaven;

import org.testng.annotations.Test;

import org.testng.Assert;

import com.my.framework.TestNGMaven.pages.LoginPage;
import com.my.framework.TestNGMaven.pages.ProfilePage;

public class LoginTest extends BaseTest {

	@Test
		public void positiveLoginTest() {
			LoginPage loginPage = new LoginPage(odriver);
			String expectedPageTitle = "Seeker Dashboard - Profile";
			String correctProfileName = "Chandrika";
			loginPage.openLoginPage();
			loginPage.fillupEmailandPassword("chandrika.kanchi@gmail.com", "Ciber@12345");
			ProfilePage profilepage = loginPage.pushSignin();
			profilepage.waitForProfilePageToLoad();
			String actualTitle = profilepage.getTitle();
			
			Assert.assertTrue(expectedPageTitle.equals(actualTitle), 
					"Page title is not expected.\nExpected:" +expectedPageTitle + "/nActual:" +actualTitle);
		
			
			Assert.assertTrue(profilepage.IsprofileNameCorrect(correctProfileName), "Profile Page is not as Expected");
			
		//Verifications
		//Verify title of the page is correct
		//Verify correct name on profile page
			
		
		}

		@Test
		public void nagativeLoginTest() {
			LoginPage loginPage = new LoginPage(odriver);
			String expectedErrorMessage = "Email and/or password incorrect";
	
			loginPage.openLoginPage();
			loginPage.fillupEmailandPassword("incorrect.kanchi@gmail.com", "Ciber@12345");
			loginPage.pushSignin();
			String actualErrorMessage = loginPage.getLoginErrorMessage();
			System.out.println(expectedErrorMessage);
			System.out.println(actualErrorMessage);
			Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), 
					"Error Message is not as expected.\nExpected:" +expectedErrorMessage + "\nActual:" +actualErrorMessage);
	
	}
}





