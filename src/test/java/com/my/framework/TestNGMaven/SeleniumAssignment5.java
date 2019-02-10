package com.my.framework.TestNGMaven;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumAssignment5 {
	public WebDriver driver;
	public String url = "http://www.snapdeal.com";
    
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void signInSnapDeal() throws InterruptedException {
		WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign In']"));
		WebElement Login = driver.findElement(By.xpath("//a[text()='login']"));

	    
		Actions action = new Actions(driver);
		Action seriesOfAction = action.clickAndHold(signIn).moveToElement(Login).click().build();
		seriesOfAction.perform();
		
	  /*  WebDriverWait wait = new WebDriverWait(driver,20);
	    WebElement frameLocator = driver.findElement(By.name("loginIframe"));
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));*/
	   
		driver.switchTo().frame("loginIframe");
        driver.findElement(By.id("userName")).sendKeys("9739315858");
        driver.findElement(By.xpath("//button[text()='continue']")).click();
	}		
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
