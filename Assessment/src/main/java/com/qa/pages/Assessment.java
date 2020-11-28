package com.qa.pages;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Assessment extends TestBase {
	static ExtentTest test;
	static ExtentReports report;
	@BeforeClass
	public static void startTest()
	{
	report = new ExtentReports("ExtentReportResults.html",true);
	test = report.startTest("Planit assessment");
	
	}
	@Test(dataProvider="TestData")
	public void Test(String UserName,String Password,String Quantity,String Company,String Country,String City,String Address1,String Address2,
			String Zip,String Phone,String Fax,String ShhippingAddress) throws InterruptedException {					
		
		try
			{		
			
			//////////////Driver initialization////////////////////		
				initialization();
				test.log(LogStatus.PASS, "Verify user is able to launch the given URL","Verification Success");
			/////////Validating WelCome message////////////
				driver.get(ObjectRepository.URL);
				Actions actions = new Actions(driver);
				WebElement Login = driver.findElement(ObjectRepository.Login_button);
				actions.moveToElement(Login).click().build().perform();				
				boolean welcome= driver.findElement(ObjectRepository.Welcome_Message).isDisplayed();
				if(welcome==true)
				{
					test.log(LogStatus.PASS, "Verify Welcome messgae is displayed","Verification Success");
				}
				else
				{
					test.log(LogStatus.FAIL, "Verify Welcome messgae is displayed","Verification failed");
				}
				
			/////////////Login function////////////////////
				FunctionLibrary.Login(UserName, Password);
				test.log(LogStatus.PASS, "Verify user is able to login with the given data","Verification Success");
				
			////////////Validating Account details//////////
				driver.findElement(ObjectRepository.user_Account).click();
				String Firstname = driver.findElement(ObjectRepository.Firstname_value).getAttribute("value");
				if(Firstname.equalsIgnoreCase("atest"))
				{
					test.log(LogStatus.PASS, "Verify First name is atest","Verification Success");
				}
				else
				{
					test.log(LogStatus.FAIL, "Verify First name is atest","Verification Failed");
				}
				
				String Lastname = driver.findElement(ObjectRepository.Lastname_value).getAttribute("value");
				if(Lastname.equalsIgnoreCase("dummy"))
				{
					
					test.log(LogStatus.PASS, "Verify Last name is dummy","Verification Success");
				}
				else
				{
					test.log(LogStatus.FAIL, "Verify Last name is dummy","Verification Failed");
				}
				String Email = driver.findElement(ObjectRepository.Email_value).getAttribute("value");
				if(Email.equalsIgnoreCase("atest@gmail.com"))
				{
					test.log(LogStatus.PASS, "Verify Email in the account is atest@gmail.com","Verification Success");
				}
				else
				{
					test.log(LogStatus.FAIL, "Verify Last name is dummy","Verification Failed");
				}
				
				//////////Emptying cart////////////////////
				WebElement shoppingCart = driver.findElement(ObjectRepository.ShoppingCart);
				actions.moveToElement(shoppingCart).click().build().perform();				
				List<WebElement> lst = driver.findElements(ObjectRepository.CartEmpty_messgae);
				if(lst.size()>0)
				{
					test.log(LogStatus.PASS, "Verify cart is  Empty","Verification Success");				
				}
				else
				{	test.log(LogStatus.INFO, "Verify cart is  Empty","Verification failed");
					driver.findElement(ObjectRepository.Cart_value).clear();
					driver.findElement(ObjectRepository.Cart_value).sendKeys("0");
					driver.findElement(ObjectRepository.Cart_value).sendKeys(Keys.ENTER);
					boolean EmptyMessage = driver.findElement(ObjectRepository.CartEmpty_messgae).isDisplayed();
					if(EmptyMessage==true)
					{
						test.log(LogStatus.PASS, "Verify user is able to remove the items in Cart","Verification Success");
					}
				}
				//////////////////Adding Book to cart/////////////////////////
				driver.findElement(ObjectRepository.Books_Menu).click();
				test.log(LogStatus.INFO, "Verify user is able to click on the Books in the main menu bar","Verification Success");
				WebElement BookSelect = driver.findElement(ObjectRepository.Book_1);
				actions.moveToElement(BookSelect).click().build().perform();
				String price = driver.findElement(ObjectRepository.Bookprice_value).getText();
				test.log(LogStatus.INFO, "Verify user is able toget the book price","Verification Success and price of the book is"+price);	
				driver.findElement(ObjectRepository.QTY_input).clear();
				driver.findElement(ObjectRepository.QTY_input).sendKeys(Quantity);
				driver.findElement(ObjectRepository.book1_AddtoCart).click();
				test.log(LogStatus.PASS, "Verify user is enter quantity(more than one) and able to click on Add to cart","Verification Success");
				boolean msg = driver.findElement(ObjectRepository.SuccessMsg).isDisplayed();
				if(msg=true)
				{
					test.log(LogStatus.PASS, "Verify Success message is disaplyed on clicking Add to cart","Verification Success");
				}
				else
				{
					test.log(LogStatus.FAIL, "Verify Success message is disaplyed on clicking Add to cart","Verification Failed");
				}
				Thread.sleep(5000);
				//// Converting string values of price and quantity into float//////
				WebElement ShoppingCart = driver.findElement(ObjectRepository.ShoppingCart);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);",ShoppingCart);				
				actions.moveToElement(ShoppingCart).click().build().perform();
				float P=Float.parseFloat(price);
				float Q = Float.parseFloat(Quantity);
				float Subtotal = P*Q;
				
				//////////////////Verifying subtotal AMount////////////
				String STotal = driver.findElement(ObjectRepository.Subtotal_value).getText();
				float S=Float.parseFloat(STotal);
				if(S==Subtotal)
				{
					test.log(LogStatus.PASS, "Verify Subtotal is multiplicaton of price and quantity","Verification Success");
				}
				else
				{
					test.log(LogStatus.PASS, "Verify Subtotal is multiplicaton of price and quantity","Verification Success");
				}
				
				driver.findElement(ObjectRepository.TandC).click();
				driver.findElement(ObjectRepository.CheckOut).click();
				test.log(LogStatus.INFO, "Select Terms and conditions and click on check out","Action Success");
				WebElement element = driver.findElement(ObjectRepository.Dropdown);
				
				/////////////////Selecting billing address and entering new address//////////////
				Select dropdown = new Select(element);				
				dropdown.selectByVisibleText("New Address");
				WebElement ele = driver.findElement(ObjectRepository.NewAddress_Country);
				Select country1 = new Select(ele);
				country1.selectByVisibleText(Country);
				driver.findElement(ObjectRepository.NewAddress_City).sendKeys(City);
				driver.findElement(ObjectRepository.NewAddress_Address1).sendKeys(Address1);
				driver.findElement(ObjectRepository.NewAddress_Address2).sendKeys(Address2);
				driver.findElement(ObjectRepository.NewAddress_Zipcode).sendKeys(Zip);
				driver.findElement(ObjectRepository.NewAddress_PhoneNum).sendKeys(Phone);			
				driver.findElement(ObjectRepository.NewAddress_FaxNum).sendKeys(Fax);
				driver.findElement(ObjectRepository.Continue).click();
				test.log(LogStatus.PASS, "Verify user is able to select New address from billing address dropdown and able to enter address in the screen ","Verification Success");
				//////////////////Selecting Shipping address as billing address////////////
				WebElement ele1 = driver.findElement(ObjectRepository.ShippingAddress_picklist);
				Select ShippingAddress = new Select(ele1);
				ShippingAddress.selectByVisibleText(ShhippingAddress);
				driver.findElement(ObjectRepository.Continue_1).click();
				test.log(LogStatus.PASS, "Verify user is able to select shipping address as Billing address and click on continue","Verification Success");
				/////////////////Selecting next day delivery and clicking continue////////////
				driver.findElement(ObjectRepository.NextDay_radioButton).click();
				driver.findElement(ObjectRepository.Continue_2).click();
				test.log(LogStatus.PASS, "Verify user is able to select next day delivery button and click on continue","Verification Success");
				/////////////Selecting COD and clicking on confirmation///////////				
				driver.findElement(ObjectRepository.COD_radiobutton).click();
				driver.findElement(ObjectRepository.Continue_3).click();
				test.log(LogStatus.PASS, "Verify user is able to select COD option and click on continue","Verification Success");
				boolean CODMsg = driver.findElement(ObjectRepository.COD_message).isDisplayed();
				if(CODMsg==true)
				{
					test.log(LogStatus.PASS, "Verify success message is getting displayed on selecting COD","Verification Success");
					
				}	
				else
				{
					test.log(LogStatus.FAIL, "Verify success message is getting displayed on selecting COD","Verification Failed");

				}
				driver.findElement(ObjectRepository.Continue_4).click();
				driver.findElement(ObjectRepository.Confirm).click();
				boolean orderConfirmation_msg = driver.findElement(ObjectRepository.Order_Successmsg).isDisplayed();
				if(orderConfirmation_msg==true)
				{					
					test.log(LogStatus.PASS, "Verify order confirmation message is displayed","Verification Success");

				}
				else
				{
					test.log(LogStatus.PASS, "Verify order confirmation message is displayed","Verification Success");
				}
				///////////printing Order number////////////
				String OrderNum = driver.findElement(ObjectRepository.OrderNumber_text).getText();
				String order[] = OrderNum.split(":");
				test.log(LogStatus.PASS, "Verify user is able to print order number","Verification Success and order number is  "+order[1]);
				driver.findElement(ObjectRepository.Continue_lastscreen).click();
				driver.findElement(ObjectRepository.Logout_Button).click();
				test.log(LogStatus.PASS, "Verify user is able to logout from the application","Verification Success");				
				driver.quit();
	
	}
			catch(Exception e)
			{		
				e.fillInStackTrace();
			}
	}
	
	@DataProvider(name="TestData")
	public Object[][] excelData() throws InvalidFormatException{
		
		Object[][] data=FunctionLibrary.getTestData("Sheet1");
		return data;	
	}
	@AfterClass
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}
	}