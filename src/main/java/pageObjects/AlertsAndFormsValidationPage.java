package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablecomponents.AbstractMethods;

public class AlertsAndFormsValidationPage extends AbstractMethods {
	
	WebDriver driver;
	
	public AlertsAndFormsValidationPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(css="#alertbtn")
	WebElement Alertbttn;
	
	@FindBy(css="#confirmbtn")
	WebElement cnfrmbttn;
	
	@FindBy(xpath="/html/body/header/div/a/button")
	WebElement homebtn;
	
	@FindBy(xpath="//html/body/app-root/form-comp/div/form/div[1]/input")
	WebElement Namefield;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailfield;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submitbtn;
	
	@FindBy(xpath="/html/body/app-root/form-comp/div/form/div[1]/div")
	WebElement nameErrormsg;
	
	@FindBy(xpath="/html/body/app-root/form-comp/div/form/div[2]/div")
	WebElement emailErrormsg;
	
	@FindBy(id="exampleInputPassword1")
	WebElement passwrdfield;
	
	@FindBy(xpath="/html/body/app-root/form-comp/div/div[2]/div/strong")
	WebElement successformvalidation;
	
	
	
	
	
		public void AlertPagefunction() throws InterruptedException {
			
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");	
			
		}
		
       public void handlingalerts() {
    	   
    	   Alertbttn.click();
			driver.switchTo().alert().accept();
			cnfrmbttn.click();
			driver.switchTo().alert().dismiss();
			
			try {
				
				boolean homebuttonstatus = homebtn.isDisplayed();
				
				if (homebuttonstatus) {
			        System.out.println("Homebutton is displayed.");
			    } else {
			        System.out.println("Homebutton is not displayed.");
			    }
				
			}
			
			catch(NoSuchElementException e) {
				
				
			    System.out.println("Homebutton is not found on the page.");

			}
			
       }
       
       public void formsErrorPage() {
			
			driver.get("https://rahulshettyacademy.com/angularpractice/");	
			
		}
       
       public void FormValidationPage() {

    	   Namefield.click();
    	   emailfield.click();
    	   submitbtn.click();
    	   
       }
       
       public String nameErrorValidation(){
    	   
    	   return nameErrormsg.getText();
    	   
    	   
       }
	
public String emailErrorValidation(){
    	   
    	   return emailErrormsg.getText();
    	   
    	   
       }

public void formSuccessjourney() {
	
	Namefield.sendKeys("mayank gupta");
	emailfield.sendKeys("mayank@test.com");
	passwrdfield.sendKeys("password02");
	 submitbtn.click();
	
}
	
public String formSuccessMessage() {

	
	return successformvalidation.getText();
	
}
       
		
	}
	
	

	
	


