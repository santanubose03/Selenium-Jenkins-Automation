package com.wellsfargo.genesis.jenkins.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
glue= {"src/test/java/com/wellsfargo/genesis/jenkins/scenarios"},
format = {"pretty", "html:target/cucumber-report/search"} )
public class LoginRunner {
 
	
}
