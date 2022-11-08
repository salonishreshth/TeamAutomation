package com.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.DemoPage;

public class DemoTestCases extends BaseClass {
	 
	DemoPage objDemoPage;
	
	@Test
	 public void TestMethod(){
		 driver.get("https://www.google.com");
		 objDemoPage = new DemoPage(driver);
	 }
		

	  @Test
	  public void testMethod1() throws InterruptedException
	  {
		  objDemoPage.SearchBoxTextPage();
		  objDemoPage.submitData("Selenium");
		  
		  System.out.println(objDemoPage.getOutputData());
		  Thread.sleep(5000);
		 
	  	Assert.assertTrue(objDemoPage.getOutputData().contains("Selenium"));
	  //	Thread.sleep(5000);
	  } 
	  
	  @AfterTest
		public void closeBrowser() {
			closeAllDriver();
		}
}
