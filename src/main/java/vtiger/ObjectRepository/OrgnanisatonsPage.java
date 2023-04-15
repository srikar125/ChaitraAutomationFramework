package vtiger.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class OrgnanisatonsPage {

	@FindBy(xpath = "//img[@title='Create Organization...']") private WebElement CreateOrgLnk;
//	private WebDriver driver;

	public OrgnanisatonsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getCreateOrgLnk() {
		return CreateOrgLnk;
	}
	
	public void orgLinkClick()
	{
		CreateOrgLnk.click();
	}
}
