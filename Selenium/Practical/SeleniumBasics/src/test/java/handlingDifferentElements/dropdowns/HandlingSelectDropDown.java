package handlingDifferentElements.dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingSelectDropDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='country']"));
		Select select = new Select(dropDown);
		
//		driver.findElement(By.xpath("//option[@value='india']")).click();
//		select.selectByIndex(9);
//		select.selectByValue("india");
//		select.selectByVisibleText("India");
		select.selectByContainsVisibleText("Ind");
		
		List<WebElement> elements = select.getOptions();
		System.out.println(elements.size());
		for(WebElement currentElement:elements)
		{
			System.out.println(currentElement.getText());
		}
		
		driver.quit();
	}

}
