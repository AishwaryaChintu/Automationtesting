package Suites;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Base.TestBase;
import Utils.Testutils;
@RunWith(Parameterized.class)
public class HandlingLoginTestcase extends TestBase{
	String mobilenum;
	String Password;
	String datatype;
	public HandlingLoginTestcase(String mobnum ,String pass,String data)
	{
		mobilenum=mobnum;
		Password=pass;
		datatype=data;
	}
	
	@Parameters
	public static Collection<String[]>getdata()
	{
		
		String data[][]=Testutils.getdata("Logintestcase");
		
		
		return Arrays.asList(data);
		
	}
	
	@Before
	public void beforetest() throws IOException 
	{
	  doinitialization();
	  boolean runmode= Testutils.isskip("HandlingLoginTestcase");
		 if(runmode==false)
		 {
			 Assert.assertTrue(false);
		 }
	  
	}
       @Test
	public void verifylogintest() throws IOException
	{
          driver.get(configprop.getProperty("URL"));
              Testutils.dologin(mobilenum ,Password);
            /*  if(datatype.equals("Y")&isloggedin==true)
      		{
      			System.out.println("Login is successfull hence testcase is passed");
      		}
      		if(datatype.equals("Y")&isloggedin==false)	
      		{
      			
      		System.out.println("Login is not successfull for valid data hence testcase is failed & raise the defect");
      		Testutils.getscreenshot("login failure1");
      		}
      		if(datatype.equals("N")&isloggedin==true)
      		{
      			System.out.println("Login is successfull for invalid data hence testcase is failed & raise the defect");
      			Testutils.getscreenshot("login failure2");
      		}
      		if(datatype.equals("N")&isloggedin==false)
      		{
      			System.out.println("Login is not successfull for invalid data hence testcase is passed ");
      		}*/
         }

	
}
