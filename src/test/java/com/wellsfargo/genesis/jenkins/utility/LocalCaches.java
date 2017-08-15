package com.wellsfargo.genesis.jenkins.utility;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.wellsfargo.genesis.jenkins.pages.BasePage;

public class LocalCaches {
	private static SeleniumProperties seleniumproperties=SeleniumProperties.getInstance();
	private static ThreadLocal<WebDriver>webDriver=new ThreadLocal<WebDriver>() {
		public WebDriver initialValue() {
			return initBrowser();
		}
	};
	private static ThreadLocal<Map<String,BasePage>> apppages=new ThreadLocal<Map<String,BasePage>> (){
		public Map<String, BasePage> initialValue(){
			return new HashMap<String, BasePage>();
		}
	};
	public static WebDriver getWebDriver() {
		return  webDriver.get();
	}
    
    public static BasePage getPages(Class classobj) {
	  BasePage page=apppages.get().get(classobj.getCanonicalName());
	  if(page==null && BasePage.class.isAssignableFrom(classobj)) {
		 try {
			 page=(BasePage) classobj.newInstance();
		 }catch(InstantiationException e) {
			 e.printStackTrace();
		 } catch (IllegalAccessException e) {
				
				e.printStackTrace();
			}
	 }
	 return page;
 }
    public static WebDriver initBrowser() {
	  System.getProperty("webdriver.chrome.driver",seleniumproperties.getSystemParam("chromepath"));
	  WebDriver driver=new ChromeDriver();
	  return driver;
  }
  
}
