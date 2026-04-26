//comment removed
package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.time.Duration; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.TestUtil;

public class TestBase extends TestUtil
{
	public static WebDriver driver;
	public static Properties prop;
	 
	public static String name;
	public TestBase()
	{
	try
	{
	prop = new Properties();
	FileInputStream ip = new FileInputStream("../Illumnus/src/main/java/config/config.properties");
	prop.load(ip);
	}
	catch (FileNotFoundException e)
	{
	e.printStackTrace();
	}
	catch (IOException e)
	{
	e.printStackTrace();
	}
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "../Illumnus/drivers/chromedriver.exe");
			driver  = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); // Deprecated
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
	  //driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); // Deprecated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
	}

}
