package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.Inventory_Page;
import pages.Login_Page;
import utility.ReadData;
import utility.ScreenShot;

public class Cart_page_Test extends TestBase
{
	Login_Page Login;
	Inventory_Page Inventory;
	Cart_Page Cart;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
	initialization();
	Login=new Login_Page();
	Inventory=new Inventory_Page();
	Cart=new Cart_Page();
	Login.LoginToApplication();
	Inventory.add6product();
	Inventory.clickOnCartlink();
	}
	@Test
	public void VerifyCartPageUrl_Test()
	{
		String ExpURL="https://www.saucedemo.com/cart.html";
		String ActURL=Cart.VerifyCartPageURL();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log(ActURL);
	}
	@Test
	public void verifyPageTitle_Test() throws EncryptedDocumentException, IOException
	{
		String ExpTitle=ReadData.ReadExcel(13, 0);//Your Cart
		String ActTitle=Cart.verifyPageTitle();
		Assert.assertEquals(ExpTitle, ActTitle);
		Reporter.log(ActTitle);
	}
	@Test
	public void VerifyDescription_Test()
	{
		Boolean Description_Result=Cart.VerifyDescription();
		Assert.assertEquals(true, Description_Result);
		Reporter.log("description is present "+ Description_Result);
	}
	@Test
	public void VerifyQTY_Test()
	{
		Boolean QTY_Result=Cart.VerifyQTY();
		Assert.assertEquals(true, QTY_Result);
		Reporter.log("QTY is present "+QTY_Result);
	}
	@Test
	public void VerifyCartBackpack_Test() throws EncryptedDocumentException, IOException
	{
		String ExpBackpackResult=ReadData.ReadExcel(1, 3);//Sauce Labs Backpack
		String ActBackpackResult=Cart.VerifyCartBackpack();
		Assert.assertEquals(ExpBackpackResult, ActBackpackResult);
		Reporter.log(ActBackpackResult);
	}
	@Test
	public void clickonCheckoutBtn_Test() throws EncryptedDocumentException, IOException
	{
		String ExpURL=ReadData.ReadExcel(3, 2);//https://www.saucedemo.com/checkout-step-one.html
		String ActURL=Cart.ClickOnCheckOutBtn();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log(ActURL);
	}
	@Test
	public void ClickonContinueBtn_Test() throws EncryptedDocumentException, IOException
	{
		String ExpURL=ReadData.ReadExcel(2, 0);//https://www.saucedemo.com/inventory.html
		String ActURL=Cart.ClickonContinueBtn();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log(ActURL);
	}
	@Test
	public void VerifyRemoveBtn_Test()
	{
		String ExpRemove_Result="Remove";
		String ActRemove_Result=Cart.VerifyRemoveBtn();
		Assert.assertEquals(ExpRemove_Result, ActRemove_Result);
		Reporter.log(ActRemove_Result);
	}
	@Test
	public void VerifyImgGoBack_Test()
	{
		boolean Img_Result=Cart.VerifyImgGoBack();
		Assert.assertEquals(Img_Result, true);
		Reporter.log("GoBack Image is Present"+Img_Result);
	}
	@AfterMethod
	public void CloseBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			ScreenShot.ScreenSc(it.getName());
		}
		driver.close();
	}

}
