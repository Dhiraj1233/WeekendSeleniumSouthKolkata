package com.qsp.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MouseActionsUtility 
{
	public static void rightClick(WebDriver driver,WebElement element)
	{
		ObjectUtility.mouseActions(driver).contextClick(element).perform();
	}
	public static void doubleClick(WebDriver driver,WebElement element) 
	{
		ObjectUtility.mouseActions(driver).doubleClick(element).perform();
	}
	public static void mouseHover(WebDriver driver,WebElement element)
	{
		ObjectUtility.mouseActions(driver).moveToElement(element).perform();
	}
	public static void dragDrop(WebDriver driver,WebElement source,WebElement target)
	{
		ObjectUtility.mouseActions(driver).dragAndDrop(source, target).perform();
	}
	public static void scroll(WebDriver driver,WebElement element)
	{
		ObjectUtility.mouseActions(driver).scrollToElement(element).perform();
	}
}