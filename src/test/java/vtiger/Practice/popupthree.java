package vtiger.Practice;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.checkerframework.framework.qual.DefaultQualifier.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.google.protobuf.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.WebDriverUtility;

public class popupthree {
	public WebDriver driver;
	@Test
	public void mone() throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.waitForPageLoad(driver);
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='webengage-engagement-callback-frame']")));
		Thread.sleep(5000);
		wutil.doubleClick(driver);
		Thread.sleep(5000);
	    driver.switchTo().defaultContent();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//span[text()='From']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("mum",Keys.DOWN,Keys.ENTER);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//span[text()='To']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("che");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(Keys.DOWN,Keys.ENTER);
	    driver.findElement(By.xpath("//div[@aria-label='Tue Mar 28 2023']")).click();
	    driver.quit();

	}

}
