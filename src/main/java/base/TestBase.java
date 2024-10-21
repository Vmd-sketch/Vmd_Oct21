package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Extent_Reports;
import utility.ReadData;

public class TestBase 
{
	public ExtentReports report=Extent_Reports.getreportInstance();//From Utility Extent_Reports
	public ExtentTest Logger;//global declaration
	public static WebDriver driver;//global declaration//crossbrowser compatibility
	public void initialization() throws IOException
	{
		String browser=ReadData.ReadPropertyFile("BROWSER");
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver();
			driver=new ChromeDriver();//typecasting
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver();
			driver=new EdgeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(ReadData.ReadPropertyFile("URL"));
	}
}//chrome driver
