package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AlertsAndFormsValidationPage;
import pageObjects.E2ERegistrationPage;
import pageObjects.LoginLandingPage;

public class basetest3 {
	
	
	public WebDriver driver;
	
	public WebDriver intializeDrivers() throws IOException {
	
		
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("/Users/mayankgupta/Documents/Selenium_Advance/Selenium_Automation_Project/src/main/java/resources/GlobalData.properties");
				
				
		prop.load(fis);
		
		String Browsername = prop.getProperty("browser");
		
		if (Browsername.equalsIgnoreCase("chrome"))
		{
		
		
        WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		}
		
		else if (Browsername.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
			
		}
		
else if (Browsername.equalsIgnoreCase("edge")) {
			
	WebDriverManager.edgedriver().setup();
	     driver = new EdgeDriver();
		}
		
		
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
		
	}
    
	

	public List<HashMap<String,String>> getJsonFileData(String filepath) throws IOException {
		
		//read data json to string
		String Jsoncontent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
	
		
		// string to hashmap
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		List<HashMap<String, String>> data = mapper.readValue(Jsoncontent, new TypeReference<List<HashMap<String, String>>>(){	
		});
		return data;
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public WebDriver launchApplication2() throws IOException, InterruptedException {
		
		driver = intializeDrivers();
		
		AlertsAndFormsValidationPage alertp = new AlertsAndFormsValidationPage(driver);
		alertp.formsErrorPage();
		return driver;
	}
	
	@AfterMethod(alwaysRun = true)
	public void closedriver2() {
		
		driver.manage().deleteAllCookies();
		driver.close();
		
	}
}


