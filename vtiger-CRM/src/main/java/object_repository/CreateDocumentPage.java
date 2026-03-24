package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDocumentPage {
	public CreateDocumentPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//img[@title='Create Document...']")
	private WebElement createButton;
	public WebElement getCreateButton() {
		return createButton;
		
	}
	
	@FindBy(name="notes_title")
	private WebElement docTitle;
	public WebElement getDocTitle() {
		return docTitle;
		
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
}
