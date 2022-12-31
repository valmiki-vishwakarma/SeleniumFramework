package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.TestBase;
import utilities.Screenshot;

public class customListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {

		// ExtentManager.createTest(result.getMethod().getMethodName());
		test = rep.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "Started executing test : " + result.getMethod().getMethodName());

		System.out.println("FROM LISTENER: Started executing test: " + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// test =rep.createTest("", "");
		test.log(Status.PASS, "Test Case Name: " + result.getMethod().getMethodName() + " Passed.");
		System.out.println("FROM LISTENER: Test Case: " + result.getMethod().getMethodName() + " PASSED");
		rep.flush();

	}

	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot.getBase64()).build());
		test.log(Status.FAIL, "Test Case Name: " + result.getMethod().getMethodName() + " Failed.");
		rep.flush();

	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		// ExtentManager.initReports();

	}

	public void onFinish(ITestContext context) {

	}

}