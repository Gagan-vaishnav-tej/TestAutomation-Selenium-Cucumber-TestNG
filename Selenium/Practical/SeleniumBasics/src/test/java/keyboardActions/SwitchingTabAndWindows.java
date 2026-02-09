package keyboardActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingTabAndWindows {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// Opens new tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.amazon.com/");
		
		//Opens new window
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.amazon.com/");
		
		driver.quit();
		
		
		
		
		

	}

}
