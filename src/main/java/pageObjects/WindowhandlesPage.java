package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablecomponents.AbstractMethods;

public class WindowhandlesPage extends AbstractMethods {
	
	WebDriver driver;

	public WindowhandlesPage(WebDriver driver) {
		super(driver);

		
		this.driver =driver;
		
		PageFactory.initElements(driver, this);
	
	}
	
	
	
	@FindBy(linkText="Free Access to InterviewQues/ResumeAssistance/Material")
	WebElement linktext;
	
	@FindBy(css=".im-para.red")
	WebElement emailtext;
	
	
	public void CheckWindowHandles() {
		
		linktext.click();
		
		Set<String> windows = driver.getWindowHandles();		
		Iterator <String> it = windows.iterator();
				
			String parentID =	it.next();
			String ChildID =	it.next();
			
			driver.switchTo().window(ChildID);
			
			
			//Java String parse and split, very good example
			String emailId= emailtext.getText().split("at")[1].trim().split(" ")[0];
			
			driver.switchTo().window(parentID);

			driver.findElement(By.id("username")).sendKeys(emailId);
		
		
		
	}
	
	
	

}
