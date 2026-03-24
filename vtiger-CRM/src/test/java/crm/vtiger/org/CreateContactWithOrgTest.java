package crm.vtiger.org;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseUtility;
import object_repository.CreateContactPage;
import object_repository.CreateOrgPage;
import object_repository.VerifyContactPage;
import object_repository.VerifyOrgPage;

public class CreateContactWithOrgTest extends BaseUtility {

	@Test
	private void createContact() throws InterruptedException {
	
		
		hp.getOrg().click();
		
		Thread.sleep(3000);
		
		CreateOrgPage cp = new CreateOrgPage(driver);
		
		cp.getCreateBtn().click();
		
		Thread.sleep(2000);
		
		String orgName = "Org"+ju.ranNum();
		
		cp.getOrgName().sendKeys(orgName);
				
		cp.getSaveBtn().click();
		
		Thread.sleep(3000);
		
		VerifyOrgPage vp = new VerifyOrgPage(driver);
		
		String verifyOrgName = vp.getOrgName().getText();
		
//		if(orgName.equals(verifyOrgName)) {
//			System.out.println("Organisation: "+orgName+" Created Successfully");
//		}
//		else {
//			System.out.println("Organisation creation failed.....");
//		}
		try {
		    // Perform the check
		    Assert.assertEquals(orgName, verifyOrgName, "Mismatch detected!");
		    
		    // If it passes, this runs:
		    System.out.println("SUCCESS: Organisation names match: " + orgName);

		} catch (AssertionError e) {
		    // If it fails, this runs BEFORE the test stops:
		    System.err.println("FAILURE: Expected " + verifyOrgName + " but found " + orgName);
		    
		    // CRITICAL: You must re-throw the error so Extent Reports 
		    // and TestNG actually know the test failed!
		    throw e; 
		}
		
		Thread.sleep(3000);
		
		CreateContactPage ccp = new CreateContactPage(driver);
		
		hp.getContact().click();
		
		Thread.sleep(3000);
		
		ccp.getCreateBtn().click();

		Thread.sleep(3000);
		
		String lastName = "Kumar"+ju.ranNum();		
		
		ccp.getLastName().sendKeys(lastName);
		
		String mainWindow = driver.getWindowHandle();
		
		ccp.getAddOrgBtn().click();
		
		Thread.sleep(3000);

		wd.switchToWindowByUrl("specific_contact_account_address");
		
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		
		driver.findElement(By.name("search")).click();
		
		Thread.sleep(2000);
		
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		
		for (WebElement element : elements) {
			if (orgName.equals(element.getText())){
				driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
				break;
			}
			
		}
		Thread.sleep(2000);
		
		for (String handle : driver.getWindowHandles()) {
		    if (handle.equals(mainWindow)) {
		        driver.switchTo().window(handle);
		    }
		}
		
		//wd.switchToWindowByUrl("http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		Thread.sleep(2000);
		ccp.getSaveBtn().click();		
		Thread.sleep(3000);
		
		VerifyContactPage vcp = new VerifyContactPage(driver);
		
		String verifyLastName = vcp.getLastName().getText();
		
		try {
			Assert.assertEquals(lastName, verifyLastName, "Last name mismatch, could not be created!");
			//if code passes through assertEquals then success message is printed
			System.out.println("Contact created Successfully with the new Org name");
		}
		catch(AssertionError e){
			System.err.println("FAILURE: Expected " + verifyLastName + " but found " + lastName);
		}
		
//		
//		if(verifyLastName.equals(lastName)) {
//			System.out.println("Contact created successfully");
//		}
//		else {
//			System.out.println("Couldn't create new contact");
//		}


	}

}
