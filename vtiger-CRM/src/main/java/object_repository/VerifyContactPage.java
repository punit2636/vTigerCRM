package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyContactPage {
	
	public VerifyContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastName;
	
	@FindBy(id="dtlview_First Name")
	private WebElement firstName;

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getFirstName() {
		return firstName;
	}
	
	

}
