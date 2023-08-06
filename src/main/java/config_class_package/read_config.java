package config_class_package;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class read_config {
	Properties pro;

	public read_config() {
		String s = "C:\\Users\\DELL\\eclipse-workspace\\Maven_project_11_march\\src\\test\\resources\\configuration_and_logs\\config.properties";
		File f = new File(s);
		pro = new Properties();
		try {
			FileInputStream file = new FileInputStream(f);
			try {
				pro.load(file);

			} catch (Exception t) {

			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public String geturl() {
		return pro.getProperty("url");
	}

	public String getuserid() {
		return pro.getProperty("userid");
	}

	public String getpassid() {
		return pro.getProperty("passid");
	}

	public String getchromedriver() {
		return pro.getProperty("chromedriver");
	}

	public String getmsedgedriver() {
		return pro.getProperty("edgedriver");
	}

}
