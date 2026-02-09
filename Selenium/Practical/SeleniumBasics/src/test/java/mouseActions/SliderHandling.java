package mouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement leftBar = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle')])[1]"));
		WebElement rightBar = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle')])[2]"));
		System.out.println("Default postion of left Silde Bar :"+leftBar.getLocation());
		System.out.println("Befault postion of Right Silde Bar :"+rightBar.getLocation());
		Actions action = new Actions(driver);
		action.dragAndDropBy(leftBar, 50, 0).perform();
		System.out.println("Position of Left Silde Bar after moving"+leftBar.getLocation());
		action.dragAndDropBy(rightBar, -50, 0).perform();
		System.out.println("Position of Right Silde Bar after moving"+rightBar.getLocation());
		
		driver.quit();
	}

}
