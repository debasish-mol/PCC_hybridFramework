package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	
	public static String captureScreenshot(WebDriver driver,String screenshotName)
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
	File src=ts.getScreenshotAs(OutputType.FILE);
	
	String destination = "D:\\all\\personal\\backup\\Selenium3\\SeleniumProgram\\com.Pcc.Net.Hybridframework\\Screenshots"+screenshotName+System.currentTimeMillis()+".png";
	
	try {
		 FileUtils.copyFile(src, new File(destination));
	} catch (IOException e) {
		System.out.println("Screenshot not Taken"+e.getMessage());
	}
		
	
	return destination;
		
		
	}

}
