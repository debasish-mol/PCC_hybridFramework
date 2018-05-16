package TestCases;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AppPages.BookingEntryPage;
import AppPages.CreateBookingFromContact;
import AppPages.loginPages;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class CreateBookingFromContactTest {

	
	
public WebDriver driver;
	
	loginPages home;
	
	@BeforeTest
	public void setup()
	{
		BrowserFactory br = new BrowserFactory();
		
		driver = br.getBrowser("Chrome");
		
		String url = "CrBookContact";
		
		driver.get(DataProviderFactory.getConfig().getUrl(url));
		
		 home = PageFactory.initElements(driver, loginPages.class);
			
			home.loginInfo();
				
	}
	
	@Test
	public void CreateBooking() throws InterruptedException
	{
		CreateBookingFromContact cbfc = PageFactory.initElements(driver, CreateBookingFromContact.class);
		
		cbfc.EnterContactNo(DataProviderFactory.getExcel().getBookingNoString("bldata",1,1));
		
		cbfc.ClickOnSearch();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			System.out.println("Exception "+e.getMessage());
		}
		
		cbfc.ClickOnContactNoLink();
		
		String currWindowUrl = driver.getWindowHandle();
		
		Set<String> allWindowUrl = driver.getWindowHandles();
		
		for(String s: allWindowUrl )
		{
			driver.switchTo().window(s);
			
			if(driver.findElement(By.xpath("html/body/div[2]/div[1]/h2")).getText().contains("View Contract"))
			{
				System.out.println("Inside If loop");
				
				break;
			}
			
			System.out.println("outside If loop");
			
		}
		
		System.out.println("outside for loop");
		
		Thread.sleep(4000);
		
		cbfc.ClickOnCreateButton();
		
		Thread.sleep(3000);
		
		BookingEntryPage bep = PageFactory.initElements(driver,BookingEntryPage.class);
		
		bep.Enter_Doc_Entry_Office("MOLSIN");
		
		bep.Enter_Doc_Issue_Office("MOLSIN");
		
		bep.EnterCnsTab("5056735");
		
		bep.ClickOnVoyageSearch();
		
		bep.ClickOnCargoButton();
		
		bep.ClickOnSaveButton();
		
		Thread.sleep(5000);
		
		System.out.println("Draft saved");
		
		bep.getBookingNo();  // Printing Booking Number at console as well as writting to excell file 
		
		bep.SelectStatusOfBooking("Requested");
		
				
		bep.ClickOnSaveButton();
		
		bep.EnterTransactionLog();
		
		System.out.println("Requested saved");
		
	}	
		
}
