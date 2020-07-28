package com.project.screens;

import java.io.IOException;

import org.openqa.selenium.Keys;

import com.aventstack.extentreports.Status;
import com.project.objects.GooObj;
import com.project.utilities.CommonMethods;
import com.project.utilities.DriverClass;
import com.project.utilities.ExcelUtil;

public class Google extends DriverClass {
	CommonMethods objCM = new CommonMethods();
	String xlFile = ".//TestData//TestData.xlsx";
	String xlSheet = "Games";

	public void imageTest() throws IOException {
		test = extent.createTest("This is testing Images");
		int n = ExcelUtil.rowCount(xlFile, xlSheet);
		for (int i = 1; i <= n; i++) {
			driver.findElement(GooObj.objImg).click();
			String value = ExcelUtil.getCellData(xlFile, xlSheet, i, 1);
			driver.findElement(GooObj.objSearch).sendKeys(value);
			driver.switchTo().activeElement().sendKeys(Keys.ENTER);
			String url = driver.getCurrentUrl();
			if (url.toLowerCase().contains("img")) {
				test.log(Status.PASS, "Images are displayed Successfully");
				objCM.takeScreenshot(value);
				driver.navigate().to("https://www.google.com");
				ExcelUtil.setCellData(xlFile, xlSheet, i, 2, "PASSED");
				if(value.toLowerCase().contains("prince"))
				{
					ExcelUtil.setCellData(xlFile, xlSheet, i, 2, "FAILED");
				}
			} else {
				test.log(Status.FAIL, "Images not displayed");
			}

		}

	}
}
