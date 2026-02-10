package browserOptions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddExtensions {

	public static void main(String[] args) {
		ChromeOptions options= new ChromeOptions();
		// Provide Location of the downloaded .crx of the particular extension
		options.addExtensions(new File("C:\\Yourlocation\\SelectorsHub-Chrome-Web-Store.crx"));
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println(driver.getTitle());
		
		
		driver.quit();

	}

}
