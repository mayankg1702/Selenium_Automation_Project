package SeleniumWebAutomation.BuildingAutomation;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.E2ERegistrationPage;
import testComponents.basetest;

public class E2EJourneyTest extends basetest {

	@Test
	public void NewRegistrationFlow() {
		
		E2ERegistrationPage regispage = new E2ERegistrationPage(driver);
		regispage.signupform();
		String successmssg = regispage.getSuccessText();
		Assert.assertEquals(successmssg, "Congratulations! Your new account has been successfully created!");
		
	}

}
