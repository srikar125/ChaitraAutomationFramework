package vtiger.GenericUtilities;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to OTestListner Interface of TestNG
 * @author Srikar Reddy
 *
 */
public class ListnersImplementation implements ITestListener {
	public ExtentReports report;
	public ExtentTest test;
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println("This "+methodName+" is Started");
		 test=report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
	//	System.out.println("This "+methodName+" is Successful");
		test.log(Status.PASS, methodName+"--> Sucess");
	}

	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
	//	System.out.println("This "+methodName+" is Failed");
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		String screenShotName=methodName+"-"+jutil.getSysemDateInFormat();
		try {
			String path=wutil.takeScreenShot(BaseClass.sdriver, screenShotName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(result.getThrowable());
		test.log(Status.FAIL, methodName+"--> Failed");
		test.log(Status.FAIL, result.getThrowable());
	
	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
	//	System.out.println("This "+methodName+" is Skipped");
	//	System.out.println(result.getThrowable());
		test.log(Status.SKIP, methodName+"--> Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
		//Configure Extent report
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report"+new JavaUtility().getSysemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Executon Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Vtiger Execution Report");
		//Attatch HTML report to extent Reports
		ExtentReports report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Base URL", "http://localhost:8888/");
		report.setSystemInfo("Author","Chaitra");
		
		
		
	System.out.println("Execution Started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution Finished");
		report.flush();
		
	}

	

	
}
