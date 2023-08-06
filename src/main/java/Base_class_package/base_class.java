package Base_class_package;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import config_class_package.read_config;
import io.github.bonigarcia.wdm.WebDriverManager;

public class base_class {
	public static WebDriver driver;
	public static Logger logger;

	read_config rc = new read_config();
	public String user = rc.getuserid();
	public String password = rc.getpassid();

	@SuppressWarnings({ "deprecation", "static-access" })
	@BeforeMethod(enabled = true)
	@Parameters("browser")
	public void openbrowser(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		PropertyConfigurator.configure(
				"C:\\Users\\DELL\\eclipse-workspace\\Maven_project_11_march\\src\\test\\resources\\configuration_and_logs\\log4j.properties");
		logger = logger.getLogger("open page");
		logger.info("open website");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get(rc.geturl());
	}

	@AfterMethod
	public void closebrowser() {
		logger.info("close website");
		 driver.quit();
	}

}
