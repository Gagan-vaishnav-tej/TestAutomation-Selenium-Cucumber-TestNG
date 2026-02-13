/*
 * 1) Open App
 * 2) Login 
 * 3) Test Logo presence
 * 3) LogOut
 */
package basics;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeHRMTest {
	
	WebDriver driver;
	
	@Test(priority=1)
	void openApplication()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(priority=2)
	void login()
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test(priority=3)
	void logoTest()
	{
		boolean isPresent = driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
		System.out.println("Is Logo Displayed :"+isPresent);
	}
	
	@Test(priority=4)
	void logout()
	{
		driver.quit();
	}
}
