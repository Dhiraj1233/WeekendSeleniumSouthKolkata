package com.qsp.utility;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersUtility  implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	public void onStart(ITestContext context) 
	{
		//it executes when test method start executing
		System.out.println("======Test Started=====");
		
		Date d = new Date();
		String timeStamp = d.toString().replace(":","_");
		ExtentSparkReporter sparkRepoter=new ExtentSparkReporter("./reports/Automation"+timeStamp+".html");//generate the report
		sparkRepoter.config().setDocumentTitle("Automation Testing");
		sparkRepoter.config().setReportName("Positive Testing");
		sparkRepoter.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(sparkRepoter);
		report.setSystemInfo("Application", "Automation Exercise");
		report.setSystemInfo("User Name",System.getProperty("user.name"));
		report.setSystemInfo("Operating System", "Windows");
		//browser
		String browser=context.getCurrentXmlTest().getParameter("browser");
		report.setSystemInfo("Browser", browser);
		//groups
		List<String> includedGrps = context.getCurrentXmlTest().getIncludedGroups();
		
		if(includedGrps.isEmpty()) {
			
			report.setSystemInfo("Groups", includedGrps.toString());
		}
	}
	public void onTestSuccess(ITestResult result) 
	{
		//it executes when test method success
		System.out.println("======Test success=====");
		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test case passed is : "+result.getName());	
	}
	public void onTestFailure(ITestResult result) 
	{
		//it executes when test method falied
		System.out.println("======Test failed=====");
		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test case failed is : "+result.getName());
		try {
			String path = ScreenShotutility.getDefects(result.getName());
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) 
	{
		//it executes when test method skipped
		System.out.println("======Test skipped=====");	
		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test case skipped is : "+result.getName());		
	}

	public void onFinish(ITestContext context) 
	{
		//it executes when test method finished
		System.out.println("======Test Finished=====");
		report.flush();
	}	

}
