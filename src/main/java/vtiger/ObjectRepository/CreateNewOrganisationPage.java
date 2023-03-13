package vtiger.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;
public class CreateNewOrganisationPage extends WebDriverUtility{

	@FindBy(name = "accountname") private WebElement acctNameEdt;
	@FindBy(xpath =  "//input[@title='Save [Alt+S]']") private WebElement saveBtn;
	@FindBy(name = "industry") private WebElement industryDropDown;
	private WebDriver driver;
	public CreateNewOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getAcctNameEdt() {
		return acctNameEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebDriver getDriver() {
		return driver;
	}
	
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	public void setIndustryDropDown(WebElement industryDropDown) {
		this.industryDropDown = industryDropDown;
	}
	/**
	 * This method will create Organisation with mandatory details
	 * @param OrgName
	 */
    public void createOrganisation(String OrgName)
    {
    	acctNameEdt.sendKeys(OrgName);
    	saveBtn.click();
    }
    /**
     *  This method will create Organisation with industry drop down
     * @param OrgName
     * @param IndustryType
     */
    public void createOrganisation(String OrgName,String IndustryType)
    {
    	acctNameEdt.sendKeys(OrgName);
    	handleDropDown(industryDropDown, IndustryType);
    	saveBtn.click();
    }
    
	
}
