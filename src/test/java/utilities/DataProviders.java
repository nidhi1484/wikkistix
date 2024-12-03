package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider (name = "addressDetail")
	public String[][] getAddressData() throws IOException{
		
		String path = ".\\testData\\address_data.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility (path);
		
		int totalRows = xlutil.getRowCount("Sheet1");
		int totalCols = xlutil.getCellCount("Sheet1", 1);
		
		String addressData[][] = new String[totalRows][totalCols];  
		
		for (int i=1; i<totalRows; i++) {
			
			for (int j=0; j<totalCols; j++) {
				
				addressData[i-1][j] = xlutil.getCellData("Sheet1", i, j); 
			}
		}
		return addressData;
		
	}
	
	@DataProvider (name = "loginDetail")
	public String[][] getLoginData() throws IOException{
		
		String path = ".\\testData\\address_data.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility (path);
		
		int totalRows = xlutil.getRowCount("Sheet2");
		int totalCols = xlutil.getCellCount("Sheet2", 1);
		
		String loginData[][] = new String[totalRows][totalCols];  
		
		for (int i=1; i<totalRows; i++) {
			
			for (int j=0; j<totalCols; j++) {
				
				loginData[i-1][j] = xlutil.getCellData("Sheet2", i, j); 
			}
		}
		return loginData;
		
	}

}
