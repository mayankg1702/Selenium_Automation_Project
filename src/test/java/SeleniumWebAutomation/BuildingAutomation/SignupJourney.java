package SeleniumWebAutomation.BuildingAutomation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginLandingPage;
import pageObjects.SignupPage;
import testComponents.basetest;

public class SignupJourney extends basetest{
	
	//(groups = {"Signup Journey Flow"})
	@Test 
	public void signupflow() throws IOException {
		
		
		SignupPage signjj = new SignupPage(driver);
		
		signjj.getalldetails();
		
		HomePage hmp = new HomePage(driver);
		
		String successmessage = hmp.ValidatesUserSignup();
		
		Assert.assertEquals(successmessage, "Account Created Successfully");
		
		
	}

}
