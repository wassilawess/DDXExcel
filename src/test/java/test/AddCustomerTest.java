package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.BasePage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest extends BasePage {
	
	WebDriver driver;

 
	ExcelReader reader = new ExcelReader("./Data/TF_TestData.xlsx");
	
	String userName = reader.getCellData("LoginInfo", "UserName", 2);   
	String Password = reader.getCellData("LoginInfo", "Password", 2);   

	String fullName = reader.getCellData("AddContactInfo", "FullName", 2);   
	String Company  = reader.getCellData("AddContactInfo", "CompanyName", 2);   
	String Email  = reader.getCellData("AddContactInfo", "Email", 2);   
	String Phone  = reader.getCellData("AddContactInfo", "Phone", 2);   
	String Address  = reader.getCellData("AddContactInfo", "Address", 2);   
	String City  = reader.getCellData("AddContactInfo", "City", 2);   
	String State  = reader.getCellData("AddContactInfo", "State", 2);   
	String Zip  = reader.getCellData("AddContactInfo", "Zip", 2);   
 
	@Test
  public void  ValidUserShouldBeAbleToAddCustomer() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(Password);
		loginPage.clinkSignButton();
		
		//DashboardPage dash = PageFactory.initElements(driver, DashboardPage.class);
		//dash.isDashboardDisplayed();
		
	  
		AddCustomerPage cos = PageFactory.initElements(driver, AddCustomerPage.class); 
		cos.clickCustomersButton();
		cos.clickAddCustomersButton();
		
		Thread.sleep(2000);
		
		cos.insertFullName(fullName);
		cos.insertCompanyName(Company);
		cos.insertEmail(Email);
		cos.insertPhone(Phone);
		cos.insertAdress(Address);
		cos.insertCity(City);
		cos.insertState(State);
		cos.insertZip(Zip);
		cos.clickSaveButton();
	  
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
