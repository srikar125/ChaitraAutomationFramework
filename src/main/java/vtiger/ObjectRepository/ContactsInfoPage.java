package vtiger.ObjectRepository;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactsInfoPage {
	@FindBy(xpath="//span[@class='dvHeaderText']") private WebElement HeaderTxt;
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getHeaderTxt() {
		return HeaderTxt;
	}
	public String getHeaderText()
	{
		return HeaderTxt.getText();
	}
}
