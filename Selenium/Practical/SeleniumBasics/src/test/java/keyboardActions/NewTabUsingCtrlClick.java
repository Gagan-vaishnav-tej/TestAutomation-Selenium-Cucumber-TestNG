package keyboardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NewTabUsingCtrlClick {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement primeVideoButton = driver.findElement(By.xpath("//a[contains(text(),'Prime Video')]"));
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(primeVideoButton).keyUp(Keys.CONTROL).perform();
		
		driver.quit();
	}

}
