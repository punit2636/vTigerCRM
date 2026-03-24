package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {
	
	public CreateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createBtn;
	public WebElement getCreateBtn() {
		return createBtn;
	}
	
	@FindBy(name="accountname")
	private WebElement orgName;
	public WebElement getOrgName() {
		return orgName;
	}
	
	@FindBy(id="phone")
	private WebElement phone;
	public WebElement getPhone() {
		return phone;
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
}
