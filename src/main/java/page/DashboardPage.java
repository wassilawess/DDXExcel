package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage extends BasePage {
	
	WebDriver driver; // Global

	// Every Page must have a constructor to invite the driver
	public DashboardPage(WebDriver driver) {
	this.driver = driver;
	}

	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement DASHBOARD_ELEMENT_FIELD;
	

	// Methods to interact with the elements
	public void verifyDashBoardElement() {
		Assert.assertEquals(DASHBOARD_ELEMENT_FIELD.getText(), "Dashboard", "Wrong page!!!");
	}

}


