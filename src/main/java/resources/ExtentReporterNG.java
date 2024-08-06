package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	
	
	public static ExtentReports getreportObject() {
		
		
		
		String reportpath = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
		
		reporter.config().setReportName("Web Automation reprot");
		
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Mayank Gupta");
		return extent;
		
		
		
		
		
	}
	
	

}
