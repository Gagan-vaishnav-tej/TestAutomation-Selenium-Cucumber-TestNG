package mouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class StoringAction {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement dragObject = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement destination = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions action = new Actions(driver);
		
		// Action Interface used to store actions
		Action storedAction = action.dragAndDrop(dragObject, destination).build();
		
		storedAction.perform();
		
		Thread.sleep(3000);
		driver.quit();
	}

}
