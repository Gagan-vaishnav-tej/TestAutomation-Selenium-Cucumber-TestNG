import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try
		{
			driver.get("https://google.com");
			
			// Locating Username and Password Elements
			WebElement logo = driver.findElement(By.xpath("//div[@class='k1zIA rSk4se']//*[name()='svg']"));
			String url = driver.getCurrentUrl();
			if(url.contains("google.com"))
			{
				System.out.println("Redirected to correct URL...");
			}
			else {
				System.out.println("Failed to navigate to google.com");
			}
			if(logo.isDisplayed())
			{
				System.out.println("Logo is being Displayed...");
			}
			else {
				System.out.println("Error in displaying LOGO");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		driver.quit();
	}

}
