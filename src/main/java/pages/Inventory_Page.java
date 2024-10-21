package pages;

import javax.xml.xpath.XPath;

import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropDownList;

public class Inventory_Page extends TestBase
{
	//object Repository
	
	//Product Name
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")private WebElement Product1;
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Bike Light')]")private WebElement Product2;
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Bolt T-Shirt')]")private WebElement Product3;
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Fleece Jacket')]")private WebElement Product4;
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Onesie')]")private WebElement Product5;
	@FindBy(xpath = "//div[text()='Test.allTheThings() T-Shirt (Red)']")private WebElement Product6;
	
	//Product Image
	@FindBy(xpath = "//img[@alt='Sauce Labs Backpack']")private WebElement ImgProduct1;
	@FindBy(xpath = "//img[@alt='Sauce Labs Bike Light']")private WebElement ImgProduct2;
	@FindBy(xpath = "//img[@alt='Sauce Labs Bolt T-Shirt']")private WebElement ImgProduct3;
	@FindBy(xpath = "//img[@alt='Sauce Labs Fleece Jacket']")private WebElement ImgProduct4;
	@FindBy(xpath = "//img[@alt='Sauce Labs Onesie']")private WebElement ImgProduct5;
	@FindBy(xpath = "//img[@alt='Test.allTheThings() T-Shirt (Red)']")private WebElement ImgProduct6;
	
	
	//Adding products Buttons
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-backpack']") private WebElement productBackpack;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bike-light']") private WebElement ProductBikeLight; 
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement productBoltTshirt;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-fleece-jacket']") private WebElement productFleeceJacket;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-onesie']") private WebElement productlabsonesie;
	@FindBy(xpath = "//button[@name='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement productTestallThings;
	@FindBy(xpath = "//span[text()='Products']") private WebElement Title;
	
	//Product description
	@FindBy(xpath = "//div[contains(text(),'carry.allTheThings() with the sleek')]")private WebElement BackpackDesc;
	@FindBy(xpath = "//div[contains(text(),'AAA ')]")private WebElement BikelightDesc;
	@FindBy(xpath = "//div[contains(text(),'superhero ')]")private WebElement BolttshirtDesc;
	@FindBy(xpath = "//div[contains(text(),'fleece jacket capable')]")private WebElement FleecejacketDesc;
	@FindBy(xpath = "//div[contains(text(),'Reinforced 3-snap bottom closure')]")private WebElement LabsonDesc;
	@FindBy(xpath = "//div[contains(text(),'Super-soft and comfy')]")private WebElement TestallDesc;
	
	
	//Logo
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement FacebookLogo;
	@FindBy(xpath = "//a[@data-test='social-linkedin']")private WebElement LinkedInLogo;
	@FindBy(xpath = "//a[@data-test='social-twitter']")private WebElement TwitterLogo;
	
	//MenuList
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")private WebElement MenuBtn;
	@FindBy(xpath = "//nav[@class='bm-item-list']/a")private WebElement MenuItemList;
	@FindBy(xpath = "//a[text()='All Items']")private WebElement AllItems;
	@FindBy(xpath = "//button[text()='Close Menu']")private WebElement CloseMenuBtn;
	@FindBy(xpath = "//a[@href=\"https://saucelabs.com/\"]']")private WebElement AboutLink;
	@FindBy(xpath = "//div[@class='bm-menu-wrap']/div")private WebElement Menuwrap;
	
	
	//DropDown
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement Dropdown;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement CartIconLink;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement CartCount;
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement Footer;
	
	//Removing From Cart
	@FindBy(xpath = "//button[@name='remove-sauce-labs-backpack']") private WebElement RemoveBackpack;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-bike-light']") private WebElement RemoveBikelight;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-bolt-t-shirt']") private WebElement RemoveBoltTshirt;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-fleece-jacket']") private WebElement RemoveFleeceJacket;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-onesie']") private WebElement RemoveLabsonesie;
	@FindBy(xpath = "//button[@name='remove-test.allthethings()-t-shirt-(red)']") private WebElement RemoveTestallThings;
	
	
	
	//constructor
	public Inventory_Page()
	{
		PageFactory.initElements(driver, this);
	}
	//Methods
	//PageTitle----------
	public String verifypagetitle()
	{
		return Title.getText();
	}
	//Name
	public String VerifyProd1()
	{
		return Product1.getText();
	}
	public String VerifyProd2()
	{
		return Product2.getText();
	}
	public  String VerifyProd3()
	{
		return Product3.getText();
	}
	public  String VerifyProd4()
	{
		return Product4.getText();
	}
	public  String VerifyProd5()
	{
		return Product5.getText();
	}
	public  String VerifyProd6()
	{
		return Product6.getText();
	}
	
	//Image---------------------------------------------------------
	public  boolean VerifyImgProd1()
	{
		return ImgProduct1.isDisplayed();
	}
	public  boolean VerifyImgProd2()
	{
		return ImgProduct2.isDisplayed();
	}
	public  boolean VerifyImgProd3()
	{
		return ImgProduct3.isDisplayed();
	}
	public  boolean VerifyImgProd4()
	{
		return ImgProduct4.isDisplayed();
	}
	public  boolean VerifyImgProd5()
	{
		return ImgProduct5.isDisplayed();
	}
	public  boolean VerifyImgProd6()
	{
		return ImgProduct6.isDisplayed();
	}
	//Product Description
	public String VerifyProd1Desc()
	{
		return BackpackDesc.getText();
	}
	public String VerifyProd2Desc()
	{
		return BikelightDesc.getText();
	}
	public String VerifyProd3Desc()
	{
		return BolttshirtDesc.getText();
	}
	public String VerifyProd4Desc()
	{
		return FleecejacketDesc.getText();
	}
	public String VerifyProd5Desc()
	{
		return LabsonDesc.getText();
	}
	public String VerifyProd6Desc()
	{
		return TestallDesc.getText();
	}
	
	
	//Logo---------------------
	public boolean verifyfacebooklogo()
	{
		return FacebookLogo.isDisplayed();
	}
	public boolean verifylinkedInLogo()
	{
		return LinkedInLogo.isDisplayed();
	}
	public boolean verifyTwitterLogo()
	{
		return TwitterLogo.isDisplayed();
	}
	public boolean verifyFooter()
	{
		return Footer.isDisplayed();
	}
	//Adding Method
	public String add6product() throws InterruptedException
	{
		HandleDropDownList.HandleSelect(Dropdown, "Price (low to high)");//webelement and value imported from utility handledropboxlist
		Thread.sleep(2000);
		productBackpack.click();
		ProductBikeLight.click();
		productBoltTshirt.click();
		productFleeceJacket.click();
		productlabsonesie.click();
		productTestallThings.click();
		
		return CartCount.getText();
	}
	//Removing Method
	public String Remove4products() throws InterruptedException
	{
		add6product();//First we have to add product to remove
		Thread.sleep(2000);
		RemoveBackpack.click();
		RemoveLabsonesie.click();
		RemoveBikelight.click();
		RemoveTestallThings.click();
		
		return CartCount.getText();
		
	}
	public void clickOnCartlink()
	{
		CartIconLink.click();
	}
	
}
