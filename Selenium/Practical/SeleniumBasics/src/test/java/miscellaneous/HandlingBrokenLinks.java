package miscellaneous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBrokenLinks {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total No.of links :"+links.size());
		int count=0;
		for(WebElement curr:links)
		{
			String href = curr.getAttribute("href");
			if(href==null || href.isEmpty() || !href.startsWith("http:"))
			{
				System.out.println("Link Cannot be Opened");
			}
			else 
			{
				try
				{
					URL url = new URL(href);
					HttpURLConnection connection = (HttpURLConnection)url.openConnection(); 
					if(connection.getResponseCode()>=400)
					{
						System.out.println(href+" : "+connection.getResponseCode()+" : Is a Broken Link");
						count++;
					}
					else
					{
						System.out.println(href+" : "+connection.getResponseCode()+" : Not a Broken Link");
					}
				}catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		System.out.println("No of broken links :"+count);
		
		
		driver.quit();
	}

}
