package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRMTest {
	WebDriver driver;
	@BeforeClass
	void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority = 1)
	void testLogin() throws InterruptedException
	{
		LoginPageFactory page = new LoginPageFactory(driver);
		page.setUsername("admin");
		page.setPassword("admin123");
		page.clickLogin();
	}
	
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}

}
