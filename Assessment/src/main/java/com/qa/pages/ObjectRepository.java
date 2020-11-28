package com.qa.pages;

import org.openqa.selenium.*;


public  class ObjectRepository {

	
	public static String URL = "http://demowebshop.tricentis.com/";
	public static  By Login_button=By.xpath("//a[text()='Log in']");
	public static By Welcome_Message = By.xpath("//h1[text()='Welcome, Please Sign In!']");
	public static By Email_input = By.xpath("//input[@name='Email']");
	public static By password_input = By.xpath("//input[@name='Password']");
	public static By Login_button2 = By.xpath("//label[text()='Remember me?']//parent::div//parent::form//div//input[@type='submit']");
	
	public static By user_Account = By.xpath("(//ul//li//a[@class='account'])[1]");
	public static By accountInfo_label = By.xpath("//h1[text()='My account - Customer info']");
	public static By Firstname_value = By.xpath("//input[@name='FirstName']");
	public static By Lastname_value = By.xpath("//input[@name='LastName']");
	public static By Email_value = By.xpath("//input[@name='Email']");
	public static By Cart_value= By.xpath("//input[@class='qty-input']");
	
	public static By ShoppingCart = By.xpath("//a//span[text()='Shopping cart']");
	public static By CartEmpty_messgae = By.xpath("//div[contains(text(),'Your Shopping Cart is empty!')]");
	public static By Books_Menu = By.xpath("//ul[@class='top-menu']//li//a[contains(text(),'Books')]");
	public static By Book_1 = By.xpath("(//div[@class='item-box'])[1]//div//div");
	public static By Bookprice_value = By.xpath("//span[@itemprop='price']");
	public static By QTY_input = By.xpath("//input[@data-val-number='The field Qty must be a number.']");
	public static By book1_AddtoCart = By.xpath("//input[@id='add-to-cart-button-13']");
	public static By SuccessMsg = By.xpath("//p[text()='The product has been added to your ']");
	
	public static By Subtotal_value =By.xpath("//table[@class='cart-total']//tr[1]//td[2]//span//span");
	public static By CheckOut = By.xpath("//button[@id='checkout']");
	public static By TandC = By.xpath("//input[@id='termsofservice']");
	
	public static By Dropdown = By.xpath("//select[@id='billing-address-select']");
	public static By NewAddress_CompanyName = By.xpath("//input[@id='BillingNewAddress_Company']");
	public static By NewAddress_Country = By.xpath("//select[@id='BillingNewAddress_CountryId']");
	public static By NewAddress_City = By.xpath("//input[@id='BillingNewAddress_City']");
	public static By NewAddress_Address1 = By.xpath("//input[@id='BillingNewAddress_Address1']");
	public static By NewAddress_Address2 = By.xpath("//input[@id='BillingNewAddress_Address2']");
	public static By NewAddress_Zipcode = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
	public static By NewAddress_PhoneNum = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
	public static By NewAddress_FaxNum = By.xpath("//input[@id='BillingNewAddress_FaxNumber']");
	
	
	public static By Continue =By.xpath("(//input[@title='Continue'])[1]");
	public static By ShippingAddress_picklist = By.xpath("//select[@id='shipping-address-select']");
	public static By Continue_1 = By.xpath("//input[@onclick='Shipping.save()']");
	public static By NextDay_radioButton = By.xpath("//label[contains(text(),'Next Day Air')]//preceding-sibling::input");
	public static By Continue_2 = By.xpath("//input[@onclick='ShippingMethod.save()']");
	public static By COD_radiobutton = By.xpath("//label[contains(text(),'Cash On Delivery (COD)')]//preceding-sibling::input");
	public static By Continue_3 = By.xpath("//input[@onclick='PaymentMethod.save()']");
	public static By COD_message = By.xpath("//p[text()='You will pay by COD']");
	public static By Continue_4 = By.xpath("//input[@onclick='PaymentInfo.save()']");
	public static By Confirm = By.xpath("//input[@onclick='ConfirmOrder.save()']");
	public static By Order_Successmsg = By.xpath("//strong[text()='Your order has been successfully processed!']");
	public static By OrderNumber_text = By.xpath("//ul//li[contains(text(),'Order number')]");
	public static By Continue_lastscreen = By.xpath("//input[@value='Continue']");
	public static By Logout_Button = By.xpath("//a[text()='Log out']");
	
	
	
	
}
