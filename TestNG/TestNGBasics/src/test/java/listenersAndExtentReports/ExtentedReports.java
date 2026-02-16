package listenersAndExtentReports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentedReports implements ITestListener{
	ExtentSparkReporter sparkReport;
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		sparkReport = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myreport.html");
		
		sparkReport.config().setDocumentTitle("Automation Report");
		sparkReport.config().setReportName("Functional Testing");
		sparkReport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(sparkReport);
		
		report.setSystemInfo("Computer Name", "localHost");
		report.setSystemInfo("Environment", "local");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.PASS, "Test case passed with name : "+result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.FAIL, "Test case passed with name : "+result.getName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.SKIP, "Test case passed with name : "+result.getName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
