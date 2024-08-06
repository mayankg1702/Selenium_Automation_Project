package reusablecomponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractMethods {
	
	
	
	WebDriver driver;
	
	
	
	//constractor to catch driver variable 
public AbstractMethods(WebDriver driver) {
	
	
	
	this.driver=driver;
	
	}



//reusable methods


public void WaitForElementVisiblebyLocator (By findby)

{
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
}


	public void WaitForElementVisibleByWebElement(WebElement Element)

	{
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		wait.until(ExpectedConditions.visibilityOf(Element));
	

}
public void WaitForElementNotVisible (By findby)

{
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	
	wait.until(ExpectedConditions.invisibilityOfElementLocated(findby));

}


}
