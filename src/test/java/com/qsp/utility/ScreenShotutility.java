package com.qsp.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.qsp.BasePage.BaseClass;

public class ScreenShotutility extends BaseClass
{
	public static String getDefects(String filename) throws IOException {
		Date d = new Date();
		String d2 = d.toString().replace(":","_");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		String targetFile = System.getProperty("user.dir")
		+"./ScreenShot"+"_"+filename+"_"+d2+".png";
		File perm = new File(targetFile);
		FileHandler.copy(temp, perm);
		return targetFile;
	}
}
