package vtiger.OrganisationsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganisationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganisationInfoPage;
import vtiger.ObjectRepository.OrgnanisatonsPage;

public class CreateMultipleOrganisaton {
	// Create all necessary objects
			PropertyFileUtility putil=new PropertyFileUtility();
			ExcelFileUtility eutil=new ExcelFileUtility();
			JavaUtility jutil=new JavaUtility();
			WebDriverUtility wutil=new WebDriverUtility();
 
	@Test(dataProvider = "OrgData")
	public void createMultipleOrg(String ORG, String INDUSTRY) throws Exception
	{
				// Read the necessary data
		// property file
		String BROWSER=putil.readDataFromPropertyFile("browser");
		String URL=putil.readDataFromPropertyFile("url");
		String USERNAME=putil.readDataFromPropertyFile("username");
		String PASSWORD=putil.readDataFromPropertyFile("password");
		
		String ORGNAME=ORG+jutil.getRandomNumber();
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
		//driver.manage().window().maximize();
		wutil.maxmiseWindow(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wutil.waitForPageLoad(driver);
		driver.get(URL);
		// Login to Application
		LoginPage login = new LoginPage(driver);
		login.loginToApp("admin", "admin");
		// Click on Organisations Link
		HomePage hp=new HomePage(driver);
		hp.orgClick();
		// Click on Create Organisation lookup image
		OrgnanisatonsPage op=new OrgnanisatonsPage(driver);
		op.orgLinkClick();
		//Create new organisation name textfield
		CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
		cnop.createOrganisation(ORGNAME, INDUSTRY);
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		String orgheader=oip.headerText();
		if(orgheader.contains(ORGNAME))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		//Click on save button
	
	//	WebElement ele=driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
	//	Actions act=new Actions(driver);
	//	act.moveToElement(ele).build().perform();
		hp.logoutofApp();
		driver.close();

	}
	@DataProvider(name = "OrgData")
	public Object[][] getData() throws Exception
	{
		Object[][] data=eutil.readMultipleDataIntoDataProvider("MulitpleOrganisations");
		
		return data;
	}

}
