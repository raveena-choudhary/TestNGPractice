package com.automation.seleniumPractice;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.automation.seleniumPractice.util.ReadExcelFile;

public class practiceTestNGTest {

	@Test(dataProvider="getData", priority=1,groups = {"dataproviderTest", "functionalTest"},threadPoolSize=4)
	public void testDataProvider(String username,String password)
	{
		System.out.println("Username is"+ username);
		System.out.println("Password is"+ password);
	}
	
	@DataProvider
	public Object[][] getData() throws InvalidFormatException, IOException
	{
		/*
		 * Object data[][]=new Object[2][2];
		 * 
		 * data[0][0]="FirstUserName"; data[0][1]="PWD1";
		 * 
		 * data[1][0]="SecondUserName"; data[1][1]="PWD2";
		 * 
		 * return data;
		 */
		
		ReadExcelFile readData = new ReadExcelFile();
		return (readData.readDataFromExcel());
	}
	
	@Test(priority=0,groups = {"functionalTest"},enabled=true,timeOut=1)
	public void testPriority()
	{
		System.out.println("In priority Test");
		//throw new SkipException("This test is to check priority only");
	}
	
	@Test(expectedExceptions=ArithmeticException.class,groups = {"functionalTest"},invocationCount=2)
	public void testExpectedExceptions()
	{
		System.out.println(10/0);
	}
}