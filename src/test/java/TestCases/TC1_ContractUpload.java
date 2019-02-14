package TestCases;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AppPages.ContEntryPages;
import AppPages.ContractSearchScreen;
import AppPages.JobMonitoringScreen;
import AppPages.loginPages;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Utility.Helper;
import junit.framework.Assert;

public class TC1_ContractUpload {
	
	public WebDriver driver;
	
	ExtentReports report;
	
	ExtentTest logger;
	
	
	loginPages home;
	
	@BeforeMethod
	public void setup() 
	{
		report = new ExtentReports(".//Reports/ContractDraftToCompleteTestCase.html",true);
		
		logger= report.startTest("Verify Test Login");
		
		BrowserFactory br = new BrowserFactory();
		
        driver = br.getBrowser();
        
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
	public void ContractUploadTest()
	{
		
		ContractSearchScreen csSreen = PageFactory.initElements(driver,ContractSearchScreen.class);
		
		String Contract_no = DataProviderFactory.getExcel().getBookingNoString("ContractData",2,7);
		
		csSreen.enterContactNumber(Contract_no);
		
		logger.log(LogStatus.INFO,"Contract no. is entered");
		
		try {
			csSreen.clickOnSearch();
			
		} catch (Exception eClickOnSearch) {
			
			System.out.println("Exception at Contract Search "+eClickOnSearch.getMessage());
		}
		
		//Thread.sleep(3000);
		
		logger.log(LogStatus.INFO,"Found Search Result");
		
		String curWindowControl = driver.getWindowHandle();
		
		try {
			csSreen.clickOnEditContact();
			
		} catch (Exception eClickOnEditContact) {
			
			System.out.println("Exception at Contract Edit "+eClickOnEditContact.getMessage());
		}
		
		
		WebDriverWait waitMulti = new WebDriverWait(driver,10);
		
		waitMulti.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> allWinControls = driver.getWindowHandles();
		
		
		ContEntryPages Contpg = PageFactory.initElements(driver,ContEntryPages.class);
		
		for(String s: allWinControls )
		{
			driver.switchTo().window(s);
			
			driver.manage().window().maximize();
			
			if(Contpg.getPageHeader().contains("Update Contract"))
			{
				break;
				
			}
			
		}
		
		
		Contpg.UploadExcelContract();
		
		
		
		try {
			
			String path = DataProviderFactory.getExcel().getBookingNoString("ContractData",3,7);
			
			Runtime.getRuntime().exec(".\\ApplicationTestData\\UploadFile.exe"+" "+path);
			
			//Runtime.getRuntime().exec("D:\\UploadFile.exe"+" "+"D:\\TC1800579_Rev0.xlsx");
			
			//Runtime.getRuntime().exec("D:\\contractUpload.exe");
			
			System.out.println("after executing file");
			
		} catch (IOException eautoIt) {
			
			System.out.println("Exception at AutoIT file upload script calling "+eautoIt.getMessage());
			
		}
		
		
		Contpg.clickOnUploadFile();
				 	
		String msg = Contpg.getMsg();
		 
		//String msg = element.getText();
		
		//System.out.println("Before if loop "+msg);
		
		if(msg.contains("failed"))
			
		{
			System.out.println("Printing error message "+msg);
			
			Assert.assertEquals("A","B");
			
			logger.log(LogStatus.FAIL,"Please Upload correct excell file" );
		}
			
		WebElement onlineJobLink = driver.findElement(By.xpath("//div[@id='divUploadSuccess']/div/div/a"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(onlineJobLink).click().build().perform();
		
		WebDriverWait waitMultiOnline = new WebDriverWait(driver,10);
		
		waitMultiOnline.until(ExpectedConditions.numberOfWindowsToBe(3));
		
		
		Set<String> allWinControls1 = driver.getWindowHandles();
		
		
		//ContEntryPages Contpg = PageFactory.initElements(driver,ContEntryPages.class);
		
		JobMonitoringScreen jms = PageFactory.initElements(driver,JobMonitoringScreen.class);
		
		
		for(String s: allWinControls1 )
		{
			driver.switchTo().window(s);
			
			
			
			//WebElement onlinePageHeader = driver.findElement(By.xpath("//div[@class='window_title']/h2"));
			
			if(jms.getTitle().contains("Online"))
			{
				driver.manage().window().maximize();
				
				break;
				
				
			}
			
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String jobStatus = jms.getStatus();
	
		
		System.out.println(" First Job Status "+jobStatus);
		
		for(int i=0;i<=30;i++)				
		{
			//System.out.println("Within for loop of refresh status");
			
			String jobStatusckh = jms.getStatus();
			
			if((jobStatusckh.equals("Success"))||(jobStatusckh.equals("Error")))
			{
				System.out.println("Final Status of Job - "+jobStatusckh);
				break;
				
			}
			
			jms.clickOnRefresh();
			
			try {
				Thread.sleep(20000);
				
			} catch (InterruptedException eJobExcep) 
			{
				
				System.out.println("Exception id thread "+eJobExcep.getMessage());
			}
			
			
			
		}
				
		logger.log(LogStatus.PASS,"Updated Successfully");
		
		report.endTest(logger);
		
		report.flush();
				
	}
	

}
