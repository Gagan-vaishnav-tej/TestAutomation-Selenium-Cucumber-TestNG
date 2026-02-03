package sychronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		WebElement textField =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
		textField.sendKeys("Admin");
		password.sendKeys("admin123");
		
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		login.click();
		driver.quit();

	}

}
