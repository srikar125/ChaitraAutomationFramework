package vtiger.OrganisationsTests;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationUsingDDT {

	public static void main(String[] args) throws Exception {
		// Read the necessary data
		// property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		// Excel Sheet
		FileInputStream fiss = new FileInputStream(".\\src\\test\\resources\\vtiger.xlsx");
		Workbook workbook = WorkbookFactory.create(fiss);
		Sheet sh = workbook.getSheet("Organisations");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(2);
		String ORGNAME = cell.getStringCellValue();
		WebDriver driver=null;
		// Launch the browser-- Example for Run time polymorphism
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(URL);
		// Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		// Click on Organisations Link
		driver.findElement(By.linkText("Organizations")).click();
		// Click on Create Organisation lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//Create new organisation name textfield
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		//Click on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		WebElement ele=driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).build().perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

}
