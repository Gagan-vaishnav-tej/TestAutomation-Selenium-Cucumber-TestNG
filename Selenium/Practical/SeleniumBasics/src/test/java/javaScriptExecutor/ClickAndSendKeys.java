package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickAndSendKeys {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		
		// Sendkeys using JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement input = driver.findElement(By.xpath("//input[@id='name']"));
		js.executeScript("arguments[0].setAttribute('value','Ram')", input);
		
		// Click Using JsExecutor
		WebElement radioButton = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", radioButton);
		
		driver.quit();
	}

}
