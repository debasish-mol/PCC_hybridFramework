package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigdataProvider {
	
	FileInputStream fis;
	static Properties prop;
	
	public ConfigdataProvider()
	{
		File file = new File("D:\\all\\personal\\backup\\Selenium3\\SeleniumProgram\\com.Pcc.Net.Hybridframework\\Configuration\\config.properties");
		
		try {
			 fis = new FileInputStream(file);
		} catch (Exception e) {
			
			System.out.println("Exception occur "+e.getMessage());
		}
		
			 prop = new Properties();
			
			try {
				prop.load(fis);
			} catch (Exception e) {
				
				System.out.println("Exception "+e.getMessage());
			}
		
	}
	
	
	/*
	public static String getUrl()
	{
		 String url = prop.getProperty("url");
		 
		 return url;
		
	}*/
	
	public static String getUrl(String urlName)
	{
		 String url = prop.getProperty(urlName);
		 
		 return url;
		
	}
	
	public static String getChromePath()
	{
		 String cromepath = prop.getProperty("Cromepath");
		 
		 return cromepath;
		
	}
	public static String getIEpath()
	{
		 String iepath = prop.getProperty("IEpath");
		 
		 return iepath;
		
	}
	
	

}
