package vtiger.ObjectRepository;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class OrganisationInfoPage {
@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement OrgHeaderTxt;
public OrganisationInfoPage(WebDriver driver)
{
	
	PageFactory.initElements(driver,this);
}
public WebElement getOrgHeaderTxt() {
	return OrgHeaderTxt;
}
/**
 * This method will return the Organisation header text
 */
public String headerText()
{
	return OrgHeaderTxt.getText();
}
}
