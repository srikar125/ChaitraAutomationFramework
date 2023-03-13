package vtiger.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
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
public class CreateContactWithOrganisationPOMBaseReporterLog extends BaseClass {

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
	Reporter.log("Organisation is clicked", true);
	// Click on Create Organisation lookup image
	OrgnanisatonsPage op=new OrgnanisatonsPage(driver);
	op.orgLinkClick();
	Reporter.log("Create Organisation lool up image is clicked", true);
	// Create new organisation name textfield
	CreateNewOrganisationPage cop=new CreateNewOrganisationPage(driver);
	cop.createOrganisation(ORGNAME);
	Reporter.log("Organisation is clicked", true);
	//Validate Organisation
	OrganisationInfoPage oip=new OrganisationInfoPage(driver);
	String OrgHeader=oip.headerText();
	Reporter.log("Organisation is created", true);
	Assert.fail();
	Assert.assertTrue(OrgHeader.contains(ORGNAME));	
	hp.contactsClick();
	ContaactsPage cp=new ContaactsPage(driver);
	cp.clickOnCreateContact();
	Reporter.log("Create Contact link is clcked", true);
	CreateNewContactPage cnop=new CreateNewContactPage(driver);
	cnop.createNewContact(LASTNAME, ORGNAME, driver);
	Reporter.log("New Contact with organisation is created", true);
	ContactsInfoPage cip=new ContactsInfoPage(driver);
	String ContactHeader=cip.getHeaderText();
	Assert.assertTrue(ContactHeader.contains(LASTNAME));
		

}

}
