package SeleniumWebAutomation.BuildingAutomation;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginLandingPage;

public class Standalone {
	
	
	
	public static void main (String[] args) throws InterruptedException
	{
		String ProductName = "ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		
		driver.get("https://rahulshettyacademy.com/client");
		
		LoginLandingPage LLP = new LoginLandingPage(driver);
		
		
		driver.findElement(By.id("userEmail")).sendKeys("makgupta.cool@gmail.com");
		
		driver.findElement(By.id("userPassword")).sendKeys("dsMayank1*");
        
		driver.findElement(By.id("login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> allproducts = driver.findElements(By.cssSelector(".mb-3"));
		
		//use of Java Streams
		
		WebElement finalprod = allproducts.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		
		finalprod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		//Thread.sleep(20000);

		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
		
		//Thread.sleep(20000);
		
		
		//match all products with local string value - String ProductName = "ZARA COAT 3";
		
		List <WebElement> carproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean match = carproducts.stream().anyMatch(cartprdt-> cartprdt.getText().equalsIgnoreCase(ProductName));
		
		Assert.assertTrue(match);
		

	
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
		driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys("231");
		
		driver.findElement(By.xpath("(//input[@type=\"text\"])[3]")).sendKeys("Mayank Gupta");

		
					Actions Aobj = new Actions(driver);
					
					
					// use of action class for auto suggested dropdowns
					
					Aobj.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
					
					driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
					driver.findElement(By.cssSelector(".action__submit")).click();

							
					String SuccessMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
					
					Assert.assertTrue(SuccessMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
					driver.close();
					
			
		}
		
		
		

	}
	
	
	

