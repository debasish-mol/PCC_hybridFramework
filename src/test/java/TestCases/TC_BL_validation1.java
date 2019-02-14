package TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AppPages.InvokeCreateBL;
import AppPages.loginPages;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Utility.Helper;

public class TC_BL_validation1 {

	public WebDriver driver;

	ExtentReports report;

	ExtentTest logger;
	
	loginPages home;
	
	String excelPath = "D:\\all\\personal\\backup\\Selenium3\\SeleniumProgram\\com.Pcc.Net.Hybridframework\\ApplicationTestData\\BL_Validation.xlsx";
	
	@BeforeSuite
	public void setup() 
	{
		report = new ExtentReports(".//Reports/TC_BL_validation1.html",true);
		
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
	public void BLValidationBookingAccepted()
	{
	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		InvokeCreateBL cbl =PageFactory.initElements(driver, InvokeCreateBL.class);
		
		//String excelPath = "D:\\all\\personal\\backup\\Selenium3\\SeleniumProgram\\com.Pcc.Net.Hybridframework\\ApplicationTestData\\BL_Validation.xlsx";
		
		double bookingNo = DataProviderFactory.getExcel().getdoublevalue(excelPath,"validation",1,1);
		
		String StringBookingNo = NumberToTextConverter.toText(bookingNo);
		
		System.out.println("Booking no "+StringBookingNo);
		
		
		
		if(!StringBookingNo.equals("0"))
		{
			logger.log(LogStatus.INFO,"Got Booking number from excell file");
			
			cbl.setBkgNo(StringBookingNo);
			
			logger.log(LogStatus.INFO,"Entered Booking number and pressed TAB");
		}
		
		String msg = cbl.getErrorMsg();
		
		if(msg.contains("'Accepted' or 'Reconciled' "))
		{
			System.out.println("validation 1 Passed");
			
			logger.log(LogStatus.INFO,msg);
			
			String path = Helper.captureScreenshot(driver,"BLValidation1");
			
			//logger.log(LogStatus.INFO,"Snapshot below: " + logger.addScreenCapture(Helper.captureScreenshot(driver,"BLValidation1")));
			
			logger.log(LogStatus.INFO,"Snapshot below: " + logger.addScreenCapture(path));
			
		}
	}
		@Test(priority=2)
		public void BLValidationBookingLegIntented()
		{
			driver.navigate().refresh();
		
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
							
			InvokeCreateBL cbl =PageFactory.initElements(driver, InvokeCreateBL.class);
								
			double bookingNo = DataProviderFactory.getExcel().getdoublevalue(excelPath,"validation",2,1);
			
			String StringBookingNo = NumberToTextConverter.toText(bookingNo);
			
			System.out.println("Booking no "+StringBookingNo);
			
			
			
			if(!StringBookingNo.equals("0"))
			{
				logger.log(LogStatus.INFO,"Got Booking number from excell file");
				
				cbl.setBkgNo(StringBookingNo);
				
				logger.log(LogStatus.INFO,"Entered Booking number and pressed TAB");
				
				System.out.println("Entered Booking Number");
			}
			
			String msg1 = cbl.getErrorMsg();
			
			System.out.println(msg1);
			
			if(msg1.contains("Firmed voyage"))
			{
				System.out.println("validation 2 Passed");
				
				logger.log(LogStatus.INFO,msg1);
				
				String path =Helper.captureScreenshot(driver,"BLValidation2");
				
				//logger.log(LogStatus.INFO,"Snapshot below: " + logger.addScreenCapture(Helper.captureScreenshot(driver,"BLValidation1")));
				
				logger.log(LogStatus.INFO,"Snapshot below: " + logger.addScreenCapture(path));
				
			}
			
			report.endTest(logger);
			report.flush();
			
		}

		
		
	
	
}
