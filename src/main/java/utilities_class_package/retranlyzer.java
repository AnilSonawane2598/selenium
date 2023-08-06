package utilities_class_package;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retranlyzer implements IRetryAnalyzer {

	public int count = 0;
	public int limit = 1;

	public boolean retry(ITestResult result) {
		if (count < limit) {
			count++;
			return true;
		}
		return false;
	}

}
