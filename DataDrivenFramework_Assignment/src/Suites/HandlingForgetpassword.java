package Suites;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Base.TestBase;
import Utils.Testutils;

public class HandlingForgetpassword extends TestBase{
	@Before
	public void beforetest() throws Exception
	{
	  doinitialization();
	  boolean runmode= Testutils.isskip("HandlingForgetpassword");
		 if(runmode==false)
		 {
			 Assert.assertTrue(false);
		 }
	}
	
	@Test
	public void forgetpassword()
	{
		System.out.println("Verify forgetpassword");
	}
}
