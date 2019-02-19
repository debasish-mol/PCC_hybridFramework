package AppPages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jna.platform.win32.OaIdl.SYSKIND;

import Factory.DataProviderFactory;
import Utility.Helper;

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
	
	@FindBy(xpath="//input[@id='txtCNSCity']") WebElement consigneeCity;
	
	@FindBy(xpath=".//input[@id='txtPostCNSCode']") WebElement consigneePinCode;
	
	@FindBy(xpath="//input[@id='btnAddRoute']") WebElement Add_leg;
	
	@FindBy(xpath="//input[@id='btnPopup1']") WebElement voyage_search;
	
	@FindBy(xpath="//div[@id='grdVoyegeSelected-btnPopup1']/table/tbody/tr[1]/td[2]") WebElement SelectVesselVoyage;
	
	@FindBy(xpath="//input[@id='btnSelect-divLOV-btnPopup1']") WebElement SelectButton;
	
	@FindBy(xpath="//input[@id='btnEditCargo0']") WebElement EditCargo1Button;
	
	@FindBy(xpath="//div[@id='gridCargoMaster']/div[1]/table/tbody/tr") List<WebElement> totalNoOfModel;
	
	@FindBy(xpath="//input[@id='txtCargoCnt']") WebElement NoOfCargoUnit;
	
	@FindBy(xpath="//input[@id='btnCargoOK']") WebElement CargoOKButton;
	
	@FindBy(xpath="//input[@id='btnSaveBottom']") WebElement SaveButton;
	
	@FindBy(xpath="//*[@id='frmCreateUpdateBkg']/div[2]/div[3]/div/div/div[5]/span/span/span[2]/span") WebElement Status;
	
	@FindBy(xpath="//ul[@id='ddlBkgSts_listbox']/li") List<WebElement> StatusList;
	
	@FindBy(xpath="//input[@id='btnSaveTop']") WebElement SaveButtonTop;
	
	@FindBy(xpath="//a[@id='lnkBkgno']") WebElement BookingNo;
	
	@FindBy(xpath="//textarea[@id='txtAreaRemarks']") WebElement AddTransactionLog;
	
	@FindBy(xpath="//input[@id='btnContinue']") WebElement TransactionSaveButton;
	
	@FindBy(xpath="//span[@id='uxMsg-div_wnd_title']") WebElement WarningWindow;
	
	@FindBy(xpath="//input[@id='uxMsg-button1']") WebElement duplicateBookingYes;
	
	@FindBy(xpath="//div[@id='grdVoyegeSelected-btnPopup1']/table/tbody/tr") List<WebElement> voyMatched;
	
	@FindBy(xpath="//div[@id='grdVoyegeSelected-btnPopup1']/table/tbody/tr/td[2]") List<WebElement> allVoyName;
	
	@FindBy(xpath="//div[@id='CreateBkgRevGrid']/table/thead/tr/th[3]") WebElement selectAllRevenue;
	
	
	
	
	
	
	public void EnterTransactionLog()
	{
		WebDriverWait waitTranLog = new WebDriverWait(driver,10);
		
		waitTranLog.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@id='popupWindow_wnd_title']")));
		
		AddTransactionLog.sendKeys("Added by Auto");
		
		TransactionSaveButton.click();
	}
	
	
	public void EnterCnsTab(String Customer_code) throws InterruptedException
	{
		
		CnsTab.click();
		
		WebDriverWait waitCns = new WebDriverWait(driver,10);
		
		waitCns.until(ExpectedConditions.visibilityOf(MolConsigneeName));
		
		MolConsigneeName.sendKeys(Customer_code);  // can't use explicit wait as value field is
													//not populated after entering customer code.
		
		Thread.sleep(3000);
		
		MolConsigneeName.sendKeys(Keys.ENTER);
		
		//MolConsigneeName
		
		consigneeCity.sendKeys("Ecocenter");
		
		consigneePinCode.sendKeys("700091");
		
		
		
		
	}
	
	
	public void Enter_Doc_Entry_Office(String value) throws InterruptedException
	{
		Doc_Entry_Office.clear();
		
		Doc_Entry_Office.sendKeys(value);
		
		WebDriverWait waitdocEntry = new WebDriverWait(driver,10);
		
		waitdocEntry.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='gridLovOrg-txtDocEntryOfc']/table/tbody/tr")));
		
		//Thread.sleep(2000);
		
		Doc_Entry_Office.sendKeys(Keys.ENTER);
		
			
	}	
	
	public void Enter_Doc_Issue_Office(String value) throws InterruptedException
	{
		Doc_Issue_Office.clear();
		
		Doc_Issue_Office.sendKeys(value);
		
		//Thread.sleep(2000);
		
		WebDriverWait waitdocEntry = new WebDriverWait(driver,10);
		
		waitdocEntry.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='gridLovOrg-txtDocIssueOfc']/table/tbody/tr")));
		
		
		Doc_Issue_Office.sendKeys(Keys.ENTER);
		
		}
	
	
	public void ClickOnVoyageSearch(String S_voy_name) throws InterruptedException
	{
		Add_leg.click();
		
		
		WebElement voyageSearch = Helper.isElementPresent(driver,"//input[@id='btnPopup1']",15);
		
		voyageSearch.click();
		
		//WebDriverWait waitVoyageSeach = new WebDriverWait(driver,10);
		
		//waitVoyageSeach.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='grdVoyegeSelected-btnPopup1']/table/tbody/tr")));
		
		
		Thread.sleep(3000);
		
		System.out.println("Total no of voyage found for this route "+voyMatched.size());
		
		System.out.println("Required voyage "+S_voy_name);
		
		if(voyMatched.size()>0)
		{
			int voy_count = allVoyName.size();
			
			for(int i=1;i<=voy_count;i++)
			{
				System.out.println("Within for loop of voyage");
				
				Actions act = new Actions(driver);
				
				System.out.println("Voyage name "+driver.findElement(By.xpath("//*[@id='grdVoyegeSelected-btnPopup1']/table/tbody/tr["+i+"]/td[2]")).getText());
				
				if(driver.findElement(By.xpath("//*[@id='grdVoyegeSelected-btnPopup1']/table/tbody/tr["+i+"]/td[2]")).getText().equalsIgnoreCase(S_voy_name))
				{
					System.out.println("voyage matched");
					
					//Thread.sleep(1500);
															
													
					act.sendKeys(Keys.ENTER).build().perform();
					
					break;
					
				}
				
				act.sendKeys(Keys.ARROW_DOWN).build().perform();
				
			}
			
			
		}
		else
			System.out.println("No voyage found for given load and discharge port");
		
		//SelectVesselVoyage.click();
		
		//SelectButton.click();
		
		//Thread.sleep(2000);
		
		WebDriverWait waitVoyageDeleteButton = new WebDriverWait(driver,10);
		
		waitVoyageDeleteButton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@id='btnDelete1']")));
		
		
		
	}
	
	public int totalCargo()
	{
		return  totalNoOfModel.size();
	}
	
	
	public void clickcargo(int i)
	{
		
		for(int j=1;j<=2;j++)
			 
		{
		 
		  try{
		 
			  Thread.sleep(2000);
						  
			//div[@id='gridCargoMaster']/div[1]/div/div/table/tbody/tr["+i+"]/td[19]/input[@id='btnEditCargo0']
			  
			//div[@id='gridCargoMaster']/div[1]/table/tbody/tr["+i+"]/td[19]/input[@id='btnEditCargo0']
					  
			  WebElement e1 = driver.findElement(By.xpath("//div[@id='gridCargoMaster']//table/tbody/tr["+i+"]/td[19]/input[@id='btnEditCargo0']"));
				
				//((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+e1.getLocation().y+")");
			  
			  JavascriptExecutor jse = (JavascriptExecutor)driver;
			  
			  jse.executeScript("arguments[0].scrollIntoView();", e1);
				
				Actions act = new Actions(driver);
				
				act.moveToElement(e1).click().build().perform();
				
				System.out.println("Data entered for row "+i);
				
				//e1.click();
		 
		    break;
		 
		}
		 
		catch(Exception excep)
		{
		 
		System.out.println(excep.getMessage());
		 
		}
		 
		}
		
		WebDriverWait waitEditCargo = new WebDriverWait(driver,10);
		
		waitEditCargo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='popupWindow_wnd_title']")));
		
		
		//int Cargo_Unit_int1 = DataProviderFactory.getExcel().getNumberData("bldata",3,3);
		
		int Cargo_Unit_int = DataProviderFactory.getExcel().getNumberData("bldata",3,3+(i-1));
					
		String Cargo_Unit1 = String.valueOf(Cargo_Unit_int);
		
		NoOfCargoUnit.sendKeys(Cargo_Unit1);
		
		CargoOKButton.click();
		
		WebDriverWait waitCargoDelete = new WebDriverWait(driver,10);
		
		waitCargoDelete.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='btnDeleteCargo0']")));
		
		
	}
	
	public void ClickOnCargoButton() throws InterruptedException
	{
		/*
		EditCargo1Button.click();
		
		*/
		
		int totalNoModel = totalNoOfModel.size();
		
		System.out.println("Total no of model "+totalNoModel);
		
		List<WebElement> models = driver.findElements(By.xpath("//input[@id='btnEditCargo0']"));
		/*
		for(int i=1;i<=totalNoModel;i++)
		{  
			
			Thread.sleep(1000);
			
			System.out.println("Printing the value of i "+i);
			
			models.get(i-1).click();
			
			Thread.sleep(3000);
			
			int Cargo_Unit_int = DataProviderFactory.getExcel().getNumberData("bldata",3,3+(i-1));
						
			String Cargo_Unit = String.valueOf(Cargo_Unit_int);
			
			NoOfCargoUnit.sendKeys(Cargo_Unit);
			
			CargoOKButton.click();
			
			Thread.sleep(3500);
			
			}*/
		
		
		
		
		
		WebElement e1 = driver.findElement(By.xpath("//div[@id='gridCargoMaster']/div[1]/table/tbody/tr[2]/td[19]/input[@title='Click here to Edit']"));
		
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+e1.getLocation().y+")");
		
		e1.click();
		
		Thread.sleep(3000);
		
		int Cargo_Unit_int1 = DataProviderFactory.getExcel().getNumberData("bldata",3,3);
					
		String Cargo_Unit1 = String.valueOf(Cargo_Unit_int1);
		
		NoOfCargoUnit.sendKeys(Cargo_Unit1);
		
		CargoOKButton.click();
		
		Thread.sleep(3500);
		
		
		
		
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
	
	public void warningAcceptBooking()
	{
		
		if(driver.findElements(By.xpath("//span[@id='uxMsg-div_wnd_title']")).size()!=0)
		{
		if(WarningWindow.getText().equalsIgnoreCase("Warning"))
		{
			duplicateBookingYes.click();
		}
		
		}
	}
	
}
