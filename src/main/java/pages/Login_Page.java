package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class Login_Page extends TestBase
{
	public String VerifyURLofApplication()
	{
		return driver.getCurrentUrl();
	}
	
	public String VerifyTitleofApplication()
	{
		return driver.getTitle();
	}
	//object Repository
	@FindBy(xpath ="//input[@id='user-name']") private WebElement UserTextBox;
	@FindBy(xpath ="//input[@id='password']") private WebElement PasswordTextBox;
	@FindBy(xpath ="//input[@id='login-button']") private WebElement LoginBtn;
	
	public Login_Page()//constuctor
	{
		PageFactory.initElements(driver, this);
	}
	public String LoginToApplication() throws IOException
	{
		Logger=report.createTest("Login Into Sauce Lab Application");
		UserTextBox.sendKeys(ReadData.ReadPropertyFile("USERNAME"));
		Logger.log(Status.INFO, "User Name Is Entered");
		PasswordTextBox.sendKeys("secret_sauce");
		Logger.log(Status.INFO, "Password is Entered");
		LoginBtn.click();
		Logger.log(Status.INFO, "Login Button is Clicked");
		Logger.log(Status.PASS, "Login Successful");
		return driver.getCurrentUrl();	
	}
	public String VerifyMultiCredentials(String UserName,String Password)
	{
		UserTextBox.sendKeys(UserName);
		PasswordTextBox.sendKeys(Password);
		LoginBtn.click();
		return driver.getCurrentUrl();
	}
	
	
}//Logic,Method,WebElement
