package com.my.framework.TestNGMaven;

import org.testng.annotations.Test;

public class FirstTest extends BaseTest{
	 
	@Test
	public void Firsttestmethod(){
	    odriver.get("https://www.dice.com");
		System.out.println("Dice Opened, Test Passed");
	}
	
	
}
    