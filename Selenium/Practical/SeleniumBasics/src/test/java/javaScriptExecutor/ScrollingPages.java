package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPages {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// Scroll by pixels
		js.executeScript("window.scrollBy(0,500)", "");
		System.out.println(js.executeScript("return window.pageYOffset",""));
		
		// Scroll until particular element
		WebElement element = driver.findElement(By.xpath("//div[@class='date-picker-box']"));
		js.executeScript("arguments[0].scrollIntoView()", element);
		System.out.println(js.executeScript("return window.pageYOffset",""));
		
		// Scroll to end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		System.out.println(js.executeScript("return window.pageYOffset",""));
		
		// Scroll to start of the page
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", "");
		System.out.println(js.executeScript("return window.pageYOffset",""));
		
		driver.quit();
		
	}

}
