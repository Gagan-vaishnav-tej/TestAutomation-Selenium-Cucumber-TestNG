package workingWithExcelFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static FileInputStream fin;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static XSSFCellStyle style;
	
	public static int getRowCount(String filepath,String sheetName) throws IOException
	{
		fin = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fin);
		sheet = workbook.getSheet(sheetName);
		int count = sheet.getLastRowNum();
		workbook.close();
		fin.close();
		return count;
	}
	
	public static int getCellCount(String filepath,String sheetName,int rowNumber) throws IOException
	{
		fin = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fin);
		sheet = workbook.getSheet(sheetName);
		int count = sheet.getRow(rowNumber).getLastCellNum();
		workbook.close();
		fin.close();
		return count;
	}
	
	public static String getCellValue(String filepath,String sheetName,int rowNumber,int cellNumber) throws IOException
	{
		fin = new FileInputStream(filepath);
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
	
	public static void setCellValue(String filepath,String sheetName,int rowNumber,int cellNumber,String data) throws IOException
	{
		fin = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fin);
		sheet = workbook.getSheet(sheetName);
		XSSFRow selectedRow = sheet.getRow(rowNumber);
		XSSFCell selectedCell = selectedRow.createCell(cellNumber);
		selectedCell.setCellValue(data);
		fo = new FileOutputStream(filepath);
		workbook.write(fo);
		workbook.close();
		fin.close();
		return ;
	}
	
	public static void fillGreenColor(String filepath,String sheetName,int rowNumber,int cellNumber) throws IOException
	{
		fin = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fin);
		sheet = workbook.getSheet(sheetName);
		XSSFRow selectedRow = sheet.getRow(rowNumber);
		XSSFCell selectedCell = selectedRow.getCell(cellNumber);
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		selectedCell.setCellStyle(style);
		
		fo = new FileOutputStream(filepath);
		workbook.write(fo);
		workbook.close();
		fin.close();
		return ;
	}

	public static void fillRedColor(String filepath,String sheetName,int rowNumber,int cellNumber) throws IOException
	{
		fin = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fin);
		sheet = workbook.getSheet(sheetName);
		XSSFRow selectedRow = sheet.getRow(rowNumber);
		XSSFCell selectedCell = selectedRow.getCell(cellNumber);
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		selectedCell.setCellStyle(style);
		
		fo = new FileOutputStream(filepath);
		workbook.write(fo);
		workbook.close();
		fin.close();
		return ;
	}
}
