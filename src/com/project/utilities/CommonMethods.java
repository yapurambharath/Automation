package com.project.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CommonMethods extends DriverClass {

	public void takeScreenshot(String fName) throws IOException
	{
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src=tk.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+fName+".jpg");
		FileUtils.copyFile(src, dest);
	}
	
}
