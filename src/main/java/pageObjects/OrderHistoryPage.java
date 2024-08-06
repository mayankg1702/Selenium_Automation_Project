package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablecomponents.AbstractMethods;

public class OrderHistoryPage extends AbstractMethods {
	
	
	WebDriver driver;

	public OrderHistoryPage(WebDriver driver) {
		
        super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement myordersBtn;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> MyOrdersList;
	
	
	
	
	public void goToMyordersHistory() {
		
		
		myordersBtn.click();
		
	}
	
	
	
	public Boolean checkProductOnMyOrders(String ProductName) {
		
		
Boolean match = MyOrdersList.stream().anyMatch(addedprduct-> addedprduct.getText().equalsIgnoreCase(ProductName));
		
		return match;
	}
}
