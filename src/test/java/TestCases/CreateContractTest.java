package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AppPages.ContEntryPages;
import AppPages.loginPages;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Utility.Helper;

public class CreateContractTest {
	
	public WebDriver driver;
	
	ExtentReports report;
	
	ExtentTest logger;
	
	loginPages home;
	
	@BeforeMethod
	public void setup() 
	{
		report = new ExtentReports(".//Reports/CreateContactTest.html",true);
		
		logger= report.startTest("Verify Test Login");
		
		BrowserFactory br = new BrowserFactory();
		
        driver = br.getBrowser("Chrome");
        
        logger.log(LogStatus.INFO,"Browser invoked");
        
		String url = "contUrl";
		
		driver.get(DataProviderFactory.getConfig().getUrl(url));
		
		logger.log(LogStatus.INFO,"Application opened");
		
		//Thread.sleep(4000);
		
		 home = PageFactory.initElements(driver, loginPages.class);
		
		home.loginInfo();	
		
		logger.log(LogStatus.PASS,"logged in successfully");
		
		logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"LoginPage")));
		
	}
	
	@Test
	public void ContractEntry() throws InterruptedException
	{
		
		ContEntryPages Contpg = PageFactory.initElements(driver,ContEntryPages.class);
		
		// Contract type = Transport Contract / Quotation / Spot Rate Guidelines Agreement with Brokers Agreement with Broker Customers
		
		
		Contpg.ContractType("Transport Contract");
		
		logger.log(LogStatus.INFO,"Contract type is selected");
		
		Thread.sleep(3000);
		
		Contpg.EnterContractName("TransportContract");
		
		logger.log(LogStatus.INFO,"Entered Contract name");
		
		Contpg.EnterMainCustomer("5117553"); // Entering Customer Code
		
		logger.log(LogStatus.INFO,"Entered Customer code");
		
		Thread.sleep(3000);
		
		Contpg.EnterEffectivedate("24/04/2018");
		
		Contpg.EnterExpiryDate("24/04/2019");
		
		Contpg.ClickOnFirstPageSave();
		
		logger.log(LogStatus.PASS,"First page saved");
		
		logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"FirstPageContract")));
		
	    Thread.sleep(3000);
		
		Contpg.ToCheckAddLpDpVisibility();   // Dynamic Wait or Explicit Wait
		
		Contpg.PrintContNo();  // Printing Contact No & Writting to excell output file - AppData.xlsx
		
		Contpg.EnterContLoadPort("SGSINPP");
		
		Contpg.EnterContDisPort("HKHKGPC");
		
		logger.log(LogStatus.INFO,"Entered Load Port & Discharge port");
		
		Contpg.ClickOnContADDLpDpSave();
		
		Contpg.ToCheckVisibilityOfAddMakeModel();
		
		Contpg.EnterCargoType("TRUCK");
		
		logger.log(LogStatus.INFO,"Entered Cargo Type");
		
		Thread.sleep(4000);
		
		//Contpg.EnterContMakeName("MARUTI");  ASHOK
		
		Contpg.EnterContMakeName("ASHOK"); 
		
		Thread.sleep(3000);
		
		//Contpg.EnterContModelName("BALENO");  
		
		Contpg.EnterContModelName("MINI TRUCK");
		
				
		Thread.sleep(3000);
		
		Contpg.EnterContADDModifyRevenue("PB");
		
		logger.log(LogStatus.INFO,"Revenue added");
		
		Thread.sleep(3000);
		
		Contpg.ConCragoSaveButton();
		
		logger.log(LogStatus.PASS,"Contract Saved with Draft status");
		
		logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"ContractSaved")));
		
		report.endTest(logger);
		
		report.flush();
		
		Thread.sleep(5000);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
	}
	

}
