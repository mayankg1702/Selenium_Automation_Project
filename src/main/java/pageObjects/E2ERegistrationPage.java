package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import reusablecomponents.AbstractMethods;

public class E2ERegistrationPage extends AbstractMethods {
	
	
	WebDriver driver;

	public E2ERegistrationPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	 String generatestring = RandomStringUtils.randomAlphabetic(6);
	    String Finalstring = generatestring+"@gmail.com";
	
	
	@FindBy(xpath="//button[@title='Continue']")
	WebElement ContinueBtn;
	
	@FindBy(xpath="//input[@id='AccountFrm_firstname']")
	WebElement firstnm;
	
	@FindBy(xpath="//input[@id='AccountFrm_lastname']")
	WebElement lastnm;
	
	@FindBy(xpath="//input[@id='AccountFrm_email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='AccountFrm_telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='AccountFrm_address_1']")
	WebElement address1;
	
	@FindBy(xpath="//input[@id='AccountFrm_city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='AccountFrm_postcode']")
	WebElement postcode;
	
	
	@FindBy(xpath="//input[@id='AccountFrm_loginname']")
	WebElement loginname;
	
	@FindBy(xpath="//input[@id='AccountFrm_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='AccountFrm_confirm']")
	WebElement confirmpsswrd;
	  
	@FindBy(id="AccountFrm_newsletter1")
	WebElement radiobtn;
	  
	@FindBy(id="AccountFrm_agree")
    WebElement privacybtn;
		  
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitbtn;
	
	@FindBy(xpath="//p[text()='Congratulations! Your new account has been successfully created!']")
	WebElement Accntscsmessage;
	
	
	
	
	public void landingpage() {
		
		driver.get("https://automationteststore.com/index.php?rt=account/login");
		
	}
	
	public void signupform() {
		ContinueBtn.click();
		firstnm.sendKeys(generatestring);
		lastnm.sendKeys(generatestring);
		email.sendKeys(Finalstring);
		telephone.sendKeys("939393932");
		address1.sendKeys("delhi india");
		city.sendKeys("delhi");
		WebElement staticdropdown = driver.findElement(By.id("AccountFrm_zone_id"));
		Select dropdown =  new Select(staticdropdown);
		dropdown.selectByIndex(3);
		postcode.sendKeys("110094");
		loginname.sendKeys(generatestring);
		password.sendKeys("password02");
		confirmpsswrd.sendKeys("password02");
		radiobtn.click();
		privacybtn.click();
		submitbtn.click();
		}
	
	public String getSuccessText() {
		return Accntscsmessage.getText();
		
	}
	
	
	
	
	
	
	
	
	

}
