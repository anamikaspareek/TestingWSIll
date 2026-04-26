package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import generic.CommonMethods;
import generic.Locators;
import pages.Dashboard;
import pages.HomePage;
import pages.LoginPage;


public class LoginPageTest extends TestBase implements Locators{

	LoginPage loginpage;
	Dashboard dashboard;
	HomePage home;
	 public LoginPageTest() {
			
		
			super();
		}
		
	@BeforeMethod
	public void setup()
	{
		initialization();
		home = new HomePage();
		home.userSelector();
		loginpage = new LoginPage();
		
	}
	@DataProvider
	public Object[][] getLoginData()
	{
		Object data [][]=CommonMethods.getTestData("Login");
	return data;
	}
	@Test(dataProvider="getLoginData")
	public void loginTest(String ddt_username,String ddt_password) throws InterruptedException
	{
	dashboard=loginpage.loginfunction(ddt_username,ddt_password);	
	}
	@AfterMethod
	public void teardown()
	{
	driver.quit();	
	}
	}


