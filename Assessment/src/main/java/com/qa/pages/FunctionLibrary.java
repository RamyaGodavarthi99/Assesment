package com.qa.pages;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
public class FunctionLibrary extends TestBase 
{
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"/Data/TestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	public static void Login(String Username, String password)
	{
//		driver.get(ObjectRepository.URL);
//		Actions actions = new Actions(driver);
//		WebElement Login = driver.findElement(ObjectRepository.Login_button);
//		actions.moveToElement(Login).click().build().perform();
		driver.findElement(ObjectRepository.Email_input).sendKeys("atest@gmail.com");
		driver.findElement(ObjectRepository.password_input).sendKeys("123456");
		driver.findElement(ObjectRepository.Login_button2).click();			
		
	}
	
	public static Object[][] getTestData(String sheetName) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
	

}