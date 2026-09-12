package com.qsp.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility
{
	public static void visibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = ObjectUtility.webdriverutility(driver);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void clickableEle(WebDriver driver,WebElement element) 
	{
		WebDriverWait wait = ObjectUtility.webdriverutility(driver);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}