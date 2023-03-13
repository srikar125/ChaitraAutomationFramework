package vtiger.ContactsTests;

import org.checkerframework.framework.qual.DefaultQualifier.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
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
@Listeners(vtiger.GenericUtilities.ListnersImplementation.class)
public class CreateContactWithOrganisationPOMBaseListners extends BaseClass {

	ExcelFileUtility eutil=new ExcelFileUtility();
	JavaUtility jutil=new JavaUtility();
	@Test
	public void CreateContactWithOrgPOMTest() throws Exception {
	
	// Excel Sheet
	String LASTNAME = eutil.readDataFromExcel("Contacts", 4, 2);
	String ORGNAME=eutil.readDataFromExcel("Contacts",4 , 3)+jutil.getRandomNumber();


	// Click on Organisations Link
	HomePage hp=new HomePage(driver);
	hp.orgClick();
	// Click on Create Organisation lookup image
	OrgnanisatonsPage op=new OrgnanisatonsPage(driver);
	op.orgLinkClick();
	// Create new organisation name textfield
	CreateNewOrganisationPage cop=new CreateNewOrganisationPage(driver);
	cop.createOrganisation(ORGNAME);
	Assert.fail();
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
	

}
	@Test(groups = "Regression")
	public void demoTest()
	{
		System.out.println("This is Demo");
	}

}
