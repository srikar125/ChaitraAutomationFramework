package vtiger.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateContactWithOrganisationGeneric {
	public static void main(String[] args) throws Exception {
	// Create all necessary objects
	PropertyFileUtility putil = new PropertyFileUtility();
	ExcelFileUtility eutil = new ExcelFileUtility();
	JavaUtility jutil = new JavaUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	// Read the necessary data
	// property file
	String BROWSER = putil.readDataFromPropertyFile("browser");
	String URL = putil.readDataFromPropertyFile("url");
	String USERNAME = putil.readDataFromPropertyFile("username");
	String PASSWORD = putil.readDataFromPropertyFile("password");
	
	// Excel Sheet
	String LASTNAME = eutil.readDataFromExcel("Contacts", 4, 2);
	String ORGNAME=eutil.readDataFromExcel("Contacts",4 , 3)+jutil.getRandomNumber();
	WebDriver driver = null;

	// Launch the browser-- Example for Run time polymorphism
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}else
	{
		System.out.println("Invalid Browser name");
	}
	// driver.manage().window().maximize();
	wutil.maxmiseWindow(driver);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	wutil.waitForPageLoad(driver);driver.get(URL);
	// Login to Application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);driver.findElement(By.name("user_password")).sendKeys(PASSWORD);driver.findElement(By.id("submitButton")).click();
	// Click on Organisations Link
	driver.findElement(By.linkText("Organizations")).click();
	// Click on Create Organisation lookup image
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	// Create new organisation name textfield
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	// Click on save button
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//Validate Organisation
	String OrgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(OrgHeader.contains(ORGNAME))
	{
		System.out.println("Organisation created sucessfully");
	}
	else
	{
		System.out.println("Organisation creation failed");
		
	}
	
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
	wutil.switchToWindow(driver, "Accounts");
	driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
	wutil.switchToWindow(driver, "Contacts");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String ContactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(ContactHeader.contains(LASTNAME))
	{
		System.out.println(ContactHeader);
		System.out.println("PASS");
	}
	else
	{
		System.out.println("FAIL");
	}
	Thread.sleep(5000);
	WebElement ele = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
	// Actions act=new Actions(driver);
	// act.moveToElement(ele).build().perform();
	wutil.mouseHover(driver,ele);driver.findElement(By.linkText("Sign Out")).click();
	driver.close();

}

}
