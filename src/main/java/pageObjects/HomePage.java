package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import reusablecomponents.AbstractMethods;

public class HomePage extends AbstractMethods {
	

	WebDriver driver;
	

	public HomePage(WebDriver driver) {
		
		super(driver);

		this.driver =driver;
		
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(css=".headcolor")
	WebElement Accountcreated;
	
	
public String ValidatesUserSignup () {
	
	
	
	return Accountcreated.getText();
	
	
}
	


}
