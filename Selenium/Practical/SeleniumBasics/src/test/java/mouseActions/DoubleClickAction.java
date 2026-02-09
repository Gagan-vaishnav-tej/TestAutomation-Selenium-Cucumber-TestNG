package mouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement inputBox1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement inputBox2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement copyText = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		inputBox1.clear();
		inputBox1.sendKeys("Selenium");
		
		Actions action = new Actions(driver);
		action.doubleClick(copyText).perform();
		
		System.out.println(inputBox1.getAttribute("value")+" - "+inputBox2.getAttribute("value"));
		
		Thread.sleep(3000);
		driver.quit();
	}

}
