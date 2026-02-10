package miscellaneous;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingScreenShots {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Take full page screen shot
		TakesScreenshot ss = (TakesScreenshot)driver;
		File f1 = ss.getScreenshotAs(OutputType.FILE);
		File target1 = new File(System.getProperty("user.dir")+"\\screenShots\\fullss.png");
		f1.renameTo(target1);
		
		// Take ScreenShot of a division
		WebElement div = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[8]/div[1]/div[1]"));		
		File f2 = div.getScreenshotAs(OutputType.FILE);
		File target2 = new File(System.getProperty("user.dir")+"\\screenShots\\divss.png");
		f2.renameTo(target2);
		
		// Take ScreenShot of a WebElement
		WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[8]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/span[1]/a[1]/img[1]"));		
		File f3 = element.getScreenshotAs(OutputType.FILE);
		File target3 = new File(System.getProperty("user.dir")+"\\screenShots\\elementss.png");
		f3.renameTo(target3);
		
		driver.quit();
	}

}
