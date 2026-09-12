package com.qsp.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpAccInformation extends BasePage
{
	//Enter Account Information
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	private WebElement accinfo;
	@FindBy(id = "id_gender1")
	private WebElement title;
	@FindBy(id ="name")
	private WebElement name;
	@FindBy(id="email")
	private WebElement email;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(id="days")
	private WebElement dayDD;
	@FindBy(id="months")
	private WebElement monthDD;
	@FindBy(id="years")
	private WebElement yearDD;
	@FindBy(id="newsletter")
	private WebElement newsletterCheckBox;
	@FindBy(id="optin")
	private WebElement partnersCheckbox;
//	Address Information
	@FindBy(id="first_name")
	private WebElement first_name;
	@FindBy(id="last_name")
	private WebElement last_name;
	@FindBy(id="address1")
	private WebElement address1;
	@FindBy(id="country")
	private WebElement countryDD;
	@FindBy(id="state")
	private WebElement state;
	@FindBy(id="city")
	private WebElement city;
	@FindBy(id="zipcode")
	private WebElement zipcode;
	@FindBy(id="mobile_number")
	private WebElement mobile_number;
	@FindBy(xpath="//button[text()='Create Account']")
	private WebElement createBtn;
	public SignUpAccInformation(WebDriver driver)
	{
		super(driver);
	}
	//Enter Account Information
	public WebElement isAcInfoDisplayed() {
		return accinfo;
	}
	public WebElement setTitle() {
		return title;
	}
	public WebElement setName() {
		return name;
	}
	public WebElement setEmail() {
		return email;
	}
	public WebElement setPassword() {
		return password;
	}
	public WebElement setDayDD() {
		
		return  dayDD;
	}
	public WebElement setMonthDD() {
		return monthDD;
	}
	public WebElement setYearDD() {
		return yearDD;
		
	}
	public void setNewsletterCheckBox() {
		newsletterCheckBox.click();
	}
	public void setPartnersCheckbox() {
		partnersCheckbox.click();
	}
	//	Address Information
	public WebElement setFirstName()
	{
		return first_name;
		
	}
	public WebElement setLastName()
	{
		return last_name;
		
	}
	public WebElement setAddress()
	{
		return address1;
		
	}public WebElement setCountry()
	{
		return countryDD;
	}
	public WebElement setState()
	{
		return state;
	}
	public WebElement setCity()
	{
		return city;
	}
	public WebElement setZipCode()
	{
		return zipcode;
	}
	public WebElement setMobileNumber()
	{
		return mobile_number;
	}
	public void clickCreateBtn()
	{
		createBtn.click();
	}
}
