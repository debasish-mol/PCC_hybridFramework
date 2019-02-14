package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AppPages.ContEntryPages;
import AppPages.internetpages;
import AppPages.loginPages;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Utility.Helper;

public class TestingCode {

public WebDriver driver;
	
		
	loginPages home;
	
	@BeforeMethod
	public void setup() 
	{
		
		
		BrowserFactory br = new BrowserFactory();
		
        driver = br.getBrowser();
        
        
        
		String url = "contUrl";
		
		driver.get(DataProviderFactory.getConfig().getUrl(url));
		
		
		
		//Thread.sleep(4000);
		
		 home = PageFactory.initElements(driver, loginPages.class);
		
		home.loginInfo();	
		
		
	}
	
	@Test
	public void ContractEntry() throws InterruptedException
	{
		
		ContEntryPages Contpg = PageFactory.initElements(driver,ContEntryPages.class);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Contpg.contractType(DataProviderFactory.getExcel().getStringData("ContractData",0,1));
		
		//Contpg.selectDate(DataProviderFactory.getExcel().getDateData("ContractData", 3,2));
		
		
		//Thread.sleep(3000);
	}				

}
