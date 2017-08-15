package com.wellsfargo.genesis.jenkins.scenarios;

import com.wellsfargo.genesis.jenkins.pages.BasePage;
import com.wellsfargo.genesis.jenkins.pages.LoginPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginScenario {
     
	private LoginPage loginpage;
	
	@Before("@login")
	 public void setup() {
		loginpage=BasePage.getLoginPage();
	}
	
	
	@Given("^user go to login page$")
	public void userGoToLoginPage() throws Throwable {
		loginpage.navigateTo("URL");
		
	}
	@And("^enter username and password$")
	public void enterCredentials() throws Throwable  {
		loginpage.login();
	}
	@And("^click on login button$")
	public void clickLoginButton() throws Throwable {
		loginpage.clickLoginButton();
	}
	@Then("^user should be logged in into jenkins$")
	public void logoutExists() throws Throwable {
		loginpage.logout();
	}
	
}
