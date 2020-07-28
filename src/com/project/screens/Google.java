package com.project.screens;

import java.io.IOException;

import org.openqa.selenium.Keys;

import com.aventstack.extentreports.Status;
import com.project.objects.GooObj;
import com.project.utilities.CommonMethods;
import com.project.utilities.DriverClass;

public class Google extends DriverClass{
	CommonMethods objCM=new CommonMethods();
	public void imageTest() throws IOException
	{
		test=extent.createTest("This is testing Images");
		driver.findElement(GooObj.objImg).click();
		driver.findElement(GooObj.objSearch).sendKeys("AC Brotherhood");
		driver.switchTo().activeElement().sendKeys(Keys.ENTER);
		String url=driver.getCurrentUrl();
		if(url.toLowerCase().contains("brotherhood"))
		{
			test.log(Status.PASS, "Images are displayed Successfully");
			driver.navigate().to("https://www.google.com");
			objCM.takeScreenshot("images");
		}
		else
		{
			test.log(Status.FAIL, "Images not displayed");
		}
	}
}
