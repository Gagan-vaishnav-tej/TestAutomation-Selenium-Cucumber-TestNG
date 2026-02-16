package dataproviderAndParallelTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	WebDriver driver;
	
	@BeforeClass
	void openApp()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dataProvider = "dataprov", priority = 2)
	void loginTest(String username,String password)
	{
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		// Is MYAccount displayed
		boolean isDisplayed = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		if(isDisplayed==true)
		{
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
		}
		Assert.assertTrue(isDisplayed);
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider(name = "dataprov")
	Object[][] dataprovider()
	{
		String[][] data= { {"abc@gmail.com" , "@abc123"} ,
						{"efg@gmail.com" , "@abc123"} ,
						{"kaef@gmail.com" , "@abc123"} ,
						{"rambheem@gmail.com" , "@pass123"} ,
						{"samc@gmail.com" , "@sam123"} };
		return data;
	}

}
