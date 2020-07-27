package com.project.screens;

import com.aventstack.extentreports.Status;
import com.project.objects.GmailObj;
import com.project.utilities.DriverClass;

public class Gmail extends DriverClass {
	GmailObj objgm = new GmailObj();

	public void gmailTest() {
		test = extent.createTest("This is testing Gmail Functionality");
		driver.findElement(GmailObj.objGmail).click();
		test.log(Status.PASS, "Gmail Clicked");
		boolean res = driver.findElement(GmailObj.objGetMore).isDisplayed();
		if (res) {
			driver.findElement(GmailObj.objSignin).click();
			test.log(Status.PASS, "Sign-In Clicked");
		} else {
			test.log(Status.FAIL, "Required Text not present");
		}
	}
}
