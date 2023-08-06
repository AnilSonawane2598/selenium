package test_class_package;

import org.testng.annotations.Test;

import Base_class_package.base_class;
import Page_class_package.all_selenium_mode;

public class new_Ttest_class extends base_class {
	@Test
	public void a() throws InterruptedException {
		all_selenium_mode am = new all_selenium_mode(driver);
		logger.info("select year");
		am.listbox();
		logger.info("take screenshot");
		am.takescreenshot();
		logger.info("veriy text");
		am.verifytitle();
		am.selectday();
	//	am.selectmonth();
		am.month2();
		Thread.sleep(4000);
		

	}

}
