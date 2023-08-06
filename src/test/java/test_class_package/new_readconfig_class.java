package test_class_package;

import org.testng.annotations.Test;

import Base_class_package.base_class;
import Page_class_package.main_page;

public class new_readconfig_class extends base_class {
	@Test
	public void readcommandata() {
		main_page mp = new main_page(driver);
		mp.username1(user);
		mp.sirname(password);
		mp.scrolldown();
		mp.submit();
	}

}
