package TestCases;

import org.openqa.selenium.WebDriver;

import AppPages.internetpages;
import AppPages.loginPages;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class TestingCode {

	public static void main(String[] args) {
		
		
		
	String date	=DataProviderFactory.getExcel().getDateData("ContractData", 3,1);
	
	System.out.println("date "+date);
		
		
		
		
		
		
		
		
		/*String url = DataProviderFactory.getConfig().getUrl();
		
		System.out.println("Printing Url "+url);
		
        BrowserFactory br = new BrowserFactory();
		
		WebDriver driver = br.getBrowser("Chrome");
		
		driver.get(url);
		
		loginPages login = new loginPages(driver);
		
		login.loginInfo();
		
          
		
		String data = DataProviderFactory.getExcel().getData(0, 0, 0);
		
		System.out.println(data);
		*/
		/*
      BrowserFactory br = new BrowserFactory();
		
		WebDriver driver = br.getBrowser("IE");
		
		  String url="url1";
	        
		driver.get(DataProviderFactory.getConfig().getUrl(url));
		
		//loginPages login = new loginPages(driver);
		
		//login.loginInfo();
		
		
        internetpages ipages = new internetpages(driver);
		
		ipages.loginpages("tomsmith","SuperSecretPassword!");
		
		*/
	}

}
