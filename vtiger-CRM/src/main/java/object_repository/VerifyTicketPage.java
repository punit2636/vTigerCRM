package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyTicketPage {
	public VerifyTicketPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="dtlview_Title")
	private WebElement header;
	public WebElement getHeader() {
		return header;
	}

}

