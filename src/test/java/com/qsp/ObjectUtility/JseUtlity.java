package com.qsp.ObjectUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class JseUtlity {

	public void passData(WebDriver driver,WebElement element,String data)
	{
		JavascriptExecutor jse = ObjectUtility.javaScriptActions(driver);
		jse.executeScript("arguments[0].value='"+data+"'", element);
	}
	public void clearData(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse=ObjectUtility.javaScriptActions(driver);
		jse.executeScript("arguments[0].value=''", element);
	}
	public void scrollIntoView(WebDriver driver,WebElement element) 
	{
		JavascriptExecutor jse=ObjectUtility.javaScriptActions(driver);
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	public void scrollBottomPage(WebDriver driver)
	{
		JavascriptExecutor jse=ObjectUtility.javaScriptActions(driver);
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
	}
	public void scrollTopPage(WebDriver driver)
	{
		JavascriptExecutor jse=ObjectUtility.javaScriptActions(driver);
		jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}	
}
