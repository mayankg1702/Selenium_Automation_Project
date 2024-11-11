package SeleniumWebAutomation.BuildingAutomation;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.AlertsAndFormsValidationPage;
import testComponents.basetest2;

public class AlertsHandlingTest extends basetest2 {
	
	
	@Test
	public void AlertTests() throws InterruptedException
	{
		
		

		AlertsAndFormsValidationPage alert = new AlertsAndFormsValidationPage(driver);
		alert.AlertPagefunction();
		alert.handlingalerts();
		
		
	}
	
	
	

}
