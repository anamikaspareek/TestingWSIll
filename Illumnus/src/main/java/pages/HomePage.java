package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import generic.CommonMethods;
import generic.Locators;

public class HomePage extends TestBase implements Locators
{
	@FindBy(xpath=teacher)
	WebElement Teacher;
 public HomePage()
 {
	PageFactory.initElements(driver, this);
}
 
 public LoginPage userSelector()
 {
	CommonMethods.onClick(Teacher);
	return new LoginPage();
}
 
}
