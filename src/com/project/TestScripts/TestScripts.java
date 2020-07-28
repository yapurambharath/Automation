package com.project.TestScripts;
import java.io.IOException;

import org.apache.commons.collections4.functors.ChainedClosure;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.project.screens.Gmail;
import com.project.screens.Google;
import com.project.utilities.DriverClass;

public class TestScripts extends DriverClass {
	Gmail objGM=new Gmail();
	Google objGO=new Google();
	
	@BeforeSuite
	public void init()
	{
		reporter=new ExtentHtmlReporter("./RunReports/TestReport.html");
		extent= new ExtentReports();
		extent.attachReporter(reporter);
	}
	@BeforeTest
	public void launchBrow()
	{
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		
	}
	
	@Test
	public void gmailTesting()
	{
		objGM.gmailTest();
	}
	
	@Test
	public void ImageTesting() throws IOException
	{
		objGO.imageTest();
	}
	
	@AfterTest
	public void flu()
	{
		driver.quit();
		extent.flush();
	}
	
	@AfterSuite
	public void AftS()
	{
		//driver.quit();
	}
}