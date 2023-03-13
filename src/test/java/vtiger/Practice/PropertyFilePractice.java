package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws Exception {
		// Load the file location in to file input stream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//create object of properties from java.util package
		Properties pobj=new Properties();
		//Load file input stream in to properties
		pobj.load(fis);
		//read the value using key
		String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		System.out.println(BROWSER);
		System.out.println(URL);

	}

}
