package annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeAndAfterTest {
	
	@BeforeClass
	void login()
	{
		System.out.println("Logging In...");
	}
	
	@AfterClass
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
