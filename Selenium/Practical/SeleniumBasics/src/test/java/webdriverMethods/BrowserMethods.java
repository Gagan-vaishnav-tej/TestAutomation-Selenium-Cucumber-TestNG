package webdriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(8000);
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		// close() is used to close a find web instance (which currently on focus)
//		driver.close();
		// quit() is used to close all the active instances of the web instances
		System.out.println(driver.getWindowHandles());
		driver.quit();
	}

}
