package questions;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ExcelUtil;

public class Q1_Selenium_DDT {
	
	public static void main(String[] args) throws IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String filepath = ".///src//test//resources//testData.xlsx";
		
		XSSFWorkbook workbook = new XSSFWorkbook(filepath);
		
		int rowCount = ExcelUtil.getRowCount(filepath, "Sheet1");
		for(int i=1;i<=rowCount;i++)
		{
			String username = ExcelUtil.getCellValue(filepath, "Sheet1", i, 0);
			String password = ExcelUtil.getCellValue(filepath, "Sheet1", i, 1);
			System.out.println(username+"  "+password);
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			driver.findElement(By.xpath("//button[@id='submit']")).click();
			if(driver.getCurrentUrl().equals("https://practicetestautomation.com/practice-test-login/"))
			{
				System.out.println("Login test "+i+" failed");
			}
			else 
			{
				System.out.println("Login test "+i+" succeded");
				WebElement logoutButton = driver.findElement(By.xpath("//a[normalize-space()='Log out']"));
				logoutButton.click();
			}
		}
		System.out.println("Finished...");
		workbook.close();
		driver.quit();
	}

}
