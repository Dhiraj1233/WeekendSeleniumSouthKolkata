package com.qsp.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePage
{
	@FindBy(xpath = "//ul[@class=\"nav navbar-nav\"]/li[1]")
	private WebElement verifyHome;

	@FindBy(xpath = "//ul[@class=\"nav navbar-nav\"]/li[4]")
	private WebElement Login_SignUp_Btn;
	
	public HomePageObject(WebDriver driver)
	{	
		super(driver);
	}
	public void verifyHomePage() {
		if(verifyHome.isDisplayed())
		{
			System.out.println("HomePage is Displayed");
		}
	}
	public void clickLogin_SignUp() {
		
		Login_SignUp_Btn.click();
	}
}
