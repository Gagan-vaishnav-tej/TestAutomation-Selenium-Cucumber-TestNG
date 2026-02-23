import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserBasedOnInput {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Browser to be Opened: ");
		String browserName = sc.next();
		switch (browserName.toLowerCase()) 
		{
			case "chrome": driver = new ChromeDriver();break;
			case "edge": driver = new EdgeDriver();break;
			case "firefox": driver = new FirefoxDriver();break;
			default:System.out.println("Invalid Browser Name...!");return;
		}
		Thread.sleep(3000);
		System.out.println("Browser Launched Sucessfully...");
		driver.quit();
	}

}
