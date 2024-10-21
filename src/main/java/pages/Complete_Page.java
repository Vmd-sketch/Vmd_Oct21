package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Complete_Page extends TestBase
{
	//object Repository
	@FindBy(xpath = "//span[@class='title']")private WebElement Complete_PageTitle;
	@FindBy(xpath = "//img[@class='pony_express']")private WebElement Image;
	@FindBy(xpath = "//h2[text()='Thank you for your order!']")private WebElement Thankyou;
	@FindBy(xpath = "//div[contains(text(),'Your order has been dispatched')]")private WebElement Dispatched;
	@FindBy(xpath = "//button[@class='btn btn_primary btn_small']")private WebElement HomeBtn;
	
	public Complete_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public String VerifyCompletePage_Title()
	{
		return Complete_PageTitle.getText();
	}
	public Boolean VerifyImage()
	{
		return Image.isDisplayed();
	}
	public String VerifyThankyou()
	{
		return Thankyou.getText();
	}
	public String VerifyDispatched()
	{
		return Dispatched.getText();
	}
	public String ClickHomeBtn()
	{
		HomeBtn.click();
		return driver.getCurrentUrl();//https://www.saucedemo.com/inventory.html
	}
}
