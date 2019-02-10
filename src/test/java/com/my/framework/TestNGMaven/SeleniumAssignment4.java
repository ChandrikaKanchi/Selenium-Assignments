package com.my.framework.TestNGMaven;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class SeleniumAssignment4 {
    public WebDriver driver;
    public String url = "https://www.ebay.com/";
    
	@BeforeTest
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(url);
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	   }
	
	@Test(priority = 1)
	public void tstSearch() {
		driver.findElement(By.cssSelector("#gh-ac")).sendKeys("Apple Watches");
		Select selectCategory = new Select(driver.findElement(By.cssSelector("#gh-cat")));
		selectCategory.selectByVisibleText("Jewelry & Watches");
		driver.findElement(By.cssSelector("#gh-btn")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(priority = 2)
	public void tstPrintResult() {
		List<WebElement> resultProducts = driver.findElements(By.xpath("//div[@id='srp-river-results']//a"));
		System.out.println("Total number of Products:  " + resultProducts.size());
	}
	
    @Test(priority = 3)
    public void tstNproduct() {
    	List<WebElement> resultProducts = driver.findElements(By.xpath("//div[@id='srp-river-results']//a"));
    	int resultCount = resultProducts.size();
    	WebElement resultProduct = driver.findElement(By.xpath("//div[@id='srp-river-results']//a["+(resultCount-1)+"]"));
    	System.out.println("Nth Product Details:  "+resultProduct.getText());
    }
    
    @Test(priority = 4)
    public void printAllProducts(){
    	List<WebElement> resultProducts = driver.findElements(By.xpath("//div[@id='srp-river-results']//a"));
    	int resultCount = resultProducts.size();
    	for (WebElement product: resultProducts) {
    		System.out.println("Product Details:  " +product.getText());
    	}
    	
    	
    }
    
    /*@Test(priority = 5)
    public void scrollDownAndPrint() {
    	
    }*/
    
    @AfterTest
    public void tearDown() {
    	driver.quit();
    	
    }
}
