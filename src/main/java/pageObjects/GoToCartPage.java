package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablecomponents.AbstractMethods;

public class GoToCartPage extends AbstractMethods {
	
	
	WebDriver driver;

	public GoToCartPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement gotocart;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	

	
	

	
	public void gotoCartSection() {
		
		gotocart.click();
	}
	
	
	public Boolean checkProductValidation(String ProductName) {
		
		
Boolean match = cartproducts.stream().anyMatch(cartprduct-> cartprduct.getText().equalsIgnoreCase(ProductName));
		
		return match;
		
	
		
	}
	
	
	
	
	
	

}
