package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.databind.node.BooleanNode;

import base.TestBase;
import utility.ReadData;

public class Checkout_StepOne_Page extends TestBase
{
	//Object Repository
	@FindBy(xpath = "//input[@name='firstName']")private WebElement FirstNameTxtBox;
	@FindBy(xpath = "//input[@name='lastName']")private WebElement lastnameTxtBox;
	@FindBy(xpath = "//input[@name='postalCode']")private WebElement PostalcodeTxtBox;
	@FindBy(xpath = "//input[@name='continue']")private WebElement ContinueBtn;
	@FindBy(xpath = "//span[contains(text(),'Checkout: Your Information')]")private WebElement PageTitlecheckout;
	@FindBy(xpath = "//button[@name='cancel']")private WebElement cancelBtn;
	
	@FindBy(xpath = "//img[@alt='Go back']")private WebElement ImgGoBack1;
	//Error
	@FindBy(xpath = "//h3[@data-test='error']")private WebElement Error;
	@FindBy(xpath = "//button[@class='error-button']")private WebElement ErrorBtn;
	
	
	public Checkout_StepOne_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public String VerifyPageTitleCheckout()
	{
		return PageTitlecheckout.getText();
	}
	public boolean VerifyImgGoBack()
	{
		return ImgGoBack1.isDisplayed();
	}
	public Boolean VerifyError()
	{
		return Error.isDisplayed();
	}
	public boolean VerifyErrorBtn()
	{
		return ErrorBtn.isDisplayed();
	}
	public String inputCredentials() throws EncryptedDocumentException, IOException
	{
		FirstNameTxtBox.sendKeys(ReadData.ReadExcel(3, 1));//Vaibhav
		lastnameTxtBox.sendKeys(ReadData.ReadExcel(4, 1));//Dhandare
		PostalcodeTxtBox.sendKeys(ReadData.ReadExcel(4, 2));//411052
		ContinueBtn.click();
		return driver.getCurrentUrl();//Here we will get Step Two URL
		
	}
}
