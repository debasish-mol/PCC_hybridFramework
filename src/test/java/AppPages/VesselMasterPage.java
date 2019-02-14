package AppPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class VesselMasterPage {
	
	public WebDriver driver;
	
	public VesselMasterPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	@FindBy(xpath="//input[@id='txtVesselName']") WebElement vslName_search;
	
	@FindBy(xpath="//input[@id='txtVesselCode']") WebElement VesselCode_search;
	
	@FindBy(xpath="//input[@id='txtVesselImoNo']") WebElement impNumber_search;
	
	@FindBy(xpath="//label[contains(.,'Vessel Status')]/following::span[1]/span/span[2]/span") WebElement vesselStatus_search;
	
	@FindBy(xpath="//ul[@id='ddlVesselStatus_listbox']/li") List<WebElement> vesselStatusList_search;
	
	@FindBy(xpath="//input[@id='txtVesselOperator']") WebElement vesselOperator_search;
	
	@FindBy(xpath="html/body/div[2]/div[2]/div[3]/div[2]/div/div[6]/span/span/span[2]/span") WebElement vesselCategory_search;
	
	@FindBy(xpath="//ul[@id='ddlVesselCategory_listbox']/li") List<WebElement> vesselCategoryList_search;
	
	@FindBy(xpath="html/body/div[2]/div[2]/div[3]/div[2]/div/div[7]/span/span/span[2]/span") WebElement vesselType_search;
	
	@FindBy(xpath="//ul[@id='ddlVesselType_listbox']/li") List<WebElement> vesselTypeList_search;
	
	@FindBy(xpath="//input[@id='btnAdd']") WebElement addNewVessel;
	
	@FindBy(xpath="//input[@id='btnClearSearch']") WebElement clear;
	
	@FindBy(xpath="//input[@id='btnVesselSearch']") WebElement search;
	
	//============================================================================================================================
	
	@FindBy(xpath="//span[@id='vesselWindow_wnd_title']") WebElement addNewVesselWinTitle;
	
	@FindBy(xpath="//input[@id='txtVslName']") WebElement vesselName;
	
	@FindBy(xpath="//div[@id='vesselWindowContent']/div/div[3]/div[2]/div/div[3]/div/div[4]/span/span/span[2]/span") WebElement vesselCategorySelect;
	
	@FindBy(xpath="//ul[@id='ddlVesselCat_listbox']/li") List<WebElement> vesselCategoryListEntry;
	
	@FindBy(xpath="//input[@id='txtVesselOper']") WebElement vesselOperatorEntry;
	
	@FindBy(id="hdnVesselOperUid") WebElement vesselOperatorID;
	
	@FindBy(xpath="//div[@id='vesselWindowContent']/div/div[3]/div[2]/div/div[3]/div/div[6]/span/span/span[2]/span") WebElement vesselStatusSelect;
	
	@FindBy(xpath="//ul[@id='ddlVesselStats_listbox']/li") List<WebElement> vesselStatusListEntry;
	
	@FindBy(xpath="//input[@id='txtMOLCode']") WebElement molCode;
	
	@FindBy(xpath="//input[@id='txtIMONumber']") WebElement imoNumber;
	
	@FindBy(xpath="//input[@id='txtCallSign']") WebElement callSign;
	
	@FindBy(xpath="//input[@id='txtCountryFlag']") WebElement countryFlag;
	
	@FindBy(id="hdnCountryCode")  WebElement countryFlagValue;
	
	@FindBy(xpath="//input[@id='txtStandardHireCost']") WebElement StandardTCHire;
	
	@FindBy(xpath="//input[@id='dtExpiryDate']") WebElement expiryDate;
	
	@FindBy(xpath="//input[@id='txtBeam']") WebElement beam;
	
	@FindBy(xpath="//input[@id='txtLpp']") WebElement lpp;
	
	@FindBy(xpath="//input[@id='txtLoa']") WebElement loa;
	
	@FindBy(xpath="//input[@id='txtDeaughtFull']") WebElement draught;
	
	@FindBy(xpath="//input[@id='txtDeadWeight']") WebElement deadWeight;
	
	@FindBy(xpath="//div[@id='vesselWindowContent']/div/div[3]/div[3]/div/div[1]/a") WebElement vesselCapacityExpand;
	
	@FindBy(xpath="//input[@id='txtCapacityRT']") WebElement capacityRT;
	
	@FindBy(xpath="//input[@id='txtRampCapacity']") WebElement sternRampCapacity;
	
	@FindBy(xpath="//input[@id='txtCalPanelHeight']") WebElement calculatePanelUPFromHeight;
	
	@FindBy(xpath="//input[@id='txtPanUpMultipler']") WebElement calculatePanelUPMultiplier;
	
	@FindBy(xpath="//td[text()='Car Deck(Standard)']/following::td[1]/input") WebElement carDeckHeightFrom;
	
	@FindBy(xpath="//td[text()='Car Deck(Standard)']/following::td[2]/input") WebElement carDeckHeightTo;
	
	@FindBy(xpath="//td[text()='Car Deck(Standard)']/following::td[3]/input") WebElement carDeckM2;
	
	@FindBy(xpath="//td[text()='Car Deck(Standard)']/following::td[4]/input") WebElement carDeckM3;
	
	@FindBy(xpath="//td[text()='HSV Deck']/following::td[1]/input") WebElement HSVDeckHeightFrom;
	
	@FindBy(xpath="//td[text()='HSV Deck']/following::td[2]/input") WebElement HSVDeckHeightTo;
	
	@FindBy(xpath="//td[text()='HSV Deck']/following::td[3]/input") WebElement HSVDeckM2;
	
	@FindBy(xpath="//td[text()='HSV Deck']/following::td[4]/input") WebElement HSVDeckM3;
	
	@FindBy(xpath="//td[text()='Truck Deck']/following::td[1]/input") WebElement truckDeckHeightFrom;
	
	@FindBy(xpath="//td[text()='Truck Deck']/following::td[2]/input") WebElement truckDeckHeightTo;
	
	@FindBy(xpath="//td[text()='Truck Deck']/following::td[3]/input") WebElement truckDeckM2;
	
	@FindBy(xpath="//td[text()='Truck Deck']/following::td[4]/input") WebElement truckDeckM3;
	
	@FindBy(xpath="//td[text()='H&H(Main Deck)']/following::td[1]/input") WebElement HHMainDeckHeightFrom;
	
	@FindBy(xpath="//td[text()='H&H(Main Deck)']/following::td[2]/input") WebElement HHMainDeckHeightTo;
	
	@FindBy(xpath="//td[text()='H&H(Main Deck)']/following::td[3]/input") WebElement HHMainDeckM2;
	
	@FindBy(xpath="//td[text()='H&H(Main Deck)']/following::td[4]/input") WebElement HHMainDeckM3;
	
	@FindBy(xpath="//td[text()='Total']/following::td[1]/input") WebElement totalHeightFrom;
	
	@FindBy(xpath="//td[text()='Total']/following::td[2]/input") WebElement totalHeightTo;
	
	@FindBy(xpath="//td[text()='Total']/following::td[3]/input") WebElement totalM2;
	
	@FindBy(xpath="//td[text()='Total']/following::td[4]/input") WebElement totalM3;
	
	@FindBy(xpath="//div[@id='vesselWindowContent']/div/div[3]/div[4]/div/div[1]/a") WebElement vessselConExpand;
	
	@FindBy(xpath="//input[@id='chkhfoIsSeaRunDefault']") WebElement hfoConDfSeaRun;
	
	@FindBy(xpath="//input[@id='chkhfoIsSECADefault']") WebElement hfoConDfSECA;
	
	@FindBy(xpath="//input[@id='chkhfoIsDriftingDefault']") WebElement hfoConDfDrifting;
	
	@FindBy(xpath="//input[@id='chkhfoIsPortDefault']") WebElement hfoConDfPort;
	
	
	@FindBy(xpath="//input[@id='txtHfoConsumptionFull']") WebElement hfoConFull;
	
	@FindBy(xpath="//input[@id='txtHfoConsumptionSs']") WebElement hfoConSs;
	
	@FindBy(xpath="//input[@id='txtHfoConsumptionMss']") WebElement hfoConMss;
	
	@FindBy(xpath="//input[@id='txtHfoConsumptionSss']") WebElement hfoConSss;
	
	@FindBy(xpath="//input[@id='txtHfoConsumptionUss']") WebElement hfoConUss;
	
	@FindBy(xpath="//input[@id='txtHfoConsumptionPort']") WebElement hfoConPort;
	
	@FindBy(xpath="//input[@id='chkMdoIsSeaRunDefault']") WebElement mdoConDfSeaRun;
	
	@FindBy(xpath="//input[@id='chkMdoIsSECADefault']") WebElement mdoConDfSECA;
	
	@FindBy(xpath="//input[@id='chkMdoIsDriftingDefault']") WebElement mdoConDfDrifting;
	
	@FindBy(xpath="//input[@id='chkMdoIsPortDefault']") WebElement mdoConDfPort;
	
	
	@FindBy(xpath="//input[@id='txtMdoConsumptionFull']") WebElement mdoConFull;
	
	@FindBy(xpath="//input[@id='txtMdoConsumptionSs']") WebElement mdoConSs;
	
	@FindBy(xpath="//input[@id='txtMdoConsumptionMss']") WebElement mdoConMss;
	
	@FindBy(xpath="//input[@id='txtMdoConsumptionSss']") WebElement mdoConSss;
	
	@FindBy(xpath="//input[@id='txtMdoConsumptionUss']") WebElement mdoConUss;
	
	@FindBy(xpath="//input[@id='txtMdoConsumptionPort']") WebElement mdoConPort;
	
	@FindBy(xpath="//input[@id='chkMgoIsSeaRunDefault']") WebElement mgoConDfSeaRun;
	
	@FindBy(xpath="//input[@id='chkMgoIsSECADefault']") WebElement mgoConDfSECA;
	
	@FindBy(xpath="//input[@id='chkMgoIsDriftingDefault']") WebElement mgoConDfDrifting;
	
	@FindBy(xpath="//input[@id='chkMgoIsPortDefault']") WebElement mgoConDfPort;
	
	@FindBy(xpath="//input[@id='txtMgoConsumptionFull']") WebElement mgoConFull;
	
	@FindBy(xpath="//input[@id='txtMgoConsumptionSs']") WebElement mgoConSs;
	
	@FindBy(xpath="//input[@id='txtMgoConsumptionMss']") WebElement mgoConMss;
	
	@FindBy(xpath="//input[@id='txtMgoConsumptionSss']") WebElement mgoConSss;
	
	@FindBy(xpath="//input[@id='txtMgoConsumptionUss']") WebElement mgoConUss;
	
	@FindBy(xpath="//input[@id='txtMgoConsumptionPort']") WebElement mgoConPort;
	
	@FindBy(xpath="//input[@id='txtVslSppedFull']") WebElement vesselSpeedFull;
	
	@FindBy(xpath="//input[@id='txtVslSppedSs']") WebElement vesselSpeedSs;
	
	@FindBy(xpath="//input[@id='txtVslSppedMss']") WebElement vesselSpeedMss;
	
	@FindBy(xpath="//input[@id='txtVslSppedSss']") WebElement vesselSpeedSss;
	
	@FindBy(xpath="//input[@id='txtVslSppedUss']") WebElement vesselSpeedUss;
	
	@FindBy(xpath="//textarea[@id='txtRemarks']") WebElement rmks;
	
	@FindBy(xpath="//input[@id='chkLsfoIsSeaRunDefault']") WebElement lsfoConDfSeaRun;
	
	@FindBy(xpath="//input[@id='chkLsfoIsSECADefault']") WebElement lsfoConDfSECA;
	
	@FindBy(xpath="//input[@id='chkLsfoIsDriftingDefault']") WebElement lsfoConDfDrifting;
	
	@FindBy(xpath="//input[@id='chkLsfoIsPortDefault']") WebElement lsfoConDfPort;
	
	@FindBy(xpath="//input[@id='txtLsfoConsumptionFull']") WebElement lsfoConFull;
	
	@FindBy(xpath="//input[@id='txtLsfoConsumptionSs']") WebElement lsfoConSs;
	
	@FindBy(xpath="//input[@id='txtLsfoConsumptionMss']") WebElement lsfoConMss;
	
	@FindBy(xpath="//input[@id='txtLsfoConsumptionSss']") WebElement lsfoConSss;
	
	@FindBy(xpath="//input[@id='txtLsfoConsumptionUss']") WebElement lsfoConUss;
	
	@FindBy(xpath="//input[@id='txtLsfoConsumptionPort']") WebElement lsfoConPort;
	
	@FindBy(xpath="//input[@id='chkLsdoIsSeaRunDefault']") WebElement lsdoConDfSeaRun;
	
	@FindBy(xpath="//input[@id='chkLsdoIsSECADefault']") WebElement lsdoConDfSECA;
	
	@FindBy(xpath="//input[@id='chkLsdoIsDriftingDefault']") WebElement lsdoConDfDrifting;
	
	@FindBy(xpath="//input[@id='chkLsdoIsPortDefault']") WebElement lsdoConDfPort;
	
	@FindBy(xpath="//input[@id='txtLsdoConsumptionFull']") WebElement lsdoConFull;
	
	@FindBy(xpath="//input[@id='txtLsdoConsumptionSs']") WebElement lsdoConSs;
	
	@FindBy(xpath="//input[@id='txtLsdoConsumptionMss']") WebElement lsdoConMss;
	
	@FindBy(xpath="//input[@id='txtLsdoConsumptionSss']") WebElement lsdoConSss;
	
	@FindBy(xpath="//input[@id='txtLsdoConsumptionUss']") WebElement lsdoConUss;
	
	@FindBy(xpath="//input[@id='txtLsdoConsumptionPort']") WebElement lsdoConPort;
	
	@FindBy(xpath="//input[@id='chkLsgoIsSeaRunDefault']") WebElement lsgoConDfSeaRun;
	
	@FindBy(xpath="//input[@id='chkLsgoIsSECADefault']") WebElement lsgoConDfSECA;
	
	@FindBy(xpath="//input[@id='chkLsgoIsDriftingDefault']") WebElement lsgoConDfDrifting;
	
	@FindBy(xpath="//input[@id='chkLsgoIsPortDefault']") WebElement lsgoConDfPort;
	
	@FindBy(xpath="//input[@id='txtLsgoConsumptionFull']") WebElement lsgoConFull;
	
	@FindBy(xpath="//input[@id='txtLsgoConsumptionSs']") WebElement lsgoConSs;
	
	@FindBy(xpath="//input[@id='txtLsgoConsumptionMss']") WebElement lsgoConMss;
	
	@FindBy(xpath="//input[@id='txtLsgoConsumptionSss']") WebElement lsgoConSss;
	
	@FindBy(xpath="//input[@id='txtLsgoConsumptionUss']") WebElement lsgoConUss;
	
	@FindBy(xpath="//input[@id='txtLsgoConsumptionPort']") WebElement lsgoConPort;
	
	@FindBy(xpath="//input[@id='txtStdBunkCostfo']") WebElement stadBunkFO;
	
	@FindBy(xpath="//input[@id='txtStdBunkCostdo']") WebElement stadBunkDO;
	
	@FindBy(xpath="//input[@id='btnSave']") WebElement saveButton;
	
	@FindBy(xpath="//input[@id='btnCancel']") WebElement cnclButton;
	
	@FindBy(xpath="//div[@id='gridVslMessage']/div") WebElement saveMsg;
	
	
	public void clickOnAddNewVessel()
	{
		addNewVessel.click();
		
		WebDriverWait waitAddNewVesselWindow = new WebDriverWait(driver,20);
		
		waitAddNewVesselWindow.until(ExpectedConditions.visibilityOf(addNewVesselWinTitle));
				
	}
	
	public void enterVesselName(String vslName)
	{
		vesselName.sendKeys(vslName);
	}
	
	
	public void enterVesselCategory(String vslcat)
	{
		vesselCategorySelect.click();
		
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException evslcat) {
			
			evslcat.printStackTrace();
		}
		
		for(WebElement e : vesselCategoryListEntry)
		{
			if(e.getText().equals(vslcat))
			{
				e.click();
				
				break;
			}
		}
				
	}
	
	public void enterVslOperator(String vslOpName)
	{
		vesselOperatorEntry.sendKeys(vslOpName);
		
		WebDriverWait waitVslOp = new WebDriverWait(driver,10);
		
		waitVslOp.until(ExpectedConditions.attributeToBeNotEmpty(vesselOperatorID,"value"));
		
	}
	
	
	public void selectVslStatus(String sts)
	{
		vesselStatusSelect.click();
		
		try {
			
			Thread.sleep(1000);
			
			} catch (InterruptedException eVslSts)
			{
			
				eVslSts.printStackTrace();
			
			}
			
		
		for(WebElement e: vesselStatusListEntry)
		{
			
			if(e.equals(sts))
			{
				e.click();
				
				break;
			}
			
		}
		
		
		
	}
	
	
	
	public void enterMolCode(String code)
	{
		molCode.sendKeys(code);
		
	}
	
	
	public void enterImoNumber(String imoNo)
	{
		imoNumber.sendKeys(imoNo);
	}
	
	public void entercallSign(String callSigns)
	{
		callSign.sendKeys(callSigns);
	}
	
	
	public void enterCountryFlag(String ctryFlag)
	{
		countryFlag.sendKeys(ctryFlag);
		
		WebDriverWait waitctryFlag= new WebDriverWait(driver,10);
		
		waitctryFlag.until(ExpectedConditions.attributeToBeNotEmpty(countryFlagValue,"value"));
		
	}
	
	
	public void enterStndTCHire(String stc)
	{
		StandardTCHire.sendKeys(stc);
	}
	
	
	public void enterExpiryDate(String date)
	{
		
		expiryDate.sendKeys(date);
		
	}
	
	
	
	
	public void enterBeam(String beamNo)
	{
		beam.sendKeys(beamNo);
	}
	
	public void enterLpp(String lppNo)
	{
		lpp.sendKeys(lppNo);
	}
	
	public void enterloa(String loaNo)
	{
		loa.sendKeys(loaNo);
	}
	
	public void enterDraught(String Drgt)
	{
		draught.sendKeys(Drgt);
	}
	
	
	public void enterdeadWeight(String Ddwgt)
	{
		deadWeight.sendKeys(Ddwgt);
	}
	
	public void clickvesselCapacityExpand()
	{
		vesselCapacityExpand.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException eexpan) {
			
			eexpan.printStackTrace();
		}
		
		WebDriverWait waitcarDeck = new WebDriverWait(driver,10);
		waitcarDeck.until(ExpectedConditions.elementToBeClickable(carDeckHeightFrom));
		
	}
	
	
	
	public void entercarDeckHeightFrom(String higtFrom)
	{
		carDeckHeightFrom.sendKeys(higtFrom);
	}
	
	public void entercarDeckHeightTo(String higtTo)
	{
		carDeckHeightTo.sendKeys(higtTo);
	}
	
	public void entercarDeckM2(String DeckM2)
	{
		carDeckM2.sendKeys(DeckM2);
	}
	
	public void entercarDeckM3(String DeckM3)
	{
		carDeckM3.sendKeys(DeckM3);
	}
	
	public void enterHSVDeckHeightFrom(String HeightFrom)
	{
		HSVDeckHeightFrom.sendKeys(HeightFrom);
	}
	
	public void enterHSVDeckHeightTo(String HeightTo)
	{
		HSVDeckHeightTo.sendKeys(HeightTo);
	}
	
	public void enterHSVDeckM2(String DeckM2)
	{
		HSVDeckM2.sendKeys(DeckM2);
	}
	public void enterHSVDeckM3(String DeckM3)
	{
		HSVDeckM3.sendKeys(DeckM3);
	}
	
	public void entertruckDeckHeightFrom(String HeightFrom)
	{
		truckDeckHeightFrom.sendKeys(HeightFrom);
	}
	
	public void entertruckDeckHeightTo(String HeightTo)
	{
		truckDeckHeightTo.sendKeys(HeightTo);
	}
	
	public void entertruckDeckM2(String DeckM2)
	{
		truckDeckM2.sendKeys(DeckM2);
	}
	
	public void entertruckDeckM3(String DeckM3)
	{
		truckDeckM3.sendKeys(DeckM3);
	}
	
	public void enterHHMainDeckHeightFrom(String HeightFrom)
	{
		HHMainDeckHeightFrom.sendKeys(HeightFrom);
	}
	
	public void enterHHMainDeckHeightTo(String HeightTo)
	{
		HHMainDeckHeightTo.sendKeys(HeightTo);
	}
	
	public void enterHHMainDeckM2(String DeckM2)
	{
		HHMainDeckM2.sendKeys(DeckM2);
	}
	
	public void enterHHMainDeckM3(String DeckM3)
	{
		HHMainDeckM3.sendKeys(DeckM3);
	}
	public void enterTotalHeightFrom(String HeightFrom)
	{
		totalHeightFrom.sendKeys(HeightFrom);
	}
	public void enterTotalHeightTo(String HeightTo)
	{
		totalHeightTo.sendKeys(HeightTo);
	}
	public void enterTotalM2(String M2)
	{
		totalM2.sendKeys(M2);
	}
	public void enterTotalM3(String M3)
	{
		totalM3.sendKeys(M3);
	}
	
	public void enterCapacityRT(String Capacity)
	{
		capacityRT.sendKeys(Capacity);
	}
	
	public void enterSternRampCapacity(String RampCapacity)
	{
		sternRampCapacity.sendKeys(RampCapacity);
	}
	
	public void enterCalculatePanelUPFromHeight(String PanelUPFromHeight)
	{
		calculatePanelUPFromHeight.sendKeys(PanelUPFromHeight);
	}
	public void enterCalculatePanelUPMultiplier(String PanelUPMultiplier)
	{
		calculatePanelUPMultiplier.sendKeys(PanelUPMultiplier);
	}
	
	public void clickVessselConExpand()
	{
		vessselConExpand.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException eVessselCon) {
			
			eVessselCon.printStackTrace();
		}
		
		WebDriverWait waitSeaRun = new WebDriverWait(driver,10);
		waitSeaRun.until(ExpectedConditions.elementToBeClickable(hfoConDfSeaRun));
		
		
	}
	
	public void checkHfoConDfSeaRun(String SeaRun)
	{
		if(SeaRun.equalsIgnoreCase("Y"))
		{	
		hfoConDfSeaRun.click();
		}
	}
	
	public void checkhfoConDfSECA(String SECA)
	{
		if(SECA.equalsIgnoreCase("Y"))
		{	
			hfoConDfSECA.click();
		}
	}
	
	public void checkhfoConDfDrifting(String Drifting)
	{
		if(Drifting.equalsIgnoreCase("Y"))
		{	
			hfoConDfDrifting.click();
		}
	}
	
	public void checkhfoConDfPort(String Port)
	{
		if(Port.equalsIgnoreCase("Y"))
		{	
			hfoConDfPort.click();
		}
	}
	
	
	public void enterhfoConFull(String hfoFull)
	{
		hfoConFull.sendKeys(hfoFull);
	}
	
	
	public void enterhfoConSs(String hfoSs)
	{
		hfoConSs.sendKeys(hfoSs);
	}
	
	public void enterhfoConMss(String hfoMss)
	{
		hfoConMss.sendKeys(hfoMss);
	}
	
	
	public void enterhfoConSss(String hfoSss)
	{
		hfoConSss.sendKeys(hfoSss);
	}
	
	public void enterhfoConUss(String hfoUss)
	{
		hfoConUss.sendKeys(hfoUss);
	}
	
	public void enterhfoConPort(String hfoPort)
	{
		hfoConPort.sendKeys(hfoPort);
	}
	
	public void checkmdoConDfSeaRun(String SeaRun)
	{
		if(SeaRun.equalsIgnoreCase("Y"))
		{	
			mdoConDfSeaRun.click();
		}
	}
	
	public void checkmdoConDfSECA(String SECA)
	{
		if(SECA.equalsIgnoreCase("Y"))
		{	
			mdoConDfSECA.click();
		}
	}
	
	public void checkmdoConDfDrifting(String Drifting)
	{
		if(Drifting.equalsIgnoreCase("Y"))
		{	
			mdoConDfDrifting.click();
		}
	}
	
	public void checkmdoConDfPort(String Port)
	{
		if(Port.equalsIgnoreCase("Y"))
		{	
			mdoConDfPort.click();
		}
	}
	
	
	public void enterMdoConFull(String ConFull)
	{
		mdoConFull.sendKeys(ConFull);
	}
	
	public void enterMdoConSs(String ConSs)
	{
		mdoConSs.sendKeys(ConSs);
	}
	
	public void enterMdoConMss(String ConMss)
	{
		mdoConMss.sendKeys(ConMss);
	}
	
	public void enterMdoConSss(String ConSss)
	{
		mdoConSss.sendKeys(ConSss);
	}
	
	public void enterMdoConUss(String ConUss)
	{
		mdoConUss.sendKeys(ConUss);
	}
	
	public void enterMdoConPort(String ConPort)
	{
		mdoConPort.sendKeys(ConPort);
	}
	
	
	public void checkMgoConDfSeaRun(String SeaRun)
	{
		if(SeaRun.equalsIgnoreCase("Y"))
		{	
			mgoConDfSeaRun.click();
		}
	}
	
	public void checkMgoConDfSECA(String SECA)
	{
		if(SECA.equalsIgnoreCase("Y"))
		{	
			mgoConDfSECA.click();
		}
	}
	
	public void checkMgoConDfDrifting(String Drifting)
	{
		if(Drifting.equalsIgnoreCase("Y"))
		{	
			mgoConDfDrifting.click();
		}
	}
	
	public void checkMgoConDfPort(String DfPort)
	{
		if(DfPort.equalsIgnoreCase("Y"))
		{	
			mgoConDfPort.click();
		}
	}
	
	public void enterMgoConFull(String ConFull)
	{
		mgoConFull.sendKeys(ConFull);
	}
	
	public void enterMgoConSs(String ConSs)
	{
		mgoConSs.sendKeys(ConSs);
	}
	
	public void enterMgoConMss(String ConMss)
	{
		mgoConMss.sendKeys(ConMss);
	}
	
	public void enterMgoConSss(String ConSss)
	{
		mgoConSss.sendKeys(ConSss);
	}
	
	public void enterMgoConUss(String ConUss)
	{
		mgoConUss.sendKeys(ConUss);
	}
	
	public void enterMgoConPort(String ConPort)
	{
		mgoConPort.sendKeys(ConPort);
	}
	
	public void enterVesselSpeedFull(String VslFull)
	{
		vesselSpeedFull.sendKeys(VslFull);
	}
	
	
	public void enterVesselSpeedSs(String VslSs)
	{
		vesselSpeedSs.sendKeys(VslSs);
	}
	public void enterVesselSpeedMss(String VslMss)
	{
		vesselSpeedMss.sendKeys(VslMss);
	}
	public void enterVesselSpeedSss(String VslSss)
	{
		vesselSpeedSss.sendKeys(VslSss);
	}
	public void enterVesselSpeedUss(String VslUss)
	{
		vesselSpeedUss.sendKeys(VslUss);
	}
	
	public void enterRemarks(String Rmks)
	{
		rmks.sendKeys(Rmks);
	}
	
	
	public void checkLsfoConDfSeaRun(String SeaRun)
	{
		if(SeaRun.equalsIgnoreCase("Y"))
		{	
			lsfoConDfSeaRun.click();
		}
	}
	
	public void checkLsfoConDfSECA(String SECA)
	{
		if(SECA.equalsIgnoreCase("Y"))
		{	
			lsfoConDfSECA.click();
		}
	}
	
	public void checkLsfoConDfDrifting(String Drifting)
	{
		if(Drifting.equalsIgnoreCase("Y"))
		{	
			lsfoConDfDrifting.click();
		}
	}
	
	public void checkLsfoConDfPort(String DfPort)
	{
		if(DfPort.equalsIgnoreCase("Y"))
		{	
			lsfoConDfPort.click();
		}
	}
	
	public void enterLsfoConFull(String ConFull)
	{
		lsfoConFull.sendKeys(ConFull);
	}
	
	public void enterLsfoConSs(String ConSs)
	{
		lsfoConSs.sendKeys(ConSs);
	}
	
	public void enterLsfoConMss(String ConMss)
	{
		lsfoConMss.sendKeys(ConMss);
	}
	
	
	public void enterLsfoConSss(String ConSss)
	{
		lsfoConSss.sendKeys(ConSss);
	}
	
	public void enterLsfoConUss(String ConUss)
	{
		lsfoConUss.sendKeys(ConUss);
	}
	
	public void enterLsfoConPorts(String ConPort)
	{
		lsfoConPort.sendKeys(ConPort);
	}
	
	
	public void checklsdoConDfSeaRun(String SeaRun)
	{
		if(SeaRun.equalsIgnoreCase("Y"))
		{	
			lsdoConDfSeaRun.click();
		}
	}
	
	public void checklsdoConDfSECA(String DfSECA)
	{
		if(DfSECA.equalsIgnoreCase("Y"))
		{	
			lsdoConDfSECA.click();
		}
	}
	
	public void checklsdoConDfDrifting(String DfDrifting)
	{
		if(DfDrifting.equalsIgnoreCase("Y"))
		{	
			lsdoConDfDrifting.click();
		}
	}
	
	public void checklsdoConDfPort(String DfPort)
	{
		if(DfPort.equalsIgnoreCase("Y"))
		{	
			lsdoConDfPort.click();
		}
	}	
	
	public void enterLsdoConFull(String conFull)
	{
		lsdoConFull.sendKeys(conFull);
	}
	
	public void enterLsdoConSs(String conSs)
	{
		lsdoConSs.sendKeys(conSs);
	}
	
	public void enterLsdoConMss(String conMs)
	{
		lsdoConMss.sendKeys(conMs);
	}
	
	public void enterLsdoConSss(String conSss)
	{
		lsdoConSss.sendKeys(conSss);
	}
	
	public void enterLsdoConUss(String ConUss)
	{
		lsdoConUss.sendKeys(ConUss);
	}
	public void enterLsdoConPort(String ConPort)
	{
		lsdoConPort.sendKeys(ConPort);
	}
	
	public void checkLsgoConDfSeaRun(String SeaRun)
	{
		if(SeaRun.equalsIgnoreCase("Y"))
		{	
			lsgoConDfSeaRun.click();
		}
	}
	
	public void checkLsgoConDfSECA(String SECA)
	{
		if(SECA.equalsIgnoreCase("Y"))
		{	
			lsgoConDfSECA.click();
		}
	}
	
	public void checkLsgoConDfDrifting(String drifting)
	{
		if(drifting.equalsIgnoreCase("Y"))
		{	
			lsgoConDfDrifting.click();
		}
	}
	
	public void checkLsgoConDfPort(String DfPort)
	{
		if(DfPort.equalsIgnoreCase("Y"))
		{	
			lsgoConDfPort.click();
		}
	}
	
	public void enterLsgoConFull(String ConFull)
	{
		lsgoConFull.sendKeys(ConFull);
	}
	
	public void enterLsgoConSs(String ConSs)
	{
		lsgoConSs.sendKeys(ConSs);
	}
	
	public void enterLsgoConMss(String ConMss)
	{
		lsgoConMss.sendKeys(ConMss);
	}
	
	public void enterLsgoConSss(String ConSss)
	{
		lsgoConSss.sendKeys(ConSss);
	}
	
	public void enterLsgoConUss(String ConUss)
	{
		lsgoConUss.sendKeys(ConUss);
	}
	
	public void enterLsgoConPort(String ConPort)
	{
		lsgoConPort.sendKeys(ConPort);
	}
	
	public void enterStadBunkFO(String stdBunkFO)
	{
		stadBunkFO.sendKeys(stdBunkFO);
	}
	
	public void enterStadBunkDO(String stdBunkDO)
	{
		stadBunkDO.sendKeys(stdBunkDO);
	}
	
	public void clickOncnclButton()
	{
		cnclButton.click();
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	
	public String getMsg()
	{
		if(saveMsg.isEnabled())
		 {
			 String text = saveMsg.getText();
			 
			 return text;
		 }
		return null;
	}
	
}
