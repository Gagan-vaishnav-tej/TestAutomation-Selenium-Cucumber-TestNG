package basics;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverDemo
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String actualTitle = driver.getTitle();
//		System.out.println(actualTitle);
		if(actualTitle.equals("OrangeHRM")) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test Failed");
		}
		driver.close();
	}

}
