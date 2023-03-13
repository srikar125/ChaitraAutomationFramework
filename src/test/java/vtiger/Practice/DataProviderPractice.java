package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider = "getData")
	public void dataProviderPractice(String Name,String Model,int Price,int Quantity)
	{
		System.out.println(Name+" "+Model+" "+Price+" "+Quantity);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][4];
		data[0][0]="Samsung";
		data[0][1]="A80";
		data[0][2]=10000;
		data[0][3]=12;
		
		data[1][0]="Iphone";
		data[1][1]="S13";
		data[1][2]=30000;
		data[1][3]=10;
		
		data[2][0]="Nokia";
		data[2][1]="1100";
		data[2][2]=5000;
		data[2][3]=10;
		
		return data;
		
		
		
	}
}
