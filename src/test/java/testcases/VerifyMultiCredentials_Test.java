package testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.Login_Page;
import utility.ScreenShot;

public class VerifyMultiCredentials_Test extends TestBase
{
	Login_Page Login;
	@BeforeMethod(alwaysRun = true)
	public void Setup() throws IOException
	{
		initialization();
		Login=new Login_Page();	
	}
	@DataProvider(name="Validation")
	public Object[][] getdata()
	{
		return new Object[][]
				{
				{"standard_user","secret_sauce"},
				//{"locked_out_user","secret_sauce"},
				{"problem_user","secret_sauce"},
				{"performance_glitch_user","secret_sauce"},
				{"error_user","secret_sauce"},
				{"visual_user","secret_sauce"}
				};	
	}
	@Test(dataProvider = "Validation")
	public void VerifyMultiCredentials_Test(String UserName,String Password)
	{
		SoftAssert S=new SoftAssert();
		String ExpURL="https://www.saucedemo.com/inventory.html";
		String ActURL=Login.VerifyMultiCredentials(UserName, Password);
		S.assertEquals(ExpURL, ActURL);
		S.assertAll();
	}
	@AfterMethod(alwaysRun = true)
	public void Closebrowser(ITestResult it ) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			ScreenShot.ScreenSc(it.getName());
		}
		driver.close();
	}
}
