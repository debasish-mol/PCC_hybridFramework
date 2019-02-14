package TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AppPages.VesselMasterPage;
import AppPages.loginPages;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Utility.Helper;

public class TCVS_creation {
	
	public WebDriver driver;
	
	loginPages home;
	
	ExtentReports report;

	ExtentTest logger;
	
	@BeforeMethod
	public void setup() 
	{
		report = new ExtentReports(".//Reports/TCVS_Vessel_creation.html",true);
		
		logger= report.startTest("Vessel Creation");
		
		BrowserFactory br = new BrowserFactory();
		
        driver = br.getBrowser();
        
        logger.log(LogStatus.INFO,"Browser opened");
		
        String url="vsl";
        
		driver.get(DataProviderFactory.getConfig().getUrl(url));
		
		//Thread.sleep(4000);
		
		 home = PageFactory.initElements(driver, loginPages.class);
		
		home.loginInfo();	
		
		logger.log(LogStatus.INFO,"Login succesfully");
		
	}
	
	@Test
	public void VesselCreate()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		VesselMasterPage vm = PageFactory.initElements(driver, VesselMasterPage.class);
		
		String excelPath="D:\\all\\personal\\backup\\Selenium3\\SeleniumProgram\\com.Pcc.Net.Hybridframework\\ApplicationTestData\\CreateVessel.xlsx";
						
		vm.clickOnAddNewVessel();
		
		logger.log(LogStatus.INFO,"Opened Vessel Creation PopUp");
		
		String vesselName=DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,0);
		
		if(!vesselName.equals("NoValue"))
		{
			vm.enterVesselName(vesselName);
			
			logger.log(LogStatus.INFO,"Entered vessel name");
		}
		
		String vslCat = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,1);
		
		if(!vslCat.equals("NoValue"))
		{
			vm.enterVesselCategory(vslCat);
		}
		
		String vslOpeName = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,2);
		
		if(!vslOpeName.equals("NoValue"))
		{
		
			vm.enterVslOperator(vslOpeName);
		
		}
		
		
		String vslsts = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,3);
		
		
		if(!vslsts.equals("NoValue"))
		{
			vm.selectVslStatus(vslsts);
		}
		
		
		int molCodeNo = DataProviderFactory.getExcel().getNumbervalue(excelPath,"VslCreate",1,4);
		
				
		String molCodeString = NumberToTextConverter.toText(molCodeNo);
		
		if(!molCodeString.equals("0"))
		{
			vm.enterMolCode(molCodeString);
		}
		
		
		int imoNo= DataProviderFactory.getExcel().getNumbervalue(excelPath,"VslCreate",1,5);
		
		String imoNoString = NumberToTextConverter.toText(imoNo);	
		
		if(!imoNoString.equals("0"))
		{
			vm.enterImoNumber(imoNoString);
		}
		
		
		int intCallSign= DataProviderFactory.getExcel().getNumbervalue(excelPath,"VslCreate",1,6);
		
		String CallSignString = NumberToTextConverter.toText(intCallSign);	
		
		if(!CallSignString.equals("0"))
		{
			vm.entercallSign(CallSignString);
		}
		
		
		String ctryFlg = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,7);
		
		if(!ctryFlg.equals("NoValue"))
			
		{
			vm.enterCountryFlag(ctryFlg);
		}
		
		
		int intStndTC= DataProviderFactory.getExcel().getNumbervalue(excelPath,"VslCreate",1,8);
		
		String stndTCString = NumberToTextConverter.toText(intStndTC);
		
		if(!stndTCString.equals("0"))
		{
			vm.enterStndTCHire(stndTCString);
		}
		
		
		String date = DataProviderFactory.getExcel().getvalueDate(excelPath,"VslCreate",1,9);
		if(!date.equals("NoDate"))
		{
			vm.enterExpiryDate(date);
		}
		
		
		
		double intBeam= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,10);
		
		String beamString = NumberToTextConverter.toText(intBeam);
		
		if(!beamString.equals("0"))
		{
			vm.enterBeam(beamString);
		}
		
		double intLpp= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,11);
		
		String lppString = NumberToTextConverter.toText(intLpp);
		
		if(!lppString.equals("0"))
		{
			vm.enterLpp(lppString);
		
		}
		
		double intLoa= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,12);
		
		String loaString = NumberToTextConverter.toText(intLoa);
		
		if(!loaString.equals("0"))
		{
			vm.enterloa(loaString);
		
		}
		
		
		double intdagt= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,13);
		
		String dagtString = NumberToTextConverter.toText(intdagt);
		
		if(!dagtString.equals("0"))
		{
			vm.enterDraught(dagtString);
		
		}
		
		double intdeadWeight= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,14);
		
		String deadWeightString = NumberToTextConverter.toText(intdeadWeight);
		
		if(!deadWeightString.equals("0"))
		{
			vm.enterdeadWeight(deadWeightString);
		
		}
		
		
		vm.clickvesselCapacityExpand();
		
		
		double dobhigtFrom= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,15);
		
		String higtFromString = NumberToTextConverter.toText(dobhigtFrom);
		
		if(!higtFromString.equals("0"))
		{
			vm.entercarDeckHeightFrom(higtFromString);
		
		}
		
		double dobhigtTo= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,16);
		
		String dobhigtToString = NumberToTextConverter.toText(dobhigtTo);
		
		if(!dobhigtToString.equals("0"))
		{
			vm.entercarDeckHeightTo(dobhigtToString);
		
		}
		
		double dobcarDeckM2= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,17);
		
		String carDeckM2String = NumberToTextConverter.toText(dobcarDeckM2);
		
		if(!carDeckM2String.equals("0"))
		{
			vm.entercarDeckM2(carDeckM2String);
		
		}
		
		double dobcarDeckM3= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,18);
		
		String carDeckM3String = NumberToTextConverter.toText(dobcarDeckM3);
		
		if(!carDeckM3String.equals("0"))
		{
			vm.entercarDeckM3(carDeckM3String);
		
		}
		
		
		double dobHSVDeckHeightFrom= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,19);
		
		String HSVDeckHeightFromString = NumberToTextConverter.toText(dobHSVDeckHeightFrom);
		
		if(!HSVDeckHeightFromString.equals("0"))
		{
			vm.enterHSVDeckHeightFrom(HSVDeckHeightFromString);
		
		}
		
		double dobHSVDeckHeightTo= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,20);
		
		String dobHSVDeckHeightToString = NumberToTextConverter.toText(dobHSVDeckHeightTo);
		
		if(!dobHSVDeckHeightToString.equals("0"))
		{
			vm.enterHSVDeckHeightTo(dobHSVDeckHeightToString);
		
		}
		
		double dobHSVDeckM2= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,21);
		
		String HSVDeckM2String = NumberToTextConverter.toText(dobHSVDeckM2);
		
		if(!HSVDeckM2String.equals("0"))
		{
			vm.enterHSVDeckM2(HSVDeckM2String);
		
		}
		
		double dobHSVDeckM3= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,22);
		
		String HSVDeckM3String = NumberToTextConverter.toText(dobHSVDeckM3);
		
		if(!HSVDeckM3String.equals("0"))
		{
			vm.enterHSVDeckM3(HSVDeckM3String);
		
		}
		
		double dobtruckDeckHeightFrom= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,23);
		
		String truckDeckHeightFromString = NumberToTextConverter.toText(dobtruckDeckHeightFrom);
		
		if(!truckDeckHeightFromString.equals("0"))
		{
			vm.entertruckDeckHeightFrom(truckDeckHeightFromString);
		
		}
		
		
		double dobtruckDeckHeightTo= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,24);
		
		String truckDeckHeightToString = NumberToTextConverter.toText(dobtruckDeckHeightTo);
		
		if(!truckDeckHeightToString.equals("0"))
		{
			vm.entertruckDeckHeightTo(truckDeckHeightToString);
		
		}
		
		
		double dobtruckDeckM2= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,25);
		
		String truckDeckM2String = NumberToTextConverter.toText(dobtruckDeckM2);
		
		if(!truckDeckM2String.equals("0"))
		{
			vm.entertruckDeckM2(truckDeckM2String);
		
		}
		
		double dobtruckDeckM3= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,26);
		
		String truckDeckM3String = NumberToTextConverter.toText(dobtruckDeckM3);
		
		if(!truckDeckM3String.equals("0"))
		{
			vm.entertruckDeckM3(truckDeckM3String);
		
		}
		
		double dobHHMainDeckHeightFrom= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,27);
		
		String HHMainDeckHeightFromString = NumberToTextConverter.toText(dobHHMainDeckHeightFrom);
		
		if(!HHMainDeckHeightFromString.equals("0"))
		{
			vm.enterHHMainDeckHeightFrom(HHMainDeckHeightFromString);
		
		}
		
		double dobHHMainDeckHeightTo= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,28);
		
		String HHMainDeckHeightToString = NumberToTextConverter.toText(dobHHMainDeckHeightTo);
		
		if(!HHMainDeckHeightToString.equals("0"))
		{
			vm.enterHHMainDeckHeightTo(HHMainDeckHeightToString);
		
		}
		
		double dobHHMainDeckM2= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,29);
		
		String HHMainDeckM2String = NumberToTextConverter.toText(dobHHMainDeckM2);
		
		if(!HHMainDeckM2String.equals("0"))
		{
			vm.enterHHMainDeckM2(HHMainDeckM2String);
		
		}
		
		double dobHHMainDeckM3= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,30);
		
		String HHMainDeckM3String = NumberToTextConverter.toText(dobHHMainDeckM3);
		
		if(!HHMainDeckM3String.equals("0"))
		{
			vm.enterHHMainDeckM3(HHMainDeckM3String);
		
		}
		
		
		double dobtotalHeightFrom= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,31);
		
		String totalHeightFromString = NumberToTextConverter.toText(dobtotalHeightFrom);
		
		if(!totalHeightFromString.equals("0"))
		{
			vm.enterTotalHeightFrom(totalHeightFromString);
		
		}
		
		double dobTotalHeightTo= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,32);
		
		String HeightFromStringString = NumberToTextConverter.toText(dobTotalHeightTo);
		
		if(!HeightFromStringString.equals("0"))
		{
			vm.enterTotalHeightTo(HeightFromStringString);
		
		}
		
		double dobenterTotalM2= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,33);
		
		String enterTotalM2String = NumberToTextConverter.toText(dobenterTotalM2);
		
		if(!enterTotalM2String.equals("0"))
		{
			vm.enterTotalM2(enterTotalM2String);
		
		}
		
		
		double dobEnterTotalM3= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,34);
		
		String enterTotalM3String = NumberToTextConverter.toText(dobEnterTotalM3);
		
		if(!enterTotalM3String.equals("0"))
		{
			vm.enterTotalM3(enterTotalM3String);
		
		}
		
		double dobCapacityRT= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,35);
		
		String CapacityRTString = NumberToTextConverter.toText(dobCapacityRT);
		
		if(!CapacityRTString.equals("0"))
		{
			vm.enterCapacityRT(CapacityRTString);
		
		}
		
		
		
		double dobSternRampCapacity= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,36);
		
		String SternRampCapacityString = NumberToTextConverter.toText(dobSternRampCapacity);
		
		if(!SternRampCapacityString.equals("0"))
		{
			vm.enterSternRampCapacity(SternRampCapacityString);
		
		}
		
		
		double dobCalculatePanelUPFromHeight= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,37);
		
		String calculatePanelUPFromHeightString = NumberToTextConverter.toText(dobCalculatePanelUPFromHeight);
		
		if(!calculatePanelUPFromHeightString.equals("0"))
		{
			vm.enterCalculatePanelUPFromHeight(calculatePanelUPFromHeightString);
		
		}
		
		double dobCalculatePanelUPMultiplier= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,38);
		
		String calculatePanelUPMultiplierString = NumberToTextConverter.toText(dobCalculatePanelUPMultiplier);
		
		if(!calculatePanelUPMultiplierString.equals("0"))
		{
			vm.enterCalculatePanelUPMultiplier(calculatePanelUPMultiplierString);
		
		}
		
		vm.clickVessselConExpand();
		
		
		String HFOSeaRunFlg = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,39);
		
		if(!HFOSeaRunFlg.equals("NoValue"))
			
		{
			vm.checkHfoConDfSeaRun(HFOSeaRunFlg);
		}
		
		String DfSECAFlg = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,40);
		
		if(!DfSECAFlg.equals("NoValue"))
			
		{
			vm.checkhfoConDfSECA(DfSECAFlg);
		}
		
		String driftingFlg = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,41);
		
		if(!driftingFlg.equals("NoValue"))
			
		{
			vm.checkhfoConDfDrifting(driftingFlg);
		}
		
		String DfPortFlg = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,42);
		
		if(!DfPortFlg.equals("NoValue"))
			
		{
			vm.checkhfoConDfPort(DfPortFlg);
		}
		
		
		double dobhfoConFull= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,43);
		
		String hfoConFullString = NumberToTextConverter.toText(dobhfoConFull);
		
		if(!hfoConFullString.equals("0"))
		{
			vm.enterhfoConFull(hfoConFullString);
		
		}
		
		double dobhfoConSs= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,44);
		
		String hfoConSsString = NumberToTextConverter.toText(dobhfoConSs);
		
		if(!hfoConSsString.equals("0"))
		{
			vm.enterhfoConSs(hfoConSsString);
		
		}
		
			
		double dobhfoConMss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,45);
		
		String hfoConMssString = NumberToTextConverter.toText(dobhfoConMss);
		
		if(!hfoConMssString.equals("0"))
		{
			vm.enterhfoConMss(hfoConMssString);
		
		}
		
		double dobhfoConSss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,46);
		
		String hfoConSssString = NumberToTextConverter.toText(dobhfoConSss);
		
		if(!hfoConSssString.equals("0"))
		{
			vm.enterhfoConSss(hfoConSssString);
		
		}
		
		
		double dobhfoConUss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,47);
		
		String hfoConUssString = NumberToTextConverter.toText(dobhfoConUss);
		
		if(!hfoConUssString.equals("0"))
		{
			vm.enterhfoConUss(hfoConUssString);
		
		}
		
		double dobhfoConPort= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,48);
		
		String hfoConPortString = NumberToTextConverter.toText(dobhfoConPort);
		
		if(!hfoConPortString.equals("0"))
		{
			vm.enterhfoConPort(hfoConPortString);
		
		}
		
		String mdoConDfSeaRun = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,49);
		
		if(!mdoConDfSeaRun.equals("NoValue"))
			
		{
			vm.checkmdoConDfSeaRun(DfPortFlg);
		}
		
		String mdoConDfSECA = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,50);
		
		if(!mdoConDfSECA.equals("NoValue"))
			
		{
			vm.checkmdoConDfSECA(DfPortFlg);
		}
		
		String mdoConDfDrifting = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,51);
		
		if(!mdoConDfDrifting.equals("NoValue"))
			
		{
			vm.checkmdoConDfDrifting(DfPortFlg);
		}
		
		String mdoConDfPort = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,52);
		
		if(!mdoConDfPort.equals("NoValue"))
			
		{
			vm.checkmdoConDfPort(DfPortFlg);
		}
		
		
		
		double dobMdoConFull= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,53);
		
		String MdoConFullString = NumberToTextConverter.toText(dobMdoConFull);
		
		if(!MdoConFullString.equals("0"))
		{
			vm.enterMdoConFull(MdoConFullString);
		
		}
		
		double dobMdoConSs= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,54);
		
		String MdoConSsString = NumberToTextConverter.toText(dobMdoConSs);
		
		if(!MdoConSsString.equals("0"))
		{
			vm.enterMdoConSs(MdoConSsString);
		
		}
		
		double dobMdoConMss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,55);
		
		String MdoConMssString = NumberToTextConverter.toText(dobMdoConMss);
		
		if(!MdoConMssString.equals("0"))
		{
			vm.enterMdoConMss(MdoConMssString);
		
		}	
		
		
		double dobMdoConSss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,56);
		
		String MdoConSssString = NumberToTextConverter.toText(dobMdoConSss);
		
		if(!MdoConSssString.equals("0"))
		{
			vm.enterMdoConSss(MdoConSssString);
		
		}	
		
		
		double dobMdoConUss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,57);
		
		String MdoConUssString = NumberToTextConverter.toText(dobMdoConUss);
		
		if(!MdoConUssString.equals("0"))
		{
			vm.enterMdoConUss(MdoConUssString);
		
		}	
		
		
		double dobMdoConPort= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,58);
		
		String MdoConPortString = NumberToTextConverter.toText(dobMdoConPort);
		
		if(!MdoConPortString.equals("0"))
		{
			vm.enterMdoConPort(MdoConPortString);
		
		}	
		
		
		String mgoConDfSeaRunString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,59);
		
		if(!mgoConDfSeaRunString.equals("NoValue"))
			
		{
			vm.checkMgoConDfSeaRun(mgoConDfSeaRunString);
		}
		
		
		String mgoConDfSECAString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,60);
		
		if(!mgoConDfSECAString.equals("NoValue"))
			
		{
			vm.checkMgoConDfSECA(mgoConDfSECAString);
		}
		
		String mgoConDfDriftingString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,61);
		
		if(!mgoConDfDriftingString.equals("NoValue"))
			
		{
			vm.checkMgoConDfDrifting(mgoConDfDriftingString);
		}
		
		String mgoConDfPortString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,62);
		
		if(!mgoConDfPortString.equals("NoValue"))
			
		{
			vm.checkMgoConDfPort(mgoConDfPortString);
		}
		
		
		double dobMgoConFull= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,63);
		
		String mgoConFullString = NumberToTextConverter.toText(dobMgoConFull);
		
		if(!mgoConFullString.equals("0"))
		{
			vm.enterMgoConFull(mgoConFullString);
		
		}	
		
		double dobMgoConSs= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,64);
		
		String mgoConSstring = NumberToTextConverter.toText(dobMgoConSs);
		
		if(!mgoConSstring.equals("0"))
		{
			vm.enterMgoConSs(mgoConSstring);
		
		}	
		
		double dobMgoConMss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,65);
		
		String mgoConMssstring = NumberToTextConverter.toText(dobMgoConMss);
		
		if(!mgoConMssstring.equals("0"))
		{
			vm.enterMgoConMss(mgoConMssstring);
		
		}	
		
		double dobMgoConSss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,66);
		
		String mgoConSssString = NumberToTextConverter.toText(dobMgoConSss);
		
		if(!mgoConSssString.equals("0"))
		{
			vm.enterMgoConSss(mgoConSssString);
		
		}	
		
		double dobMgoConUss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,67);
		
		String mgoConUssString = NumberToTextConverter.toText(dobMgoConUss);
		
		if(!mgoConUssString.equals("0"))
		{
			vm.enterMgoConUss(mgoConUssString);
		
		}	
		
		double dobMgoConPort= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,68);
		
		String mgoConPortString = NumberToTextConverter.toText(dobMgoConPort);
		
		if(!mgoConPortString.equals("0"))
		{
			vm.enterMgoConPort(mgoConPortString);
		
		}	
		
		double dobVesselSpeedFull= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,69);
		
		String vesselSpeedFullString = NumberToTextConverter.toText(dobVesselSpeedFull);
		
		if(!vesselSpeedFullString.equals("0"))
		{
			vm.enterVesselSpeedFull(vesselSpeedFullString);
		
		}	
		
		double dobVesselSpeedSs= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,70);
		
		String vesselSpeedSsString = NumberToTextConverter.toText(dobVesselSpeedSs);
		
		if(!vesselSpeedSsString.equals("0"))
		{
			vm.enterVesselSpeedSs(vesselSpeedSsString);
		
		}	
		
		double dobVesselSpeedMss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,71);
		
		String vesselSpeedMssString = NumberToTextConverter.toText(dobVesselSpeedMss);
		
		if(!vesselSpeedMssString.equals("0"))
		{
			vm.enterVesselSpeedMss(vesselSpeedMssString);
		
		}	
		
		double dobVesselSpeedSss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,72);
		
		String vesselSpeedSssString = NumberToTextConverter.toText(dobVesselSpeedSss);
		
		if(!vesselSpeedSssString.equals("0"))
		{
			vm.enterVesselSpeedSss(vesselSpeedSssString);
		
		}	
		
		
		double dobVesselSpeedUss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,73);
		
		String vesselSpeedUssString = NumberToTextConverter.toText(dobVesselSpeedUss);
		
		if(!vesselSpeedUssString.equals("0"))
		{
			vm.enterVesselSpeedUss(vesselSpeedUssString);
		
		}	
		
		
		
		String remarksString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,74);
		
		if(!remarksString.equals("NoValue"))
			
		{
			vm.enterRemarks(remarksString);
		}
		
		String lsfoConDfSeaRunString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,75);
		
		if(!lsfoConDfSeaRunString.equals("NoValue"))
			
		{
			vm.checkLsfoConDfSeaRun(lsfoConDfSeaRunString);
		}
		
		String lsfoConDfSECAString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,76);
		
		if(!lsfoConDfSECAString.equals("NoValue"))
			
		{
			vm.checkLsfoConDfSECA(lsfoConDfSECAString);
		}
		
		String lsfoConDfDriftingString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,77);
		
		if(!lsfoConDfDriftingString.equals("NoValue"))
			
		{
			vm.checkLsfoConDfDrifting(lsfoConDfDriftingString);
		}
		
		String lsfoConDfPortString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,78);
		
		if(!lsfoConDfPortString.equals("NoValue"))
			
		{
			vm.checkLsfoConDfPort(lsfoConDfPortString);
		}
		
		
		double doblsfoConFull= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,79);
		
		String lsfoConFullString = NumberToTextConverter.toText(doblsfoConFull);
		
		if(!lsfoConFullString.equals("0"))
		{
			vm.enterLsfoConFull(lsfoConFullString);
		
		}	
		
		double doblsfoConSs= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,80);
		
		String lsfoConSsString = NumberToTextConverter.toText(doblsfoConSs);
		
		if(!lsfoConSsString.equals("0"))
		{
			vm.enterLsfoConSs(lsfoConSsString);
		
		}	
		
		double doblsfoConMss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,81);
		
		String lsfoConMssString = NumberToTextConverter.toText(doblsfoConMss);
		
		if(!lsfoConMssString.equals("0"))
		{
			vm.enterLsfoConMss(lsfoConMssString);
		
		}	
		
		double doblsfoConSss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,82);
		
		String lsfoConSssString = NumberToTextConverter.toText(doblsfoConSss);
		
		if(!lsfoConSssString.equals("0"))
		{
			vm.enterLsfoConSss(lsfoConSssString);
		
		}	
		
		double doblsfoConUss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,83);
		
		String lsfoConUssString = NumberToTextConverter.toText(doblsfoConUss);
		
		if(!lsfoConUssString.equals("0"))
		{
			vm.enterLsfoConUss(lsfoConUssString);
		
		}	
		
		
		double doblsfoConPorts= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,84);
		
		String lsfoConPortsString = NumberToTextConverter.toText(doblsfoConPorts);
		
		if(!lsfoConPortsString.equals("0"))
		{
			vm.enterLsfoConPorts(lsfoConPortsString);
		
		}	
		
		String lsdoConDfSeaRunString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,85);
		
		if(!lsdoConDfSeaRunString.equals("NoValue"))
			
		{
			vm.checkLsfoConDfPort(lsdoConDfSeaRunString);
		}
		
		
		String lsdoConDfSECAString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,86);
		
		if(!lsdoConDfSECAString.equals("NoValue"))
			
		{
			vm.checkLsfoConDfPort(lsdoConDfSECAString);
		}
		
		String lsdoConDfDriftingString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,87);
		
		if(!lsdoConDfDriftingString.equals("NoValue"))
			
		{
			vm.checkLsfoConDfPort(lsdoConDfDriftingString);
		}
		
		
		String lsdoConDfPortString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,88);
		
		if(!lsdoConDfPortString.equals("NoValue"))
			
		{
			vm.checkLsfoConDfPort(lsdoConDfPortString);
		}
		
		
		double dobLsdoConFull= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,89);
		
		String lsdoConFullString = NumberToTextConverter.toText(dobLsdoConFull);
		
		if(!lsdoConFullString.equals("0"))
		{
			vm.enterLsdoConFull(lsdoConFullString);
		
		}	
		
		double dobLsdoConSs= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,90);
		
		String lsdoConSsString = NumberToTextConverter.toText(dobLsdoConSs);
		
		if(!lsdoConSsString.equals("0"))
		{
			vm.enterLsdoConSs(lsdoConSsString);
		
		}	
		
		double doblsdoConMss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,91);
		
		String lsdoConMssString = NumberToTextConverter.toText(doblsdoConMss);
		
		if(!lsdoConMssString.equals("0"))
		{
			vm.enterLsdoConMss(lsdoConMssString);
		
		}	
		
		double dobLsdoConSss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,92);
		
		String lsdoConSssString = NumberToTextConverter.toText(dobLsdoConSss);
		
		if(!lsdoConSssString.equals("0"))
		{
			vm.enterLsdoConSss(lsdoConSssString);
		
		}	
		
		
		double doblsdoConUss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,93);
		
		String lsdoConUssString = NumberToTextConverter.toText(doblsdoConUss);
		
		if(!lsdoConUssString.equals("0"))
		{
			vm.enterLsdoConUss(lsdoConUssString);
		
		}	
		
		double dobLsdoConPort= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,94);
		
		String lsdoConPortString = NumberToTextConverter.toText(dobLsdoConPort);
		
		if(!lsdoConPortString.equals("0"))
		{
			vm.enterLsdoConPort(lsdoConPortString);
		
		}	
		
		String lsgoConDfSeaRunString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,95);
		
		if(!lsgoConDfSeaRunString.equals("NoValue"))
			
		{
			vm.checkLsgoConDfSeaRun(lsgoConDfSeaRunString);
		}
		
		String lsgoConDfSECAString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,96);
		
		if(!lsgoConDfSECAString.equals("NoValue"))
			
		{
			vm.checkLsgoConDfSECA(lsgoConDfSECAString);
		}
		
		String lsgoConDfDriftingString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,97);
		
		if(!lsgoConDfDriftingString.equals("NoValue"))
			
		{
			vm.checkLsgoConDfDrifting(lsgoConDfDriftingString);
		}
		
		String lsgoConDfPortString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,98);
		
		if(!lsgoConDfPortString.equals("NoValue"))
			
		{
			vm.checkLsgoConDfPort(lsgoConDfPortString);
		}
		
		double dobLsgoConFull= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,99);
		
		String lsgoConFullString = NumberToTextConverter.toText(dobLsgoConFull);
		
		if(!lsgoConFullString.equals("0"))
		{
			vm.enterLsgoConFull(lsgoConFullString);
		
		}	
		
		double dobLsgoConSs= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,100);
		
		String lsgoConSsString = NumberToTextConverter.toText(dobLsgoConSs);
		
		if(!lsgoConSsString.equals("0"))
		{
			vm.enterLsgoConSs(lsgoConSsString);
		
		}	
		
		double dobLsgoConMss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,101);
		
		String lsgoConMssString = NumberToTextConverter.toText(dobLsgoConMss);
		
		if(!lsgoConMssString.equals("0"))
		{
			vm.enterLsgoConMss(lsgoConMssString);
		
		}	
		
		double dobLsgoConSss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,102);
		
		String lsgoConSssString = NumberToTextConverter.toText(dobLsgoConSss);
		
		if(!lsgoConSssString.equals("0"))
		{
			vm.enterLsgoConSss(lsgoConSssString);
		
		}	
		
		double dobLsgoConUss= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,103);
		
		String lsgoConUssString = NumberToTextConverter.toText(dobLsgoConUss);
		
		if(!lsgoConUssString.equals("0"))
		{
			vm.enterLsgoConUss(lsgoConUssString);
		
		}	
		
		double dobLsgoConPort= DataProviderFactory.getExcel().getdoublevalue(excelPath,"VslCreate",1,104);
		
		String lsgoConPortString = NumberToTextConverter.toText(dobLsgoConPort);
		
		if(!lsgoConPortString.equals("0"))
		{
			vm.enterLsgoConPort(lsgoConPortString);
		
		}
		
		String stadBunkFOString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,105);
		
		if(!stadBunkFOString.equals("NoValue"))
			
		{
			vm.enterStadBunkFO(stadBunkFOString);
		}
		
		String stadBunkDOString = DataProviderFactory.getExcel().getvalue(excelPath,"VslCreate",1,106);
		
		if(!stadBunkDOString.equals("NoValue"))
			
		{
			vm.enterStadBunkDO(stadBunkDOString);
		}
		
		
		vm.clickOnSaveButton();
		
		logger.log(LogStatus.INFO,"Clicked on Save Button");
		
		WebDriverWait waitVslCode = new WebDriverWait(driver,10);
		
		waitVslCode.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='txtVslCode']")));
		
		WebElement vslCode = driver.findElement(By.xpath("//span[@id='txtVslCode']"));
		
		/*
		String vesselCode = vslCode.getText();
		
		System.out.println("New Vessel Code "+vesselCode);
		
		if(!vesselCode.equals(null))
		  {
			System.out.println("New Vessel Code ck "+vesselCode);
						
		  } */
		
		String msg =vm.getMsg();
				
		System.out.println("Printing message "+msg);
		
		if(msg.contains("registered"))
		{
			logger.log(LogStatus.PASS,"Vessel created successfully" );
		}
		
		logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"Vessel has been created")));
		
		
		report.endTest(logger);
		
		report.flush();
		
	}
	

}
