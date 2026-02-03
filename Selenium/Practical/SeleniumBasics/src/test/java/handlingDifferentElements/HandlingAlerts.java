package handlingDifferentElements;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAlerts {
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//Simple alert
		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		Alert myalert = driver.switchTo().alert();
		System.out.println(myalert.getText());
		myalert.accept();
		
		// Confirmation Alert
		driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();
		myalert = driver.switchTo().alert();
//		myalert.dismiss();
		myalert.accept();
		
		driver.findElement(By.xpath("//button[@id='promptBtn']")).click();
		myalert = wait.until(ExpectedConditions.alertIsPresent());
		myalert.sendKeys("Shankar");
		myalert.accept();
		
		driver.quit();
		
	}
}
