package SeleniumWebAutomation.BuildingAutomation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginLandingPage;
import pageObjects.SignupPage;
import testComponents.basetest;

public class ErrorValidations extends basetest{
	
	
	@Test
	public void errorcheck() throws IOException {
		
		//launchApplication();
		
		
		LoginLandingPage LLP = new LoginLandingPage(driver);
		
		
		LLP.LoginCredsBlankCase("email", "passwrd");
		
		String message = LLP.errormessage();
		
		AssertJUnit.assertEquals(message, "*Password is required");
		
	}

}
