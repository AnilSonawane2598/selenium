package test_class_package;

import java.io.IOException;

import org.testng.annotations.Test;

import Base_class_package.base_class;
import Page_class_package.broken_links;

public class broken_link_test_class extends base_class {
	@Test
	public void bklinks() throws IOException {
		broken_links bl = new broken_links(driver);
		bl.links();
	}

}
