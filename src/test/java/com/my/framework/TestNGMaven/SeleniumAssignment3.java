package com.my.framework.TestNGMaven;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class SeleniumAssignment3 {
     public WebDriver driver;
     public String url = "https://www.flipkart.com/";
     public List<WebElement> links;
   	
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		
		//WebDriverWait wait = new WebDriverWait(driver,30);
		/*wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		*/
//		String MainWindow = driver.getWindowHandle();
//		System.out.println(MainWindow);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	    Set<String> window_handles = driver.getWindowHandles();
//		Iterator it = window_handles.iterator();
//		while(it.hasNext()) {
//			String childWindow = (String) it.next();
//			System.out.println(childWindow);
//			if (!MainWindow.equalsIgnoreCase(childWindow)) {
//				driver.switchTo().window(MainWindow);
//			}
//		}
	}
	
	@Test
	public void numOfLinks() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
	}
	
	@Test
	public void printLink() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement link: links) {
			System.out.println(link.getText());
		}
		
	}
	
	@AfterMethod
	public void tearDown() {
	  driver.quit();	
	}
}
