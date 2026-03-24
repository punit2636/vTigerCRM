package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Documents")
	private WebElement doc;

	public WebElement getDoc() {
		return doc;
	}

	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement profile;

	public WebElement getProfile() {
		return profile;
	}

	@FindBy(linkText = "Sign Out")
	private WebElement signOut;

	public WebElement getSignOut() {
		return signOut;
	}
	@FindBy(linkText = "Trouble Tickets")
	private WebElement troubleTicket;

	public WebElement getTroubleTicket() {
		return troubleTicket;	
	}
	
	@FindBy(linkText = "Products")
	private WebElement product;
	public WebElement getProduct() {
		return product;
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement org;

	public WebElement getOrg() {
		return org;	
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contact;
	public WebElement getContact() {
		return contact;
	}
	

}
