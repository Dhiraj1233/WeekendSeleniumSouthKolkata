package com.qsp.TestCases;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.qsp.BasePage.BaseClass;
import com.qsp.pageObject.HomePageObject;
import com.qsp.pageObject.Login_SignupPageObject;
import com.qsp.utility.PropertiesUtility;
public class Login_With_Invalid_Credentials extends BaseClass
{
	@Test(groups = {"smoke","master"})
	public void invalidUser()
	{
		try 
		{
			HomePageObject hp=new HomePageObject(driver);
			hp.verifyHomePage();
			hp.clickLogin_SignUp();
			Login_SignupPageObject lsp=new Login_SignupPageObject(driver);
			PropertiesUtility prop=new PropertiesUtility();
			lsp.loginActions(prop.getData("inValidEmail"), prop.getData("inValidPass"),driver);
			Assert.assertTrue(
					lsp.isErrorMsgDisplayed(),
					"Your email or password is incorrect!"
					);
			Reporter.log("Error message is displaying",true);
		}	
		catch(Exception e){
			  Reporter.log("Login test failed: " + e.getMessage(), true);
			  Assert.fail("Login test failed because: " + e.getMessage());
		}
	}
}