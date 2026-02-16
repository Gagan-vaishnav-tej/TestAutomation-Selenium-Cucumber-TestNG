package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@SuppressWarnings("deprecation")
public class BaseTest {
	public static WebDriver driver;
	public Logger logger;
	public Properties properties;
	
	
	@BeforeClass(groups= {"Sanity","Regression","Master","DataDriven"})
	@Parameters({"browser","os"})
	public void setup(String browser,String os) throws IOException
	{
		FileReader file = new FileReader(new File(System.getProperty("user.dir")+"./src//test//resources/config.properties"));
		properties = new Properties();
		properties.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		switch(browser.toLowerCase())
		{
			case "chrome" : driver = new ChromeDriver();break;
			case "edge" : driver = new EdgeDriver();break;
			default : System.out.println("Invalid browser"); return;
		}
		driver.get(properties.getProperty("appurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master","DataDriven"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{

		String str = RandomStringUtils.randomAlphabetic(5);
		return str;
	}
	
	
	public String randomNumber()
	{
		return RandomStringUtils.randomNumeric(10);
	}

	public String randomalphaNumeric()
	{
		return RandomStringUtils.randomAlphabetic(5)+"$"+RandomStringUtils.randomNumeric(5);
	}

	public String captureScreenShot(String name) {
		String timestamp = new SimpleDateFormat("yyyyMMddmmss").format(new Date());
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		
		String targetFilepath =  System.getProperty("user.dir")+"\\screenshots\\"+name+"_"+timestamp+".png";
		File targetFile = new File(targetFilepath);
		
		file.renameTo(targetFile);
		
		return targetFilepath;
	}
}
