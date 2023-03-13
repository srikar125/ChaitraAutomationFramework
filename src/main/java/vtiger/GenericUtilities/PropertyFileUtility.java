package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class contains generic methods related to property file
 * @author Srikar Reddy
 *
 */
public class PropertyFileUtility {
	/**
	 * This generic method will read key from property file and return the value
	 * @throws Exception
	 */
	public String readDataFromPropertyFile(String key) throws Exception
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}
	
}
