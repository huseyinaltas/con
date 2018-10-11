package com.conceptsis.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.conceptsis.Utilities.Driver;

public class LoginPage_Pages {

private WebDriver driver;
	
		public LoginPage_Pages() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="tbxUserName")
		public WebElement username;
		
		@FindBy(id="tbxPassword")
		public WebElement password;
		
		@FindBy(id="btnSubmit")
		public WebElement submit;
		
		@FindBy(xpath="//a[@href='Login.aspx']")
		public WebElement signOut;
}
