package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablecomponents.AbstractMethods;

public class ProductCataloguePage extends AbstractMethods {
	
	WebDriver driver;
	public ProductCataloguePage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css=".mb-3")
	List<WebElement> allproducts;
	
	By productsby = By.cssSelector(".mb-3");
	
	By AddtoCart = By.cssSelector(".card-body button:last-of-type");
	
	By toastmessage = By.cssSelector("#toast-container");
	
	By loader = By.cssSelector(".ng-animating");
	
	
	
	// action method to return all our products
	public List<WebElement> getproductlist() {
		
		
		WaitForElementVisiblebyLocator(productsby);
		return allproducts;
		
			
		}
	
	// action method to get product by name 
	public WebElement getproductByname (String ProductName) {
		
		
		WebElement finalprod = getproductlist().stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
          return finalprod;
			
	}
	// action method to get product add to cart  

	public void  productAddtoCart (String ProductName ) {
		
		WebElement finalprod = getproductByname(ProductName);
		
		finalprod.findElement(AddtoCart).click();
		
		WaitForElementVisiblebyLocator(toastmessage);
		WaitForElementNotVisible(loader);

	
	}
	
	
	
	
	
	
	
	
		
	}
	
	

	
	


