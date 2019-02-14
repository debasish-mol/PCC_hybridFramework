package AppPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.util.NumberToTextConverter;
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
	
	@FindBy(xpath="//input[@id='txtCustCodeCNS']") WebElement consignee;
    
	@FindBy(xpath="//h2") WebElement tittle;
	
	@FindBy(xpath="//div[@id='divFrom']/div[3]/div[1]/div[4]/div[2]/span/span/span[2]/span") WebElement issueTypeLov;
	
	@FindBy(xpath="//ul[@id='IssueTyp_listbox']/li") List<WebElement> issueTypeLovValue;
	
	@FindBy(name="txtPkgDscr") WebElement gddescrip;
	
	@FindBy(xpath="//div[@id='grdBlCargo']/div/table[@class='k-selectable' ]/tbody/tr/td[text()='1']") WebElement gdSeq1;
	
	 @FindBy(xpath="//div[@id='grdBlCargo']/div/table[@class='k-selectable' ]/tbody/tr/td[text()='2']") WebElement gdSeq2;
	 
	 @FindBy(xpath="//div[@id='grdBlCargo']/div/table[@class='k-selectable' ]/tbody/tr/td[text()='3']") WebElement gdSeq3;
	 
	 //Total no of row at Good Description table
	 
	 @FindBy(xpath="//div[@id='grdBlCargo']/div/table[@class='k-selectable' ]/tbody/tr") List<WebElement> TotalNoOfCargo;
	 
	 @FindBy(xpath="//input[@id='btnBlClause']") WebElement blClause;
	 
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
	 
	 @FindBy(xpath="//span[@id='winEditBlRev_wnd_title']") WebElement addRevenueWinTitle;
	 
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
	 
	 @FindBy(xpath="//div[@id='AddEditPnl']/div[1]/div/div[5]/div[4]/div[1]/span/span/span[2]/span") WebElement paymentMode;
	 
	 @FindBy(xpath="//ul[@id='PpdCol_listbox']/li") List<WebElement> paymentModeList;
	 
	 @FindBy(xpath="//div[@id='AddEditPnl']/div[1]/div/div[5]/div[4]/div[2]/span/span/span[2]/span") WebElement printOn;
	 
	 @FindBy(xpath="//ul[@id='NotOnBl_listbox']/li") List<WebElement> printOnList;
	 
	 @FindBy(css="input#CustName") WebElement payer;
	 
	 	 
	 @FindBy(xpath="//li[text()='Per Unit basis']") WebElement BasisPerUnit;
	 
	 @FindBy(xpath="//input[@id='btnAddFreightOK']") WebElement RevenueAcceptButton;
	 
	 @FindBy(xpath="//input[@id='btnViewRoute']") WebElement View_route;
	 
	 @FindBy(xpath="//span[@id='CmplStsTxt']") WebElement statusOfBl;
	 
	 @FindBy(id="CurrencyDescription") WebElement Currenecy_des;
	 
	 @FindBy(id="ChargeDescription") WebElement Charge_des;
	 
	 @FindBy(id="FrtCollOfc") WebElement freightColOfficeValue;
	 
	 @FindBy(id="InvOfc") WebElement invoiceOfficeValue;
	 
	 @FindBy(xpath="//div[@id='divMessage']/div") WebElement error;
	 
	 
	 public void selectIssueType()
	 {
		 try{
		 
			 Thread.sleep(1000);
		 
		 }catch(Exception eSelectIssueType)
		 {
			 System.out.println("Exception for not ready "+eSelectIssueType.getMessage());
			 
		 }
		 
		 
		 issueTypeLov.click();
		 
		 try{
			 
			 Thread.sleep(1000);
		 
		 }catch(Exception eSelectIssueTypeLov)
		 {
			 System.out.println("Exception for not ready "+eSelectIssueTypeLov.getMessage());
			 
		 }
		 
		 String SissueTypeLovValue = DataProviderFactory.getExcel().getStringData("bldata",19,3);
		 
		 System.out.println("Issue Type LOV value from Excell "+issueTypeLovValue);
		 
		 for(WebElement e: issueTypeLovValue)
		 {
			 if(e.getText().equalsIgnoreCase(SissueTypeLovValue))
			 {
				 e.click();
				 
				 break;
			 }
		 }
		 
		 
		 
		 
	 }
	  
	 
	 public void setConsignee()
	 {
		 WebDriverWait waitConCode = new WebDriverWait(driver,10);
		 
		 waitConCode.until(ExpectedConditions.elementToBeClickable(consignee));
		 
		 consignee.click();
		 
		 String cnsName = consignee.getAttribute("value");
		 
		 System.out.println("Consignee value "+cnsName);
		 
		 if(cnsName.equals(""))
		 {
			 String conCode = NumberToTextConverter.toText(DataProviderFactory.getExcel().getNumberData("bldata",18,3));
			 
			 consignee.sendKeys(conCode);
			 
			 WebDriverWait waitCon = new WebDriverWait(driver,10);
			 
			 waitCon.until(ExpectedConditions.attributeContains(By.xpath("//input[@id='hdnCustCodeCNS']"),"value", conCode));
			 
		 }
		 
	 }
	 
	 
	 public String getError()
	 {
		 if(error.isEnabled())
		 {
			 String text = error.getText();
			 
			 return text;
		 }
		return null;
	 }
	 
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
	 
	 
	 public void waitGoodsDescription()
	 {
		 
		 WebDriverWait wait = new WebDriverWait(driver,10);
			
			wait.until(ExpectedConditions.elementToBeClickable(blClause));
		 
	 }
	 
	 
	 public void VerifyTitle()
	 {
		 WebDriverWait wait1 = new  WebDriverWait(driver,10);
		 
		WebElement ele = wait1.until(ExpectedConditions.presenceOfElementLocated(title));
		
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
		 
		 WebDriverWait wait2 = new WebDriverWait(driver,15);
		 
		 wait2.until(ExpectedConditions.visibilityOf(addRevenueWinTitle));
		 
		 //Thread.sleep(3000);
		 
		 addchargeCode.sendKeys(DataProviderFactory.getExcel().getStringData("bldata",10,3));
		 
		 WebDriverWait wait3 = new WebDriverWait(driver,10);
		 
		// wait3.until(ExpectedConditions.elementToBeClickable(makeModel));
		 
		 wait3.until(ExpectedConditions.attributeToBeNotEmpty(Charge_des,"value"));
		 
		 		 
		// Thread.sleep(2000);
		 
		 addchargeCode.sendKeys(Keys.TAB);
		 
		 addchargeCode.sendKeys(Keys.TAB);
		 
		 basis.click();
		 
		 //Thread.sleep(2000);
		 
		// BasisPerUnit.click();
		 
		  //BasisValueSelect();
		 
		 WebDriverWait wait4 = new WebDriverWait(driver,10);
		 
		 wait4.until(ExpectedConditions.visibilityOfAllElements(list_basis));
		 
		 
		 for(WebElement e: list_basis)
		 {
			if( e.getText().equals(DataProviderFactory.getExcel().getStringData("bldata",11,3)))
			{
				e.click();
				System.out.println("Printing basis select"+e.getText());
			}
		 }
		 
		 
		 WebDriverWait wait5 = new WebDriverWait(driver,10);
		 
		 wait5.until(ExpectedConditions.elementToBeClickable(rate));
		 
		 String rateAmount = NumberToTextConverter.toText(DataProviderFactory.getExcel().getNumberDataDouble("bldata",13,3));
		 
		 rate.clear();
		 
		 rate.sendKeys(rateAmount);
		 
		 
		 currency.sendKeys(DataProviderFactory.getExcel().getStringData("bldata",14,3));
		 
		// Thread.sleep(2000);
		 
		 WebDriverWait wait6 = new WebDriverWait(driver,10);
		 
		// wait6.until(ExpectedConditions.elementToBeClickable(FreightcolOffice));
		 
		 wait6.until(ExpectedConditions.attributeToBeNotEmpty(Currenecy_des, "value"));
		 
		 FreightcolOffice.click();
		 
		 FreightcolOffice.sendKeys(DataProviderFactory.getExcel().getStringData("bldata",12,3));
		 
		 Thread.sleep(3000);
		 
		 FreightcolOffice.sendKeys(Keys.ENTER);
		 
		 WebDriverWait waitFreight = new WebDriverWait(driver,10);
		 
		 waitFreight.until(ExpectedConditions.attributeToBeNotEmpty(freightColOfficeValue,"value"));
		 
		 /*
		 WebDriverWait wait7 = new WebDriverWait(driver,10);
		 
		 wait7.until(ExpectedConditions.elementToBeClickable(invoiceOffice));
		 */
		 
		 invoiceOffice.click();
		 
		 invoiceOffice.sendKeys(DataProviderFactory.getExcel().getStringData("bldata",15,3));
		 
		 Thread.sleep(3000);
		 
		 invoiceOffice.sendKeys(Keys.ENTER);
		 
		// Thread.sleep(2000);
		 
		 WebDriverWait wait8 = new WebDriverWait(driver,10);
		 
		 wait8.until(ExpectedConditions.attributeToBeNotEmpty(invoiceOfficeValue,"value"));
		 
		 String payer_name = NumberToTextConverter.toText(DataProviderFactory.getExcel().getNumberDataDouble("bldata",16,3));
		 
		 payer.sendKeys(payer_name);
		 
		// Thread.sleep(3000);
		 
		 	WebDriverWait wait9 = new WebDriverWait(driver,10);
			
			wait9.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.xpath("//input[@id='PayerCustCode']")),payer_name));
			
		 
		 
		 RevenueAcceptButton.click();
		 
		 Thread.sleep(3000);
		 
		 WebDriverWait wait10 = new WebDriverWait(driver,10);
		 
		 wait10.until(ExpectedConditions.elementToBeClickable(AddFreight));
		 
		 
	 }
	 
	 
	 public void multiRevenueAdd()
	 {
		 
		 String record1 = DataProviderFactory.getExcel().getStringData("bldata",24,0);
		
		System.out.println("1st revenue "+record1);
		
		int rowcount=0;
		
		int rowcount1 = 24;
		
		 while(!record1.equals("NoValue"))
		 {
						
			rowcount++;
							
			rowcount1++;
			
			record1 = DataProviderFactory.getExcel().getStringData("bldata",rowcount1,0);
					
		}
			
		 	System.out.println("Loop count "+rowcount);
		
		
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 
		 
		 for(int loopCount =24 ;loopCount<rowcount+24;loopCount++)
		 { 
		
			 AddFreight.click(); 
		 
		 WebDriverWait wait2 = new WebDriverWait(driver,15);
		 
		 wait2.until(ExpectedConditions.visibilityOf(addRevenueWinTitle));
		 
		 
		 addchargeCode.sendKeys(DataProviderFactory.getExcel().getStringData("bldata",loopCount,0));
		 
		 WebDriverWait wait3 = new WebDriverWait(driver,10);
		 			 
		 wait3.until(ExpectedConditions.attributeToBeNotEmpty(Charge_des,"value"));
		 
		
		 makeModel.click();
		 
		 String modelNametxt = DataProviderFactory.getExcel().getStringData("bldata",loopCount,1);
		 
		 if(!modelNametxt.equals("NoValue"))
		 {
			 makeModel.sendKeys(modelNametxt);
			 try {
				Thread.sleep(1500);
			} catch (InterruptedException emodel) {
				// TODO Auto-generated catch block
				emodel.printStackTrace();
			}
			 
			 makeModel.sendKeys(Keys.ENTER);
			 
		 }
		 
		 // addchargeCode.sendKeys(Keys.TAB);
		 
		 //addchargeCode.sendKeys(Keys.TAB);
		 
		 basis.click();
		 
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException ebasis) {
			
			ebasis.printStackTrace();
		}
		 
		/* WebDriverWait wait4 = new WebDriverWait(driver,20);
		 
		 wait4.until(ExpectedConditions.visibilityOfAllElements(list_basis));
		 */
		 
		 for(WebElement e: list_basis)
		 {
			if( e.getText().contains(DataProviderFactory.getExcel().getStringData("bldata",loopCount,2)))
			{
				e.click();
				
				System.out.println("Printing basis select"+e.getText());
				
				if(DataProviderFactory.getExcel().getStringData("bldata",loopCount,2).equalsIgnoreCase("Percentage basis"))
				{
					
					try {
						Thread.sleep(1500);
						} catch (InterruptedException ePerBasis) 
						{
						
						ePerBasis.printStackTrace();
						}
					
					ratedAt.sendKeys(NumberToTextConverter.toText(DataProviderFactory.getExcel().getNumberDataDouble("bldata",loopCount,3)));
					
				}
			}
		 }
		 
		 WebDriverWait waitRate = new WebDriverWait(driver,10);
		 
		 waitRate.until(ExpectedConditions.elementToBeClickable(rate));
		 
		 
		 rate.clear();
		 
		 rate.sendKeys(NumberToTextConverter.toText(DataProviderFactory.getExcel().getNumberDataDouble("bldata",loopCount,5)));
		 
		 currency.sendKeys(DataProviderFactory.getExcel().getStringData("bldata",loopCount,6));
		 
		 WebDriverWait waitCurr = new WebDriverWait(driver,10);
		 
		 waitCurr.until(ExpectedConditions.attributeToBeNotEmpty(Currenecy_des, "value"));
		 
		 paymentMode.click();
		 
		 try {
			Thread.sleep(1000);
			
		} catch (InterruptedException epmptMode) {
			
			epmptMode.printStackTrace();
		}
		 
		 /*
		 WebDriverWait waitpamt = new WebDriverWait(driver,10);
		 
		 waitpamt.until(ExpectedConditions.visibilityOfAllElements(paymentModeList));
		 */
		 String paymentModeSel = DataProviderFactory.getExcel().getStringData("bldata",loopCount,12);
		 
		 for(WebElement e:paymentModeList)
		 {
			 if(e.getText().equalsIgnoreCase(paymentModeSel))
				 
				 {
				 e.click();
				 
				 break;
				 }
			 
		 }
		 
		 
		 printOn.click();
		 /*
		 WebDriverWait waitPrintOn = new WebDriverWait(driver,10);
		 
		 waitPrintOn.until(ExpectedConditions.visibilityOfAllElements(printOnList));
		 */
		 
		 String printOnSel = DataProviderFactory.getExcel().getStringData("bldata",loopCount,13);
		 
		 for(WebElement e:printOnList)
		 {
			 if(e.getText().equalsIgnoreCase(printOnSel))
			 {
				 e.click();
				 break;
			 }
		 }
		 
		 
		 FreightcolOffice.click();
		 
		 FreightcolOffice.sendKeys(DataProviderFactory.getExcel().getStringData("bldata",loopCount,14));
		 
		 try {
			
			 Thread.sleep(3000);
		
		 	} catch (InterruptedException eFrgtColOffice) {
			
			eFrgtColOffice.printStackTrace();
		 	}
		 
		 FreightcolOffice.sendKeys(Keys.ENTER);
		 
		 WebDriverWait waitFreight = new WebDriverWait(driver,10);
		 
		 waitFreight.until(ExpectedConditions.attributeToBeNotEmpty(freightColOfficeValue,"value"));
		 
		 invoiceOffice.click();
		 
		 invoiceOffice.sendKeys(DataProviderFactory.getExcel().getStringData("bldata",loopCount,15));
		 
		 try {
				
			 Thread.sleep(3000);
		
		 	} catch (InterruptedException eInvOffice) {
			
		 		eInvOffice.printStackTrace();
		 	}
		 
		 invoiceOffice.sendKeys(Keys.ENTER);
		 
				 
		 WebDriverWait waitInvOfc = new WebDriverWait(driver,10);
		 
		 waitInvOfc.until(ExpectedConditions.attributeToBeNotEmpty(invoiceOfficeValue,"value"));
		 
		 String payer_name = NumberToTextConverter.toText(DataProviderFactory.getExcel().getNumberDataDouble("bldata",loopCount,16));
		 
		 payer.sendKeys(payer_name);
		 
		 WebDriverWait waitPayer = new WebDriverWait(driver,10);
			
		 waitPayer.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.xpath("//input[@id='PayerCustCode']")),payer_name));
		 		 
		 RevenueAcceptButton.click();
		 
		 WebDriverWait waitAcptRev = new WebDriverWait(driver,20);
		 
		 waitAcptRev.until(ExpectedConditions.elementToBeClickable(AddFreight));
		 
		 try {
			Thread.sleep(3000);
			
		} catch (InterruptedException eRevOK) {
			
			eRevOK.printStackTrace();
		}
		 
		 }
		 
		 
		 
	 }
	 
	 
	 public void clickOnSave() throws InterruptedException
	 {
		// Thread.sleep(3000);
		 
		 save.click();
	 }
	 
	 public void waitToSaveCompletion()
	 {
		 WebDriverWait wait11 = new WebDriverWait(driver,15);
		 wait11.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='winBlLog_wnd_title']")));
		 
	 }
	 
	 
	 public void transactionLog()
	 {
		 textArea.sendKeys(DataProviderFactory.getExcel().getStringData("bldata",17,3));
		 
		 saveLog.click();
		 
		 WebDriverWait wait12 = new WebDriverWait(driver,10);
		 
		 wait12.until(ExpectedConditions.elementToBeClickable(View_route));
				 
	 }
	 
	 public void clickOnComplete()
	 {
		 
		 WebDriverWait wait14 = new WebDriverWait(driver,15);
		 
		 wait14.until(ExpectedConditions.elementToBeClickable(CompleteBtn));
		 
		// CompleteBtn.click();
		 
		 
		 
		 //driver.findElements(By.id("btnComplete")).size()!=0
		 
		 for(int i=1;i<10;i++)
		 {
			 
			 try {
					Thread.sleep(3500);
				} catch (Exception e) {
					
					System.out.println("comple button exception "+e.getMessage());
					
				}
			System.out.println("Inside for loop");
			
		    if(CompleteBtn.isDisplayed() && CompleteBtn.isEnabled() )
		    {
		    	System.out.println("Inside If loop");
		    	try{
		    	  CompleteBtn.click();
		    	}
		    	catch(Exception e)
		    	{
		    		try {
						Thread.sleep(3000);
						
						CompleteBtn.click();
						break;
					} catch (InterruptedException e1) {
						
						System.out.println("inner block complete button exception "+e1.getMessage());
					}
		    	System.out.println("outer block complete button exception "+e.getMessage());
		    	}
		    break;
		    }
		    
		    
		 }  
	 }
	 
	 
	 public void getBLNumber()
	 {
		 WebDriverWait wait15 = new WebDriverWait(driver,10);
		 
		 wait15.until(ExpectedConditions.elementToBeClickable(View_route));
		 
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
		 
		 WebDriverWait wait16 = new WebDriverWait(driver,15);
		 
		 wait16.until(ExpectedConditions.visibilityOf(redyForInvIssue));
		 
		 redyForInvIssue.click();
	 }
	 
	 public void BLImageGenerator()
	 {
		 BLImage.click();
	 }
	 
	 
	 public void getBLStatus()
	 {
		 WebDriverWait statusWait = new WebDriverWait(driver,10);
		 
		 statusWait.until(ExpectedConditions.elementToBeClickable(View_route));
		 
		 if(statusOfBl.getText().equalsIgnoreCase("Draft"))
		 {
			 System.out.println("BL Completion status is "+statusOfBl.getText());
		 }
		 else if(statusOfBl.getText().equalsIgnoreCase("Complete")) 
		  {
			 System.out.println("BL Completion status is "+statusOfBl.getText());
		 }
		 
		// else if(statusOfBl.getText().equalsIgnoreCase("Complete"))
		 
	 }
	 

}
