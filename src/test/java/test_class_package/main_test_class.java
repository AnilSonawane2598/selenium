package test_class_package;

import org.testng.annotations.Test;

import Base_class_package.base_class;
import Page_class_package.main_page;
import utilities_class_package.retranlyzer;

public class main_test_class extends base_class {
	@Test(retryAnalyzer = retranlyzer.class)
	public void mainpage() throws InterruptedException {
		main_page mp = new main_page(driver);
		logger.info("enter firstname");
		mp.firstname();
		logger.info("enter lastname");
		mp.lastname();
		logger.info("enter email");
		mp.email();
		logger.info("enter mobile");
		mp.mobile();
		logger.info("select gender");
		mp.gendermale();
		logger.info("select skills");
		mp.skills();
		logger.info("scroll down");
		mp.scrolldown();
		logger.info("select year");
		mp.year();
		logger.info("select month");
		mp.month();
		logger.info("select day");
		mp.day();
		logger.info("click on submit");
		mp.submit();

	}

}
