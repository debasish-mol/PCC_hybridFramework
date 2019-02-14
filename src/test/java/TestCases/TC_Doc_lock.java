package TestCases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AppPages.DockLockPage;
import AppPages.InvokeCreateBL;
import AppPages.JobMonitoringScreen;
import AppPages.loginPages;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class TC_Doc_lock {
	
	public WebDriver driver;

	ExtentReports report;

	ExtentTest logger;
	
	loginPages home;
	
	@BeforeMethod
	public void setup() 
	{
		report = new ExtentReports(".//Reports//BLWiseDocLock.html",true);
		
		logger= report.startTest("BLWiseDocLock");
		
		BrowserFactory br = new BrowserFactory();
		
        driver = br.getBrowser();
        
        logger.log(LogStatus.INFO,"Browser opened");
		
        String url="docLockUrl";
        
		driver.get(DataProviderFactory.getConfig().getUrl(url));
		
		home = PageFactory.initElements(driver, loginPages.class);
		
		home.loginInfo();	
		
		logger.log(LogStatus.INFO,"Login succesfully");
		
	}
	
	@Test
	public void dockLockTest()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		DockLockPage dl = PageFactory.initElements(driver, DockLockPage.class);
		
		String excelPath="D:\\all\\personal\\backup\\Selenium3\\SeleniumProgram\\com.Pcc.Net.Hybridframework\\ApplicationTestData\\CreateVessel.xlsx";
		
		String vesselCode=DataProviderFactory.getExcel().getvalue(excelPath,"DockLock",1,0);
		
		if(!vesselCode.equals("NoValue"))
		{
			dl.enter_vsl_name(vesselCode);
			
			logger.log(LogStatus.INFO,"Entered vessel code");
		}
		
		String voyageCode=DataProviderFactory.getExcel().getvalue(excelPath,"DockLock",1,1);
		
		if(!voyageCode.equals("NoValue"))
		{
			dl.enter_voy_code(voyageCode);
			
			logger.log(LogStatus.INFO,"Entered voyage code");
		}
		
		String portCode=DataProviderFactory.getExcel().getvalue(excelPath,"DockLock",1,2);
		
		if(!portCode.equals("NoValue"))
		{
			dl.enter_portName(portCode);;
			
			logger.log(LogStatus.INFO,"Entered port code");
		}
		
		String callOrder=DataProviderFactory.getExcel().getvalue(excelPath,"DockLock",1,3);
		
		if(!callOrder.equals("NoValue"))
		{
			dl.enter_call_order(callOrder);
			
			logger.log(LogStatus.INFO,"Entered call order");
		}
		
		dl.click_Search_Button();
		
		
		String portCodeDOCLock=DataProviderFactory.getExcel().getvalue(excelPath,"DockLock",1,4);
		
		String BLNo = DataProviderFactory.getExcel().getvalue(excelPath,"DockLock",1,5);
		
		if(!(portCodeDOCLock.equals("NoValue") && BLNo.equals("NoValue")))
		{
			dl.selectPort(portCodeDOCLock,BLNo);
			
			logger.log(LogStatus.INFO,"Entered port for BLwise Doc Lock");
		}
		
		WebElement onlineJobLink = driver.findElement(By.xpath("//div[@id='uxMsg-div']/div/a"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(onlineJobLink).click().build();
		
		WebDriverWait waitMultiOnline = new WebDriverWait(driver,10);
		
		waitMultiOnline.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		
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
				
		
		
		
		
		
		
		
	}
	
	

}
