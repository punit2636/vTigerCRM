package crm.vtiger.org;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import generic_utility.BaseUtility;
import object_repository.CreateTroubleTicketPage;
import object_repository.VerifyTicketPage;

public class CreateTroubleTicketTest extends BaseUtility  {

	@Test
    public void createTrouble() throws InterruptedException, EncryptedDocumentException, IOException {
        
			CreateTroubleTicketPage ctt = new CreateTroubleTicketPage(driver);
			
			
            
			wd.eleToBeClickable(hp.getTroubleTicket());
			
			wd.eleToBeClickable(ctt.getCreateButton());
			
			String tName = file.getDataFromExcelFile("Trouble", 0, 1)+ju.ranNum();
			
			double contact = file.getNumDataFromExcelFile("Trouble", 1, 1)*ju.ranNum();
			
			String str = String.valueOf((int)contact);
			
            wd.eleToBeSeenWait(ctt.getTicketTitle()).sendKeys(tName);
            
            ctt.getDescription().sendKeys(str);
            
			ctt.getSaveButton().click();
			
			
			
			VerifyTicketPage vtp = new VerifyTicketPage(driver);
			
			String headerText = wd.eleToBeSeenWait(vtp.getHeader()).getText();
            if (headerText.contains(tName)) {
                System.out.println("Test Passed: Trouble Ticket "+tName+" created successfully.");
            } else {
                System.out.println("Test Failed: Could not verify ticket creation.");
            }
}
}