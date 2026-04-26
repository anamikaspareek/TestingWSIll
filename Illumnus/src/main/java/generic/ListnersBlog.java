package generic;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import base.TestBase;

public class ListnersBlog extends TestBase implements ITestListener 

{
	protected static ExtentReports reports;
	 protected static ExtentTest test;
	String filePath = "D:\\SCREENSHOTS";
	
	public void onTestStart(ITestResult result) {
       System.out.println("New Test Started: " + result.getName());
       test = reports.startTest(result.getMethod().getMethodName());
       test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
   }
   public void onTestSuccess(ITestResult result) {
       System.out.println("Test Successfully Finished: " + result.getName());
       test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
   }
   public void onTestFailure(ITestResult result) 
   {
   	test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
   	String str = result.getName();
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			String temp = ScreenShotHandling.getScreenShot(driver, str);
			
			// MarkupHelper is used to display the output in different colors
			//logger.log(Status.FAIL,MarkupHelper.createLabel("Test Case Failed is :"+str, ExtentColor.RED));
			//logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			//try {
			//	logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			//} catch (IOException e) {
			//	// TODO Auto-generated catch block
			//	e.printStackTrace();
			}
		
		Reporter.log("Test Method Failed : "+ str,true);
   }
   
   public void onTestSkipped(ITestResult result) {
       System.out.println("Test Skipped: " + result.getName());
       test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
   }
   public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
       System.out.println("Test Failed but within success percentage: "  + result.getName());
   }
   public void onStart(ITestContext context) {
       System.out.println("This is onStart method: " + context.getOutputDirectory());
       reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
   }
   public void onFinish(ITestContext context) {
       System.out.println("This is onFinish method: " + context.getPassedTests());
       System.out.println("This is onFinish method: " + context.getFailedTests());
       reports.endTest(test);
       reports.flush();
   }

}
