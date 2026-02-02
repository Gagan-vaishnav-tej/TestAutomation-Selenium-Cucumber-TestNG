package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
//		// Xpath using single attribute
//		driver.findElement(By.xpath("//input[@id=\"small-searchterms\"]")).sendKeys("Mobiles");
//		
//		// Xpath using multiple attributes
//		driver.findElement(By.xpath("//input[@id=\"small-searchterms\"][@name='q']")).sendKeys("Laptops");
//		
//		// Xpath with 'and' and 'or' operations
//		driver.findElement(By.xpath("//input[@id='small-searchterms' and @name='q']")).clear();
//		
//		// Xpath with text() method used for inner text
//		driver.findElement(By.xpath("//button[text()='Search']")).click();
//		
//		// Xpath using contains() method 
//		// Here in attribute section of contains method we can use . in place of text()
//		driver.findElement(By.xpath("//input[contains(@placeholder,'Search store')]")).sendKeys("Hello");
		
		// Xpath using starts_with() method
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Searc')]")).sendKeys("Hello");
		
		// Xpath using chained xpath (combination of relative xpath and a bit of absolute xpath)
		System.out.println(driver.findElement(By.xpath("//div[@class='header-logo']/a/img")).isDisplayed());
	}
}
