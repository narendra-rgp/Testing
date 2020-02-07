package nari.framework;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass  {
	static ExtentHtmlReporter html;
	static ExtentReports report;
	static ExtentTest test;
	
	@BeforeSuite
	public static void beforeSuite() throws IOException {
		html = new ExtentHtmlReporter("Reports//s.html");
		report = new ExtentReports();
		report.attachReporter(html);
		
	}
	@BeforeClass
	public static void BeforeClass() throws IOException {
		
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
        Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");                         
       
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

        Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
	}
	@BeforeMethod
	public static void beforemethod(Method method) throws IOException {
		
		String val = method.getName();
		test = report.createTest(val);
		
	}
	@AfterMethod
	public static void aftermethod(ITestResult result) {
		
		switch (test.getStatus()) {
		case PASS:
			test.log(Status.PASS, MarkupHelper.createLabel("The Test ' " + result.getMethod().getMethodName()+ " is passed", ExtentColor.BLUE));
			break;
		case DEBUG:
		case FAIL:
			test.log(Status.FAIL, MarkupHelper.createLabel("The Test "+result.getMethod().getMethodName()+"is Failed", ExtentColor.RED));
			break;
		default:
			break;
		}
		
	}
	public static void writeLog(String status, String stepName, String actualResult) {
		Status stepStatus;
		
		switch (status.toLowerCase()) {
			case "pass":
				stepStatus= Status.PASS;
				break;
			case "fail":
	
				stepStatus=Status.FAIL;
				break;
			
			case "warning":
				stepStatus=Status.WARNING;
				break;	
			
			default:
				stepStatus=Status.INFO;
				break;
			
		}
		 
		test.log(stepStatus, "Step Name : " + stepName + '\n'+ "; Actual Result : " + actualResult); 
		 
	}
	@AfterSuite(alwaysRun = true)
	public static void aftersuite() {
		//Data.driver.quit();
		report.flush();		
	}
}
