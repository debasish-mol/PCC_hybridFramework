package TestCases;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AppPages.BookingRouteApprovalPage;
import AppPages.loginPages;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class BookingRouteApproveTest {

	
	public WebDriver driver;
	
	loginPages home;
	
	@BeforeMethod
	public void setup() 
	{
		BrowserFactory br = new BrowserFactory();
		
        driver = br.getBrowser();
        
		String url = "BookingRoute";
		
		driver.get(DataProviderFactory.getConfig().getUrl(url));
		
		//Thread.sleep(4000);
		
		 home = PageFactory.initElements(driver, loginPages.class);
		
		home.loginInfo();	
		
	}
	
	@Test
	public void BookingRouteApproval() throws InterruptedException
	{
		
		BookingRouteApprovalPage brap = PageFactory.initElements(driver,BookingRouteApprovalPage.class);
		
		String Bkg_no = NumberToTextConverter.toText(DataProviderFactory.getExcel().getNumberDataDouble("bldata",0,1));		
			
			
		System.out.println("Printing Booking number String "+Bkg_no);
		
		
		brap.EnterBooking_No_appv(Bkg_no);
		
		Thread.sleep(1500);
		
		brap.ClickOnSearch();
		
		Thread.sleep(3000);
		
		brap.CheckBookingRecord();
		
		brap.ClickOnApproveButton();
		
		Thread.sleep(4000);
		
		brap.SelectRouteStatus("Approved");
		
		
		
		
		
		
		
		
		
	}
	
}
