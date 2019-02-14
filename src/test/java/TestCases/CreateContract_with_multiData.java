package TestCases;

import java.io.*;
import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import AppPages.ContEntryPages;
import AppPages.ContractSearchScreen;
import AppPages.loginPages;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Utility.Helper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class CreateContract_with_multiData 
{
	public WebDriver driver;

	ExtentReports report;
	
	ExtentTest logger;
	

	loginPages home;
	ContractSearchScreen contSearch;
	
	//@BeforeMethod
	public void setup() 
	{
		report = new ExtentReports(".//Reports/CreateContract_with_multiData.html",true);
		
		logger= report.startTest("Create Contract with multiple Data");
		
		BrowserFactory br = new BrowserFactory();
		
        driver = br.getBrowser();        
        
		String url = "contUrl";
		
		driver.get(DataProviderFactory.getConfig().getUrl(url));	
				
		//Thread.sleep(4000);
		
		home = PageFactory.initElements(driver, loginPages.class);
		
		home.loginInfo();	
	}
	
	@Test
	public void multiRowEntry() throws IOException
	{
	
	String filePath = "D:\\Selenium_Framework\\PCC_hybridFramework\\ApplicationTestData";
	String fileName = "Contact_Entry_Data.xlsx";
	String mainSheetName = "Run_Manager";
	String contNo = null, xlsContStatus = null;
	String xlsContType = null, xlsContName = null, stringXlsMainCustCode = null, xlsSalesPersonLoginID = null;
	String  xlsAffCustCode1 = null,xlsAffCustCode2 = null, xlsAffCustCode3 = null, xlsAffCustCode4 = null;
	String xlsSalesOfcCode = null, xlsDocIssueOfcCodeHdr= null, xlsContEffFromHdr = null, xlsContEffToHdr = null;
	String xlsRmks = null, xlsBkgRmks = null, xlsFrghtRmks = null;
	String xlsFrmPortCode = null, xlsToPortCode = null, xlsPlaceOfReceiptCode = null, xlsPlaceOfDeliveryCode = null;
	String xlsPlaceOfReceiptName = null, xlsPlaceOfDeliveryName = null;
	String xlsTsh1 = null, xlsTsh2 = null, xlsTsh3 = null;
	String xlsJapFrgtTrmntCode = null, xlsSRGContNo = null, stringXlsGGNRatio = null, xlsTerms = null;
	String xlsFDPS = null, xlsDocIssueOfcCodeDtl = null;
	String xlsMakeName = null, xlsModelCode = null, xlsModelName = null, stringXlsIndicativeQntityUnits = null;
	String xlsCharges = null, xlsBasisCode = null, stringXlsRate = null, xlsCurrency = null, xlsPreCol = null;
	String xlsFrgtCollOfcCode = null, xlsInvoiceOfcCode = null, stringXlsPayerCode = null;
	String xlsRevenueEffectiveFromDtl = null, xlsRevenueEffectiveToDtl = null; 
	int xlsMainCustCode = 0, xlsIndicativeQntityUnits = 0;
	double xlsGGNRatio = 0;
	
		
	File file = new File(filePath+"\\"+fileName);
	FileInputStream inputStream = new FileInputStream(file);
	
	Workbook myWorkbook =null;
	
	String fileExtensionName = fileName.substring(fileName.indexOf("."));
		
		if(fileExtensionName.equals(".xlsx"))
		{
			myWorkbook = new XSSFWorkbook(inputStream);
		}

	    else if(fileExtensionName.equals(".xls"))
	    {
	    	myWorkbook = new HSSFWorkbook(inputStream);
		}
		
		Sheet runManager = myWorkbook.getSheet(mainSheetName);
				
		int iteration = (int) runManager.getRow(1).getCell(1).getNumericCellValue();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		for (int tabIteration = 1; tabIteration < iteration+1; tabIteration ++)
		{
			setup();
			ContEntryPages Contpg = PageFactory.initElements(driver,ContEntryPages.class);
			
			contSearch = PageFactory.initElements(driver, ContractSearchScreen.class);
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
			
			String tabtName = "Iteration"+ tabIteration;
			Sheet mySheet = myWorkbook.getSheet(tabtName);
			int rowCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();
			
			for(int i = 1;i<rowCount+1;i++)
			{
				if(i == 1)
				{
					logger.log(LogStatus.INFO,"Entering all records of first row");
					xlsContType = mySheet.getRow(1).getCell(0).getStringCellValue().trim();
					if(xlsContType != "")
					{
						try 
						{
							Contpg.contractType(xlsContType);
						} 
						catch (InterruptedException eContType) 
						{
							eContType.printStackTrace();
						}
					}
								
					xlsContName = mySheet.getRow(1).getCell(3).getStringCellValue().trim();
					if(xlsContName!="")
					{
						Contpg.enterContractName(xlsContName);
					}
				
					stringXlsMainCustCode = mySheet.getRow(1).getCell(4).getStringCellValue().trim();
					xlsMainCustCode = Integer.parseInt(stringXlsMainCustCode);
					if(!xlsContType.equalsIgnoreCase("Spot Rate Guidelines"))
					{
						if(xlsMainCustCode!=0)
						{
							Contpg.enterMainCustomer(xlsMainCustCode);
						}
					}
						
				
					xlsSalesPersonLoginID = mySheet.getRow(1).getCell(8).getStringCellValue().trim();
					if(xlsSalesPersonLoginID!="")
					{
						Contpg.enterSalesPerson(xlsSalesPersonLoginID);
					}
				
					xlsSalesOfcCode = mySheet.getRow(1).getCell(9).getStringCellValue().trim();
					
				
					xlsDocIssueOfcCodeHdr = mySheet.getRow(1).getCell(11).getStringCellValue().trim();
					if(xlsDocIssueOfcCodeHdr!="")
					{
						try 
						{
							Contpg.enterDocIssueOfcCode(xlsDocIssueOfcCodeHdr);
						} 
						catch (InterruptedException eDocIssueOfcCodeHdr) 
						{
							eDocIssueOfcCodeHdr.printStackTrace();
						}
					}
				
					xlsContEffFromHdr = dateFormat.format(mySheet.getRow(1).getCell(13).getDateCellValue()).trim();
					if(xlsContEffFromHdr!= "")
					{
						Contpg.enterEffectivedate(xlsContEffFromHdr);
					}
				
					xlsContEffToHdr = dateFormat.format(mySheet.getRow(1).getCell(14).getDateCellValue()).trim();
					if(xlsContEffToHdr!= "")
					{
						Contpg.enterExpiryDate(xlsContEffToHdr);
					}
				
					xlsRmks = mySheet.getRow(1).getCell(15).getStringCellValue().trim();
					if(xlsRmks!= "")
					{
						Contpg.enterRemarks(xlsRmks);
					}
				
					xlsBkgRmks = mySheet.getRow(1).getCell(16).getStringCellValue().trim();
					if(xlsBkgRmks!="")
					{
						Contpg.enterBKGRemarks(xlsBkgRmks);
					}
				
					xlsFrghtRmks = mySheet.getRow(1).getCell(17).getStringCellValue().trim();
					if(xlsFrghtRmks!="")
					{
						Contpg.enterFrgtRemarks(xlsFrghtRmks);
					}
						
					xlsAffCustCode1 = mySheet.getRow(1).getCell(18).getStringCellValue().trim();
					if(!xlsContType.equalsIgnoreCase("Spot Rate Guidelines"))
					{
						if(xlsAffCustCode1 !="")
						{
							Contpg.clickOnAddAffiliates();
							Contpg.enterAffiliatedCustomer(xlsAffCustCode1);
						}
					}
						
					
					xlsAffCustCode2 = mySheet.getRow(1).getCell(20).getStringCellValue().trim();
					if(!xlsContType.equalsIgnoreCase("Spot Rate Guidelines"))
					{
						if(xlsAffCustCode2 !="")
						{
							Contpg.clickOnAddAffiliates();
							Contpg.enterAffiliatedCustomer(xlsAffCustCode2);
						}
					}
						
					
					xlsAffCustCode3 = mySheet.getRow(1).getCell(22).getStringCellValue().trim();
					if(!xlsContType.equalsIgnoreCase("Spot Rate Guidelines"))
					{
						if(xlsAffCustCode3 !="")
						{
							Contpg.clickOnAddAffiliates();
							Contpg.enterAffiliatedCustomer(xlsAffCustCode3);
						}
					}
						
					
					xlsAffCustCode4 = mySheet.getRow(1).getCell(24).getStringCellValue().trim();
					if(!xlsContType.equalsIgnoreCase("Spot Rate Guidelines"))
					{
						if(xlsAffCustCode4 !="")
						{
							Contpg.clickOnAddAffiliates();
							Contpg.enterAffiliatedCustomer(xlsAffCustCode4);
						}
					}
						
				
					//saving value of header section
					Contpg.clickOnHdrSave();
					try 
					{
						Thread.sleep(5000);
					}
					catch (InterruptedException eHDRSave) 
					{
						eHDRSave.printStackTrace();
					}
					
					contNo = Contpg.getContNo();
					//System.out.println(contNo);
					Cell cell = null;
					cell = mySheet.getRow(1).getCell(1);
					cell.setCellValue(contNo);  
					String file_Path = filePath+"\\"+fileName;
					FileOutputStream output_file =new FileOutputStream(new File(file_Path));
					myWorkbook.write(output_file);
					output_file.close();
				
					xlsFrmPortCode = mySheet.getRow(1).getCell(27).getStringCellValue().trim();
					if(xlsFrmPortCode!="")
					{
						try {
							Contpg.enterContLoadPort(xlsFrmPortCode);
						}
						catch (InterruptedException eFromPort) 
						{
								eFromPort.printStackTrace();
						}
					}
						
					xlsToPortCode = mySheet.getRow(1).getCell(30).getStringCellValue().trim();
					if(xlsToPortCode!="")
					{
						try 
						{
							Contpg.enterContDisPort(xlsToPortCode);
						}
						catch (InterruptedException eToPort) 
						{
								eToPort.printStackTrace();
						}
					}
				
					xlsPlaceOfReceiptCode = mySheet.getRow(1).getCell(32).getStringCellValue().trim();
					if(xlsPlaceOfReceiptCode!="")
					{
						try 
						{
							Contpg.enterPlaceOfReceiptCode(xlsPlaceOfReceiptCode);
						}
						catch (InterruptedException ePRCode) 
						{
							ePRCode.printStackTrace();
						}
					}
				
					xlsPlaceOfDeliveryCode = mySheet.getRow(1).getCell(34).getStringCellValue().trim();
					if(xlsPlaceOfDeliveryCode!="")
					{
						try 
						{
							Contpg.enterPlaceOfDeliveryCode(xlsPlaceOfDeliveryCode);
						}
						catch (InterruptedException ePDCode) 
						{
							ePDCode.printStackTrace();
						}
					}
				
					xlsTsh1 = mySheet.getRow(1).getCell(36).getStringCellValue().trim();
					if(xlsTsh1!="")
					{
						Contpg.enterTSH1(xlsTsh1);
					}
				
					xlsTsh2 = mySheet.getRow(1).getCell(37).getStringCellValue().trim();
					if(xlsTsh2!="")
					{
						Contpg.enterTSH2(xlsTsh2);
					}
				
					xlsTsh3 = mySheet.getRow(1).getCell(38).getStringCellValue().trim();
					if(xlsTsh3!=""){
						Contpg.enterTSH3(xlsTsh3);
					}
					
						
					if(!xlsContType.equalsIgnoreCase("Spot Rate Guidelines"))
					{
						xlsJapFrgtTrmntCode = mySheet.getRow(1).getCell(39).getStringCellValue().toUpperCase().trim();
						if(xlsJapFrgtTrmntCode!="")
						{
							if(xlsJapFrgtTrmntCode.compareTo("YES") == 0)
							{
								Contpg.checkJapFrgtTrmntCodeFlag();
								
								xlsSRGContNo = mySheet.getRow(1).getCell(40).getStringCellValue().trim();
								if(xlsSRGContNo!="")
								{
									Contpg.enterSRGContNo(xlsSRGContNo);
								}
						
								xlsGGNRatio = mySheet.getRow(1).getCell(41).getNumericCellValue();
								stringXlsGGNRatio = String.valueOf(xlsGGNRatio).trim();
								if(stringXlsGGNRatio!="")
								{
									Contpg.enterGGNRatio(stringXlsGGNRatio);
								}
							}
						}
					}
					
					xlsTerms = mySheet.getRow(1).getCell(42).getStringCellValue().trim();
					if(xlsTerms!="")
					{
						try 
						{
							Contpg.selectTerms(xlsTerms);
						}
						catch (InterruptedException eTerms) 
						{
							eTerms.printStackTrace();
						}
					}
				
					xlsFDPS = mySheet.getRow(1).getCell(43).getStringCellValue().trim();
					if(xlsFDPS!="")
					{
						try
						{
							Contpg.enterFDPS(xlsFDPS);
						} 
						catch (InterruptedException eFDPS) 
						{
							eFDPS.printStackTrace();
						}
					}
								
					xlsDocIssueOfcCodeDtl = mySheet.getRow(1).getCell(44).getStringCellValue().trim();
					if(xlsDocIssueOfcCodeDtl!="")
					{
						try 
						{
							Contpg.enterDocIssueOfcCode(xlsDocIssueOfcCodeDtl);
						} 
						catch (InterruptedException eDocIssueOfcCodeDtl) 
						{
							eDocIssueOfcCodeDtl.printStackTrace();
						}
					}
				
					//saving value of LP-DP combination
					Contpg.clickOnContADDLpDpSave();
				
					xlsModelCode = mySheet.getRow(1).getCell(49).getStringCellValue().trim();
					if(xlsModelCode!="")
					{
						try 
						{
							Contpg.enterContModelName(xlsModelCode);
						}
						catch (InterruptedException eModelCode) 
						{
							eModelCode.printStackTrace();
						}
					}
				
					xlsIndicativeQntityUnits = (int)mySheet.getRow(1).getCell(51).getNumericCellValue();
					stringXlsIndicativeQntityUnits = String.valueOf(xlsIndicativeQntityUnits).trim();
					if(stringXlsIndicativeQntityUnits!="")
					{
						Contpg.enterIndicativeQntityUnits(stringXlsIndicativeQntityUnits);
					}
				
					//opening revenue pop-up
					Contpg.clickOnAddAndModifyRevenue();
				
					xlsCharges = mySheet.getRow(1).getCell(52).getStringCellValue().trim();
					if(xlsCharges!="")
					{
						try 
						{
							Contpg.enterCharges(xlsCharges);
						} 
						catch (InterruptedException eCharges) 
						{
							eCharges.printStackTrace();
						}
					}
				
					xlsBasisCode = mySheet.getRow(1).getCell(53).getStringCellValue().trim();
					if(xlsBasisCode!="")
					{
						Contpg.enterBasisCode(xlsBasisCode);
					}
				
					stringXlsRate = mySheet.getRow(1).getCell(55).getStringCellValue().trim();
					if(stringXlsRate!="")
					{
						Contpg.enterRate(stringXlsRate);
					}
						
					xlsCurrency = mySheet.getRow(1).getCell(56).getStringCellValue().trim();
					if(xlsCurrency!="")
					{
						Contpg.enterCurrency(xlsCurrency);
					}
				
					xlsPreCol = mySheet.getRow(1).getCell(57).getStringCellValue().trim();
					if(xlsPreCol!="")
					{
						Contpg.enterPreCol(xlsPreCol);
					}
				
					xlsFrgtCollOfcCode = mySheet.getRow(1).getCell(58).getStringCellValue().trim();
					if(xlsFrgtCollOfcCode!="")
					{
						Contpg.enterFrgtCollOfcCode(xlsFrgtCollOfcCode);
					}
				
					xlsInvoiceOfcCode = mySheet.getRow(1).getCell(60).getStringCellValue().trim();
					if(xlsInvoiceOfcCode!="")
					{
						Contpg.enterInvOfcCode(xlsInvoiceOfcCode);
					}
				
					stringXlsPayerCode = mySheet.getRow(1).getCell(62).getStringCellValue().trim();
					if(!xlsContType.equalsIgnoreCase("Spot Rate Guidelines"))
					{
						if(stringXlsPayerCode!="")
						{
							Contpg.enterPayer(stringXlsPayerCode);
						}
					}
						
				
					xlsRevenueEffectiveFromDtl = dateFormat.format(mySheet.getRow(1).getCell(64).getDateCellValue());
					if(xlsRevenueEffectiveFromDtl!="")
					{
						Contpg.enterRevenueEffectiveFrom(xlsRevenueEffectiveFromDtl);
					}
						
					xlsRevenueEffectiveToDtl = dateFormat.format(mySheet.getRow(1).getCell(65).getDateCellValue());
					if(xlsRevenueEffectiveToDtl!="")
					{
						Contpg.enterRevenueEffectiveTo(xlsRevenueEffectiveToDtl);
					}
						
					Contpg.clickRevenueSave();
				
					Contpg.clickRevenuePopupClose();
				
					Contpg.conCragoSaveButton();
					
					try 
					{
						Thread.sleep(5000);
					} 
					catch (InterruptedException eContOpen) 
					{
						eContOpen.printStackTrace();
					}
					
					if(rowCount > 1)
					{
						contSearch.waitForScreenLoad();
						
						contSearch.enterContactNumber(contNo);
						
						contSearch.clickOnSearch();
						
						contSearch.clickOnEditContact();
						
						try 
						{
							Thread.sleep(2000);
						} 
						catch (InterruptedException eUpdtCont) 
						{
							eUpdtCont.printStackTrace();
						}
						
						Set<String> allWinControls = driver.getWindowHandles();
						
						for(String s: allWinControls )
						{
							driver.switchTo().window(s);
							
							driver.manage().window().maximize();
							
							if(Contpg.getPageHeader().contains("Update Contract"))
							{
								break;
							}
						}
					}
					
					if(i == rowCount)
					{
						logger.log(LogStatus.INFO,"All records are successfully inserted for first row");
						xlsContStatus = mySheet.getRow(1).getCell(6).getStringCellValue().trim();
						
						if(xlsContStatus.equalsIgnoreCase("Complete"))
						{
							contSearch.waitForScreenLoad();
							
							contSearch.enterContactNumber(contNo);
							
							contSearch.clickOnSearch();
							
							contSearch.clickOnEditContact();
							
							try 
							{
								Thread.sleep(2000);
							} 
							catch (InterruptedException eUpdtCont) 
							{
								eUpdtCont.printStackTrace();
							}
							
							Set<String> allWinControls = driver.getWindowHandles();
							
							for(String s: allWinControls )
							{
								driver.switchTo().window(s);
								
								driver.manage().window().maximize();
								
								if(Contpg.getPageHeader().contains("Update Contract"))
								{
									break;
								}
							}
							
							Contpg.selectContactStatus();
							Contpg.clickOnHdrSave();
							try 
							{
								Thread.sleep(5000);
							}
							catch (InterruptedException eHDRSave) 
							{
								eHDRSave.printStackTrace();
							}
							logger.log(LogStatus.INFO,"Contract is saved with Completed status");
							report.endTest(logger);
							report.flush();
							driver.quit();
						}
						else
						{
							logger.log(LogStatus.INFO,"Contract is saved with Draft status");
							report.endTest(logger);
							report.flush();
							driver.quit();
						}
					}
					
				}
				else
				{
					xlsContStatus = mySheet.getRow(1).getCell(6).getStringCellValue().trim();
					xlsContType = mySheet.getRow(1).getCell(0).getStringCellValue().trim();
					xlsFrmPortCode = mySheet.getRow(i).getCell(27).getStringCellValue().trim();
					xlsToPortCode = mySheet.getRow(i).getCell(30).getStringCellValue().trim();
					xlsPlaceOfReceiptCode = mySheet.getRow(i).getCell(32).getStringCellValue().trim();
					xlsPlaceOfReceiptName = mySheet.getRow(i).getCell(33).getStringCellValue().trim();
					xlsPlaceOfDeliveryCode = mySheet.getRow(i).getCell(34).getStringCellValue().trim();
					xlsPlaceOfDeliveryName = mySheet.getRow(i).getCell(35).getStringCellValue().trim();
					xlsTsh1 = mySheet.getRow(i).getCell(36).getStringCellValue().trim();
					xlsTsh2 = mySheet.getRow(i).getCell(37).getStringCellValue().trim();
					xlsTsh3 = mySheet.getRow(i).getCell(38).getStringCellValue().trim();
					xlsJapFrgtTrmntCode = mySheet.getRow(i).getCell(39).getStringCellValue().toUpperCase().trim();
					xlsSRGContNo = mySheet.getRow(i).getCell(40).getStringCellValue().trim();
					xlsGGNRatio = mySheet.getRow(i).getCell(41).getNumericCellValue();
					stringXlsGGNRatio = String.valueOf(xlsGGNRatio).trim();
					xlsTerms = mySheet.getRow(i).getCell(42).getStringCellValue().trim();
					xlsFDPS = mySheet.getRow(i).getCell(43).getStringCellValue().trim();
					xlsDocIssueOfcCodeDtl = mySheet.getRow(i).getCell(44).getStringCellValue().trim();
					xlsMakeName = mySheet.getRow(i).getCell(48).getStringCellValue().trim();
					xlsModelCode = mySheet.getRow(i).getCell(49).getStringCellValue().trim();
					xlsModelName = mySheet.getRow(i).getCell(50).getStringCellValue().trim();
					xlsIndicativeQntityUnits = (int)mySheet.getRow(i).getCell(51).getNumericCellValue();
					stringXlsIndicativeQntityUnits = String.valueOf(xlsIndicativeQntityUnits).trim(); 
					xlsCharges = mySheet.getRow(i).getCell(52).getStringCellValue().trim();
					xlsBasisCode = mySheet.getRow(i).getCell(53).getStringCellValue().trim();
					stringXlsRate = mySheet.getRow(i).getCell(55).getStringCellValue().trim();
					xlsCurrency = mySheet.getRow(i).getCell(56).getStringCellValue().trim();
					xlsPreCol = mySheet.getRow(i).getCell(57).getStringCellValue().trim();
					xlsFrgtCollOfcCode = mySheet.getRow(i).getCell(58).getStringCellValue().trim();
					xlsInvoiceOfcCode = mySheet.getRow(i).getCell(60).getStringCellValue().trim();
					stringXlsPayerCode = mySheet.getRow(i).getCell(62).getStringCellValue().trim();
					xlsRevenueEffectiveFromDtl = dateFormat.format(mySheet.getRow(i).getCell(64).getDateCellValue());
					xlsRevenueEffectiveToDtl = dateFormat.format(mySheet.getRow(i).getCell(65).getDateCellValue());
					
					String log = "Entering records for row number "+i;
					logger.log(LogStatus.INFO,log);
					
					log = Contpg.AddMultiRecordsinEditMode(tabtName,i,xlsContType,xlsFrmPortCode,xlsToPortCode,xlsPlaceOfReceiptCode,xlsPlaceOfReceiptName,xlsPlaceOfDeliveryName,
							xlsPlaceOfDeliveryCode,xlsTsh1,xlsTsh2,xlsTsh3,xlsJapFrgtTrmntCode,xlsSRGContNo,stringXlsGGNRatio,xlsTerms,
							xlsFDPS,xlsDocIssueOfcCodeDtl,xlsMakeName,xlsModelCode,xlsModelName,stringXlsIndicativeQntityUnits,xlsCharges,xlsBasisCode,stringXlsRate,xlsCurrency,
							xlsPreCol,xlsFrgtCollOfcCode,xlsInvoiceOfcCode,stringXlsPayerCode,xlsRevenueEffectiveFromDtl,xlsRevenueEffectiveToDtl);
					
					if(log.contains("Duplicate LP-DP combination present in"))
					{
						logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"Error Message")));
						logger.log(LogStatus.INFO,log);
						Contpg.removeErrormsg();
					}
					else
					{
						logger.log(LogStatus.INFO,log);
					}
						
										
					if(i == rowCount)
					{
						if(xlsContStatus.equalsIgnoreCase("Complete"))
						{
							Contpg.clickonHeader();
							Contpg.selectContactStatus();
							Contpg.clickOnHdrSave();
							try 
							{
								Thread.sleep(5000);
							}
							catch (InterruptedException eHDRSave) 
							{
								eHDRSave.printStackTrace();
							}
							logger.log(LogStatus.INFO,"Contract is saved with Completed status");
							report.endTest(logger);
							report.flush();
							driver.quit();
						}
						else
						{
							logger.log(LogStatus.INFO,"Contract is saved with Draft status");
							report.endTest(logger);
							report.flush();
							driver.quit();
						}
					}
					
				}
			}
		}
	}
}
	
