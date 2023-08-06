package Page_class_package;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class main_page {
	public static WebDriver driver;

	@SuppressWarnings("static-access")
	public main_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstname;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastname;

	@FindBy(xpath = "//input[@type='email']")
	WebElement email;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement mobile;

	@FindBy(xpath = "//input[@value='Male']")
	WebElement Gendermale;

	@FindBy(xpath = "//select[@id='Skills']//option")
	List<WebElement> skill;

	@FindBy(xpath = "//select[@id='yearbox']")
	WebElement year;

	@FindBy(xpath = "(//select[@type=\"text\"])[4]//option")
	List<WebElement> month;

	@FindBy(xpath = "(//select[@type=\"text\"])[5]//option")
	List<WebElement> day;

	@FindBy(xpath = "//input[@id='imagesrc']")
	WebElement selectfile;

	@FindBy(xpath = "//label[normalize-space()='Skills']")
	WebElement javascript;

	@FindBy(xpath = "//button[@id='submitbtn']")
	WebElement submit;

	public void firstname() {
		firstname.sendKeys("anil");
	}

	public void lastname() {
		lastname.sendKeys("sonawane");
	}

	public void email() {
		email.sendKeys("gsdfsdf35@gmail.com");
	}

	public void mobile() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + "8830163791" + "';", mobile);
	}

	public void gendermale() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Gendermale);
	}

	public void skills() {

		for (int i = 0; i < skill.size(); i++)
			if (skill.get(i).getText().equals("APIs"))
				skill.get(i).click();

	}

	public void year() {
		Select s = new Select(year);
		s.selectByVisibleText("1996");
	}

	public void month() {
		for (int i = 0; i < month.size(); i++) {
			String months = month.get(i).getText();
			if (months.equals("July")) {
				month.get(i).click();
			}
		}
	}

	public void day() {
		for (int i = 0; i < day.size(); i++) {
			String days = day.get(i).getText();
			if (days.equals("8")) {
				day.get(i).click();
			}
		}
	}

	public void selectfile() {
		String source = "D:\\Other File\\RESUME\\introduction.pdf";
		selectfile.sendKeys(source);
	}

	public void scrolldown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", javascript);
	}

	public void submit() {
		submit.click();
	}

	public void username1(String user) {
		firstname.sendKeys(user);
	}

	public void sirname(String sir) {
		lastname.sendKeys(sir);
	}

}
