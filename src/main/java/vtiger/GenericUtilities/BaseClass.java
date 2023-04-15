package vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This class consists of basic configeration annotations
 * @author Srikar Reddy
 *
 */
public class BaseClass {
	PropertyFileUtility putil=new PropertyFileUtility();
	ExcelFileUtility eutil=new ExcelFileUtility();
	JavaUtility jutil=new JavaUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("DataBas Connection Succesful");
	}
	@BeforeClass
	public void bcConfig() throws Exception
	{
		String BROWSER=putil.readDataFromPropertyFile("browser");
		String URL=putil.readDataFromPropertyFile("url");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox Browser is launched");
		} else {
			System.out.println("Invalid Browser name");
		}
		wutil.maxmiseWindow(driver);
		wutil.waitForPageLoad(driver);
		driver.get(URL);
		sdriver=driver;
	}
	@BeforeMethod
	public void bmConfig() throws Exception
	{
		String USERNAME=putil.readDataFromPropertyFile("username");
		String PASSWORD=putil.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login to App Succesful");
	}
	@AfterMethod
	public void amConfig() throws Exception
	{
	HomePage hp=new HomePage(driver);
	hp.logoutofApp(driver);
	System.out.println("Logout of App Succesful");
	}
	
	@AfterClass
	public void acConfig() throws Exception
	{
		driver.quit();
		System.out.println("Browser is closed Sucefully");
	}
	@AfterSuite
	public void asConfig()
	{
		System.out.println("DataBas Connection closed Succesful");
	}
	
}
