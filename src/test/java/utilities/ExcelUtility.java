package utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public File fl;
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFRow row ;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public ExcelUtility(String path) {
		
		this.path = path;
	}
	
	public int getRowCount(String xlsheet) throws IOException {
		
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		
		return rowCount;
	}
	
	public int getCellCount(String xlsheet, int rowNum) throws IOException {
		
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		
		return cellCount;
	}
	
public String getCellData(String xlsheet, int rowNum, int column) throws IOException{
		
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(column);
		
		String data;
		try {
			
			//data = cell.toString();
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);		// returns the value of the cell in String format
		}
		catch(Exception e) {
			
			data = "";
		}
		wb.close();
		fi.close();
		
		return data;
		
	}
	
public void setCellData(String xlsheet, int rowNum, int column, String data) throws IOException {
	
	fl = new File(path);
	if(!fl.exists()) {
		
		wb = new XSSFWorkbook();
		fo = new FileOutputStream(path);
		wb.write(fo);
	}
	
	fi = new FileInputStream(path);
	wb = new XSSFWorkbook(fi);
	
	if(wb.getSheetIndex(xlsheet)==-1) //if sheet does not exists, then create sheet
	{		
		wb.createSheet(xlsheet);
		ws = wb.getSheet(xlsheet);
	}
	
	if(ws.getRow(rowNum)==null) {
		
		ws.createRow(rowNum);
		row = ws.getRow(rowNum);
	}
		
	cell = row.createCell(column);
	cell.setCellValue(data);
	
	fo = new FileOutputStream(path);
	wb.write(fo);
	
	wb.close();
	fi.close();
	fo.close();
	
	}

}
