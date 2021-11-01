package com.testingframework.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testingframework.annotations.FrameworkAnnotation;
import com.testingframework.reports.ExtentLoggers;
import com.testingframework.reports.ExtentReport;
import com.testingframework.utils.ELKUtils;

public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReport();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {

		ExtentReport.flushReport();

	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());

		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).author());

		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLoggers.pass(result.getMethod().getMethodName() + " is Passed.");
		ELKUtils.sendDataToELK(result.getMethod().getDescription(), "Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentLoggers.fail(result.getMethod().getMethodName() + " is Failed.", true);
			ExtentLoggers.fail(result.getThrowable().toString());
			ELKUtils.sendDataToELK(result.getMethod().getDescription(), "Fail");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLoggers.skip(result.getMethod().getMethodName() + " is Skipped.");
		ELKUtils.sendDataToELK(result.getMethod().getDescription(), "Skip");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	/**
	 * Invoked each time a test fails due to a timeout.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 */
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	/**
	 * Invoked before running all the test methods belonging to the classes inside
	 * the &lt;test&gt; tag and calling all their Configuration methods.
	 *
	 * @param context The test context
	 */
	@Override
	public void onStart(ITestContext context) {
		// not implemented
	}

	/**
	 * Invoked after all the test methods belonging to the classes inside the
	 * &lt;test&gt; tag have run and all their Configuration methods have been
	 * called.
	 *
	 * @param context The test context
	 */
	@Override
	public void onFinish(ITestContext context) {
		// not implemented
	}
}
