package workingWithExcelFiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writingDataIntoExcelFile {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Sheet10");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of rows:");
		int rows = sc.nextInt();
		System.out.println("Enter number of colums:");
		int colums = sc.nextInt();
		
		for(int i=0;i<rows;i++)
		{
			XSSFRow row = sheet.createRow(i);
			for(int j=0;j<colums;j++)
			{
				XSSFCell cell = row.createCell(j);
				cell.setCellValue(sc.next());
			}
		}
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\writeData.xlsx");
		workbook.write(file);
		workbook.close();
		file.close();
		sc.close();
	}

}
