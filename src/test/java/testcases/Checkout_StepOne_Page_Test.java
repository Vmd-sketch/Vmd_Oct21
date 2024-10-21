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
import pages.Inventory_Page;
import pages.Login_Page;
import utility.ReadData;
import utility.ScreenShot;

public class Checkout_StepOne_Page_Test extends TestBase
{
	Login_Page Login;
	Inventory_Page Inventory;
	Cart_Page Cart;
	Checkout_StepOne_Page Checkout1;

@BeforeMethod
public void Setup() throws IOException, InterruptedException
{
	initialization();
	Login=new Login_Page();
	Inventory=new Inventory_Page();
	Cart =new Cart_Page();
	Checkout1=new Checkout_StepOne_Page();
	Login.LoginToApplication();
	Inventory.add6product();
	Inventory.clickOnCartlink();
	Cart.ClickOnCheckOutBtn();
	
}
@Test
public void  VerifyPageTitleCheckout_Test() throws EncryptedDocumentException, IOException
{
	String ExpTitle=ReadData.ReadExcel(4, 3);//Checkout: Your Information
	String ActTitle=Checkout1.VerifyPageTitleCheckout();
	Assert.assertEquals(ExpTitle, ActTitle);
	Reporter.log(ActTitle);
}
@Test
public void InputCredentials_Test() throws EncryptedDocumentException, IOException
{
	String ExpURL=ReadData.ReadExcel(11, 0);//https://www.saucedemo.com/checkout-step-two.html
	String ActURL=Checkout1.inputCredentials();
	Assert.assertEquals(ExpURL, ActURL);
	Reporter.log(ActURL);
}
@Test
public void VerifyImgGoBack_Test()
{
	boolean Img1_Result=Checkout1.VerifyImgGoBack();
	Assert.assertEquals(Img1_Result, true);
	Reporter.log("GoBack Image 1 is Present "+Img1_Result);
}
@Test(enabled = false)
public void VerifyError_Test()
{
	boolean Error_Result=Checkout1.VerifyError();
	Assert.assertEquals(Error_Result, true);
	Reporter.log("Error Message Detected"+Error_Result);
}
@Test(enabled = false)
public void VerifyErrorBtn_Test()
{
	boolean Error_Btn=Checkout1.VerifyErrorBtn();
	Assert.assertEquals(Error_Btn, true);
	Reporter.log("Error Button is Present "+Error_Btn);
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