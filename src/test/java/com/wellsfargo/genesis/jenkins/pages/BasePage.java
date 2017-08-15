package com.wellsfargo.genesis.jenkins.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wellsfargo.genesis.jenkins.utility.LocalCaches;
import com.wellsfargo.genesis.jenkins.utility.SeleniumProperties;

public class BasePage {
	private static SeleniumProperties seleniumproperties=SeleniumProperties.getInstance();

	public static WebDriver getDriver() {
		return LocalCaches.getWebDriver();
	}
	
	public static LoginPage getLoginPage() {
		return (LoginPage)LocalCaches.getPages(LoginPage.class);		
	}
	public String getSysParam(String key) {
		return seleniumproperties.getSystemParam(key);
	}
	public WebElement getByXpath(String xpath) {
		return getDriver().findElement(By.xpath(getSysParam(xpath)));
	}
	public  WebElement getByName(String name) {
		return getDriver().findElement(By.name(name));
	}
	public void clickButton(String text) {
		getByXpath(text).click();
	}
	public  void navigateTo(String URL) {
		getDriver().get(getSysParam(URL));
	}
	public void quitDriver() {
		getDriver().quit();
	}
	
}
