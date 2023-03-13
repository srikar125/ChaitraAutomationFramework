package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule 1
	//Rule 2: Declaration
	@FindBy(name="user_name")
	private WebElement usernametxt;
	@FindBy(name="user_password") 
	private WebElement passwordtxt;
	@FindBy(id="submitButton") 
	private WebElement loginbtn;
	private WebDriver driver;
	//Rule 3: Intialisation
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Rule 4: 
	public WebElement getUsernametxt() {
		return usernametxt;
	}

	public WebElement getPasswordtxt() {
		return passwordtxt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	//Rule 4: Utilisation
	public WebDriver getDriver() {
		return driver;
	}
	//Rule 5: Business Libraries
	/**
	 * This business library will perform login action
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password)
	{
		usernametxt.sendKeys(username);
		passwordtxt.sendKeys(password);
		loginbtn.click();
	}
	
}
