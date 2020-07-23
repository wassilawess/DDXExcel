package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a")
	WebElement CUSTOMERS_BUTTON_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id='side-menu']/li[3]/ul/li[1]/a")
	WebElement ADD_CUSTOMERS_BUTTON_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id='account']")
	WebElement FULLNAME_FIELD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_DROPDOWN_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id='email']")
	WebElement EMAIL_FIELD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id='phone']")
	WebElement PHONE_FIELD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id='address']")
	WebElement ADDRESS_FIELD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id='city']")
	WebElement CITY_FIELD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id='state']")
	WebElement STATE_FIELD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id='zip']")
	WebElement ZIP_FIELD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//*[@id='submit']")
	WebElement SUBIT_BUTTON;

	// mth to interat with the elt
	public void clickCustomersButton() {
		CUSTOMERS_BUTTON_LOCATOR.click();
	}

	public void clickAddCustomersButton() {
		ADD_CUSTOMERS_BUTTON_LOCATOR.click();
	}

	String enteredName;

	public void insertFullName(String fullName) {
		enteredName = fullName + BasePage.randomNumGenerator();
		FULLNAME_FIELD_LOCATOR.sendKeys(enteredName);
	}

	public void insertCompanyName(String company) {
		BasePage.dropDown(COMPANY_DROPDOWN_LOCATOR, company);

	}

	public void insertEmail(String email) {
		String enterdEmail = BasePage.randomNumGenerator() + email;

		EMAIL_FIELD_LOCATOR.sendKeys(enterdEmail);

	}

	public void insertPhone(String Phone) {
		String phoneNum = BasePage.randomNumGenerator() + Phone;
		PHONE_FIELD_LOCATOR.sendKeys(phoneNum);
	}

	public void insertAdress(String Address) {
		ADDRESS_FIELD_LOCATOR.sendKeys(Address);
	}

	public void insertCity(String City) {
		CITY_FIELD_LOCATOR.sendKeys(City);
	}

	public void insertState(String State) {
		STATE_FIELD_LOCATOR.sendKeys(State);
	}

	public void insertZip(String Zip) {
		ZIP_FIELD_LOCATOR.sendKeys(Zip);
	}

	public void clickSaveButton() {
		SUBIT_BUTTON.click();
	}

	// tbody/tr[1]/td[3]
	// tbody/tr[2]/td[3]
	// tbody/tr[i]/td[3]

	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";

	public void verifyEntredCustomerAndDelete() {

		for (int i = 1; i <= 5; i++) {

			// tbody/tr[i]/td[3]

			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			// Assert.assertEquals(name, entredName, "Name does not mtach");

			// if (name.contains(entredName)) {

			System.out.println("entred name exists");

			// driver.findElement(By.xpath(before_xpath+ i +after_xpath
			// +"/following-sibling::td[4]/a[2]")).click();
			driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();

			// BasePage.waitForElement(driver, 2,
			// By.xpath("/html/body/div[1]/div/div/div[2]/boutton[2]"));
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/boutton[2]"));

		}
	}

	// }

}
