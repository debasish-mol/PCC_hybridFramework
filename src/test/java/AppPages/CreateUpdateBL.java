package AppPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Factory.DataProviderFactory;

public class CreateUpdateBL {
	
	public WebDriver driver;
	
	public CreateUpdateBL(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
		
	By title = By.xpath("//h2");
    
	@FindBy(xpath="//h2") WebElement tittle;
	
	@FindBy(name="txtPkgDscr") WebElement gddescrip;
	
	@FindBy(xpath="//div[@id='grdBlCargo']/div/table[@class='k-selectable' ]/tbody/tr/td[text()='1']") WebElement gdSeq1;
	
	 @FindBy(xpath="//div[@id='grdBlCargo']/div/table[@class='k-selectable' ]/tbody/tr/td[text()='2']") WebElement gdSeq2;
	 
	 @FindBy(xpath="//div[@id='grdBlCargo']/div/table[@class='k-selectable' ]/tbody/tr/td[text()='3']") WebElement gdSeq3;
	 
	 //Total no of row at Good Description table
	 
	 @FindBy(xpath="//div[@id='grdBlCargo']/div/table[@class='k-selectable' ]/tbody/tr") List<WebElement> TotalNoOfCargo;
	 
	 @FindBy(id="btnSave") WebElement save;
	 
	 @FindBy(name="XnsTxt") WebElement textArea;
	 
	 @FindBy(xpath="//input[@value='SAVE LOG']") WebElement saveLog;
	 
	 @FindBy(id="btnComplete") WebElement CompleteBtn;
	 
	 @FindBy(id="BlNo") WebElement BL_NO;
	 
	 @FindBy(xpath="//textarea[@id='txtAreaRemarks']") WebElement cmplTextArea;
	 
	 @FindBy(xpath="//input[@id='btnContinue']") WebElement cmplSaveLog;
	 
	 @FindBy(xpath="//input[@value='READY FOR INV/ISS']") WebElement redyForInvIssue;
	 
	 @FindBy(id="btnGenerateBL") WebElement BLImage;
	 
	 @FindBy(xpath="//input[@id='ShpFwdRef']") WebElement CustSIRef;
	 
	 @FindBy(css="input#btnAddFreight") WebElement AddFreight;
	 
	 @FindBy(css="input[id='ChrgCode'][name='ChrgCode']") WebElement addchargeCode;
	 
	 @FindBy(css="input#MakeModelNoTxt") WebElement makeModel;
	 
	// @FindBy(css="input[id='BlDt']") WebElement basis;
	 
	 @FindBy(xpath=".//*[@id='AddEditPnl']/div[1]/div/div[1]/div[4]/div[4]/span[1]/span/span[2]/span") WebElement basis;
	 
	 //List<WebElement> list_basis = driver.findElements(By.xpath("//ul[@id='BasCode_listbox']/li"));
	 
	 @FindBy(xpath="//ul[@id='BasCode_listbox']/li") List<WebElement> list_basis; 
	 
	 @FindBy(id="RatedAt") WebElement ratedAt;
	 
	 @FindBy(css="input#Rate") WebElement rate;
	 
	 @FindBy(css="input[id='Currency']") WebElement currency;
	 
	 @FindBy(css="input#FrtCollOfcNm") WebElement FreightcolOffice;
	 
	 @FindBy(css="input#InvOfcNm") WebElement invoiceOffice;
	 
	 @FindBy(css="input#CustName") WebElement payer;
	 
	 @FindBy(xpath="//li[text()='Per Unit basis']") WebElement BasisPerUnit;
	 
	 @FindBy(xpath="//input[@id='btnAddFreightOK']") WebElement RevenueAcceptButton;
	 
	 
	 public void BasisValueSelect()
	 {
		 for(WebElement e: list_basis)
		 {
			if( e.getText().equals("Per Bill"))
			{
				e.click();
				System.out.println("Printing basis select"+e.getText());
			}
		 }
	 }
	 
	 
	 
	 public void VerifyTitle()
	 {
		 WebDriverWait wait = new  WebDriverWait(driver,10);
		 
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(title));
		
		String text = ele.getText();
		
		//Assert.assertEquals(text,"Create/Modify Bill of Lading(OPBLW03)", "Not Opened required pages");
		
		//Assert.assertEquals(text.contains("Lading"),"Create/Modify Bill of Lading(OPBLW03)" );
		
		System.out.println("Text is "+text);
		
		Assert.assertTrue(text.contains("Create"));
	 }
	 
	 public void setGoodsDescription() throws InterruptedException
	 {
		System.out.println("Total no of cargo - "+TotalNoOfCargo.size()); 
		
		int cargoNo = TotalNoOfCargo.size();
		
		System.out.println("Total goods coiunt"+cargoNo);
		
		
		gdSeq1.click();
		
		gddescrip.sendKeys(DataProviderFactory.getExcel().getStringData("bldata",9,3));
		
		
		
		if (cargoNo> 1)
		{ 
			
			System.out.println("Inside If Loop");
			
			Thread.sleep(4000);
			
			for(int i=2;i<=cargoNo;i++)
			{
				System.out.println("Inside If for loop");
				
				TotalNoOfCargo.get(i-1).click();
				
				Thread.sleep(3000);
				
				gddescrip.sendKeys(DataProviderFactory.getExcel().getStringData("bldata",9,3)+i);
				
			}
			
			
			
		}
		
		CustSIRef.click();
		
		/* 
		 
		 
		 TotalNoOfCargo.get(1).click();
		 
		 Thread.sleep(3000);
		 
		 gddescrip.sendKeys("generated from B/L print and Mass B/L print for Agent Screen2");
		 
		 TotalNoOfCargo.get(2).click();
		 
		 Thread.sleep(3000);
		 
		 gddescrip.sendKeys("generated from B/L print and Mass B/L print for Agent Screen3");
		 
		 TotalNoOfCargo.get(1).click();
		 Thread.sleep(2000);
		 
		 */
		 
		 
		/*		 
		 gdSeq2.click();		 
		 
		 Thread.sleep(3000);
		 
		 if(gdSeq2.isSelected())
		 {
		 gddescrip.sendKeys("generated from B/L print and Mass B/L print for Agent Screen2"); 
		 }				 
		 else
		 {
			 gdSeq2.click();
			 
			 gddescrip.sendKeys("generated from B/L print and Mass B/L print for Agent Screen2");
		 }		 
		
		 gdSeq3.click();
		 
		 Thread.sleep(3000);
		 
		 gddescrip.sendKeys("generated from B/L print and Mass B/L print for Agent Screen3");
		 */
		 
		 
		 
		 
		 
	 }
	
	 public void AddRevenue() throws InterruptedException
	 {
			
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 
		 AddFreight.click();
		 
		 Thread.sleep(3000);
		 
		 addchargeCode.sendKeys("ADH");
		 
		 		 
		 Thread.sleep(2000);
		 
		 addchargeCode.sendKeys(Keys.TAB);
		 
		 addchargeCode.sendKeys(Keys.TAB);
		 
		 basis.click();
		 
		 Thread.sleep(2000);
		 
		// BasisPerUnit.click();
		 
		  //BasisValueSelect();
		 
		 for(WebElement e: list_basis)
		 {
			if( e.getText().equals("Per Bill"))
			{
				e.click();
				System.out.println("Printing basis select"+e.getText());
			}
		 }
		 
		 
		 
		 Thread.sleep(2000);
		 
		 
		 rate.sendKeys("600");
		 
		 
		 currency.sendKeys("USD");
		 
		 Thread.sleep(2000);
		 
		 FreightcolOffice.sendKeys("molsin");
		 
		 Thread.sleep(3000);
		 
		 FreightcolOffice.sendKeys(Keys.ENTER);
		 
		 Thread.sleep(2000);
		 
		 
		 invoiceOffice.sendKeys("molsin");
		 
		 Thread.sleep(3000);
		 
		 invoiceOffice.sendKeys(Keys.ENTER);
		 
		 Thread.sleep(2000);
		 
		 payer.sendKeys("5117553");
		 
		 Thread.sleep(3000);
		 
		 
		 RevenueAcceptButton.click();
		 
		 Thread.sleep(3000);
		 
		 
	 }
	 
	 
	 
	 public void clickOnSave() throws InterruptedException
	 {
		 Thread.sleep(3000);
		 
		 save.click();
	 }
	 
	 public void transactionLog()
	 {
		 textArea.sendKeys("Text Area");
		 
		 saveLog.click();
				 
	 }
	 
	 public void clickOnComplete()
	 {
		 CompleteBtn.click();
	 }
	 
	 public void getBLNumber()
	 {
		 String bl_number=BL_NO.getText();
		 
		 System.out.println("B/L Number- "+bl_number);
				 
	 }
	 
	 public void cmplTransactionLog()
	 {
		 cmplTextArea.sendKeys("TextArea Complete");
		 
		 cmplSaveLog.click();
	 }
	 
	 public void ReadyForInvoiceIssue()
	 {
		 redyForInvIssue.click();
	 }
	 
	 public void BLImageGenerator()
	 {
		 BLImage.click();
	 }
	 
	 

}
