package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@SuppressWarnings("deprecation")
public class BaseTest {
//	public static WebDriver driver;
	public Logger logger;
	public Properties properties;
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	
	public static void setDriver(WebDriver instance)
	{
		driver.set(instance);
	}
	
	@BeforeClass(groups= {"Sanity","Regression","Master","DataDriven"})
	@Parameters({"browser","os"})
	public void setup(String browser,String os) throws IOException
	{
		FileReader file = new FileReader(new File(System.getProperty("user.dir")+"./src//test//resources/config.properties"));
		properties = new Properties();
		properties.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		if(properties.getProperty("execution_env").equals("remote"))
		{
			DesiredCapabilities capabilites = new DesiredCapabilities();
			switch(browser.toLowerCase())
			{
				case "chrome" : capabilites.setBrowserName("chrome");break;
				case "edge" : capabilites.setBrowserName("MicrosoftEdge");break;
				case "firefox" : capabilites.setBrowserName("firefox"); break;
				default : System.out.println("Invalid browser"); return;
			}
			switch(os.toLowerCase())
			{
				case "windows" : capabilites.setPlatform(Platform.WIN11);break;
				case "mac" : capabilites.setPlatform(Platform.MAC);break;
				case "linux":  capabilites.setPlatform(Platform.LINUX);break;
				default : System.out.println("Invalid OS"); return;
			}
			setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilites));
		}
		else
		{
			switch(browser.toLowerCase())
			{
				case "chrome" : setDriver(new ChromeDriver());break;
				case "edge" : setDriver(new EdgeDriver());break;
				case "firefox" : setDriver(new FirefoxDriver());break;
				default : System.out.println("Invalid browser"); return;
			}
		}
		getDriver().get(properties.getProperty("appurl"));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master","DataDriven"})
	public void tearDown()
	{
		getDriver().quit();
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
