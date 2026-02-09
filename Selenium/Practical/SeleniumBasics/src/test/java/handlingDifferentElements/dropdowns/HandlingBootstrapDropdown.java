package handlingDifferentElements.dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBootstrapDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
		Thread.sleep(5000);
		List<WebElement> options = driver.findElements(By.xpath("//input[@id='justAnInputBox']/parent::div/following-sibling::div[contains(@class,'comboTreeDropDownContainer')]//span[contains(@class,'comboTreeItemTitle')]"));
		System.out.println(options.size());
		
		for(int i=0;i<options.size();i++) System.out.println(options.get(i).getText());
		
		for(int i=0;i<options.size();i++)
		{
			if((i&1)==0)options.get(i).click();
		}
//		System.out.println(options);
	}

}
