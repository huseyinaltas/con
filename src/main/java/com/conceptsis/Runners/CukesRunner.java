package com.conceptsis.Runners;
import org.junit.runner.RunWith;



import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			plugin = {"pretty", 
					"html:target/cucumber-report",
					"json:target/cucumber.json"
			},
			tags = "@smoketest",
			features= "src/test/java/Future/",
			glue= "com/conceptsis/Stepdefinitions/",
			dryRun=false
	)

public class CukesRunner extends AbstractTestNGCucumberTests{

} 