package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	@Test
	public void assertPractice()
	{
		SoftAssert soft=new SoftAssert();
		System.out.println("Test 1");
		System.out.println("Test 2");
		System.out.println("Test 3");
	//	Assert.assertEquals(false, true);
		soft.assertEquals(true, false);
		System.out.println("Test 4");
		System.out.println("Test 5");
		System.out.println("Test 6");
		soft.assertAll();
	}
}
