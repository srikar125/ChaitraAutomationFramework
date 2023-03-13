package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.RetryAnalyserImplementation;

public class RetryAnalyserPractice {

	@Test(retryAnalyzer = vtiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void practiceRetry()
	{
		System.out.println("Run");
		Assert.fail();
	}
	
	@Test
	public void practiceRetry1()
	{
		System.out.println("Run1");
	}

}
