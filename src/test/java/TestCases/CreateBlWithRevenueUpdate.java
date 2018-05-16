package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AppPages.CreateUpdateBL;
import AppPages.InvokeCreateBL;
import AppPages.loginPages;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class CreateBlWithRevenueUpdate {
	
public WebDriver driver;
	
	loginPages home;
	
	@BeforeMethod
	public void setup() 
	{
		BrowserFactory br = new BrowserFactory();
		
        driver = br.getBrowser("Chrome");
		
        String url="Blurl";
        
		driver.get(DataProviderFactory.getConfig().getUrl(url));
		
		//Thread.sleep(4000);
		
		 home = PageFactory.initElements(driver, loginPages.class);
		
		home.loginInfo();	
		
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
		
		String bkg_No = DataProviderFactory.getExcel().getBookingNoString("bldata",0,1);
		
		cbl.setBkgNo(bkg_No);
		
		cbl.proceedButton();
		
	/*}
	
	@Test(priority=3)
	public void CreateUpdateBLTest() throws InterruptedException
	{*/
		
		CreateUpdateBL cubl = PageFactory.initElements(driver, CreateUpdateBL.class);
		
		cubl.setGoodsDescription();
		
		Thread.sleep(3000);
		
		cubl.AddRevenue();
		
		Thread.sleep(3000);
		
         cubl.clickOnSave();
         
         Thread.sleep(3000);
         
		cubl.transactionLog();
		
		Thread.sleep(3000);
					
		cubl.getBLNumber();
		
		Thread.sleep(3000);
		
		cubl.clickOnComplete();
		
		Thread.sleep(3000);
		
		cubl.transactionLog();
		
		Thread.sleep(3000);
		
		cubl.ReadyForInvoiceIssue();
		
		Thread.sleep(3000);
		
		cubl.transactionLog();
		
		
		
		
		
	
	}

}
