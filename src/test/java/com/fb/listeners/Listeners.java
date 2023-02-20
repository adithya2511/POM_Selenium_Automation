package com.fb.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.fb.base.Base;
import com.fb.utilities.Utility;

public class Listeners extends Base implements ITestListener {
	Utility utility;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println( result.getMethod().getMethodName() + " on Test Start");
		extent.attachReporter(spark);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println( result.getMethod().getMethodName() + " on Test Success");
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		test.pass("Test Method Pass");
		extent.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println( result.getMethod().getMethodName() + " on Test Failure");
		ExtentTest test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Adithya");
		test.fail("Test Method Fail");
		utility = new Utility();  
		String fileName = result.getMethod().getMethodName();
		utility.failedTestCase(fileName);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

}
