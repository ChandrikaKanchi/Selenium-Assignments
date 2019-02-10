package com.my.framework.TestNGMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject <T>{
	protected WebDriver odriver;
	protected WebDriverWait wait;
	
	protected BasePageObject(WebDriver driver) {
		this.odriver = driver;
		wait = new WebDriverWait(odriver,40);
	}
	
	protected T getPage(String url) {
		odriver.get(url);
		return (T) this;
	}
	
	protected void type(String text, By element) {
		find(element).sendKeys(text);
	}
	
	protected void waitForVisibilityOf (By Locator, Integer...timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(Locator),(timeOutInSeconds.length > 0 ? timeOutInSeconds[0]:null));
			    break;
			}catch (StaleElementReferenceException e) {
     	}
			attempts++;
		}
				
	}
	
	private void waitFor(ExpectedCondition<WebElement> condition,Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds!=null?timeOutInSeconds :30;
		WebDriverWait Wait = new WebDriverWait(odriver,timeOutInSeconds);
		wait.until(condition);
	
	}
	public void click(By element) {
		find(element).click();
	}

	public WebElement find(By element) {
		return odriver.findElement(element);
	}
		
	public String getTitle() {
		return odriver.getTitle();
	}
	
	public String getText(By element) {
		return find(element).getText();
	}
}
