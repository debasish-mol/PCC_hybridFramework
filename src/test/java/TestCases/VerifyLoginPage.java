package TestCases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import AppPages.internetpages;
import AppPages.loginPages;
import DataProvider.ConfigdataProvider;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class VerifyLoginPage {
	
	@Test
	public void loginTest()
	{
		
		BrowserFactory br = new BrowserFactory();
		
         WebDriver driver = br.getBrowser();
		
         String url="url1";
	        
 		driver.get(DataProviderFactory.getConfig().getUrl(url));
						
		/*loginPages login = new loginPages(driver);
		
		login.loginInfo();  */
		
		loginPages home = PageFactory.initElements(driver, loginPages.class);

		home.loginInfo();	
		
		//internetpages ipages = PageFactory.initElements(driver, internetpages.class);
		
		/*internetpages ipages = new internetpages(driver);
		
		ipages.loginpages("tomsmith","SuperSecretPassword!");   */
		
	}
	
	
	
	

}