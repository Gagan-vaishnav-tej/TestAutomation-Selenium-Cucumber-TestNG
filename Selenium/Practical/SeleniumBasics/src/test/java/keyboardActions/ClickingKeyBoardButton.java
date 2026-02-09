package keyboardActions;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickingKeyBoardButton {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement field1= driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("KeyBoard Action");
		
		Actions action = new Actions(driver);
		
		// Selecting text using CTRL + A
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		// Copying selected text using CTRL + C
		action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		// Clicking TAB
		action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		// Pasting text using CTRL + V
		action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		
		driver.quit();		
	}

}
