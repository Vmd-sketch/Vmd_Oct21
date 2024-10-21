package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bouncycastle.asn1.dvcs.Data;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;
import freemarker.template.SimpleDate;

public class Extent_Reports extends TestBase
{
	static ExtentReports report;
	public static ExtentReports getreportInstance()
	{
		if(report==null)
		{
			String report_name=new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
			ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter("F:\\ST QA\\5oct_Project_Selenium_Framework\\ExtentReport"+report_name+".html");
			report=new ExtentReports();
			report.attachReporter(htmlreporter);
			report.setSystemInfo("OS", "Windows");
			report.setSystemInfo("Environment", "SIT");
			report.setSystemInfo("Build", "102.02.02.1234");
			report.setSystemInfo("Browser", "Chrome");
			htmlreporter.config().setDocumentTitle("UI Testing Documents");
			htmlreporter.config().setReportName("UI Test Reporter");
			
		}
		return report;
		
	}
}
