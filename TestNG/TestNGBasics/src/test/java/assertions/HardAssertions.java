package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {
	@Test
	void test()
	{
//		Assert.assertEquals(123, 123); // passed
//		Assert.assertEquals(123, 1223); // failed
		
//		Assert.assertNotEquals(123, 123); // passed
//		Assert.assertNotEquals(123, 1223); // failed
		
//		Assert.assertTrue(true); // passed
//		Assert.assertTrue(false); // failed
		
//		Assert.assertFalse(false); // passed
//		Assert.assertFalse(true); // failed
		
		Assert.fail();
		
	}
}
