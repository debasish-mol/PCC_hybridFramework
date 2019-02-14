package TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AppPages.CreateUpdateBL;
import AppPages.HomePageIndex;
import AppPages.InvokeCreateBL;
import AppPages.loginPages;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Utility.Helper;

public class CreateBlWithRevenueUpdate {
	
public WebDriver driver;

	ExtentReports report;

	ExtentTest logger;
	
	loginPages home;
	
	@BeforeMethod
	public void setup() 
	{
		report = new ExtentReports(".//Reports/CreateCompleteBLTest.html",true);
		
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
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		cubl.selectIssueType();
		
		cubl.setGoodsDescription();
		
		logger.log(LogStatus.INFO,"Goods description added");
		
		
		cubl.waitGoodsDescription();
		
		
		//Thread.sleep(3000);
		
		cubl.AddRevenue();
		
		logger.log(LogStatus.INFO,"Added Revenue");
		
		//Thread.sleep(4000);
		
         cubl.clickOnSave();
         
        // Thread.sleep(4000);
         
        cubl.waitToSaveCompletion(); 
         
		cubl.transactionLog();
		
		logger.log(LogStatus.INFO,"Saved B/L in deaft Status");
		
		//Thread.sleep(4000);
		
							
		cubl.getBLNumber();
		
		//Thread.sleep(4000);
		
		logger.log(LogStatus.INFO,"B/L no is written at excel file");
		
				
		cubl.clickOnComplete();
		
		cubl.waitToSaveCompletion(); 
		
		//Thread.sleep(4000);
		
		cubl.transactionLog();
		
		logger.log(LogStatus.INFO,"Saved B/L with complete Status");
		
		//Thread.sleep(4000);
		
		cubl.ReadyForInvoiceIssue();
		
		//Thread.sleep(3000);
		
		cubl.waitToSaveCompletion();
		
		cubl.transactionLog();
		
		//Thread.sleep(4000);
		
		cubl.getBLStatus();
		
		logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"CreateCompleteBL")));
		
		report.endTest(logger);
		
		report.flush();
				
		}
	
	/*
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path =Helper.captureScreenshot(driver,result.getName());
			
			logger.log(LogStatus.FAIL,logger.addScreenCapture(Helper.captureScreenshot(driver,"CreateCompleteBL")));
			
		}
		
		//driver.quit();
	} */

}
