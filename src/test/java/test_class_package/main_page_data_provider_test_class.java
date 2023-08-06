package test_class_package;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base_class_package.base_class;
import Page_class_package.main_page;
import utilities_class_package.exceldatautil;

public class main_page_data_provider_test_class extends base_class {

	@Test(dataProvider = "logindata")
	public void readexceldata(String name, String sirn, String expected) {
		main_page mp = new main_page(driver);
		mp.username1(name);
		mp.sirname(sirn);
		mp.scrolldown();
		mp.submit();
		String title = driver.getTitle();
		String acttitle = "SignIn";

		if (expected.equals("valid")) {
			if (title.equals(acttitle)) {
				Assert.assertTrue(false);
			} else
				Assert.assertTrue(true);
		}
		if (expected.equals("invalid")) {
			if (title.equals(acttitle)) {
				Assert.assertTrue(false);
			} else
				Assert.assertTrue(true);
		}

	}

	@DataProvider(name = "logindata")
	public String[][] providedata() throws IOException {
		String path = "C:\\Users\\DELL\\eclipse-workspace\\Maven_project_11_march\\src\\main\\java\\Test_data_package\\anildata.xlsx";
		int rownum = exceldatautil.getrowcount(path, "Sheet1");
		int colnum = exceldatautil.getcellcount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colnum];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				logindata[i - 1][j] = exceldatautil.getcelldata(path, "Sheet1", i, j);
			}
		}
		return logindata;

	}
}
