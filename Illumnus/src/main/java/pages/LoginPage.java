package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import generic.CommonMethods;
import generic.Locators;

public class LoginPage extends TestBase implements Locators {

	
		@FindBy(xpath=username)
		WebElement Username;
			
		@FindBy(xpath=password)
		WebElement Password;

		@FindBy(xpath=signin)
		WebElement Signin;

		public LoginPage() {

		PageFactory.initElements(driver, this);	
		}

		public Dashboard loginfunction(String ddt_username, String ddt_password) throws InterruptedException
		{
			CommonMethods.sendkeysss(Username, ddt_username);
			CommonMethods.sendkeysss(Password, ddt_password);
			CommonMethods.onClick(Signin);
				Thread.sleep(10000);
			return new Dashboard();
			
		}
	}


