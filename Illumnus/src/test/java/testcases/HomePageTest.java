package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import generic.Locators;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase implements Locators
{

	HomePage home;
	LoginPage login;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		home = new HomePage();
	}
	@Test
	public void HomeTest() throws InterruptedException
	{
	login=home.userSelector();	
	}	
	@AfterMethod
	public void teardown()
	{
	driver.quit();	
	}
}
