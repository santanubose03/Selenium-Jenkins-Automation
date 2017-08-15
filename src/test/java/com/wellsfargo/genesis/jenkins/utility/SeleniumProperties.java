package com.wellsfargo.genesis.jenkins.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SeleniumProperties {
	private static SeleniumProperties instance=null;
	private Properties sysProps=null;
	private Properties xpathProps=null;
	
	private SeleniumProperties() {
		loadProperties();
	} 
	private void loadProperties() {
		sysProps=loadTestProps("sysParam.properties");
		xpathProps=loadTestProps("xpathParam.properties");
		
	}
	private Properties loadTestProps(String file) {
		Properties properties=new Properties();
		try {
			InputStream is=getClass().getClassLoader().getResourceAsStream(file);
			properties.load(is);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	public static SeleniumProperties getInstance() {
		if (instance==null) {
			synchronized (SeleniumProperties.class) {
				instance=new SeleniumProperties();
			}
		}
		return instance;
	}
	public String getSystemParam(String key) {
		String value=(String)sysProps.get(key);
		return value;
	}
	public String getXpathParam(String key) {
		return (String)xpathProps.get(key);
	}

}
