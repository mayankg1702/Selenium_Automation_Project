package SeleniumWebAutomation.BuildingAutomation;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.AlertsAndFormsValidationPage;
import testComponents.basetest3;

public class FormsValidation extends basetest3 {
	
	@Test
	public void errorValidation() {
		
		
		AlertsAndFormsValidationPage alert = new AlertsAndFormsValidationPage(driver);
		alert.FormValidationPage();
	
		String NameErrorMessage = alert.nameErrorValidation();
		String EmailErrorMessage = alert.emailErrorValidation();
		Assert.assertEquals(EmailErrorMessage, "Email is required");
		Assert.assertEquals(NameErrorMessage, "Name is required");
		alert.formSuccessjourney();
		String successmessagefinal = alert.formSuccessMessage();
		Assert.assertEquals(successmessagefinal,"Success!");		
		
	}
	
	

}
