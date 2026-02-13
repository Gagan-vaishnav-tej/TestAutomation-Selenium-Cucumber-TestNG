package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {
	
	@Test
	void sampleTest()
	{
		String expectedTitle = "OrangeHRM";
		String actualTitle = "AppleHRM";
		if(expectedTitle.equals(actualTitle))
		{
			System.out.println("Test Passed...");
			Assert.assertTrue(true);
		}
		else 
		{
			System.out.println("Test Failed...");
			Assert.assertTrue(false);
		}
		
//		Assert.assertEquals(expectedTitle, actualTitle);
		
	}
}
