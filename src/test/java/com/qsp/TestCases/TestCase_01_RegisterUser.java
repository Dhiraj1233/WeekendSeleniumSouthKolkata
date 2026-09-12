package com.qsp.TestCases;
import java.io.IOException;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qsp.BasePage.BaseClass;
import com.qsp.ObjectUtility.HandlingDropdown;
import com.qsp.ObjectUtility.JseUtlity;
//import com.qsp.pageObject.AccCreated;
import com.qsp.pageObject.HomePageObject;
import com.qsp.pageObject.Login_SignupPageObject;
import com.qsp.pageObject.SignUpAccInformation;
import com.qsp.utility.PropertiesUtility;



public class TestCase_01_RegisterUser  extends BaseClass
{
	@Test(groups = {"smoke","master"})
	public void registerUser() throws InterruptedException, IOException
	{
		//Home Page
		HomePageObject hp=new HomePageObject(driver);
		hp.verifyHomePage();
		hp.clickLogin_SignUp();
		Login_SignupPageObject lsp=new Login_SignupPageObject(driver);
		PropertiesUtility prop=new PropertiesUtility();
		lsp.signUpActions(prop.getData("regEmail"), prop.getData("regPass"), driver);
		SignUpAccInformation accinfo=new SignUpAccInformation(driver);
		Assert.assertEquals(accinfo.isAcInfoDisplayed().getText(),
				"Enter Account Information"
				);
		accinfo.setTitle().click();
		accinfo.setPassword().sendKeys(prop.getData("password"));
		JseUtlity jsutil=new JseUtlity();
		jsutil.scrollIntoView(driver, accinfo.setAddress());
		
		HandlingDropdown dropdown = new HandlingDropdown();
		dropdown.selectOptions("07", accinfo.setDayDD());
		dropdown.selectOptions("September", accinfo.setMonthDD());
		dropdown.selectOptions("1999",accinfo.setYearDD());
		accinfo.setNewsletterCheckBox();
		accinfo.setPartnersCheckbox();
		accinfo.setFirstName().sendKeys(prop.getData("firstName"));
		accinfo.setLastName().sendKeys(prop.getData("lastName"));
		accinfo.setAddress().sendKeys(prop.getData("address"));
		dropdown.selectOptions(prop.getData("country"),accinfo.setCountry());
		accinfo.setState().sendKeys(prop.getData("state"));
		accinfo.setCity().sendKeys(prop.getData("city"));
		accinfo.setZipCode().sendKeys(prop.getData("zipCode"));
		accinfo.setMobileNumber().sendKeys(prop.getData("number"));
		accinfo.clickCreateBtn();
		//Account Created
//		AccCreated  acc = new AccCreated(driver);
//		acc.setVerifyAccCreated().isDisplayed();
//		acc.setContinueBtn().click();
//		acc.setVerifyLogin().isDisplayed();
//		acc.setDeleteAcc().click();
//		acc.setVerifyDeleted().isDisplayed();
//		acc.setContinueBtn().click();
	}
}
