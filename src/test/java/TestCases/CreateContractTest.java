package TestCases;

import java.util.concurrent.TimeUnit;

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
		
        driver = br.getBrowser();
        
        logger.log(LogStatus.INFO,"Browser is invoked");
        
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
		
		
		//Contpg.ContractType("Transport Contract");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Contpg.ContractType(DataProviderFactory.getExcel().getStringData("ContractData",0,1));
		
		logger.log(LogStatus.INFO,"Contract type is selected");
		
		//Thread.sleep(3000);
		
		//Contpg.EnterContractName("TransportContract");
		
		Contpg.EnterContractName(DataProviderFactory.getExcel().getStringData("ContractData",1,1));
				
		
		logger.log(LogStatus.INFO,"Entered Contract name");
		
		//Contpg.EnterMainCustomer("5117553"); // Entering Customer Code
		
		Contpg.EnterMainCustomer(DataProviderFactory.getExcel().getNumberData("ContractData",2,1)); // Entering Customer Code
		
		logger.log(LogStatus.INFO,"Entered Customer code");
		
		//Thread.sleep(5000);
		
		//Contpg.EnterEffectivedate("24/04/2018");
		
		Contpg.EnterEffectivedate(DataProviderFactory.getExcel().getDateData("ContractData", 3,1));
		
		
		//Contpg.EnterExpiryDate("24/04/2019");
		
		Contpg.EnterExpiryDate(DataProviderFactory.getExcel().getDateData("ContractData", 4,1));
		
		
		Contpg.ClickOnFirstPageSave();
		
		logger.log(LogStatus.PASS,"First page saved");
		
		logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"FirstPageContract")));
		
	    Thread.sleep(5000);
		
		Contpg.ToCheckAddLpDpVisibility();   // Dynamic Wait or Explicit Wait
		
		Contpg.PrintContNo();  // Printing Contact No & Writting to excell output file - AppData.xlsx
		
		//Contpg.EnterContLoadPort("SGSINPP");
		
		Contpg.EnterContLoadPort((DataProviderFactory.getExcel().getStringData("ContractData",5,1)));
		
		//Contpg.EnterContDisPort("HKHKGPC");
		
		Contpg.EnterContDisPort((DataProviderFactory.getExcel().getStringData("ContractData",6,1)));
		
		logger.log(LogStatus.INFO,"Entered Load Port & Discharge port");
		
		Contpg.ClickOnContADDLpDpSave();
		
		Contpg.ToCheckVisibilityOfAddMakeModel();
		
		//Contpg.EnterCargoType("TRUCK");
		
		Contpg.EnterCargoType((DataProviderFactory.getExcel().getStringData("ContractData",7,1)));
		
		logger.log(LogStatus.INFO,"Entered Cargo Type");
		
		Thread.sleep(4000);
		
		//Contpg.EnterContMakeName("MARUTI");  ASHOK
		
		//Contpg.EnterContMakeName("ASHOK"); 
		
		Contpg.EnterContMakeName((DataProviderFactory.getExcel().getStringData("ContractData",8,1))); 
		
		Thread.sleep(3000);
		
		//Contpg.EnterContModelName("BALENO");  
		
		//Contpg.EnterContModelName("MINI TRUCK");
		
		Contpg.EnterContModelName((DataProviderFactory.getExcel().getStringData("ContractData",9,1)));
		
				
		Thread.sleep(4000);
		
		//Contpg.EnterContADDModifyRevenue("PB");
		
		Contpg.EnterContADDModifyRevenue((DataProviderFactory.getExcel().getStringData("ContractData",10,1)));
		
		logger.log(LogStatus.INFO,"Revenue added");
		
		Thread.sleep(3000);
		
		Contpg.ConCragoSaveButton();
		
		logger.log(LogStatus.PASS,"Contract Saved with Draft status");
		
		logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"ContractSaved")));
		
		report.endTest(logger);
		
		report.flush();
		
		Thread.sleep(5000);
		
	}
	/*
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
	}
	
*/
}
