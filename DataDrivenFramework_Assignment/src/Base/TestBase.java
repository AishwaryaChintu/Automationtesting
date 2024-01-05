package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static Properties configprop;
	public static Properties objrepoprop;
	public static WebDriver driver;
	public static boolean isloggedin;
	public static Xls_Reader datatable;
	
	
	public static void doinitialization() throws IOException
	{
		if(driver==null)
		{
		FileInputStream fis= new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\DataDrivenFramework_Assignment\\src\\Configuration\\Config.properties");
	    configprop=new Properties();
		configprop.load(fis);
			
		FileInputStream objfis= new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\DataDrivenFramework_Assignment\\src\\Objectrepository\\Objectrepo.properties");
		 objrepoprop=new Properties();
		objrepoprop.load(objfis);
		
		
		
		String browserinfo=configprop.getProperty("browserName");
		System.out.println(browserinfo);
		switch(browserinfo)
		{
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "FireFox":
			driver=new FirefoxDriver();
			break;
		case "Edge":
			driver=new EdgeDriver();
			break;
	}
		datatable=new Xls_Reader("C:\\Users\\Admin\\eclipse-workspace\\DataDrivenFramework_Assignment\\src\\Input\\datatablesheet.xlsx");
	}
	}
	public static WebElement getobject(String xpathvalue)
	{
	return driver.findElement(By.xpath(objrepoprop.getProperty(xpathvalue)));
	}
	
}
