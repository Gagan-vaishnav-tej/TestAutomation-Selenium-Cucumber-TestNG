package annotations.beforeAndAfterSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassA {
	
	@BeforeSuite
	void beforeSuite()
	{
		System.out.println("Before Suite...");
	}
	
	@BeforeTest
	void beforeTest()
	{
		System.out.println("Before test method...");
	}
	@Test
	void m1()
	{
		System.out.println("Method 1...");
	}
}
