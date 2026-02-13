package annotations.beforeAndAfterSuite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ClassB {
	@AfterTest
	void afterTest()
	{
		System.out.println("After test method....");
	}
	
	@AfterTest
	void afterTest2()
	{
		System.out.println("After test method 2....");
	}
	
	@Test
	void m2()
	{
		System.out.println("Method 2...");
	}
	
	@AfterSuite
	void afterSuite()
	{
		System.out.println("After Suite...");
	}
}
