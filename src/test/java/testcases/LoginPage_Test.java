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
import pages.Login_Page;
import utility.ReadData;
import utility.ScreenShot;

public class LoginPage_Test extends TestBase
{
	Login_Page Login;//global object create of login Page
	
	@BeforeMethod(alwaysRun = true) //Annotation
	public void Setup() throws IOException//customized user input method
	{
		initialization();//calling method from testbase
		Login = new Login_Page();//typecasting
	}
	@Test(priority = 1,groups = "Automation")
	public void VerifyURLofApplicationtest()
	{
		String ExpURL="https://www.saucedemo.com/";
		String ActURL=Login.VerifyURLofApplication();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log(ActURL);
	}
	@Test(priority = 2,dependsOnMethods = "VerifyURLofApplicationtest",enabled = true,groups = "Automation")
	public void VerifyTitleofApplicationTest() throws EncryptedDocumentException, IOException
	{
		String ExpTitle=ReadData.ReadExcel(1, 0);//Swag Labs  -parametrization
		String ActTitle=Login.VerifyTitleofApplication();
		Assert.assertEquals(ExpTitle, ActTitle);
		Reporter.log(ActTitle);
	}
	@Test(priority = 3,dependsOnMethods = "VerifyURLofApplicationtest")
	public void LoginToApplicationTest() throws IOException
	{
		String ExpURL=ReadData.ReadExcel(2, 0);//https://www.saucedemo.com/inventory.html  -parameterization
		//String ExpURL=ReadData.ReadExcel(2, 2);//Making it fail for screenshot
		String ActURL=Login.LoginToApplication();
		Assert.assertEquals(ExpURL, ActURL);
		Reporter.log(ActURL);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			ScreenShot.ScreenSc(it.getName());
		}
		report.flush();
		driver.close();
	}

}
