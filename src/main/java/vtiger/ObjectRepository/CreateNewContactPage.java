package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{

	@FindBy(name = "lastname") private WebElement lastNameEdit;
	@FindBy(name = "leadsource") private WebElement leadsourceDropDown;
	@FindBy(xpath = "(//img[@title='Select'])[1]") private WebElement orgImg;
	@FindBy(id="search_txt") private WebElement searchEdit;
	@FindBy(name = "search") private WebElement searchBtn;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement saveBtn;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getLastNamEdit() {
		return lastNameEdit;
	}

	public WebElement getLeadsourceDropDown() {
		return leadsourceDropDown;
	}

	public WebElement getOrgImg() {
		return orgImg;
	}

	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/**
	 * This method will create new contact with last name
	 * @param lastname
	 */
	public void createNewContact(String lastname)
	{
		lastNameEdit.sendKeys(lastname);
		saveBtn.click();
	}
	/**
	 * This method will create new contact with organisation
	 * @param lastname
	 * @param orgName
	 * @param driver
	 */
	public void createNewContact(String lastname,String orgName,WebDriver driver)
	{
		lastNameEdit.sendKeys(lastname);
		orgImg.click();
		switchToWindow(driver, "Accounts");
		searchEdit.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
}
