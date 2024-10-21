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
import pages.Complete_Page;
import pages.Inventory_Page;
import pages.Login_Page;
import utility.ReadData;
import utility.ScreenShot;

public class Complete_Page_Test extends TestBase
{
	Login_Page Login;
	Inventory_Page Inventory;
	Cart_Page Cart;
	Checkout_StepOne_Page Checkout1;
	Checkout_StepTwo_Page Checkout_Overview;
	Complete_Page Complete;
	
	@BeforeMethod
	public void Setup() throws IOException, InterruptedException
	{
		initialization();
		Login=new Login_Page();
		Inventory=new Inventory_Page();
		Cart=new Cart_Page();
		Checkout1=new Checkout_StepOne_Page();
		Checkout_Overview=new Checkout_StepTwo_Page();
		Complete=new Complete_Page();
		Login.LoginToApplication();
		Inventory.add6product();
		Inventory.clickOnCartlink();
		Cart.ClickOnCheckOutBtn();
		Checkout1.inputCredentials();
		Checkout_Overview.ClickFinishBtn();
	}
	@Test
	public void VerifyCompletePage_Title_Test() throws EncryptedDocumentException, IOException
	{
		String ExpTitle="Checkout: Complete!";
		String ActTitle=Complete.VerifyCompletePage_Title();
		Assert.assertEquals(ExpTitle, ActTitle);
		Reporter.log(ActTitle);
	}
	@Test
	public void VerifyImage_Test()
	{
		Boolean Image_Result=Complete.VerifyImage();
		Assert.assertEquals(true, Image_Result);
		Reporter.log("Image is Present "+Image_Result);
	}
	@Test
	public void VerifyThankyou_Test()
	{
		String ExpText="Thank you for your order!";
		String ActText=Complete.VerifyThankyou();
		Assert.assertEquals(ExpText, ActText);
		Reporter.log(ActText);
	}
	@Test
	public void VerifyDispatched_Test()
	{
		String ExpDisp="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String ActDisp=Complete.VerifyDispatched();
		Assert.assertEquals(ExpDisp, ActDisp);
		Reporter.log(ActDisp);
	}
	@Test
	public void ClickHomeBtn_Test() throws EncryptedDocumentException, IOException
	{
		String ExpURL=ReadData.ReadExcel(2, 0);//https://www.saucedemo.com/inventory.html
		String ActURL=Complete.ClickHomeBtn();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log(ActURL);
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
