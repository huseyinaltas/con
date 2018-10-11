package com.conceptsis.Utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



import io.github.bonigarcia.wdm.WebDriverManager;


public class Driver {
	
	public Driver() {}
	
	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			switch (ConfigurationReader.getProperty("browser")) {
			
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			default:
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	public void sendEmail() throws EmailException {
		
		Email email= new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("selami3448@gmail.com","212252sc" ));
		email.setSSLOnConnect(true);
		email.setFrom("scelepoglu@gsastl.org");
		email.setSubject("Smoke Test Report");
		email.setMsg("This is a test message");
		//email.addTo("muzunel@conceptschools.org");
		email.addTo("selamicelepoglu11@gmail.com");
		email.send();
		
		
	}
}


