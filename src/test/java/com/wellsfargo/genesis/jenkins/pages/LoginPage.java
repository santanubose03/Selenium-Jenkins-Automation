package com.wellsfargo.genesis.jenkins.pages;

public class LoginPage extends BasePage{
    
	private String J_USERNAME="j_username";
	private String J_PASSWORD="j_password";
	
	public void login() {
		getByName(J_USERNAME);
		getByName(J_PASSWORD);
		
	}
	public void clickLoginButton() {
      clickButton("XPATH_LOGIN_BUTTON");
	}
	
	public void logout() {
		try{
			getByXpath("XPATH_LOGOUT_LINK").click();
		}
		finally {
			quitDriver();
		}
	}
}
