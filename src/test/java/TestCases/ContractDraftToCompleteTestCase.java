package TestCases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AppPages.ContEntryPages;
import AppPages.ContractSearchScreen;
import AppPages.loginPages;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Utility.Helper;

public class ContractDraftToCompleteTestCase {
	
	WebDriver driver;
	
	ExtentReports report;
	
	ExtentTest logger;
	
	loginPages home;
	
	@BeforeMethod
	public void setup() 
	{
		report = new ExtentReports(".//Reports/ContractDraftToCompleteTestCase.html",true);
		
		logger= report.startTest("Verify Test Login");
		
		BrowserFactory br = new BrowserFactory();
		
        driver = br.getBrowser("IE");
        
        logger.log(LogStatus.INFO,"Browser is invoked");
        
		String url = "ContSrch";
		
		driver.get(DataProviderFactory.getConfig().getUrl(url));
		
		logger.log(LogStatus.INFO,"Application opened");
		
		
		
		//Thread.sleep(4000);
		
		 home = PageFactory.initElements(driver, loginPages.class);
		
		home.loginInfo();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		logger.log(LogStatus.PASS,"logged in successfully");
		
		logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"LoginPage")));
		
	}
	@Test
	public void ContractComplete() throws InterruptedException
	{
		ContractSearchScreen csSreen = PageFactory.initElements(driver,ContractSearchScreen.class);
		
		String Contract_no = DataProviderFactory.getExcel().getBookingNoString("bldata",1,1);
		
		csSreen.EnterContactNumber(Contract_no);
		
		logger.log(LogStatus.INFO,"Contract no. is entered");
		
		csSreen.ClickOnSearch();
		
		Thread.sleep(3000);
		
		logger.log(LogStatus.INFO,"Found Search Result");
		
		String curWindowControl = driver.getWindowHandle();
		
		csSreen.ClickOnEditContact();
		
		Thread.sleep(3000);
		
		logger.log(LogStatus.INFO,"Clicked on Edit button");
		
		Set<String> allWinControls = driver.getWindowHandles();
		
		ContEntryPages Contpg = PageFactory.initElements(driver,ContEntryPages.class);
		
		for(String s: allWinControls )
		{
			driver.switchTo().window(s);
			
			driver.manage().window().maximize();
			
			if(Contpg.getPageHeader().contains("Update Contract"))
			{
				//Contpg.EnterSalesPerson();
				
				Contpg.SelectContactStatus();
				
								
				Thread.sleep(2000);
				
				Contpg.ClickOnHdrSave();
				
			}
			
		}
		
		logger.log(LogStatus.PASS,"Updated Successfully");
		
		report.endTest(logger);
		
		report.flush();
		
	/*	
		Contpg.EnterSalesPerson();
		
		Contpg.SelectContactStatus();
		
		Thread.sleep(2000);
		
		Contpg.ClickOnHdrSave();
		*/
		
	}
	

}
