package com.my.framework.TestNGMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumAssignment1 {
	
	public WebDriver driver;
	public String url1 = "https://www.freecrm.com/";
	public String url2 = "https://www.facebook.com/";
	
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(url1);
		
	}
	
	@Test(priority = 1)
	public void tstPageTitle() {
		String actualTitle = driver.getTitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals("Free CRM software in the cloud for sales and service", actualTitle);
	}
	
	@Test(priority = 2)
	public void tstNavigatePage() {
		driver.navigate().to(url2);
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
	    driver.navigate().forward();
	    driver.navigate().to(url1);
	}
	
  
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
