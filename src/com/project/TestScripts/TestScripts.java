package com.project.TestScripts;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.project.utilities.DriverClass;

public class TestScripts extends DriverClass {
	
	@BeforeSuite
	public void init()
	{
		reporter=new ExtentHtmlReporter("./Reports/TestReport.html");
		extent= new ExtentReports();
		extent.attachReporter(reporter);
	}
	@BeforeTest
	public void launchBrow()
	{
		driver.get("https://www.google.com");
	}
	
	@Test
	
	
	
	
	
	
	@AfterTest
	public void flu()
	{
		extent.flush();
	}
	
	@AfterSuite
	public void AftS()
	{
		driver.quit();
	}
}