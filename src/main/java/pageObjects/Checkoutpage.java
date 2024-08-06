package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablecomponents.AbstractMethods;

public class Checkoutpage extends AbstractMethods {
	
	
	WebDriver driver;

	public Checkoutpage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(css=".totalRow button")
	WebElement checkoutbtn;
	
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement ccvfield;
	
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement namefield;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement countryName;
	
	
	@FindBy(css=".action__submit")
	WebElement submitbtn;

	
	By searchwait = By.cssSelector(".ta-results");
	
	
	
	public void checkoutPageDetails()
	{
		checkoutbtn.click();
		
		ccvfield.sendKeys("323");
		namefield.sendKeys("Mayank Gupta");
		
		Actions Aobj = new Actions(driver);
				
		Aobj.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
		
		WaitForElementVisiblebyLocator(searchwait);
		
		countryName.click();
		submitbtn.click();
	}
	
	
	
	
	

}
