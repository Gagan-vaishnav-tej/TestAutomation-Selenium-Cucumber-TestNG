package handlingDifferentElements;


import java.time.Duration;
import java.time.Month;
import java.time.Year;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDatePicker {

	private static void selectDate(WebDriver driver,String date,String month,String year)
	{
		while(true)
		{
			String currentYearStr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			Year requiredYear = Year.parse(year),currentYear = Year.parse(currentYearStr);
			int diff = requiredYear.compareTo(currentYear);
			if(diff>0)
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}else if(diff<0)
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
			else {
				break;
			}
		}
		selectMonthAndDay(driver,month,date);
	}
	private static void selectMonthAndDay(WebDriver driver, String month,String date) {
		while(true)
		{
			String currentMonthStr = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			Month requiredMonth = Month.valueOf(month.toUpperCase());
			Month currentMonth=Month.valueOf(currentMonthStr.toUpperCase());
			int diff = requiredMonth.compareTo(currentMonth);
			if(diff>0)
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}else if(diff<0)
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
			else {
				// Select Date
				List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td/a"));
				for(WebElement currDate:dates)
				{
					if(currDate.getText().equals(date)) {
						currDate.click();
						return;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(0);
		
		// Direct Date picker
//		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("01/01/2000");
		
		// Picking date using date picker
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		selectDate(driver,"1","June","2027");
		
		driver.quit();
	}

}
