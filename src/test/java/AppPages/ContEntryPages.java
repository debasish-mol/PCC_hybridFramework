package AppPages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
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

	@FindBy(xpath=".//*[@id='divContract']/form/div[3]/div[1]/div[4]/div[1]/span[1]/span/span[2]/span") WebElement contTypeLov;
		
	@FindBy(xpath="//ul[@id='ContractType_listbox']/li") List<WebElement> contTypeSelect;
	
	@FindBy(id="ContractName") WebElement contName;
	
	@FindBy(id="MainCustName") WebElement mainCustName;
	
	@FindBy(xpath= "//*[@id='btnAddCustomer']") WebElement btnAddAffiliates;
	
	@FindBy(xpath= "//*[@id='CustName']") WebElement affiliatesCustName;
	
	@FindBy(xpath= "//input[@id='EffectiveDate']") WebElement contEffectDate;
	
	@FindBy(xpath="//input[@id='ExpiryDate']") WebElement contExpiryDate;
	
	@FindBy(xpath="//input[@id='btnSaveHdr']") WebElement contSave;
	
	@FindBy(xpath="//input[@id='btnSaveHdr']")  WebElement hdrSave;
	
	@FindBy(xpath="//div[@title='ADD LP-DP']") WebElement contAddLpDp;
	
	@FindBy(xpath="//span[@id='spnContNo']") WebElement contNo;
	
	@FindBy(xpath="//input[@id='LoadPort']") WebElement contLoadPort;
	
	@FindBy(xpath="//input[@id='LoadPort' and @value ='' ]") WebElement contLoadPortCheck;
	
	@FindBy(xpath="//input[@id='DschPort']") WebElement contDschPort;
	
	@FindBy(xpath="//input[@id='btnSaveLPDP']") WebElement contADDLpDpSave;
	
	@FindBy(xpath="//div[@title='ADD MAKE-MODEL']") WebElement ContAddMakeModel;
	
	@FindBy(xpath="//span[@aria-owns='CargoTypeCode_listbox']/span/span[2]") WebElement contCargoType;
	
	@FindBy(xpath="//ul[@id='CargoTypeCode_listbox']/li") List<WebElement> contCargoTypeList;
	
	@FindBy(xpath="//input[@id='MakeName']") WebElement contMakeName;
	
	@FindBy(xpath="//input[@id='ModelName']") WebElement contModelName;
	
	@FindBy(xpath="//input[@id='btnRevenueAdd']") WebElement contADDModifyRevenue;
	
	@FindBy(xpath="//input[@id='ChrgCode']") WebElement contChgeCode;
	
	@FindBy(xpath="//span[@aria-owns='BaseCode_listbox']/span/span[2]") WebElement contBasisCode;
		
	@FindBy(xpath="//ul[@id='BaseCode_listbox']/li") List<WebElement> contBaseCodeList;
	
    @FindBy(xpath="//td[@data-container-for='Rate']/span/span/input[1]") WebElement contRate;
	
	@FindBy(xpath="//td[@data-container-for='Currency']/input[@id='Currency']") WebElement contCurrency;
	
	@FindBy(xpath="//td[@data-container-for='PrepaidCollect']/span/span/span[2]") WebElement contPreCol;
	
	@FindBy(xpath="//ul[@id='PrepaidCollect_listbox']/li") List<WebElement> contPreColList;
	
	@FindBy(xpath="//input[@id='FreightCollectOfcName']") WebElement contFrtCollOfcCode;
	
	@FindBy(xpath="//input[@id='InvOfcName']") WebElement contInvOfcCode;
	
	@FindBy(xpath="//Input[@id='Payer']") WebElement payer;
	
	@FindBy(xpath="//input[@id='btnSave1']") WebElement contRevSave;//this need to discuss
	
	@FindBy(xpath = "//input[@id='btnRevenueClose']") WebElement contRevWinClose;
	
	@FindBy(xpath="//input[@id='btnSaveCargo']") WebElement contCargoSave;
	
	@FindBy(xpath="//*[@id='divContract']/form/div[3]/div[1]/div[4]/div[5]/span[1]/span/span[1]") WebElement contStatus;
			
	@FindBy(xpath="//ul[@id='ContractStatus_listbox']/li") List<WebElement> contStatusList;
	
	@FindBy(xpath="//input[@id='SalesPerson']")  WebElement salesPerson;
	
	@FindBy(xpath="html/body/div[2]/div[1]/h2") WebElement pageheader;
	
	@FindBy(xpath="//div[@id='divContract']/div[1]/h3") WebElement contRouteHeader;
	
	@FindBy(id="hdnMake") WebElement makeSelected;
	
	@FindBy(id="hdnModel") WebElement moldelSelected;
	
	@FindBy(id="btnDownloadExcel") WebElement downloadContract;
	
	@FindBy(xpath="//input[@id='btnUpload']") WebElement uploadCont;
	
	@FindBy(xpath="//span[text()='Select files...']") WebElement selectFiles;
	
	@FindBy(xpath="//button[text()='Upload files']") WebElement uploadFile;
	
	@FindBy(xpath="//span[@id='spanErrorMsg']") WebElement uploadedMsg;
	
	@FindBy(xpath="//span[@class='k-icon k-i-xlsx']") WebElement uploadedIcon;
	
	@FindBy(xpath="//input[@id='DocIssueOfficeName']") WebElement docIssueOfcCode;
	
	@FindBy(xpath="//*[@id='Remarks']") WebElement rmksHdr;
	
	@FindBy(xpath="//*[@id='BkgRemarks']") WebElement bkgRmksHdr;
	
	@FindBy(xpath="//*[@id='FrtRemarks']") WebElement frgtRmksHdr;
	
	@FindBy(xpath="//*[@id='PR']") WebElement placeOfReceiptCode;
	
	@FindBy(xpath="//*[@id='PD']") WebElement placeOfDeliveryCode;
	
	@FindBy(xpath="//*[@id='TshPortName1']") WebElement tsh1;
	
	@FindBy(xpath="//*[@id='TshPortName2']") WebElement tsh2;
	
	@FindBy(xpath="//*[@id='TshPortName3']") WebElement tsh3;
	
	@FindBy(xpath="//*[@id='FreightTargetFlag']") WebElement japFrgtTrmntCode;
	
	@FindBy(xpath="//*[@id='SRGContractNo']") WebElement srgContNo;
	
	@FindBy(xpath="//*[@id='divContract']/div[4]/div[4]/div[3]/span/span/input[1]") WebElement ggnRatio;
	
	@FindBy(xpath="//*[@id='divContract']/div[5]/div[4]/div[1]/span/span/span[1]") WebElement terms;
	
	@FindBy(xpath="//*[@id='TermName_listbox']/li") List<WebElement> termsList;
	
	@FindBy(xpath="//*[@id='FdpsTypeName']") WebElement fdps;
	
	@FindBy(xpath="//*[@id='divContract']/div[3]/div[1]/div[4]/div[4]/span[1]/span/input[1]") WebElement indicativeQntityUnits;
	
	@FindBy(xpath="//*[@id='EffectiveFrom']") WebElement revenueEffectiveFrom;
	
	@FindBy(xpath="//*[@id='EffectiveTo']") WebElement revenueEffectiveTo;
	
	@FindBy(xpath="//*[@id='ContractRevenueWindowContentGrid']/div[2]/div[4]/div[2]/input[@value='ADD Revenue']") WebElement addRevenueBtnInPopup;
	
	@FindBy(xpath="//*[@id='divMessage']/div") WebElement error_Confirmation_Msg;
	
	@FindBy(xpath="//*[@id='treeview-left']/ul/li/div/span[2]/div") WebElement header;
	
	
	
	
	public void clickonHeader()
	{
		header.click();
		try
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException eClickonHeader) 
		{
			eClickonHeader.printStackTrace();
		}
	}
	
	public String getErrConfMsg()
	{
		String val = error_Confirmation_Msg.getText();
		return val;
	}
	
	// Selecting Contract Type using the method
	public void contractType(String name) throws InterruptedException
	{
		contTypeLov.click();
		
		WebDriverWait waitContractType = new WebDriverWait(driver,10);
		 
		waitContractType.until(ExpectedConditions.visibilityOfAllElements(contTypeSelect));
		
		for(WebElement e: contTypeSelect)
		{
			if(e.getText().equals(name))
			{
				System.out.println(e.getText());
				e.click();
			}
		}
		
	}
	
	//Entering Contract name using the method
	public void enterContractName(String name)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(contName));
		
		contName.sendKeys(name);
	}
	
	//Entering Main customer code using the method
	public void enterMainCustomer(int name)
	{
		String name1 = Integer.toString(name);
		
		mainCustName.sendKeys(name1);
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.xpath("//input[@id='MainCustCode']")),name1));
		
	}
	
	//Clicking the Add Affiliates button
	public void clickOnAddAffiliates()
	{
		btnAddAffiliates.click();
	}
	
	public void enterAffiliatedCustomer(String name)
	{
		affiliatesCustName.sendKeys(name);
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException eAffiliatedCustomer) 
		{
			eAffiliatedCustomer.printStackTrace();
		}
		salesPerson.sendKeys(Keys.ENTER);
	}
	
	//Entering Sales person using the method
	public void enterSalesPerson(String name)
	{
		salesPerson.sendKeys(name);
		salesPerson.sendKeys(Keys.ENTER);
	}
	
	//Entering Doc Issuing Office code using the method
	public void enterDocIssueOfcCode(String name) throws InterruptedException
	{
		if(!name.equals(docIssueOfcCode.getAttribute("value")))
		{
			docIssueOfcCode.clear();
			docIssueOfcCode.sendKeys(name);
		}
		Thread.sleep(2000);
		
		docIssueOfcCode.sendKeys(Keys.ENTER);
		
		
	}
	
	//Entering Effective From date of the Contract using the method
	public void enterEffectivedate(String date)
	{
		contEffectDate.sendKeys(date);
	}
	
	//Entering Effective To date of the Contract using the method
	public void enterExpiryDate(String date)
	{
		contExpiryDate.sendKeys(date);
	}
	
	//Entering Remarks in header section using the method
	public void enterRemarks(String name)
	{
		rmksHdr.sendKeys(name);
	}
	
	//Entering Booking Remarks in header section using the method	
	public void enterBKGRemarks(String name)
	{
		bkgRmksHdr.sendKeys(name);
	}
	
	//Entering Freight Remarks in header section using the method	
	public void enterFrgtRemarks(String name)
	{
		frgtRmksHdr.sendKeys(name);
	}
	
	//Saving the header section using the method
	public void clickOnHdrSave()
	{
		hdrSave.click();
	}
	
	//Entering From Port value using the method
	public void enterContLoadPort(String name) throws InterruptedException
	{
		contLoadPort.sendKeys(name);
		
		Thread.sleep(1500);
		
		WebDriverWait lpWait = new WebDriverWait(driver,10);
		
		//String lpName = contLoadPort.getAttribute("value");
		
		lpWait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.xpath("//input[@id='hdLoadPort']")), name));
				
		contLoadPort.sendKeys(Keys.TAB);
	}
	
	//Entering To Port value using the method
	public void enterContDisPort(String name) throws InterruptedException
	{
		contDschPort.sendKeys(name);
		
		Thread.sleep(1500);
		
		WebDriverWait dpWait = new WebDriverWait(driver,10);
		
		//String dpName = contDschPort.getAttribute("value");
		
		dpWait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.xpath("//input[@id='hdDschPort']")),name));
		
		contDschPort.sendKeys(Keys.TAB);
		
		//Thread.sleep(2000);
	}
	
	//Entering Place of Receipt value using the method
	public void enterPlaceOfReceiptCode(String name) throws InterruptedException
	{
		placeOfReceiptCode.sendKeys(name);
		
		Thread.sleep(1500);
		
		WebDriverWait prWait = new WebDriverWait(driver,10);
		//String prname = placeOfReceiptCode.getAttribute("value");
		prWait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.xpath("//*[@id='hdPR']")), name));
				
		placeOfReceiptCode.sendKeys(Keys.TAB);
	}
	
	//Entering Place of Delivery value using the method
	public void enterPlaceOfDeliveryCode(String name) throws InterruptedException
	{
		placeOfDeliveryCode.sendKeys(name);
		
		Thread.sleep(1500);
		
		WebDriverWait pdWait = new WebDriverWait(driver,10);
		//String pdname = placeOfDeliveryCode.getAttribute("value");
		pdWait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.xpath("//*[@id='hdPD']")), name));
				
		placeOfDeliveryCode.sendKeys(Keys.TAB);
	}
	
	//Entering Transshipment# 1 value using the method
	public void enterTSH1(String name)
	{
		tsh1.sendKeys(name);
	}
	
	//Entering Transshipment# 2 value using the method
	public void enterTSH2(String name)
	{
		tsh2.sendKeys(name);
	}
	
	//Entering Transshipment# 3 value using the method
	public void enterTSH3(String name)
	{
		tsh3.sendKeys(name);
	}
	
	//Selecting Japanese Freight Treatment value using the method
	public void checkJapFrgtTrmntCodeFlag()
	{	
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException eJapFrgtTrmntCodeFlag) 
		{
			eJapFrgtTrmntCodeFlag.printStackTrace();
		}
		//japFrgtTrmntCode.isSelected();
		if(!driver.findElement(By.xpath("//*[@id='FreightTargetFlag']")).isSelected())
		{
			driver.findElement(By.xpath("//*[@id='FreightTargetFlag']")).sendKeys(Keys.SPACE);;
		}
	}
	
	//Entering SRG Contract No. using the method
	public void enterSRGContNo(String name)  
	{
		srgContNo.sendKeys(name);
		
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException eSRGContNo) 
		{
			eSRGContNo.printStackTrace();
		}
		//WebDriverWait srgWait = new WebDriverWait(driver,10);
		
		//srgWait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.xpath("//*[@id='SRGContractNo']")), name));
				
		//ContLoadPort.sendKeys(Keys.TAB);
	}
	
	//Entering GGN Ratio using the method
	public void enterGGNRatio(String name)
	{
		ggnRatio.sendKeys(name);
	}
	
	//Entering Terms using the  method
	public void selectTerms(String name) throws InterruptedException
	{
		terms.click();
		
		Thread.sleep(1000);
		
		//WebDriverWait waitContractType = new WebDriverWait(driver,10);
		 
		//waitContractType.until(ExpectedConditions.visibilityOfAllElements(termsList));
		
		for(WebElement e: termsList)
		{
			if(e.getText().equals(name))
			{
				e.click();
			}
		}
	}
	
	//Entering FDPS using the  method
	public void enterFDPS(String name) throws InterruptedException
	{
		fdps.sendKeys(name);
		
		Thread.sleep(3000);
		
		//WebDriverWait fdpsWait = new WebDriverWait(driver,10);
		
		//name = name.toUpperCase();
		
		//fdpsWait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.xpath("//*[@id='FdpsTypeName']")), name));
				
		fdps.sendKeys(Keys.TAB);
	}
	
	//Saving Location, Terms and Other Details section using the method
	public void clickOnContADDLpDpSave()
	{
		contADDLpDpSave.click();
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException eContADDLpDpSave) 
		{
			eContADDLpDpSave.printStackTrace();
		}
	}

	//Entering Model Code/Name using the method 
	public void enterContModelName(String name) throws InterruptedException
	{
		WebDriverWait wait5 = new WebDriverWait(driver,10);
		wait5.until(ExpectedConditions.visibilityOf(contModelName));
		
		contModelName.click();
		
		contModelName.sendKeys(name);
		
		WebDriverWait waitModelSelected = new WebDriverWait(driver,10);
		 
		waitModelSelected.until(ExpectedConditions.attributeToBeNotEmpty(moldelSelected,"value"));
		
	}
	
	//Entering Indicative Quantity Units using the method
	public void enterIndicativeQntityUnits(String name)
	{
		indicativeQntityUnits.sendKeys(name);
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException eIndicativeQntityUnits) 
		{
			eIndicativeQntityUnits.printStackTrace();
		}
	}
	
	//Clicking on Add And Modify Revenue button using the method
	public void clickOnAddAndModifyRevenue()
	{
		contADDModifyRevenue.click();
		
		WebDriverWait revWait = new WebDriverWait(driver,10);
		
		revWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='ContractRevenueWindowGrid_wnd_title']")));
		
	}
	
	//Entering Charges using the method
	public void enterCharges(String name) throws InterruptedException
	{
		contChgeCode.clear();
		
		contChgeCode.sendKeys(name);
		
		Thread.sleep(2000);
		
		WebDriverWait chargesWait = new WebDriverWait(driver,10);
			
		chargesWait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(By.xpath("//input[@id='ChrgCode']")), name));
					
			//ContLoadPort.sendKeys(Keys.TAB);
	}
	
	//Entering Basis Code using the method
	public void enterBasisCode(String name)
	{
		contBasisCode.click();
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException eBasis) 
		{
			eBasis.printStackTrace();
		}
		
		for(WebElement e : contBaseCodeList)
		{
			
			if(e.getText().equalsIgnoreCase(name))
			{
			//System.out.println("Printing base Code "+e.getText());
			
			e.click();
			}
		}
		
		WebDriverWait waitBaseCodeSelected = new WebDriverWait(driver,10);
		
		waitBaseCodeSelected.until(ExpectedConditions.textToBe(By.xpath(".//div[@id='gridRevenueDetails']/div[2]/table/tbody/tr/td[5]/span[1]/span/span[1]"), name));
	}
	
	//Entering Rate using the method
	public void enterRate(String rate)
	{
		contRate.sendKeys(rate);
	}
	
	//Entering Currency using the method
	public void enterCurrency(String currency)
	{
		contCurrency.sendKeys(currency);
		try 
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException eCurrency) 
		{
			eCurrency.printStackTrace();
		}
	}
	
	//Selecting Prepaid / Collect using the method
	public void enterPreCol(String preCol)
	{
		contPreCol.click();
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException ePreCol1) 
		{
			ePreCol1.printStackTrace();
		}
		
		
		for(WebElement e: contPreColList)
		{
			if(e.getText().equalsIgnoreCase(preCol))
			{
			//System.out.println("Prepaid or Collect "+e.getText());
			e.click();
			}
		}
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException ePreCol2) 
		{
			ePreCol2.printStackTrace();
		}
	}
	
	//Entering Freight Collection Office code using the method
	public void enterFrgtCollOfcCode(String name)
	{
		contFrtCollOfcCode.sendKeys(name); // Freight Office
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException eFCOC1) 
		{
			eFCOC1.printStackTrace();
		}
		
		contFrtCollOfcCode.sendKeys(Keys.ENTER);
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException eFCOC2) 
		{
			eFCOC2.printStackTrace();
		}
	}
	
	//Entering Invoicing Office code using the method
	public void enterInvOfcCode(String name)
	{
		contInvOfcCode.sendKeys(name); // Invoice Office
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException eInvOfcCode1) 
		{
			eInvOfcCode1.printStackTrace();
		}
		
		contInvOfcCode.sendKeys(Keys.ENTER);
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException eInvOfcCode2) 
		{
			eInvOfcCode2.printStackTrace();
		}
	}
	
	//Entering Payer code using the method
	public void enterPayer(String name)
	{
		payer.sendKeys(name);
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException ePayerCode) 
		{
			ePayerCode.printStackTrace();
		}
	}
	
	//Entering Revenue Effective From date using the method
	public void enterRevenueEffectiveFrom(String name)
	{
		revenueEffectiveFrom.clear();
		revenueEffectiveFrom.sendKeys(name);
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException eRevEffFrm) 
		{
			eRevEffFrm.printStackTrace();
		}
	}
	
	//Entering Revenue Effective To date using the method
	public void enterRevenueEffectiveTo(String name)
	{
		revenueEffectiveTo.clear();
		revenueEffectiveTo.sendKeys(name);
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException eRevEffTo) 
		{
			eRevEffTo.printStackTrace();
		}
	}
	
	//Saving the revenue record grid using the method
	public void clickRevenueSave()
	{
		contRevSave.click();
		
		try 
		{
			Thread.sleep(3500);
		} 
		catch (InterruptedException eRevSave) 
		{
			eRevSave.printStackTrace();
		}
		
		//WebDriverWait contRevSaveWait = new WebDriverWait(driver,10);
		
		//contRevSaveWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='btnSave1']")));
	}
	
	//Closing the Revenue pop-up screen using the method
	public void clickRevenuePopupClose()
	{
		contRevWinClose.click();
		
		try 
		{
			Thread.sleep(2500);
		} 
		catch (InterruptedException eRevClose) 
		{
			eRevClose.printStackTrace();
		}
		
		//WebDriverWait contRevCloseWait = new WebDriverWait(driver,10);
		
		//contRevCloseWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='btnRevenueClose']")));
	}
	
	//Saving Cargo details using the method
	public void conCragoSaveButton()
	{
		WebDriverWait wait5 = new WebDriverWait(driver,10);
		
		wait5.until(ExpectedConditions.elementToBeClickable(contCargoSave));
		
		
		contCargoSave.click();
		
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException eContRevSave) 
		{
			eContRevSave.printStackTrace();
		}
	}
	
	
	//Returning Contract No using the method
	public String getContNo()
	{
		String Contact_No = contNo.getText();
		return Contact_No;
	}
	
	//Saving Contract details using the method
	public void clickOnFirstPageSave()
	{
		contSave.click();
		
		WebDriverWait fstPageWait = new WebDriverWait(driver,20);
		
		fstPageWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='divContract']/div[1]/h3")));
	}
	
	
	public void clickonAddRevenueinPopup()
	{
		addRevenueBtnInPopup.click();
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException eAddRevenuePopup) 
		{
			eAddRevenuePopup.printStackTrace();
		}
	}
	
	//Select the Complete value as Status of a contract
	public void selectContactStatus()
	{
		contStatus.click();
		
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException eContactStatus) 
		{
			eContactStatus.printStackTrace();
		}
			
		for(WebElement e: contStatusList)
		{
			if(e.getText().equals("Complete"))
			{
				System.out.println("Selecting Contact Status"+e.getText());
					
				e.click();
			}
		}
	}
	
	//Enter the functionality of the method
	public String getPageHeader()
	{
		 String pageName = pageheader.getText();
		 
		 return pageName;
	}
	
	//Enter the functionality of the method
	public void ToCheckAddLpDpVisibility()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.visibilityOf(contAddLpDp));
		
		
	}
	
	//Enter the functionality of the method
	public void PrintContNo()
	{
		String Contact_No = contNo.getText();
		
		System.out.println("Printing Cont No "+Contact_No);
		
		try 
		{
			DataProviderFactory.getExcel().WriteDataExcel("bldata",1,1,Contact_No);
		
		} 
		catch (IOException e) 
		{
			System.out.println("Exception "+e.getMessage());
		}
	}
	
	//Enter the functionality of the method
	public void ToCheckVisibilityOfAddMakeModel()
	{
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		wait1.until(ExpectedConditions.visibilityOf(ContAddMakeModel));
		
	}
	
	//Enter the functionality of the method
	public void EnterCargoType(String name) throws InterruptedException
	{
		 contCargoType.click();
		 
		 WebDriverWait wait2 = new WebDriverWait(driver,10);
		 
		 wait2.until(ExpectedConditions.visibilityOfAllElements(contCargoTypeList));
		 
		 for(WebElement e: contCargoTypeList)
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
		 
		 WebDriverWait waitCargoSelected = new WebDriverWait(driver,10);
		 
		 waitCargoSelected.until(ExpectedConditions.textToBe(By.xpath(".//div[@id='divContract']/div[3]/div[1]/div[4]/div[1]/span[1]/span/span[1]"), name));
		 
		 
	}
	
	//Enter the functionality of the method
	public void EnterContMakeName(String name) throws InterruptedException
	{
		WebDriverWait wait3 = new WebDriverWait(driver,20);
		wait3.until(ExpectedConditions.visibilityOf(contMakeName));
		
				
		contMakeName.click();
		
		contMakeName.sendKeys(name);
		//Thread.sleep(2000);
		
		WebDriverWait waitMakeSelected = new WebDriverWait(driver,10);
		 
		waitMakeSelected.until(ExpectedConditions.attributeToBeNotEmpty(makeSelected,"value"));
		 
		
		contMakeName.sendKeys(Keys.TAB);
		
	}
	
	//Enter the functionality of the method
	public void EnterContADDModifyRevenue(String BaseCode) throws InterruptedException
	{
		contADDModifyRevenue.click();
		
		WebDriverWait revWait = new WebDriverWait(driver,10);
		
		revWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='ContractRevenueWindowGrid_wnd_title']")));
		
		//Thread.sleep(2000);
		
		contBasisCode.click();
		
		//Thread.sleep(1000);
		
		for(WebElement e : contBaseCodeList)
		{
			
			if(e.getText().equalsIgnoreCase(BaseCode))
			{
			System.out.println("Printing base Code "+e.getText());
			
			e.click();
			Thread.sleep(1500);
			}
			
		}
		/*
		WebDriverWait waitBaseCodeSelected = new WebDriverWait(driver,10);
		
		waitBaseCodeSelected.until(ExpectedConditions.textToBe(By.xpath(".//div[@id='gridRevenueDetails']/div[2]/table/tbody/tr/td[5]/span[1]/span/span[1]"), BaseCode));
		*/
		//ContRate.sendKeys("2000");
		
        int no2=DataProviderFactory.getExcel().getNumberData("ContractData",11,1);
		
		String no3= Integer.toString(no2);
		
		contRate.sendKeys(no3);  // Rate 
		
		
		//ContCurrency.sendKeys("SGD");
		
		contCurrency.sendKeys(DataProviderFactory.getExcel().getStringData("ContractData",12,1));  // Currency
		
		Thread.sleep(1500);
		
		contPreCol.click();
		
		Thread.sleep(1000);
		
		
		for(WebElement e: contPreColList)
		{
			if(e.getText().equalsIgnoreCase(DataProviderFactory.getExcel().getStringData("ContractData",13,1)))
			{
			System.out.println("Prepaid or Collect "+e.getText());
			
			e.click();
			}
		}
		
		Thread.sleep(1000);
		
		contFrtCollOfcCode.sendKeys(DataProviderFactory.getExcel().getStringData("ContractData",14,1)); // Freight Office
		
		Thread.sleep(2000);
		
		contFrtCollOfcCode.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		
		contInvOfcCode.sendKeys(DataProviderFactory.getExcel().getStringData("ContractData",15,1)); // Invoice Office
		
		Thread.sleep(2000);
		
		contInvOfcCode.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		
		//payer.sendKeys("5117553");
		
		int no=DataProviderFactory.getExcel().getNumberData("ContractData",16,1);  //payer
		
		String no1= Integer.toString(no);
		
		payer.sendKeys(no1);
		
		//WebDriverWait payerWait = new WebDriverWait(driver,10);
		
		//payerWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='gridCustMaster-Payer']/table/tbody/tr[1]/td[1]")));
		
		//payerWait.until(ExpectedConditions.textToBePresentInElement(By.xpath("//input[@id='Payer']"),no1));
		
		Thread.sleep(2500);
		
		contRevSave.click();
		
		WebDriverWait contSaveWait = new WebDriverWait(driver,10);
		
		contSaveWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='btnDelete1']")));
		
		contRevWinClose.click();
		
	}
	
	//Enter the functionality of the method
	public void UploadExcelContract()
	{
	
		WebDriverWait waitUpload = new WebDriverWait(driver,10);
		
		waitUpload.until(ExpectedConditions.elementToBeClickable(uploadCont));
		
		uploadCont.click();
		
		WebDriverWait waitExcellUploadWindow = new WebDriverWait(driver,10);
		
		waitExcellUploadWindow.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@id='ExcelUploadWindow_wnd_title']")));
		
		
		selectFiles.click();
		
		
		
	}
	
	//Enter the functionality of the method
	public void clickOnUploadFile()
	{
		WebDriverWait waitFileUpload = new WebDriverWait(driver,10);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		uploadFile.click();
		
		try
		{
			Thread.sleep(2000); 
		}
		catch (InterruptedException  e)
		{
			e.printStackTrace();
		}
		
	}
	
	//Enter the functionality of the method
	public String getMsg()
	{
		String msg =uploadedMsg.getText();
		
		return msg;
	}
	
	public void removeErrormsg()
	{
		clickonHeader();
		WebElement warningYes = driver.findElement(By.xpath("//*[@id='uxMsg-button1']"));
		warningYes.click();
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException eWarningYes) 
		{
			eWarningYes.printStackTrace();
		}
	}
	
	//Below function is for entering multiple data in edit mode of a contract
	public String AddMultiRecordsinEditMode(String tabName, int rowNumber,String xlsContType,String xlsFrmPortCode,String xlsToPortCode,String xlsPlaceOfReceiptCode,
		String xlsPlaceOfReceiptName,String xlsPlaceOfDeliveryName,String xlsPlaceOfDeliveryCode,String xlsTsh1,String xlsTsh2,String xlsTsh3,
		String xlsJapFrgtTrmntCode,String xlsSRGContNo,String stringXlsGGNRatio,String xlsTerms,String xlsFDPS,String xlsDocIssueOfcCodeDtl,
		String xlsMakeName,String xlsModelCode,String xlsModelName,String stringXlsIndicativeQntityUnits,String xlsCharges,String xlsBasisCode,
		String stringXlsRate,String xlsCurrency,String xlsPreCol, String xlsFrgtCollOfcCode,String xlsInvoiceOfcCode,String stringXlsPayerCode,
		String xlsRevenueEffectiveFromDtl,String xlsRevenueEffectiveToDtl)
	{
		int lpDpFlag = 0;
		int modelFlag = 0;
		int revenueFlag = 0;
		String log = null;
		String lpDPname = xlsFrmPortCode+"~"+xlsToPortCode;
		String makeModelName = xlsMakeName+"~"+xlsModelName;
		List<WebElement> lpDplist = driver.findElements(By.xpath("//div[@id='treeview-left']/ul/li/ul/li"));
		
		for(int i=2;i<=lpDplist.size();i++)
		{
			String path ="//div[@id='treeview-left']/ul/li/ul/li["+i+"]/div/span[2]/div";
			WebElement lpDpPath = driver.findElement(By.xpath(path));
						
			if(lpDpPath.getText().equalsIgnoreCase(lpDPname))
			{
				lpDpPath.click();
				
				lpDpFlag = 0;
				
				try 
				{
					Thread.sleep(3000);
				}
				catch (InterruptedException eLPDP) 
				{
					eLPDP.printStackTrace();
				}
				
				WebElement PR = driver.findElement(By.xpath("//input[@id='PR']"));
				
				WebElement PD = driver.findElement(By.xpath("//input[@id='PD']"));
				
				if(PR.getAttribute("value").equalsIgnoreCase(xlsPlaceOfReceiptName) && PD.getAttribute("value").equalsIgnoreCase(xlsPlaceOfDeliveryName))
				{
					lpDpFlag = 0;
					List<WebElement> modelList = driver.findElements(By.xpath("//li[@id='treeview-left_tv_active']/ul/li"));
					for(int j=2;j<=modelList.size();j++)
					{
						String modelPath = "//li[@id='treeview-left_tv_active']/ul/li["+j+"]/div/span/div";
						
						WebElement modelElement = driver.findElement(By.xpath(modelPath));
						
						if(modelElement.getText().equalsIgnoreCase(makeModelName))
						{
							modelFlag = 0;
							
							modelElement.click();
							
							try 
							{
								Thread.sleep(3000);
							} 
							catch (InterruptedException eModel) 
							{
								eModel.printStackTrace();
							}
							
							List<WebElement> revenueList = driver.findElements(By.xpath("//div[@id='gridRevenueDetailsMain']/div[2]/table/tbody/tr"));
							
							for(int k =1;k<=revenueList.size();k++)
							{
								String chargePath = "//div[@id='gridRevenueDetailsMain']/div[2]/table/tbody/tr["+k+"]/td[2]";
								
								WebElement chargeElement = driver.findElement(By.xpath(chargePath));
								
								String chargeValue = chargeElement.getText();
								
								String BasisPath = "//div[@id='gridRevenueDetailsMain']/div[2]/table/tbody/tr["+k+"]/td[4]";
								
								WebElement basisElement = driver.findElement(By.xpath(BasisPath));
								
								String basisValue = basisElement.getText();
								
								String ratePath = "//div[@id='gridRevenueDetailsMain']/div[2]/table/tbody/tr["+k+"]/td[7]";
								
								WebElement rateElement = driver.findElement(By.xpath(ratePath));
								
								String rateValue = rateElement.getText();
								
								String currPath = "//div[@id='gridRevenueDetailsMain']/div[2]/table/tbody/tr["+k+"]/td[8]";
								
								WebElement currElement = driver.findElement(By.xpath(currPath));
								
								String currValue = currElement.getText();
								
								String preColPath = "//div[@id='gridRevenueDetailsMain']/div[2]/table/tbody/tr["+k+"]/td[10]";
								
								WebElement preColElement = driver.findElement(By.xpath(preColPath));
								
								String preColValue = preColElement.getText();
								
								String effFromPath = "//div[@id='gridRevenueDetailsMain']/div[2]/table/tbody/tr["+k+"]/td[17]";
								
								WebElement effFromElement = driver.findElement(By.xpath(effFromPath));
								
								String effFromValue = effFromElement.getText();
								
								String effToPath = "//div[@id='gridRevenueDetailsMain']/div[2]/table/tbody/tr["+k+"]/td[18]";
								
								WebElement effToElement = driver.findElement(By.xpath(effToPath));
								
								String effToValue = effToElement.getText();
								
								if(chargeValue.equalsIgnoreCase(xlsCharges) && basisValue.equalsIgnoreCase(xlsBasisCode) && rateValue.equalsIgnoreCase(stringXlsRate) && currValue.equalsIgnoreCase(xlsCurrency) && preColValue.equalsIgnoreCase(xlsPreCol) && effFromValue.equalsIgnoreCase(xlsRevenueEffectiveFromDtl) && effToValue.equalsIgnoreCase(xlsRevenueEffectiveToDtl))
								{
									log = "Duplicate value present in row no:"+rowNumber+" "+"in the data sheet named "+"'"+tabName+"'";
									revenueFlag = 0;
								}
								else
								{
									revenueFlag = 1;
								}
								
								if(k == revenueList.size() && revenueFlag == 1)
								{
									clickOnAddAndModifyRevenue();
									
									try 
									{
										Thread.sleep(3000);
									} 
									catch (InterruptedException eBtnAddAndModifyRevenue)
									{
										eBtnAddAndModifyRevenue.printStackTrace();
									}
									
									clickonAddRevenueinPopup();
									
									if(xlsCharges!="")
									{
										try 
										{
											enterCharges(xlsCharges);
										} 
										catch (InterruptedException eCharges) 
										{
											eCharges.printStackTrace();
										}
									}
							
									if(xlsBasisCode!="")
									{
										enterBasisCode(xlsBasisCode);
									}
							
									if(stringXlsRate!="")
									{
										enterRate(stringXlsRate);
									}
							
									if(xlsCurrency!="")
									{
										enterCurrency(xlsCurrency);
									}
							
									if(xlsPreCol!="")
									{
										enterPreCol(xlsPreCol);
									}
							
									if(xlsFrgtCollOfcCode!="")
									{
										enterFrgtCollOfcCode(xlsFrgtCollOfcCode);
									}
							
									if(xlsInvoiceOfcCode!="")
									{
										enterInvOfcCode(xlsInvoiceOfcCode);
									}
									
									if(!xlsContType.equalsIgnoreCase("Spot Rate Guidelines"))
									{
										if(stringXlsPayerCode!="")
										{
											enterPayer(stringXlsPayerCode);
										}
									}
							
									if(xlsRevenueEffectiveFromDtl!="")
									{
										enterRevenueEffectiveFrom(xlsRevenueEffectiveFromDtl);
									}
							
									if(xlsRevenueEffectiveToDtl!="")
									{
										enterRevenueEffectiveTo(xlsRevenueEffectiveToDtl);
									}
							
									String revBtnPath = "//*[@id='btnSave"+(revenueList.size()+1)+"']";
									
									WebElement newSaveElement = driver.findElement(By.xpath(revBtnPath));
							
									newSaveElement.click();
									
									try 
									{
										Thread.sleep(3000);
									} 
									catch (InterruptedException eNewSave) 
									{
										eNewSave.printStackTrace();
									}
									
									clickRevenuePopupClose();
							
									conCragoSaveButton();
									
									try 
									{
										Thread.sleep(3000);
									} 
									catch (InterruptedException eNewSave) 
									{
										eNewSave.printStackTrace();
									}
									log = "Only Revenue details added successfully for row number "+rowNumber;
								}
							}
						}
						else
						{
							modelFlag = 1;
						}
						if(j == modelList.size() && modelFlag == 1)
						{
							WebElement newModelElement = driver.findElement(By.xpath("//li[@id='treeview-left_tv_active']/ul/li[1]/div/span/div"));
							
							newModelElement.click();
							
							try 
							{
								Thread.sleep(3000);
							} 
							catch (InterruptedException eNewModel) 
							{
								eNewModel.printStackTrace();
							}
														
							if(xlsModelCode!="")
							{
								try 
								{
									enterContModelName(xlsModelCode);
								} 
								catch (InterruptedException eModelCode) 
								{
									eModelCode.printStackTrace();
								}
							}
											
							if(stringXlsIndicativeQntityUnits!="")
							{
								enterIndicativeQntityUnits(stringXlsIndicativeQntityUnits);
							}
											
							//opening revenue pop-up
							clickOnAddAndModifyRevenue();
											
							if(xlsCharges!="")
							{
								try 
								{
									enterCharges(xlsCharges);
								} 
								catch (InterruptedException eCharges) 
								{
									eCharges.printStackTrace();
								}
							}
											
							if(xlsBasisCode!="")
							{
								enterBasisCode(xlsBasisCode);
							}
											
							if(stringXlsRate!="")
							{
								enterRate(stringXlsRate);
							}
											
							if(xlsCurrency!="")
							{
								enterCurrency(xlsCurrency);
							}
											
							if(xlsPreCol!="")
							{
								enterPreCol(xlsPreCol);
							}
											
							if(xlsFrgtCollOfcCode!="")
							{
								enterFrgtCollOfcCode(xlsFrgtCollOfcCode);
							}
											
							if(xlsInvoiceOfcCode!="")
							{
								enterInvOfcCode(xlsInvoiceOfcCode);
							}
											
							if(!xlsContType.equalsIgnoreCase("Spot Rate Guidelines"))
							{
								if(stringXlsPayerCode!="")
								{
									enterPayer(stringXlsPayerCode);
								}
							}
											
							if(xlsRevenueEffectiveFromDtl!="")
							{
								enterRevenueEffectiveFrom(xlsRevenueEffectiveFromDtl);
							}
											
							if(xlsRevenueEffectiveToDtl!="")
							{
								enterRevenueEffectiveTo(xlsRevenueEffectiveToDtl);
							}
											
							clickRevenueSave();
							
							try 
							{
								Thread.sleep(3000);
							} 
							catch (InterruptedException eNewSave) 
							{
								eNewSave.printStackTrace();
							}
											
							clickRevenuePopupClose();
											
							conCragoSaveButton();
							
							try 
							{
								Thread.sleep(3000);
							} 
							catch (InterruptedException eNewSave) 
							{
								eNewSave.printStackTrace();
							}
							log = "Model and Revenue details added successfully for row number "+rowNumber;
						}
					}
				}
				else
				{
					lpDpFlag = 1;
				}
			}
			else
			{
				lpDpFlag = 1;	
			}
			
			if(i==lpDplist.size() && lpDpFlag == 1)
			{
				WebElement newLPDPElement = driver.findElement(By.xpath("//*[@id='treeview-left']/ul/li/ul/li[1]/div/span/div"));
				newLPDPElement.click();
				try 
				{
					Thread.sleep(4000);
				} 
				catch (InterruptedException eNewLPDP) 
				{
					eNewLPDP.printStackTrace();
				}
				
				if(xlsFrmPortCode!="")
				{
					try 
					{
						enterContLoadPort(xlsFrmPortCode);
					} 
					catch (InterruptedException eFromPort) 
					{
						eFromPort.printStackTrace();
					}
				}
				
			
				if(xlsToPortCode!="")
				{
					try 
					{
						enterContDisPort(xlsToPortCode);
					} 
					catch (InterruptedException eToPort) 
					{
						eToPort.printStackTrace();
					}
				}
		
			
				if(xlsPlaceOfReceiptCode!="")
				{
					try 
					{
						enterPlaceOfReceiptCode(xlsPlaceOfReceiptCode);
					} 
					catch (InterruptedException ePRCode) 
					{
						ePRCode.printStackTrace();
					}
				}
		
				if(xlsPlaceOfDeliveryCode!="")
				{
					try 
					{
						enterPlaceOfDeliveryCode(xlsPlaceOfDeliveryCode);
					} 
					catch (InterruptedException ePDCode) 
					{
						ePDCode.printStackTrace();
					}
				}
		
				if(xlsTsh1!="")
				{
					enterTSH1(xlsTsh1);
				}
		
			
				if(xlsTsh2!="")
				{
					enterTSH2(xlsTsh2);
				}
		
			
				if(xlsTsh3!="")
				{
					enterTSH3(xlsTsh3);
				}
		
				if(!xlsContType.equalsIgnoreCase("Spot Rate Guidelines"))
				{
					if(xlsJapFrgtTrmntCode!="")
					{
						if(xlsJapFrgtTrmntCode.compareTo("YES") == 0)
						{
							checkJapFrgtTrmntCodeFlag();
							
							
							if(xlsSRGContNo!=null)
							{
								enterSRGContNo(xlsSRGContNo);
							}
					
							if(stringXlsGGNRatio!=null)
							{
								enterGGNRatio(stringXlsGGNRatio);
							}
						}
					}
				}
				
				if(xlsTerms!="")
				{
					try 
					{
						selectTerms(xlsTerms);
					} 
					catch (InterruptedException eTerms) 
					{
						eTerms.printStackTrace();
					}
				}
		
				if(xlsFDPS!="")
				{
					try 
					{
						enterFDPS(xlsFDPS);
					} 
					catch (InterruptedException eFDPS) 
					{
					eFDPS.printStackTrace();
					}
				}
						
			
				if(xlsDocIssueOfcCodeDtl!="")
				{
					try 
					{
						enterDocIssueOfcCode(xlsDocIssueOfcCodeDtl);
					} 
					catch (InterruptedException eDocIssueOfcCodeDtl) 
					{
						eDocIssueOfcCodeDtl.printStackTrace();
					}
				}
		
				//saving value of LP-DP combination
				clickOnContADDLpDpSave();
				
				String errVal = getErrConfMsg();
				
				if(errVal.contains("600007-CON-LP-DP combination already exists"))
				{
					log = "Duplicate LP-DP combination present in row no:"+rowNumber+" "+"in the data sheet named "+"'"+tabName+"'";
					break;
				}
				/*else
				{
					System.out.println(errVal);
				}
				*/
				
				try 
				{
					Thread.sleep(3000);
				} 
				catch (InterruptedException eScreenClear) 
				{
					eScreenClear.printStackTrace();
				}
				
				WebElement newMakeModel = driver.findElement(By.xpath("//*[@id='treeview-left_tv_active']/ul/li/div/span"));
				newMakeModel.click();
			
				try 
				{
					Thread.sleep(2000);
				} 
				catch (InterruptedException eNewMakeModel) 
				{
					eNewMakeModel.printStackTrace();
				}
				
				if(xlsModelCode!="")
				{
					try 
					{
						enterContModelName(xlsModelCode);
					} 
					catch (InterruptedException eModelCode) 
					{
						eModelCode.printStackTrace();
					}
				}
								
				if(stringXlsIndicativeQntityUnits!="")
				{
					enterIndicativeQntityUnits(stringXlsIndicativeQntityUnits);
				}
								
				//opening revenue pop-up
				clickOnAddAndModifyRevenue();
				
				try 
				{
					Thread.sleep(3000);
				} 
				catch (InterruptedException eAddAndModifyRevenue)
				{
					eAddAndModifyRevenue.printStackTrace();
				}
				
				if(xlsCharges!="")
				{
					try 
					{
						enterCharges(xlsCharges);
					} 
					catch (InterruptedException eCharges) 
					{
						eCharges.printStackTrace();
					}
				}
	
				if(xlsBasisCode!="")
				{
					enterBasisCode(xlsBasisCode);
				}
	
				if(stringXlsRate!="")
				{
					enterRate(stringXlsRate);
				}
	
				if(xlsCurrency!="")
				{
					enterCurrency(xlsCurrency);
				}
	
				if(xlsPreCol!="")
				{
					enterPreCol(xlsPreCol);
				}
	
				if(xlsFrgtCollOfcCode!="")
				{
					enterFrgtCollOfcCode(xlsFrgtCollOfcCode);
				}
	
				if(xlsInvoiceOfcCode!="")
				{
					enterInvOfcCode(xlsInvoiceOfcCode);
				}
				
				if(!xlsContType.equalsIgnoreCase("Spot Rate Guidelines"))
				{
					if(stringXlsPayerCode!="")
					{
						enterPayer(stringXlsPayerCode);
					}
				}
				
	
				if(xlsRevenueEffectiveFromDtl!="")
				{
					enterRevenueEffectiveFrom(xlsRevenueEffectiveFromDtl);
				}
	
				if(xlsRevenueEffectiveToDtl!="")
				{
					enterRevenueEffectiveTo(xlsRevenueEffectiveToDtl);
				}
	
				clickRevenueSave();
				
				try 
				{
					Thread.sleep(3000);
				} 
				catch (InterruptedException eNewSave) 
				{
					eNewSave.printStackTrace();
				}
	
				clickRevenuePopupClose();
	
				conCragoSaveButton();
				
				try 
				{
					Thread.sleep(3000);
				} 
				catch (InterruptedException eNewSave) 
				{
					eNewSave.printStackTrace();
				}
				log = "All details added successfully for row number "+rowNumber;
			}
		}
		return log;
	}
}
