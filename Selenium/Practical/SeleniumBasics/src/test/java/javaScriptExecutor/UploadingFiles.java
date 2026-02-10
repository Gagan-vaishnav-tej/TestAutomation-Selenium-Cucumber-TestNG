package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadingFiles {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement fileUpload = driver.findElement(By.xpath("//input[@id='multipleFilesInput']"));
		fileUpload.sendKeys("C:\\Users\\radhi\\untitled.txt"+"\n"+"C:\\Users\\radhi\\New Text Document.txt");
		
		driver.quit();
	}

}
