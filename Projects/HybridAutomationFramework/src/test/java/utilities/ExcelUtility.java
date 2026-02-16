package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public FileInputStream fin;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path;
	
	public ExcelUtility(String path)
	{
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException
	{
		fin = new FileInputStream(path);
		workbook = new XSSFWorkbook(fin);
		sheet = workbook.getSheet(sheetName);
		int count = sheet.getLastRowNum();
		workbook.close();
		fin.close();
		return count;
	}
	
	public int getCellCount(String sheetName,int rowNumber) throws IOException
	{
		fin = new FileInputStream(path);
		workbook = new XSSFWorkbook(fin);
		sheet = workbook.getSheet(sheetName);
		int count = sheet.getRow(rowNumber).getLastCellNum();
		workbook.close();
		fin.close();
		return count;
	}
	
	public String getCellValue(String sheetName,int rowNumber,int cellNumber) throws IOException
	{
		fin = new FileInputStream(path);
		workbook = new XSSFWorkbook(fin);
		sheet = workbook.getSheet(sheetName);
		XSSFRow selectedRow = sheet.getRow(rowNumber);
		XSSFCell selectedCell = selectedRow.getCell(cellNumber);
		String data;
		try {
//			data = selectedCell.getStringCellValue();
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(selectedCell);
		}catch(Exception e){
			data = "";
		}
		workbook.close();
		fin.close();
		return data;
	}
	
	public void setCellValue(String sheetName,int rowNumber,int cellNumber,String data) throws IOException
	{
		fin = new FileInputStream(path);
		workbook = new XSSFWorkbook(fin);
		sheet = workbook.getSheet(sheetName);
		XSSFRow selectedRow = sheet.getRow(rowNumber);
		XSSFCell selectedCell = selectedRow.createCell(cellNumber);
		selectedCell.setCellValue(data);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fin.close();
		return ;
	}
}
