package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
		public CreateProductPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//img[@title='Create Product...']")
		private WebElement createProduct;
		
		public WebElement getCreateProduct() {
			return createProduct;	
		}
		
		@FindBy(name="productname")
		private WebElement productName;
		
		public WebElement getProductName() {
			return productName;
		}
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveButton;
		public WebElement getSaveButton() {
			return saveButton;
		}
		
}
