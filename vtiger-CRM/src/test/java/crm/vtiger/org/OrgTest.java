package crm.vtiger.org;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic_utility.BaseUtility;
import generic_utility.JavaUtility;
import object_repository.CreateOrgPage;
import object_repository.VerifyOrgPage;

public class OrgTest extends BaseUtility {

	private String name;
	private String phone;
	
	@Test(priority = 1)
	void createOrg() throws InterruptedException {
		
		wd.eleToBeSeenWait(hp.getOrg()).click();

		CreateOrgPage co = new CreateOrgPage(driver);

		System.out.println("Creating organisation...");

		wd.eleToBeSeenWait(co.getCreateBtn()).click();
		JavaUtility jd = new JavaUtility();
		name = "Org" + jd.ranNum();
		wd.eleToBeSeenWait(co.getOrgName()).sendKeys(name);

		phone = String.valueOf(jd.ranNum());
		co.getPhone().sendKeys(phone);

		co.getSaveBtn().click();

		System.out.println("Saving organisation...");

		VerifyOrgPage vp = new VerifyOrgPage(driver);
		String header = wd.eleToBeSeenWait(vp.getOrgName()).getText();
		String num = vp.getPhone().getText();
		if (header.equals(name) && num.equals(phone)) {
			System.out.println("Org creation successful");
			Reporter.log("Org Created");
		} else {
			System.out.println("org creation failed");
			Reporter.log("Org creation failed");
		}

		Thread.sleep(2000);

	}

	@Test(priority = 2)
	void delete() throws InterruptedException {
		
		wd.eleToBeClickable(driver.findElement(By.linkText("Organizations")));

		wd.eleToBeSeenWait(driver.findElement(By.name("search_text"))).sendKeys(name);
		Thread.sleep(1000);
		Select drop = new Select(driver.findElement(By.id("bas_searchfield")));
		drop.selectByVisibleText("Organization Name");
		
		Thread.sleep(1000);
		driver.findElement(By.name("submit")).click();

		WebElement oname = driver.findElement(By.linkText(name));
		wd.eleToBeClickable(oname);
		
		Thread.sleep(2000);

		wd.eleToBeClickable(driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")));
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		wd.eleToBeSeenWait(driver.findElement(By.name("search_text"))).sendKeys(name);
		Select dropped = new Select(driver.findElement(By.id("bas_searchfield")));
		dropped.selectByVisibleText("Organization Name");
		Thread.sleep(1000);
		driver.findElement(By.name("submit")).click();

		Thread.sleep(2000);

		List<WebElement> links = driver.findElements(By.linkText(name));

		if (links.isEmpty()) {
			System.out.println("deleted successfully");
			Reporter.log("Org deleted successfully");
		} else {
			System.out.println("couldn't delete Org");
			Reporter.log("deletion unsuccessful");
		}

	}

}
