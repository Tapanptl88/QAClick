package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	
	public static ExtentReports extent;
	public static ExtentReports getExtentReport() {
		
		
		
		String reportPath = System.getProperty("user.dir") +"\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(reportPath);
		report.config().setDocumentTitle("Login Test Report");
		report.config().setReportName("Automation Testing Report");
		
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Tapan Patel");
		return extent;
	
	
	}

}
