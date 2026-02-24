
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try
		{
			driver.get("https://practicetestautomation.com/practice-test-login/");
			
			// Locating Username and Password Elements
			WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
			WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
			WebElement loginBtn = driver.findElement(By.xpath("//button[@id='submit']"));
			
			userName.sendKeys("student");
			password.sendKeys("Password123");
			loginBtn.click();
			Thread.sleep(3000);
			System.out.println("Login Sucessful...");
		}
		catch(Exception e)
		{
			System.out.println("Login Unsucessful...");
			e.printStackTrace();
		}	
		driver.quit();
	}

}
