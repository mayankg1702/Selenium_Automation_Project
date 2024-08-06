package pageObjects;

import org.openqa.selenium.By;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import reusablecomponents.AbstractMethods;

public class SignupPage extends AbstractMethods {
	
	
	WebDriver driver;
	String FirstName = "dmuyqads";
	String LastName = "dMasqdsswqwytrin";
    String ContactNumber = "9932116311";
    String newpassword = "dsMagic1*";
    String confirmpassword = "dsMagic1*"; 
    String dynamictext = RandomStringUtils.randomAlphabetic(6);
    String emailid = dynamictext+"@gmail.com";
	
	@FindBy(id="firstName")
	WebElement firstnm;
	
	@FindBy(id="lastName")
	WebElement Lastnm;
	
	
	@FindBy(id="userEmail")
	WebElement usermail;
	
	
	@FindBy(id="userMobile")
	WebElement mobile;
	
	@FindBy(xpath="//select[@formcontrolname='occupation']")
	WebElement dropdwnlocator;
	
	@FindBy(xpath="//input[@value='Male']")
	WebElement radiobtn;

	@FindBy(xpath="//input[@formcontrolname='required']")
	WebElement requiredbtn;

	@FindBy(id="login")
	WebElement submitbtn;
	
	
	@FindBy(id="userPassword")
	WebElement password;
	

	
	@FindBy(id="confirmPassword")
	WebElement cnfrmpassword;
	
	@FindBy(className="login-wrapper-footer-text")
	WebElement signuplink;


	public SignupPage(WebDriver driver) {
		
		super(driver);

		this.driver =driver;
		
		PageFactory.initElements(driver, this);

	}
	
	
	
	public void getalldetails() {
		
		
		signuplink.click();
		
		firstnm.sendKeys(FirstName);
		Lastnm.sendKeys(LastName);
		usermail.sendKeys(emailid);
		mobile.sendKeys(ContactNumber);
		
	WebElement occupationdrpdwn = dropdwnlocator;
		
		Select dropdown = new Select(occupationdrpdwn);
		dropdown.selectByIndex(3);
		radiobtn.click();
		password.sendKeys(newpassword);
		cnfrmpassword.sendKeys(confirmpassword);
		requiredbtn.click();
		submitbtn.click();		
	}

	
	
	

}
