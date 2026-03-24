package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyProductPage {
	public VerifyProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement header;
	
	public WebElement getHeader() {
		return header;
	}
	
	
	
}
