package com.my.framework.TestNGMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumAssignment6 {
	WebDriver driver;
	
	
  @BeforeTest
  public void OpenBrowser() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://www.google.co.in/");
 }
  
  @Test
  public void tstLoginGmail() throws InterruptedException {
	   
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//a[text()='Gmail']")).click();
	   driver.findElement(By.id("identifierId")).sendKeys("chandrika.kanchi");
	   driver.findElement(By.xpath("//span[text()='Next']")).click();
	   driver.findElement(By.xpath("//a[text()='Sign In']")).click();
	   //driver.findElement(By.xpath("//a[text()='Gmail']")).click();
	   //driver.findElement(By.xpath("//input[@type='email']")).sendKeys("chandrika.kanchi");
	   //driver.findElement(By.xpath("//span[text()='Next']")).click();
	   
     driver.navigate().refresh();
       
       
	   driver.findElement(By.xpath("//input[@type='password']")).sendKeys("shukriya");
	   driver.findElement(By.xpath("//span[text()='Next']")).click();
	   String nextPage = driver.getWindowHandles().toArray()[1].toString();
	   driver.switchTo().window(nextPage);
	   
	   driver.findElement(By.id("smsauth-interstitial-remindbutton")).click();
  }
  
  @Test
  public void sendEmail() {
	  
  }
  
  @Test
  public void refreshInbox() {
	  
  }
  
  @Test
  public void countOfEmail() {
	  
  }
  
  @Test
  public void senderOfLastEmail() {
	  
  }
  
  @AfterTest
  public void logOutEmailAndCloseBrowser() {
	  
  }
}
