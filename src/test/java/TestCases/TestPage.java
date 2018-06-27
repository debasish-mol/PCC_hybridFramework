package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import AppPages.loginPages;
import DataProvider.ExcelDataProvider;
import Factory.DataProviderFactory;

public class TestPage {
	
	

	public static void main(String[] args) throws IOException {
		
		
		//double data = DataProviderFactory.getExcel().getNumberData("bldata",0,1);
		
		//double data = DataProviderFactory.getExcel().getNumberDataDouble("bldata",0,1);
		
		//String str = NumberToTextConverter.toText(cell.getNumericCellValue())
		
		String data = NumberToTextConverter.toText(DataProviderFactory.getExcel().getNumberDataDouble("bldata",0,1));
		
		System.out.println("Data is "+data);
		
		/*loginPages home;
		
		System.setProperty("webdriver.chrome.driver","D:\\all\\personal\\backup\\Selenium3\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://sqa-web.molace-pcc.net/Contract/CreateUpdate/Home/Index?currentAgentId=1038");
		
		home = PageFactory.initElements(driver, loginPages.class);
		
		home.loginInfo();
		
		String title=driver.getTitle();
		
		System.out.println("Page title is "+title);
		
		*/
		/*
		ExcelDataProvider ex = new ExcelDataProvider();
		
		String data = ex.getBookingNoString("bldata",0,0);
		
		System.out.println("Reading Data"+data);
		
		try {
			ex.WriteDataExcel("bldata",6,5,"Bidisha");
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
			
			System.out.println(e.getMessage());
			
			
		}
		System.out.println("Written");
		
		*/
  
		/*
		File file = new File("D:\\all\\personal\\backup\\Selenium3\\SeleniumProgram\\com.Pcc.Net.Hybridframework\\ApplicationTestData\\AppData.xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		String data = wb.getSheet("bldata").getRow(0).getCell(0).toString();
		
		System.out.println("Data "+data);
		
		wb.getSheet("bldata").getRow(0).createCell(2).setCellValue("Debasish");
		
		wb.getSheet("bldata").createRow(2).createCell(2).setCellValue("Debasish");
		
		FileOutputStream fos = new FileOutputStream(file);
		
		wb.write(fos);
		
	wb.close();
	
	fis.close();
	
	fos.close();
		
		*/
		
	}

}
