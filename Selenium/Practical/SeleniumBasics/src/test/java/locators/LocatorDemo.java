package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorDemo {
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		//Finding webElement by name
		driver.findElement(By.name("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		
		//Finding WebElement by id
		driver.findElement(By.id("submit")).click();
		
		//Finding WebElement by link Text
		driver.findElement(By.linkText("Log out")).click();
		// Finding WebElement by partial link text
//		driver.findElement(By.partialLinkText("Log")).click();
		
		// Finding multiple WebElements using className
		List<WebElement> elements = driver.findElements(By.className("wp-block-separator"));
		System.out.println(elements.size());
		
		// Finding multiple WebElements using tagName
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		driver.quit();
	}
}
