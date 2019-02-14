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
		report = new ExtentReports(".//Reports//CreateContactTest.html",true);
		
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
		
		logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"login")));
		
	}
	
	@Test
	public void ContractEntry() throws InterruptedException
	{
		
		ContEntryPages Contpg = PageFactory.initElements(driver,ContEntryPages.class);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Contpg.contractType(DataProviderFactory.getExcel().getStringData("ContractData",0,1));
		
		logger.log(LogStatus.INFO,"Contract type is selected");
		
		//Thread.sleep(3000);
					
		Contpg.enterContractName(DataProviderFactory.getExcel().getStringData("ContractData",1,1));
		
		logger.log(LogStatus.INFO,"Entered Contract name");
			
		Contpg.enterMainCustomer(DataProviderFactory.getExcel().getNumberData("ContractData",2,1)); // Entering Customer Code
		
		logger.log(LogStatus.INFO,"Entered Customer code");
			
		Contpg.enterEffectivedate(DataProviderFactory.getExcel().getDateData("ContractData", 3,1));
						
		Contpg.enterExpiryDate(DataProviderFactory.getExcel().getDateData("ContractData", 4,1));
				
		Contpg.clickOnFirstPageSave();
		
		logger.log(LogStatus.PASS,"First page saved");
		
		logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"FirstPageContract")));
		
	   // Thread.sleep(5000);
		
		Contpg.ToCheckAddLpDpVisibility();   // Dynamic Wait or Explicit Wait
		
		Contpg.PrintContNo();  // Printing Contact No & Writting to excell output file - AppData.xlsx
						
		try {
			
			Contpg.enterContLoadPort((DataProviderFactory.getExcel().getStringData("ContractData",5,1)));
			
		} catch (Exception eEnterContLoadPort) {
			
			System.out.println("Exception at Entering load port "+eEnterContLoadPort);
		}
						
		try {
			
			Contpg.enterContDisPort((DataProviderFactory.getExcel().getStringData("ContractData",6,1)));
			
		} catch (Exception eEnterContDisPort) {
			
			System.out.println("Exception at Entering Discharge port"+eEnterContDisPort.getMessage());
			
			
		}
		
		logger.log(LogStatus.INFO,"Entered Load Port & Discharge port");
		
		try {
			
			Contpg.clickOnContADDLpDpSave();
		
		} catch (Exception eADDLpDpSave) {
			
			System.out.println("Exception at Saving Load/Discharge Section "+eADDLpDpSave);
		}
		
		try {
			
			Contpg.ToCheckVisibilityOfAddMakeModel();
		
		} catch (Exception eAddMakeModel) {
			
			System.out.println("Exception at Opening make model "+eAddMakeModel.getMessage());
			
		}
			
		try{
		
			Contpg.EnterCargoType((DataProviderFactory.getExcel().getStringData("ContractData",7,1)));
		
		}catch(Exception eCargoType)
		{
			System.out.println("Exception at Cargo section "+eCargoType.getMessage());
		}
		
		logger.log(LogStatus.INFO,"Entered Cargo Type");
		
		//Thread.sleep(4000);
		try{
			
		Contpg.EnterContMakeName((DataProviderFactory.getExcel().getStringData("ContractData",8,1))); 
		
		}catch(Exception eContMakeName)
		{
			System.out.println("Exception at make section "+eContMakeName.getMessage());
		}
		//Thread.sleep(3000);
		
		try{
		
		Contpg.enterContModelName((DataProviderFactory.getExcel().getStringData("ContractData",9,1)));
		
		}catch(Exception eModelName)
		{
			System.out.println("Exception at model entry section "+eModelName.getMessage());
		}
		
		//Thread.sleep(4000);
		
		try{
						
		Contpg.EnterContADDModifyRevenue((DataProviderFactory.getExcel().getStringData("ContractData",10,1)));
		
		}catch(Exception eRevenue)
		{
			System.out.println("Exception at revenue section "+eRevenue.getMessage());
		}
		
		logger.log(LogStatus.INFO,"Revenue added");
		
		//Thread.sleep(3000);
		
		try {
			
			Contpg.conCragoSaveButton();
			
		} catch (Exception eCragoSaveButton) {
			
			System.out.println("Exception at Model and Revenue details Saving "+eCragoSaveButton.getMessage());
		}
		
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
