package Page_class_package;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.utility.RandomString;

public class all_selenium_mode {
	public WebDriver driver;

	public all_selenium_mode(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@id='imagetrgt']")
	WebElement img;

	@FindBy(xpath = "//h1[normalize-space()='Automation Demo Site']")
	WebElement title;

	public void takescreenshot() {
		String path = "C:\\Users\\DELL\\eclipse-workspace\\Maven_project_11_march\\src\\test\\resources\\perticular_element_SS\\";
		String s = "autoimage";
		String s1 = RandomString.make(2);
		File source = ((TakesScreenshot) img).getScreenshotAs(OutputType.FILE);
		File dest = new File(path + s + s1 + ".jpg");
		try {
			FileHandler.copy(source, dest);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	String y = "//select[@id='yearbox']//option";

	@FindBy(xpath = "//select[@placeholder='Month']")
	WebElement month;

	String b = "1990/June/4";
	String c[] = b.split("/");

	public void handlelistbox(String str, String s) {
		List<WebElement> year = driver.findElements(By.xpath(str));
		System.out.println(year.size());
		for (int i = 0; i < year.size(); i++) {
			String data = year.get(i).getText();
			System.out.println(data);
			if (data.equals(s)) {
				year.get(i).click();
			}
		}

	}

	public void listbox() {
		all_selenium_mode am = new all_selenium_mode(driver);
		am.handlelistbox(y, c[0]);
	}

	public void verifytitle() {
		System.out.println("website main title text is:-->" + title.getText());
		String s = "Automation Demo Site ";
		if (title.getText().equals(s)) {
			System.out.println("correct title");
		} else
			System.out.println("wrong title");

	}

	public void month(WebElement ele, String data) {
		Select sl = new Select(ele);
		sl.selectByVisibleText(data);

	}

	public void month2() {
		Select sl = new Select(month);

		List<WebElement> mt = sl.getOptions();
		for (int i = 0; i < mt.size(); i++) {
			String months = mt.get(i).getText();
			System.out.println(months);
			if (months.equals("September")) {
				mt.get(i).click();
			}
		}

	}

	public void selectmonth() {
		all_selenium_mode am = new all_selenium_mode(driver);
		am.month(month, c[1]);
	}

	public void selectday() {
		List<WebElement> day = driver.findElements(By.xpath("//select[@id='daybox']//option"));
		System.out.println(day.size());

		for (int i = 0; i < day.size(); i++) {
			if (day.get(i).getText().equals("9")) {
				day.get(i).click();

			}
		}

	}
}
