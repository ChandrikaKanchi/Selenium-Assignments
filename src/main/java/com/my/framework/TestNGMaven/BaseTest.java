package com.my.framework.TestNGMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;


public class BaseTest{
	 protected WebDriver odriver;
        @BeforeTest
	    public void methodSetUp() {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			 odriver = new ChromeDriver();
		}
	    
        @AfterMethod
	    public void methodTearDown() {
	    	odriver.quit();
	    }
	
}
