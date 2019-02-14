package TestCases;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		
		driver = br.getBrowser();
		
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
		
		String Cont_no= DataProviderFactory.getExcel().getBookingNoString("bldata",1,1);
		
		try {
			
			cbfc.ClickOnSearch();
			
		} catch (Exception eSearchButton) {
			
			System.out.println("Exception at search "+eSearchButton);
		}
		
		WebDriverWait waitContSearch = new WebDriverWait(driver,10);
		
		waitContSearch.until(ExpectedConditions.textToBe(By.xpath("//div[@id='gridContract']/table/tbody/tr/td[5]/a"), Cont_no));
		
		
		/*
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			System.out.println("Exception "+e.getMessage());
		}
		*/
		
		String currWindowUrl = driver.getWindowHandle();
		
		try {
			cbfc.ClickOnContactNoLink();
			
		} catch (Exception eContractLink) {
			
			System.out.println("Exception in contract link "+eContractLink.getMessage());
			
		}
		
		
		Set<String> allWindowUrl = driver.getWindowHandles();
		
		for(String s: allWindowUrl )
		{
			driver.switchTo().window(s);
			
			driver.manage().window().maximize();
			
			if(driver.findElement(By.xpath("html/body/div[2]/div[1]/h2")).getText().contains("View Contract"))
			{
				System.out.println("Inside If loop");
				
				break;
			}
			
			System.out.println("outside If loop");
			
		}
		
		System.out.println("outside for loop");
		
		//Thread.sleep(4000);
		
			
		cbfc.selctCargo(DataProviderFactory.getExcel().getStringData("bldata",3,4));
		
		cbfc.ClickOnCreateButton();
		
		WebDriverWait waitBookingScreen = new WebDriverWait(driver,20);
		
		waitBookingScreen.until(ExpectedConditions.textToBe(By.xpath("//div[@class='window_content']/div[@class='window_title']/h2"),"Create/Update Booking (OPBKW02)"));
		
		
		//Thread.sleep(5000);
		
		BookingEntryPage bep = PageFactory.initElements(driver,BookingEntryPage.class);
		
		
		
		
		try {
			
			bep.Enter_Doc_Entry_Office(DataProviderFactory.getExcel().getStringData("bldata",0,3));
			
		} catch (Exception eDocEntry) {
			
			System.out.println("Exception at Doc Entry Office "+eDocEntry.getMessage());
			
		}
		
		try {
			
			bep.Enter_Doc_Issue_Office(DataProviderFactory.getExcel().getStringData("bldata",1,3));
			
		} catch (Exception eDocIssueOffice) {
			
			System.out.println("Exception at Doc Issue Office "+eDocIssueOffice.getMessage());
			
		}
			
		
		int cons_no_int = DataProviderFactory.getExcel().getNumberData("bldata",2,3);
		
				
		String Cons_no = String.valueOf(cons_no_int);
		
		System.out.println("Printing the value of consignee "+Cons_no);
		
		try {
			
			bep.EnterCnsTab(Cons_no);
			
		} catch (Exception eCns) {
			
			System.out.println("Exception at Consignee "+eCns.getMessage());
		}
		
	
		
		//Cargo Unit
		
		int CargoNo = bep.totalCargo();
		
		System.out.println("Total cargo "+CargoNo);
		
		for(int i =1;i<=CargoNo;i++)
		{
					
		bep.clickcargo(i);
				
			
		}
		
		
		/*
		try {
			
			bep.ClickOnCargoButton();
			
		} catch (Exception eCargoSearch) {
			
			System.out.println("Exception at Cargo search "+eCargoSearch.getMessage());
		}
		*/
		
		String VoyName = DataProviderFactory.getExcel().getStringData("bldata",5,3);
		
		try {
			
			bep.ClickOnVoyageSearch(VoyName);
			
		} catch (Exception eVoyageSearch) {
			
			System.out.println("Exception at Voyage search "+eVoyageSearch.getMessage());
			
		}
		
				
		try {
			
			bep.ClickOnSaveButton();
			
		} catch (Exception eBookingSave) {
			
			System.out.println("Exception at Voyage search "+eBookingSave.getMessage());
		}
		
		WebDriverWait waitBookingLog = new WebDriverWait(driver,10);
		
		waitBookingLog.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnBkgLog']")));
		
		//Thread.sleep(5000);
		
		System.out.println("Draft saved");
		
		bep.getBookingNo();  // Printing Booking Number at console as well as writing to excel file 
		
		try {
			
			bep.SelectStatusOfBooking("Requested");
			
		} catch (Exception eBookingStatus) {
			
			System.out.println("Exception at Booking status change "+eBookingStatus.getMessage());
			
		}
		
				
		try {
			bep.ClickOnSaveButton();
			
		} catch (Exception eSaveAfterStatus) {
			
			System.out.println("Exception at Booking save after status change "+eSaveAfterStatus.getMessage());
		}
		
		try {
			
			bep.EnterTransactionLog();
		
		} catch (Exception eTransactionLog) {
			
			System.out.println("Exception at transaction log  "+eTransactionLog.getMessage());
			
		}
		
		bep.warningAcceptBooking();
		
		System.out.println("Requested saved");
		
	}

	private Object Integer(int cons_no_int) {
		// TODO Auto-generated method stub
		return null;
	}	
		
}
		