package handlingDifferentElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// Handling Single check boxes
		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		for(int i=0;i<list.size();i++) {
			if((i&1)==0) list.get(i).click();
		}
		Thread.sleep(5000);
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).isSelected()) list.get(i).click();
		}
		
		driver.quit();
		
	}

}
