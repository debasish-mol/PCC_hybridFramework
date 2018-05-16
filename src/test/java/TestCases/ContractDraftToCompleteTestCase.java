package TestCases;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AppPages.ContEntryPages;
import AppPages.ContractSearchScreen;
import AppPages.loginPages;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class ContractDraftToCompleteTestCase {
	
	WebDriver driver;
	
	loginPages home;
	
	@BeforeMethod
	public void setup() 
	{
		BrowserFactory br = new BrowserFactory();
		
        driver = br.getBrowser("Chrome");
        
		String url = "ContSrch";
		
		driver.get(DataProviderFactory.getConfig().getUrl(url));
		
		//Thread.sleep(4000);
		
		 home = PageFactory.initElements(driver, loginPages.class);
		
		home.loginInfo();	
		
	}
	@Test
	public void ContractComplete() throws InterruptedException
	{
		ContractSearchScreen csSreen = PageFactory.initElements(driver,ContractSearchScreen.class);
		
		String Contract_no = DataProviderFactory.getExcel().getBookingNoString("bldata",1,1);
		
		csSreen.EnterContactNumber(Contract_no);
		
				
		csSreen.ClickOnSearch();
		
		Thread.sleep(3000);
		
		String curWindowControl = driver.getWindowHandle();
		
		csSreen.ClickOnEditContact();
		
		Thread.sleep(3000);
		
		
		Set<String> allWinControls = driver.getWindowHandles();
		
		ContEntryPages Contpg = PageFactory.initElements(driver,ContEntryPages.class);
		
		for(String s: allWinControls )
		{
			driver.switchTo().window(s);
			
			if(Contpg.getPageHeader().contains("Update Contract"))
			{
				//Contpg.EnterSalesPerson();
				
				Contpg.SelectContactStatus();
				
				Thread.sleep(2000);
				
				Contpg.ClickOnHdrSave();
				
			}
			
		}
		
		
		
	/*	
		Contpg.EnterSalesPerson();
		
		Contpg.SelectContactStatus();
		
		Thread.sleep(2000);
		
		Contpg.ClickOnHdrSave();
		*/
		
	}
	

}
