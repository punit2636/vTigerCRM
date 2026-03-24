package crm.vtiger.org;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic_utility.BaseUtility;

public class LeadsTest extends BaseUtility {

	@Test(priority = 1)
	void createLead() {
		wd.eleToBeClickable(driver.findElement(By.linkText("Leads")));

		wd.eleToBeClickable(driver.findElement(By.xpath("//img[@title='Create Lead...']")));

		wd.eleToBeSeenWait(driver.findElement(By.name("lastname"))).sendKeys("kumar");

		driver.findElement(By.name("company")).sendKeys("Qspiders");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String vCompany = wd.eleToBeSeenWait(driver.findElement(By.id("dtlview_Company"))).getText();

		if (vCompany.equals("Qspiders")) {
			System.out.println("Lead created");
			Reporter.log("Lead Created");
		} else {
			System.out.println("Lead was not created");
			Reporter.log("Couldn't create lead");
		}
	}

	@Test(priority = 2)
	void deleteLead() throws InterruptedException {

		wd.eleToBeClickable(driver.findElement(By.linkText("Leads")));

		wd.eleToBeSeenWait(driver.findElement(By.name("search_text"))).sendKeys("kumar");

		Select drop = new Select(driver.findElement(By.id("bas_searchfield")));
		drop.selectByVisibleText("Last Name");
		driver.findElement(By.name("submit")).click();

		Thread.sleep(1000);

		wd.eleToBeClickable(driver.findElement(By.linkText("kumar")));

		Thread.sleep(1000);

		wd.eleToBeClickable(driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")));

		Thread.sleep(1000);

		driver.switchTo().alert().accept();

		Thread.sleep(1000);

		wd.eleToBeSeenWait(driver.findElement(By.name("search_text"))).sendKeys("kumar");

		Select dropped = new Select(driver.findElement(By.id("bas_searchfield")));
		dropped.selectByVisibleText("Last Name");
		driver.findElement(By.name("submit")).click();

		Thread.sleep(1000);
		
		List<WebElement> leads = driver.findElements(By.linkText("kumar"));
		
		if (leads.isEmpty()) {
			System.out.println("lead deleted successfully");
			Reporter.log("lead deleted");
		}
		else {
			System.out.println("lead could not be deleted");
			Reporter.log("could not delete lead");
		}

	}

}
