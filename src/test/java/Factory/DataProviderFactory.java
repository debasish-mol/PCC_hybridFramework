package Factory;

import DataProvider.ConfigdataProvider;
import DataProvider.ExcelDataProvider;

public class DataProviderFactory {
	
	public static ConfigdataProvider getConfig()
	{
		ConfigdataProvider config = new ConfigdataProvider();
		
		return config;
	}
	
	
	
	public static ExcelDataProvider getExcel()
	
	{
		ExcelDataProvider excel = new ExcelDataProvider();
		
		return excel;
		
		
	}
	

}
