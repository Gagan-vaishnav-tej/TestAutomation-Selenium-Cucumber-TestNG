package handlingDifferentElements.tables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicTables {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']/li"));
		System.out.println(pages.size());
		for(WebElement curr:pages)
		{
			curr.click();
			List<WebElement> tableContent = driver.findElements(By.xpath("//table[@id='productTable']//tr"));
			for(int i=1;i<tableContent.size();i++)
			{
				System.out.print(driver.findElement(By.xpath("//table[@id='productTable']//tr["+i+"]/td[1]")).getText()+"\t");
				System.out.print(driver.findElement(By.xpath("//table[@id='productTable']//tr["+i+"]/td[2]")).getText()+"\t");
				System.out.print(driver.findElement(By.xpath("//table[@id='productTable']//tr["+i+"]/td[3]")).getText()+"\t");
				System.out.println();
			}
			
		}
		driver.quit();
	}

}
