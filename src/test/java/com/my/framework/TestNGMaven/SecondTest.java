package com.my.framework.TestNGMaven;

import org.testng.annotations.Test;

public class SecondTest extends BaseTest {
	@Test
	public void Secondtestmethod() {
		odriver.get("https://in.linkedin.com");
		System.out.println("Dice Opened, Test Passed");
	}
}
