package com.conceptsis.Stepdefinitions;

import static org.testng.Assert.assertEquals;
import org.apache.commons.mail.EmailException;

import com.conceptsis.Pages.LoginPage_Pages;
import com.conceptsis.Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage_StepDefinitions {
	
	LoginPage_Pages login= new LoginPage_Pages();
	
	
	@Given("^The user is on the page \"([^\"]*)\"$")
	public void the_user_is_on_the_page(String arg1) {
	   Driver.getDriver().get("https://grades.es.gsastl.org/Login.aspx?reason=Inactivity&page=%2fDashboard.aspx");
	  
	}

	@When("^I send the credantials to the Application$")
	public void i_send_the_credantials_to_the_Application() {
		   login.username.sendKeys("selami");
		   login.password.sendKeys("212252Sc");
		   login.submit.click();
	}

	@When("^I should be able to login to the page$")
	public void i_should_be_able_to_login_to_the_page() throws EmailException {
	   
		
		try{
				String url=Driver.getDriver().getCurrentUrl();
				String expectedUrl="https://grades.es.gsastl.org/Dashboard.aspx";
				assertEquals(url,expectedUrl);
				
		}catch(AssertionError ae){
			 Driver drv= new Driver();
			    drv.sendEmail();
			    throw ae;
		}
	    
	  }

	@When("^if the login functionality fails$")
	public void if_the_login_functionality_fails() {
		
		login.signOut.click();
	}

	@Then("^send an email to the admin$")
	public void send_an_email_to_the_admin() {
	   
	}

}