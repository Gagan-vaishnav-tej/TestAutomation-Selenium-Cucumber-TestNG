package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement rightClickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		Actions action = new Actions(driver);
		action.contextClick(rightClickButton).build().perform();
		
		WebElement copy = driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[3]"));
		copy.click();
		
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
		driver.quit();
	}

}
