package utilities_class_package;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base_class_package.base_class;

public class listenerstestng extends base_class implements ITestListener {
	ExtentTest test;
	ExtentReports extent = extendreportertestng.getReportObject();

	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		// Extent Report //10
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		// Extent Report //pass
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {

		extentTest.get().fail(result.getThrowable());

		String testmethodname = result.getMethod().getMethodName();

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(genericutil.getScreenshotAs(testmethodname, driver),
					result.getMethod().getMethodName());
		} catch (Exception a) {
			a.printStackTrace();
		}

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
