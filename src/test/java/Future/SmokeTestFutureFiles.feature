Feature: Smoke Test
	@smoketest
  Scenario: Login Functionality
    
    Given The user is on the page "url"
    When I send the credantials to the Application
    And I should be able to login to the page
    And if the login functionality fails
    Then send an email to the admin
