package vtiger.Practice;

import org.apache.poi.ss.usermodel.Workbook;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Exception {
		PropertyFileUtility putil=new PropertyFileUtility();
		String value=putil.readDataFromPropertyFile("browser");
		System.out.println(value);
		
		ExcelFileUtility eutil=new ExcelFileUtility();
		String data=eutil.readDataFromExcel("Organisations", 1, 2);
		System.out.println(data) ;
		
		int rowCount=eutil.getRowCount("Organisations");
		System.out.println(rowCount);
		
		System.out.println("SSSSSSSSSSSSSSSSSSSSSSssssss");
		
		eutil.writeDataIntoExcel("Organisations", 2, 6, "Chaitra125gh");
		
		JavaUtility jutil=new JavaUtility();
		System.out.println(jutil.getRandomNumber());		
		String d=jutil.getSysemDate();
		System.out.println(d);
	}

}
