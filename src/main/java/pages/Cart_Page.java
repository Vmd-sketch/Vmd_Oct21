package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_Page extends TestBase
{
	//object Repository
	@FindBy(xpath = "//span[text()='Your Cart']") private WebElement PageTitle;
	@FindBy(xpath = "//button[@class='btn btn_action btn_medium checkout_button ']")private WebElement CheckOutBtn;
	@FindBy(xpath = "//button[@name='continue-shopping']")private WebElement ContinueshoppingBtn;
	@FindBy(xpath = "//div[text()='Description']")private WebElement Description;
	@FindBy(xpath = "//div[text()='QTY']")private WebElement QTY;
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")private WebElement CartBackpack;
	@FindBy(xpath = "//div[text()='29.99']")private WebElement Price29;
	@FindBy(xpath = "//div[contains(text(),'allTheThings')]") private WebElement BackpackDetails;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-backpack']")private WebElement BackpackRemove;
	
	//Arrow
	@FindBy(xpath = "//img[@alt='Go back']")private WebElement ImgGoBack;
	
	public Cart_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public String VerifyCartPageURL()
	{
		return driver.getCurrentUrl();
	}
	public String verifyPageTitle()
	{
		return PageTitle.getText();
	}
	public boolean VerifyDescription()
	{
		return Description.isDisplayed();
	}
	public boolean VerifyQTY()
	{
		return QTY.isDisplayed();
	}
	public String VerifyCartBackpack()
	{
		return CartBackpack.getText();
	}
	public String ClickonContinueBtn()
	{
		ContinueshoppingBtn.click();
		return driver.getCurrentUrl();
	}
	public String VerifyPrice()
	{
		return Price29.getText();
	}
	public String VerifyItemDetail()
	{
		return BackpackDetails.getText();
	}
	public String VerifyRemoveBtn()
	{
		return BackpackRemove.getText();
	}
	public boolean VerifyImgGoBack()
	{
		return ImgGoBack.isDisplayed();
	}
	public String ClickOnCheckOutBtn()
	{
		CheckOutBtn.click();
		return driver.getCurrentUrl();
	}
}
	
	
	
	
