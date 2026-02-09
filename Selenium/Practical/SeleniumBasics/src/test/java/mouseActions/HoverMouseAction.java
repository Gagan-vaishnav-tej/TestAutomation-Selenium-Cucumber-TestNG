package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverMouseAction {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement account = driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']"));
		WebElement music = driver.findElement(By.xpath("//span[normalize-space()='Music Library']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(account).moveToElement(music).click().perform();
		
		driver.quit();
	}

}
