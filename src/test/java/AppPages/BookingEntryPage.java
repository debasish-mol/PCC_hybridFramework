package AppPages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Factory.DataProviderFactory;

public class BookingEntryPage
{
	
	
	public WebDriver driver;
	
	public BookingEntryPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//input[@id='txtDocEntryOfc']") WebElement Doc_Entry_Office;
	
	@FindBy(xpath="//input[@id='txtDocIssueOfc']") WebElement Doc_Issue_Office;
	
	@FindBy(xpath="//li[@id='cnsTab']/a") WebElement CnsTab;
	
	@FindBy(xpath="//input[@id='txtCNSCustName']") WebElement MolConsigneeName;
	
	@FindBy(xpath="//input[@id='btnAddRoute']") WebElement Add_leg;
	
	@FindBy(xpath="//input[@id='btnPopup1']") WebElement voyage_search;
	
	@FindBy(xpath="//div[@id='grdVoyegeSelected-btnPopup1']/table/tbody/tr[1]/td[2]") WebElement SelectVesselVoyage;
	
	@FindBy(xpath="//input[@id='btnSelect-divLOV-btnPopup1']") WebElement SelectButton;
	
	@FindBy(xpath="//input[@id='btnEditCargo0']") WebElement EditCargo1Button;
	
	@FindBy(xpath="//input[@id='txtCargoCnt']") WebElement NoOfCargoUnit;
	
	@FindBy(xpath="//input[@id='btnCargoOK']") WebElement CargoOKButton;
	
	@FindBy(xpath="//input[@id='btnSaveBottom']") WebElement SaveButton;
	
	@FindBy(xpath="//*[@id='frmCreateUpdateBkg']/div[2]/div[3]/div/div/div[5]/span/span/span[2]/span") WebElement Status;
	
	@FindBy(xpath="//ul[@id='ddlBkgSts_listbox']/li") List<WebElement> StatusList;
	
	@FindBy(xpath="//input[@id='btnSaveTop']") WebElement SaveButtonTop;
	
	@FindBy(xpath="//a[@id='lnkBkgno']") WebElement BookingNo;
	
	@FindBy(xpath="//textarea[@id='txtAreaRemarks']") WebElement AddTransactionLog;
	
	@FindBy(xpath="//input[@id='btnContinue']") WebElement TransactionSaveButton;
	
	
	
	
	
	
	public void EnterTransactionLog()
	{
		AddTransactionLog.sendKeys("Added by Auto");
		
		TransactionSaveButton.click();
	}
	
	
	public void EnterCnsTab(String Customer_code) throws InterruptedException
	{
		
		CnsTab.click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.visibilityOf(MolConsigneeName));
		
		MolConsigneeName.sendKeys(Customer_code);
		
		Thread.sleep(3000);
		
		MolConsigneeName.sendKeys(Keys.ENTER);
		
		//MolConsigneeName
	}
	
	
	public void Enter_Doc_Entry_Office(String value) throws InterruptedException
	{
		Doc_Entry_Office.sendKeys(value);
		
		Thread.sleep(2000);
		
		Doc_Entry_Office.sendKeys(Keys.ENTER);
		
			
	}	
	
	public void Enter_Doc_Issue_Office(String value) throws InterruptedException
	{
		Doc_Issue_Office.sendKeys(value);
		
		Thread.sleep(2000);
		
		Doc_Issue_Office.sendKeys(Keys.ENTER);
		
		}
	
	
	public void ClickOnVoyageSearch() throws InterruptedException
	{
		Add_leg.click();
		
		voyage_search.click();
		
		Thread.sleep(3000);
		
		SelectVesselVoyage.click();
		
		SelectButton.click();
		
		Thread.sleep(2000);
		
		
	}
	
	public void ClickOnCargoButton() throws InterruptedException
	{
		
		EditCargo1Button.click();
		
		Thread.sleep(2000);
		
		NoOfCargoUnit.sendKeys("10");
		
		CargoOKButton.click();
		
		Thread.sleep(2000);
		
			
	}
	
	public void ClickOnSaveButton()
	{
		SaveButton.click();
	}
	
   public void SelectStatusOfBooking(String StatusValue)
   {
	   Status.click();
	   
	   for(WebElement e : StatusList)
	   {
		   System.out.println("Status"+e.getText());
		   
		   if(e.getText().equals(StatusValue))     //Requested Draft  Cancelled
		   {
			   System.out.println("Status selected"+e.getText());
			   
			   e.click();
		   }
			  
	   }	   
		   
   }
   
	public void getBookingNo()
	{
		String Booking_No=BookingNo.getText();
		 
		System.out.println("Booking No "+BookingNo.getText());
		
		try {
			
			DataProviderFactory.getExcel().WriteDataExcel("bldata",2,1,Booking_No);
		
		} catch (IOException e) {
			
			System.out.println("Exception "+e.getMessage());
		}
	}
	
	
	
}
