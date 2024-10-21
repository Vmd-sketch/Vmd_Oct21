package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class ScreenShot extends TestBase
{
	//Date
	public static String getDate()
	{
		return new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
	}
	//Screenshot Capture
	public static void ScreenSc(String nameofmethod) throws IOException
	{
		File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("F:\\ST QA\\5oct_Project_Selenium_Framework\\Screenshots\\"+nameofmethod+"--"+getDate()+".jpeg");
		FileHandler.copy(Source, Dest);
		
		
	}
}
