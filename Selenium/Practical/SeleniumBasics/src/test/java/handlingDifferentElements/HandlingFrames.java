package handlingDifferentElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello");
		driver.switchTo().defaultContent();
		
//		driver.switchTo().frame(1);
//		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Hello");
//		
//		driver.switchTo().defaultContent();
//		
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Entered frame 3");
		
		// Navigating to iframe inside frame 3
		driver.switchTo().frame(0);
//		driver.findElement(By.xpath("//div[@id='i6']//div[@class='AB7Lab Id5V1']")).click();
		
		WebElement radioButton = driver.findElement(By.xpath("//div[@id='i6']//div[@class='AB7Lab Id5V1']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", radioButton);
		
		driver.switchTo().defaultContent();
		WebElement frame = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//a[text()='https://a9t9.com']")).click();
		driver.findElement(By.xpath("//a[@href='/rpa'][normalize-space()='Browser Automation']")).click();
		
		driver.quit();
	}

}
