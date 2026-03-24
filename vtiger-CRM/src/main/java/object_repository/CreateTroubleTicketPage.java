package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTroubleTicketPage {
	public CreateTroubleTicketPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//img[@title='Create Ticket...']")
	private WebElement createButton;
	public WebElement getCreateButton() {
		return createButton;
		
	}
	
	@FindBy(name="ticket_title")
	private WebElement ticketTitle;
	public WebElement getTicketTitle() {
		return ticketTitle;
		
	}
	
	@FindBy(name="description")
	private WebElement description;
	public WebElement getDescription() {
		return description;
		
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
}