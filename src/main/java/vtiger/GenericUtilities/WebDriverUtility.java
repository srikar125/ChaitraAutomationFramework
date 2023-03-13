package vtiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import javax.swing.ActionMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;
import com.google.common.io.Files;

/**
 * This class contains generic methods to perform all webdriver related actions
 * 
 * @author Srikar Reddy
 *
 */
public class WebDriverUtility {
	private static final String ScreenShotName = null;
	private TakesScreenshot driver;

	/**
	 * This method will maximise the window
	 * 
	 * @param driver
	 */
	public void maxmiseWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method will minimise the window
	 * 
	 * @param driver
	 */
	public void minimiseWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method will wait for entire page to load for 20 seconds
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	/**
	 * This method is used to wait for element to be visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will wait for element to be clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This is a custom wait for a second to wait for element to become clickable
	 * 
	 * @param element
	 * @throws Exception
	 */
	public void customWaitForSecond(WebElement element) throws Exception {
		int count = 0;
		while (count < 5) {
			try {
				element.click();
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}

	/**
	 * This method will handle drop down based on Index value
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method will handle drop down based on value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This method will handle drop down based on visibletext
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropDown(String visibletext, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
	}

	/**
	 * This method will perfoem mouse hover action
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		;
	}

	/**
	 * This method will perfoem mouse hover action based on offset
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element, int x, int y) {
		Actions act = new Actions(driver);
		act.moveToElement(element, x, y).perform();
	}

	/**
	 * This method will perform right click randomly on a page
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
		;
	}

	/**
	 * This method will perform right click on specific element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
		;
	}

	/**
	 * This method will perform double click randomly on a page
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
		;
	}

	/**
	 * This method will perform double click on specific element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
		;
	}

	/**
	 * This method will drag and drop from source element to target element
	 * 
	 * @param driver
	 * @param srcElement
	 * @param trgtElement
	 */
	public void dragAndDrop(WebDriver driver, WebElement srcElement, WebElement trgtElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, trgtElement).perform();
	}

	/**
	 * This method will press and elease the enter key
	 * 
	 * @throws Exception
	 */
	public void pressEnterKey() throws Exception {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * This method will switch to frame based on index
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(0);
	}

	/**
	 * This method will switch to frame based on name or id
	 * 
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver, String nameorid) {
		driver.switchTo().frame(nameorid);
	}

	/**
	 * This method will switch to frame based on WebElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method will switch to default frame
	 * 
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method will scroll down for 500 units
	 * 
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)", "");
	}

	/**
	 * This method will scroll down until a particular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		je.executeScript("window.scrollBy(0," + y + ")", element);
	}

	/**
	 * This method will take screenshot and sdave it in screenShots folder
	 * 
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws Exception
	 */
	public String takeScreenShot(WebDriver driver, String ScreenShotName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\" + ScreenShotName + ".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath(); // Used in extent reports
	}
/**
 * This method will switch to window based on ppartial Window Title
 * @param driver
 * @param partialWinTitle
 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		Set<String> allwindows = driver.getWindowHandles();
		for (String Indwindow : allwindows) {
			String currentwinTitle = driver.switchTo().window(Indwindow).getTitle();
			if (currentwinTitle.contains(partialWinTitle)) {
				break;
			}
		}
	}
}
