package webdriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		
		// isDisplayed() is used to check whether a web element is displayed or not
		System.out.println(driver.findElement(By.xpath("//img[contains(@alt,'nopCommerce demo store')]")).isDisplayed());
		
		// idEnabled() is used to check whether a web element is enabled on the web page or not
		System.out.println(driver.findElement(By.xpath("//img[contains(@alt,'nopCommerce demo store')]")).isEnabled());
		
		// isSelected() is used to check whether a particular element is selected or not
		WebElement maleRadioButton = driver.findElement(By.xpath("//*[@id='gender-male']"));
		WebElement femaleRadioButton = driver.findElement(By.xpath("//*[@id='gender-female']"));
		
		System.out.println("Male Button Selected:"+maleRadioButton.isSelected());
		System.out.println("Female Button Selected:"+femaleRadioButton.isSelected());
		
		maleRadioButton.click();
		System.out.println("Male Button Selected:"+maleRadioButton.isSelected());
		System.out.println("Female Button Selected:"+femaleRadioButton.isSelected());
		
		femaleRadioButton.click();
		System.out.println("Male Button Selected:"+maleRadioButton.isSelected());
		System.out.println("Female Button Selected:"+femaleRadioButton.isSelected());
		
		driver.quit();
	}
}
