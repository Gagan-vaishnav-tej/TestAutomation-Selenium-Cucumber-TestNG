import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTest {

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchBar= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']")));
		
		searchBar.sendKeys("laptop");
		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='left-pane-results-container']/div"));
		for(WebElement element:searchResults)
		{
			System.out.println(element.getText());
		}
	}

}
