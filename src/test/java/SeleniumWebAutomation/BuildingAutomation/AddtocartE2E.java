package SeleniumWebAutomation.BuildingAutomation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Checkoutpage;
import pageObjects.GoToCartPage;
import pageObjects.LoginLandingPage;
import pageObjects.OrderConfirmationPage;
import pageObjects.OrderHistoryPage;
import pageObjects.ProductCataloguePage;
import testComponents.basetest;

public class AddtocartE2E extends basetest{
	
	String ProductName = "ZARA COAT 3";
	// groups= {"Add to Cart flow"}
	@Test (dataProvider = "getData")
	public void addtocartJourney(HashMap<String, String> input) throws InterruptedException, IOException
	{
				
		// first object 
		LoginLandingPage LLP = new LoginLandingPage(driver);
		
		LLP.LoginCreds(input.get("emailID"), input.get("password"));
		
		// second object 
		
		ProductCataloguePage ProductCatalogue = new ProductCataloguePage(driver);
		
		List<WebElement> allproducts = ProductCatalogue.getproductlist();
		ProductCatalogue.productAddtoCart(input.get("product"));
		
		// third object 
		
		GoToCartPage cartpage =  new GoToCartPage(driver);
		cartpage.gotoCartSection();
		
		Boolean match = cartpage.checkProductValidation(input.get("product"));
		
		Assert.assertTrue(match);
		
		//fourth object 
		Checkoutpage chckpg = new Checkoutpage(driver);
		
		chckpg.checkoutPageDetails();
		
		// fivth object 
		
		OrderConfirmationPage cofirmationpg = new OrderConfirmationPage(driver);
		
		String successname = cofirmationpg.getconfirmationtext();
							
					AssertJUnit.assertTrue(successname.equalsIgnoreCase("THANKYOU FOR THE ORDER."));			
		}
	//(dependsOnMethods= {"addtocartJourney"})
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>> data = getJsonFileData("//Users//mayankgupta//eclipse-workspace//BuildingAutomation//src//test//java//testData//testsets.json");
		
		return new Object[][] { {data.get(0)}, {data.get(1)} };
		
		
	}
	

	}