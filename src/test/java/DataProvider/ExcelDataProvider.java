package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	FileInputStream fis;
	
	FileOutputStream fos;
	
	File file ;
	
	public ExcelDataProvider()
	{
		file = new File("D:\\all\\personal\\backup\\Selenium3\\SeleniumProgram\\com.Pcc.Net.Hybridframework\\ApplicationTestData\\AppData.xlsx");
		
		try {
			
			 fis = new FileInputStream(file);
			
			// fos = new FileOutputStream(file);
			
			 wb = new XSSFWorkbook(fis);
			 
			 //wbw= new XSSFWorkbook(fos);
			 
		    } catch (Exception e) {
			
			System.out.println("Exception is "+e.getMessage());		
			
		}
		
		
		
	}
	
	
	public String getData(int sheetIndex,int row,int col)
	{
		
		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(col).toString();
		
		return data;
		
	}
	
	
	public String getBookingNoString(String sheetName,int row,int col)
	
	{
		String bl_no = wb.getSheet(sheetName).getRow(row).getCell(col).toString();
		
		return bl_no;
	}
	
	public String getStringData(String sheetName,int row,int col)
	
	{
		String data = wb.getSheet(sheetName).getRow(row).getCell(col).toString();
		
		return data;
	}
	
		public String getDateData(String sheetName,int row,int col)
	
	{  			 XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(col);
		
					//String data = wb.getSheet(sheetName).getRow(row).getCell(col).toString();
			
			           	
                	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                	
                	//System.out.print(dateFormat.format(cell.getDateCellValue()));
                	
                	String data = dateFormat.format(cell.getDateCellValue());
                	
                	//System.out.print(date);
                	
                	//System.out.print(dateFormat.format(cell.getDateCellValue()) + "\t\t");
                	
                  //  System.out.print(cell.getDateCellValue());
                    
                    System.out.print("  ");
		
		return data;
	}
	
		public int getNumberData(String sheetName,int row,int col)
		
		{   XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(col);
			
				
		int number = (int)cell.getNumericCellValue();	           	
	                	
			return number;
		}
		
		
		public double getNumberDataDouble(String sheetName,int row,int col)
		
		{   XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(col);
			
				
		double number = (double)cell.getNumericCellValue();	           	
	                	
			return number;
		}
		
		
		
	public void WriteDataExcel(String sheetName,int row1,int col1,String data) throws IOException
	{
		
		
		//wb.getSheet("bldata").createRow(row1).createCell(col1).setCellValue(data);
		
		wb.getSheet("bldata").getRow(row1).createCell(col1).setCellValue(data);
		
		 fos = new FileOutputStream(file);
		 
		wb.write(fos);
		
		wb.close();
		
		fis.close();
		
		fos.close();
		
		
	}
	
	
	

}
