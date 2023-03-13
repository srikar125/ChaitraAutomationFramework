package vtiger.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ContaactsPage {

	@FindBy(xpath = "//img[@title='Create Contact...']") private WebElement createContactLookupImg;
	
	public ContaactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactLookupImg() {
		return createContactLookupImg;
	}
	/**
	 * This method will click on create contact Look up image
	 */
	public void clickOnCreateContact()
	{
		createContactLookupImg.click();
	}
}
