package crm.vtiger.org;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import generic_utility.BaseUtility;
import object_repository.CreateProductPage;
import object_repository.VerifyProductPage;

public class CreateProductTest extends BaseUtility {
	@Test
	public void createProduct() throws InterruptedException, EncryptedDocumentException, IOException {

		wd.eleToBeClickable(hp.getProduct());
		
		CreateProductPage cdp = new CreateProductPage(driver);

		wd.eleToBeClickable(cdp.getCreateProduct());
		
		String pName = file.getDataFromExcelFile("Product", 0, 1)+ ju.ranNum();

		wd.eleToBeSeenWait(cdp.getProductName()).sendKeys(pName);
        
        cdp.getSaveButton().click();
        
        VerifyProductPage vpp = new VerifyProductPage(driver);

        wd.eleToBeSeenWait(vpp.getHeader());
        
        String headerText = vpp.getHeader().getText();
        
        if (headerText.contains(pName)) {
            System.out.println("Test Passed: Product "+pName+" created successfully.");
        } else {
            System.out.println("Test Failed: Could not verify ticket creation.");
        }

	}

}
