package webdriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		//get() - used to open url in the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// getCurrentUrl() is used to get or retrieve the url of current web page
		System.out.println(driver.getCurrentUrl());
		
		// getTitle() is used to get or retrieve the title of current web page
		System.out.println(driver.getTitle());
		
		// getPageSource() is used to get the page source(code) of web page
//		System.out.println(driver.getPageSource());
		
		
		// getWindowHandle() is used to get the window id of current web page(web page in focus)
		System.out.println(driver.getWindowHandle());
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		// getWindowHandles() is used to get the window id of all open web pages
		System.out.println(driver.getWindowHandles());
		
		driver.quit();
	}

}
