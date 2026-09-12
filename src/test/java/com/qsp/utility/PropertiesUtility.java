package com.qsp.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.qsp.BasePage.FrameworkConstant;

public class PropertiesUtility implements FrameworkConstant
{
	public String getData(String value) throws IOException {
		
		FileInputStream fis = new FileInputStream(propertyUrl);
		Properties pro = new Properties();
		pro.load(fis);
		String data=pro.getProperty(value);
		return data;
	}
}
