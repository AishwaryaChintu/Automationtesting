package Suites;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Base.TestBase;
import Utils.Testutils;

public class HandlingContactus extends TestBase {
	@Before
	public void beforetest() throws Exception
	{
	  doinitialization();
	  boolean runmode= Testutils.isskip("HandlingContactus");
		 if(runmode==false)
		 {
			 Assert.assertTrue(false);
		 }
	}
	
	@Test
	public void contactus()
	{
		System.out.println("Verify contactus");
	}
	
}
