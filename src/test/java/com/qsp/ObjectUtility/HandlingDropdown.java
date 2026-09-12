package com.qsp.ObjectUtility;

import org.openqa.selenium.WebElement;
public class HandlingDropdown 
{
	public void selectOptions(Object value,WebElement element)
	{
		if(value instanceof Integer) {
			ObjectUtility.handleDropdown(element).selectByIndex((int) value);
		}
		else if ( value instanceof String) {
			try {
			ObjectUtility.handleDropdown(element).selectByVisibleText((String) value);
			}
			catch (Exception e)
			{
				ObjectUtility.handleDropdown(element).selectByContainsVisibleText((String)value);
			}finally 
			{
				ObjectUtility.handleDropdown(element).selectByValue((String)value);
			}
		}
		
	}
	public void deselectOptions(Object value,WebElement element)
	{
		if(value instanceof Integer)
		{
			ObjectUtility.handleDropdown(element).deselectByIndex((int)value);
		}else if(value instanceof String) {

			try {
				ObjectUtility.handleDropdown(element).deselectByValue((String)value);
			} catch (Exception e) {
				ObjectUtility.handleDropdown(element).deSelectByContainsVisibleText((String)value);
			}
			finally {
				ObjectUtility.handleDropdown(element).deselectByVisibleText((String)value);
			}
		}
		else if(value.equals(null)) {
			ObjectUtility.handleDropdown(element).deselectAll();
		}
		
	}
}