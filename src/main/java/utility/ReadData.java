package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData 
{
	public static String ReadPropertyFile(String value) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream File= new FileInputStream("F:\\ST QA\\5oct_Project_Selenium_Framework\\src\\main\\java\\config\\config.properties");
		prop.load(File);
		return prop.getProperty(value);
	}
	//To Read Excel File PARAMETERIZATION
	public static String ReadExcel(int rownum,int colnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream File=new FileInputStream("F:\\ST QA\\5oct_Project_Selenium_Framework\\TestData\\Book21.xlsx");//Excel file path
		Sheet Es = WorkbookFactory.create(File).getSheet("Sheet2");
		String Value = Es.getRow(rownum).getCell(colnum).getStringCellValue();
		
		return Value;
		
	}
}
