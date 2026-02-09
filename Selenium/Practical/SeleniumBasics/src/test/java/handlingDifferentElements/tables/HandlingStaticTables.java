package handlingDifferentElements.tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingStaticTables {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		System.out.println("Number of row :"+rows.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		System.out.println("Numbers of columns :"+columns.size());
		
		for(int i=1;i<rows.size();i++)
		{
			List<WebElement> curr = rows.get(i).findElements(By.xpath(".//td"));
			for(int j=0;j<columns.size();j++)
			{
				System.out.print(curr.get(j).getText()+"\t");
			}
			System.out.println();
		}
		
		driver.quit();
	}

}
