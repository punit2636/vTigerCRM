package generic_utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

public class WebDriverUtility {

	private WebDriver driver;
	private Actions actions;
	private JavascriptExecutor js;
	private WebDriverWait wait;

	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
		//System.out.println("Window maximized.");
	}
	
	public void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public void setFullScreen() {
		driver.manage().window().fullscreen();
		//System.out.println("Window set to full screen.");
	}

	public void hoverOverElement(WebElement element) {
		actions.moveToElement(element).perform();
		//System.out.println("Hovered over element.");
	}

	// Standard click over Actions click
	public void leftClick(WebElement element) {
		element.click();
		//System.out.println("Left clicked on element.");
	}

	public void rightClick(WebElement element) {
		actions.contextClick(element).perform();
		//System.out.println("Right clicked on element.");
	}

	public void doubleClick(WebElement element) {
		actions.doubleClick(element).perform();
		//System.out.println("Double clicked on element.");
	}

	public void clickAndHold(WebElement element) {
		actions.clickAndHold(element).perform();
		//System.out.println("Clicked and held element.");
	}

	public void releaseElement(WebElement element) {
		actions.release(element).perform();
		//System.out.println("Released element.");
	}

	public void scrollIntoView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollByOffset(int x, int y) {
		js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	}

	public void captureScreenshot(WebDriver driver, String fileName) throws IOException {
		Random rand = new Random();
		int randomNumber = rand.nextInt(1000000);

		// NOTE: Use double backslashes for Windows paths
		String folderPath = "C:\\Users\\punit\\Pictures\\SeleniumSS\\";

		// Combine folder path + filename + random number + extension
		String destinationPath = folderPath + fileName + "_" + randomNumber + ".png";

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(destinationPath);

		// This will now save 'GooglePage_84920.png' INSIDE the folder
		FileHandler.copy(source, destination);

		System.out.println("Screenshot saved at: " + destinationPath);
	}

	public void takeElementScreenshot(WebElement element, String filePath) throws IOException {
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filePath);
		FileHandler.copy(srcFile, destFile); // This line can throw IOException
		System.out.println("Element screenshot saved at: " + filePath);
	}

	public void safeJavaScriptClick(WebElement element) {
		js.executeScript("arguments[0].click();", element);
		//System.out.println("Performed JavaScript click.");
	}

	public void javaScriptSendKeys(WebElement element, String value) {
		js.executeScript("arguments[0].value = arguments[1];", element, value);
		//System.out.println("Value entered via JS.");
	}

	public boolean switchToWindowByTitle(String targetTitle) {
		String originalWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {
			driver.switchTo().window(windowHandle);
			if (driver.getTitle().contains(targetTitle)) {
				System.out.println("Switched to window with title: " + targetTitle);
				return true;
			}
		}
		driver.switchTo().window(originalWindow);
		System.out.println("Window with title '" + targetTitle + "' not found.");
		return false;
	}
	

	public void sendKeysByAction(String ch) {
		
		actions.pause(1000).sendKeys(ch).perform();
	}



	public boolean switchToWindowByUrl(String partialUrl) {
		String originalWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {
			driver.switchTo().window(windowHandle);
			if (driver.getCurrentUrl().contains(partialUrl)) {
				System.out.println("Switched to window with URL containing: " + partialUrl);
				return true;
			}
		}
		driver.switchTo().window(originalWindow);
		return false;
	}

	public void closeAllChildWindows() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				driver.close();
				System.out.println("Closed child window: " + windowHandle);
			}
		}
		driver.switchTo().window(parentWindow);
	}
	
	public WebElement eleToBeSeenWait(WebElement element) {
		WebElement we =wait.until(ExpectedConditions.visibilityOf(element));
		return we;
		
	}
	
	public void eleToBeSeenWait(WebElement element, String keys) {
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(keys);		
		
	}
	
	public void eleToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

}