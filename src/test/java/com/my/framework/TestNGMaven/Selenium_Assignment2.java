package com.my.framework.TestNGMaven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium_Assignment2 {
	public WebDriver driver;
	public static Properties prop;
	
	@BeforeTest
	public void readProperties() throws IOException {
		prop = new Properties();
		File file = new File("C:\\Users\\SUDHA KANCHI\\eclipse-workspace\\TestNGMaven\\src\\test\\java\\com\\my\\framework\\TestNGMaven\\Assignment.properties");
		FileInputStream ip = null;
		ip = new FileInputStream(file);
	   
	    prop.load(ip);
	    System.out.println(prop.entrySet());
	    System.out.println(prop.getProperty("url"));
	    
	}
	
   @BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	  }
	
//	@Test(priority = 2)
//	public void tstCurrentPage() {
//		String actualUrl = driver.getCurrentUrl();
//		Assert.assertEquals(actualUrl, prop.getProperty("url"));
//	}
	
	@Test(priority = 3)
	public void tstcreateAccount() {
		WebElement firstName = driver.findElement(By.xpath(prop.getProperty("firstNamePath")));
		WebElement lastName = driver.findElement(By.xpath(prop.getProperty("lastNamePath")));
		WebElement emailAddress = driver.findElement(By.xpath(prop.getProperty("emailAddressPath")));
		WebElement newPassword = driver.findElement(By.xpath(prop.getProperty("newPasswordPath")));
		WebElement Birthday = driver.findElement(By.xpath(prop.getProperty("birthday_Path")));
		WebElement BirthMonth = driver.findElement(By.xpath(prop.getProperty("birthmonth_Path")));
		WebElement BirthYear = driver.findElement(By.xpath(prop.getProperty("birthyear_Path")));
		WebElement sex_button = driver.findElement(By.xpath(prop.getProperty("sex_button")));
		WebElement submit_button = driver.findElement(By.xpath(prop.getProperty("submit_button")));
		
		firstName.sendKeys(prop.getProperty("FirstNameValue"));
		lastName.sendKeys(prop.getProperty("lastNameValue"));
		emailAddress.sendKeys(prop.getProperty("emailAddressValue"));
		newPassword.sendKeys(prop.getProperty("newPasswordValue"));
		
		Select selectDay = new Select(Birthday);
		selectDay.selectByVisibleText(prop.getProperty("birthday_Value"));
		
		
		Select selectMonth = new Select(BirthMonth);
		selectMonth.selectByVisibleText(prop.getProperty("birthmonth_Value"));
		
		Select selectYear = new Select(BirthYear);
		selectYear.selectByVisibleText(prop.getProperty("birthyear_Value"));
		
		sex_button.click();
		
		submit_button.click();
		
	}
    
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
