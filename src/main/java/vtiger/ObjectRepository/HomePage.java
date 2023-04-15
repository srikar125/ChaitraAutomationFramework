package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	@FindBy(linkText="Organizations") private WebElement OrganisationsLnk;
	@FindBy(linkText="Contacts") private WebElement ContactsLnk;
	@FindBy(linkText="Opportunities") private WebElement OpportunitiesLnk;
	@FindBy(xpath="//td[@class='genHeaderSmall']/following-sibling::td/img") private WebElement AdminLnk;
	@FindBy(linkText = "Sign Out") private WebElement SignOutLnk;
	//private WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrganisationsLnk() {
		return OrganisationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getAdminLnk() {
		return AdminLnk;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}

	/*
	 * public WebDriver getDriver() { return driver; }
	 */
	
	public void orgClick()
	{
		OrganisationsLnk.click();
	}
	
	public void contactsClick()
	{
		ContactsLnk.click();
	}
	
	public void logoutofApp(WebDriver driver) throws Exception 
	{ 
		mouseHover(driver, AdminLnk);
		SignOutLnk.click();
	}

	
}
