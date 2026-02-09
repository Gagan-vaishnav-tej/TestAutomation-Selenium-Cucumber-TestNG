package handlingDifferentElements.dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAutoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).click();
		
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Selenium");
		
		Thread.sleep(5000);
		List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class='pcTkSc']//div[@role='presentation' and @class='wM6W7d']/span"));
		for(WebElement element:suggestions)
		{
			if(element.getText().equals("selenium")) 
			{
				element.click();
				break;
			}
			System.out.println(element.getText());
		}
		
		driver.quit();
	
	}

}
