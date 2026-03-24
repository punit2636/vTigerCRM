package generic_utility;

import java.io.IOException;

//import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import object_repository.HomePage;
import object_repository.LoginPage;

public class BaseUtility {

	protected WebDriver driver;
	protected WebDriverUtility wd;
	// protected String name;
	// protected String phone;
	protected String fName;
	protected String lName;
	protected HomePage hp;
	protected JavaUtility ju;
	protected FileUtility file;

	@BeforeClass
	public void openBrowser() throws IOException {

		file = new FileUtility();

		String BROWSER = file.getDataFromPropertyFile("bro");
		String WEBSITE = file.getDataFromPropertyFile("url");

		
		
		if (BROWSER.equals("chrome")) {
			
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless=new"); // The magic line
			//options.addArguments("--window-size=1920,1080"); // Important for headless stability
			driver = new ChromeDriver();
		
		}
		else if (BROWSER.equals("edge"))
			driver = new EdgeDriver();
		else if (BROWSER.equals("firefox"))
			driver = new FirefoxDriver();
		else {
			throw new RuntimeException("Invalid browser name provided: " + BROWSER);
		}

		hp = new HomePage(driver);
		wd = new WebDriverUtility(driver);
		ju = new JavaUtility();

		wd.maximizeWindow();
		wd.implicitlyWait();
		driver.get(WEBSITE);

	}

	@BeforeMethod
	public void login() throws InterruptedException, IOException {
		
		String USERNAME = file.getDataFromPropertyFile("un");
		String PASSWORD = file.getDataFromPropertyFile("pwd");
		
		
		LoginPage lp = new LoginPage(driver);

		wd.eleToBeSeenWait(lp.getUn()).sendKeys(USERNAME);
		lp.getPwd().sendKeys(PASSWORD);
		wd.eleToBeClickable(lp.getLoginBtn());

		Thread.sleep(3000);

	}

	@AfterMethod
	public void logout() throws InterruptedException {

		wd.hoverOverElement(wd.eleToBeSeenWait(hp.getProfile()));
		wd.eleToBeSeenWait(hp.getSignOut()).click();
		Thread.sleep(2000);
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
