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
import pages.Checkout_StepOne_Page;
import pages.Checkout_StepTwo_Page;
import pages.Inventory_Page;
import pages.Login_Page;
import utility.ReadData;
import utility.ScreenShot;

public class Checkout_StepTwo_Page_Test extends TestBase
{
	Login_Page Login;
	Inventory_Page Inventory;
	Cart_Page Cart;
	Checkout_StepOne_Page Checkout1;
	Checkout_StepTwo_Page Checkout_Overview;
	
	@BeforeMethod
	public void Setup() throws IOException, InterruptedException
	{
		initialization();
		Login=new Login_Page();
		Inventory=new Inventory_Page();
		Cart=new Cart_Page();
		Checkout1=new Checkout_StepOne_Page();
		Checkout_Overview=new Checkout_StepTwo_Page();
		Login.LoginToApplication();
		Inventory.add6product();
		Inventory.clickOnCartlink();
		Cart.ClickOnCheckOutBtn();
		Checkout1.inputCredentials();
	}
	@Test
	public void VerifyOvervievPageTitle_Test() throws EncryptedDocumentException, IOException
	{
		String ExpTitle=ReadData.ReadExcel(5, 2);//Checkout: Overview
		String ActTitle=Checkout_Overview.VerifyOvervievPageTitle();
		Assert.assertEquals(ExpTitle, ActTitle);
		Reporter.log(ActTitle);
	}
	@Test
	public void VerifyPaymentInfoLabel_Test() throws EncryptedDocumentException, IOException
	{
		String ExpPayInfo=ReadData.ReadExcel(6, 2);//Payment Information:
		String ActPayInfo=Checkout_Overview.VerifyPaymentInfoLabel();
		Assert.assertEquals(ExpPayInfo, ActPayInfo);
		Reporter.log(ActPayInfo);
	}
	@Test
	public void VerifySaucecardLabel_Test() throws EncryptedDocumentException, IOException
	{
		String ExpSauce=ReadData.ReadExcel(7, 2);//SauceCard #31337
		String ActSauce=Checkout_Overview.VerifySaucecardLabel();
		Assert.assertEquals(ExpSauce, ActSauce);
		Reporter.log(ActSauce);
	}
	@Test
	public void VerifyShippingInfoLabel_Test() throws EncryptedDocumentException, IOException
	{
		String ExpShippingInfo=ReadData.ReadExcel(8, 2);//Shipping Information:
		String ActShippingInfo=Checkout_Overview.VerifyShippingInfoLabel();
		Assert.assertEquals(ExpShippingInfo, ActShippingInfo);
		Reporter.log(ActShippingInfo);
	}
	@Test
	public void VerifyFreeDeliveryLabel_Test() throws EncryptedDocumentException, IOException
	{
		String ExpFreeDel=ReadData.ReadExcel(9, 2);//Free Pony Express Delivery!
		String ActFreeDel=Checkout_Overview.VerifyFreeDeliveryLabel();
		Assert.assertEquals(ExpFreeDel, ActFreeDel);
		Reporter.log(ActFreeDel);
	}
	@Test
	public void VerifyTotalPriceLabel_Test() throws EncryptedDocumentException, IOException
	{
		String ExpTotalPrice=ReadData.ReadExcel(10, 2);//Price Total
		String ActTotalPrice=Checkout_Overview.VerifyTotalPriceLabel();
		Assert.assertEquals(ExpTotalPrice, ActTotalPrice);
		Reporter.log(ActTotalPrice);
	}
	@Test
	public void VerifySubTotalLabel_Test()
	{
		Boolean Subtotal_Result=Checkout_Overview.VerifySubTotalLabel();
		Assert.assertEquals(true, Subtotal_Result);
		Reporter.log("Subtotal Is Present "+Subtotal_Result);;
	}
	@Test
	public void VerifyTaxLabel_Test()
	{
		Boolean TaxLabel_Result=Checkout_Overview.VerifyTaxLabel();
		Assert.assertEquals(true, TaxLabel_Result);
		Reporter.log("Tax Label is Present "+TaxLabel_Result);;
	}
	@Test
	public void TotalLabel_Test()
	{
		Boolean TotalLabel_Result=Checkout_Overview.TotalLabel();
		Assert.assertEquals(true, TotalLabel_Result);
		Reporter.log("Total Label is Present "+TotalLabel_Result);
		
	}
	@Test
	public void ClickFinishBtn_Test() throws EncryptedDocumentException, IOException
	{
		String ExpURL=ReadData.ReadExcel(12, 0);//https://www.saucedemo.com/checkout-complete.html
		String ActURL=Checkout_Overview.ClickFinishBtn();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log(ActURL);
	}
	@Test
	public void ClickCancelBtn_Test() throws EncryptedDocumentException, IOException
	{
		String ExpURL=ReadData.ReadExcel(2, 0);//https://www.saucedemo.com/inventory.html
		String ActURL=Checkout_Overview.ClickCancelBtn();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log(ActURL);
	}
	@Test
	public void VerifyImgGoBack2_Test()
	{
		boolean ImgGoBack2=Checkout_Overview.VerifyImgGoBack2();
		Assert.assertEquals(ImgGoBack2, true);
		Reporter.log("GoBack Image2 is Visible "+ImgGoBack2);
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
