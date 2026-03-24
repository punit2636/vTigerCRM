package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	public CreateContactPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createBtn;
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(name="firstname")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/img")
	private WebElement addOrgBtn;

	public WebElement getAddOrgBtn() {
		return addOrgBtn;
	}

	public WebElement getCreateBtn() {
		return createBtn;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	

}
