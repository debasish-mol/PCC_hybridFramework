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

public class ContEntryPages {
	
	public WebDriver driver;
	
	public ContEntryPages(WebDriver driver) 
	{
		this.driver=driver;
	}

	@FindBy(xpath=".//*[@id='divContract']/form/div[3]/div[1]/div[4]/div[1]/span[1]/span/span[2]/span") WebElement ContTypeLov;
	
		
	@FindBy(xpath="//ul[@id='ContractType_listbox']/li") List<WebElement> ContTypeSelect;
	
	@FindBy(id="ContractName") WebElement ContName;
	
	@FindBy(id="MainCustName") WebElement MainCustName;
	
	@FindBy(xpath= "//input[@id='EffectiveDate']") WebElement ContEffectDate;
	
	@FindBy(xpath="//input[@id='ExpiryDate']") WebElement ContExpiryDate;
	
	@FindBy(xpath="//input[@id='btnSaveHdr']") WebElement ContSave;
	
	@FindBy(xpath="//div[@title='ADD LP-DP']") WebElement ContAddLpDp;
	
	@FindBy(xpath="//span[@id='spnContNo']") WebElement ContNo;
	
	@FindBy(xpath="//input[@id='LoadPort']") WebElement ContLoadPort;
	
	@FindBy(xpath="//input[@id='DschPort']") WebElement ContDschPort;
	
	@FindBy(xpath="//input[@id='btnSaveLPDP']") WebElement ContADDLpDpSave;
	
	@FindBy(xpath="//div[@title='ADD MAKE-MODEL']") WebElement ContAddMakeModel;
	
	
	@FindBy(xpath="//span[@aria-owns='CargoTypeCode_listbox']/span/span[2]") WebElement ContCargoType;
	
	@FindBy(xpath="//ul[@id='CargoTypeCode_listbox']/li") List<WebElement> ContCargoTypeList;
	
	@FindBy(xpath="//input[@id='MakeName']") WebElement ContMakeName;
	
	@FindBy(xpath="//input[@id='ModelName']") WebElement ContModelName;
	
	@FindBy(xpath="//input[@id='btnRevenueAdd']") WebElement ContADDModifyRevenue;
	
	@FindBy(xpath="//input[@id='ChrgCode']") WebElement ContChgeCode;
	
	@FindBy(xpath="//span[@aria-owns='BaseCode_listbox']/span/span[2]") WebElement ContBaseCode;
	
		
	@FindBy(xpath="//ul[@id='BaseCode_listbox']/li") List<WebElement> ContBaseCodeList;
	
    @FindBy(xpath="//td[@data-container-for='Rate']/span/span/input[1]") WebElement ContRate;
	
	@FindBy(xpath="//td[@data-container-for='Currency']/input[@id='Currency']") WebElement ContCurrency;
	
	@FindBy(xpath="//td[@data-container-for='PrepaidCollect']/span/span/span[2]") WebElement ContPreCol;
	
	@FindBy(xpath="//ul[@id='PrepaidCollect_listbox']/li") List<WebElement> ContPreColList;
	
	@FindBy(xpath="//input[@id='FreightCollectOfcName']") WebElement ContFrtCollOfc;
	
	@FindBy(xpath="//input[@id='InvOfcName']") WebElement ContInvOfc;
	
	@FindBy(xpath="//Input[@id='Payer']") WebElement payer;
	
	@FindBy(xpath="//input[@id='btnSave1']") WebElement ContRevSave;
	
	@FindBy(xpath = "//input[@id='btnRevenueClose']") WebElement ContRevWinClose;
	
	@FindBy(xpath="//input[@id='btnSaveCargo']") WebElement ContCargoSave;
	
	
	//@FindBy(xpath="//span[@aria-owns='ContractStatus_listbox']/span/span[1]") WebElement ContStatus;
	
	
	@FindBy(xpath="//*[@id='divContract']/form/div[3]/div[1]/div[4]/div[5]/span[1]/span/span[1]") WebElement ContStatus;
	
		
	@FindBy(xpath="//ul[@id='ContractStatus_listbox']/li") List<WebElement> ContStatusList;
	
	@FindBy(xpath="//input[@id='btnSaveHdr']")  WebElement hdrSave;
	
	@FindBy(xpath="//input[@id='SalesPerson']")  WebElement SalesPerson;
	
	@FindBy(xpath="html/body/div[2]/div[1]/h2") WebElement pageheader;
	
	
	
	public String getPageHeader()
	{
		 String pageName = pageheader.getText();
		 
		 return pageName;
	}
	
	public void EnterSalesPerson()
	{
		SalesPerson.sendKeys("SEIJI YOKOMIZO");
		
		SalesPerson.sendKeys(Keys.ENTER);
	}
	
	
	public void ClickOnHdrSave()
	{
		
		hdrSave.click();
		
	}
	 
	public void SelectContactStatus() throws InterruptedException
	{
		ContStatus.click();
		
		Thread.sleep(2000);
		
		for(WebElement e: ContStatusList)
		{
			if(e.getText().equals("Complete"))
			{
				System.out.println("Selecting Contact Status"+e.getText());
				
				e.click();
				
			}
						
		}
				
	}
	
	
	
	
	public void ContractType(String name) throws InterruptedException
	{
		ContTypeLov.click();
		
		Thread.sleep(2000);
		
		for(WebElement e: ContTypeSelect)
		{
			if(e.getText().equals(name))
			{
				e.click();
			}
		}
		
	}
	
	
	public void EnterContractName(String name)
	{
		ContName.sendKeys(name);
	}
	
	public void EnterMainCustomer(String name)
	{
		MainCustName.sendKeys(name);
	}
	
	
	public void EnterEffectivedate(String date)
	{
		ContEffectDate.sendKeys(date);
	}
	
	public void EnterExpiryDate(String date)
	{
		ContExpiryDate.sendKeys(date);
	}
	
	public void ClickOnFirstPageSave()
	{
		ContSave.click();
	}
	
	
	public void ToCheckAddLpDpVisibility()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.visibilityOf(ContAddLpDp));
		
		
	}
	
	
	public void PrintContNo()
	{
		String Contact_No = ContNo.getText();
		
		System.out.println("Printing Cont No "+Contact_No);
		
		try {
			
			DataProviderFactory.getExcel().WriteDataExcel("bldata",1,1,Contact_No);
		
		} catch (IOException e) {
			
			System.out.println("Exception "+e.getMessage());
		}
	}
	
	
	
	public void EnterContLoadPort(String name) throws InterruptedException
	{
		ContLoadPort.sendKeys(name);
		
		Thread.sleep(2000);
		
		ContLoadPort.sendKeys(Keys.TAB);
		
	}
	
	public void EnterContDisPort(String name) throws InterruptedException
	{
		ContDschPort.sendKeys(name);
		
		Thread.sleep(2000);
	}
	
	
	public void ClickOnContADDLpDpSave()
	{
		ContADDLpDpSave.click();
	}
	
	
	
	public void ToCheckVisibilityOfAddMakeModel()
	{
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		
		wait1.until(ExpectedConditions.visibilityOf(ContAddMakeModel));
		
	}
	
	
	public void EnterCargoType(String name) throws InterruptedException
	{
		 ContCargoType.click();
		 
		 WebDriverWait wait2 = new WebDriverWait(driver,10);
		 
		 wait2.until(ExpectedConditions.visibilityOfAllElements(ContCargoTypeList));
		 
		 for(WebElement e: ContCargoTypeList)
		 {
			if(e.getText().equalsIgnoreCase(name))
			{ 
			 System.out.println("CARGO TYPE "+e.getText());
			 
			 e.click();
			}
			 System.out.println("CARGO TYPE SELECTED "+e.getText());
		 }
		 
		// Thread.sleep(2000);
		 
		// ContCargoType.sendKeys(Keys.TAB);
	}
	
	
	public void EnterContMakeName(String name) throws InterruptedException
	{
		WebDriverWait wait3 = new WebDriverWait(driver,20);
		wait3.until(ExpectedConditions.visibilityOf(ContMakeName));
		
				
		ContMakeName.click();
		
		ContMakeName.sendKeys(name);
		//Thread.sleep(2000);
		
		ContMakeName.sendKeys(Keys.TAB);
		
	}
	
	
	public void EnterContModelName(String name) throws InterruptedException
	{
		WebDriverWait wait5 = new WebDriverWait(driver,10);
		wait5.until(ExpectedConditions.visibilityOf(ContModelName));
		
		ContModelName.click();
		
		ContModelName.sendKeys(name);
		Thread.sleep(1000);
	}
	
	
	public void EnterContADDModifyRevenue(String BaseCode) throws InterruptedException
	{
		ContADDModifyRevenue.click();
		
		Thread.sleep(2000);
		
		ContBaseCode.click();
		
		Thread.sleep(1000);
		
		for(WebElement e : ContBaseCodeList)
		{
			
			if(e.getText().equalsIgnoreCase(BaseCode))
			{
			System.out.println("Printing base Code "+e.getText());
			
			e.click();
			}
		}
		
		ContRate.sendKeys("2000");
		
		ContCurrency.sendKeys("SGD");
		
		Thread.sleep(1000);
		
		ContPreCol.click();
		
		Thread.sleep(1000);
		
		
		for(WebElement e: ContPreColList)
		{
			if(e.getText().equalsIgnoreCase("P"))
			{
			System.out.println("Prepaid or Collect "+e.getText());
			
			e.click();
			}
		}
		
		
		ContFrtCollOfc.sendKeys("MOLSIN");
		
		Thread.sleep(2000);
		
		ContFrtCollOfc.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		ContInvOfc.sendKeys("MOLSIN");
		
		Thread.sleep(2000);
		
		ContInvOfc.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		payer.sendKeys("5117553");
		
		Thread.sleep(3500);
		
		ContRevSave.click();
		
		Thread.sleep(2000);
		
		ContRevWinClose.click();
		
	}
	
	public void ConCragoSaveButton()
	{
		WebDriverWait wait5 = new WebDriverWait(driver,10);
		
		wait5.until(ExpectedConditions.elementToBeClickable(ContCargoSave));
		
		
		ContCargoSave.click();
	}
	
	
}
