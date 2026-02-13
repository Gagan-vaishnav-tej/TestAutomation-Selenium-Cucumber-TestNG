package annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAndAfterMethod {
	
	@BeforeMethod
	void login()
	{
		System.out.println("Logging In...");
	}
	
	@AfterMethod
	void logout()
	{
		System.out.println("Logging out...");
	}
	
	@Test(priority=0)
	void search()
	{
		System.out.println("Searching...");
	}
	
	@Test(priority=1)
	void advancedSearch()
	{
		System.out.println("Advanced Searching...");
	}

}
