package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_StepTwo_Page extends TestBase
{
	//object Repository
	@FindBy(xpath = "//span[text()='Checkout: Overview']")private WebElement OverviewPageTitle;
	@FindBy(xpath = "//div[text()='Payment Information:']")private WebElement PaymentInfoLabel;
	@FindBy(xpath = "//div[contains(text(),'SauceCard #31337')]")private WebElement SaucecardLabel;
	@FindBy(xpath = "//div[contains(text(),'Shipping Information:')]")private WebElement ShippingInfoLabel;
	@FindBy(xpath = "//div[contains(text(),'Free Pony Express Delivery!')]")private WebElement FreeDeliveryLabel;
	@FindBy(xpath = "//div[contains(text(),'Price Total')]")private WebElement TotalPriceLabel;
	@FindBy(xpath = "//div[contains(text(),'Item total: $')]")private WebElement SubTotalLabel;
	@FindBy(xpath = "//div[contains(text(),'Tax: $')]")private WebElement TaxLabel;
	@FindBy(xpath = "//div[text()='Item total: $']")private WebElement TotalLabel;
	@FindBy(xpath = "//button[@name='finish']")private WebElement FinishBtn;
	@FindBy(xpath = "//button[@name='cancel']")private WebElement CancelBtn;
	
	@FindBy(xpath = "//img[@alt='Go back']")private WebElement ImgGoBack2;
	
	public Checkout_StepTwo_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyOvervievPageTitle()
	{
		return OverviewPageTitle.getText();
	}
	public String VerifyPaymentInfoLabel()
	{
		return PaymentInfoLabel.getText();
	}
	public String VerifySaucecardLabel()
	{
		return SaucecardLabel.getText();
	}
	public String VerifyShippingInfoLabel()
	{
		return ShippingInfoLabel.getText();
	}
	public String VerifyFreeDeliveryLabel()
	{
		return FreeDeliveryLabel.getText();
	}
	public String VerifyTotalPriceLabel()
	{
		return TotalPriceLabel.getText();
	}
	public Boolean VerifySubTotalLabel()
	{
		return SubTotalLabel.isDisplayed();
	}
	public Boolean VerifyTaxLabel()
	{
		return TaxLabel.isDisplayed();
	}
	public Boolean TotalLabel()
	{
		return TotalLabel.isDisplayed();
	}
	public String ClickFinishBtn()
	{
		FinishBtn.click();
		return driver.getCurrentUrl();//https://www.saucedemo.com/checkout-complete.html
	}
	public boolean VerifyImgGoBack2()
	{
		return ImgGoBack2.isDisplayed();
	}
	public String ClickCancelBtn()
	{
		CancelBtn.click();
		return driver.getCurrentUrl();//https://www.saucedemo.com/inventory.html
	}
}

