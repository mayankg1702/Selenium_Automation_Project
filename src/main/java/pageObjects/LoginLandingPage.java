package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablecomponents.AbstractMethods;

public class LoginLandingPage extends AbstractMethods {
	
	WebDriver driver;
	
	public LoginLandingPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="userEmail")
	WebElement useremail;

	@FindBy(id="userPassword")
	WebElement passwordusr;
	

	@FindBy(id="login")
	WebElement loginbtn;
	
	@FindBy(css="[class*='invalid-feedback']")
	WebElement errortext;
	
	
	
	
		public void landingscreen() {
			
			driver.get("https://rahulshettyacademy.com/client");
			
		}
		
        public void landingscreenchildwindows() {
			
			driver.get("https://rahulshettyacademy.com/loginpagePractise/");
			
		}
	
	
		public void LoginCreds(String emailIDofuser, String passwordofuser) {

			useremail.sendKeys(emailIDofuser);
			
			passwordusr.sendKeys(passwordofuser);
			loginbtn.click();
			
		}
		
		public void LoginCredsBlankCase(String email, String passwrd) {

			useremail.sendKeys("makgupta.cool@gmail.com");
			
			passwordusr.sendKeys("");
			loginbtn.click();
			
		}
	
	
		public String errormessage () {
			
			WaitForElementVisibleByWebElement(errortext);
			
			return errortext.getText();
			
			
		}
		
		
	
		
	}
	
	

	
	


