package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	
	public static String captureScreenshot(WebDriver driver,String screenshotName)
	{
		/*
		TakesScreenshot ts = (TakesScreenshot)driver;
		
	File src=ts.getScreenshotAs(OutputType.FILE);
	
	String destination = "D:\\all\\personal\\backup\\Selenium3\\SeleniumProgram\\com.Pcc.Net.Hybridframework\\Screenshots"+screenshotName+System.currentTimeMillis()+".png";
	
	try {
		 FileUtils.copyFile(src, new File(destination));
	} catch (IOException e) {
		System.out.println("Screenshot not Taken"+e.getMessage());
	}
		
	return destination;
	
		*/
		
		
		 //File scrFile = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File scrFile=ts.getScreenshotAs(OutputType.FILE);
		
		    String encodedBase64 = null;
		    FileInputStream fileInputStreamReader = null;
		    try {
		        fileInputStreamReader = new FileInputStream(scrFile);
		        byte[] bytes = new byte[(int)scrFile.length()];
		        fileInputStreamReader.read(bytes);
		        encodedBase64 = new String(Base64.encodeBase64(bytes));
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		  
		  //  return "data:image/png;base64,"+encodedBase64;
		    
		    String destination = "D:\\all\\personal\\backup\\Selenium3\\SeleniumProgram\\com.Pcc.Net.Hybridframework\\Screenshots\\deb"+screenshotName+System.currentTimeMillis()+".png";
		    
		    try {
				FileUtils.copyFile(scrFile, new File(destination));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		   // return "data:image/png;base64,"+encodedBase64;
		    return destination;
						
		
	}

}
