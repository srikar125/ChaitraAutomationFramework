package vtiger.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContaactsPage;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganisationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganisationInfoPage;
import vtiger.ObjectRepository.OrgnanisatonsPage;

public class CreateContactWithOrganisationPOMTest {
	@Test
	public void CreateContactWithOrgPOMTest() throws Exception {
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
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	// Click on Organisations Link
	HomePage hp=new HomePage(driver);
	hp.orgClick();
	// Click on Create Organisation lookup image
	OrgnanisatonsPage op=new OrgnanisatonsPage(driver);
	op.orgLinkClick();
	// Create new organisation name textfield
	CreateNewOrganisationPage cop=new CreateNewOrganisationPage(driver);
	cop.createOrganisation(ORGNAME);
	//Validate Organisation
	OrganisationInfoPage oip=new OrganisationInfoPage(driver);
	String OrgHeader=oip.headerText();
	if(OrgHeader.contains(ORGNAME))
	{
		System.out.println("Organisation created sucessfully");
	}
	else
	{
		System.out.println("Organisation creation failed");
		
	}
	
	hp.contactsClick();
	ContaactsPage cp=new ContaactsPage(driver);
	cp.clickOnCreateContact();
	CreateNewContactPage cnop=new CreateNewContactPage(driver);
	cnop.createNewContact(LASTNAME, ORGNAME, driver);
	ContactsInfoPage cip=new ContactsInfoPage(driver);
	String ContactHeader=cip.getHeaderText();
	if(ContactHeader.contains(LASTNAME))
	{
		System.out.println(ContactHeader);
		System.out.println("PASS");
	}
	else
	{
		System.out.println("FAIL");
	}
	hp.logoutofApp();
	driver.close();

}

}
