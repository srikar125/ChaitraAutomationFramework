package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DebuggingPractice {
	@Test
	public void debugTest()
	{
		System.out.println("Hi");
		System.out.println("Hello");
		int c=divide(10,0);
		System.out.println(c);
	}
	public int divide(int a,int b)
	{
		int c=a/b;
		return c;
	}
	
}
