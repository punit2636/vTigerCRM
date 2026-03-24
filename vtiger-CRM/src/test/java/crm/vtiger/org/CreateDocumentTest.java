package crm.vtiger.org;

import org.testng.annotations.Test;

import generic_utility.BaseUtility;
import object_repository.CreateDocumentPage;
import object_repository.VerifyDocumentPage;

public class CreateDocumentTest extends BaseUtility {

	@Test
	public void createDocument() throws InterruptedException {
		
			wd.eleToBeClickable(hp.getDoc());
			
			CreateDocumentPage cdp = new CreateDocumentPage(driver);
			
			wd.eleToBeClickable(cdp.getCreateButton());

			String title = "DD"+ju.ranNum();

			wd.eleToBeSeenWait(cdp.getDocTitle()).sendKeys(title);

			cdp.getSaveButton().click();
			
			VerifyDocumentPage vdp = new VerifyDocumentPage(driver);

			String headerText = (wd.eleToBeSeenWait(vdp.getHeader())).getText();

			if (headerText.contains(title)) {
				System.out.println("Test Passed: Document " + title + " created successfully.");
			} else {
				System.out.println("Test Failed: Could not verify ticket creation.");
			}

	}
}