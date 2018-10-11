package com.conceptsis.Stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.conceptsis.Utilities.Driver;



public class Hooks {

	
	@BeforeMethod
	public void setUp() {
		
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().fullscreen();
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.closeDriver();
	}
}
