package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods 
{
	public	static String TESTDATA_SHEET_PATH= "D:/testing/workspace//Illumnus/data_provider/logintestdata.xlsx";
	static Workbook book = null;
	static Sheet sheet;
	public static void sendkeysss(WebElement element, String value)
	{
		element.sendKeys(value);
	}

	public static void onClick(WebElement element)
	{
	element.click();	
	}

	public static void selection(WebElement element,WebDriver driver,String locator,String value)
	{
	element.click();
	List<WebElement> alloptions = driver.findElements(By.xpath(locator));
	for (WebElement all : alloptions)
	{
		String selectoption = all.getText();
		System.out.println(selectoption);
		if(selectoption.equalsIgnoreCase(value))
		{
			all.click();
			System.out.println(all.getText());
			break;
		}
	}

	}

	public static void Dropdownfunction(WebElement element,String value)
	{
	Select dropdown = new Select(element);	
	dropdown.selectByVisibleText(value);
	}
	 
	public static Object[][] getTestData(String sheetName)
	{
		
		FileInputStream file = null;
		
		try
		{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			book = WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		 sheet = book.getSheet(sheetName);
		 
		 Object [][] date = new Object[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getLastCellNum()];
		 
		 for(int i=0;i<sheet.getLastRowNum();i++)
		 {
			 for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			 {
				 try
				 {
					
				 date[i][k] =sheet.getRow(i+1).getCell(k).toString();
				 }
				 
				 catch (Exception e)
				 {
					e.printStackTrace();
				}
				 }
		 }
				return date;
	}

}
