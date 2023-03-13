package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganisationPractice {

	public static void main(String[] args) {
		// Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		// Login to Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		// Click on organisations link
		driver.findElement(By.linkText("Organizations")).click();
		// Click on create organisation look up image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		// Create new organisation with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("ddg");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}

}
