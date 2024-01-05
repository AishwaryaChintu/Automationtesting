package Utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;
import Base.Xls_Reader;

public class Testutils extends TestBase {
	public static void dologin(String mobilenumberdata,String passworddata )
	{
			WebElement helloobj=getobject("Hello");
			helloobj.click();
			WebElement signinobj=getobject("Signin");
			signinobj.click();
			WebElement mobilenum=getobject("Mobilenumber");
			mobilenum.sendKeys(mobilenumberdata);
			WebElement cont=getobject("Continue");
			cont.click();
			WebElement Password=getobject("Password");
			Password.sendKeys(passworddata);
			WebElement signinsubmit=getobject("Signinsubmit");
			signinsubmit.click();
			
	}
	public static boolean isskip(String Inputtestcase )
	{
		
		for(int rownum=2;rownum<=datatable.getRowCount("Suites");rownum++)
		{
			if(datatable.getCellData("Suites",0,rownum).equals(Inputtestcase))
			{
				if(datatable.getCellData("Suites",2,rownum).equals("Y"))
				{
				//System.out.println("run the testcase");
					return true;
				}
				else
				{
					//System.out.println("skip the testcase");
					return false;
				}
			}
	}
	return false;
	}
	public static String[][] getdata(String testdatasheet)
	{
		datatable=new Xls_Reader("C:\\Users\\Admin\\eclipse-workspace\\DataDrivenFramework_Assignment\\src\\Input\\datatablesheet.xlsx");
		int rowcount=datatable.getRowCount(testdatasheet);
		int colcount=datatable.getColumnCount(testdatasheet);
		System.out.println("number of rows is "+ rowcount);
		System.out.println("number of cols is" + colcount);
		String data[][]=new String [rowcount-1][colcount];
		for(int rownum=2; rownum<=rowcount; rownum++)
		{
			for( int colnum=0; colnum<colcount; colnum++)
			{
				data[rownum-2][colnum]=datatable.getCellData(testdatasheet, colnum, rownum);
			}
		}
	return data;
	}
	public static void getscreenshot(String filename) throws IOException
	{
		File sourcefile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//get the screenshot of the page and stores in the file
		FileHandler.copy(sourcefile,new File("C:\\Users\\Admin\\eclipse-workspace\\DataDrivenFramework_Assignment\\src\\Output\\"+filename+".png"));
	}
	
}
