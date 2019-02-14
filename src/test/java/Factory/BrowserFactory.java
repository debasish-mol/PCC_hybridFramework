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
	
	public WebDriver getBrowser()
	{
		
		
			//System.getProperty("webdriver.ie.driver",DataProviderFactory.getConfig().getIEpath());
			
			System.setProperty("webdriver.ie.driver", ".\\Driver\\IEDriverServer.exe");
			
					
			//System.setProperty("webdriver.ie.driver", "D:\\all\\personal\\backup\\Selenium3\\IEDriverServer.exe");
			
			driver=new InternetExplorerDriver();
			
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				
				System.out.println("Exception type "+e.getMessage());
				
				//e.printStackTrace();
				
				
			}  
		/*
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			
			System.out.println("Exception type "+e.getMessage());
		}
		*/
			
			driver.manage().window().maximize();
			
			
		
		
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
	}

	
	
	public static void closeBrowser(WebDriver ldriver)
	{
		
		ldriver.quit();
		
	}
}
