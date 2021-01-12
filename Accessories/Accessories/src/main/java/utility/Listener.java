package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	public void onFinish(ITestContext result) {
		System.out.println(result.getName() + " - Test Case Finished");

	}

	public void onStart(ITestContext result) {
		System.out.println(result.getName() + " - Test Case Started");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " - Test Case is Failed");

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() + " - Test Case is Skipped");

	}

	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " - Test Case is Started");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " - Test Case is Success");

	}

}
