package handlingDifferentElements;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMutlipleWindows {
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		
		List<String> windows = new ArrayList<String>(driver.getWindowHandles());
		for(String windowId:windows)
		{
			WebDriver currentPage = driver.switchTo().window(windowId);
			System.out.println(currentPage.getTitle());
		}
		
		for(String windowId:windows)
		{
			WebDriver currentPage = driver.switchTo().window(windowId);
			System.out.println(currentPage.getTitle());
			if(currentPage.getTitle().equals("Human Resources Management Software | HRMS | OrangeHRM")) driver.close();
		}
		
		driver.quit();
	}
}
