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
import pages.Inventory_Page;
import pages.Login_Page;
import utility.ReadData;
import utility.ScreenShot;

public class Inventory_Page_Test extends TestBase
{
	Login_Page login;
	Inventory_Page Inventory;
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException
	{
		initialization();
		login=new Login_Page();
		Inventory=new Inventory_Page();
		login.LoginToApplication();	
	}
	@Test(priority = 1,enabled = true,groups = "Automation")
	public void verifypagetitle_Test() throws EncryptedDocumentException, IOException
	{
		String ExpTitle=ReadData.ReadExcel(1, 2);//Products  -Parameterization
		String ActTitle=Inventory.verifypagetitle();
		Assert.assertEquals(ExpTitle, ActTitle);
		Reporter.log("Page Title"+ActTitle);
	}
	@Test(priority = 2,dependsOnMethods = "verifypagetitle_Test",groups = "Automation")
	public void verifyfacebooklogo_Test()
	{
		boolean Result = Inventory.verifyfacebooklogo();
		Assert.assertEquals(Result, true);
		Reporter.log("Facebook Logo Is Present"+Result);
	}
	@Test(priority = 3,groups = "Automation")
	public void verifylinkedInLogo_Test()
	{
		boolean Result=Inventory.verifylinkedInLogo();
		Assert.assertEquals(Result, true);
		Reporter.log("linkedIn Logo is Present"+Result);
	}
	@Test(groups = "Automation")
	public void verifyTwitterLogo_Test()
	{
		boolean Result =Inventory.verifyTwitterLogo();
		Assert.assertEquals(Result, true);
		Reporter.log("Twitter Logo is Present"+Result);
	}
	@Test(groups = "Automation")
	public void verifyFooter_Test()
	{
		boolean Footer_Result = Inventory.verifyFooter();
		Assert.assertEquals(Footer_Result, true);
		Reporter.log("Footer is Present"+Footer_Result);
	}
	@Test(groups = "Automation")
	public void add6product_Test() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String ExpCount=ReadData.ReadExcel(0, 1);//6  -Parameterization
		String ActCount=Inventory.add6product();
		Assert.assertEquals(ExpCount, ActCount);
		Reporter.log("Total Products Added "+ ActCount);
	}
	@Test(groups = "Manual")
	public void Remove4products_Test() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String ExpCount=ReadData.ReadExcel(4, 0);//2  -parameterization
		String ActCount=Inventory.Remove4products();
		Assert.assertEquals(ExpCount, ActCount);
		Reporter.log("Total Products in cart "+ActCount);
	}
	@Test(groups = "Manual")
	public void VerifyProd1_Test()
	{
		String ExpName="Sauce Labs Backpack";
		String ActName=Inventory.VerifyProd1();
		Assert.assertEquals(ExpName, ActName);
		Reporter.log(ActName);
	}
	@Test(groups = "Manual")
	public void VerifyProd2_Test()
	{
		String ExpName="Sauce Labs Bike Light";
		String ActName=Inventory.VerifyProd2();
		Assert.assertEquals(ExpName, ActName);
		Reporter.log(ActName);
	}
	@Test(groups = "Manual")
	public void VerifyProd3_Test()
	{
		String ExpName="Sauce Labs Bolt T-Shirt";
		String ActName=Inventory.VerifyProd3();
		Assert.assertEquals(ExpName, ActName);
		Reporter.log(ActName);
	}
	@Test
	public void VerifyProd4_Test()
	{
		String ExpName="Sauce Labs Fleece Jacket";
		String ActName=Inventory.VerifyProd4();
		Assert.assertEquals(ExpName, ActName);
		Reporter.log(ActName);
	}
	@Test
	public void VerifyProd5_Test()
	{
		String ExpName="Sauce Labs Onesie";
		String ActName=Inventory.VerifyProd5();
		Assert.assertEquals(ExpName, ActName);
		Reporter.log(ActName);
	}
	@Test
	public void VerifyProd6_Test()
	{
		String ExpName="Test.allTheThings() T-Shirt (Red)";
		String ActName=Inventory.VerifyProd6();
		Assert.assertEquals(ExpName, ActName);
		Reporter.log(ActName);
	}
	@Test
	public void VerifyImgProd1_Test()
	{
		boolean Img1=Inventory.VerifyImgProd1();
		Assert.assertEquals(Img1, true);
		Reporter.log("Image1 Is Present"+Img1);
	}
	@Test
	public void VerifyImgProd2_Test()
	{
		boolean Img2=Inventory.VerifyImgProd2();
		Assert.assertEquals(Img2, true);
		Reporter.log("Image2 Is Present"+Img2);
	}
	@Test
	public void VerifyImgProd3_Test()
	{
		boolean Img3=Inventory.VerifyImgProd3();
		Assert.assertEquals(Img3, true);
		Reporter.log("Image3 Is Present"+Img3);
	}
	@Test(priority = 1,dependsOnMethods = "verifypagetitle_Test")
	public void VerifyImgProd4_Test()
	{
		boolean Img4=Inventory.VerifyImgProd4();
		Assert.assertEquals(Img4, true);
		Reporter.log("Image4 Is Present"+Img4);
	}
	@Test
	public void VerifyImgProd5_Test()
	{
		boolean Img5=Inventory.VerifyImgProd5();
		Assert.assertEquals(Img5, true);
		Reporter.log("Image5 Is Present"+Img5);
	}
	@Test
	public void VerifyImgProd6_Test()
	{
		boolean Img6=Inventory.VerifyImgProd6();
		Assert.assertEquals(Img6, true);
		Reporter.log("Image6 Is Present"+Img6);
	}
	@Test
	public void VerifyProd1Desc_Test()
	{
		String ExpDesc="carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
		String ActDesc=Inventory.VerifyProd1Desc();
		Assert.assertEquals(ExpDesc, ActDesc);
		Reporter.log(ActDesc);
	}
	@Test
	public void VerifyProd2Desc_Test()
	{
		String ExpDesc="A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
		String ActDesc=Inventory.VerifyProd2Desc();
		Assert.assertEquals(ExpDesc, ActDesc);
		Reporter.log(ActDesc);
	}
	@Test
	public void VerifyProd3Desc_Test()
	{
		String ExpDesc="Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.";
		String ActDesc=Inventory.VerifyProd3Desc();
		Assert.assertEquals(ExpDesc, ActDesc);
		Reporter.log(ActDesc);
	}
	@Test
	public void VerifyProd4Desc_Test()
	{
		String ExpDesc="It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
		String ActDesc=Inventory.VerifyProd4Desc();
		Assert.assertEquals(ExpDesc, ActDesc);
		Reporter.log(ActDesc);
	}
	@Test
	public void VerifyProd5Desc_Test()
	{
		String ExpDesc="Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.";
		String ActDesc=Inventory.VerifyProd5Desc();
		Assert.assertEquals(ExpDesc, ActDesc);
		Reporter.log(ActDesc);
	}
	@Test(groups = "Manual")
	public void VerifyProd6Desc_Test()
	{
		String ExpDesc="This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.";
		String ActDesc=Inventory.VerifyProd6Desc();
		Assert.assertEquals(ExpDesc, ActDesc);
		Reporter.log(ActDesc);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closedriver(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			ScreenShot.ScreenSc(it.getName());
		}
		driver.close();
	}
}
