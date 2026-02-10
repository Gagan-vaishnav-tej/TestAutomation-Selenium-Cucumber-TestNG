package browserOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Automation Testing Practice"))
		{
			System.out.println("Loading Correct Page...");
		}else {
			System.out.println("Failed loading");
		}
		driver.quit();
	}

}
