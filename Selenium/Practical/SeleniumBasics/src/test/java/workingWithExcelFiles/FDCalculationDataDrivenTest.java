package workingWithExcelFiles;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculationDataDrivenTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		String filepath = System.getProperty("user.dir")+"\\testdata\\BDDTestData.xlsx";
		String sheetName = "Sheet1";
		FileInputStream fin = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		int rows = ExcelUtil.getRowCount(filepath, sheetName);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.paisabazaar.com/fd-fixed-deposit-calculator/");
		
		WebElement amountElement = driver.findElement(By.xpath("//input[@id='principal_amount']"));
		WebElement interestElement = driver.findElement(By.xpath("//input[@id='rate_of_interest_w']"));
		WebElement tenureElement = driver.findElement(By.xpath("//input[@id='tennure']"));
		WebElement selectElement = driver.findElement(By.xpath("//select[@id='tennureType']"));
		Select select = new Select(selectElement);
		WebElement calculateButton = driver.findElement(By.xpath("//button[@id='fd-calculatorbt']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		for(int i=1;i<=rows;i++)
		{
			
			amountElement.clear();
			js.executeScript("document.getElementById('rate_of_interest_w').value = '';", "");

			amountElement.sendKeys(ExcelUtil.getCellValue(filepath, sheetName, i, 0));
			interestElement.sendKeys(ExcelUtil.getCellValue(filepath, sheetName, i, 1));
			select.selectByContainsVisibleText(ExcelUtil.getCellValue(filepath, sheetName, i, 3));
			js.executeScript("document.getElementById('tennure').value = '';", "");
			tenureElement.sendKeys(ExcelUtil.getCellValue(filepath, sheetName, i, 2));
			calculateButton.click();
			
			Thread.sleep(1000);
			String amountStr = driver.findElement(By.xpath("//p[@id='maturityAmount']")).getText();
			String actualAmount = amountStr.substring(1);
			ExcelUtil.setCellValue(filepath, sheetName, i, 5, actualAmount);
			
			if(actualAmount.equals(ExcelUtil.getCellValue(filepath, sheetName, i, 4)))
			{
				System.out.println("Test Passed...");
				ExcelUtil.setCellValue(filepath, sheetName, i, 6, "Passed");
				ExcelUtil.fillGreenColor(filepath, sheetName, i, 6);
				
			}
			else
			{
				System.out.println("Test Failed...");
				ExcelUtil.setCellValue(filepath, sheetName, i, 6, "Failed");
				ExcelUtil.fillRedColor(filepath, sheetName, i, 6);
			}
			Thread.sleep(3000);
		}
		workbook.close();
		fin.close();
		
		driver.quit();
	}

}
