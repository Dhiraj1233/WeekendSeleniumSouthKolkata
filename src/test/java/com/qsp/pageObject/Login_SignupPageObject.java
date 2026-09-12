package com.qsp.pageObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qsp.ObjectUtility.WebdriverUtility;

public class Login_SignupPageObject extends BasePage{
	@FindBy(xpath = "//h2[text()='Login to your account']")
	private WebElement verifyLoginAc;
	@FindBy(name="email")
	private WebElement emailId;
	@FindBy(name="password")
	private WebElement password;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;
	@FindBy(xpath = "//ul[@class='nav navbar-nav']//li[10]//b")
	private WebElement VerifyUsername;
	@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
	private WebElement errorMsg;
	
	@FindBy(xpath = "//h2[text()='New User Signup!']")
	private WebElement VerifySignUp;
	@FindBy(xpath="//input[@placeholder='Name']")
	private WebElement name;
	@FindBy(xpath="(//input[@placeholder='Email Address'])[2]")
	private WebElement email;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement signUpBtn;
	public Login_SignupPageObject(WebDriver driver) {
		super(driver);
	}
	public void loginActions(String email, String Password,WebDriver driver) {
		try {
			WebdriverUtility.visibility(driver, verifyLoginAc);
			emailId.clear();
			emailId.sendKeys(email);
			password.clear();
			password.sendKeys(Password);
			WebdriverUtility.clickableEle(driver, loginBtn);
			loginBtn.click();
		} catch (TimeoutException e) {
			System.out.println("=== Login / SignUp Page is not displayed ===");
		}
	}
	public boolean isUsernameDisplayed() {
		try {
			return VerifyUsername.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	public boolean isErrorMsgDisplayed() {
		try {
			return errorMsg.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void signUpActions(String Name ,String Email, WebDriver driver) {
		try {
			WebdriverUtility.visibility(driver, VerifySignUp);
			name.clear();
			name.sendKeys(Name);
			email.clear();
			email.sendKeys(Email);
			WebdriverUtility.clickableEle(driver,signUpBtn);
			signUpBtn.click();
			
		}catch (TimeoutException e) {
			System.out.println("===SignUp Page is not displayed ===");
		}
	}
}