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
import pageObjects.WindowhandlesPage;
import testComponents.basetest;

public class ChildwindowHandlings extends basetest{
	
	
 
	@Test (groups = {"Child Window handles"})
	public void Childwindowscheck() throws IOException {		
		
		
		WindowhandlesPage childpage = new WindowhandlesPage(driver);
		
		childpage.CheckWindowHandles();
		
	}

}
