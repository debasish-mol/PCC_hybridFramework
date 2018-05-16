package Factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import DataProvider.ConfigdataProvider;

public class BrowserFactory {
	
	
	 WebDriver driver;
	
	//ConfigdataProvider dp = new ConfigdataProvider();
	
	public WebDriver getBrowser(String BrowserName)
	{
		
		if(BrowserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
			driver.manage().window().maximize();
		}
		
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			 System.setProperty("webdriver.chrome.driver", "D:\\all\\personal\\backup\\Selenium3\\chromedriver.exe");
					
			//System.getProperty("webdriver.chrome.driver",DataProviderFactory.getConfig().getChromePath());
			
			driver=new ChromeDriver();
			
			driver.manage().window().maximize();
		}
		
		if(BrowserName.equalsIgnoreCase("IE"))
		{
			System.getProperty("webdriver.ie.driver",DataProviderFactory.getConfig().getIEpath());
			
			driver=new InternetExplorerDriver();
			
			driver.manage().window().maximize();
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
	}

	
	
	public static void closeBrowser(WebDriver ldriver)
	{
		
		ldriver.quit();
		
	}
}