package TestCases;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AppPages.CreateUpdateBL;
import AppPages.InvokeCreateBL;
import AppPages.loginPages;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Utility.Helper;

public class CreateDraftBL {
	
	public WebDriver driver;
	
	loginPages home;
	
	ExtentReports report;
	
	ExtentTest logger;
	
	@BeforeMethod
	public void setup() 
	{
		
		report = new ExtentReports(".//Reports/CreateDraftBLTest.html",true);
		
		logger= report.startTest("Create Draft BL Test");
		
		BrowserFactory br = new BrowserFactory();
		
        driver = br.getBrowser();
        
        logger.log(LogStatus.INFO,"Browser opened");
		
        String url="Blurl";
        
        driver.get(DataProviderFactory.getConfig().getUrl(url));
		
		//Thread.sleep(4000);
		
		 home = PageFactory.initElements(driver, loginPages.class);
		
		home.loginInfo();
		
		logger.log(LogStatus.INFO,"Login succesfully");
		
	}
	
	@Test(priority=1)
	public void ApplicationLogin() throws InterruptedException
	{
		//loginPages login = new loginPages(driver);
		
		

		
		
				
	/*}
	
	@Test(priority=2)
	public void createBL()
	{*/
		InvokeCreateBL cbl =PageFactory.initElements(driver, InvokeCreateBL.class);
		
		//String bkg_No = DataProviderFactory.getExcel().getBookingNoString("bldata",0,1);
		
		String Bkg_no = NumberToTextConverter.toText(DataProviderFactory.getExcel().getNumberDataDouble("bldata",0,1));		
				
		System.out.println("Printing Booking number String "+Bkg_no);
		
		logger.log(LogStatus.INFO,"Got Booking number from excell file");
		
		cbl.setBkgNo(Bkg_no);
		
		cbl.proceedButton();
		
	/*}
	
	@Test(priority=3)
	public void CreateUpdateBLTest() throws InterruptedException
	{*/
		
		CreateUpdateBL cubl = PageFactory.initElements(driver, CreateUpdateBL.class);
		
		cubl.setGoodsDescription();
		
		cubl.clickOnSave();
		
		logger.log(LogStatus.INFO,"Saved B/L in deaft Status");
		
		cubl.transactionLog();
					
		cubl.getBLNumber();
		
		logger.log(LogStatus.PASS,"Saved B/L in draft Status");
		
				
        Thread.sleep(8000);
        
        logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"createDraftBL")));
        
        report.endTest(logger);
		
		report.flush();
		
		driver.quit();
			
			}
	
	
	
	/*@AfterTest
	public void CloseBrowswer()
	{
		driver.quit();
	}*/
	
	

}
