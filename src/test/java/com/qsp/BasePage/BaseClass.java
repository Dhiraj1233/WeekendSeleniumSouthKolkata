package com.qsp.BasePage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass implements FrameworkConstant
{
	public  static WebDriver driver;
	@Parameters({"browser","os"})
	@BeforeClass(alwaysRun = true,groups = {"smoke","adhoc","master"})
	public void setUp(String browser,String os) {

		switch (browser.toLowerCase()) {
		case "chrome": driver = new ChromeDriver();
		break;
		case "firefox": driver=new FirefoxDriver();
		break;
		case "edge":driver=new EdgeDriver();
		break;
		default : throw new IllegalArgumentException("Invalid Broswer : "+browser);
	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		driver.get(pageUrl);
	}
	@AfterClass(alwaysRun = true,groups = {"smoke","adhoc","master"})
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
